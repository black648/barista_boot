package org.barista.framework.utils;

public class APIResultUtil {

    public static APIResult getAPIResult() {
        return getAPIResult(null);
    }

    public static APIResult getAPIResult(Object resultData) {
        APIResult result = new APIResult();
        result.setResultCode(0); // default
        result.setResultData(resultData);
        return result;
    }

    public static APIResult getAPIResult(int nErrorCode, String msg) {
        APIResult result = new APIResult();
        result.setResultCode(nErrorCode); // default
        result.setResultMsg(msg);
        return result;
    }

    public static APIResult getAPIResultWithMsg(Object resultData, String msg) {
        APIResult result = new APIResult();
        result.setResultCode(0); // default
        result.setResultMsg(msg);
        result.setResultData(resultData);
        return result;
    }
}
