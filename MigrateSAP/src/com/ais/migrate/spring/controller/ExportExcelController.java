package com.ais.migrate.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ais.migrate.mnims.spring.service.MetabCompanyService;
import com.ais.migrate.sem.spring.service.SemElMeterInfoService;

public class ExportExcelController  extends AbstractController {
	private String successView;
	private String errorPage;
	
	private MetabCompanyService metabCompanyService; 
	private SemElMeterInfoService semElMeterInfoService; 
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List metabCompanyList  = metabCompanyService.getMetabCompanyList();
		System.out.println("metabCompanyList size = "+metabCompanyList.size());
		List semElMeterInfoList  = semElMeterInfoService.getsemElMeterInfoList();
		System.out.println("semElMeterInfoList size = "+semElMeterInfoList.size());
		return new ModelAndView(successView);
	}
	
	public void setSuccessView(String successView) {
		this.successView = successView;
	}
	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}
	public void setSemElMeterInfoService(SemElMeterInfoService semElMeterInfoService) {
		this.semElMeterInfoService = semElMeterInfoService;
	}
	
	public void setMetabCompanyService(MetabCompanyService metabCompanyService) {
		this.metabCompanyService = metabCompanyService;
	}
}


