package th.co.ais.domain.common;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import net.sf.beanlib.hibernate3.Hibernate3BeanReplicator;

import org.apache.commons.beanutils.BeanUtilsBean2;
import org.apache.commons.beanutils.NestedNullException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.validator.GenericValidator;
import org.hibernate.Hibernate;
import org.hibernate.collection.PersistentSet;
import org.hibernate.proxy.HibernateProxy;

import th.co.ais.domain.annotation.Convenience;
import th.co.ais.domain.util.ModelUtil;

public class CommonUtils {

	private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new HashMap<Class<?>, Class<?>>();
	
	private static final Map<String, Method> mapReadMethod = new Hashtable<String, Method>();
	private static final Map<String, Method> mapWriteMethod = new Hashtable<String, Method>();
	private static final Object[] NULL_PARAM = new Object[] { null };
	public static final CompareNullMode DEFAULT_NULL_MODE = CompareNullMode.NullBigger;

	public enum CompareNullMode {
		IgnoreNull, NullSmaller, NullBigger
	};

	static {
		primitiveWrapperTypeMap.put(Boolean.class, boolean.class);
		primitiveWrapperTypeMap.put(Byte.class, byte.class);
		primitiveWrapperTypeMap.put(Character.class, char.class);
		primitiveWrapperTypeMap.put(Double.class, double.class);
		primitiveWrapperTypeMap.put(Double.class, float.class);
		primitiveWrapperTypeMap.put(Integer.class, int.class);
		primitiveWrapperTypeMap.put(Long.class, long.class);
		primitiveWrapperTypeMap.put(Short.class, short.class);
	}

	public static boolean isFlatClazz(Class<?> clazz) {

		if (clazz.isPrimitive() || primitiveWrapperTypeMap.containsKey(clazz) || clazz.equals(String.class) || clazz.equals(Date.class)
				|| clazz.equals(Calendar.class)) {
			return true;
		}
		return false;
	}

	

	public static Class<?> getGenericClass(Type paramType) {
		Class<?> genericType = null;
		if (paramType != null && paramType instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) paramType;
			genericType = (Class<?>) parameterizedType.getActualTypeArguments()[0];
		} else {
			genericType = (Class<?>) paramType;
		}
		return genericType;
	}

	public static int compareObjById(Object obj1, Object obj2) {
		return compareObjById(obj1, obj2, DEFAULT_NULL_MODE);
	}

	public static int compareObjById(Object obj1, Object obj2, CompareNullMode nullMode) {
		return compareObjById(obj1, obj2, "id", nullMode);
	}

	public static int compareObjById(Object obj1, Object obj2, String idName) {
		return compareObjById(obj1, obj2, idName, DEFAULT_NULL_MODE);
	}

	public static int compareObjById(Object obj1, Object obj2, String idName, CompareNullMode nullMode) {
		Object objId1;
		Object objId2;
		try {
			if (isSomeObjNull(obj1, obj2)) {
				return compareNullObj(obj1, obj2, nullMode);
			}
			objId1 = getReadMethod(obj1.getClass(), idName).invoke(obj1);
			objId2 = getReadMethod(obj2.getClass(), idName).invoke(obj2);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot compare id from " + obj1.getClass() + " and " + obj2.getClass() + " with id :" + idName);
		}
		return CommonUtils.compareObj(objId1, objId2, nullMode);
	}


	public static boolean isSomeObjNull(Object obj1, Object obj2) {
		return (obj1 == null) || (obj2 == null);
	}

	public static int compareNullObj(Object obj1, Object obj2, CompareNullMode nullMode) {
		if (obj1 == null && obj2 == null) {
			switch (nullMode) {
			case IgnoreNull:
				return 0;
			case NullSmaller:
				return -1;
			case NullBigger:
				return 1;
			}
		}
		if (obj1 != null && obj2 == null) {
			switch (nullMode) {
			case IgnoreNull:
				return 0;
			case NullSmaller:
				return 1;
			case NullBigger:
				return -1;
			}
		}
		if (obj1 == null && obj2 != null) {
			switch (nullMode) {
			case IgnoreNull:
				return 0;
			case NullSmaller:
				return -1;
			case NullBigger:
				return 1;
			}
		}
		throw new RuntimeException("No NULL Object");
	}

	public static int compareObj(Object objId1, Object objId2) {
		return compareObj(objId1, objId2, DEFAULT_NULL_MODE);
	}

	@SuppressWarnings("unchecked")
	public static int compareObj(Object objId1, Object objId2, CompareNullMode nullMode) {
		if (isSomeObjNull(objId1, objId2)) {
			return compareNullObj(objId1, objId2, nullMode);
		}
		if (Long.class.isAssignableFrom(objId1.getClass()) && Long.class.isAssignableFrom(objId2.getClass())) {
			return compareLongId((Long) objId1, (Long) objId2);
		} else if (Comparable.class.isAssignableFrom(objId1.getClass()) && Comparable.class.isAssignableFrom(objId2.getClass())) {
			return ((Comparable) objId1).compareTo(objId2);
		}
		throw new RuntimeException("Cannot compare id from " + objId1.getClass() + " and " + objId2.getClass());
	}

	public static boolean isEqualById(Object obj1, Object obj2) {
		return isEqualById(obj1, obj2, "id");
	}

	public static boolean isEqualById(Object obj1, Object obj2, String idName) {
		Object objId1;
		Object objId2;
		try {
			if (obj1 == null && obj2 == null) {
				return true;
			}
			if (obj1 != null && obj2 == null) {
				return false;
			}
			if (obj1 == null && obj2 != null) {
				return false;
			}
			if (!obj1.getClass().isAssignableFrom(obj2.getClass()) && !obj2.getClass().isAssignableFrom(obj1.getClass())) {
				return false;
			}
			objId1 = getReadMethod(obj1.getClass(), idName).invoke(obj1);
			objId2 = getReadMethod(obj2.getClass(), idName).invoke(obj2);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot equal id from " + obj1.getClass() + " and " + obj2.getClass() + " with id :" + idName);
		}
		return CommonUtils.isObjEqual(objId1, objId2);
	}

	public static boolean isObjEqual(Object obj1, Object obj2) {
		if ((obj1 != null && obj2 == null) || (obj1 == null && obj2 != null)) {
			return false;
		}
		if (obj1 == null && obj2 == null) {
			return true;
		}
		if (obj1 == null) {
			return obj2.equals(obj1);
		}
		if (obj1 instanceof String && obj2 instanceof String) {
			return ((String) obj1).trim().equals(((String) obj2).trim());
		}
		return obj1.equals(obj2);
	}

	public static int compareLongId(long id1, long id2) {
		Long objId1 = Long.class.cast(id1);
		Long objId2 = Long.class.cast(id2);
		if (objId1 == null && objId2 == null) {
			return 0;
		}
		if (objId1 != null && objId2 == null) {
			return 1;
		}
		if (objId1 == null && objId2 != null) {
			return -1;
		}
		return objId1.compareTo(objId2);
	}

	/**
	 * Deep Clone an Object using ByteArrayInput(Output)Stream
	 * 
	 * @param obj
	 *            Object that will be cloned , success is depend on serializable
	 * @return Cloned Object
	 * @throws IOException
	 *             if Object cannot clone
	 * @throws ClassNotFoundException
	 *             if Object cannot clone
	 */
	public static Object deepClone(Object obj) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
		objectOutputStream.writeObject(obj);
		objectOutputStream.flush();
		objectOutputStream.close();
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(in);
		Object object = objectInputStream.readObject();
		objectInputStream.close();
		return object;
	}

	/**
	 * Deep Clone Collection which is store one level of Object
	 * 
	 * @param srcCollection
	 * @return returnCollection
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Collection deepCloneCollection(Collection srcCollection) throws Exception {
		Collection returnCollection = null;
		Object obj;
		Iterator<?> iterator = srcCollection.iterator();
		if (srcCollection != null) {
			returnCollection = getDefaultCollectionInstant(srcCollection.getClass());
			while (iterator.hasNext()) {
				obj = iterator.next();
				returnCollection.add(deepClone(obj));
			}
		}
		return returnCollection;
	}


	public static <T> T resolveProxy(Object proxyObj, Class<T> clazz) throws Exception {
		return new Hibernate3BeanReplicator().deepCopy(proxyObj, clazz);
	}

	public static <T> T shallowCopy(Object proxyObj, Class<T> clazz) throws Exception {
		return new Hibernate3BeanReplicator().shallowCopy(proxyObj, clazz);
	}

	public static boolean isWritable(Field field) {
		int modifier = field.getModifiers();
		if (Modifier.isFinal(modifier) || Modifier.isStatic(modifier) || Modifier.isTransient(modifier)) {
			return false;
		}
		return true;
	}

	public static Method getSetterMethod(Method getterMethod) throws Exception {
		Class<?> clazz = getterMethod.getDeclaringClass();
		Method setterMethod;
		if (getterMethod.getName().startsWith("get")) {
			setterMethod = clazz.getMethod(getterMethod.getName().replaceFirst("get", "set"), getterMethod.getReturnType());
		} else {
			setterMethod = clazz.getMethod(getterMethod.getName().replaceFirst("is", "set"), getterMethod.getReturnType());
		}
		return setterMethod;
	}

	@SuppressWarnings("unchecked")
	public static Collection getDefaultCollectionInstant(Class clazz) throws Exception {
		Collection collection;
		if (clazz.isInterface() && List.class.isAssignableFrom(clazz)) {
			collection = ArrayList.class.newInstance();
		} else if (PersistentSet.class.isAssignableFrom(clazz)) {
			collection = HashSet.class.newInstance();
		} else if (clazz.isInterface() && SortedSet.class.isAssignableFrom(clazz)) {
			collection = TreeSet.class.newInstance();
		} else if (clazz.isInterface() && Set.class.isAssignableFrom(clazz)) {
			collection = HashSet.class.newInstance();
		} else if (clazz.isInterface() && Queue.class.isAssignableFrom(clazz)) {
			collection = LinkedList.class.newInstance();
		} else {
			collection = (Collection) clazz.newInstance();
		}
		return collection;
	}


	public static int countNestedLayer(String elExpression) {
		return elExpression.split("\\.").length;
	}

	public static boolean isNullOrEmpty(String obj) {
		return GenericValidator.isBlankOrNull(obj);
	}

	public static String trimToNull(String str) {
		if (str != null && str.trim().length() == 0) {
			return null;
		}
		return str;
	}

	public static boolean isCollectionNotEmpty(Collection<?> collection) {
		return collection != null && !collection.isEmpty();
	}

	/**
	 * Return true is collection is null OR empty.
	 * 
	 * @param collection
	 * @return
	 */
	public static boolean isCollectionEmpty(Collection<?> collection) {
		return !isCollectionNotEmpty(collection);
	}

	public static boolean isCollectionNull(Collection<?> collection) {
		return collection == null;
	}

	public static boolean isCollectionSizeGreaterThanZero(Collection<?> collection) {
		return isCollectionNotEmpty(collection) && collection.size() > 0;
	}

	public static String getFieldNameFromGetterMethod(String getterMethodName) {
		String fieldName;
		if (getterMethodName.startsWith("get")) {
			fieldName = getterMethodName.replaceFirst("get", "");
		} else if (getterMethodName.startsWith("is")) {
			fieldName = getterMethodName.replaceFirst("is", "");
		} else {
			fieldName = getterMethodName;
		}
		return getCamelCase(fieldName);
	}

	public static String getCamelCase(String field) {
		return field.replaceFirst(field.substring(0, 1), field.substring(0, 1).toLowerCase());
	}

	public static <T> T selectSingleFromCollection(Collection<T> inputCollection, Class<T> clazz, String fieldName, Object... possibleValues) {
		List<T> selectList = selectFromCollection(inputCollection, clazz, fieldName, possibleValues);
		if (selectList.size() == 0) {
			return null;
		} else if (selectList.size() == 1) {
			return selectList.get(0);
		}
		throw new RuntimeException("Invalid collection, selected data not contain single record");
	}

	public static <T> List<T> selectFromCollection(Collection<T> inputCollection, Class<T> clazz, String fieldName, Object... possibleValues) {
		return selectFromCollection(inputCollection, clazz, fieldName, true, possibleValues);
	}

	public static <T> List<T> selectFromCollection(Collection<T> inputCollection, Class<T> clazz, String fieldName, boolean isInclude,
			Object... possibleValues) {
		Object fieldValue;
		Method readMethod;
		List<T> selectList = new ArrayList<T>();
		List<?> possibleValueList = Arrays.asList(possibleValues);
		if (inputCollection != null) {
			try {
				readMethod = getReadMethod(clazz, fieldName);
				for (T element : inputCollection) {
					fieldValue = readMethod.invoke(element);
					if (isInclude ? possibleValueList.contains(fieldValue) : !possibleValueList.contains(fieldValue)) {
						selectList.add(element);
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return selectList;
	}

	public static List<Object> selectFieldFromCollection(Collection<?> inputCollection, String elExpression) {
		List<Object> fieldList = new ArrayList<Object>();
		if (inputCollection != null) {
			try {
				for (Object element : inputCollection) {
					fieldList.add(getPropertyEL(element, elExpression));
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return fieldList;
	}

	public static <T> int countFromCollection(Collection<T> inputCollection, Class<T> clazz, String fieldName, Object... possibleValues) {
		Object fieldValue;
		Method readMethod;
		int found = 0;
		List<?> possibleValueList = Arrays.asList(possibleValues);
		if (inputCollection != null) {
			try {
				readMethod = getReadMethod(clazz, fieldName);
				for (T element : inputCollection) {
					fieldValue = readMethod.invoke(element);
					if (possibleValueList.contains(fieldValue)) {
						found++;
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return found;
	}

	@SuppressWarnings("unchecked")
	public static boolean isExistInCollection(Collection<?> inputCollection, Class<?> clazz, String fieldName, Object... possibleValues) {
		Object fieldValue;
		Method readMethod;
		List possibleValueList = Arrays.asList(possibleValues);
		if (inputCollection != null) {
			try {
				readMethod = getReadMethod(clazz, fieldName);
				for (Object element : inputCollection) {
					fieldValue = readMethod.invoke(element);
					if (possibleValueList.contains(fieldValue)) {
						return true;
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public static boolean isExistInCollection(Collection<?> inputCollection, Object... possibleValues) {
		List possibleValueList = Arrays.asList(possibleValues);
		if (inputCollection != null) {
			for (Object element : inputCollection) {
				if (possibleValueList.contains(element)) {
					return true;
				}
			}
		}
		return false;
	}


	public static Method getReadMethod(Class<?> clazz, String fieldName) {
		String key = clazz.getName() + fieldName;
		Method readMethod;
		try {
			readMethod = mapReadMethod.get(key);
			if (readMethod == null) {
				readMethod = new PropertyDescriptor(fieldName, clazz).getReadMethod();
				mapReadMethod.put(key, readMethod);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return readMethod;
	}

	public static Method getWriteMethod(Class<?> clazz, String fieldName) {
		String key = clazz.getName() + fieldName;
		Method writeMethod;
		try {
			writeMethod = mapWriteMethod.get(key);
			if (writeMethod == null) {
				writeMethod = new PropertyDescriptor(fieldName, clazz).getWriteMethod();
				mapWriteMethod.put(key, writeMethod);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return writeMethod;
	}


	public static void sortList(List<?> list, boolean ascending, String... pathResolver) throws Exception {
		ModelUtil.getInstance().sortList(list, pathResolver, ascending);

	}

	public static void setPropertyEL(Object obj, String ELPath, Object value) {
		try {
			BeanUtilsBean2.getInstance().getPropertyUtils().setProperty(obj, ELPath, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Object getPropertyEL(Object obj, String ELPath) {
		return getPropertyEL(obj, ELPath, true);
	}

	public static Object getPropertyEL(Object obj, String ELPath, boolean isAllowNull) {
		Object rst = null;
		try {
			rst = BeanUtilsBean2.getInstance().getPropertyUtils().getProperty(obj, ELPath);
		} catch (Exception e) {
			if (e instanceof IllegalAccessException || e instanceof NestedNullException) {
				if (isAllowNull) {
					rst = null;
				} else {
					throw new RuntimeException(e);
				}
			}
		}
		return rst;
	}

	public static String escapeLikeExpression(String input) {
		if (input != null && input.trim().length() > 0) {
			return input.replaceAll("!", CommonConstant.ESCAPE_CHARACTER + "!").replaceAll("%", CommonConstant.ESCAPE_CHARACTER + "%")
					.replaceAll("_", CommonConstant.ESCAPE_CHARACTER + "_");
		}
		return input;
	}

	public static String toStringIfNotNull(Object obj, String... nestedField) {
		if (obj == null) {
			return null;
		}
		if (obj instanceof String) {
			return !isNullOrEmpty(obj.toString()) ? obj.toString() : null;
		}
		if (nestedField != null && nestedField.length > 0 && !isNullOrEmpty(nestedField[0])) {
			try {
				for (String element : nestedField) {
					obj = getReadMethod(obj.getClass(), element).invoke(obj);
				}
				return (String) obj;
			} catch (Exception e) {

			}
		}

		return null;
	}

	public static boolean isNumberZero(Number number) {

		return Integer.valueOf(number.intValue()).equals(NumberUtils.INTEGER_ZERO)
				|| Double.valueOf(number.doubleValue()).equals(NumberUtils.DOUBLE_ZERO)
				|| Long.valueOf(number.longValue()).equals(NumberUtils.LONG_ZERO)
				|| Float.valueOf(number.floatValue()).equals(NumberUtils.FLOAT_ZERO);
	}

	/**
	 * Limit length of String
	 * 
	 * @param source
	 * @param maxLength
	 * @return source.substring(0, maxLength), null will be returned if source is null.
	 */
	public static String limitLength(String source, int maxLength) {
		if (source != null) {
			if (source.length() > maxLength) {
				return source.substring(0, maxLength);
			}
		}
		return source;
	}

	/**
	 * Trim string
	 * 
	 * @param param
	 * @return new String which has been trim, the empty string will be return in case of null or empty String.
	 */
	public static String getTrim(String param) {
		return isNullOrEmpty(param) ? "" : param.trim();
	}

	/**
	 * Utility method that tries to properly initialize the Hibernate CGLIB proxy.
	 * 
	 * @param <T>
	 * @param maybeProxy
	 *            -- the possible Hibernate generated proxy
	 * @param baseClass
	 *            -- the resulting class to be cast to.
	 * @return the object of a class <T>
	 * @throws ClassCastException
	 */
	public static <T> T recast(Object maybeProxy, Class<T> baseClass) throws ClassCastException {
		if (maybeProxy instanceof HibernateProxy) {
			return baseClass.cast(((HibernateProxy) maybeProxy).getHibernateLazyInitializer().getImplementation());
		}
		return baseClass.cast(maybeProxy);
	}

	/**
	 * Force to initialize proxy object. (Avoid invocation error.)
	 * 
	 * @param proxy
	 *            proxy object.
	 */
	public static void initailizeProxy(Object object) {
		if (!Hibernate.isInitialized(object)) {
			Hibernate.initialize(object);
		}
	}
	
	public static boolean isGetterObjectMethod(Method method) {
		return (method.getModifiers() == Modifier.PUBLIC || method.getModifiers() == Modifier.PROTECTED)
				&& method.getParameterTypes().length == 0 && (method.getName().startsWith("get") || method.getName().startsWith("is"))
				&& method.getParameterTypes().length == 0 && !CommonUtils.isFlatClazz(method.getReturnType())
				&& method.getAnnotation(Convenience.class) == null;
	}
	
	public static boolean isNotBlankValue(Object object) {
		return !isBlankValue(object);
	}

	public static boolean isBlankValue(Object object) {

		boolean isBlankValue = true;

		if (object != null) {
			if (object instanceof String) {
				String stringObject = (String) object;
				if (StringUtils.isNotEmpty(stringObject) && StringUtils.isNotBlank(stringObject)
						&& stringObject.trim().length() > 0 && !StringUtils.equals(stringObject, "null")) {

					isBlankValue = false;
				}

			} else {
				isBlankValue = false;
			}
		}

		return isBlankValue;
	}
	
	public static String convertString4FullTxtSrch(String arg0) throws Exception {
		if (CommonUtils.isNotBlankValue(arg0)) {
			if (arg0.indexOf("*") > -1) {
				arg0 = arg0.replace("*", "%");
			}

			if (!arg0.startsWith("%")) {
				arg0 = "%" + arg0;
			}

			if (!arg0.endsWith("%")) {
				arg0 = arg0 + "%";
			}
		}

		return arg0;
	}
	
	public static String joinString(List<String> list, String separator) {
		if(list == null || list.isEmpty())
			return null;
		
		String[] array = list.toArray(new String[list.size()]);
		return StringUtils.join(array, separator);
	}
}
