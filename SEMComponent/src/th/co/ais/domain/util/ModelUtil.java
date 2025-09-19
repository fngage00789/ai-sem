package th.co.ais.domain.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import th.co.ais.domain.common.CommonUtils;

public class ModelUtil {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ModelUtil.class);

	/** The instance. */
	private static ModelUtil instance = new ModelUtil();

	/**
	 * Private constructor.
	 */
	private ModelUtil() {
	}

	/**
	 * Singleton instance accessor.
	 * 
	 * @return ModelUtil
	 */
	public static ModelUtil getInstance() {
		return instance;
	}

	/**
	 * Sort a List of same class instance with specified fieldNames order. (Not
	 * supporting field in superClass hierarchy yet)
	 * 
	 * @param dataList
	 *            a List to be sorted
	 * @param pathResolver
	 *            * Simple (name) - The specified name identifies an individual
	 *            property of a particular JavaBean. The name of the actual
	 *            getter or setter method to be used is determined using
	 *            standard JavaBeans instrospection, so that (unless overridden
	 *            by a BeanInfo class, a property named "xyz" will have a getter
	 *            method named getXyz() or (for boolean properties only)
	 *            isXyz(), and a setter method named setXyz(). 
	 *            
	 *            * Nested(name1.name2.name3) The first name element is used to select a
	 *            property getter, as for simple references above. The object
	 *            returned for this property is then consulted, using the same
	 *            approach, for a property getter for a property named name2,
	 *            and so on. The property value that is ultimately retrieved or
	 *            modified is the one identified by the last name element.
	 *            
	 *            * Indexed (name[index]) - The underlying property value is
	 *            assumed to be an array, or this JavaBean is assumed to have
	 *            indexed property getter and setter methods. The appropriate
	 *            (zero-relative) entry in the array is selected. List objects
	 *            are now also supported for read/write. You simply need to
	 *            define a getter that returns the List 
	 *            
	 *            * Mapped (name(key)) - The
	 *            JavaBean is assumed to have an property getter and setter
	 *            methods with an additional attribute of type java.lang.String.
	 *            Combined (name1.name2[index].name3(key)) - Combining mapped,
	 *            nested, and indexed references is also supported.
	 * 
	 * @param ascending
	 *            ascending order
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("unchecked")
	public void sortList(final List dataList, final String[] pathResolver,
			final boolean ascending) throws Exception {
		if (dataList == null || dataList.size() < 2) {
			return;
		}
		
		Comparator comparator = new Comparator() {
			private int factor = ascending ? 1: -1;

			public int compare(final Object obj1, final Object obj2) {

				try {
					PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
					for (int fIdx = 0; fIdx < pathResolver.length; fIdx++) {
						Comparable value1 = (Comparable) propertyUtilsBean.getProperty(obj1, pathResolver[fIdx]);
						Comparable value2 = (Comparable) propertyUtilsBean.getProperty(obj2, pathResolver[fIdx]);
						int result = 0;
						result = CommonUtils.compareObj(value1, value2);
						if(result != 0){
							return result*factor;
						}
					}
				} catch (Exception ex) {
					return 0;
				}
				return 0;
			}
		};
		
		Collections.sort(dataList, comparator);
	}
}
