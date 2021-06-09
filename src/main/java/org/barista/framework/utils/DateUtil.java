package org.barista.framework.utils;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class DateUtil
{
    public static final String					SZ_NULL_STRING = "";

    public static final String					DATE_TO_CONDITION_SUFFIX = " 23:59:59";
    public static final long                    DATE_TO_CONDITION_SUFFIX_MILLISECONDS = (1000 * 86399); // "23:59:59"
    public static final long                    DATE_TO_CONDITION_ONE_DAY_MILLSECONDS = (1000 * 86400); // "1day"
    public static final String                  DATE_FROM_COMMON_MIN_VALUE = "1900-01-01";
    public static final String					DATE_TO_COMMON_MAX_VALUE = "2286-01-01";

    public static final Timestamp 				DATE_TO_MIN_TIMESTAMP = new Timestamp(0);
    public static final Timestamp 				DATE_TO_MAX_TIMESTAMP = Timestamp.valueOf("9999-12-31" + DATE_TO_CONDITION_SUFFIX);

    public static final SimpleDateFormat        SDF_ISO8601 = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssZ");
    public static final SimpleDateFormat        SDF_ISO8601_NO_MARK = new SimpleDateFormat( "yyyyMMdd'T'HHmmss'Z'");
    public static final SimpleDateFormat        SDF_ISO8601_WINDOWS = new SimpleDateFormat( "yyyyMMdd'T'HH:mm:ss");
    public static final SimpleDateFormat        SDF_ISO8601_MS = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    public static final SimpleDateFormat		SDF_YYYY = new SimpleDateFormat( "yyyy");
    public static final SimpleDateFormat		SDF_YYYYMM = new SimpleDateFormat( "yyyyMM");
    public static final SimpleDateFormat		SDF_YYYYMM_DASH = new SimpleDateFormat( "yyyy-MM");
    public static final SimpleDateFormat		SDF_YYYYMM_DOT = new SimpleDateFormat( "yyyy.MM");
    public static final SimpleDateFormat		SDF_YYYYMMDD = new SimpleDateFormat( "yyyyMMdd");
    public static final SimpleDateFormat        SDF_YYYYMMDDHH = new SimpleDateFormat ("yyyyMMddHH");
    public static final SimpleDateFormat		SDF_YYYYMMDD_DASH = new SimpleDateFormat( "yyyy-MM-dd");
    public static final SimpleDateFormat		SDF_YYYYMMDD_SLASH= new SimpleDateFormat("yyyy/MM/dd");
    public static final SimpleDateFormat		SDF_YYYYMMDD_DOT = new SimpleDateFormat( "yyyy.MM.dd");
    public static final SimpleDateFormat		SDF_YYYYMMDDHHMM = new SimpleDateFormat( "yyyyMMddhhmm");
    public static final SimpleDateFormat		SDF_YYYYMMDDHHMM_DASH_DASH = new SimpleDateFormat( "yyyy-MM-dd HH-mm");
    public static final SimpleDateFormat		SDF_YYYYMMDDHHMM_DASH_DOT = new SimpleDateFormat( "yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat		SDF_YYYYMMDDHHMMM_DASH_DOT = new SimpleDateFormat( "yyyy-MM-dd a hh:mm");
    public static final SimpleDateFormat		SDF_YYYYMMDDHHMMSS_NO_MARK = new SimpleDateFormat( "yyyyMMddHHmmss");
    public static final SimpleDateFormat		SDF_YYYYMMDDHHMMSSM_DASH_DOT = new SimpleDateFormat( "yyyy-MM-dd a hh:mm:ss");
    public static final SimpleDateFormat		SDF_YYYYMMDDHHMMSSM_DASH = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat		SDF_YYYYMMDDHHMMSSMS_DASH_DOT = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.S");

    public static final SimpleDateFormat        SDF_YYYYMMDDHHMMSSM_DOT = new SimpleDateFormat("yyyyy.MM.dd a hh:mm");
    public static final SimpleDateFormat        SDF_YYYYMMDDHHMMSSSM_DOT = new SimpleDateFormat("yyyyy.MM.dd aaa hh:mm");
    public static final SimpleDateFormat        SDF_YYYYMMDDHHMMSSMA_DASH_DOT = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss a");

    public static final SimpleDateFormat        SDF_YYYYMMDDHHMMSSMSSS_SLASH_DOT = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss:SSS");

    public static final SimpleDateFormat		SDF_MMDDYYYY = new SimpleDateFormat( "MMddyyyy");
    public static final SimpleDateFormat		SDF_MMDDYYYY_DASH = new SimpleDateFormat( "MM/dd/yyyy");
    public static final SimpleDateFormat		SDF_MMDDYYYY_DOT = new SimpleDateFormat( "MM.dd.yyyy");
    public static final SimpleDateFormat		SDF_MMDDYYYYHHMM = new SimpleDateFormat( "MMddyyyyhhmm");
    public static final SimpleDateFormat        SDF_MMDDYYYYHHMMM_DASH_DOT = new SimpleDateFormat( "MM/dd/yyyy hh:mm a");
    public static final SimpleDateFormat        SDF_MMDDYYYYHHMMSSM_DASH_DOT = new SimpleDateFormat( "MM/dd/yyyy hh:mm:ss a");
    public static final SimpleDateFormat        SDF_MMDDYYYYHHMMSSM_DOT = new SimpleDateFormat("MM.dd.yyyy hh:mm a");
    public static final SimpleDateFormat        SDF_MMDDYYYYHHMMSSSM_DOT = new SimpleDateFormat("MM.dd.yyyy hh:mm aaa");
    public static final SimpleDateFormat        SDF_MMDDYYYYHHMMSSMA_DASH_DOT = new SimpleDateFormat ("MM/dd/yyyy hh:mm:ss a");


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
    public static final int DATE_TYPE_DAY = 1;
    public static final int DATE_TYPE_WEEK = 2;
    public static final int DATE_TYPE_MONTH = 3;
    public static final int DATE_TYPE_HALF_YEAR = 4;
    public static final int DATE_TYPE_YEAR = 5;

    public static final SimpleDateFormat[] defaultDateformats = new SimpleDateFormat[]{
            DateUtil.SDF_YYYYMMDD_DASH,
            DateUtil.SDF_YYYYMMDD_DOT,
            DateUtil.SDF_YYYYMMDD_SLASH,
            DateUtil.SDF_YYYYMMDDHHMM_DASH_DOT,
            DateUtil.SDF_YYYYMMDDHHMMSSM_DASH,
            DateUtil.SDF_YYYYMMDDHHMMSSMS_DASH_DOT
    };

    public static Timestamp getNow() {
        Timestamp tsNow = new Timestamp(System.currentTimeMillis());
        tsNow.setNanos(0);

        return tsNow;
    }

    public static Locale s_DefaultLocale        = Locale.getDefault();

    public static String convertString( String szDate, SimpleDateFormat srcSDF, SimpleDateFormat dstSDF)
    {
        if ( szDate == null || szDate.length() <= 0 ) { return SZ_NULL_STRING;}

        try
        {
            synchronized( srcSDF)
            {
                Date dt = srcSDF.parse( szDate);
                return dstSDF.format( dt);
            }
        }
        catch ( Exception e )
        {
            return SZ_NULL_STRING;
        }
    }

    protected static Map<String, SimpleDateFormat> timeZoneDateFormatMap = new HashMap<String, SimpleDateFormat>();
    protected static final String TIMEZONE_DATE_FORMAT_DELIMITER = "||";
    public static SimpleDateFormat getDateFormatTimeZoneSupport(SimpleDateFormat sdf, TimeZone timeZone) {
        String key = null;
        SimpleDateFormat sdfTimeZoneSupport = null;

        if (timeZone != null) {
            key = sdf.toPattern() + TIMEZONE_DATE_FORMAT_DELIMITER + timeZone.getID();
            sdfTimeZoneSupport = timeZoneDateFormatMap.get(key);
            if (sdfTimeZoneSupport == null) {
                sdfTimeZoneSupport = (SimpleDateFormat) sdf.clone();
                sdfTimeZoneSupport.setTimeZone(timeZone);
                timeZoneDateFormatMap.put(key, sdfTimeZoneSupport);
            }
            return sdfTimeZoneSupport;
        }
        return sdf;
    }

    public static String convertDate(Date dt, SimpleDateFormat sdf) {
        return convertDate(dt, sdf, TimeZone.getDefault());
    }
    public static String convertDate(Date dt, SimpleDateFormat sdf, TimeZone timeZone) {
        SimpleDateFormat sdfTimeZoneSupport = null;

        if (dt == null) {
            return SZ_NULL_STRING;
        }

        sdfTimeZoneSupport = getDateFormatTimeZoneSupport(sdf, timeZone);
        try {
            synchronized (sdfTimeZoneSupport) {
                return sdfTimeZoneSupport.format(dt);
            }
        } catch (Exception e) {
            return SZ_NULL_STRING;
        }
    }

    public static String convertDate(Timestamp ts, SimpleDateFormat sdf) {
        return convertDate(ts, sdf, TimeZone.getDefault());
    }
    public static String convertDate(Timestamp ts, SimpleDateFormat sdf, TimeZone timeZone) {
        if (ts == null) {
            return SZ_NULL_STRING;
        }

        return convertDate(new Date(ts.getTime()), sdf, timeZone);
    }

    public static String lastDayToString(int nDay, SimpleDateFormat sdf )
    {
        Calendar rightNow = Calendar.getInstance();

        rightNow.add(Calendar.DATE, -nDay);

        try
        {
            synchronized( sdf)
            {
                return sdf.format(rightNow.getTime());
            }
        }
        catch ( Exception e )
        {
            return SZ_NULL_STRING;
        }
    }

    public static Timestamp lastTimestamp(int dateType)
    {
        Calendar rightNow = Calendar.getInstance();

        rightNow.set(Calendar.HOUR_OF_DAY, 0);
        rightNow.set(Calendar.MINUTE, 0);
        rightNow.set(Calendar.MILLISECOND, 0);

        switch (dateType) {
            case DATE_TYPE_DAY:
                rightNow.add(Calendar.DATE, -1);
                break;
            case DATE_TYPE_WEEK :
                rightNow.add(Calendar.WEEK_OF_YEAR, -1);
                break;
            case DATE_TYPE_MONTH :
                rightNow.add(Calendar.MONTH, -1);
                break;
            case DATE_TYPE_HALF_YEAR :
                rightNow.add(Calendar.MONTH, -6);
                break;
            case DATE_TYPE_YEAR :
                rightNow.add(Calendar.YEAR, -1);
                break;
            default:
                // TODO Exception
        }

        return new Timestamp( rightNow.getTimeInMillis());
    }

    public static Date getLastDate(long currentTimeMillis, int nDayOffset, boolean bApplyTimeOffset,
                                   boolean bStart) {
        Calendar gc = GregorianCalendar.getInstance();
        gc.setTime(new java.sql.Date(currentTimeMillis));

        if (bApplyTimeOffset) {
            if (bStart) {
                gc.set(Calendar.HOUR_OF_DAY, gc.getMinimum(Calendar.HOUR_OF_DAY));
                gc.set(Calendar.MINUTE, 0);
                gc.set(Calendar.SECOND, 0);
                gc.set(Calendar.MILLISECOND, 0);
            }
            else {
                gc.set(Calendar.HOUR_OF_DAY, gc.getMaximum(Calendar.HOUR_OF_DAY));
                gc.set(Calendar.MINUTE, gc.getMaximum(Calendar.MINUTE));
                gc.set(Calendar.SECOND, gc.getMaximum(Calendar.SECOND));
                gc.set(Calendar.MILLISECOND, gc.getMaximum(Calendar.MILLISECOND));
            }
        }

        gc.add(Calendar.DATE, -nDayOffset);
        return new Date(gc.getTime().getTime());
    }

    public static java.sql.Date lastDayToDate(int nDay) {
        return new java.sql.Date(getLastDate(System.currentTimeMillis(), nDay, false, true).getTime());
    }

    public static Date getLastDate(long currentTimeMillis, int nDayOffset) {
        return getLastDate(currentTimeMillis, nDayOffset, false, false);
    }

    public static Date getLastStartDate(long currentTimeMillis, int nDayOffset) {
        return getLastDate(currentTimeMillis, nDayOffset, true, true);
    }

    public static Date getLastEndDate(long currentTimeMillis, int nDayOffset) {
        return getLastDate(currentTimeMillis, nDayOffset, true, false);
    }

    public static String lastDayToString( String date, int nDay, SimpleDateFormat sdf) {
        Timestamp tmp = convertString2Timestamp( date);
        Date dt = getLastDate(tmp.getTime(),nDay);
        try
        {
            synchronized( sdf)
            {
                return sdf.format( dt);
            }
        }
        catch ( Exception e )
        {
            return SZ_NULL_STRING;
        }
    }

    public static Timestamp getLastDate(Timestamp dateTime, int day) {
        Date date = getLastDate(dateTime.getTime(), day);
        return new Timestamp(date.getTime());
    }

    public static Date getLastMonth(long currentTimeMillis, int nMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        calendar.add(Calendar.MONTH, -nMonth);
        return calendar.getTime();
    }

    public static String lastMonthToString(int nMonth, SimpleDateFormat sdf )
    {
        Calendar rightNow = Calendar.getInstance();

        rightNow.add(Calendar.MONTH, -nMonth);

        try
        {
            synchronized( sdf)
            {
                return sdf.format(rightNow.getTime());
            }
        }
        catch ( Exception e )
        {
            return SZ_NULL_STRING;
        }
    }

    public static String currentTimeToString( SimpleDateFormat sdf )
    {
        Calendar rightNow = Calendar.getInstance();

        try
        {
            synchronized( sdf)
            {
                return sdf.format(rightNow.getTime());
            }
        }
        catch ( Exception e )
        {
            return SZ_NULL_STRING;
        }
    }

    public static Timestamp getNextYearFromNow(int nYear) {
        Calendar rightNow = Calendar.getInstance();

        rightNow.add(Calendar.YEAR, nYear);

        return new Timestamp (rightNow.getTime().getTime());
    }

    public static Timestamp getLastHour(long currentTimeMillis, int nHourOffset) {

        Calendar rightNow = Calendar.getInstance();
        if( currentTimeMillis > 0) {
            rightNow.setTime(new java.sql.Date(currentTimeMillis));
        }

        rightNow.add(Calendar.HOUR_OF_DAY, -nHourOffset);

        return new Timestamp (rightNow.getTime().getTime());
    }

    public static Timestamp getToTimeSuffix(Timestamp ts) {
        if (ts == null) {
            return null;
        }

        return new Timestamp(ts.getTime() + DateUtil.DATE_TO_CONDITION_SUFFIX_MILLISECONDS);
    }

    public static Date getLastMonth(int nMonth) {
        return getLastMonth(System.currentTimeMillis(), nMonth);
    }

    public static int compareTimestamp( Timestamp tsSource, Timestamp tsTarget ){
        if( tsSource == null){
            return ( tsTarget == null) ? 0 : -1;
        }

        if( tsTarget == null){
            return 1;
        }

        return tsSource.equals( tsTarget) ? 0 : tsSource.before( tsTarget ) ? -1 : 1;
    }

    public static Timestamp convertString2Timestamp(String date) {
        return convertString2Timestamp(date, TimeZone.getDefault());
    }
    public static Timestamp convertString2Timestamp(String date, TimeZone timeZone) {
        return convertString2Timestamp(date, defaultDateformats, timeZone);
    }
    public static Timestamp convertString2Timestamp(String szDate, SimpleDateFormat sdfDateFormat) {
        return convertString2Timestamp(szDate, new SimpleDateFormat[]{sdfDateFormat});
    }
    public static Timestamp convertString2Timestamp(String szDate, SimpleDateFormat[] sdfDateFormats) {
        return convertString2Timestamp(szDate, sdfDateFormats, TimeZone.getDefault());
    }
    public static Timestamp convertString2Timestamp(String szDate, SimpleDateFormat sdfDateFormat, TimeZone timeZone) {
        return convertString2Timestamp(szDate, new SimpleDateFormat[]{sdfDateFormat}, timeZone);
    }
    public static Timestamp convertString2Timestamp(String szDate, SimpleDateFormat[] sdfDateFormats, TimeZone timeZone) {
        if (szDate == null || szDate.length() <= 0)
            return null;

        try {
            Date dtDate = null;
            dtDate = parseDate(szDate, sdfDateFormats, timeZone);

            Timestamp tsResult = new Timestamp(dtDate.getTime());
            return tsResult;
        } catch (Exception e) {
            if (isMilliseconds(szDate)) {
                return new Timestamp(Long.parseLong(szDate));
            }
            return null;
        }
    }

    public static boolean isMilliseconds(String dateTimeString) {
        // 숫자로만 구성되었는지 체크
        String temp = dateTimeString;
        if (temp != null && temp.length() > 0) {
            // 음수 부호 제거
            if (temp.charAt(0) == '-') {
                temp = temp.substring(1);
            }
            if (temp.length() > 0) {
                return ObjectUtil.isNumeric(temp);
            }
        }
        return false;
    }

    public static boolean isWindowsDateTime(String dateTimeString) {
        return isMilliseconds(dateTimeString) && dateTimeString.length() > 16;
    }

    public static Date parseDate(String str, SimpleDateFormat parsePattern) throws ParseException {
        return parseDate(str, new SimpleDateFormat[] {parsePattern});
    }
    public static Date parseDate(String str, SimpleDateFormat[] parsePatterns) throws ParseException {
        return parseDate(str, parsePatterns, TimeZone.getDefault());
    }
    public static Date parseDate(String str, SimpleDateFormat[] parsePatterns, TimeZone timeZone) throws ParseException {
        if (str == null || parsePatterns == null) {
            // TODO Exception
        }

        SimpleDateFormat parser = null;
        ParsePosition pos = new ParsePosition(0);
        for (int i = 0; i < parsePatterns.length; i++) {
            parser = getDateFormatTimeZoneSupport(parsePatterns[i], timeZone);
            synchronized (parser) {
                pos.setIndex(0);

                Date date = parser.parse(str, pos);
                if (date != null && pos.getIndex() == str.length()) {
                    return date;
                }
            }
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

    public static Timestamp checkValidateDate(Timestamp tsSource) {
        if( ObjectUtil.isNotNull(tsSource)) {
            Timestamp tsValidate = new Timestamp( 0);
            if( compareTimestamp(tsSource, tsValidate) < 0) {
                return tsValidate;
            }
        }
        return tsSource;
    }

    public static boolean isInvalidDateTime(Timestamp dateTime) {
        return compareTimestamp(dateTime, DATE_TO_MIN_TIMESTAMP) < 0 || compareTimestamp(dateTime, DATE_TO_MAX_TIMESTAMP) > 0;
    }

    public static void checkInvalidDateTime(Timestamp dateTime) {
        if (isInvalidDateTime(dateTime)) {
            // TODO Exception
        }
    }

    public static String convertToDate(String date, String format) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dateFormat = sdf;

        LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        Calendar cal;

        sdf.parse(date);
        cal = sdf.getCalendar();
        return "";

    }

    public static String getNowYear(){
        Calendar cal = Calendar.getInstance();
        return String.valueOf(cal.get(cal.YEAR));
    }

    public static String getNowMonth(){
        Calendar cal = Calendar.getInstance();
        return String.format("%02d", cal.get(cal.MONTH)+1);
    }
}
