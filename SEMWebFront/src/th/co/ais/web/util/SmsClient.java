package th.co.ais.web.util;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

import th.co.ais.domain.rt.SMSModel;


public class SmsClient {
	
	public static boolean sendSMS(SMSModel smsM) {
		boolean result = false;
		Socket s1;
		String header = "";
		String content = "";
		String buffer = "";
		String form = smsM.getvHeader();
		PrintWriter pOut;
		BufferedReader in;
		int i;
		int ascii;	// ascii code
		int ch;
		String hexchar = new String();
		int unicode = 0 ;	// 0 = normal message , 1 = unicode message
		StringBuffer StrBuf1 = new StringBuffer();	// String buffer to keep unicode message
		Logger log = Logger.getLogger("SmsClient");
		
		String[] data = {smsM.getMobileNo(),smsM.getvMessage()}; 
		
	        // ##### Check Data format #####
		if (data[0].startsWith("-l")) {
//			System.out.println("=== Information ===");
//			System.out.println("FROM = SEM");
//			System.out.println("CODE = ADC");
//			System.out.println("TEXT = UNICODE|TEXT");
//			System.out.println("IP:PORT = 10.217.83.158:9007");
//			System.exit(-1);
		}
		if (!data[0].startsWith("66")) {
			System.out.println("Number Error : "+data[0]);
			log.info("Number Error : "+data[0]);
//			System.exit(-1);
		}
		if (data[1].length()<=0) {
			System.out.println("Message Error : "+data[1]);
			log.info("Message Error : "+data[1]);
//			System.exit(-1);
		}

	        // ##### Start Program #####
		try {
			int len = data[1].length();
			// for loop to check unicode ? and convert input to unicode format if input is unicode.
			for (i=0 ; i < len ; i++ ) {
				ascii = (int)data[1].charAt(i);

				if (ascii > 160) {
					hexchar = "";
					unicode = 1;
					if (ascii > 3584)
						ch = ascii - 3584;	// USC-4
					else
						ch = ascii - 160;	// UCS-2
					hexchar = Integer.toHexString(ch).toUpperCase(); // convert to hexcimal string
					if (hexchar.length() == 1) {
						StrBuf1.append("%0E%0");
						StrBuf1.append(hexchar);
					} else {
						StrBuf1.append("%0E%");
						StrBuf1.append(hexchar);
					}
				} else {
					hexchar = Integer.toHexString(ascii); // convert to hexcimal string
					if (hexchar.length() == 1) {
						StrBuf1.append("%00%0");
						StrBuf1.append(hexchar);
					} else {
						StrBuf1.append("%00%");
						StrBuf1.append(hexchar);
					}
				}
	                        //System.out.println(data[1].charAt(i)+" = "+ascii+" hex="+hexchar);
			}

			// ### This is unicode message. ###
			if (unicode==1) {
				log.info("unicode==1");
				if(data[1].length()>70) {
					log.info("data[1].length()>70");
					content = "TRANSID=PUSH&CMD=SENDMSG&FROM="+form+"&TO="+data[0]+"&CHARGE=N&REPORT=N&CODE=TEXT&CTYPE=LUNICODE&CONTENT="+StrBuf1;
//					content = "TRANSID=PUSH&CMD=SENDMSG&FROM="+form+"&TO="+"66879336964"+"&CHARGE=N&REPORT=N&CODE=TEXT&CTYPE=LUNICODE&CONTENT="+StrBuf1;
				} else {
					content = "TRANSID=PUSH&CMD=SENDMSG&FROM="+form+"&TO="+data[0]+"&CHARGE=N&REPORT=N&CODE=TEXT&CTYPE=UNICODE&CONTENT="+StrBuf1;
//					content = "TRANSID=PUSH&CMD=SENDMSG&FROM="+form+"&TO="+"66879336964"+"&CHARGE=N&REPORT=N&CODE=TEXT&CTYPE=UNICODE&CONTENT="+StrBuf1;
				}
			// ### This is normal text. ###
			} else {
				if(data[1].length()>140) {
					log.info("data[1].length()>140");
					content = "TRANSID=PUSH&CMD=SENDMSG&FROM="+form+"&TO="+data[0]+"&CHARGE=N&REPORT=N&CODE=TEXT&CTYPE=LTEXT&CONTENT="+URLEncoder.encode(data[1]);
//					content = "TRANSID=PUSH&CMD=SENDMSG&FROM="+form+"&TO="+"66879336964"+"&CHARGE=N&REPORT=N&CODE=TEXT&CTYPE=LTEXT&CONTENT="+URLEncoder.encode(data[1]);
				} else {
					content = "TRANSID=PUSH&CMD=SENDMSG&FROM="+form+"&TO="+data[0]+"&CHARGE=N&REPORT=N&CODE=TEXT&CTYPE=TEXT&CONTENT="+URLEncoder.encode(data[1]);
//					content = "TRANSID=PUSH&CMD=SENDMSG&FROM="+form+"&TO="+"66879336964"+"&CHARGE=N&REPORT=N&CODE=TEXT&CTYPE=TEXT&CONTENT="+URLEncoder.encode(data[1]);
				}
			}

            //System.out.println("OATCOMMENT: Content="+content+" length="+data[1].length());
			log.info("Message: "+ data[1]);
			//s1 = new Socket("10.218.1.70",9007);
			//PROD
//            s1 = new Socket("10.217.83.158",9007);
            //DEV
			s1 = new Socket("10.104.130.37",9007);
		    pOut = new PrintWriter(s1.getOutputStream(),true);
	        header = "POST / HTTP/1.1\r\nReferer: http://10.216.56.103/test.html\r\nConnection: Keep-Alive\r\nHost: 10.216.56.101\r\nAccept: \r\nAccept-Encoding: gzip\r\nAccept-Language: en\r\nAccept-Charset: iso-8859-1,*,utf-8\r\nContent-type: application/x-www-form-urlencoded\r\nContent-Length: "+content.length()+"\r\n\r\n";
	        //header = "POST / HTTP/1.1\r\nReferer: http://10.138.32.103/test.html\r\nConnection: Keep-Alive\r\nHost: 10.138.32.103\r\nAccept: \r\nAccept-Encoding: gzip\r\nAccept-Language: en\r\nAccept-Charset: iso-8859-1,*,utf-8\r\nContent-type: application/x-www-form-urlencoded\r\nContent-Length: "+content.length()+"\r\n\r\n";
	        buffer = header + content;
	        log.info("Header: "+header);
	        log.info("Content: "+content);
	        log.info("Buffer: "+buffer.toString());
			pOut.println(buffer);
			in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			String resp = in.readLine();

            // ### Check Response ###
			if (resp==null) {
                // ###### ERROR: Write File at /export/home/tanaputp/SMS/SMSWait ######
                System.out.println("ERROR");
                log.info("ERROR resp is null");
                result = false;

			} else {
				if (resp.compareTo("HTTP/1.1 200 OK") == 0) {
                    // ###### OK: Write File at /export/home/tanaputp/SMS/SMSSuccess ######
                    System.out.println("SEND SUCCESS");
                    log.info("SEND SUCCESS");
                    result = true;

				} else {
                    // ###### Write File at /export/home/tanaputp/SMS/SMSWait ######
                    System.out.println("ERROR");
                    log.info("ERROR Not 200 is : "+ resp);
                    result = false;
				}
			}

            pOut.close();
//            in.close();
            s1.close();
		}

		catch (Exception e) {
			System.out.println("Opp: "+e);
			log.info("Opp: "+e.getMessage());
		}
		return result;
	}
}
