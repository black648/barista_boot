package org.barista.framework.utils;

public class APIResult {
    private int resultCode;
    private String resultMsg;
    private Object resultData;

    public APIResult() {
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultData() {
        return this.resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public String toString() {
        return "Result [resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ", resultData=" + this.resultData + "]";
    }
}