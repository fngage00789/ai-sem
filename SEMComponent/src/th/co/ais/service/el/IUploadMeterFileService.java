package th.co.ais.service.el;

import java.util.List;
import java.util.Set;

import th.co.ais.domain.el.UploadMeter;
import th.co.ais.domain.el.UploadMeterFile;
import th.co.ais.service.BaseService;

public interface IUploadMeterFileService extends BaseService{

	public String createUploadMeterFile(UploadMeterFile uploadMeter) throws Exception;
	public void validateMeter(String plName, String UploadMeterFileId, Set<UploadMeter> uploadMeters) throws Exception;
	public UploadMeterFile queryUploadMeter(String uploadMeterId) throws Exception;
	public UploadMeterFile moveDataByPL(String plName, String uploadMeterId) throws Exception;
	
}
