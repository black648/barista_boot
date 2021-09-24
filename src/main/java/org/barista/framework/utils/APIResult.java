package org.barista.framework.utils;

public class APIResult {
    private int resultCode;
    private String resultMessage;
    private Object resultData;

    public APIResult() {
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Object getResultData() {
        return this.resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public String toString() {
        return "Result [resultCode=" + this.resultCode + ", resultMessage=" + this.resultMessage + ", resultData=" + this.resultData + "]";
    }
}