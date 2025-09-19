//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ais.sem.write.transfer;

import com.ais.sem.write.db.ConnectDb;
import com.ais.sem.write.model.UserProfile;
import com.ais.sem.write.util.FileUtilities;
import com.ais.sem.write.util.SFTPUtilities;
import com.ais.sem.write.util.Utilities;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.nio.file.attribute.PosixFilePermission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GenFileFromSemCTTransSap {
    private int totalRowHead = 0;
    private int totalRowDetail = 0;
    private String strRefsem = "";
    private String fileNameDat = "";
    private String fileNameSyn = "";
    private String createby = "";
    private UserProfile uProfile = null;
    private static String system = Utilities.getResources("system");

    public GenFileFromSemCTTransSap() {
    }

    public static void main(String[] args) {
        GenFileFromSemCTTransSap genText = new GenFileFromSemCTTransSap();
        String refsem = "'ELD151100059178'";
        String filename = "ZFAP107_1600_" + Utilities.formatDateYYYYMMDD() + "_0010";
        UserProfile uProfile = new UserProfile();
        uProfile.setCreateby("rapeesuw");
        uProfile.setEmail("rapeesuw@ais.co.th");
        uProfile.setFilename(filename);
        uProfile.setUserId("rapeesuw");
        genText.doProcess(refsem, uProfile);
    }

    public void doProcess(String refsem, UserProfile uProfile) {
        try {
            this.uProfile = uProfile;
            this.strRefsem = refsem;
            this.createby = this.createby;
            this.fileNameDat = this.uProfile.getFilename() + ".dat";
            this.fileNameSyn = this.uProfile.getFilename() + ".syn";
            System.out.println("strRefsem = " + this.strRefsem);
            System.out.println("fileNameDat = " + this.fileNameDat);
            System.out.println("fileNameSyn = " + this.fileNameSyn);
            System.out.println("system = " + system);
            if (!system.equalsIgnoreCase("window") && !system.equalsIgnoreCase("production")) {
                if (system.equalsIgnoreCase("linux")) {
                    this.writeFileOnLinux();
                }
            } else {
                this.writeFileOnWindow();
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    private void writeFileOnLinux() {
        Connection con = null;

        try {
            con = ConnectDb.dbConnectSEM();
            this.writeFileDat(con, SFTPUtilities.temp_path);
            this.writeFileSyn(con, SFTPUtilities.temp_path);
            this.updateSemCTTransSapTB(con, this.fileNameDat);
            this.insertSemCTTransSapLogTB(con, this.fileNameDat);
            SFTPUtilities sftp = new SFTPUtilities(true);
            sftp.put(SFTPUtilities.temp_path + this.fileNameDat, SFTPUtilities.sapPath);
            sftp.put(SFTPUtilities.temp_path + this.fileNameSyn, SFTPUtilities.sapPath);
            sftp.getChannelSftp().rm(SFTPUtilities.temp_path + this.fileNameDat);
            sftp.getChannelSftp().rm(SFTPUtilities.temp_path + this.fileNameSyn);
            sftp.getChannelSftp().chmod(Integer.parseInt("644", 8), SFTPUtilities.sapPath + this.fileNameDat);
            sftp.getChannelSftp().chmod(Integer.parseInt("644", 8), SFTPUtilities.sapPath + this.fileNameSyn);
            sftp.disconnect();
        } catch (Exception var11) {
            System.out.println("error : " + var11);
            var11.printStackTrace();
        } finally {
            System.out.println("... finally writeFileOnLinux ...");

            try {
                if (con != null) {
                    con.close();
                    System.out.println("... con.close ...");
                }
            } catch (Exception var10) {
                System.out.println("error : " + var10);
            }

        }

    }

    private void writeFileOnWindow() {
        Connection con = null;

        try {
            con = ConnectDb.dbConnectSEM();
            String sapPath = FileUtilities.sapPath;
            this.writeFileDat(con, sapPath);
            this.writeFileSyn(con, sapPath);
            this.updateSemCTTransSapTB(con, this.fileNameDat);
            this.insertSemCTTransSapLogTB(con, this.fileNameDat);
        } catch (Exception var11) {
            System.out.println("error : " + var11);
            var11.printStackTrace();
        } finally {
            System.out.println("... finally writeFileOnWindow ...");

            try {
                if (con != null) {
                    con.close();
                    System.out.println("... con.close ...");
                }
            } catch (Exception var10) {
                System.out.println("error : " + var10);
            }

        }

    }

    private void writeFileSyn(Connection con, String sapPath) throws Exception {
        int totalRecord = 0;
        File fileSyn = new File(sapPath, this.fileNameSyn);
        
        if (fileSyn.createNewFile()) {
            System.out.println("File " + this.fileNameSyn + " is created!");
        } else {
            System.out.println("File " + this.fileNameSyn + " already exists.");
        }
        
        Process p;
        try {
        	System.out.println("chmod 755 -R "+sapPath+"/"+this.fileNameSyn);
        	p = Runtime.getRuntime().exec("chmod 755 -R "+sapPath+"/"+this.fileNameSyn);
            p.waitFor();
        } catch (Exception e) {
        	e.printStackTrace();        	
        }
        
        System.out.println("fileSyn, Is Execute allow : " + fileSyn.canExecute());
        System.out.println("fileSyn, Is Write allow : " + fileSyn.canWrite());
        System.out.println("fileSyn, Is Read allow : " + fileSyn.canRead());

        FileOutputStream fos = new FileOutputStream(fileSyn);
        OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(out);
        totalRecord = this.totalRowHead + this.totalRowDetail;
        String totalAmount = String.valueOf(this.getToTalAmount(con));
        String strColumn = "Total record|Total amount|UserID|Email|Createdate|Time";
        bw.write(strColumn);
        bw.newLine();
        strColumn = totalRecord + "|" + Utilities.toDecimal(totalAmount, 2) + "|" + this.uProfile.getUserId() + "|" + this.uProfile.getEmail() + "|" + Utilities.formatDateYYYYMMDD() + "|" + Utilities.formatTimeHHMMSS();
        bw.write(strColumn);
        bw.newLine();

        if (bw != null) {
            bw.close();
        }

        if (out != null) {
            out.close();
        }

        if (fos != null) {
            fos.close();
        }

    }

    private void writeFileDat(Connection con, String sapPath) throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs2 = null;
        PreparedStatement pstmt3 = null;
        ResultSet rs3 = null;

        try {
            String strSql = "";
            String dataValue = "";
            String refsem = "";
            String strWhere = "";
            String temp = "";
            String lastColumn = "";
            File fileDat = new File(sapPath, this.fileNameDat);

            if (fileDat.createNewFile()) {
                System.out.println("File " + this.fileNameDat + " is created!");
            } else {
                System.out.println("File " + this.fileNameDat + " already exists.");
            }
            
            Process p;
            try {
            	System.out.println("chmod 755 -R "+sapPath+"/"+this.fileNameDat);
            	p = Runtime.getRuntime().exec("chmod 755 -R "+sapPath+"/"+this.fileNameDat);
                p.waitFor();
            } catch (Exception e) {
            	e.printStackTrace();        	
            }
            
            System.out.println("fileDat, Is Execute allow : " + fileDat.canExecute());
            System.out.println("fileDat, Is Write allow : " + fileDat.canWrite());
            System.out.println("fileDat, Is Read allow : " + fileDat.canRead());

            FileOutputStream fos = new FileOutputStream(fileDat);
            OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(out);
            if (this.strRefsem != null && this.strRefsem.length() > 0) {
                strWhere = " and refsem in(" + this.strRefsem + ")";
            }

            strSql = "select * from SEM_CT_TRANS_SAP_UNIVERSAL where (3>1) " + strWhere + " order by hearun";
            pstmt = con.prepareStatement(strSql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                ++this.totalRowHead;
                StringBuffer sbHead = new StringBuffer();

                for(int i = 1; i < rs.getMetaData().getColumnCount(); ++i) {
                    this.nullToEmpty(rs.getMetaData().getColumnName(i));
                    if (i > 1) {
                        dataValue = this.nullToEmpty(rs.getString(rs.getMetaData().getColumnName(i)));
                        if (!"refsem".equalsIgnoreCase(rs.getMetaData().getColumnName(i))) {
                            sbHead.append(dataValue);
                        }

                        if (i < rs.getMetaData().getColumnCount() - 2) {
                            sbHead.append("|");
                        }

                        if ("refsem".equalsIgnoreCase(rs.getMetaData().getColumnName(i))) {
                            refsem = dataValue;
                        }
                    }
                }

                bw.write(sbHead.toString());
                bw.newLine();
                strSql = "select * from SEM_CT_TRANS_SAP_DTL_UNIVERSAL where refsem = '" + refsem + "'";
                pstmt2 = con.prepareStatement(strSql);
                rs2 = pstmt2.executeQuery();

                int i;
                StringBuffer sbDetail;
                while(rs2.next()) {
                    ++this.totalRowDetail;
                    sbDetail = new StringBuffer();

                    for(i = 1; i <= rs2.getMetaData().getColumnCount() - 1; ++i) {
                        if (i > 1) {
                            dataValue = this.nullToEmpty(rs2.getString(rs2.getMetaData().getColumnName(i)));
                            sbDetail.append(dataValue);
                            if (i != rs2.getMetaData().getColumnCount()) {
                                sbDetail.append("|");
                            }
                        }
                    }

                    bw.write(sbDetail.toString());
                    bw.newLine();
                }

                strSql = "select * from SEM_CT_TRANS_SAP_EXTRA where TEXT = '" + refsem + "'";
                pstmt3 = con.prepareStatement(strSql);
                rs3 = pstmt3.executeQuery();

                while(rs3.next()) {
                    ++this.totalRowDetail;
                    sbDetail = new StringBuffer();

                    for(i = 1; i <= rs3.getMetaData().getColumnCount(); ++i) {
                        if (i > 1) {
                            dataValue = this.nullToEmpty(rs3.getString(rs3.getMetaData().getColumnName(i)));
                            sbDetail.append(dataValue);
                            if (i != rs3.getMetaData().getColumnCount()) {
                                sbDetail.append("|");
                            }
                        }
                    }

                    bw.write(sbDetail.toString());
                    bw.newLine();
                }

                if (rs2 != null) {
                    rs2.close();
                }

                if (rs3 != null) {
                    rs3.close();
                }

                if (pstmt2 != null) {
                    pstmt2.close();
                }

                if (pstmt3 != null) {
                    pstmt3.close();
                }
            }

            if (bw != null) {
                bw.close();
            }

            if (out != null) {
                out.close();
            }

            if (fos != null) {
                fos.close();
            }
            
        } catch (Exception var29) {
            System.out.println("error : " + var29);
            var29.printStackTrace();
            throw var29;
        } finally {
            System.out.println("... finally writeFileDat ...");

            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception var28) {
                System.out.println("error : " + var28);
            }

        }

    }

    private BigDecimal getToTalAmount(Connection con) throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String strWhere = "";
        BigDecimal totalAmount = new BigDecimal(0);

        try {
            if (this.strRefsem != null && this.strRefsem.length() > 0) {
                strWhere = " and refsem in(" + this.strRefsem + ")";
            }

            String query = "select sum(amtloc) as total from sem_ct_trans_sap_dtl_universal where 1=1 and AMTTYP = 'D' " + strWhere;
            System.out.println("strSql = " + query);
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                totalAmount = rs.getBigDecimal("total");
            }
        } catch (Exception var10) {
            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            System.out.println("error : " + var10);
            var10.printStackTrace();
            throw var10;
        } finally {
            System.out.println("... finally getToTalAmount ...");
            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

        }

        return totalAmount;
    }

    private void updateSemCTTransSapTB(Connection con, String filename) throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        new HashMap();
        String strWhere = "";

        try {
            if (this.strRefsem != null && this.strRefsem.length() > 0) {
                strWhere = " and refsem in(" + this.strRefsem + ")";
            }

            String query = "update  SEM_CT_TRANS_SAP_UNIVERSAL  set FILENAME = '" + filename.trim() + "' " + " where (3>1) " + strWhere;
            System.out.println("strSql = " + query);
            pstmt = con.prepareStatement(query);
            int var8 = pstmt.executeUpdate();
        } catch (Exception var12) {
            if (rs != null) {
                ((ResultSet)rs).close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            System.out.println("error : " + var12);
            var12.printStackTrace();
            throw var12;
        } finally {
            System.out.println("... finally updateSemCTTransSapTB ...");
            if (rs != null) {
                ((ResultSet)rs).close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

        }

    }

    private void insertSemCTTransSapLogTB(Connection con, String filename) throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        new HashMap();

        try {
            pstmt = con.prepareStatement("insert  into SEM_CT_TRANS_SAP_LOG(TRANS_SAP_LOG_ID,FILE_NAME,REMARK,RECORD_STATUS,VERSION,CREATE_DT,CREATE_BY)values(gen_random_uuid(),?,?,?,?,current_timestamp,?)");
            pstmt.setString(1, filename.trim());
            pstmt.setString(2, "");
            pstmt.setString(3, "Y");
            pstmt.setInt(4, 0);
            pstmt.setString(5, this.createby);
            pstmt.executeUpdate();
        } catch (Exception var10) {
            if (rs != null) {
                ((ResultSet)rs).close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            System.out.println("error : " + var10);
            var10.printStackTrace();
            throw var10;
        } finally {
            System.out.println("... finally insertSemCTTransSapLogTB ...");
            if (rs != null) {
                ((ResultSet)rs).close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

        }

    }

    private String nullToEmpty(String str) {
        return str == null ? "" : str;
    }
}
