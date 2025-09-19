package th.co.ais.rpt.util;

import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.springframework.beans.factory.FactoryBean;

public class StringDecryptFactoryBean implements FactoryBean{
	
	private PBEStringEncryptor pBEStringEncryptor = null;
	private String decryptString = null;
	
	
	
	public void setDecryptString(String decryptString) {
		this.decryptString = decryptString;
	}

	public void setPBEStringEncryptor(PBEStringEncryptor stringEncryptor) {
		pBEStringEncryptor = stringEncryptor;
	}

	public Object getObject() throws Exception {
		String output = null;
		try {
			output = pBEStringEncryptor.decrypt(decryptString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	public Class getObjectType() {
		return String.class;
	}

	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
