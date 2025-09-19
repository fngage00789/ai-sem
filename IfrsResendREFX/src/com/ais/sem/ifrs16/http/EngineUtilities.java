package com.ais.sem.ifrs16.http;

import org.apache.axis.EngineConfiguration;

public class EngineUtilities {
	
	
	public static final EngineConfiguration getEngineConfiguration() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		sb.append("<deployment name=\"defaultClientConfig\"\r\n");
		sb.append("xmlns=\"http://xml.apache.org/axis/wsdd/\"\r\n");
		sb.append("xmlns:java=\"http://xml.apache.org/axis/wsdd/providers/java\">\r\n");
		sb.append("<globalConfiguration>\r\n");
		sb.append("<parameter name=\"disablePrettyXML\" value=\"true\"/>\r\n");
		sb.append("<parameter name=\"enableNamespacePrefixOptimization\" value=\"true\"/>\r\n");
		sb.append("</globalConfiguration>\r\n");
		sb.append("<transport name=\"http\" pivot=\"java:" + CustomCommonsHTTPSender.class.getName() + "\"/>\r\n");
		sb.append("<transport name=\"local\" pivot=\"java:org.apache.axis.transport.local.LocalSender\"/>\r\n");
		sb.append("<transport name=\"java\" pivot=\"java:org.apache.axis.transport.java.JavaSender\"/>\r\n");
		sb.append("</deployment>\r\n");
		return new org.apache.axis.configuration.XMLStringProvider(sb.toString());
	}
}
