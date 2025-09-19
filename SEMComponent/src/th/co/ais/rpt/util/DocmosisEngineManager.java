package th.co.ais.rpt.util;

import com.docmosis.SystemManager;

public class DocmosisEngineManager {
	public void startEngine(){
		System.out.println("### start engine ###");
		if (!SystemManager.isInitialized()){
			SystemManager.initialise();
			System.out.println("### start initialise ###");
		}
	}
	
	public void stopEngine(){
		System.out.println("### stop engine ###");
		if (SystemManager.isInitialized()){
			SystemManager.release();
			System.out.println("### stop release ###");
		}
	}
}
