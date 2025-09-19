package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSP;
import th.co.ais.service.BaseService;

public interface IDepositDetailService extends BaseService{

	public List<DepositDetail> queryByManagement(final Management manage, String depositType, String expenseType, String recordStatus) throws Exception;
	public List<DepositDetail> queryByManagement(final ManagementSP manage, String depositType, String expenseType, String recordStatus) throws Exception;
	public List<DepositDetail> queryCriteria(DepositDetail depositDetail) throws Exception;
	public DepositDetail queryByRowId(String rowId) throws Exception;
	public void createDepositDetail(DepositDetail depositDetail) throws Exception;
	public void updateDepositDetail(DepositDetail depositDetail) throws Exception;
	public List<DepositDetail> queryDepositDetail(DepositDetail depositDetail)throws Exception;
}
