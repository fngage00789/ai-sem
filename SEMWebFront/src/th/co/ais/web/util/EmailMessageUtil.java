package th.co.ais.web.util;
import javax.faces.context.FacesContext;
import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;

//import org.jacorb.notification.util.LogUtil;

import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.web.action.AbstractBaseAction;
import th.co.ais.web.util.SemUtils;

import java.io.Serializable;
import java.util.*;

public class EmailMessageUtil implements Serializable{
	 // ################# E-Mail Information Section ################
    private static String SMTP_HOST_NAME = "mail.corp.ais900.org";
//    private static String SMTP_HOST_NAME = "mailgw.channel.ais.co.th";
    //private static String SMTP_HOST_NAME = "10.13.201.24";
   // private static String SMTP_PORT = "25";
    //private static String FROM = "slimsAdmin@ais.co.th";
    private static String FROM = "slimsAdmin@ais.co.th";
    private static String TO = "casnewva@gmail.com";
    private static String SUBJECT = "Test send email.";
    private static String MESSAGE = "Test Body Text.";
    
    
    

    public static boolean sendEmail(EMAILModel emailM){
    	boolean result = false;
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
       // props.put("mail.smtp.port", SMTP_PORT);
        
        Logger log = Logger.getLogger("EmailMessageUtil");

        Session session = Session.getInstance(props, null);
        session.setDebug(false);
        Date now = new Date();
        boolean ckSendMail = false;
        
        if(emailM != null && !emailM.getEmail_from().equals("")){
        	// log.info("EmailMessageUtil email from : "+emailM.getEmail_from());
        	// System.out.println("EmailMessageUtil email from : "+emailM.getEmail_from());
        	log.info(FROM);
        	System.out.println(FROM);
        	log.info("EmailMessageUtil email To : "+emailM.getEmail_to());
        	System.out.println("EmailMessageUtil email To : "+emailM.getEmail_to());
        	// FROM = emailM.getEmail_from();
        	TO = emailM.getEmail_to();
        	SUBJECT = emailM.getV_Subject();
        	MESSAGE = emailM.getV_Message();
        }
        try {
	          MimeMessage message = new MimeMessage(session);
	          message.setFrom(new InternetAddress(FROM));
	          InternetAddress[] to_address = InternetAddress.parse(TO);
	          //InternetAddress[] cc_address = InternetAddress.parse(CC);
	          message.setRecipients(Message.RecipientType.TO, to_address);
	         // message.setRecipients(Message.RecipientType.CC, cc_address);
	          message.setSubject(SUBJECT);
	
	          MimeBodyPart mbp = new MimeBodyPart();
	          mbp.setText(MESSAGE, "UTF-8");
	          mbp.setHeader("Content-Type", "text/plain; charset=\"utf-8\"");
	
	          Multipart content = new MimeMultipart();
	          content.addBodyPart(mbp);
	
	          message.setContent(content);
	          Transport.send(message);
	
	          result = true;
        } catch (MessagingException mex) {
        	log.info("\n--Exception handling in msgsendsample.java");
        	log.info(now + " :: ==>> " + mex);
        	System.out.println("\n--Exception handling in msgsendsample.java");
        	System.out.println(now + " :: ==>> " + mex);

        } catch (Exception e) {
              e.printStackTrace();
        }finally{
              if(result){
            	  log.info("Send E-Mail Success..");
            	  System.out.println("Send E-Mail Success..");
              }else {
            	  log.info("Send E-Mail Fail..");
            	  System.out.println("Send E-Mail Fail..");
              }
              log.info("Run Mail Done...");
        }
        return result;
  }

    
}
