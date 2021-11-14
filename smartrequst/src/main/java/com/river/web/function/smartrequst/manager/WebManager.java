package com.river.web.function.smartrequst.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.river.web.function.smartrequst.model.WebClass;
import com.river.web.function.smartrequst.model.WebFunction;
import com.river.web.function.smartrequst.model.WebParameter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * @Author river66
 * @Date 2021/1/1 21:40
 */
public class WebManager {
    public static <T> JSONObject getWebResult(T t, String webJSONParam) {
        WebParameter webParameter = JSONObject.parseObject(webJSONParam, WebParameter.class);
        if (null == webJSONParam) {
            return null;
        }
        List<WebClass> webClassList = webParameter.getWebClassList();
        if (null == webClassList || webClassList.size() == 0) {
            return null;
        }
        Class<?> serviceClass = t.getClass();
        webClassList.forEach(webClass -> {
            String webClassName = webClass.getWebClassName();
            if (serviceClass.getSimpleName().equals(webClassName)) {
                List<WebFunction> webFunctions = webClass.getFunctionList();
                if (null != webFunctions && 0 < webFunctions.size()) {
                    Method[] methods = serviceClass.getMethods();
                    webFunctions.forEach(webFunction -> {
                        String functionName = webFunction.getFunctionName();
                        JSONObject functionParam = webFunction.getFunctionParam();
                        if (functionParam != null) {
                            for (Method method : methods) {
                                if (functionName != null && functionName.equals(method.getName())) {
                                    Object result = invoke(t, method, functionParam);
                                    webFunction.setFunctionJSONResult(JSONObject.toJSONString(result));
                                }
                            }
                        }
                    });
                }
            }
        });
        return JSON.parseObject(JSONObject.toJSONString(webParameter));
    }

    private static <T> Object invoke(T t, Method method, JSONObject param) {
        try {
            return method.invoke(t, getParams(param, method.getParameters()));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object[] getParams(JSONObject param, Parameter[] parameters) {
        int size = parameters.length;
        Object[] paramObjects = new Object[size];
        for (int i = 0; i < size; i++) {
            paramObjects[i] = param.get(parameters[i].getName());
        }
        return paramObjects;
    }
}
