package com.river.web.function.smartrequst.model;

import java.util.List;

/**
 * @Author river66
 * @Date 2021/1/1 16:08
 */
public class WebClass {
    private List<WebFunction> functionList;
    private String webClassName;

    public String getWebClassName() {
        return webClassName;
    }

    public void setWebClassName(String webClassName) {
        this.webClassName = webClassName;
    }

    public List<WebFunction> getFunctionList() {
        return functionList;
    }

    public void setFunctionList(List<WebFunction> functionList) {
        this.functionList = functionList;
    }
}
