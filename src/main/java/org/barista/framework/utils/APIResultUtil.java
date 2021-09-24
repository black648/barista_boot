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

    public static APIResult getAPIResult(int nErrorCode, String message) {
        APIResult result = new APIResult();
        result.setResultCode(nErrorCode); // default
        result.setResultMessage(message);
        return result;
    }

    public static APIResult getAPIResultWithMessage(Object resultData, String message) {
        APIResult result = new APIResult();
        result.setResultCode(0); // default
        result.setResultMessage(message);
        result.setResultData(resultData);
        return result;
    }
}
