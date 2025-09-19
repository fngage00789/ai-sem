package th.co.ais.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.service.util.ServiceConstants;

public class WrapperBeanObject<T extends AbstractDomain> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5585703687323613502L;
	private T dataObj;
	private String message;
	private boolean checkBox;
	private boolean disableCheckBox = true;
	private String dbQuery;
	private String mapRowId;

	public WrapperBeanObject() {

	}

	public WrapperBeanObject(T dataObj) {
		super();
		this.dataObj = dataObj;
		this.dbQuery = ServiceConstants.MODULE_ACTION_SELECT;
		this.setMapRowId(dataObj);
	}

	public WrapperBeanObject(T dataObj, String dbQuery) {
		super();
		this.dataObj = dataObj;
		this.dbQuery = dbQuery;
		this.setMapRowId(dataObj);
	}

	public WrapperBeanObject(String mapRowId, T dataObj, String dbQuery) {
		super();
		this.mapRowId = mapRowId;
		this.dataObj = dataObj;
		this.dbQuery = dbQuery;
	}

	public WrapperBeanObject(WrapperBeanObject<T> wrap) {
		super();
		this.mapRowId = wrap.getMapRowId();
		this.dataObj = (T) wrap.getDataObj();
		this.dbQuery = wrap.getDbQuery();
		this.message = wrap.getMessage();
		this.checkBox = wrap.isCheckBox();
	}

	public boolean isCheckBox() {
		return checkBox;
	}

	public void setCheckBox(boolean checkBox) {
		this.checkBox = checkBox;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getDataObj() {
		return dataObj;
	}

	public void setDataObj(T dataObj) {
		this.dataObj = dataObj;
	}

	public String getDbQuery() {
		return dbQuery;
	}

	public void setDbQuery(String dbQuery) {
		this.dbQuery = dbQuery;
	}

	public String getMapRowId() {
		return mapRowId;
	}
	
	public boolean isDisableCheckBox() {
		return disableCheckBox;
	}
	
	public void setDisableCheckBox(boolean disableCheckBox) {
		this.disableCheckBox = disableCheckBox;
	}

	public void setMapRowId(String mapRowId) {
		this.mapRowId = genMapRowid(mapRowId);
	}

	private void setMapRowId(T dataObj) {
		this.setMapRowId(dataObj.getRowId());
	}

	private String genMapRowid(String mapRowId) {
		return (StringUtils.isNotEmpty(mapRowId) && StringUtils.isNotBlank(mapRowId)) ? 
					mapRowId : ("zx" + new SimpleDateFormat("mmssSS").format(new Date())
							+ new Random().nextInt(100000) + new Random().nextInt(10000));
	}

}
