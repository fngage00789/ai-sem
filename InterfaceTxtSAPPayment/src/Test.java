public class Test {
	String[] arrStr = {"111","222","aaa","444","555"};

	public void doProcess(){				
		try{
			tranferOnWindow();			
		}catch(Exception e){
			e.printStackTrace(); 
		}
	}
	
	private void tranferOnWindow() {
		for(int i=0;i<5;i++){
			try {
				readDatToPayTBWin(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void readDatToPayTBWin(int i) throws Exception{
		insertSapPayTB(i);
	}
	
	private void insertSapPayTB(int i) throws Exception {
		System.out.println("arrStr["+i+"] = "+Integer.parseInt(arrStr[i]));
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.doProcess();
	}

}
