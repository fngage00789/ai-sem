package th.co.ais.domain.si;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.co.ais.domain.AbstractDomain;

public class RegionZone extends AbstractDomain{

	Map<String,String> regionZone = new HashMap<String, String>();
	
	
	public Map<String, String> getRegionZone() {
		return regionZone;
	}

	public void setRegionZone(Map<String, String> regionZone) {
		this.regionZone = regionZone;
	}

	public void putRegionZone(String zone,String region) {
		this.regionZone.put(zone, region);
	}
	
	public String findRegionByZone(String zone) {
		return this.regionZone.get(zone);
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
