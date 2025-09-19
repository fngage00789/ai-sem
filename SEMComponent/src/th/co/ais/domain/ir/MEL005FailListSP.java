package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class MEL005FailListSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8555105698964921736L;
	
	private String rowId;
	private String errMsgDesc;
	private String countAll;
	private String countClose;
	private String countNonClose;
	private String elImportTranId;
	private String styleClassName;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getErrMsgDesc() {
		return errMsgDesc;
	}

	public void setErrMsgDesc(String errMsgDesc) {
		this.errMsgDesc = errMsgDesc;
	}

	public String getCountAll() {
		return countAll;
	}

	public void setCountAll(String countAll) {
		this.countAll = countAll;
	}

	public String getCountClose() {
		return countClose;
	}

	public void setCountClose(String countClose) {
		this.countClose = countClose;
	}

	public String getCountNonClose() {
		return countNonClose;
	}

	public void setCountNonClose(String countNonClose) {
		this.countNonClose = countNonClose;
	}

	public String getElImportTranId() {
		return elImportTranId;
	}

	public void setElImportTranId(String elImportTranId) {
		this.elImportTranId = elImportTranId;
	}

	public String getStyleClassName() {
		return styleClassName;
	}

	public void setStyleClassName(String styleClassName) {
		this.styleClassName = styleClassName;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		
	}

}
