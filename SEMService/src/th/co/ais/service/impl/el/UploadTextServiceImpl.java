package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.dao.impl.el.UploadTextHibernateDAO;
import th.co.ais.domain.el.ElectricFTRateSearch;
import th.co.ais.domain.el.InstallmentSearch7;
import th.co.ais.domain.el.UploadText;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.el.IUploadTextService;

public class UploadTextServiceImpl extends AbstractService implements IUploadTextService{

	UploadTextHibernateDAO uploadTextDao;
	private PLUtil plUtil;	

	public void setPlUtil(PLUtil plUtil) {
		this.plUtil = plUtil;
	}

	public void setUploadTextDao(UploadTextHibernateDAO uploadTextDao) {
		this.uploadTextDao = uploadTextDao;
	}

	@Override
	public List<UploadText> queryUploadTextByImportTransactionId(String importTransactionId)
			throws Exception {
		
		return uploadTextDao.queryUploadTextByImportTransactionId(importTransactionId);
	}
	
	@Override
	public UploadText queryUploadTextById(String uploadTextId)
			throws Exception {
		
		UploadText uploadTextReturn = uploadTextDao.loadById(uploadTextId); 
		if(null!=uploadTextReturn && null!=uploadTextReturn.getTextFileId()){
			uploadTextReturn.getTextFileId().toString();//avoid lazy error
		}
		
		return uploadTextReturn;
	}

	@Override
	public List<UploadText> queryUploadTextByCriteria(UploadText uploadText)
			throws Exception {
		
		return uploadTextDao.queryUploadTextByCriteria(uploadText);
	}

	@Override
	public void updateUploadText(UploadText uploadText) throws Exception {
		
		uploadTextDao.update(uploadText);
		
	}
	
	@Override
	public void updateUploadTextWithPL(UploadText uploadText, String plName) throws Exception {
		
		uploadTextDao.update(uploadText);
		
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{uploadText.getRowId()};
		
		plUtil.callPL(plName, inParamType, inParamValue);		
	}

	@Override
	public List<UploadText> queryUploadTextError(UploadText uploadText)
			throws Exception {
		
		return uploadTextDao.queryUploadTextError(uploadText);
	}

	@Override
	public Object[] callPLWithReturnValue(String plName, int[] inParamType,
			Object[] inParamValue, int[] outParamType) throws Exception {
		
		return plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);
	}
	@Override
	public List<ElectricFTRateSearch> queryFTRate(ElectricFTRateSearch ftRate) throws Exception {
		//paymentDao.s
		//logger.debug(" --- queryInstallment -- : Test" );
		return uploadTextDao.searchFTRate(ftRate);
		
		}

	@SuppressWarnings("unchecked")
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return uploadTextDao.querySPList(spName, property);
	}		

}
