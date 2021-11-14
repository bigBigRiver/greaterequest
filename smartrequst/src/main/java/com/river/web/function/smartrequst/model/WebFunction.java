package com.river.web.function.smartrequst.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author river66
 * @Date 2021/1/1 16:29
 */
public class WebFunction {
    private String functionName;
    private JSONObject functionParam;
    private String functionJSONResult;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public JSONObject getFunctionParam() {
        return functionParam;
    }

    public void setFunctionParam(JSONObject functionParam) {
        this.functionParam = functionParam;
    }

    public String getFunctionJSONResult() {
        return functionJSONResult;
    }

    public void setFunctionJSONResult(String functionJSONResult) {
        this.functionJSONResult = functionJSONResult;
    }
}
