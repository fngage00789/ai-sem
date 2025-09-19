package th.co.ais.service.ir;

import java.util.List;

import th.co.ais.domain.ir.ExGenerateDraftSP;
import th.co.ais.service.BaseService;

public interface IGenerateDraft extends BaseService {
	
	 List<ExGenerateDraftSP> queryMIR008Ex1(String draftNo) throws Exception;
	 List<ExGenerateDraftSP> queryMIR008Ex2(String draftNo) throws Exception;
	 List<ExGenerateDraftSP> queryMIR008Ex3(String draftNo) throws Exception;
}
