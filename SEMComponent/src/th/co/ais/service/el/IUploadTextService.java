package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.ElectricFTRateSearch;
import th.co.ais.domain.el.InstallmentSearch7;
import th.co.ais.domain.el.UploadText;
import th.co.ais.service.BaseService;

public interface IUploadTextService extends BaseService{

	public List<UploadText> queryUploadTextByImportTransactionId(String importTransactionId) throws Exception;
	public UploadText queryUploadTextById(String uploadTextId) throws Exception;
	public List<UploadText> queryUploadTextByCriteria(UploadText uploadText) throws Exception;
	public void updateUploadText(UploadText uploadText) throws Exception;
	public void updateUploadTextWithPL(UploadText uploadText, String plName) throws Exception;
	public List<UploadText> queryUploadTextError(UploadText uploadText) throws Exception;
	public Object[] callPLWithReturnValue(String plName, int []inParamType, Object []inParamValue, int []outParamType) throws Exception;//WT###Add 20110308
	public List<ElectricFTRateSearch> queryFTRate(ElectricFTRateSearch ftRate) throws Exception;
	public List querySPList(String spName, Object property) throws Exception;
}
