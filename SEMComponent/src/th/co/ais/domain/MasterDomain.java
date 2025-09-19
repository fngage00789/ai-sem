package th.co.ais.domain;

import java.io.Serializable;
import java.util.Date;


public abstract class MasterDomain implements Serializable{

	private static final long serialVersionUID = 1L;
	//default value//
	protected Date createDt;
	protected String createBy;
	protected Date updateDt;
	protected String updateBy;

	
	public abstract String getCreateBy();
	public abstract void setCreateBy(String createBy);
	public abstract Date getCreateDt();
	public abstract void setCreateDt(Date createDt);
	public abstract String getUpdateBy();
	public abstract void setUpdateBy(String updateBy);
	public abstract Date getUpdateDt();
	public abstract void setUpdateDt(Date updateDt);
	
}
