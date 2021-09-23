package org.barista.framework.utils;


import com.fasterxml.uuid.Generators;
import org.hibernate.id.UUIDGenerator;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.util.*;
import java.util.Map.Entry;

public class Utils {

    public static Timestamp getNow() {
        return DateUtil.getNow();
    }

    public static Object[] concatenateWithDuplicate(Object[] arrObj1, Object[] arrObj2) {
        if ((arrObj1 != null) && (arrObj2 == null)) {
            return arrObj1;
        }

        if ((arrObj1 == null) && (arrObj2 != null)) {
            return arrObj2;
        }

        if ((arrObj1 == null) && (arrObj2 == null)) {
            return null;
        }

        int nSize1 = arrObj1.length;
        int nSize2 = arrObj2.length;

        // Arrray 영역을 새로 잡는다.
        Object[] arrReturn = (Object[]) Array.newInstance(arrObj1.getClass().getComponentType(),
                nSize1 + nSize2);

        // 첫번째 Array 복사
        System.arraycopy(arrObj1, 0, arrReturn, 0, nSize1);

        // 그 뒤를 이어 두번째 Array 복사
        System.arraycopy(arrObj2, 0, arrReturn, nSize1, nSize2);

        return arrReturn;
    }


    /**
     * Boolean 값을 int로 변환해 주는 함수이다.
     * @param bValue int로 변환하고 싶은 booelan 값
     * @return bValue가 true이면, 1, false면 0
     */
    public static int getIntValue(boolean bValue) {
        return bValue ? 1 : 0;
    }

    /**
     * System 속성 값을 읽어서 출력해 주는 method.
     */
    public static void printSystemProperties() {

        TreeMap<Object, Object> tmProperties = new TreeMap<Object, Object>();
        tmProperties.putAll(System.getProperties());
        Iterator<Entry<Object, Object>> itr = tmProperties.entrySet().iterator();
        Entry<Object, Object> entry = null;

        while (itr.hasNext()) {
            entry = itr.next();
        }
    }

    public static String toString(Throwable t) {
        CharArrayWriter cw = new CharArrayWriter();
        PrintWriter pw = new PrintWriter(cw);
        t.printStackTrace(pw);
        return cw.toString();
    }

    private Utils() {
    }

    /**
     * 두개의 Object 배열을 합친다. merge :
     * @param arr1
     * @param arr2
     * @return
     */
    public static Object[] merge(Object[] arr1, Object[] arr2) {
        if (arr1 == null || arr1.length <= 0)
            if (arr2 == null || arr2.length <= 0)
                return null;
            else
                return arr2;
        else if (arr2 == null || arr2.length <= 0)
            return arr1;

        int nCount = arr1.length + arr2.length;
        Object[] arrReturn = (Object[]) Array.newInstance(arr1[0].getClass(), nCount);
        for (int i = 0; i < nCount; i++) {
            if (i < arr1.length)
                arrReturn[i] = arr1[i];
            else
                arrReturn[i] = arr2[i - arr1.length];
        }

        return arrReturn;
    }


    /**
     * Bit AND연산에 대한 결과값을 리턴한다.
     * @param lLong : 비교할 값
     * @param lLongTarget : 비교대상
     * @return
     */
    public static boolean equalsBitAnd(long lLong, long lLongTarget) {
        return (lLong & lLongTarget) == lLongTarget;
    }

    public static Object[] addObjectToArray(Object[] arrObj1, Object obj) {
        if ((arrObj1 != null) && (obj == null)) {
            return arrObj1;
        }

        if ((arrObj1 == null) && (obj != null)) {
            return new Object[]{obj};
        }

        if ((arrObj1 == null) && (obj == null)) {
            return null;
        }

        arrObj1 = concatenateWithDuplicate(arrObj1, new Object[]{obj});

        return arrObj1;
    }

    public static <T> void addArrayToCollection(Collection<T> list, T[] objs) {

        if (objs == null)
            return;

        for (int i = 0; i < objs.length; i++) {
            list.add(objs[i]);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] getArray( T obj, int size) {
        if( size > 0 && obj != null){
            return (T[]) Array.newInstance(obj.getClass(), size);
        }

        return null;
    }


    public static <T> List<T> toList(T[] arrObj) {
        if (arrObj != null && arrObj.length > 0) {
            return Arrays.asList(arrObj);
        }

        return null;
    }

    public static <T> List<T> toArrayList(T[] arrObj) {
        List<T> list = new ArrayList<T>();
        if (arrObj != null && arrObj.length > 0) {
            for (int i = 0, m = arrObj.length; i < m; i++) {
                list.add(arrObj[i]);
            }
            return list;
        }

        return null;
    }

    public static <T> List<T> toList(Map<String, T> map) {
        List<T> list = new ArrayList<T>();
        String[] keys = null;

        if (map != null) {
            keys = map.keySet().toArray(new String[] {});
            for (int i = 0, m = keys.length; i < m; i++) {
                list.add(map.get(keys[i]));
            }
        }

        return list;
    }


    private static class ReverseComparator<T> implements Comparator<T>, Serializable {
        private static final long serialVersionUID = 1L;

        private Comparator<T> cmp = null;

        public ReverseComparator(Comparator<T> cmp) {
            this.cmp = cmp;
        }

        public int compare(T o1, T o2) {
            return cmp.compare(o2, o1);
        }
    }

    public static <T> Comparator<T> reverseOrder(Comparator<T> cmp) {
        return new ReverseComparator<T>(cmp);
    }

    public static String getFloatRoundString(float f, int decimalPoint)
    {
        int n = 1;

        if ( f >= 100 && decimalPoint > 0 )
        {
            decimalPoint = 0;
        }
		/*
		else if ( f >= 10 && decimalPoint > 0 )
		{
			decimalPoint = 1;
		}*/

        for( int i = 0; i < decimalPoint; i++)
        {
            n *= 10;
        }

        return decimalPoint > 0 ? String.valueOf(((float) Math.round(f * n) / n)) : String.valueOf(Math.round(f)) ;
    }

    public static int getIntegerValue(Object obj)
    {
        if ( obj instanceof BigDecimal )
        {
            return ((BigDecimal)obj).intValue();
        }
        else if ( obj instanceof Integer )
        {
            return ((Integer)obj).intValue();
        }
        else if ( obj instanceof Long)
        {
            return ((Long)obj).intValue();
        }
        else
        {
            throw new RuntimeException("Not Expected Object Type [" + obj.getClass().getName() + "]");
        }
    }

    public static <T> List<T>[] getSplitList(List<T> allList, int maxSize) {
        List<List<T>> result = new ArrayList<List<T>>();
        List<T> subList = null;

        if (allList == null || allList.size() == 0 || maxSize == 0) {
            result.add(new ArrayList<T>());
        } else if (maxSize < 0 || allList.size() < maxSize) {
            result.add(allList);
        } else  {
            int numBatches = (allList.size() / maxSize) + 1;
            for (int index = 0; index < numBatches; index++) {
                int count = index + 1;
                int fromIndex = Math.max(((count - 1) * maxSize), 0);
                int toIndex = Math.min((count * maxSize), allList.size());

                subList = allList.subList(fromIndex, toIndex);
                if (subList != null && subList.size() > 0) {
                    result.add(subList);
                }
            }
        }

        return Utils.toArray(result);
    }

    public static String[][] getSplitArray(String[] array, int size) {
        String[][] result = null;
        String[] subArray = null;
        int index = 0;
        int resultSize = 0;
        int remainder = 0;
        if (array != null) {
            remainder = array.length % size;
            resultSize = array.length / size + (remainder > 0 ? 1 : 0);
            result = new String[resultSize][];
            for (int i = 0; i < resultSize; i++) {
                if (remainder > 0 && (resultSize - 1) == i) {
                    subArray = new String[remainder];
                } else {
                    subArray = new String[size];
                }
                for (int j = 0, n = subArray.length; j < n; j++) {
                    subArray[j] = array[index];
                    index++;
                }
                result[i] = subArray;
            }
        }
        return result;
    }

    /**
     * findElementIndexInArray
     * @param array
     * @param element
     * @return index
     */
    public static int findElementIndexInArray( Object[] array, Object element) {
        if( array != null && array.length > 0 && element != null) {
            for (int i = 0, m = array.length; i < m; i++) {
                if( array[ i] != null && array[ i].equals(element)) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static <T> T[] toArray(T[] arrObj) {
        T[] arrReturn = null;

        if ((arrObj != null) && (arrObj.length > 0)) {
            int nSize = arrObj.length;
            arrReturn = getNewArrayInstance(arrObj[0], nSize);
            System.arraycopy(arrObj, 0, arrReturn, 0, nSize);
        }
        return arrReturn;
    }
    public static <T> T[] toArray(Collection<T> colObj) {
        return toArray(colObj, null);
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(Collection<T> colObj, Class<T> targetClass) {
        T[] arrReturn = null;

        if ((colObj != null) && (colObj.size() > 0)) {
            Iterator<T> itr = colObj.iterator();
            if (targetClass == null) {
                targetClass = (Class<T>) itr.next().getClass();
            }
            // arrReturn = (Object[])
            // java.lang.reflect.Array.newInstance(targetClass, colObj.size());
            arrReturn = getNewArrayInstance(targetClass, colObj.size());
            colObj.toArray(arrReturn);
        }
        return arrReturn;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] getNewArrayInstance(Class<T> clazz, int size) {
        if (size > 0) {
            return (T[]) Array.newInstance(clazz, size);
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] getNewArrayInstance(T obj, int size) {
        if (size > 0 && obj != null) {
            return (T[]) Array.newInstance(obj.getClass(), size);
        }

        return null;
    }

    public static String lpad( String str, int length, String addStr) {
        String result = str;

        if( result == null) {
            result = "";
        }

        int templength   = length - result.length();

        for (int i = 0; i < templength; i++) {
            result = addStr + result;
        }
        return result;
    }


    public static String decryptAES256(String msg, String key) throws Exception {

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ByteBuffer buffer = ByteBuffer.wrap(Base64.getDecoder().decode(msg));
        byte[] saltBytes = new byte[20];
        buffer.get(saltBytes, 0, saltBytes.length);
        byte[] ivBytes = new byte[cipher.getBlockSize()];
        buffer.get(ivBytes, 0, ivBytes.length);
        byte[] encryoptedTextBytes = new byte[buffer.capacity() - saltBytes.length - ivBytes.length];
        buffer.get(encryoptedTextBytes);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(key.toCharArray(), saltBytes, 70000, 256);

        SecretKey secretKey = factory.generateSecret(spec);
        SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(ivBytes));
        byte[] decryptedTextBytes = cipher.doFinal(encryoptedTextBytes);

        return new String(decryptedTextBytes);
    }

    public static String encodeAES128ByElectronic(String str, String aes128Key) throws Exception {
        byte[] keyData = aes128Key.getBytes();
        SecretKey secureKey = new SecretKeySpec(keyData, "AES");
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(aes128Key.getBytes()));
        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
        String enStr = new String(Base64.getEncoder().encode(encrypted));
        return enStr;
    }

    public static String getID() {
        return Generators.timeBasedGenerator().generate().toString().replace("-", "");
    }
}
