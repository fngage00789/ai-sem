package th.co.ais.rpt.util;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import org.apache.log4j.Logger;

public class BeanReflexUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(BeanReflexUtil.class);
	private static final HashMap<Thread, Long> indentCounter = new HashMap<Thread, Long>();
	
	
	public static Iterator listLoadedClass() {
		return listLoadedClass(Thread.currentThread().getContextClassLoader());
	}
	@SuppressWarnings("unchecked")
	public static Iterator listLoadedClass(ClassLoader cl) {
		Vector classes = new Vector();
		try {
			Class clClass = cl.getClass();
			while (clClass != java.lang.ClassLoader.class) {
				clClass = clClass.getSuperclass();
			}
			java.lang.reflect.Field classFld = clClass.getDeclaredField("classes");
			classFld.setAccessible(true);
			classes.addAll((Vector)classFld.get(cl));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classes.iterator();
	}
	
	private static synchronized String nextIndent() {
		Long indentLevelObj = indentCounter.get(Thread.currentThread());
		long indentLevel = 0;
		if(indentLevelObj != null) {
			indentLevel = indentCounter.get(Thread.currentThread()).longValue();
		}
		
		StringBuffer strIndent = new StringBuffer();
		for(int i=0;i<indentLevel;i++) {
			strIndent.append("\t");
		}

		log.trace("Indent is ["+indentLevel+"]");
		indentLevel++;
		indentCounter.put(Thread.currentThread(), new Long(indentLevel));
		return strIndent.toString();
	}
	
	private static synchronized void cancelIndent() {
		long indenLevel = indentCounter.get(Thread.currentThread()).longValue();
		if(indenLevel>0) {
			indenLevel--;
		} else {
			log.warn("Indent cannot be lower 0[Thread "+Thread.currentThread()+"]");
		}
		log.trace("Indent is ["+indenLevel+"]");
		indentCounter.put(Thread.currentThread(), new Long(indenLevel));
	}

	@SuppressWarnings("unchecked")
	public static BigDecimal castToBigDecimal(Number number) {
		BigDecimal result = null;
		
		if(number != null) {
			result = new BigDecimal(number.toString());
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	public static BigDecimal castToBigDecimal(String number) {
		BigDecimal result = null;
		
		if(number != null) {
			result = new BigDecimal(number);
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	public static String castToString(Object bean) {
		String indentStr = nextIndent();
		StringBuffer strBuffer = new StringBuffer();
		
		if(bean != null) {
			Class cls = null;
			Class beanClass = bean.getClass();
			if(!beanClass.getName().startsWith("java.")) {
				strBuffer.append("Values of class -[[").append(beanClass.getName()).append("]]- are \n");
				try {
					cls = Class.forName(beanClass.getName(), false, beanClass.getClassLoader());
				} catch (Exception e) {
					log.info("Unable to load class by Class.forName, use current loaded class");
					cls = beanClass;
				}
				
				List<Method>methodLST = new ArrayList<Method>();
				
				Class supCls = cls;
				while(supCls!=null) {
					log.debug("SuperClass is " + supCls.getName());
					
					
					if(supCls.
							getName().
							startsWith("java")) {
						supCls = null;
					} else {
						methodLST.addAll(Arrays.asList(supCls.getDeclaredMethods()));
						supCls = supCls.getSuperclass();
					}
				}
				
				Method methods[] = (Method[])methodLST.toArray(new Method[methodLST.size()]);

				Arrays.sort(methods, new Comparator(){
					public int compare(Object o1, Object o2) {
						Method m1 = ((Method)o1); 
						Method m2 = ((Method)o2);
						return m1.getName().compareToIgnoreCase(m2.getName());
					}
				});
				
				for(int i=0;i<methods.length;i++) {
					String mthNameFull = methods[i].getName();
					int mod = methods[i].getModifiers();
					if((mod & Modifier.PUBLIC) != 0) {
						if(mthNameFull.startsWith("get")) {
							String mthName = mthNameFull.substring(3);
							if(methods[i].getParameterTypes().length == 0) {
								strBuffer.append(indentStr);
								strBuffer.append(mthName).append(" : ").append("\t");
								try {
									strBuffer.append(castToString(methods[i].invoke(bean, new Object[0])));
								} catch (Exception e) {
									strBuffer.append("#ERROR:").append(e.getMessage()).append("#");
								}
								strBuffer.append("\n");
							}
						}
					}
				}
			} else 
			if(bean instanceof java.util.Date) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.US);
				strBuffer.append(sdf.format(bean));
			} else {
				strBuffer.append(bean);
			}
		} else {
			strBuffer.append("<null>");
		}
		
		cancelIndent();
 
		return strBuffer.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println("BigDecimal is " + castToBigDecimal(30.8347d));
		System.out.println("BigDecimal is " + castToBigDecimal(30));
		System.out.println("BigDecimal is " + castToBigDecimal(31l));
		System.out.println("BigDecimal is " + castToBigDecimal(35.727f));
		System.out.println("BigDecimal is " + castToBigDecimal(0));
	}
	
	
	public static void printAnnotation(Object obj) {
		Class cls = obj.getClass();
		{
			Annotation anno[] = cls.getAnnotations();
			for(int i=0;i<anno.length;i++) {
				System.out.println(cls+"#"+anno[i]);
			}
		}
		{
			java.lang.reflect.Field flds[] = cls.getDeclaredFields();
			for(int j=0;j<flds.length;j++) {
				Annotation anno[] = flds[j].getAnnotations();
				for(int i=0;i<anno.length;i++) {
					System.out.println(cls+"."+flds[j].getName()+"#"+anno[i]);
				}
			}
		}
		{
			java.lang.reflect.Method mthds[] = cls.getDeclaredMethods();
			for(int j=0;j<mthds.length;j++) {
				Annotation anno[] = mthds[j].getAnnotations();
				for(int i=0;i<anno.length;i++) {
					System.out.println(cls+"."+mthds[j].getName()+"#"+anno[i]);
				}
			}
		}
	}
	
	public static void setField(java.lang.reflect.Field fld, Object obj, Object val) {
		try {
			fld.setAccessible(true);
			int mod = fld.getModifiers(); 
			
			if((mod&Modifier.FINAL) != 0) {
				//cancel to set final field.
				return;
			}
			if("ROWID".equalsIgnoreCase(fld.getName())) {
				val = null;
			}
			
			log.debug("set "+obj.getClass()+"."+fld.getName()+"<"+fld.getType()+">" + " as "+ val);
			fld.set(obj, val);
		} catch (Exception e) {
			log.debug("", e);
		}
	}
	
	
	public static void setAllFieldValue(Object obj, List<BeanReflexUtil.ObjectFieldValue> fieldValues) {
		if(obj!=null) {
			Class objClass = obj.getClass();
			Field flds[] = objClass.getDeclaredFields();
			for(Iterator i=fieldValues.iterator();
				i.hasNext();) {
				BeanReflexUtil.ObjectFieldValue fieldValue =  (BeanReflexUtil.ObjectFieldValue) i.next();
				setField(fieldValue.getField(), obj, fieldValue.getValueObj());
			}
		}
	}
	 
	public static String toGetterName(String name) {
		StringBuffer sb = new StringBuffer("get");
		sb.append(name.toUpperCase().charAt(0));
		sb.append(name.substring(1));
		
		return sb.toString();
	}
	
	public static String toBeanName(String name) {
		StringBuffer sb = new StringBuffer("");
		sb.append(name.toLowerCase().charAt(0));
		sb.append(name.substring(1));
		
		return sb.toString();
	}
	
	
	public static List<ObjectFieldValue> getAllFieldValue(Object obj) {
		List<ObjectFieldValue> result = new ArrayList<ObjectFieldValue>();
		
		if(obj!=null) {
			Class objClass = obj.getClass();
			Field flds[] = objClass.getDeclaredFields();
			for(int i=0;i<flds.length;i++) {
				flds[i].setAccessible(true);
				Object value = null;
				try {
					value = flds[i].get(obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
				result.add(new ObjectFieldValue(flds[i], value));
			}
		}
		
		return result;
	}
	
	public static class BeanReflex {
		private List<ObjectFieldValue> allFields = new ArrayList<ObjectFieldValue>(); 
		private Class beanClass = null;
		
		public BeanReflex(Object obj) {
			allFields.clear();
			if(obj!=null) {
				beanClass = obj.getClass();
				allFields.addAll(BeanReflexUtil.getAllFieldValue(obj));
			}
		}
		public List<ObjectFieldValue> getAllFields() {
			return allFields;
		}
		public Class getBeanClass() {
			return beanClass;
		}
	}
	
	
	public static class ObjectFieldValue {
		private Object value;
		private Field field;
		
		public ObjectFieldValue(Field field, Object value) {
			this.field = field;
			this.value = value;
		}
		public Field getField() {
			return field;
		}
		public String getName() {
			return field.getName();
		}
		public String getValueAsString() {
			return value.toString();
		}
		public Object getValueObj() {
			return value;
		}
		public void setValueByString(String valueStr) {
			Class type = field.getType();
			if(type.equals(String.class)) {
				value = valueStr;
			} else
			if(type.equals(Long.class)) {
				value = new Long(valueStr);
			} else
			if(type.equals(BigInteger.class)) {
				value = new BigInteger(valueStr);
			} else
			if(type.equals(BigInteger.class)) {
				value = new BigInteger(valueStr);
			} else {
				try {
					Constructor construct = type.getConstructor(new Class[]{String.class});
					value = construct.newInstance(new Object[]{valueStr});
				} catch (Exception e) {
					throw new RuntimeException("Error when try to reflex "+type+"(String)", e);
				}
				
			}
		}
		public void setValueObj(Object value) {
			Class type = field.getType();
			if(type.equals(value.getClass())) {
				this.value = value;
			} else {
				throw new RuntimeException("Not support to set difference type object to field");
			}
		}
		public boolean isEditable() {
			int mod = field.getModifiers(); 
			
			if((mod&Modifier.FINAL) != 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static boolean validateCastType(Class srcClass, Class tgtClass) {
		log.debug("Invoke validateCastType(" + srcClass + "," +tgtClass+")");
		if(tgtClass!=null) {
			while(srcClass!=null) {
				if(tgtClass.equals(srcClass)) {
					return true;
				}
				srcClass = srcClass.getSuperclass();
			}
		}
		return false;
	}
	
	public static Field getDeepField(Class cls, String fieldName) throws NoSuchFieldException {
		Field fld = null;
		{
			NoSuchFieldException lastNoSuchFieldException = null;
			Class tgtCls = cls;
			while(tgtCls!=null) {
				try {
					fld = tgtCls.getDeclaredField(fieldName);
				} catch (NoSuchFieldException e1) {
					lastNoSuchFieldException = e1;
				}
				tgtCls = tgtCls.getSuperclass();
			}
			
			if(fld == null) {
				throw lastNoSuchFieldException;
			}
		}
		return fld;
	}
	
	private static Field getFieldOfClass(String srcFieldNames[], int levelNo, Class srcClass) {
		log.debug("Invoke");
		
		{
			Class cls = null;
			try {
				cls = Class.forName(srcClass.getName());
			} catch (Exception e) {
				cls = srcClass;
			}
			
			
			String fullTarget = null;
			String currTarget = srcFieldNames[levelNo];

			if(log.isTraceEnabled()) {
				StringBuffer sb = new StringBuffer(0);
				for(int i=0;i<=levelNo;i++) {
					if(sb.length()>0) {
						sb.append(".");
					}
					sb.append(srcFieldNames[i]);
				}
				fullTarget = sb.toString();
				
				log.trace("fullTarget is ["+fullTarget+"] of " + cls);
				log.trace("levelNo is ["+levelNo+"] ");
				log.trace("setField at ["+currTarget+"] of " + cls);
			}
			
			Field fld = null;
			{
				try {
					fld = getDeepField(cls, currTarget);
				} catch (NoSuchFieldException e1) {
					if(fullTarget == null) {
						StringBuffer sb = new StringBuffer(0);
						for(int i=0;i<=levelNo;i++) {
							if(sb.length()>0) {
								sb.append(".");
							}
							sb.append(srcFieldNames[i]);
						}
						fullTarget = sb.toString();
					}	
					throw new RuntimeException("Not found field \"" + currTarget + "\" from " + cls + " (full target is "+ fullTarget +")", e1);
				}
			}
			
			fld.setAccessible(true);
			Class fieldType = fld.getType();
			
			
			//Final step
			levelNo++;
			if(levelNo < srcFieldNames.length) {
				log.trace("set nested field as " + fieldType);
				return getFieldOfClass(srcFieldNames, levelNo, fld.getType());
			} else {
				log.trace("set terminal field");
				return fld;
			}
		}
	}
	
	public static Field getFieldOfClass(String targetFieldName, Class srcClass) {
		log.debug("get field info ["+targetFieldName+"] from " + srcClass);
		return getFieldOfClass(targetFieldName.split("[.]"), 0, srcClass);
	}
	
	@SuppressWarnings("unchecked")
	public static Annotation getClassAnnoted(Class cls, Class annotationClass) {
		if(log.isDebugEnabled()) {
			log.debug("Invoke("+cls+")");
		}
		
		Class tmpCls = cls;
		Annotation anno = null;
		while(tmpCls != null) {
			anno = tmpCls.getAnnotation(annotationClass);
			if(anno!=null) {
				if(log.isDebugEnabled()) {
					log.debug("Found annotation " + BeanReflexUtil.castToString(anno));
				}
				break;
			}
		}
		
		return anno;
	}
	
	public static Date castToDate(String dateString, String dateFormat, Locale locale) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, locale);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse \""+dateString+"\" to date with pattern \""+dateFormat+"\"", e);
		}
	}

	public static Date castToDate(String dateString, String dateFormat) {
		return castToDate(dateString, dateFormat, Locale.getDefault());
	}

	public static Long castToLong(BigDecimal num) {
		if(num == null) return null;
		
		return num.longValue();
	}
}
