package com.syntel.AMGclassextractor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class AMGClassExtractorConfig {
                public static Connection.Response confluenceConfig () throws IOException{
                                // Create a trust manager that does not validate certificate chains
                                TrustManager[] trustAllCerts = new TrustManager[]{
                                    new X509TrustManager() {
                                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                            return null;
                                        }
                                        public void checkClientTrusted(
                                            java.security.cert.X509Certificate[] certs, String authType) {
                                        }
                                        public void checkServerTrusted(
                                            java.security.cert.X509Certificate[] certs, String authType) {
                                        }
                                    }
                                };

                                // Install the all-trusting trust manager
                                try {
                                    SSLContext sc = SSLContext.getInstance("SSL");
                                    sc.init(null, trustAllCerts, new java.security.SecureRandom());
                                    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                                } catch (Exception e) {
                                }

                                // Now you can access an https URL without having the certificate in the truststore
                                try {
                                    URL url = new URL("https://confluence.usfdc.corpintra.net/display/MBUSACOM/MY18+C-+Cabriolet+-+BYO+Exterior");
                                } catch (MalformedURLException e) {
                                }
                                System.setProperty("http.proxyHost", "mbusa.americas.svc.corpintra.net");
                                System.setProperty("http.proxyPort", "3128");
                                Connection.Response res = Jsoup
                                                                .connect("https://confluence.usfdc.corpintra.net/display/MBUSACOM/MY18+C-+Cabriolet+-+BYO+Exterior")
                                                                .data("os_username", "SCHINTA")
                                                                .data("os_password", "Syntel@2017")
                                                                .data("loginButton", "Log In")
                                                                .method(Connection.Method.POST).followRedirects(false)
                                                                .execute();
                                return res;
                }
                }
