package th.co.ais.rpt.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

@SuppressWarnings("unchecked")
public class DataUtil {

	private static final Logger log = Logger.getLogger(DateUtil.class);
	public static String th_unit = "\u0E1A\u0E32\u0E17", th_tuan = "\u0E16\u0E49\u0E27\u0E19", th_stang = "\u0E2A\u0E15\u0E32\u0E07\u0E04\u0E4C", th_ten = "\u0E2A\u0E34\u0E1A", th_hundred = "\u0E23\u0E49\u0E2D\u0E22", th_thousand = "\u0E1E\u0E31\u0E19", th_ten_thousand = "\u0E2B\u0E21\u0E37\u0E48\u0E19", th_hundred_thousand = "\u0E41\u0E2A\u0E19", th_million = "\u0E25\u0E49\u0E32\u0E19";
	public static String th_zero = "\u0E28\u0E39\u0E19\u0E22\u0E4C", th_one = "\u0E2B\u0E19\u0E36\u0E48\u0E07", th_two = "\u0E2A\u0E2D\u0E07",  th_three = "\u0E2A\u0E32\u0E21", th_four = "\u0E2A\u0E35\u0E48", th_five = "\u0E2B\u0E49\u0E32", th_six = "\u0E2B\u0E01", th_seven = "\u0E40\u0E08\u0E47\u0E14", th_eight = "\u0E41\u0E1B\u0E14", th_nine = "\u0E40\u0E01\u0E49\u0E32",th_aed = "\u0E40\u0E2D\u0E47\u0E14", th_twenty = "\u0E22\u0E35\u0E48";
	public static String th_year = "\u0E1B\u0E35", th_month = "\u0E40\u0E14\u0E37\u0E2D\u0E19", th_day = "\u0E27\u0E31\u0E19";
	private static String mtch[] = {"", DataUtil.th_one, DataUtil.th_two, DataUtil.th_three, DataUtil.th_four, DataUtil.th_five, DataUtil.th_six, DataUtil.th_seven, DataUtil.th_eight, DataUtil.th_nine};
	private static String mtdec[] = {DataUtil.th_thousand, DataUtil.th_hundred, DataUtil.th_ten, DataUtil.th_million, DataUtil.th_hundred_thousand, DataUtil.th_ten_thousand, DataUtil.th_thousand, DataUtil.th_hundred, DataUtil.th_ten, "" };
	private static String mstnum = "", mstthai = "", choice1 = "", cnumthai = "", cin_number = "", tmp_key = "";
	private static long ncnt = 1, nlen = 0, nlen2 = 0, nnumber = 0, din_number2 = 0;
	private static BigDecimal din_number3 = new BigDecimal(0);
	
	public static String separator4OS(){
		if ("W".equals(System.getProperty("os.name").substring(0, 1).toUpperCase())) {
			return "\\";
		} else {
			return "/";
		}
	}
	public static String convertNull2String(Object obj) {
		return (obj != null ? obj.toString() : "");
	}

	public static BigDecimal converString2BigDecimal(String in_number) {
		if (StringUtils.isNotEmpty(in_number)) {
			Double d_number = Double.parseDouble(in_number);
			if ((d_number > 0) && (d_number < 9999999999.99)) {
				return BigDecimal.valueOf(d_number);
			}
		}
		return null;
	}
	
	public static String convert2Abridgement(String abridgement) {
		if (StringUtils.isNotEmpty(abridgement) && "Y".equals(abridgement)) {
			return th_year;
		} else if (StringUtils.isNotEmpty(abridgement) && ("M".equals(abridgement) || "01".equals(abridgement))) {
			return th_month;
		} else if (StringUtils.isNotEmpty(abridgement) && "D".equals(abridgement)) {
			return th_day;	
		}	
		return abridgement;
	}
	
	public static String convert2ThaiBath(String in_number) {
		if (StringUtils.isNotEmpty(in_number)) {
			Double d_number = Double.parseDouble(in_number);
			if ((d_number > 0) && (d_number < 9999999999.99)) {
				return convert2ThaiBath(d_number);
			}
		}
		return "";
	}
	
	public static String convert2ThaiBathSA(BigDecimal in_number) {
		return (in_number != null ? convert2ThaiBathSiteAcq(
					in_number) : "");
	}

	public static String convert2ThaiBath(BigDecimal in_number) {
		return (in_number != null ? convert2ThaiBath(
					Double.parseDouble(in_number.toString())) : "");
	}
	
	public static String convert2ThaiLanguage(BigDecimal in_number) {
		return (in_number != null ? convert2ThaiLanguage(
					Double.parseDouble(in_number.toString())) : "");
	}

	public static String convert2ThaiLanguage(Double in_number) {	
		cnumthai = "";
		if (in_number != null) {
			if ((in_number > 9999999999.99) || (in_number < 0)) {
				cnumthai = "";
			} else if (in_number == 0) {
				cnumthai += th_zero ;
			} else {
				din_number2 = (long) (in_number * 100);
				cin_number = Long.toString(din_number2);
				mstnum = cin_number;
				nlen = cin_number.length();
				nlen2 = 12 - nlen;
	
				for (int xj = 0; xj < nlen2; xj++) {
					mstnum = "x" + mstnum;
				}
	
				int ye = 0;
				for (int xe = 0; xe < 10; xe++) {
					String ccharnum = mstnum.substring(xe, xe + 1);
					if (ccharnum.equals("x")) {
						cnumthai = cnumthai + "";
					} else {
						
						if (ccharnum.equals("0")) {
							if (ye != 3){
								if (xe == 4) {
									cnumthai = cnumthai + th_million;
								} else {
									cnumthai = cnumthai + "";
								}
							}
						} else {
							if (ccharnum.equals("1")) {
								if ((xe == 3 && nlen != 9) || (xe == 9 && nlen != 3)){
									cnumthai = cnumthai + th_aed;
								} else {
									if (xe != 2 && xe != 8) {
										cnumthai = cnumthai + mtch[(int) Long.parseLong(ccharnum)];
									}
								}
							} else {
								if (ccharnum.equals("2") && (xe == 2 || xe == 8)) {
									cnumthai = cnumthai + th_twenty;
								} else {
									cnumthai = cnumthai + mtch[(int) Long.parseLong(ccharnum)];
								}
							}
							cnumthai = cnumthai + mtdec[xe];
							ye = xe;
						}
					}
				}
				cnumthai = cnumthai;
	
				String ccharnum = mstnum.substring(10);
				if (ccharnum.equals("00")) {
					cnumthai = cnumthai;
				} else {
					ccharnum = mstnum.substring(10, 11);
					if (!(ccharnum.equals("0"))) {
						if (!ccharnum.equals("1")) {
							if (ccharnum.equals("2")) {
								cnumthai = cnumthai + th_twenty;
							} else {
								cnumthai = cnumthai + mtch[(int) Long.parseLong(ccharnum)];
							}
						}
						cnumthai = cnumthai + mtdec[8];
					}
	
					String ccharnum1 = mstnum.substring(11);
					if (!ccharnum1.equals("0")) {
						if (ccharnum1.equals("1") || ccharnum.equals("0")) {
							cnumthai = cnumthai + th_aed;
						} else {
							cnumthai = cnumthai + mtch[Integer.parseInt(ccharnum1)];
						}
					}
					cnumthai = cnumthai + th_stang;
				}
			}
		}
		return cnumthai;
	}
	
	public static String convert2ThaiBath(Double in_number) {	
		cnumthai = "";
		if (in_number != null) {
			if ((in_number > 9999999999.99) || (in_number < 0)) {
				cnumthai = "";
			} else if (in_number == 0) {
				cnumthai += th_zero + th_unit + th_tuan;
			} else {
				din_number2 = (long) (in_number * 100);
				cin_number = Long.toString(din_number2);
				mstnum = cin_number;
				nlen = cin_number.length();
				nlen2 = 12 - nlen;
	
				for (int xj = 0; xj < nlen2; xj++) {
					mstnum = "x" + mstnum;
				}
	
				int ye = 0;
				for (int xe = 0; xe < 10; xe++) {
					String ccharnum = mstnum.substring(xe, xe + 1);
					if (ccharnum.equals("x")) {
						cnumthai = cnumthai + "";
					} else {
						
						if (ccharnum.equals("0")) {
							if (ye != 3){
								if (xe == 4) {
									cnumthai = cnumthai + th_million;
								} else {
									cnumthai = cnumthai + "";
								}
							}
						} else {
							if (ccharnum.equals("1")) {
								if ((xe == 3 && nlen != 9) || (xe == 9 && nlen != 3)){
									cnumthai = cnumthai + th_aed;
								} else {
									if (xe != 2 && xe != 8) {
										cnumthai = cnumthai + mtch[(int) Long.parseLong(ccharnum)];
									}
								}
							} else {
								if (ccharnum.equals("2") && (xe == 2 || xe == 8)) {
									cnumthai = cnumthai + th_twenty;
								} else {
									cnumthai = cnumthai + mtch[(int) Long.parseLong(ccharnum)];
								}
							}
							cnumthai = cnumthai + mtdec[xe];
							ye = xe;
						}
					}
				}
				cnumthai = cnumthai + th_unit;
	
				String ccharnum = mstnum.substring(10);
				if (ccharnum.equals("00")) {
					cnumthai = cnumthai + th_tuan;
				} else {
					ccharnum = mstnum.substring(10, 11);
					if (!(ccharnum.equals("0"))) {
						if (!ccharnum.equals("1")) {
							if (ccharnum.equals("2")) {
								cnumthai = cnumthai + th_twenty;
							} else {
								cnumthai = cnumthai + mtch[(int) Long.parseLong(ccharnum)];
							}
						}
						cnumthai = cnumthai + mtdec[8];
					}
	
					String ccharnum1 = mstnum.substring(11);
					if (!ccharnum1.equals("0")) {
						if (ccharnum1.equals("1") || ccharnum.equals("0")) {
							cnumthai = cnumthai + th_aed;
						} else {
							cnumthai = cnumthai + mtch[Integer.parseInt(ccharnum1)];
						}
					}
					cnumthai = cnumthai + th_stang;
				}
			}
		}
		return cnumthai;
	}
	
	public static String convert2ThaiBathSiteAcq(BigDecimal in_number) {	
		cnumthai = "";
		if (in_number != null) {
			if ((in_number.doubleValue() > 9999999999.99) || (in_number.doubleValue() < 0)) {
				cnumthai = "";
			} else if (in_number.doubleValue() == 0) {
				cnumthai += th_zero + th_unit + th_tuan;
			} else {
				din_number3 = in_number.multiply(BigDecimal.valueOf(100));
				System.out.println("din_number3 =: "+din_number3);
				
				cin_number = doConvertBigDecimaltoString(din_number3);
				
//				cin_number = din_number3.toString();
				mstnum = cin_number;
				nlen = cin_number.length();
				nlen2 = 12 - nlen;
	
				for (int xj = 0; xj < nlen2; xj++) {
					mstnum = "x" + mstnum;
				}
	
				int ye = 0;
				for (int xe = 0; xe < 10; xe++) {
					String ccharnum = mstnum.substring(xe, xe + 1);
					if (ccharnum.equals("x")) {
						cnumthai = cnumthai + "";
					} else {
						
						if (ccharnum.equals("0")) {
							if (ye != 3){
								if (xe == 4) {
									cnumthai = cnumthai + th_million;
								} else {
									cnumthai = cnumthai + "";
								}
							}
						} else {
							if (ccharnum.equals("1")) {
								if ((xe == 3 && nlen != 9) || (xe == 9 && nlen != 3)){
									cnumthai = cnumthai + th_aed;
								} else {
									if (xe != 2 && xe != 8) {
										cnumthai = cnumthai + mtch[(int) Long.parseLong(ccharnum)];
									}
								}
							} else {
								if (ccharnum.equals("2") && (xe == 2 || xe == 8)) {
									cnumthai = cnumthai + th_twenty;
								} else {
									cnumthai = cnumthai + mtch[(int) Long.parseLong(ccharnum)];
								}
							}
							cnumthai = cnumthai + mtdec[xe];
							ye = xe;
						}
					}
				}
				cnumthai = cnumthai + th_unit;
	
				String ccharnum = mstnum.substring(10);
				if (ccharnum.equals("00")) {
					cnumthai = cnumthai + th_tuan;
				} else {
					ccharnum = mstnum.substring(10, 11);
					if (!(ccharnum.equals("0"))) {
						if (!ccharnum.equals("1")) {
							if (ccharnum.equals("2")) {
								cnumthai = cnumthai + th_twenty;
							} else {
								cnumthai = cnumthai + mtch[(int) Long.parseLong(ccharnum)];
							}
						}
						cnumthai = cnumthai + mtdec[8];
					}
	
					String ccharnum1 = mstnum.substring(11);
					if (!ccharnum1.equals("0")) {
						//comment by NEW 19022016
//						if (ccharnum1.equals("1") || ccharnum.equals("0")) {
						if (ccharnum1.equals("1") && !ccharnum.equals("0")) {
							cnumthai = cnumthai + th_aed;
						} else {
							cnumthai = cnumthai + mtch[Integer.parseInt(ccharnum1)];
						}
					}
					cnumthai = cnumthai + th_stang;
				}
			}
		}
		return cnumthai;
	}
	
	public static String convertDate2ThaiWord(String y_number, String m_number, String d_number) {		
		return convertDate2ThaiWord(
				converString2BigDecimal(y_number), 
				converString2BigDecimal(m_number), 
				converString2BigDecimal(d_number));
	}
	
	public static String convertDate2ThaiWord(BigDecimal y_number, BigDecimal m_number, BigDecimal d_number) {
		String str = "";
		if (y_number != null && y_number.intValue() != 0) {
			str += convertDate2ThaiWord(y_number) + th_year;
		}
		if (m_number != null && m_number.intValue() != 0) {
			str += convertDate2ThaiWord(m_number) + th_month;
		}
		if (d_number != null && d_number.intValue() != 0) {
			str += convertDate2ThaiWord(d_number) + th_day;
		}	
		return str;
	}
		
	public static String convertDate2ThaiWord(BigDecimal in_number) {
		cnumthai = "";
		if (in_number != null) {
			if ((in_number.intValue() > 9999999999.99) || (in_number.intValue() < 0)) {
				cnumthai = "";
			} else if (in_number.intValue() == 0) {
				cnumthai = th_zero;
			} else {
				din_number2 = (long) (in_number.intValue() * 100);
				cin_number = Long.toString(din_number2);
				mstnum = cin_number;
				nlen = cin_number.length();
				nlen2 = 12 - nlen;
	
				for (int xj = 0; xj < nlen2; xj++) {
					mstnum = "x" + mstnum;
				}
	
				int ye = 0;
				for (int xe = 0; xe < 10; xe++) {
					String ccharnum = mstnum.substring(xe, xe + 1);
					if (ccharnum.equals("x")) {
						cnumthai = cnumthai + "";
					} else {
						if (ccharnum.equals("0")) {
							if (ye != 3) {
								if (xe == 4) {
									cnumthai = cnumthai + th_million;
								} else {
									cnumthai = cnumthai + "";
								}
							}
						} else {
							if (ccharnum.equals("1")) {
								if ((xe == 3 && nlen != 9)
										|| (xe == 9 && nlen != 3)) {
									cnumthai = cnumthai + th_aed;
								} else {
									if (xe != 2 && xe != 8) {
										cnumthai = cnumthai + mtch[(int) Long.parseLong(ccharnum)];
									}
								}
							} else {
								if (ccharnum.equals("2") && (xe == 2 || xe == 8)) {
									cnumthai = cnumthai + th_twenty;
								} else {
									cnumthai = cnumthai + mtch[(int) Long.parseLong(ccharnum)];
								}
							}
							cnumthai = cnumthai + mtdec[xe];
							ye = xe;
						}
					}
				}
			}
		}
		return cnumthai;
	}
	
	//added by NEW 15022016 for Site acq report docmosis
	public static String setFormatDecmal(BigDecimal num){
		String strange = "#,###.00";
		String strange2 = "#,###";
		DecimalFormatSymbols decimal_format_symbols = new DecimalFormatSymbols();
		String fn = "";
		DecimalFormat weirdFormatter;
		String numStr = "";
		try{			
//			DecimalFormat weirdFormatter = new DecimalFormat(strange);
////			weirdFormatter.setGroupingSize(4);
//			String numStr = weirdFormatter.format(num);
			System.out.println("bizarre.indexOf = "+num.toString().indexOf("."));
			if(num.toString().indexOf(".") > 0){
				weirdFormatter = new DecimalFormat(strange);
//				weirdFormatter.setGroupingSize(4);
				numStr = weirdFormatter.format(num);
				fn = numStr;
				System.out.println("fn = "+fn);
			}else{
//				System.out.println("num = "+num);
//				return num.toString();
				weirdFormatter = new DecimalFormat(strange2);
//				weirdFormatter.setGroupingSize(4);
				numStr = weirdFormatter.format(num);
				fn = numStr;
				System.out.println("fn = "+fn);
			}
//			fn = new BigDecimal(Double.parseDouble(bizarre));
			System.out.println("fn = "+fn);
		}catch (Exception e) {
			e.printStackTrace();
			
			// TODO: handle exception
		}
		return fn;
	}
	
	public static String doConvertBigDecimaltoString(BigDecimal num){
		String strange = "####";
		DecimalFormatSymbols decimal_format_symbols = new DecimalFormatSymbols();
		BigDecimal fn = new BigDecimal(0);
		String numStr = "";
		try{
			DecimalFormat weirdFormatter = new DecimalFormat(strange);
			weirdFormatter.setGroupingSize(4);
			numStr = weirdFormatter.format(num);
			System.out.println("bizarre.indexOf = "+num.toString().indexOf("."));
			if(num.toString().indexOf(".") > 0){
				fn = new BigDecimal(numStr);
				System.out.println("fn = "+fn);
			}else{
				System.out.println("num = "+num);
				return num.toString();
			}
//			fn = new BigDecimal(Double.parseDouble(bizarre));
			System.out.println("fn = "+fn);
		}catch (Exception e) {
			e.printStackTrace();
			
			// TODO: handle exception
		}
		return numStr;
	}
}
