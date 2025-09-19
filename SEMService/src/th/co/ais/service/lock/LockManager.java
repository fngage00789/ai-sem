package th.co.ais.service.lock;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;

import th.co.ais.dao.GenericDAO;
import th.co.ais.domain.common.BaseDomain;
import th.co.ais.service.lock.exception.LockingException;
import th.co.ais.service.spring.util.AppContext;


public enum LockManager {
	INSTANCE;

	private static final Logger LOG = Logger.getLogger(LockManager.class);

	public static ThreadLocal<Set<String>> LOCK_OBJECTS_THREAD = new ThreadLocal<Set<String>>() {
		@Override
		protected java.util.Set<String> initialValue() {
			return new HashSet<String>();
		}
	};

	private static Set<String> LOCK_HOLDER = new HashSet<String>();

	private final static String GET_ID_METHOD_STR = "getId";

	private String registerLockedObject(BaseDomain lockedObject) throws Exception {
		String registeredKey = null;

		Long id = getDomainId(lockedObject);
		String key = generateKey(lockedObject, id);

		if (!contains(key, lockedObject) && checkObjectVersion(lockedObject, id)) {
			registeredKey = key;
		}

		return registeredKey;
	}

	private boolean contains(String key, BaseDomain clz) throws Exception {
		if (LOCK_HOLDER.contains(key)) {
			throw new LockingException(clz.getClass().getName() + " is being updated by another user");
		}

		return false;
	}

	public void registerLockedObjects(Set<BaseDomain> lockedObjects) throws Exception {
		if (LOCK_OBJECTS_THREAD.get().size() == 0) {
			Set<String> registeredKeys = new HashSet<String>();
			synchronized (this) {
				for (BaseDomain lockedObject : lockedObjects) {
					if (getDomainId(lockedObject) == null) {
						continue;
					}
					registeredKeys.add(registerLockedObject(lockedObject));
				}
				LOCK_HOLDER.addAll(registeredKeys);
				LOCK_OBJECTS_THREAD.get().addAll(registeredKeys);
			}
		}
	}

	public void releaseLockedObjects() {
		LOCK_HOLDER.removeAll(LOCK_OBJECTS_THREAD.get());
		LOCK_OBJECTS_THREAD.get().clear();
	}

	private boolean checkObjectVersion(BaseDomain obj, Long id) throws Exception {
		ApplicationContext ctx = AppContext.getApplicationContext();
		

		GenericDAO dao = (GenericDAO) ctx.getBean("genericDAO");
		if (obj instanceof HibernateProxy) {
			obj = (BaseDomain) ((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation();
		}
		BaseDomain loadedObj = (BaseDomain) dao.loadObjectByClassAndId(obj.getClass(), id);

		if (obj.getDbVersion() != loadedObj.getDbVersion()) {
			throw new LockingException(obj.getClass().getName() + " is being updated by another user");
		}
		return true;
	}

	private String generateKey(BaseDomain obj, Long id) {
		if (obj instanceof HibernateProxy) {
			obj = (BaseDomain) ((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation();
		}
		return obj.getClass().toString() + id;
	}

	private Long getDomainId(BaseDomain obj) throws Exception {
		Method getIdMethod = BeanUtils.findMethod(obj.getClass(), LockManager.GET_ID_METHOD_STR, new Class[0]);
		return (Long) getIdMethod.invoke(obj);
	}

}
