package com.kuleshov.web;

import com.google.common.collect.ImmutableList;
import com.kuleshov.annotation.RequestMapping;
import com.kuleshov.annotation.RequestParam;
import com.kuleshov.controller.UserController;
import com.kuleshov.dao.UserDAO;
import com.kuleshov.exception.IllegalRequestException;
import com.kuleshov.service.UserService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

public class Dispatcher {
    private List<Controller> controllers;
    private Invoker invoker = new Invoker();
    private static Dispatcher dispatcher;

    private Dispatcher() {
        controllers = ImmutableList.<Controller>builder()
                .add(new UserController(new UserService(new UserDAO())))
                .build();
    }

    public static Dispatcher getInstance() {
        if (dispatcher == null) {
            dispatcher = new Dispatcher();
        }
        return dispatcher;
    }

    public ModelAndView dispatch(String url, String method, Map<String, String[]> parametersMap, HttpServletRequest req) {
        HttpMethod httpMethod = HttpMethod.valueOf(method);
        Target target = getTargetForInvoke(url, httpMethod);
        if (target != null) {
            fillTargetByParameters(target, parametersMap, req);

            Object result = invoker.invoke(target);
            return (ModelAndView) result;
        }
        return new ModelAndView(HttpStatus.PAGE_NOT_FOUND);
    }

    private void fillTargetByParameters(Target target, Map<String, String[]> stringParametersMap,
                                        HttpServletRequest req) {
        HashMap<String, Object> parametersMap = new HashMap<>();
        stringParametersMap.forEach((k, v) -> parametersMap.put(k, v[0]));
        parametersMap.put("request", req);

//        Arrays.stream(target.method.getParameters())
//                .map(e -> parametersMap.get(e.getName()))
//                .filter(Objects::nonNull)
//                .forEach(e -> target.params.add(e));

        Arrays.stream(target.method.getParameters())
                .filter(e -> e.getDeclaredAnnotation(RequestParam.class) != null)
                .map(e -> parametersMap.get(e.getDeclaredAnnotation(RequestParam.class).name()))
                .filter(Objects::nonNull)
                .forEach(e -> target.params.add(e));

    }

    private Target getTargetForInvoke(String requestedUrl, HttpMethod requestedHttpMethod) {
        Target target = null;

        for (Controller controller : controllers) {
            Method[] methods = controller.getClass().getMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping current = method.getAnnotation(RequestMapping.class);

                    if (requestedHttpMethod == current.method() && StringUtils.equals(requestedUrl, current.url())) {
                        target = new Target(controller, method);
                        break;
                    }
                }
            }
            if (target != null) {
                break;
            }
        }
        return target;
    }

    private static class Invoker {
        private Object invoke(Target target) {
            try {
                target.method.setAccessible(true);

                return target.method.invoke(target.controller, target.params.toArray());
            } catch (Exception e) {
                throw new IllegalRequestException(e.getMessage());
            }
        }
    }

    private static class Target {
        private Controller controller;
        private Method method;
        private List<Object> params = new ArrayList<>();

        Target(Controller controller, Method method) {
            this.controller = controller;
            this.method = method;
        }
    }
}
