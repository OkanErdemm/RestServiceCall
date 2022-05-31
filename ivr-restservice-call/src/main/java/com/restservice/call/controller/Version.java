package com.global.bilgi.restservice.call.controller;

public class Version {


	private static final String CURRENT_VERSION = "1.00";
	private static final String MODIFIED_DATE = "20210713";
	private static final String MODIFIED_BY = "Okan ERDEM";
	
	public static String getCurrentVersion() {
		return CURRENT_VERSION;
	}
	public static String getModifiedDate() {
		return MODIFIED_DATE;
	}
	public static String getModifiedBy() {
		return MODIFIED_BY;
	}
	
	 // 1.00 20210713 OE New Imp.
}

