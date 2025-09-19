package th.co.ais.dao.rpt.hibernate;

import java.io.ByteArrayOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.dao.IReportJobDao;
import th.co.ais.rpt.domain.ReportJob;
import th.co.ais.rpt.parameter.SFRMO001ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.SEMDataUtility;

/**
 * @author Warawit
 *
 */
public class HibernateReportJobDao implements IReportJobDao, ServiceConstants{
	
	private static Log log = LogFactory.getLog(HibernateReportJobDao.class);

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void deleteReportJob(ReportJob reportJob) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(reportJob);
	}

	public ReportJob getReportJob(String jobId) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		return (ReportJob) session.createCriteria(ReportJob.class).add(
				Restrictions.eq("jobId", jobId)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ReportJob> getReportJob() throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(ReportJob.class).list();
	}

	public ReportJob getNewReportJobForStartBatch() throws DataAccessException {
		ReportJob ReportJob = null;
        List list = null;
        Session session = null;
        
        try {
             session = sessionFactory.getCurrentSession();
             list = session.createCriteria(ReportJob.class).
                    add(Restrictions.eq("status", IReportJobDao.STATUS_WAITING)).
                    add(Restrictions.le("jobSchedule", new Date())).
                    add(Restrictions.isNull("runOnServer")).
                    addOrder(org.hibernate.criterion.Order.asc("jobSchedule")).setMaxResults(1).list();
             log.debug("HibernateReportJobDao.getNewReportJobForStartBatch() : List = "+list.size());
             if(list != null && list.size() > 0){
            	 ReportJob = (ReportJob)list.get(0);
             }
        } catch (DataAccessException e) {
                throw e;
        } finally{
                list = null;
                session = null;
        }
        return ReportJob;
    }

	public ReportJob getNewReportJobForStartBatch(String reportTypeId) throws DataAccessException {
		ReportJob ReportJob = null;
        List list = null;
        Session session = null;
        try {
             session = sessionFactory.getCurrentSession();
             list = session.createCriteria(ReportJob.class).
             		add(Restrictions.eq("reportTypeId", reportTypeId)).
                    add(Restrictions.eq("status", IReportJobDao.STATUS_WAITING)).
                    add(Restrictions.le("jobSchedule", new Date())).
                    add(Restrictions.isNull("runOnServer")).
                    addOrder(org.hibernate.criterion.Order.asc("jobId")).setMaxResults(1).list();
             log.debug("HibernateReportJobDao.getNewReportJobForStartBatch() : List = "+list.size());
             if(list != null && list.size() > 0){
            	 ReportJob = (ReportJob)list.get(0);
             }
        } catch (DataAccessException e) {
                throw e;
        } finally{
                list = null;
                session = null;
        }
        return ReportJob;
    }
	
	public void updateReportJob(ReportJob ReportJob) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.update(ReportJob);
	}
	
	@SuppressWarnings("unchecked")
	public List<ReportJob> getClearFailJobList(String serverName, String reportOverTimeMinutes, Set currentJobIdList) throws DataAccessException {
		List list = null;
		Calendar cal = null;
		try {
			cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.MINUTE, (Integer.parseInt(reportOverTimeMinutes)*-1));
			Session session = sessionFactory.getCurrentSession();
			if(currentJobIdList!=null && currentJobIdList.size()>0){
				list = session.createCriteria(ReportJob.class).add(
						Restrictions.eq("runOnServer", serverName)).add(
							Restrictions.eq("status", IReportJobDao.STATUS_RUNNING)).add(
									Restrictions.not(Restrictions.in("jobId", currentJobIdList))).add(
											Restrictions.le("startDt", cal.getTime())).addOrder(
										org.hibernate.criterion.Order.asc("jobId")).setMaxResults(10).list();	
			}else{
				list = session.createCriteria(ReportJob.class).add(
						Restrictions.eq("runOnServer", serverName)).add(
							Restrictions.eq("status", IReportJobDao.STATUS_RUNNING)).add(
											Restrictions.le("startDt", cal.getTime())).addOrder(
										org.hibernate.criterion.Order.asc("jobId")).setMaxResults(10).list();	
			}	
		} catch (DataAccessException e) {
			throw e;
		} finally{
			cal = null;
		}
		return list;
	}	
	
	public int countWaitJobScheduleWithReportTypeId(String reportTypeId) throws DataAccessException {
		int count = 0;
		Session session = null;
		List list = null;
		try {
			session = sessionFactory.getCurrentSession();
			list = session.createCriteria(ReportJob.class).
				setProjection(Projections.rowCount()).
				add(Restrictions.eq("reportTypeId", reportTypeId)).
				add(Restrictions.eq("status", IReportJobDao.STATUS_WAITING)).
				add(Restrictions.le("jobSchedule", new Date())).
				add(Restrictions.isNull("runOnServer")).list();
			if(list!=null && list.size()>0){
				count = ((Integer)list.get(0)).intValue();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		} finally{
			session = null;
			list = null;
		}
		return count;
		
	}

	public void insertReportJob(ReportJob reportJob) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.save(reportJob);
	}
	
	public List searchReportMonitoringByCriteria(SFRMO001ReportParameter criteria) throws DataAccessException {
		int index = 0;
		Iterator iter = null;
		List returnList = null;
		List ReportMonitoringList = null;
		Query query = null;
		ReportJob reportJob = null;
		String sql = null;
		Session session = null;
		

		try{
			session = sessionFactory.getCurrentSession();
			
			sql = " SELECT JOB_ID jobId, REPORT_TYPE_ID reportTypeId , REPORT_EXPORT_FILE_PATH  reportExportFilePath, STATUS status, " +
		    	  " REQUEST_BY requestBy , REQUEST_DT requestDt , START_DT startDt, END_DT endDt , REMARK  remark , JOB_SCHEDULE jobSchedule" + 
//		    	  " FROM REPORT_JOB " +
		    	  " FROM SFFADM.SFF_REPORT_JOB" +
		    	  " WHERE 1=1 ";
			
			if(criteria.getRequestDateFrom() != null)
		       //sql += " AND TRUNC(REQUEST_DT) >= TRUNC(TO_DATE(?, 'DD/MM/YYYY', 'NLS_CALENDAR=GREGORIAN'))";	
			   sql += " AND cast(REQUEST_DT as date) >= (TO_DATE(?, 'DD/MM/YYYY'))";	
		    if(criteria.getRequestDateTo() != null)
		      // sql += " AND TRUNC(REQUEST_DT) <= TRUNC(TO_DATE(?, 'DD/MM/YYYY', 'NLS_CALENDAR=GREGORIAN'))";
		       sql += " AND cast(REQUEST_DT as date) <= (TO_DATE(?, 'DD/MM/YYYY'))";
		    if(criteria.getScheduleDateFrom() != null)
		       //sql += " AND TRUNC(JOB_SCHEDULE) >= TRUNC(TO_DATE(?, 'DD/MM/YYYY', 'NLS_CALENDAR=GREGORIAN'))";
		       sql += " AND cast(JOB_SCHEDULE as Date) >= (TO_DATE(?, 'DD/MM/YYYY'))";
		    if(criteria.getScheduleDateTo() != null)
		      // sql += " AND TRUNC(JOB_SCHEDULE) <= TRUNC(TO_DATE(?, 'DD/MM/YYYY', 'NLS_CALENDAR=GREGORIAN'))";
		       sql += " AND cast(JOB_SCHEDULE as date) <= (TO_DATE(?, 'DD/MM/YYYY'))";
		    if(criteria.getStatus() != null && !"".equals(criteria.getStatus().trim()))
		       sql += "AND STATUS = ? ";		    
		    if(criteria.getUserName() != null && !"".equals(criteria.getUserName().trim()))
		       sql += "AND UPPER(REQUEST_BY) LIKE ? ";
		    
		    sql += "ORDER BY reportTypeId, requestDt DESC";
		    
		    query = session.createSQLQuery(sql).
		    		addScalar("jobId",Hibernate.STRING).
		            addScalar("reportTypeId",Hibernate.STRING).
		            addScalar("reportExportFilePath",Hibernate.STRING).
		            addScalar("status",Hibernate.STRING).
		            addScalar("requestBy",Hibernate.STRING).
		            addScalar("requestDt",Hibernate.TIMESTAMP).
		            addScalar("startDt",Hibernate.TIMESTAMP).
		            addScalar("endDt",Hibernate.TIMESTAMP).
		            addScalar("remark",Hibernate.STRING).
		            addScalar("jobSchedule",Hibernate.TIMESTAMP);
		     		    
		    if(criteria.getRequestDateFrom() != null)
		       query.setString(index++, criteria.getRequestDateFrom());
		    if(criteria.getRequestDateTo() != null)
		       query.setString(index++, criteria.getRequestDateTo());
		    if(criteria.getScheduleDateFrom() != null)
		       query.setString(index++, criteria.getScheduleDateFrom());
		    if(criteria.getScheduleDateTo() != null)
		       query.setString(index++, criteria.getScheduleDateTo());
		    if(criteria.getStatus() != null && !"".equals(criteria.getStatus().trim()))
		       query.setString(index++, criteria.getStatus().trim());
		    if(criteria.getUserName() != null && !"".equals(criteria.getUserName().trim()))
			   query.setString(index++, "%"+criteria.getUserName().toUpperCase().trim()+"%");
				    
		    returnList = query.setResultTransformer(Transformers.aliasToBean(ReportJob.class)).list();
		    if(returnList != null && returnList.size() > 0){
				  ReportMonitoringList = new ArrayList();
			      for(iter=returnList.iterator();iter.hasNext();){
			    	  reportJob = (ReportJob)iter.next();
			    	  if(reportJob.getStatus() != null && !"".equals(reportJob.getStatus())){
			    		  if(reportJob.getStatus().equals(REPORT_STATUS_CODE_WAITING))
			    			  reportJob.setStatus(REPORT_STATUS_DESC_WAITING);
			    		  if(reportJob.getStatus().equals(REPORT_STATUS_CODE_RUNNING))
			    			  reportJob.setStatus(REPORT_STATUS_DESC_RUNNING);
			    		  if(reportJob.getStatus().equals(REPORT_STATUS_CODE_SUCCESS))
			    			  reportJob.setStatus(REPORT_STATUS_DESC_SUCCESS);
			    		  if(reportJob.getStatus().equals(REPORT_STATUS_CODE_FAIL))
			    			  reportJob.setStatus(REPORT_STATUS_DESC_FAIL);
			    		  if(reportJob.getStatus().equals(REPORT_STATUS_CODE_CANCEL))
			    			  reportJob.setStatus(REPORT_STATUS_DESC_CANCEL);
			    	  }
//			    	  if(reportJob.getReportExportFilePath() != null && !"".equals(reportJob.getReportExportFilePath())){
//			    		  String filePath = reportJob.getReportExportFilePath();
//			    		  String fileName = filePath.substring(filePath.lastIndexOf("/")+1,filePath.length());
//			    		  reportJob.setReportExportFilePath(fileName);			    		  
//			    	  }
			    	  ReportMonitoringList.add(reportJob);
			      }
			   }
		    log.debug("returnList.size() : "+returnList.size());
		    
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			sql = null;
			session = null;
			query = null;
		}
		return ReportMonitoringList;
	}
	
	public List updateStatusReportMonitoring(ReportJob reportJob, SFRMO001ReportParameter criteria) throws DataAccessException {
		List returnListUpdate = null;
		Query query = null;
		String sql = null;
		Session session = null;

		try{
			session = sessionFactory.getCurrentSession();
//		    sql = " UPDATE REPORT_JOB SET STATUS = ? " +
			sql = " UPDATE SFFADM.SFF_REPORT_JOB SET STATUS = ? " +
		    	  " WHERE JOB_ID = ? ";

		    query = session.createSQLQuery(sql);
		    query.setString(0, reportJob.getStatus());
		    query.setString(1, reportJob.getJobId());
		    query.executeUpdate();
		    
		    returnListUpdate = searchReportMonitoringByCriteria(criteria);
		    
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		} finally {
			sql = null;
			session = null;
			query = null;
		}
		return returnListUpdate;
	}

	// added by.. YUT 2015/09/14
	@SuppressWarnings("deprecation")
	@Override
	public byte[] callExportExcelMSA003(Map<String, Object> paramMap) throws DataAccessException, SQLException {
		Session session = null;
		byte[] bytes = null;
		
		String sqlString = "";
		ResultSet rs = null;
		PreparedStatement stmt = null;
		java.sql.Date EFFTVE_DT_FROM = null;
		java.sql.Date EFFTVE_DT_TO = null;
		java.sql.Date EXP_DT_FROM = null;
		java.sql.Date EXP_DT_TO = null;
		
		try {
			//edit by NEW 20160513
			if(paramMap.get("EFFTVE_DT_FROM") != null)EFFTVE_DT_FROM = new java.sql.Date(((Date)paramMap.get("EFFTVE_DT_FROM")).getTime());
			if(paramMap.get("EFFTVE_DT_TO") != null)EFFTVE_DT_TO = new java.sql.Date(((Date)paramMap.get("EFFTVE_DT_TO")).getTime());
			if(paramMap.get("EXP_DT_FROM") != null)EXP_DT_FROM = new java.sql.Date(((Date)paramMap.get("EXP_DT_FROM")).getTime());
			if(paramMap.get("EXP_DT_TO") != null)EXP_DT_TO = new java.sql.Date(((Date)paramMap.get("EXP_DT_TO")).getTime());
			
			session = sessionFactory.getCurrentSession();
			sqlString = "SELECT * FROM SEM_PG_ESI001_NEW_GET_DATA( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			
			stmt = session.connection().prepareStatement(sqlString);
			stmt.setString(1, paramMap.get("DOC_NO") == null ? null : paramMap.get("DOC_NO").toString());
			stmt.setString(2, paramMap.get("COMPANY") == null ? null : paramMap.get("COMPANY").toString());
			stmt.setString(3, paramMap.get("REGION") == null ? null : paramMap.get("REGION").toString());
			stmt.setString(4, paramMap.get("REQ_TYPE") == null ? null : paramMap.get("REQ_TYPE").toString());
			stmt.setString(5, paramMap.get("TITLE") == null ? null : paramMap.get("TITLE").toString());
			stmt.setString(6, paramMap.get("ASSGN_CNTRCT_NO") == null ? null : paramMap.get("ASSGN_CNTRCT_NO").toString());
			stmt.setString(7, paramMap.get("LEGAL_APPR_STTS") == null ? null : paramMap.get("LEGAL_APPR_STTS").toString());
			stmt.setString(8, paramMap.get("LOCATION_ID") == null ? null : paramMap.get("LOCATION_ID").toString());
			stmt.setString(9, paramMap.get("LOCATION_CODE") == null ? null : paramMap.get("LOCATION_CODE").toString());
			stmt.setString(10, paramMap.get("SITE_NAME") == null ? null : paramMap.get("SITE_NAME").toString());
			stmt.setString(11, paramMap.get("SITE_TYPE") == null ? null : paramMap.get("SITE_TYPE").toString());
			stmt.setString(12, paramMap.get("SITE_INF_STTS") == null ? null : paramMap.get("SITE_INF_STTS").toString());
			stmt.setString(13, paramMap.get("SITE_STTS") == null ? null : paramMap.get("SITE_STTS").toString());
			stmt.setString(14, paramMap.get("CNTRCT_NO") == null ? null : paramMap.get("CNTRCT_NO").toString());
			stmt.setString(15, paramMap.get("PENDING_STTS") == null ? null : paramMap.get("PENDING_STTS").toString());
			stmt.setString(16, paramMap.get("EXP_STTS") == null ? null : paramMap.get("EXP_STTS").toString());
			//edit by NEW 20160513
//			System.out.println("EFFTVE_DT_FROM  getTime :  "+((Date)paramMap.get("EFFTVE_DT_FROM")).getTime());
			stmt.setDate(17, EFFTVE_DT_FROM);
			stmt.setDate(18, EFFTVE_DT_TO);
			stmt.setDate(19, EXP_DT_FROM);
			stmt.setDate(20, EXP_DT_TO);
			stmt.setString(21, paramMap.get("NO_EXP_FLG") == null ? null : paramMap.get("NO_EXP_FLG").toString());
			stmt.setString(22, paramMap.get("LSSR_NAME") == null ? null : paramMap.get("LSSR_NAME").toString());
			stmt.setString(23, paramMap.get("CRR_FLG") == null ? null : paramMap.get("CRR_FLG").toString());
			System.out.println("Export Excel New Befor ExecuteQuery");
			rs = (ResultSet) stmt.executeQuery();
			System.out.println("Export Excel New After ExecuteQuery");
			bytes = managementExcelReportRS(rs);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(session != null){
				session.connection().close();
			}
			
			if(stmt != null){
				stmt.close();
			}
			
			session = null;
		}
		
		return bytes;
	}
	
	public byte[] managementExcelReportRS(ResultSet rs) throws SQLException {
		byte[] bytes = null;
		
		try {
			String dateStr;
			Workbook wb = new SXSSFWorkbook(100);
			Sheet sheet = wb.createSheet("new sheet");
			createCellStyles(wb);

			ResultSetMetaData metaData = rs.getMetaData();
            int colCount = metaData.getColumnCount();
//            System.out.println("colCount: " + colCount);

            // -> header
            Row rowhead = sheet.createRow((int)0);
            
			for(int i = 0; i < colCount; i++) {
				rowhead.createCell((int) i).setCellValue(metaData.getColumnName(i + 1).trim());
				rowhead.getCell(i).setCellStyle(_headerCellStyle);
			}
			// <- header
			
			// -> detail
			CreationHelper createHelper = wb.getCreationHelper();
			CellStyle cs_ = wb.createCellStyle();
			int j=1;
			while(rs.next()){
				Row row = sheet.createRow((int)j);
				for(int k=0; k<colCount; k++){
//					row.createCell((int) k).setCellValue(rs.getString(metaData.getColumnName(k + 1).trim()));
//					if(metaData.getColumnType(k + 1) == 91 && rs.getString(metaData.getColumnName(k + 1)) != null){ //Date	
////						System.out.println("["+k+"] > " + "head getCellType: " + rowhead.getCell(k).getCellType() + " // head getColumnType: " + metaData.getColumnType(k + 1));
////						System.out.println(rs.getString(metaData.getColumnName(k + 1).trim()));
//	//					
//						String d = rs.getString(metaData.getColumnName(k + 1).trim());
//						d = d.substring(0, d.length()-2);
////						System.out.println(d);
////						System.out.println(DateUtil.getDate(d));
//						row.createCell((int) k).setCellValue(DateUtil.convertDateTime2StringWithLocale(DateUtil.getDate(d), "dd/MM/yyyy", DateUtil.thLocale));
//						row.getCell(k).setCellStyle(_dateCellStyle);
//					}else{
//						row.createCell((int) k).setCellValue(rs.getString(metaData.getColumnName(k + 1).trim()));
//					}
					if(rs.getString(metaData.getColumnName(k + 1)) != null){
						if(metaData.getColumnType(k + 1) == 91 ){ //Date
							dateStr = DateUtil.convertDateTime2StringWithLocale(rs.getDate(metaData.getColumnName(k + 1).trim()), 
									DateUtil.SIMPLE_DATE_PATTERN, DateUtil.thLocale);
//							row.createCell((int) k).setCellValue(rs.getDate(metaData.getColumnName(k + 1).trim()));
							row.createCell((int) k).setCellValue(DateUtil.getDate(dateStr, DateUtil.SIMPLE_DATE_PATTERN));
//							System.out.println("["+k+"] > " + "head getCellType: " + rowhead.getCell(k).getCellType() + " // head getColumnType: " + metaData.getColumnType(k + 1));
							cs_.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
							cs_.getDataFormat();
							row.getCell(k).setCellStyle(cs_);
						}else if(metaData.getColumnType(k + 1) == 2){
							row.createCell((int) k).setCellValue(rs.getDouble(metaData.getColumnName(k + 1).trim()));
							
							if(!"\u0E1B\u0E35".equals(metaData.getColumnName(k + 1)) &&
									!"\u0E40\u0E14\u0E37\u0E2D\u0E19".equals(metaData.getColumnName(k + 1)) &&
									!"\u0E27\u0E31\u0E19".equals(metaData.getColumnName(k + 1))){
								row.getCell(k).setCellStyle(_moneyCells);
							}
							
						}else{
							row.createCell((int) k).setCellValue(rs.getString(metaData.getColumnName(k + 1).trim()));
						}
					}
					
				}
//				System.out.println("row.getLastCellNum() = "+row.getLastCellNum());
//				for(int colNum = 0; colNum<row.getLastCellNum();colNum++)   
//				    wb.getSheetAt(0).autoSizeColumn(colNum);
				j++;
			}
			// <- detail
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			wb.write(bos);
			bytes = bos.toByteArray();
			
			bos.close();
//			System.out.println("Your excel file has been generated!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null){
				rs.close();
			}
		}
		
		return bytes;
	}
	
	
	// the style for header
	private static CellStyle _headerCellStyle;
	
	// the style for Date column
	private static CellStyle _dateCellStyle;
	
	// the style for Money cells
    private static CellStyle _moneyCells;
    private static CellStyle _moneyCellsNegative;
	
	private static void createCellStyles(Workbook wb) {
		CreationHelper createHelper = wb.getCreationHelper();
		
		// ** Cell style for header row
		_headerCellStyle = wb.createCellStyle();
		_headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		_headerCellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		_headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		_headerCellStyle.setBorderTop((short)1); 		
		_headerCellStyle.setBorderRight((short)1); 
		_headerCellStyle.setBorderBottom((short)1);	
		_headerCellStyle.setBorderLeft((short)1);
        
        Font f = wb.createFont();
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);
        f.setFontHeightInPoints((short)8);
        _headerCellStyle.setFont(f);
        
		
		// ** Date Format
		_dateCellStyle = wb.createCellStyle();
		_dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
		
		
		// ** Money Format
		// money style ( >= 0)
        _moneyCells = wb.createCellStyle();
        _moneyCells.setDataFormat(createHelper.createDataFormat().getFormat("__##,##0.00"));
        // money style ( < 0)
        Font font = wb.createFont();
        font.setColor(Font.COLOR_RED);
        _moneyCellsNegative = wb.createCellStyle();
        _moneyCellsNegative.setDataFormat(createHelper.createDataFormat().getFormat("$__##,##0.##"));
        _moneyCellsNegative.setFont(font);
	}


}
