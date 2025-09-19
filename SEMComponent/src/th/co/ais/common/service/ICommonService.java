package th.co.ais.common.service;

import java.util.HashMap;

import javax.jws.WebService;

import th.co.ais.exception.AISBusinessException;

@WebService
public interface ICommonService {
	public String hello(String name) throws AISBusinessException;
	public String helloException(String name) throws AISBusinessException;
	public HashMap testResultMap(String name) throws AISBusinessException;
}
