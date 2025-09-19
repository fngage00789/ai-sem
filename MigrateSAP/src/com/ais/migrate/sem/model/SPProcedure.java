package com.ais.migrate.sem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//@Entity
//@Table(name="spProcedure")
public class SPProcedure implements Serializable{
	
	private Boolean success;
	private String resultMsg;
	private Integer rowEffect;
	private String useTime;
	
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getResultMsg() {
		return resultMsg;
	}
	
	public Integer getRowEffect() {
		return rowEffect;
	}

	public void setRowEffect(Integer rowEffect) {
		this.rowEffect = rowEffect;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	
	
	public enum EProcedureName {
		MIGRATE_SI_SITE_PROPERTY_TAX("MIGRATE_SI_SITE_PROPERTY_TAX"),
		MIGRATE_RT_RENTAL_MASTER("MIGRATE_RT_RENTAL_MASTER");
		//MIGRATE_VENDOR_MASTER_BOOKBANK("MIGRATE_VENDOR_MASTER_BOOKBANK");

		public String name = "";		
		EProcedureName(String name) {
		this.name = name;
		}
	}
}
