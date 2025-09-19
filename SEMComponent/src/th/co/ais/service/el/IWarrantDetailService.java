package th.co.ais.service.el;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.WarrantDatail;
import th.co.ais.domain.el.WarrantDetailSP;
import th.co.ais.service.BaseService;

public interface IWarrantDetailService extends BaseService {

	public List<WarrantDatail> queryWarrantDatailByCriteria(WarrantDatail warrantDetail) throws Exception;
	public void createWarrantDetailByManagement(String plName, WarrantDatail warrantDetail, Management manage, Set<WarrantDatail> warrantDetails) throws Exception;
	public void updateWarrantDetail(WarrantDatail warrantDatail) throws Exception;
	public BigDecimal queryMaxPrintTime(Management manage) throws Exception;
	public List<WarrantDatail> queryWarrantDatailByCriteria(WarrantDatail warrantDetail,String sortBy,String sortType) throws Exception;
	public void updateWarrantDetial(WarrantDatail warrantDetail) throws Exception;
	public List<WarrantDetailSP> queryWarrantDetailSP(WarrantDetailSP warrantDetailSP)throws Exception;
	public void updateWarrantDetailExport(List<WarrantDatail> warrantDetailList)throws Exception;
	public String getWarrantType(String plName, String processStatusCode) throws Exception;
	public void updateStatusWarrantDetail(String plName, List<WarrantDetailSP> warrantDetailSPList, Date sentSighDt, Date sighDt, Date sentWarrantDt,
			Date sentContractDt, Date sentSamuserDt, String remark, String samUsername, String samuserPhone, String userName) throws Exception;
	public void createWarrantDetailByManagementPrivate(String plName, WarrantDatail warrantDetail, Management manage, Set<WarrantDatail> warrantDetails) throws Exception;
}
