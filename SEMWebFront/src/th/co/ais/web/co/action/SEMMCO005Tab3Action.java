package th.co.ais.web.co.action;

import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import th.co.ais.domain.co.ContractCheckDoc;
import th.co.ais.domain.co.Mco001UpdateCheckDocLSP;
import th.co.ais.service.co.IContractCheckDocService;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.co.bean.SEMMCO005Bean;
import th.co.ais.web.co.bean.SEMMCO005Tab1Bean;
import th.co.ais.web.co.bean.SEMMCO005Tab3Bean;

public class SEMMCO005Tab3Action extends AbstractAction{

	private static final long serialVersionUID = 5934806069385322547L;

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		return flag;
	}
	
	public void doShowRentType() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		// clear radio other
		semmco005tab3Bean.setRentalType99("");
		String rentalType = semmco005tab3Bean.getContractCheckDoc().getRentalType();
		if(rentalType != null){
			if(rentalType.equals("01")){
				semmco005tab3Bean.setRenderChk1(true);
				semmco005tab3Bean.setRenderChk2(false);
				semmco005tab3Bean.setRenderChk3(false);
				semmco005tab3Bean.setRenderChk4(false);
				semmco005tab3Bean.setRenderChk5(false);
				semmco005tab3Bean.setRenderChk6(false);
				semmco005tab3Bean.setRenderChk7(false);
				semmco005tab3Bean.setRenderChk8(false);
			}else if(rentalType.equals("02")){
				semmco005tab3Bean.setRenderChk1(false);
				semmco005tab3Bean.setRenderChk2(true);
				semmco005tab3Bean.setRenderChk3(false);
				semmco005tab3Bean.setRenderChk4(false);
				semmco005tab3Bean.setRenderChk5(false);
				semmco005tab3Bean.setRenderChk6(false);
				semmco005tab3Bean.setRenderChk7(false);
				semmco005tab3Bean.setRenderChk8(false);
			}else if(rentalType.equals("03")){
				semmco005tab3Bean.setRenderChk1(false);
				semmco005tab3Bean.setRenderChk2(false);
				semmco005tab3Bean.setRenderChk3(true);
				semmco005tab3Bean.setRenderChk4(false);
				semmco005tab3Bean.setRenderChk5(false);
				semmco005tab3Bean.setRenderChk6(false);
				semmco005tab3Bean.setRenderChk7(false);
				semmco005tab3Bean.setRenderChk8(false);
			}else if(rentalType.equals("04")){
				semmco005tab3Bean.setRenderChk1(false);
				semmco005tab3Bean.setRenderChk2(false);
				semmco005tab3Bean.setRenderChk3(false);
				semmco005tab3Bean.setRenderChk4(true);
				semmco005tab3Bean.setRenderChk5(false);
				semmco005tab3Bean.setRenderChk6(false);
				semmco005tab3Bean.setRenderChk7(false);
				semmco005tab3Bean.setRenderChk8(false);
			}else if(rentalType.equals("05")){
				semmco005tab3Bean.setRenderChk1(false);
				semmco005tab3Bean.setRenderChk2(false);
				semmco005tab3Bean.setRenderChk3(false);
				semmco005tab3Bean.setRenderChk4(false);
				semmco005tab3Bean.setRenderChk5(true);
				semmco005tab3Bean.setRenderChk6(false);
				semmco005tab3Bean.setRenderChk7(false);
				semmco005tab3Bean.setRenderChk8(false);
			}else if(rentalType.equals("06")){
				semmco005tab3Bean.setRenderChk1(false);
				semmco005tab3Bean.setRenderChk2(false);
				semmco005tab3Bean.setRenderChk3(false);
				semmco005tab3Bean.setRenderChk4(false);
				semmco005tab3Bean.setRenderChk5(false);
				semmco005tab3Bean.setRenderChk6(true);
				semmco005tab3Bean.setRenderChk7(false);
				semmco005tab3Bean.setRenderChk8(false);
			}else if(rentalType.equals("07")){
				semmco005tab3Bean.setRenderChk1(false);
				semmco005tab3Bean.setRenderChk2(false);
				semmco005tab3Bean.setRenderChk3(false);
				semmco005tab3Bean.setRenderChk4(false);
				semmco005tab3Bean.setRenderChk5(false);
				semmco005tab3Bean.setRenderChk6(false);
				semmco005tab3Bean.setRenderChk7(false);
				semmco005tab3Bean.setRenderChk8(true);
			}
		}
		
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}
	
	public void doShowRentType99() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		String rentalType = semmco005tab3Bean.getRentalType99();
		semmco005tab3Bean.getContractCheckDoc().setRentalType("");
		if(rentalType != null){
			if(rentalType.equals("99")){
				semmco005tab3Bean.setRenderChk1(false);
				semmco005tab3Bean.setRenderChk2(false);
				semmco005tab3Bean.setRenderChk3(false);
				semmco005tab3Bean.setRenderChk4(false);
				semmco005tab3Bean.setRenderChk5(false);
				semmco005tab3Bean.setRenderChk6(false);
				semmco005tab3Bean.setRenderChk7(true);
				semmco005tab3Bean.setRenderChk8(false);
			}
		}
		
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}

	@Override
	public boolean validate() {
		return false;
	}
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init() {
		SEMMCO005Tab3Bean semmco005tab3Bean = new SEMMCO005Tab3Bean();
		semmco005tab3Bean.setContractCheckDoc(new ContractCheckDoc());
		semmco005tab3Bean.getContractCheckDoc().setRentalType("01");
		semmco005tab3Bean.setRentalType99("");
		semmco005tab3Bean.setRenderChk1(true);
		setSemmco005tab3Bean(semmco005tab3Bean);
	}
	
	public void initTab3() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		this.setDefaultRadio();
		setSemmco005tab3Bean(semmco005tab3Bean);
		this.searchContractCheckDocByContractId();
	}

	private void setDefaultRadio() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		semmco005tab3Bean.setRenderChk1(true);
		semmco005tab3Bean.setRenderChk2(false);
		semmco005tab3Bean.setRenderChk3(false);
		semmco005tab3Bean.setRenderChk4(false);
		semmco005tab3Bean.setRenderChk5(false);
		semmco005tab3Bean.setRenderChk6(false);
		semmco005tab3Bean.setRenderChk7(false);
		semmco005tab3Bean.getContractCheckDoc().setRentalType("01");
		setSemmco005tab3Bean(semmco005tab3Bean);
	}

	private void searchContractCheckDocByContractId() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		semmco005Bean = getSemmco005Bean();
		List<ContractCheckDoc> to = null;
		try{
			String contractId = getSemmco005Bean().getContractIdParam();
			if(contractId != null && !contractId.equals("")){
				IContractCheckDocService service = (IContractCheckDocService)getBean("contractCheckDocService");
				to = service.queryContractCheckDocByContractId(contractId);
				if(to != null && !to.isEmpty()){
					semmco005tab3Bean.setContractCheckDoc(to.get(0));
					if(semmco005tab3Bean.getContractCheckDoc().getRentalType() == null){
						semmco005tab3Bean.getContractCheckDoc().setRentalType("01");
						semmco005tab3Bean.getContractCheckDoc().setRentalTypeOtherRemark("");
						this.doShowRentType();
					}else{
						if(semmco005tab3Bean.getContractCheckDoc().getRentalType().equals("99")){
							semmco005tab3Bean.setRentalType99("99");
							semmco005tab3Bean.getContractCheckDoc().setRentalType("");
							this.setRentalType();
							this.doShowRentType99();
						}else{
							semmco005tab3Bean.getContractCheckDoc().setRentalTypeOtherRemark("");
							this.setRentalType();
							this.doShowRentType();
						}
					}
					semmco005Bean.setCreateBy(semmco005tab3Bean.getContractCheckDoc().getCreateBy());
					semmco005Bean.setUpdateBy(semmco005tab3Bean.getContractCheckDoc().getUpdateBy());
					semmco005Bean.setCreateDate(semmco005tab3Bean.getContractCheckDoc().getCreateDt());
					semmco005Bean.setUpdateDate(semmco005tab3Bean.getContractCheckDoc().getUpdateDt());
				}else{
					this.setDefaultRadio();
				}
				setSemmco005tab3Bean(semmco005tab3Bean);
				setSemmco005Bean(semmco005Bean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void setRentalType() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		String rentalType = semmco005tab3Bean.getContractCheckDoc().getRentalType();
		if(rentalType != null){
			if(rentalType.equals("01")){
				this.setRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(rentalType.equals("02")){
				this.setRentalType2();
				this.clearRentalType1();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(rentalType.equals("03")){
				this.setRentalType3();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(rentalType.equals("04")){
				this.setRentalType4();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(rentalType.equals("05")){
				this.setRentalType5();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(rentalType.equals("06")){
				this.setRentalType6();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType7();
				this.clearRentalType8();
			}if(rentalType.equals("07")){
				this.setRentalType8();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType7();
			}else if(rentalType.equals("99")){
				this.setRentalType7();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType8();
				
			}else if(semmco005tab3Bean.getRentalType99() != null && semmco005tab3Bean.getRentalType99().equals("99")){
				this.setRentalType7();
			}
		}
		setSemmco005tab3Bean(semmco005tab3Bean);
	}

	
	private void clearRentalType7() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		semmco005tab3Bean.setChkDoc711(false);
		semmco005tab3Bean.setChkDoc712(false);
		semmco005tab3Bean.setChkDoc721(false);
		semmco005tab3Bean.setChkDoc722(false);
		semmco005tab3Bean.setChkDoc731(false);
		semmco005tab3Bean.setChkDoc732(false);
		semmco005tab3Bean.setChkDoc741(false);
		semmco005tab3Bean.setChkDoc742(false);
		semmco005tab3Bean.setChkDoc751(false);
		semmco005tab3Bean.setChkDoc752(false);
		semmco005tab3Bean.setChkDoc761(false);
		semmco005tab3Bean.setChkDoc762(false);
		semmco005tab3Bean.setChkDoc771(false);
		semmco005tab3Bean.setChkDoc772(false);
		semmco005tab3Bean.setChkDoc781(false);
		semmco005tab3Bean.setChkDoc782(false);
		semmco005tab3Bean.setChkDoc791(false);
		semmco005tab3Bean.setChkDoc792(false);
		semmco005tab3Bean.setChkDoc7101(false);
		semmco005tab3Bean.setChkDoc7102(false);
		semmco005tab3Bean.setChkDoc7111(false);
		semmco005tab3Bean.setChkDoc7112(false);
		semmco005tab3Bean.setRentalOtherRemark7("");
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}

	private void clearRentalType1() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		semmco005tab3Bean.setChkDoc111(false);
		semmco005tab3Bean.setChkDoc112(false);
		semmco005tab3Bean.setChkDoc121(false);
		semmco005tab3Bean.setChkDoc122(false);
		semmco005tab3Bean.setChkDoc131(false);
		semmco005tab3Bean.setChkDoc132(false);
		semmco005tab3Bean.setChkDoc141(false);
		semmco005tab3Bean.setChkDoc142(false);
		semmco005tab3Bean.setChkDoc151(false);
		semmco005tab3Bean.setChkDoc152(false);
		semmco005tab3Bean.setChkDoc161(false);
		semmco005tab3Bean.setChkDoc162(false);
		semmco005tab3Bean.setChkDoc171(false);
		semmco005tab3Bean.setChkDoc172(false);
		semmco005tab3Bean.setChkDoc181(false);
		semmco005tab3Bean.setChkDoc182(false);
		semmco005tab3Bean.setChkDoc191(false);
		semmco005tab3Bean.setChkDoc192(false);
		semmco005tab3Bean.setRentalOtherRemark1("");
		setSemmco005tab3Bean(semmco005tab3Bean);
	}

	private void clearRentalType6() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		semmco005tab3Bean.setChkDoc611(false);
		semmco005tab3Bean.setChkDoc612(false);
		semmco005tab3Bean.setChkDoc621(false);
		semmco005tab3Bean.setChkDoc622(false);
		semmco005tab3Bean.setChkDoc631(false);
		semmco005tab3Bean.setChkDoc632(false);
		semmco005tab3Bean.setChkDoc641(false);
		semmco005tab3Bean.setChkDoc642(false);
		semmco005tab3Bean.setChkDoc651(false);
		semmco005tab3Bean.setChkDoc652(false);
		semmco005tab3Bean.setChkDoc661(false);
		semmco005tab3Bean.setChkDoc662(false);
		semmco005tab3Bean.setChkDoc671(false);
		semmco005tab3Bean.setChkDoc672(false);
		semmco005tab3Bean.setChkDoc681(false);
		semmco005tab3Bean.setChkDoc682(false);
		semmco005tab3Bean.setChkDoc691(false);
		semmco005tab3Bean.setChkDoc692(false);
		semmco005tab3Bean.setRentalOtherRemark6("");
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}

	private void clearRentalType5() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		semmco005tab3Bean.setChkDoc511(false);
		semmco005tab3Bean.setChkDoc512(false);
		semmco005tab3Bean.setChkDoc521(false);
		semmco005tab3Bean.setChkDoc522(false);
		semmco005tab3Bean.setChkDoc531(false);
		semmco005tab3Bean.setChkDoc532(false);
		semmco005tab3Bean.setChkDoc541(false);
		semmco005tab3Bean.setChkDoc542(false);
		semmco005tab3Bean.setChkDoc551(false);
		semmco005tab3Bean.setChkDoc552(false);
		semmco005tab3Bean.setChkDoc561(false);
		semmco005tab3Bean.setChkDoc562(false);
		semmco005tab3Bean.setChkDoc571(false);
		semmco005tab3Bean.setChkDoc572(false);
		semmco005tab3Bean.setChkDoc581(false);
		semmco005tab3Bean.setChkDoc582(false);
		semmco005tab3Bean.setChkDoc591(false);
		semmco005tab3Bean.setChkDoc592(false);
		semmco005tab3Bean.setRentalOtherRemark5("");
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}

	private void clearRentalType4() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		semmco005tab3Bean.setChkDoc411(false);
		semmco005tab3Bean.setChkDoc412(false);
		semmco005tab3Bean.setChkDoc421(false);
		semmco005tab3Bean.setChkDoc422(false);
		semmco005tab3Bean.setChkDoc431(false);
		semmco005tab3Bean.setChkDoc432(false);
		semmco005tab3Bean.setChkDoc441(false);
		semmco005tab3Bean.setChkDoc442(false);
		semmco005tab3Bean.setChkDoc451(false);
		semmco005tab3Bean.setChkDoc452(false);
		semmco005tab3Bean.setChkDoc461(false);
		semmco005tab3Bean.setChkDoc462(false);
		semmco005tab3Bean.setChkDoc471(false);
		semmco005tab3Bean.setChkDoc472(false);
		semmco005tab3Bean.setChkDoc481(false);
		semmco005tab3Bean.setChkDoc482(false);
		semmco005tab3Bean.setChkDoc491(false);
		semmco005tab3Bean.setChkDoc492(false);
		semmco005tab3Bean.setChkDoc4101(false);
		semmco005tab3Bean.setChkDoc4102(false);
		semmco005tab3Bean.setRentalOtherRemark4("");
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}

	private void clearRentalType3() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		semmco005tab3Bean.setChkDoc311(false);
		semmco005tab3Bean.setChkDoc312(false);
		semmco005tab3Bean.setChkDoc321(false);
		semmco005tab3Bean.setChkDoc322(false);
		semmco005tab3Bean.setChkDoc331(false);
		semmco005tab3Bean.setChkDoc332(false);
		semmco005tab3Bean.setChkDoc341(false);
		semmco005tab3Bean.setChkDoc342(false);
		semmco005tab3Bean.setChkDoc351(false);
		semmco005tab3Bean.setChkDoc352(false);
		semmco005tab3Bean.setChkDoc361(false);
		semmco005tab3Bean.setChkDoc362(false);
		semmco005tab3Bean.setChkDoc371(false);
		semmco005tab3Bean.setChkDoc372(false);
		semmco005tab3Bean.setChkDoc381(false);
		semmco005tab3Bean.setChkDoc382(false);
		semmco005tab3Bean.setChkDoc391(false);
		semmco005tab3Bean.setChkDoc392(false);
		semmco005tab3Bean.setRentalOtherRemark3("");
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}

	private void clearRentalType2() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		semmco005tab3Bean.setChkDoc211(false);
		semmco005tab3Bean.setChkDoc212(false);
		semmco005tab3Bean.setChkDoc221(false);
		semmco005tab3Bean.setChkDoc222(false);
		semmco005tab3Bean.setChkDoc231(false);
		semmco005tab3Bean.setChkDoc232(false);
		semmco005tab3Bean.setChkDoc241(false);
		semmco005tab3Bean.setChkDoc242(false);
		semmco005tab3Bean.setChkDoc251(false);
		semmco005tab3Bean.setChkDoc252(false);
		semmco005tab3Bean.setChkDoc261(false);
		semmco005tab3Bean.setChkDoc262(false);
		semmco005tab3Bean.setChkDoc271(false);
		semmco005tab3Bean.setChkDoc272(false);
		semmco005tab3Bean.setChkDoc281(false);
		semmco005tab3Bean.setChkDoc282(false);
		semmco005tab3Bean.setRentalOtherRemark2("");
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}
	
	private void clearRentalType8() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		semmco005tab3Bean.setChkDoc811(false);
		semmco005tab3Bean.setChkDoc812(false);
		semmco005tab3Bean.setChkDoc821(false);
		semmco005tab3Bean.setChkDoc822(false);
		semmco005tab3Bean.setChkDoc831(false);
		semmco005tab3Bean.setChkDoc832(false);
		semmco005tab3Bean.setChkDoc841(false);
		semmco005tab3Bean.setChkDoc842(false);
		semmco005tab3Bean.setChkDoc851(false);
		semmco005tab3Bean.setChkDoc852(false);
		semmco005tab3Bean.setRentalOtherRemark8("");
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}

	private void setRentalType1() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		ContractCheckDoc doc = semmco005tab3Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmco005tab3Bean.setChkDoc111(true);
		}else{
			semmco005tab3Bean.setChkDoc111(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmco005tab3Bean.setChkDoc112(true);
		}else{
			semmco005tab3Bean.setChkDoc112(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmco005tab3Bean.setChkDoc121(true);
		}else{
			semmco005tab3Bean.setChkDoc121(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmco005tab3Bean.setChkDoc122(true);
		}else{
			semmco005tab3Bean.setChkDoc122(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmco005tab3Bean.setChkDoc131(true);
		}else{
			semmco005tab3Bean.setChkDoc131(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmco005tab3Bean.setChkDoc132(true);
		}else{
			semmco005tab3Bean.setChkDoc132(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmco005tab3Bean.setChkDoc141(true);
		}else{
			semmco005tab3Bean.setChkDoc141(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmco005tab3Bean.setChkDoc142(true);
		}else{
			semmco005tab3Bean.setChkDoc142(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmco005tab3Bean.setChkDoc151(true);
		}else{
			semmco005tab3Bean.setChkDoc151(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmco005tab3Bean.setChkDoc152(true);
		}else{
			semmco005tab3Bean.setChkDoc152(false);
		}
		
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmco005tab3Bean.setChkDoc161(true);
		}else{
			semmco005tab3Bean.setChkDoc161(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmco005tab3Bean.setChkDoc162(true);
		}else{
			semmco005tab3Bean.setChkDoc162(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmco005tab3Bean.setChkDoc171(true);
		}else{
			semmco005tab3Bean.setChkDoc171(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmco005tab3Bean.setChkDoc172(true);
		}else{
			semmco005tab3Bean.setChkDoc172(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmco005tab3Bean.setChkDoc181(true);
		}else{
			semmco005tab3Bean.setChkDoc181(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmco005tab3Bean.setChkDoc182(true);
		}else{
			semmco005tab3Bean.setChkDoc182(false);
		}
		
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmco005tab3Bean.setChkDoc191(true);
		}else{
			semmco005tab3Bean.setChkDoc191(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmco005tab3Bean.setChkDoc192(true);
		}else{
			semmco005tab3Bean.setChkDoc192(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmco005tab3Bean.setRentalOtherRemark1(doc.getDocOtherRemark());
		}
		setSemmco005tab3Bean(semmco005tab3Bean);
	}
	
	private void setRentalType8() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		ContractCheckDoc doc = semmco005tab3Bean.getContractCheckDoc();
		
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmco005tab3Bean.setChkDoc811(true);
		}else{
			semmco005tab3Bean.setChkDoc811(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmco005tab3Bean.setChkDoc812(true);
		}else{
			semmco005tab3Bean.setChkDoc812(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmco005tab3Bean.setChkDoc821(true);
		}else{
			semmco005tab3Bean.setChkDoc821(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmco005tab3Bean.setChkDoc822(true);
		}else{
			semmco005tab3Bean.setChkDoc822(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmco005tab3Bean.setChkDoc831(true);
		}else{
			semmco005tab3Bean.setChkDoc831(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmco005tab3Bean.setChkDoc832(true);
		}else{
			semmco005tab3Bean.setChkDoc832(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmco005tab3Bean.setChkDoc841(true);
		}else{
			semmco005tab3Bean.setChkDoc841(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmco005tab3Bean.setChkDoc842(true);
		}else{
			semmco005tab3Bean.setChkDoc842(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmco005tab3Bean.setChkDoc851(true);
		}else{
			semmco005tab3Bean.setChkDoc851(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmco005tab3Bean.setChkDoc852(true);
		}else{
			semmco005tab3Bean.setChkDoc852(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmco005tab3Bean.setRentalOtherRemark8(doc.getDocOtherRemark());
		}
		setSemmco005tab3Bean(semmco005tab3Bean);
	}
	
	private void setRentalType2() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		ContractCheckDoc doc = semmco005tab3Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmco005tab3Bean.setChkDoc211(true);
		}else{
			semmco005tab3Bean.setChkDoc211(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmco005tab3Bean.setChkDoc212(true);
		}else{
			semmco005tab3Bean.setChkDoc212(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmco005tab3Bean.setChkDoc221(true);
		}else{
			semmco005tab3Bean.setChkDoc221(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmco005tab3Bean.setChkDoc222(true);
		}else{
			semmco005tab3Bean.setChkDoc222(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmco005tab3Bean.setChkDoc231(true);
		}else{
			semmco005tab3Bean.setChkDoc231(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmco005tab3Bean.setChkDoc232(true);
		}else{
			semmco005tab3Bean.setChkDoc232(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmco005tab3Bean.setChkDoc241(true);
		}else{
			semmco005tab3Bean.setChkDoc241(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmco005tab3Bean.setChkDoc242(true);
		}else{
			semmco005tab3Bean.setChkDoc242(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmco005tab3Bean.setChkDoc251(true);
		}else{
			semmco005tab3Bean.setChkDoc251(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmco005tab3Bean.setChkDoc252(true);
		}else{
			semmco005tab3Bean.setChkDoc252(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmco005tab3Bean.setChkDoc261(true);
		}else{
			semmco005tab3Bean.setChkDoc261(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmco005tab3Bean.setChkDoc262(true);
		}else{
			semmco005tab3Bean.setChkDoc262(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmco005tab3Bean.setChkDoc271(true);
		}else{
			semmco005tab3Bean.setChkDoc271(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmco005tab3Bean.setChkDoc272(true);
		}else{
			semmco005tab3Bean.setChkDoc272(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmco005tab3Bean.setChkDoc281(true);
		}else{
			semmco005tab3Bean.setChkDoc281(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmco005tab3Bean.setChkDoc282(true);
		}else{
			semmco005tab3Bean.setChkDoc282(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmco005tab3Bean.setRentalOtherRemark2(doc.getDocOtherRemark());
		}
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}
	private void setRentalType3() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		ContractCheckDoc doc = semmco005tab3Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmco005tab3Bean.setChkDoc311(true);
		}else{
			semmco005tab3Bean.setChkDoc311(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmco005tab3Bean.setChkDoc312(true);
		}else{
			semmco005tab3Bean.setChkDoc312(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmco005tab3Bean.setChkDoc321(true);
		}else{
			semmco005tab3Bean.setChkDoc321(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmco005tab3Bean.setChkDoc322(true);
		}else{
			semmco005tab3Bean.setChkDoc322(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmco005tab3Bean.setChkDoc331(true);
		}else{
			semmco005tab3Bean.setChkDoc331(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmco005tab3Bean.setChkDoc332(true);
		}else{
			semmco005tab3Bean.setChkDoc332(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmco005tab3Bean.setChkDoc341(true);
		}else{
			semmco005tab3Bean.setChkDoc341(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmco005tab3Bean.setChkDoc342(true);
		}else{
			semmco005tab3Bean.setChkDoc342(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmco005tab3Bean.setChkDoc351(true);
		}else{
			semmco005tab3Bean.setChkDoc351(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmco005tab3Bean.setChkDoc352(true);
		}else{
			semmco005tab3Bean.setChkDoc352(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmco005tab3Bean.setChkDoc361(true);
		}else{
			semmco005tab3Bean.setChkDoc361(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmco005tab3Bean.setChkDoc362(true);
		}else{
			semmco005tab3Bean.setChkDoc362(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmco005tab3Bean.setChkDoc371(true);
		}else{
			semmco005tab3Bean.setChkDoc371(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmco005tab3Bean.setChkDoc372(true);
		}else{
			semmco005tab3Bean.setChkDoc372(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmco005tab3Bean.setChkDoc381(true);
		}else{
			semmco005tab3Bean.setChkDoc381(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmco005tab3Bean.setChkDoc382(true);
		}else{
			semmco005tab3Bean.setChkDoc382(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmco005tab3Bean.setChkDoc391(true);
		}else{
			semmco005tab3Bean.setChkDoc391(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmco005tab3Bean.setChkDoc392(true);
		}else{
			semmco005tab3Bean.setChkDoc392(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmco005tab3Bean.setRentalOtherRemark3(doc.getDocOtherRemark());
		}
		setSemmco005tab3Bean(semmco005tab3Bean);
	}
	
	private void setRentalType4() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		ContractCheckDoc doc = semmco005tab3Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmco005tab3Bean.setChkDoc411(true);
		}else{
			semmco005tab3Bean.setChkDoc411(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmco005tab3Bean.setChkDoc412(true);
		}else{
			semmco005tab3Bean.setChkDoc412(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmco005tab3Bean.setChkDoc421(true);
		}else{
			semmco005tab3Bean.setChkDoc421(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmco005tab3Bean.setChkDoc422(true);
		}else{
			semmco005tab3Bean.setChkDoc422(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmco005tab3Bean.setChkDoc431(true);
		}else{
			semmco005tab3Bean.setChkDoc431(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmco005tab3Bean.setChkDoc432(true);
		}else{
			semmco005tab3Bean.setChkDoc432(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmco005tab3Bean.setChkDoc441(true);
		}else{
			semmco005tab3Bean.setChkDoc441(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmco005tab3Bean.setChkDoc442(true);
		}else{
			semmco005tab3Bean.setChkDoc442(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmco005tab3Bean.setChkDoc451(true);
		}else{
			semmco005tab3Bean.setChkDoc451(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmco005tab3Bean.setChkDoc452(true);
		}else{
			semmco005tab3Bean.setChkDoc452(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmco005tab3Bean.setChkDoc461(true);
		}else{
			semmco005tab3Bean.setChkDoc461(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmco005tab3Bean.setChkDoc462(true);
		}else{
			semmco005tab3Bean.setChkDoc462(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmco005tab3Bean.setChkDoc471(true);
		}else{
			semmco005tab3Bean.setChkDoc471(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmco005tab3Bean.setChkDoc472(true);
		}else{
			semmco005tab3Bean.setChkDoc472(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmco005tab3Bean.setChkDoc481(true);
		}else{
			semmco005tab3Bean.setChkDoc481(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmco005tab3Bean.setChkDoc482(true);
		}else{
			semmco005tab3Bean.setChkDoc482(false);
		}
		if(doc.getDoc91() != null && doc.getDoc91().equals("Y")){
			semmco005tab3Bean.setChkDoc491(true);
		}else{
			semmco005tab3Bean.setChkDoc491(false);
		}
		if(doc.getDoc92() != null && doc.getDoc92().equals("Y")){
			semmco005tab3Bean.setChkDoc492(true);
		}else{
			semmco005tab3Bean.setChkDoc492(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmco005tab3Bean.setChkDoc4101(true);
		}else{
			semmco005tab3Bean.setChkDoc4101(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmco005tab3Bean.setChkDoc4102(true);
		}else{
			semmco005tab3Bean.setChkDoc4102(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmco005tab3Bean.setRentalOtherRemark4(doc.getDocOtherRemark());
		}
		setSemmco005tab3Bean(semmco005tab3Bean);
	}
	
	private void setRentalType5() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		ContractCheckDoc doc = semmco005tab3Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmco005tab3Bean.setChkDoc511(true);
		}else{
			semmco005tab3Bean.setChkDoc511(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmco005tab3Bean.setChkDoc512(true);
		}else{
			semmco005tab3Bean.setChkDoc512(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmco005tab3Bean.setChkDoc521(true);
		}else{
			semmco005tab3Bean.setChkDoc521(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmco005tab3Bean.setChkDoc522(true);
		}else{
			semmco005tab3Bean.setChkDoc522(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmco005tab3Bean.setChkDoc531(true);
		}else{
			semmco005tab3Bean.setChkDoc531(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmco005tab3Bean.setChkDoc532(true);
		}else{
			semmco005tab3Bean.setChkDoc532(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmco005tab3Bean.setChkDoc541(true);
		}else{
			semmco005tab3Bean.setChkDoc541(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmco005tab3Bean.setChkDoc542(true);
		}else{
			semmco005tab3Bean.setChkDoc542(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmco005tab3Bean.setChkDoc551(true);
		}else{
			semmco005tab3Bean.setChkDoc551(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmco005tab3Bean.setChkDoc552(true);
		}else{
			semmco005tab3Bean.setChkDoc552(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmco005tab3Bean.setChkDoc561(true);
		}else{
			semmco005tab3Bean.setChkDoc561(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmco005tab3Bean.setChkDoc562(true);
		}else{
			semmco005tab3Bean.setChkDoc562(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmco005tab3Bean.setChkDoc571(true);
		}else{
			semmco005tab3Bean.setChkDoc571(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmco005tab3Bean.setChkDoc572(true);
		}else{
			semmco005tab3Bean.setChkDoc572(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmco005tab3Bean.setChkDoc581(true);
		}else{
			semmco005tab3Bean.setChkDoc581(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmco005tab3Bean.setChkDoc582(true);
		}else{
			semmco005tab3Bean.setChkDoc582(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmco005tab3Bean.setChkDoc591(true);
		}else{
			semmco005tab3Bean.setChkDoc591(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmco005tab3Bean.setChkDoc592(true);
		}else{
			semmco005tab3Bean.setChkDoc592(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmco005tab3Bean.setRentalOtherRemark5(doc.getDocOtherRemark());
		}
		setSemmco005tab3Bean(semmco005tab3Bean);
	}
	
	private void setRentalType6() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		ContractCheckDoc doc = semmco005tab3Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmco005tab3Bean.setChkDoc611(true);
		}else{
			semmco005tab3Bean.setChkDoc611(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmco005tab3Bean.setChkDoc612(true);
		}else{
			semmco005tab3Bean.setChkDoc612(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmco005tab3Bean.setChkDoc621(true);
		}else{
			semmco005tab3Bean.setChkDoc621(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmco005tab3Bean.setChkDoc622(true);
		}else{
			semmco005tab3Bean.setChkDoc622(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmco005tab3Bean.setChkDoc631(true);
		}else{
			semmco005tab3Bean.setChkDoc631(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmco005tab3Bean.setChkDoc632(true);
		}else{
			semmco005tab3Bean.setChkDoc632(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmco005tab3Bean.setChkDoc641(true);
		}else{
			semmco005tab3Bean.setChkDoc641(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmco005tab3Bean.setChkDoc642(true);
		}else{
			semmco005tab3Bean.setChkDoc642(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmco005tab3Bean.setChkDoc651(true);
		}else{
			semmco005tab3Bean.setChkDoc651(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmco005tab3Bean.setChkDoc652(true);
		}else{
			semmco005tab3Bean.setChkDoc652(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmco005tab3Bean.setChkDoc661(true);
		}else{
			semmco005tab3Bean.setChkDoc661(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmco005tab3Bean.setChkDoc662(true);
		}else{
			semmco005tab3Bean.setChkDoc662(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmco005tab3Bean.setChkDoc671(true);
		}else{
			semmco005tab3Bean.setChkDoc671(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmco005tab3Bean.setChkDoc672(true);
		}else{
			semmco005tab3Bean.setChkDoc672(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmco005tab3Bean.setChkDoc681(true);
		}else{
			semmco005tab3Bean.setChkDoc681(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmco005tab3Bean.setChkDoc682(true);
		}else{
			semmco005tab3Bean.setChkDoc682(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmco005tab3Bean.setChkDoc691(true);
		}else{
			semmco005tab3Bean.setChkDoc691(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmco005tab3Bean.setChkDoc692(true);
		}else{
			semmco005tab3Bean.setChkDoc692(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmco005tab3Bean.setRentalOtherRemark6(doc.getDocOtherRemark());
		}
		setSemmco005tab3Bean(semmco005tab3Bean);
	}
	
	private void setRentalType7() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		ContractCheckDoc doc = semmco005tab3Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmco005tab3Bean.setChkDoc711(true);
		}else{
			semmco005tab3Bean.setChkDoc711(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmco005tab3Bean.setChkDoc712(true);
		}else{
			semmco005tab3Bean.setChkDoc712(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmco005tab3Bean.setChkDoc721(true);
		}else{
			semmco005tab3Bean.setChkDoc721(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmco005tab3Bean.setChkDoc722(true);
		}else{
			semmco005tab3Bean.setChkDoc722(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmco005tab3Bean.setChkDoc731(true);
		}else{
			semmco005tab3Bean.setChkDoc731(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmco005tab3Bean.setChkDoc732(true);
		}else{
			semmco005tab3Bean.setChkDoc732(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmco005tab3Bean.setChkDoc741(true);
		}else{
			semmco005tab3Bean.setChkDoc741(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmco005tab3Bean.setChkDoc742(true);
		}else{
			semmco005tab3Bean.setChkDoc742(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmco005tab3Bean.setChkDoc751(true);
		}else{
			semmco005tab3Bean.setChkDoc751(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmco005tab3Bean.setChkDoc752(true);
		}else{
			semmco005tab3Bean.setChkDoc752(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmco005tab3Bean.setChkDoc761(true);
		}else{
			semmco005tab3Bean.setChkDoc761(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmco005tab3Bean.setChkDoc762(true);
		}else{
			semmco005tab3Bean.setChkDoc762(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmco005tab3Bean.setChkDoc771(true);
		}else{
			semmco005tab3Bean.setChkDoc771(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmco005tab3Bean.setChkDoc772(true);
		}else{
			semmco005tab3Bean.setChkDoc772(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmco005tab3Bean.setChkDoc781(true);
		}else{
			semmco005tab3Bean.setChkDoc781(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmco005tab3Bean.setChkDoc782(true);
		}else{
			semmco005tab3Bean.setChkDoc782(false);
		}
		if(doc.getDoc91() != null && doc.getDoc91().equals("Y")){
			semmco005tab3Bean.setChkDoc791(true);
		}else{
			semmco005tab3Bean.setChkDoc791(false);
		}
		if(doc.getDoc92() != null && doc.getDoc92().equals("Y")){
			semmco005tab3Bean.setChkDoc792(true);
		}else{
			semmco005tab3Bean.setChkDoc792(false);
		}
		if(doc.getDoc101() != null && doc.getDoc101().equals("Y")){
			semmco005tab3Bean.setChkDoc7101(true);
		}else{
			semmco005tab3Bean.setChkDoc7101(false);
		}
		if(doc.getDoc102() != null && doc.getDoc102().equals("Y")){
			semmco005tab3Bean.setChkDoc7102(true);
		}else{
			semmco005tab3Bean.setChkDoc7102(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmco005tab3Bean.setChkDoc7111(true);
		}else{
			semmco005tab3Bean.setChkDoc7111(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmco005tab3Bean.setChkDoc7112(true);
		}else{
			semmco005tab3Bean.setChkDoc7112(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmco005tab3Bean.setRentalOtherRemark7(doc.getDocOtherRemark());
		}
		
		
		setSemmco005tab3Bean(semmco005tab3Bean);
	}

	public void doUpdateTab3() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		semmco005Bean = getSemmco005Bean();
		semmco005tab1Bean = getSemmco005tab1Bean();
		try{
			if(validateTab3()){
				IContractCheckDocService service = (IContractCheckDocService)getBean("contractCheckDocService");
				this.setRequestDocType();
				if(semmco005tab3Bean.getContractCheckDoc() != null){
					if(semmco005tab3Bean.getRentalType99().equals("")){
						semmco005tab3Bean.getContractCheckDoc().setDoc91("");
						semmco005tab3Bean.getContractCheckDoc().setDoc92("");
						semmco005tab3Bean.getContractCheckDoc().setDoc101("");
						semmco005tab3Bean.getContractCheckDoc().setDoc102("");
						semmco005tab3Bean.getContractCheckDoc().setRentalTypeOtherRemark("");
					}
					if(semmco005tab3Bean.getContractCheckDoc().getRentalType().equals("02")){
						semmco005tab3Bean.getContractCheckDoc().setDoc81("");
						semmco005tab3Bean.getContractCheckDoc().setDoc82("");
					}
					if(!semmco005tab3Bean.getRentalType99().equals("") && semmco005tab3Bean.getRentalType99().equals("99")){
						semmco005tab3Bean.getContractCheckDoc().setRentalType(semmco005tab3Bean.getRentalType99());
					}
					semmco005tab3Bean.getContractCheckDoc().setCurrentUser(semmco005tab3Bean.getUserLogin());
					semmco005tab3Bean.getContractCheckDoc().setRecordStatus("Y");
					semmco005tab3Bean.setContractCheckDoc(service.updateContractCheckDoc(semmco005tab3Bean.getContractCheckDoc()));
					semmco005Bean.setCreateBy(semmco005tab3Bean.getContractCheckDoc().getCreateBy());
					semmco005Bean.setUpdateBy(semmco005tab3Bean.getContractCheckDoc().getUpdateBy());
					semmco005Bean.setCreateDate(semmco005tab3Bean.getContractCheckDoc().getCreateDt());
					semmco005Bean.setUpdateDate(semmco005tab3Bean.getContractCheckDoc().getUpdateDt());
					addMessageInfo(("M0001"));
					
					List<Mco001UpdateCheckDocLSP> toDocL = null;
					// UPDATE CHECK DOC CALL SEM_SP_MCO001_UPD_CHECK_DOC_L
					Mco001UpdateCheckDocLSP docL = new Mco001UpdateCheckDocLSP();
					docL.setSiteInfoId(semmco005Bean.getSiteInfoParam());
					docL.setCurrentUser(semmco005Bean.getUserLogin());
					toDocL = service.querySPList(EQueryName.SP_MCO001_UPD_CHECK_DOC_L.name, docL);
					if(toDocL != null && !toDocL.isEmpty() && toDocL.get(0).getResultMsg().equals("Success")){
						log.debug("update check doc Legal result [" + toDocL.get(0).getResultMsg());
					}
				}
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError(("E0001"));
		}
		setSemmco005tab3Bean(semmco005tab3Bean);
		setSemmco005Bean(semmco005Bean);
	}

	private void setRequestDocType() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		if(semmco005tab3Bean.getContractCheckDoc().getRentalType() != null){
			if(semmco005tab3Bean.getContractCheckDoc().getRentalType().equals("01")){
				this.setRequestDocType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(semmco005tab3Bean.getContractCheckDoc().getRentalType().equals("02")){
				this.setRequestDocType2();
				this.clearRentalType1();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(semmco005tab3Bean.getContractCheckDoc().getRentalType().equals("03")){
				this.setRequestDocType3();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(semmco005tab3Bean.getContractCheckDoc().getRentalType().equals("04")){
				this.setRequestDocType4();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(semmco005tab3Bean.getContractCheckDoc().getRentalType().equals("05")){
				this.setRequestDocType5();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(semmco005tab3Bean.getContractCheckDoc().getRentalType().equals("06")){
				this.setRequestDocType6();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(semmco005tab3Bean.getContractCheckDoc().getRentalType().equals("07")){
				this.setRequestDocType8();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
			}
			if(semmco005tab3Bean.getRentalType99() != null && semmco005tab3Bean.getRentalType99().equals("99")){
				this.setRequestDocType7();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType8();
			}
			setSemmco005tab3Bean(semmco005tab3Bean);
		}
		
	}

	private void setRequestDocType1() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		if(semmco005tab3Bean.isChkDoc111()){
			semmco005tab3Bean.getContractCheckDoc().setDoc11("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc11("N");
		}
		if(semmco005tab3Bean.isChkDoc112()){
			semmco005tab3Bean.getContractCheckDoc().setDoc12("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc12("N");
		}
		if(semmco005tab3Bean.isChkDoc121()){
			semmco005tab3Bean.getContractCheckDoc().setDoc21("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc21("N");
		}
		if(semmco005tab3Bean.isChkDoc122()){
			semmco005tab3Bean.getContractCheckDoc().setDoc22("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc22("N");
		}
		if(semmco005tab3Bean.isChkDoc131()){
			semmco005tab3Bean.getContractCheckDoc().setDoc31("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc31("N");
		}
		if(semmco005tab3Bean.isChkDoc132()){
			semmco005tab3Bean.getContractCheckDoc().setDoc32("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc32("N");
		}
		if(semmco005tab3Bean.isChkDoc141()){
			semmco005tab3Bean.getContractCheckDoc().setDoc41("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc41("N");
		}
		if(semmco005tab3Bean.isChkDoc142()){
			semmco005tab3Bean.getContractCheckDoc().setDoc42("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc42("N");
		}
		if(semmco005tab3Bean.isChkDoc151()){
			semmco005tab3Bean.getContractCheckDoc().setDoc51("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc51("N");
		}
		if(semmco005tab3Bean.isChkDoc152()){
			semmco005tab3Bean.getContractCheckDoc().setDoc52("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc52("N");
		}
		// add choices list 20110706
		if(semmco005tab3Bean.isChkDoc161()){
			semmco005tab3Bean.getContractCheckDoc().setDoc61("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc61("N");
		}
		if(semmco005tab3Bean.isChkDoc162()){
			semmco005tab3Bean.getContractCheckDoc().setDoc62("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc62("N");
		}
		if(semmco005tab3Bean.isChkDoc171()){
			semmco005tab3Bean.getContractCheckDoc().setDoc71("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc71("N");
		}
		if(semmco005tab3Bean.isChkDoc172()){
			semmco005tab3Bean.getContractCheckDoc().setDoc72("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc72("N");
		}
		if(semmco005tab3Bean.isChkDoc181()){
			semmco005tab3Bean.getContractCheckDoc().setDoc81("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc81("N");
		}
		if(semmco005tab3Bean.isChkDoc182()){
			semmco005tab3Bean.getContractCheckDoc().setDoc82("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc82("N");
		}
		
		if(semmco005tab3Bean.isChkDoc191()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark1());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("N");
		}
		if(semmco005tab3Bean.isChkDoc192()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark1());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("N");
		}
		
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}
	private void setRequestDocType2() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		if(semmco005tab3Bean.isChkDoc211()){
			semmco005tab3Bean.getContractCheckDoc().setDoc11("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc11("N");
		}
		if(semmco005tab3Bean.isChkDoc212()){
			semmco005tab3Bean.getContractCheckDoc().setDoc12("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc12("N");
		}
		if(semmco005tab3Bean.isChkDoc221()){
			semmco005tab3Bean.getContractCheckDoc().setDoc21("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc21("N");
		}
		if(semmco005tab3Bean.isChkDoc222()){
			semmco005tab3Bean.getContractCheckDoc().setDoc22("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc22("N");
		}
		if(semmco005tab3Bean.isChkDoc231()){
			semmco005tab3Bean.getContractCheckDoc().setDoc31("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc31("N");
		}
		if(semmco005tab3Bean.isChkDoc232()){
			semmco005tab3Bean.getContractCheckDoc().setDoc32("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc32("N");
		}
		if(semmco005tab3Bean.isChkDoc241()){
			semmco005tab3Bean.getContractCheckDoc().setDoc41("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc41("N");
		}
		if(semmco005tab3Bean.isChkDoc242()){
			semmco005tab3Bean.getContractCheckDoc().setDoc42("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc42("N");
		}
		if(semmco005tab3Bean.isChkDoc251()){
			semmco005tab3Bean.getContractCheckDoc().setDoc51("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc51("N");
		}
		if(semmco005tab3Bean.isChkDoc252()){
			semmco005tab3Bean.getContractCheckDoc().setDoc52("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc52("N");
		}
		if(semmco005tab3Bean.isChkDoc261()){
			semmco005tab3Bean.getContractCheckDoc().setDoc61("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc61("N");
		}
		if(semmco005tab3Bean.isChkDoc262()){
			semmco005tab3Bean.getContractCheckDoc().setDoc62("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc62("N");
		}
		if(semmco005tab3Bean.isChkDoc271()){
			semmco005tab3Bean.getContractCheckDoc().setDoc71("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc71("N");
		}
		if(semmco005tab3Bean.isChkDoc272()){
			semmco005tab3Bean.getContractCheckDoc().setDoc72("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc72("N");
		}
		if(semmco005tab3Bean.isChkDoc281()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark2());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("N");
		}
		if(semmco005tab3Bean.isChkDoc282()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark2());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("N");
		}
		
		setSemmco005tab3Bean(semmco005tab3Bean);
	}
	
	private void setRequestDocType3() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		if(semmco005tab3Bean.isChkDoc311()){
			semmco005tab3Bean.getContractCheckDoc().setDoc11("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc11("N");
		}
		if(semmco005tab3Bean.isChkDoc312()){
			semmco005tab3Bean.getContractCheckDoc().setDoc12("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc12("N");
		}
		if(semmco005tab3Bean.isChkDoc321()){
			semmco005tab3Bean.getContractCheckDoc().setDoc21("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc21("N");
		}
		if(semmco005tab3Bean.isChkDoc322()){
			semmco005tab3Bean.getContractCheckDoc().setDoc22("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc22("N");
		}
		if(semmco005tab3Bean.isChkDoc331()){
			semmco005tab3Bean.getContractCheckDoc().setDoc31("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc31("N");
		}
		if(semmco005tab3Bean.isChkDoc332()){
			semmco005tab3Bean.getContractCheckDoc().setDoc32("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc32("N");
		}
		if(semmco005tab3Bean.isChkDoc341()){
			semmco005tab3Bean.getContractCheckDoc().setDoc41("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc41("N");
		}
		if(semmco005tab3Bean.isChkDoc342()){
			semmco005tab3Bean.getContractCheckDoc().setDoc42("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc42("N");
		}
		if(semmco005tab3Bean.isChkDoc351()){
			semmco005tab3Bean.getContractCheckDoc().setDoc51("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc51("N");
		}
		if(semmco005tab3Bean.isChkDoc352()){
			semmco005tab3Bean.getContractCheckDoc().setDoc52("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc52("N");
		}
		if(semmco005tab3Bean.isChkDoc361()){
			semmco005tab3Bean.getContractCheckDoc().setDoc61("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc61("N");
		}
		if(semmco005tab3Bean.isChkDoc362()){
			semmco005tab3Bean.getContractCheckDoc().setDoc62("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc62("N");
		}
		if(semmco005tab3Bean.isChkDoc371()){
			semmco005tab3Bean.getContractCheckDoc().setDoc71("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc71("N");
		}
		if(semmco005tab3Bean.isChkDoc372()){
			semmco005tab3Bean.getContractCheckDoc().setDoc72("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc72("N");
		}
		if(semmco005tab3Bean.isChkDoc381()){
			semmco005tab3Bean.getContractCheckDoc().setDoc81("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc81("N");
		}
		if(semmco005tab3Bean.isChkDoc382()){
			semmco005tab3Bean.getContractCheckDoc().setDoc82("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc82("N");
		}
		if(semmco005tab3Bean.isChkDoc391()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark3());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("N");
		}
		if(semmco005tab3Bean.isChkDoc392()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark3());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("N");
		}
		
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}
	
	private void setRequestDocType4() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		if(semmco005tab3Bean.isChkDoc411()){
			semmco005tab3Bean.getContractCheckDoc().setDoc11("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc11("N");
		}
		if(semmco005tab3Bean.isChkDoc412()){
			semmco005tab3Bean.getContractCheckDoc().setDoc12("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc12("N");
		}
		if(semmco005tab3Bean.isChkDoc421()){
			semmco005tab3Bean.getContractCheckDoc().setDoc21("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc21("N");
		}
		if(semmco005tab3Bean.isChkDoc422()){
			semmco005tab3Bean.getContractCheckDoc().setDoc22("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc22("N");
		}
		if(semmco005tab3Bean.isChkDoc431()){
			semmco005tab3Bean.getContractCheckDoc().setDoc31("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc31("N");
		}
		if(semmco005tab3Bean.isChkDoc432()){
			semmco005tab3Bean.getContractCheckDoc().setDoc32("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc32("N");
		}
		if(semmco005tab3Bean.isChkDoc441()){
			semmco005tab3Bean.getContractCheckDoc().setDoc41("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc41("N");
		}
		if(semmco005tab3Bean.isChkDoc442()){
			semmco005tab3Bean.getContractCheckDoc().setDoc42("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc42("N");
		}
		if(semmco005tab3Bean.isChkDoc451()){
			semmco005tab3Bean.getContractCheckDoc().setDoc51("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc51("N");
		}
		if(semmco005tab3Bean.isChkDoc452()){
			semmco005tab3Bean.getContractCheckDoc().setDoc52("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc52("N");
		}
		if(semmco005tab3Bean.isChkDoc461()){
			semmco005tab3Bean.getContractCheckDoc().setDoc61("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc61("N");
		}
		if(semmco005tab3Bean.isChkDoc462()){
			semmco005tab3Bean.getContractCheckDoc().setDoc62("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc62("N");
		}
		if(semmco005tab3Bean.isChkDoc471()){
			semmco005tab3Bean.getContractCheckDoc().setDoc71("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc71("N");
		}
		if(semmco005tab3Bean.isChkDoc472()){
			semmco005tab3Bean.getContractCheckDoc().setDoc72("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc72("N");
		}
		if(semmco005tab3Bean.isChkDoc481()){
			semmco005tab3Bean.getContractCheckDoc().setDoc81("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc81("N");
		}
		if(semmco005tab3Bean.isChkDoc482()){
			semmco005tab3Bean.getContractCheckDoc().setDoc82("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc82("N");
		}
		if(semmco005tab3Bean.isChkDoc491()){
			semmco005tab3Bean.getContractCheckDoc().setDoc91("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc91("N");
		}
		if(semmco005tab3Bean.isChkDoc492()){
			semmco005tab3Bean.getContractCheckDoc().setDoc92("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc92("N");
		}
		if(semmco005tab3Bean.isChkDoc4101()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark4());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("N");
		}
		if(semmco005tab3Bean.isChkDoc4102()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark4());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("N");
		}
		
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}
	private void setRequestDocType5() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		if(semmco005tab3Bean.isChkDoc511()){
			semmco005tab3Bean.getContractCheckDoc().setDoc11("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc11("N");
		}
		if(semmco005tab3Bean.isChkDoc512()){
			semmco005tab3Bean.getContractCheckDoc().setDoc12("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc12("N");
		}
		if(semmco005tab3Bean.isChkDoc521()){
			semmco005tab3Bean.getContractCheckDoc().setDoc21("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc21("N");
		}
		if(semmco005tab3Bean.isChkDoc522()){
			semmco005tab3Bean.getContractCheckDoc().setDoc22("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc22("N");
		}
		if(semmco005tab3Bean.isChkDoc531()){
			semmco005tab3Bean.getContractCheckDoc().setDoc31("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc31("N");
		}
		if(semmco005tab3Bean.isChkDoc532()){
			semmco005tab3Bean.getContractCheckDoc().setDoc32("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc32("N");
		}
		if(semmco005tab3Bean.isChkDoc541()){
			semmco005tab3Bean.getContractCheckDoc().setDoc41("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc41("N");
		}
		if(semmco005tab3Bean.isChkDoc542()){
			semmco005tab3Bean.getContractCheckDoc().setDoc42("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc42("N");
		}
		if(semmco005tab3Bean.isChkDoc551()){
			semmco005tab3Bean.getContractCheckDoc().setDoc51("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc51("N");
		}
		if(semmco005tab3Bean.isChkDoc552()){
			semmco005tab3Bean.getContractCheckDoc().setDoc52("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc52("N");
		}
		if(semmco005tab3Bean.isChkDoc561()){
			semmco005tab3Bean.getContractCheckDoc().setDoc61("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc61("N");
		}
		if(semmco005tab3Bean.isChkDoc562()){
			semmco005tab3Bean.getContractCheckDoc().setDoc62("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc62("N");
		}
		if(semmco005tab3Bean.isChkDoc571()){
			semmco005tab3Bean.getContractCheckDoc().setDoc71("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc71("N");
		}
		if(semmco005tab3Bean.isChkDoc572()){
			semmco005tab3Bean.getContractCheckDoc().setDoc72("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc72("N");
		}
		if(semmco005tab3Bean.isChkDoc581()){
			semmco005tab3Bean.getContractCheckDoc().setDoc81("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc81("N");
		}
		if(semmco005tab3Bean.isChkDoc582()){
			semmco005tab3Bean.getContractCheckDoc().setDoc82("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc82("N");
		}
		if(semmco005tab3Bean.isChkDoc591()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark5());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("N");
		}
		if(semmco005tab3Bean.isChkDoc592()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark5());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("N");
		}
		
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}
	
	private void setRequestDocType6() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		if(semmco005tab3Bean.isChkDoc611()){
			semmco005tab3Bean.getContractCheckDoc().setDoc11("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc11("N");
		}
		if(semmco005tab3Bean.isChkDoc612()){
			semmco005tab3Bean.getContractCheckDoc().setDoc12("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc12("N");
		}
		if(semmco005tab3Bean.isChkDoc621()){
			semmco005tab3Bean.getContractCheckDoc().setDoc21("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc21("N");
		}
		if(semmco005tab3Bean.isChkDoc622()){
			semmco005tab3Bean.getContractCheckDoc().setDoc22("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc22("N");
		}
		if(semmco005tab3Bean.isChkDoc631()){
			semmco005tab3Bean.getContractCheckDoc().setDoc31("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc31("N");
		}
		if(semmco005tab3Bean.isChkDoc632()){
			semmco005tab3Bean.getContractCheckDoc().setDoc32("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc32("N");
		}
		if(semmco005tab3Bean.isChkDoc641()){
			semmco005tab3Bean.getContractCheckDoc().setDoc41("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc41("N");
		}
		if(semmco005tab3Bean.isChkDoc642()){
			semmco005tab3Bean.getContractCheckDoc().setDoc42("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc42("N");
		}
		if(semmco005tab3Bean.isChkDoc651()){
			semmco005tab3Bean.getContractCheckDoc().setDoc51("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc51("N");
		}
		if(semmco005tab3Bean.isChkDoc652()){
			semmco005tab3Bean.getContractCheckDoc().setDoc52("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc52("N");
		}
		if(semmco005tab3Bean.isChkDoc661()){
			semmco005tab3Bean.getContractCheckDoc().setDoc61("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc61("N");
		}
		if(semmco005tab3Bean.isChkDoc662()){
			semmco005tab3Bean.getContractCheckDoc().setDoc62("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc62("N");
		}
		if(semmco005tab3Bean.isChkDoc671()){
			semmco005tab3Bean.getContractCheckDoc().setDoc71("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc71("N");
		}
		if(semmco005tab3Bean.isChkDoc672()){
			semmco005tab3Bean.getContractCheckDoc().setDoc72("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc72("N");
		}
		if(semmco005tab3Bean.isChkDoc681()){
			semmco005tab3Bean.getContractCheckDoc().setDoc81("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc81("N");
		}
		if(semmco005tab3Bean.isChkDoc682()){
			semmco005tab3Bean.getContractCheckDoc().setDoc82("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc82("N");
		}
		if(semmco005tab3Bean.isChkDoc691()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark6());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("N");
		}
		if(semmco005tab3Bean.isChkDoc692()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark6());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("N");
		}
		
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}
	
	private void setRequestDocType7() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		if(semmco005tab3Bean.isChkDoc711()){
			semmco005tab3Bean.getContractCheckDoc().setDoc11("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc11("N");
		}
		if(semmco005tab3Bean.isChkDoc712()){
			semmco005tab3Bean.getContractCheckDoc().setDoc12("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc12("N");
		}
		if(semmco005tab3Bean.isChkDoc721()){
			semmco005tab3Bean.getContractCheckDoc().setDoc21("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc21("N");
		}
		if(semmco005tab3Bean.isChkDoc722()){
			semmco005tab3Bean.getContractCheckDoc().setDoc22("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc22("N");
		}
		if(semmco005tab3Bean.isChkDoc731()){
			semmco005tab3Bean.getContractCheckDoc().setDoc31("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc31("N");
		}
		if(semmco005tab3Bean.isChkDoc732()){
			semmco005tab3Bean.getContractCheckDoc().setDoc32("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc32("N");
		}
		if(semmco005tab3Bean.isChkDoc741()){
			semmco005tab3Bean.getContractCheckDoc().setDoc41("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc41("N");
		}
		if(semmco005tab3Bean.isChkDoc742()){
			semmco005tab3Bean.getContractCheckDoc().setDoc42("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc42("N");
		}
		if(semmco005tab3Bean.isChkDoc751()){
			semmco005tab3Bean.getContractCheckDoc().setDoc51("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc51("N");
		}
		if(semmco005tab3Bean.isChkDoc752()){
			semmco005tab3Bean.getContractCheckDoc().setDoc52("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc52("N");
		}
		if(semmco005tab3Bean.isChkDoc761()){
			semmco005tab3Bean.getContractCheckDoc().setDoc61("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc61("N");
		}
		if(semmco005tab3Bean.isChkDoc762()){
			semmco005tab3Bean.getContractCheckDoc().setDoc62("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc62("N");
		}
		if(semmco005tab3Bean.isChkDoc771()){
			semmco005tab3Bean.getContractCheckDoc().setDoc71("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc71("N");
		}
		if(semmco005tab3Bean.isChkDoc772()){
			semmco005tab3Bean.getContractCheckDoc().setDoc72("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc72("N");
		}
		if(semmco005tab3Bean.isChkDoc781()){
			semmco005tab3Bean.getContractCheckDoc().setDoc81("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc81("N");
		}
		if(semmco005tab3Bean.isChkDoc782()){
			semmco005tab3Bean.getContractCheckDoc().setDoc82("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc82("N");
		}
		if(semmco005tab3Bean.isChkDoc791()){
			semmco005tab3Bean.getContractCheckDoc().setDoc91("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc91("N");
		}
		if(semmco005tab3Bean.isChkDoc792()){
			semmco005tab3Bean.getContractCheckDoc().setDoc92("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc92("N");
		}
		if(semmco005tab3Bean.isChkDoc7101()){
			semmco005tab3Bean.getContractCheckDoc().setDoc101("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc101("N");
		}
		if(semmco005tab3Bean.isChkDoc7102()){
			semmco005tab3Bean.getContractCheckDoc().setDoc102("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc102("N");
		}
		if(semmco005tab3Bean.isChkDoc7111()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark7());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("N");
		}
		if(semmco005tab3Bean.isChkDoc7112()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark7());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("N");
		}
		
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}

	private void setRequestDocType8() {
		semmco005tab3Bean = getSemmco005tab3Bean();
		if(semmco005tab3Bean.isChkDoc811()){
			semmco005tab3Bean.getContractCheckDoc().setDoc11("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc11("N");
		}
		if(semmco005tab3Bean.isChkDoc812()){
			semmco005tab3Bean.getContractCheckDoc().setDoc12("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc12("N");
		}
		if(semmco005tab3Bean.isChkDoc821()){
			semmco005tab3Bean.getContractCheckDoc().setDoc21("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc21("N");
		}
		if(semmco005tab3Bean.isChkDoc822()){
			semmco005tab3Bean.getContractCheckDoc().setDoc22("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc22("N");
		}
		if(semmco005tab3Bean.isChkDoc831()){
			semmco005tab3Bean.getContractCheckDoc().setDoc31("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc31("N");
		}
		if(semmco005tab3Bean.isChkDoc832()){
			semmco005tab3Bean.getContractCheckDoc().setDoc32("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc32("N");
		}
		if(semmco005tab3Bean.isChkDoc841()){
			semmco005tab3Bean.getContractCheckDoc().setDoc41("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc41("N");
		}
		if(semmco005tab3Bean.isChkDoc842()){
			semmco005tab3Bean.getContractCheckDoc().setDoc42("Y");
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDoc42("N");
		}
		if(semmco005tab3Bean.isChkDoc851()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark8());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther1("N");
		}
		if(semmco005tab3Bean.isChkDoc852()){
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("Y");
			semmco005tab3Bean.getContractCheckDoc().setDocOtherRemark(semmco005tab3Bean.getRentalOtherRemark8());
		}else{
			semmco005tab3Bean.getContractCheckDoc().setDocOther2("N");
		}
		
		setSemmco005tab3Bean(semmco005tab3Bean);
		
	}
	
	private SEMMCO005Tab3Bean semmco005tab3Bean;
	
	public SEMMCO005Tab3Bean getSemmco005tab3Bean() {
		return (SEMMCO005Tab3Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005tab3Bean");
	}
	
	public void setSemmco005tab3Bean(SEMMCO005Tab3Bean semmco005tab3Bean) {
		this.semmco005tab3Bean = semmco005tab3Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco005tab3Bean", this.semmco005tab3Bean);
	}

	private SEMMCO005Bean semmco005Bean;
	
	public SEMMCO005Bean getSemmco005Bean() {
		return (SEMMCO005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005Bean");
	}

	public void setSemmco005Bean(SEMMCO005Bean semmco005Bean) {
		this.semmco005Bean = semmco005Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco005Bean", this.semmco005Bean);
	}
	
	private SEMMCO005Tab1Bean semmco005tab1Bean;
	
	public SEMMCO005Tab1Bean getSemmco005tab1Bean() {
		return (SEMMCO005Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005tab1Bean");
	}

	public void setSemmco005tab1Bean(SEMMCO005Tab1Bean semmco005tab1Bean) {
		this.semmco005tab1Bean = semmco005tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco005tab1Bean", this.semmco005tab1Bean);
	}

	private boolean validateTab3(){
		boolean flgValid = true;
		getSemmco005tab3Bean().getContractCheckDoc().setCheckDocStatus("Y");
		if("01".equals(getSemmco005tab3Bean().getContractCheckDoc().getRentalType())){
			if(!(getSemmco005tab3Bean().isChkDoc112() &&
			getSemmco005tab3Bean().isChkDoc122() &&
			getSemmco005tab3Bean().isChkDoc132() &&
			getSemmco005tab3Bean().isChkDoc142() &&
			getSemmco005tab3Bean().isChkDoc152() &&
			getSemmco005tab3Bean().isChkDoc162())){
				getSemmco005tab3Bean().getContractCheckDoc().setCheckDocStatus("N");
			}
		}else{
			if("02".equals(getSemmco005tab3Bean().getContractCheckDoc().getRentalType())){
				if(!(getSemmco005tab3Bean().isChkDoc212() &&
				getSemmco005tab3Bean().isChkDoc222() &&
				getSemmco005tab3Bean().isChkDoc232() &&
				getSemmco005tab3Bean().isChkDoc242() &&
				getSemmco005tab3Bean().isChkDoc252())){
					getSemmco005tab3Bean().getContractCheckDoc().setCheckDocStatus("N");
				}
			}else{
				if("03".equals(getSemmco005tab3Bean().getContractCheckDoc().getRentalType())){
					if(!(getSemmco005tab3Bean().isChkDoc312() &&
					getSemmco005tab3Bean().isChkDoc322() &&
					getSemmco005tab3Bean().isChkDoc332() &&
					getSemmco005tab3Bean().isChkDoc342() &&
					getSemmco005tab3Bean().isChkDoc352() &&
					getSemmco005tab3Bean().isChkDoc362())){
						getSemmco005tab3Bean().getContractCheckDoc().setCheckDocStatus("N");
					}
				}else{
					if("04".equals(getSemmco005tab3Bean().getContractCheckDoc().getRentalType())){
						if(!(getSemmco005tab3Bean().isChkDoc412() &&
						getSemmco005tab3Bean().isChkDoc422() &&
						getSemmco005tab3Bean().isChkDoc432() &&
						getSemmco005tab3Bean().isChkDoc442() &&
						getSemmco005tab3Bean().isChkDoc452() &&
						getSemmco005tab3Bean().isChkDoc462())){
							getSemmco005tab3Bean().getContractCheckDoc().setCheckDocStatus("N");
						}
					}else{
						if("05".equals(getSemmco005tab3Bean().getContractCheckDoc().getRentalType())){
							if(!(getSemmco005tab3Bean().isChkDoc512() &&
							getSemmco005tab3Bean().isChkDoc522() &&
							getSemmco005tab3Bean().isChkDoc532() &&
							getSemmco005tab3Bean().isChkDoc542() &&
							getSemmco005tab3Bean().isChkDoc552() &&
							getSemmco005tab3Bean().isChkDoc562())){
								getSemmco005tab3Bean().getContractCheckDoc().setCheckDocStatus("N");
							}
						}else{
							if("06".equals(getSemmco005tab3Bean().getContractCheckDoc().getRentalType())){
								if(!(getSemmco005tab3Bean().isChkDoc612() &&
								getSemmco005tab3Bean().isChkDoc622() &&
								getSemmco005tab3Bean().isChkDoc632() &&
								getSemmco005tab3Bean().isChkDoc642() &&
								getSemmco005tab3Bean().isChkDoc652() &&
								getSemmco005tab3Bean().isChkDoc662())){
									getSemmco005tab3Bean().getContractCheckDoc().setCheckDocStatus("N");
								}
							}else{
								if("07".equals(getSemmco005tab3Bean().getContractCheckDoc().getRentalType())){
									if(!(getSemmco005tab3Bean().isChkDoc812() && getSemmco005tab3Bean().isChkDoc822())){
												getSemmco005tab3Bean().getContractCheckDoc().setCheckDocStatus("N");
									}
								}else{
									if(!(getSemmco005tab3Bean().isChkDoc712() &&
											getSemmco005tab3Bean().isChkDoc722() &&
											getSemmco005tab3Bean().isChkDoc732() &&
											getSemmco005tab3Bean().isChkDoc742() &&
											getSemmco005tab3Bean().isChkDoc752() &&
											getSemmco005tab3Bean().isChkDoc762() &&
											getSemmco005tab3Bean().isChkDoc772() &&
											getSemmco005tab3Bean().isChkDoc782())){
												getSemmco005tab3Bean().getContractCheckDoc().setCheckDocStatus("N");
									}
								}
							}
					}
				}
				}
			}
		}
		
		return flgValid;
	}
	
}
