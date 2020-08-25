package com.tutorial.student_service.common;

public interface CustomHttpHeaders {
    String USER_ACCESS_TOKEN = "x-user-auth";
    String SERVICE_ACCESS_TOKEN = "x-service-auth";
    String IMS_CLIENT_ID = "X-IMS-ClientID";
    String GW_IMS_CLIENT_ID = "x-gw-ims-client-id";
    String API_KEY = "x-api-key";
    String FORWARDED_FOR = "x-forwarded-for";
    String REQUEST_ID = "x-request-id";
    String CORRELATION_ID = "x-correlation-id";
}