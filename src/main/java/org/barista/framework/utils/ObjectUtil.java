package org.barista.framework.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;


public class ObjectUtil {

	/*@Inject
	static CalendarService calendarService;*/


/*	public static void setSearchDate(CalendarVO calendarVO, Model model) throws Exception {
		CalendarVO sysDt = new CalendarVO();

		String cal_yyyy=calendarVO.getCal_yyyy();
		String cal_mm=calendarVO.getCal_mm();

		if(calendarVO.getCal_yyyy()==null || "".equals(calendarVO.getCal_yyyy())) {
			sysDt=calendarService.getSysDt();
			cal_yyyy=sysDt.getCal_yyyy();
			cal_mm=sysDt.getCal_mm();
		}
		//��,�� ����Ʈ
		List<String> getYYYYList = calendarService.getYYYYList();

		model.addAttribute("getYYYYList",getYYYYList);
		model.addAttribute("cal_yyyy", cal_yyyy);
		model.addAttribute("cal_mm", cal_mm);
	}*/

    public static final String NEW_LINE = "\r\n";
    public static final String STR_ELLIPSIS = "...";

    public static void fillArrays(Object[] a, Object val) throws Exception {
        if( ObjectUtil.isNull( a)) return;
        ObjectUtil.fillArrays( a, 0, a.length, val);
    }

    public static void fillArrays(Object[] a, int fromIndex, int toIndex, Object val) throws Exception {
        for (int i=fromIndex; i<toIndex; i++)
            a[i] = ObjectUtil.instantiate( val.getClass().getName());
    }

    public static Class<?> loadClass(String className) throws ClassNotFoundException, Exception {

        Class<?> clazz = null;
        try {
            clazz = Thread.currentThread().getContextClassLoader().loadClass(className);
        }
        catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        }
        catch (Exception e) {
            throw new Exception(e);
        }

        if (clazz == null) {
            clazz = Class.forName(className);
        }

        return clazz;

    }

    public static Object instantiate(String className) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, Exception {
        Class<?> clazz;

        try {
            clazz = loadClass(className);
            return clazz.newInstance();
        }
        catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        }
        catch (InstantiationException e) {
            throw new InstantiationException();
        }
        catch (IllegalAccessException e) {
            throw new IllegalAccessException();
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static Object instantiate(String className, String[] types, Object[] values) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, Exception {
        Class<?> clazz;
        Class<?>[] classParams = new Class[values.length];
        Object[] objectParams = new Object[values.length];

        try {
            clazz = loadClass(className);

            for (int i = 0; i < values.length; i++) {
                classParams[i] = loadClass(types[i]);
                objectParams[i] = values[i];
            }

            Constructor<?> constructor = clazz.getConstructor(classParams);
            return constructor.newInstance(values);

        }
        catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        }
        catch (InstantiationException e) {
            throw new InstantiationException();
        }
        catch (IllegalAccessException e) {
            throw new IllegalAccessException();
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static boolean isNull(Object object) {
        return ((object == null) || object.equals(null));
    }

    public static boolean isNotNull( Object object) {

        return !ObjectUtil.isNull( object);
    }

    public static boolean isNotNull( Object[] objects) {

        return (objects != null && objects.length > 0);
    }

    public static boolean isEmpty( Object object) {
        if ( object == null )
            return true;

        if ( object instanceof java.lang.String) {
            return (( String)object).length() == 0;
        }
        else if ( object instanceof java.util.Collection) {
            return ((Collection<?>)object).size() == 0;
        }
        else if ( object instanceof java.util.Map) {
            return ((Map<?, ?>)object).size() == 0;
        }
        else if ( object instanceof Object[]){
            return ((Object[])object).length == 0;
        }
        else if ( object instanceof java.lang.Integer) {
            return (( Integer)object).intValue() == 0;
        }
        else if ( object instanceof java.util.List) {
            return ((List<?>)object).size() == 0;
        }

        return false;
    }

    public static boolean isNotEmpty( Object object) {

        return !ObjectUtil.isEmpty( object);
    }

    public static Object[] getIncluedObjects(Object[] obj, Object[] targetObj) {
        if (isEmpty(obj))
            return null;
        if (isEmpty(targetObj))
            return null;
        List<Object> incluedObjects = new ArrayList<>();
        for (int i = 0; i < obj.length; ++i) {
            if (isNull(obj)) {
                continue;
            }
            for (int j = 0; j < targetObj.length; ++j) {
                if (isNull(targetObj)) {
                    continue;
                }
                if (obj[i].equals(targetObj[j])) {
                    incluedObjects.add(targetObj[j]);
                }
            }
        }

        return Utils.toArray(incluedObjects);
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> getLazyListDecorate(List<T> list, T decoratedObj) {
        return (List<T>) LazyList.decorate(list, FactoryUtils.instantiateFactory(decoratedObj.getClass()));
    }

    public static Map<?, ?> getLazyMapDecorate(Map<?, ?> map, Object decoratedObj) {
        return LazyMap.decorate(map, FactoryUtils.instantiateFactory(decoratedObj.getClass()));
    }

    public static int compareNullObject(Object o1, Object o2) {

        if ( o1 == null && o2 == null) return 0;
        if ( o1 != null && o2 == null) return 1;
        if ( o1 == null && o2 != null) return -1;

        return 2;
    }

    public static void merge( Object obj, Object update, boolean mergeNull) {
        merge( obj, update, mergeNull, false);
    }

    public static void merge( Object obj, Object update, boolean mergeNull, boolean currentClass) {

        if ( !obj.getClass().isAssignableFrom( update.getClass())) {
            return;
        }

        Method[] methods = obj.getClass().getMethods();
        Method fromMethod = null;

        for ( int i = 0; i < methods.length; i++) {

            fromMethod = methods[i];

            // 같은 타입의 클레스에 대해 비교하고자 할경우 사용.
            // fromMethod.getDeclaringClass().equals( obj.getClass())
            if ( currentClass && !fromMethod.getDeclaringClass().equals( obj.getClass())) {
                continue;
            }

            if ( fromMethod.getName().startsWith( "get")) {

                String fromName = fromMethod.getName();
                String toName = fromName.replaceFirst( "get", "set");

                try {
                    Method toMetod = obj.getClass().getMethod( toName, new Class[]{fromMethod.getReturnType()});
                    Object value = fromMethod.invoke( update, ( Object[]) null);
                    if ( ObjectUtil.isNotEmpty( value)) {
                        if ( mergeNull) {
                            Object toValue = fromMethod.invoke( obj, ( Object[]) null);
                            if ( ObjectUtil.isEmpty( toValue)) {
                                toMetod.invoke( obj, new Object[]{value});
                            }
                        }
                        else {
                            toMetod.invoke( obj, new Object[]{value});
                        }
                    }
                }
                catch ( NoSuchMethodException e) {
                    // TODO
                }
                catch ( Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String encodePassword(String password, String algorithm) {
        byte[] unencodedPassword = password.getBytes();

        MessageDigest md = null;

        try {
            // first create an instance, given the provider
            md = MessageDigest.getInstance(algorithm);
        }
        catch (Exception e) {
            return password;
        }

        md.reset();

        // call the update method one or more times
        // (useful when you don't know the size of your data, eg. stream)
        md.update(unencodedPassword);

        // now calculate the hash
        byte[] encodedPassword = md.digest();

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < encodedPassword.length; i++) {
            if (((int) encodedPassword[i] & 0xff) < 0x10) {
                buf.append("0");
            }

            buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
        }

        return buf.toString();
    }

    public static String swapFirstLetterCase(String str) {
        StringBuffer sbuf = new StringBuffer(str);
        sbuf.deleteCharAt(0);
        if (Character.isLowerCase(str.substring(0, 1).toCharArray()[0])) {
            sbuf.insert(0, str.substring(0, 1).toUpperCase());
        }
        else {
            sbuf.insert(0, str.substring(0, 1).toLowerCase());
        }
        return sbuf.toString();
    }

    public static String trim(String origString, String trimString) {
        int startPosit = origString.indexOf(trimString);
        if (startPosit != -1) {
            int endPosit = trimString.length() + startPosit;
            return origString.substring(0, startPosit) + origString.substring(endPosit);
        }
        return origString;
    }

    public static String getLastString(String origStr, String strToken) {
        if( origStr == null) return null;

        StringTokenizer str = new StringTokenizer(origStr, strToken);
        String lastStr = "";
        while (str.hasMoreTokens()) {
            lastStr = str.nextToken();
        }
        return lastStr;
    }

    public static String[] getStringArray(String str, String strToken) {
        return getStringArray(str, strToken, false);
    }
    public static String[] getStringArray(String str, String strToken, boolean isTrim) {

        // Null Check.
        if( isNull( str)) return null;

        if (str.indexOf(strToken) != -1) {
            StringTokenizer st = new StringTokenizer(str, strToken);
            String[] stringArray = new String[st.countTokens()];
            for (int i = 0; st.hasMoreTokens(); i++) {
                if( isTrim) {
                    stringArray[i] = st.nextToken().trim();
                }
                else {
                    stringArray[i] = st.nextToken();
                }
            }
            return stringArray;
        }
        return new String[] { str };
    }

    public static String convertStringArrayToString(String[] array, String delimiter) {
        return String.join(delimiter, array);
    }

    public static boolean isNotEmpty( String str) {
        return isNotEmpty( str, false);
    }

    public static boolean isNotEmpty(String str, boolean isTrim) {

        if( isTrim) {
            return !isEmpty(str, true);
        }
        else {
            return !isEmpty(str);
        }
    }

    public static boolean isEmpty(String str) {
        return isEmpty( str, false);
    }
    public static boolean isEmpty(String str, boolean isTrim) {
        if( isTrim) {
            return isEmptyTrimmed( str);
        }
        else {
            return (str == null || str.length() == 0);
        }
    }

    public static boolean isEmptyDefault(String str, boolean isTrim) {
        if(isEmpty(str)) {
            return isTrim;
        } else {
            return true;
        }
    }


    public static final boolean isEmptyTrimmed(String foo) {
        return (foo == null || foo.trim().length() == 0);
    }

    public static String replace(String szOriginal, String szOld, String szNew) {
        return replace(szOriginal, szOld, szNew, 0);
    }

    public static String replace(String szOriginal, String szOld, String szNew, int nReplaceCount) {
        if (szOriginal == null || szOld == null || szNew == null) {
            throw new IllegalArgumentException();
        }

        StringBuffer sbResult = new StringBuffer();
        int nFromIndex = 0, nToIndex = 0;
        int nOldLength = szOld.length();
        int i = 0;

        while ((nToIndex = szOriginal.indexOf(szOld, nFromIndex)) >= 0) {
            sbResult.append(szOriginal.substring(nFromIndex, nToIndex)).append(szNew);
            nFromIndex = nToIndex + nOldLength;

            if (nReplaceCount != 0 && ++i == nReplaceCount) {
                return sbResult.append(szOriginal.substring(nFromIndex)).toString();
            }
        }

        return sbResult.append(szOriginal.substring(nFromIndex)).toString();
    }

    public static int string2integer(String str) {
        int ret = Integer.parseInt(str.trim());

        return ret;
    }

    public static String integer2string(int integer) {
        return ("" + integer);
    }

    public static boolean isPatternMatching(String str, String pattern) throws Exception {
        // if url has wild key, i.e. "*", convert it to ".*" so that we can
        // perform regex matching
        if (pattern.indexOf('*') >= 0) {
            pattern = pattern.replaceAll("\\*", ".*");
        }

        pattern = "^" + pattern + "$";

        return Pattern.matches(pattern, str);
    }

    public static boolean containsMaxSequence(String str, String maxSeqNumber) {
        int occurence = 1;
        int max = string2integer(maxSeqNumber);
        if (str == null) {
            return false;
        }

        int sz = str.length();
        for (int i = 0; i < (sz - 1); i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                occurence++;

                if (occurence == max)
                    return true;
            }
            else {
                occurence = 1;
            }
        }
        return false;
    }

    public static boolean containsInvalidChars(String str, char[] invalidChars) {
        if (str == null || invalidChars == null) {
            return false;
        }
        int strSize = str.length();
        int validSize = invalidChars.length;
        for (int i = 0; i < strSize; i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < validSize; j++) {
                if (invalidChars[j] == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsInvalidChars(String str, String invalidChars) {
        if (str == null || invalidChars == null) {
            return true;
        }
        return containsInvalidChars(str, invalidChars.toCharArray());
    }

    public static boolean isAlphaNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        if (sz == 0)
            return false;
        for (int i = 0; i < sz; i++) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlpha(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        if (sz == 0)
            return false;
        for (int i = 0; i < sz; i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        if (sz == 0)
            return false;
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuffer(str).reverse().toString();
    }

    public static String fillString(String originalStr, char ch, int cipers) {
        int originalStrLength = originalStr.length();

        if (cipers < originalStrLength)
            return null;

        int difference = cipers - originalStrLength;

        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < difference; i++)
            strBuf.append(ch);

        strBuf.append(originalStr);
        return strBuf.toString();
    }

    public static List<String> getTokenFixSize( String lst, int fixSize) {
        List<String> alToken = new ArrayList<String>();

        if ( lst != null ) {
            if ( lst.length() >= fixSize && fixSize > 0 ) {

                for ( int i = 0; i < lst.length(); i+=fixSize) {
                    if ( i+fixSize < lst.length() )
                        alToken.add( lst.substring( i, i+fixSize));
                    else
                        alToken.add( lst.substring( i, lst.length()) );
                }

            } else {
                alToken.add( lst);
            }
        }

        return alToken;
    }

    public static List<String> getTokenFixSize( String lst) {
        return getTokenFixSize( lst, 2);
    }

    public static List<String> getAddTokensFixSize(String lst, int fixSize, boolean bExcludeLastToken) {
        List<String> tokens = getTokenFixSize(lst, fixSize);
        List<String> newTokens = new ArrayList<String>();

        String sumToken = "";
        for ( int i = 0 ; tokens != null && i < tokens.size() - ( bExcludeLastToken ? 1 : 0) ; i++) {
            sumToken = sumToken + tokens.get( i);
            newTokens.add( sumToken);
        }

        return newTokens;
    }

    public static List<String> getAddTokensFixSize(String lst, int fixSize) {
        return getAddTokensFixSize( lst, fixSize, false );
    }

    public static List<String> getAddTokensFixSize(String lst ) {
        return getAddTokensFixSize( lst, 2, false );
    }

    public static List<String> getAddTokens(String lst, String separator, boolean bExcludeLastToken) {
        List<String> tokens = getTokens(lst, separator);
        List<String> newTokens = new ArrayList<String>();

        String sumToken = "";
        for ( int i = 0 ; tokens != null && i < tokens.size() - ( bExcludeLastToken ? 1 : 0) ; i++) {
            sumToken = sumToken + tokens.get( i) + separator;
            newTokens.add( sumToken);
        }

        return newTokens;
    }

    public static List<String> getAddTokens(String lst, String separator) {
        return getAddTokens( lst, separator, false );
    }

    public static List<String> getTokens(String lst, String separator, boolean includeNullString) {
        List<String> tokens = new ArrayList<String>();

        if (lst != null) {
            StringTokenizer st = new StringTokenizer(lst, separator);
            while (st.hasMoreTokens()) {
                try {
                    String en = st.nextToken().trim();
                    if( includeNullString || isNotNull( en)) tokens.add(en);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return tokens;
    }

    public static List<String> getTokens(String lst, String separator) {
        return getTokens( lst, separator, true);
    }

    public static List<String> getTokens(String lst) {
        return getTokens(lst, ",");
    }

    public static String convertToCamelCase(String targetString, char posChar) {
        StringBuffer result = new StringBuffer();
        boolean nextUpper = false;
        String allLower = targetString.toLowerCase();

        for (int i = 0; i < allLower.length(); i++) {
            char currentChar = allLower.charAt(i);
            if (currentChar == posChar) {
                nextUpper = true;
            }
            else {
                if (nextUpper) {
                    currentChar = Character.toUpperCase(currentChar);
                    nextUpper = false;
                }
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public static String convertToCamelCase(String underScore) {
        return convertToCamelCase(underScore, '_');
    }

    public static String convertToUnderScore(String camelCase) {
        String result = "";
        for (int i = 0; i < camelCase.length(); i++) {
            char currentChar = camelCase.charAt(i);
            // This is starting at 1 so the result does not end up with an
            // underscore at the begin of the value
            if (i > 0 && Character.isUpperCase(currentChar)) {
                result = result.concat("_");
            }
            result = result.concat(Character.toString(currentChar).toLowerCase());
        }
        return result;
    }

    public static String toLowerCaseFirstChar(String value) {
        if (isNotEmpty(value)) {
            value = value.substring(0, 1).toLowerCase() + value.substring(1);
        }
        return value;
    }

    public static String toUpperCaseFirstChar(String value) {
        if (isNotEmpty(value)) {
            value = value.substring(0, 1).toUpperCase() + value.substring(1);
        }
        return value;
    }

    public static String null2str(String org, String converted) {
        if (org == null || org.trim().length() == 0) {
            return converted;
        }
        else {
            return org.trim();
        }
    }

    public static String null2str(String org) {
        return null2str(org, "");
    }

    public static String[] tokenizeToStringArray(String str, String delimiters) {
        return tokenizeToStringArray(str, delimiters, true, true);
    }

    public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens,
                                                 boolean ignoreEmptyTokens) {

        if (str == null) {
            return null;
        }
        StringTokenizer st = new StringTokenizer(str, delimiters);
        List<String> tokens = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (trimTokens) {
                token = token.trim();
            }
            if (!ignoreEmptyTokens || token.length() > 0) {
                tokens.add(token);
            }
        }
        return toStringArray(tokens);
    }

    public static String[] delimitedListToStringArray(String str, String delimiter) {
        return delimitedListToStringArray(str, delimiter, null);
    }

    public static String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete) {
        if (str == null) {
            return new String[0];
        }
        if (delimiter == null) {
            return new String[] { str };
        }
        List<String> result = new ArrayList<String>();
        if ("".equals(delimiter)) {
            for (int i = 0; i < str.length(); i++) {
                result.add(deleteAny(str.substring(i, i + 1), charsToDelete));
            }
        }
        else {
            int pos = 0;
            int delPos = 0;
            while ((delPos = str.indexOf(delimiter, pos)) != -1) {
                result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
                pos = delPos + delimiter.length();
            }
            if (str.length() > 0 && pos <= str.length()) {
                // Add rest of String, but not in case of empty input.
                result.add(deleteAny(str.substring(pos), charsToDelete));
            }
        }
        return toStringArray(result);
    }

    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return collection.toArray(new String[collection.size()]);
    }

    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }
        List<String> list = Collections.list(enumeration);
        return list.toArray(new String[list.size()]);
    }

    public static String delete(String inString, String pattern) {
        return replace(inString, pattern, "");
    }

    public static String deleteAny(String inString, String charsToDelete) {
        if (!hasLength(inString) || !hasLength(charsToDelete)) {
            return inString;
        }
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < inString.length(); i++) {
            char c = inString.charAt(i);
            if (charsToDelete.indexOf(c) == -1) {
                out.append(c);
            }
        }
        return out.toString();
    }

    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    public static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    public static String[] trimArrayElements(String[] array) {
        if (ObjectUtil.isEmpty(array)) {
            return new String[0];
        }
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            String element = array[i];
            result[i] = (element != null ? element.trim() : null);
        }
        return result;
    }

    public static String[] getTokenizedStringsWithDelimiter(String szSource, String szDelimiter) {
        if (szSource == null || szDelimiter == null) {
            throw new IllegalArgumentException();
        }

        StringTokenizer st = new StringTokenizer(szSource, szDelimiter, false);
        int nTokenNumber = st.countTokens();
        if (nTokenNumber == 0) {
            return null;
        }

        int i = 0;
        String[] arrResult = new String[nTokenNumber];

        while (st.hasMoreTokens()) {
            arrResult[i++] = st.nextToken();
        }

        return arrResult;
    }

    public static String[] getTokenizedTrimmedStringsWithDelimiter( String szSource, String szDelimiter )
    {
        if ( szSource == null || szDelimiter == null )
        {
            throw new IllegalArgumentException();
        }


        StringTokenizer st = new StringTokenizer( szSource, szDelimiter, false );
        int				nTokenNumber = st.countTokens();
        if ( nTokenNumber == 0 )
        {
            return	null;
        }

        int				i = 0;
        String[]		arrResult = new String[nTokenNumber];

        while ( st.hasMoreTokens() )
        {
            arrResult[i++] = st.nextToken().trim();
        }

        return		arrResult;
    }

    public static String[] getTokenizedStringsWithDelimiter( String szSource, String szDelimiter, boolean bIncludeNullString )
    {
        if ( szSource == null || szDelimiter == null )
        {
            throw new IllegalArgumentException();
        }

        if ( szSource.length() == 0 )
        {
            return null;
        }

        StringTokenizer st = new StringTokenizer( szSource, szDelimiter, bIncludeNullString );
        ArrayList<String> al = new ArrayList<>();
        String szTemp = "";
        boolean bNextDelimiter = false;

        while ( st.hasMoreTokens() )
        {
            szTemp = st.nextToken();

            if ( szTemp.equals(szDelimiter) )
            {
                if ( !bNextDelimiter )
                {
                    al.add( "" );
                }

                bNextDelimiter = false;
            }
            else
            {
                al.add( szTemp );
                bNextDelimiter = true;
            }
        }

        if ( !bNextDelimiter )
        {
            al.add( "" );
        }

        return al.toArray(new String[0]);
    }

    public static String getSubstringWithDelimiter( String szSource, String szDelimiter, int nStartToken, int nEndToken )
    {
        if ( szSource == null || szDelimiter == null ||
                !(nStartToken >= 0 && nEndToken >= nStartToken) )
        {
            throw new IllegalArgumentException();
        }

        int i = 0;
        String szResult = "";
        String szNextToken = "";
        StringTokenizer st = new StringTokenizer( szSource, szDelimiter, true );

        while ( st.hasMoreTokens() && i <= nEndToken )
        {
            szNextToken = st.nextToken();

            if ( szNextToken.equals(szDelimiter) )
            {
                szNextToken = "";
            }
            else if ( st.hasMoreTokens() )
            {
                szDelimiter = st.nextToken();   // 이것이 Delimiter.
            }

            if ( i == nStartToken )
            {
                szResult += szNextToken;
            }
            else if ( i > nStartToken )
            {
                szResult += szDelimiter + szNextToken;
            }

            i ++;
        }

        return szResult;
    }

    public static String cutString( String string, int length) {
        if( isEmpty( string) || string.length() <= length) {
            return string;
        }
        return string.substring( 0, length);
    }

    public static String concatenate(Object[] szTokens, String szSept) {
        StringBuffer sb = new StringBuffer();

        if (szTokens == null)
            return null;

        if (szTokens.length > 0 && szTokens[0] != null)
            sb.append(szTokens[0].toString());

        for (int i = 1; i < szTokens.length; i++)
            sb.append(szSept).append(szTokens[i].toString());

        return sb.toString();
    }

    public static String concatenate( List<?> szTokens, String szSept) {
        StringBuffer sb = new StringBuffer();

        if (szTokens == null)
            return null;

        if (szTokens.size() > 0)
            sb.append(szTokens.get( 0));

        for (int i = 1; i < szTokens.size(); i++)
            sb.append(szSept).append(szTokens.get(i));

        return sb.toString();
    }


    public static boolean isNull( String szInString)
    {
        return ( szInString == null || szInString.trim().length() == 0 );
    }

    public static boolean isNotNull( String szInString)
    {
        return ( szInString != null && szInString.trim().length() > 0 );
    }

    public static String getFileName(String szFileName)
    {
        return getFileName( szFileName, true);
    }

    public static String getFileName(String szFileName, boolean bFileSeparator)
    {
        String szName = szFileName;

        if ( szFileName != null )
        {
            String cFileSeparator = ( bFileSeparator ? File.separator : "/");

            int index = szFileName.lastIndexOf( cFileSeparator);

            if ( index < (szFileName.length() - 1) && index != -1 )
            {
                szName = szFileName.substring( index + 1);
            }
        }

        return szName;
    }

    public static String getFileType(String szFileName)
    {
        return getFileType(szFileName, false);
    }

    public static String getFileType(String szFileName, boolean toUpperCase)
    {
        if ( szFileName != null )
        {
            int index = szFileName.lastIndexOf( ".");

            if ( index < (szFileName.length() - 1) && index != -1 )
            {
                if( toUpperCase) {
                    return szFileName.substring( index + 1).toUpperCase();
                }
                else {
                    return szFileName.substring( index + 1);
                }
            }
            else
            {
                return "";
            }
        }

        return "";
    }

    public static String lpad( String str, int len, String addStr)
    {
        String result = str;

        if( result == null){
            result = "";
        }

        int templen   = len - result.length();

        for (int i = 0; i < templen; i++)
        {
            result = addStr + result;
        }

        return result;
    }

    public static boolean isEqualStr( String str1, String str2)
    {
        if( StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2)) return false;

        if( (str1.toLowerCase()).equals( str2.toLowerCase())) return true;
        else return false;
    }

    public static String getFileFullNameWithoutFileType(String szFileName)
    {
        if ( szFileName == null )
        {
            return "";
        }

        int index = szFileName.lastIndexOf( ".");

        if ( index < (szFileName.length() - 1) && index != -1 )
        {
            szFileName = szFileName.substring( 0, index);
        }

        return szFileName;
    }

    public static int compare(String str1, String str2)
    {
        if ( ( str1 == null || str1.length() == 0)
                && ( str2 == null || str2.length() == 0)) return 0;

        if ( str1 == null ) return -1;

        if ( str2 == null ) return 1;

        return str1.compareTo(str2);
    }

    public static String pack(String str1)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("MD5") ;
            return digest.digest(str1.getBytes()).toString();
        }
        catch(NoSuchAlgorithmException ie)
        {
            return str1;
        }
    }

    private static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean isValidatedEmail(String email) {
        return isNotEmpty(email) && EMAIL_ADDRESS_PATTERN.matcher(email).find();
    }

    private static final Pattern DOMAIN_PATTERN = Pattern.compile("^([a-z0-9*]+(-[a-z0-9]+)*\\.)+[a-z]{2,}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidatedDomain(String domain) {
        return isNotEmpty(domain) && DOMAIN_PATTERN.matcher(domain).find();
    }

    private static final Pattern IP_PATTERN = Pattern.compile("^[0-9*]{1,3}[-]{0,1}[0-9*]{0,3}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidatedIP(String ips) {
        boolean result = false;
        if (isNotEmpty(ips)) {
            String[] arrIP = ips.split("\\.");
            for (String ip : arrIP) {
                result = true;
                if (!IP_PATTERN.matcher(ip).find()) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean hasAlphabet( String value) {
        return Pattern.compile(".*[a-zA-Z]+.*").matcher( value).matches();
    }

    public static StringBuffer removeLastSeparator( StringBuffer sb, String separator) {
        if( sb != null) {
            int lastIndex = sb.lastIndexOf( separator);
            int length = sb.length();
            if( lastIndex == length-1) {
                sb.delete( lastIndex, length);
            }
        }
        return sb;
    }

    protected static String[] 	fileSizeUnits	= new String[]{ "GB", "MB", "KB", "BYTE"};
    protected static double[]	fileSizes 		= new double[]{ 1024 * 1024 * 1024, 1024 * 1024, 1024, 1};
    public static String getFileSizeAndUnit( double byteSize, String format) {
        double 	size 	= 0;
        int		index	= 0;

        for( int m = fileSizes.length; index < m; index++) {
            size = fileSizes[ index];
            if( byteSize >= size) {
                break;
            }
        }
        if( index >= fileSizes.length) {
            index = fileSizes.length - 1;
        }

        return new DecimalFormat( format).format( byteSize / fileSizes[ index]) + fileSizeUnits[ index];
    }

    public static String getSequenceName(String name, List<String> existNames) {
        if (existNames != null && existNames.size() > 0) {
            int sequence = 0;
            for (int i = 0; i < existNames.size(); i++) {

                String postFix = (existNames.get(i)).substring(name.length());

                if (postFix.lastIndexOf("(") >= 0 && (postFix.lastIndexOf(")") <= (postFix.length() - 1))) {
                    postFix = postFix.substring(postFix.lastIndexOf("(") + 1, postFix.lastIndexOf(")")).trim();

                    if (isNumeric(postFix) && sequence < Integer.parseInt(postFix)) {
                        sequence = Integer.parseInt(postFix);
                    }
                } else {
                    continue;
                }
            }

            if (sequence >= 0) {
                if (sequence == 0)
                    sequence = 1;
                name += " (" + (sequence + 1) + ")";
            }
        }
        return name;
    }


    public static String makeSequenceName(String name, Collection<String> similarNames) {
        return makeSequenceName(name, similarNames, null);
    }

    public static String makeSequenceName(String name, Collection<String> similarNames, String fileType) {
        if (name == null || name.length() == 0) {
            return name;
        }
        boolean checkFileType = fileType != null && fileType.length() > 0;
        String checkName = checkFileType ? name + "." + fileType : name;
        if (similarNames == null || similarNames.size() == 0) {
            return checkFileType ? name + "." + fileType : name;
        }

        Set<String> similarNameSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        similarNameSet.addAll(similarNames);
        if (!similarNameSet.contains(checkName)) {
            return checkName;
        }

        int seq = 2;
        while (true) {
            checkName = name + " (" + seq + ")";
            if (checkFileType) {
                checkName += "." + fileType;
            }
            if (!similarNameSet.contains(checkName)) {
                return checkName;
            }

            seq++;
        }
    }

    public static String join(Object[] objects, String separator) {
        return StringUtils.join(objects, separator);
    }

    public static boolean equals(String source, String target, boolean useCaseSensitive) {
        if (source == null) {
            return false;
        }
        if (useCaseSensitive) {
            return source.equals(target);
        } else {
            return source.equalsIgnoreCase(target);
        }
    }

    public static String getStringWithElipsis(String origString, int maxLength, boolean includeElipsisMaxLength) {
        if( isNotEmpty(origString) && origString.length() > maxLength) {
            return origString.substring(0, includeElipsisMaxLength ? maxLength - STR_ELLIPSIS.length() : maxLength) + STR_ELLIPSIS;
        }
        return origString;
    }

    public static Map<String, String> parseQueryString(String value) {
        return parseString(value, "&", "=");
    }

    public static Map<String, String> parseString(String value, String elementDelimiter, String valueDelimiter) {
        Map<String, String> result = new HashMap<>();
        String[] elements = null;
        int valueIndex = -1;

        if (isNotEmpty(value) && isNotEmpty(elementDelimiter) && isNotEmpty(valueDelimiter)) {
            elements = getStringArray(value, elementDelimiter);
            for (String element : elements) {
                if (isNotEmpty(element)) {
                    valueIndex = element.indexOf(valueDelimiter);
                    if (valueIndex > 0) {
                        result.put(element.substring(0, valueIndex), element.substring(valueIndex + valueDelimiter.length()));
                    } else {
                        result.put(element, null);
                    }
                }
            }
        }
        return result;
    }

    public static String getStringParameter(String str, String defaultData) {
        return str != null ? str : defaultData;
    }

    public static String getStringParameter(Object strObject, String defaultData) {
        return strObject != null ? strObject.toString() : defaultData;
    }

    public static int getIntParameter(String str, int defaultData) {
        if(isEmpty(str)) {
            return defaultData;
        } else {
            return Integer.parseInt(str);
        }
    }

    public static boolean getBooleanParameter(String str, boolean defaultData) {
        if(isEmpty(str)) {
            return defaultData;
        } else {
            return Boolean.parseBoolean(str);
        }
    }

    static ObjectMapper objectMapper = new ObjectMapper();
    public static HashMap<String, Object>[] convertLightMap(Object obj []){

        HashMap<String, Object> map_ [] = new HashMap[obj.length];
        for( int i = 0 ; i < obj.length ; i ++) {
            HashMap<String, Object> map = objectMapper.convertValue(obj, HashMap.class);
            HashMap<String, Object> returnMap = new HashMap<>();

            Iterator<String> keys = map.keySet().iterator();
            while (keys.hasNext()) {
                String mapKey = keys.next();
                Object mapValue = map.get(mapKey);
                if (ObjectUtil.isNotEmpty(mapValue)) {
                    returnMap.put(mapKey, mapValue);
                }
            }
            map_[i] = returnMap;
        }
        return map_;
    }

    /**
     * Map 에서 String 가져오기
     * @author chkim
     * @param map
     * @param key
     * @return
     */
    public static String getMapVal(Map<String, Object> map, String key) {
        return getMapVal(map, key, null);
    }

    /**
     * Map 에서 String 가져오기
     * @author chkim
     * @param map
     * @param key
     * @param
     * @return defaultValue
     */
    public static String getMapVal(Map<String, Object> map, String key, String defaultValue) {
        try {
            Object obj = map.get(key);
            if (obj == null) {
                return defaultValue;
            }
            return String.valueOf(obj);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Map 에서 int 가져오기
     * @author chkim
     * @param map
     * @param key
     * @return
     */
    public static int getMapValInt(Map<String, Object> map, String key) {
        return getMapValInt(map, key, -1);
    }

    /**
     * Map 에서 int 가져오기
     * @author chkim
     * @param map
     * @param key
     * @return defaultValue
     * @return
     */
    public static int getMapValInt(Map<String, Object> map, String key, int defaultValue) {
        try {
            return Integer.parseInt(getMapVal(map, key, String.valueOf(defaultValue)));
        } catch (Exception e) {
            return defaultValue;
        }
    }

}
