package com.ais;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

import th.co.ais.domain.gm.Employee;
import th.co.ais.domain.gm.TransPayment;
import th.co.ais.domain.sap.SapMapping;
import th.co.ais.domain.sap.SapTrxDtl;
import th.co.ais.util.SAPUtility;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.util.SerializeManager;
import th.co.ais.web.util.WebUtil;
import Permission.bean.ais.com.SSOCompCode;
import Permission.bean.ais.com.SSOProgCode;

public class JUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
		try {
			testSSO();
			//search();
			//search2();
			
			//SSOCompCode compCode = getPermission("SEM0008", "ddlApproveType");
			//String desc = compCode.getCompDesc();		
			//doSFTP();			
			//testSAP();			
			
			/*Date dNow = new Date();
			String SAP_OUTPUT_FILE = "C:/Documents and Settings/vorapt49/Desktop/Projects/SEM/SAP/output/SSGXXG1_COMPANY CODE_YYYYMMDD_XXXX.txt";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmm", Locale.ENGLISH);
			System.out.println("Show Date >> "+ sdf.format(dNow));*/			
			
			//Double d = 6000.1245;
			//System.out.println(String.format("%.2f", d));
			//System.out.println(String.format("%04d", 100)); //0100			
			//System.out.println("Next File: "+getNextFile());
			//testSortList();
			//testGetNextSAPFile();			
			
			/*Double a = 7.00;
			System.out.println(""+ String.format("%02d", a));*/
			
		}catch (Exception e) {
			System.out.println("Exception >> "+e.getMessage());
			e.printStackTrace();			
		}
	}
	
	private void testGetNextSAPFile() throws Exception{
		/*Employee employee = new Employee();
		employee.setUserStamp("ekarutwa");
		employee.setCompanyCode("MMT");
		String nextFile = SAPUtility.getNextFileName(employee, "20101115");
		System.out.println(nextFile);*/
		
		/*String filePath = "/SEM/Interface_SAP/Outbound/SEMPA*YYYYMMDD*XXXX.dat";
		int lastSlash = filePath.lastIndexOf("/")+1;
		String path = filePath.substring(0, lastSlash);
		String fileName = "";
		if(lastSlash < filePath.length()-1){
			fileName = filePath.substring(lastSlash, filePath.length());
		}
		System.out.println("Path: "+path);
		System.out.println("File (before): "+fileName);
		
		String regxFile = "";
		if(fileName.indexOf("*") > -1){
			regxFile = "^(" + fileName.replace("*", ").*(") + ")";
		}
		System.out.println("File (after): "+fileName);*/
		
		//String path = "sem_path=C:\\Documents and Settings\\vorapt49\\Desktop\\Projects\\SEM\\SEMFiles\\SEM\\Outbound\\";
		//System.out.println("Path: "+ path.replace("\\", "/"));
		
		//System.out.println();
	}
	private void testSortList(){
		/*List<Integer> listRunning = new ArrayList<Integer>();
		listRunning.add(4);
		listRunning.add(2);
		listRunning.add(1);
		listRunning.add(9);
		listRunning.add(8);
		Integer[] runnings = listRunning.toArray(new Integer[0]);		
		Arrays.sort(runnings);
		//Arrays.sort(runnings, Collections.reverseOrder());
		for (Integer i : runnings) {
            System.out.println(i.intValue());
        }*/
	}
	private void testInvokeMethod(){
		/*SapTrxDtl detail = new SapTrxDtl(1, "0001", "T_002","001","D","G","3300001",6000.00,6000.00,"15000","20101111");
		Method method = Class.forName("th.co.ais.domain.sap.SapTrxDtl").getDeclaredMethod("getLinitmtxt", null);
		Object obj = method.invoke(detail, new Object[0]);
		if(obj==null){
			System.out.println("Linitmtxt is null");
		}else{
			System.out.println("Linitmtxt: "+obj.toString());
		}
		
		Method methodChild = Class.forName(obj.getClass().getName()).getDeclaredMethod("getLogid", null);
		Object obj2 = methodChild.invoke(obj, new Object[0]);		
		String logid = obj2.toString();
		System.out.println("LOGID: "+logid);*/
	}
	public static String getNextFile(){ //1,2,3,4,5
		int nextNumber=1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);			
		String yyyyMMdd = sdf.format(new Date());
		String srcPath = WebUtil.getResources("resources.sap", "sap_source_path");
		String fmtFile = WebUtil.getResources("resources.sap", "sap_source_file");
		String prefix = fmtFile.replaceAll("XXXX.dat", "").replaceAll("YYYYMMDD", yyyyMMdd);
		List<Integer> suffixList = new ArrayList<Integer>();
		File dir = new File(srcPath);
		if(dir.isDirectory()){
			FilenameFilter filter = new FileListFilter(prefix, null);
			File[] files = dir.listFiles(filter);
			for(File f : files){
				String fName = f.getName();
				System.out.println(fName);
				fName = fName.substring(0, fName.indexOf("."));
				String[] prtOfNames = fName.split("_");					
				int suffix = Integer.parseInt(prtOfNames[prtOfNames.length-1]);
				suffixList.add(suffix);
								
			}
		}
		if(suffixList.size()>0){
			Integer[] suffixArray = suffixList.toArray(new Integer[0]);
			Arrays.sort(suffixArray);
			nextNumber = suffixArray[suffixArray.length-1]+1;
		}
		return prefix.concat(String.format("%04d", nextNumber));//nextNumber;
	}
	
	private void testSAP(){
		try {
			/*List<SapMapping> sapMap = new ArrayList<SapMapping>();
			List<TransPayment> tPayment = new ArrayList<TransPayment>();
			
			//Prepare SapMapping List
			SapMapping s = new SapMapping();
			s.setFieldName("REFSSG");
			s.setFieldDbName("TransPaymentId");
			sapMap.add(s);
			
			s = new SapMapping();
			s.setFieldName("COMCOD");
			s.setFieldDbName("Hello");
			sapMap.add(s);
			
			s = new SapMapping();
			s.setFieldName("COMCOD");
			s.setFieldDbName("Company");
			sapMap.add(s);*/
			
			//Prepare TransPayment List
			/*TransPayment t = new TransPayment();
			t.setRowId("SGIR01100000001");
			t.setCompany("AIS");
			tPayment.add(t);*/
			
			
			//FileSystemResource fsr = new FileSystemResource("D:/officework/workspace/SEM/SEMWebApp/WebContent/WEB-INF/applicationContext.xml");
			//XmlBeanFactory factory = new XmlBeanFactory(fsr);
			//System.out.println(" 1111 ");
			//PaymentServiceImpl pImpl = (PaymentServiceImpl)factory.getBean("paymentService");			
			//System.out.println(" dataSource : "+factory.getBean("dataSource"));
			//System.out.println(" transPaymentDao : "+factory.getBean("transPaymentDao"));
			
			/*ApplicationContext appcontext = new FileSystemXmlApplicationContext( new String[] {
					//"D:/officework/workspace/SEM/SEMWebFront/WebContent/WEB-INF/applicationContext-http-gm.xml"
					"D:/officework/workspace/SEM/SEMWebApp/WebContent/WEB-INF/applicationContext.xml"
					});
			System.out.println("paymentService : "+appcontext.getBean("paymentService"));*/
			
			/*List<Method> pmMethods = Arrays.asList(TransPayment.class.getDeclaredMethods());
			for (Method method : pmMethods)
		    {
				System.out.println("Method : "+method.getName());
				Column column = method.getAnnotation(Column.class);
				if(column!=null){
					System.out.println("name,length,precision,scale : "+
									column.name().concat(",")
									.concat(String.valueOf(column.length())).concat(",")
									.concat(String.valueOf(column.precision())).concat(",")
									.concat(String.valueOf(column.scale())));
				}		
		    }*/
			
			/*FileWriter fileWriter= new FileWriter("C:/Documents and Settings/vorapt49/Desktop/Projects/SEM/SAP/testSAP.txt",true);		
			BufferedWriter bufWriter = new BufferedWriter(fileWriter);
			PrintWriter pw = new PrintWriter(bufWriter);			
			for(TransPayment tp : tPayment){
				int countCol = 0;
				for(SapMapping sm : sapMap){
					if(null!=sm.getFieldDbName() && !"".equals(sm.getFieldDbName())){
						String mName = "get".concat(sm.getFieldDbName());
						Method method = null;
						try {
							method = tp.getClass().getDeclaredMethod(mName, null);
							Object fieldValue = method.invoke(tp, new Object[0]);
							System.out.println(method.getName()+" = "+fieldValue);						
							if(countCol < sapMap.size()-1){
								pw.print(fieldValue);
								pw.print("|");
							}else{
								pw.println(fieldValue);
							}
								
						} catch (NoSuchMethodException e) {
							System.out.println("[Method name '"+mName+"' not found.]");
						}	
					}
				}
			}
			pw.close();
			bufWriter.close();
			fileWriter.close();*/
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void testSSO(){
		/*try {
			//EmployeeServiceWebServiceV2 empService = (new EmployeeServiceWebServiceV2ServiceLocator()).getEmployeeServiceWebServiceV2SoapPort();
			//SSOResponse resp = empService.getAllPermission("Zv6TM2JppRTb2RGdmLpJYdl73j7JxD8TlLJLk82JCz2f890GnNLH!1200885014!1282823230781,vorapt49,142,176,null");
			//SSOProgCode[] allProgCode = resp.getSSOProgCodecArr();
			//SSOCompCode[] allCompCode = resp.getSSOCompCode();
			
			SsoBean ssoBean = (SsoBean)SerializeManager.read(SSOLoginServlet.SSO_SERIALIZE_PATH+"ssoBean_rapeesuw.xml");
			SSOProgCode[] allProgCode = ssoBean.getSsoProgCodes();
			SSOCompCode[] allCompCode = ssoBean.getSsoCompCodeAll();			
			
			HashMap<String, SSOCompCode[]> mapC = new HashMap<String, SSOCompCode[]>();
			for (SSOProgCode pc : allProgCode) {
				if(!mapC.containsKey(pc.getProgCodeName())){
					
					int index = Arrays.binarySearch(allCompCode, pc.getProgCodeId());
					index = index;

					Arrays.copyOfRange(original, from, to)					
					Binary Search
					Comparator<SSOCompCode> c = new Comparator<SSOCompCode>() {
				      public int compare(SSOCompCode c1, SSOCompCode c2) {
				    	  if(c1.getProgCodeId()==c2.getProgCodeId()) return 0;
				    	  else if(c2.getProgCodeId()<c1.getProgCodeId()) return -1;
				    	  else return 1;				    	  
				      }
				    };
					SSOCompCode key = new SSOCompCode();
					key.setProgCodeId(pc.getProgCodeId());
					int index = Collections.binarySearch(Arrays.asList(allCompCode), key, c);
					if(index>-1){
						SSOCompCode comp = Arrays.asList(allCompCode).get(index);
					}
				}
			}	
		} catch (Exception e) {
			 
		}*/
		
		
	}
	
	public void search(){		
		/*String value=null;
		String queryString = "id=0001&flag=decreaseCounter&name=hello&group=AIS";
		String key="group";		
		List<String> qryStrs = Arrays.asList(queryString.split("&"));
		Comparator<String> c = new Comparator<String>() {
			public int compare(String left, String right) {
			  String[] part = left.split("=");
	    	  if(part.length==2 || part.length==1){
	    		  if(part[0].length() <= right.length())
	    			  return part[0].compareTo(right);
	    		  else
	    			  return right.compareTo(part[0]);
	    	  }else{
	    		  return -1;
	    	  }
	      }
	    };		    
		int index = Collections.binarySearch(qryStrs, key, c);Collections.binarySearch(qryStrs, name, c);
		if(index>-1){
			String[] part = qryStrs.get(index).split("=");
			if(part.length==2){					
				value = part[1];					
			}else{
				value = "";
			}
			System.out.println("Value of "+key+" >> "+value);
		}else{
			System.out.println("Not found!!!");
		}*/
	}
	public void search2() throws Exception{
		/*SSOResponse respP = (SSOResponse)SerializeManager.read(SSOLoginServlet.SSO_SERIALIZE_PATH+"ssoAllPermission.xml");
		SSOProgCode[] allProgCode = respP.getSSOProgCodecArr();
		SSOCompCode[] allCompCode = respP.getSSOCompCode();
		List<SSOCompCode> allCompCodeList = Arrays.asList(allCompCode);
		
		HashMap<String, SSOCompCode[]> mapC = new HashMap<String, SSOCompCode[]>();
		for (SSOProgCode sp : allProgCode) {				
			if(!mapC.containsKey(sp.getProgCodeName())){
				
				SSOCompCode key = new SSOCompCode();
				key.setProgCodeId(sp.getProgCodeId());				

				int index = Arrays.binarySearch(allCompCode, key);
				index = index;
			}
		}*/
		
	}	
	public static String SSO_SERIALIZE_PATH = "D:/officework/workspace/SEM/SEMWebFront/WebContent/serialize/";
	public SSOCompCode getPermission(String progCode, String comCode) throws Exception{
		SSOCompCode compCode = null;				
		/*try {
			*** Fix *** 
			SsoBean ssoBean = (SsoBean)SerializeManager.read(SSO_SERIALIZE_PATH.concat("ssoBean_vorapt49.xml"));
			HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
			SsoBean ssoBean = (SsoBean)request.getSession().getAttribute("ssoBean");
		    
			SSOCompCode[] compCodes = null;
		    if(ssoBean!=null && comCode!=null && !"".equals(comCode)){
		    	Map<String, SSOCompCode[]> map = ssoBean.getSsoCompCodes();
				if(map!=null){
					if(map.containsKey(progCode)){
						compCodes = map.get(progCode);
						
						if(null!=compCodes){
							Comparator<SSOCompCode> c = new Comparator<SSOCompCode>() {
						      public int compare(SSOCompCode c1, SSOCompCode c2) {
						    	  return c1.getCompCode().compareTo(c2.getCompCode());				    	  
						      }
						    };
							SSOCompCode key = new SSOCompCode();
							key.setCompCode(comCode);
							int index = Collections.binarySearch(Arrays.asList(compCodes), key, c);
							if(index>-1){
								compCode = Arrays.asList(compCodes).get(index);
							}
						}
					}
				}
		    }
		} catch (Exception e) {
			throw e;
		}*/
		return compCode;
	}
	public void doSFTP() throws Exception {
		/*String  host="",
				userName="",
				password="",
				filePath="";
		int port = 22;
		
		SshClient ssh = new SshClient(); 
		ssh.connect(host, port); 
		Authenticate 
		PasswordAuthenticationClient passwordAuthenticationClient = new PasswordAuthenticationClient(); 
		passwordAuthenticationClient.setUsername(userName); 
		passwordAuthenticationClient.setPassword(password); 
		int result = ssh.authenticate(passwordAuthenticationClient); 
		if(result != AuthenticationProtocolState.COMPLETE){ 
		     throw new Exception("Login to " + host + ":" + port + " " + userName + "/" + password + " failed"); 
		} 
		Open the SFTP channel 
		SftpClient client = ssh.openSftpClient(); 
		Send the file 
		client.put(filePath); 
		disconnect 
		client.quit(); 
		ssh.disconnect(); */
	}
}


class FileListFilter implements FilenameFilter {
  private String name;
  private String extension; 

  public FileListFilter(String name, String extension) {
    this.name = name;
    this.extension = extension;
  }

  public boolean accept(File directory, String filename) {
    boolean fileOK = true;

    if (name != null) {
      fileOK &= filename.startsWith(name);
    }

    if (extension != null) {
      fileOK &= filename.endsWith('.' + extension);
    }
    return fileOK;
  }
}