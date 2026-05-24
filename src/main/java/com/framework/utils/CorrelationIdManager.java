package com.framework.utils;

import java.util.UUID;

public class CorrelationIdManager {
	
	 private CorrelationIdManager() {
	    }

	    public static String generateCorrelationId() {

	        return UUID.randomUUID().toString();
	    }
}
