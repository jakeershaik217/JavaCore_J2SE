package com.syntel.themeextractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



public class ThemeContentExtractor {
	
	
	public void themeContentExtractor(XSSFWorkbook wb) {
		try {
			   System.setProperty("http.proxyHost", "mbusa.americas.svc.corpintra.net");
		        System.setProperty("http.proxyPort", "3128");

		        Document doc = Jsoup.connect("https://mbusa.com").get();
		        System.out.println("Obtained Title: " + doc.title()); 
		}catch(Exception  e){
			e.printStackTrace();
		}
		
	}
}
