package com.merck.ushh.icomm.mail;

import org.apache.http.HttpHost;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class MerckLyrisMailSender {
    public final static void main(String[] args) throws Exception {

       HttpClient httpclient = new HttpClientt();
       HttpHost proxy = new HttpHost("54.30.228.195", 8080);
       httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
        try {
            HttpGet httpget = new HttpGet("www.google.com");

            System.out.println("executing request " + httpget.getURI());

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            System.out.println("----------------------------------------");

        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }
}
