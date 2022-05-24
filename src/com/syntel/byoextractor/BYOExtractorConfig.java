package com.syntel.byoextractor;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class BYOExtractorConfig {
	
	public static Connection.Response confluenceConfig () throws IOException{
		System.setProperty("http.proxyHost", "mbusa.americas.svc.corpintra.net");
	    System.setProperty("http.proxyPort", "3128");
	    Connection.Response res = Jsoup
	     	    .connect("https://confluence.usfdc.corpintra.net/display/MBUSACOM/MY18+C-+Cabriolet+-+BYO+Exterior")
	     	    .data("os_username", "SCHINTA")
	     	    .data("os_password", "MBUSA@2017")//MBUSA@2017 Syntel@2017
	     	    .data("loginButton", "Log In")
	     	    .method(Connection.Method.POST).followRedirects(false)
	     	    .execute();
		return res;
	}

}


