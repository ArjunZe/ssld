/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infa.ssl;

/**
 *
 * @author mreddy
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.OutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class SkipVerification implements Runnable {

    public static String myurl;
    public static Integer SNI;
    public static String Verb;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Needed Arugments -> URL VERB SNIExtenstion(0/1)");
            return;
        }
        myurl = args[0];
        SNI = 0;
        Verb = "POST";
        if (args.length == 2) {
            Verb = args[1];
        }
        if (args.length == 3) {
            SNI = Integer.parseInt(args[2]);
        }
        SkipVerification us = new SkipVerification();
        us.run();
    }

    @Override
    public void run() {
        try {
            HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            // Security.setProperty("ocsp.enable", "true");
            // System.setProperty("com.sun.net.ssl.checkRevocation", "true");
            // System.setProperty("com.sun.security.enableCRLDP", "true");
            // h="https://api.peoplegrove.com/v1/users/";
            // h="https://server.cryptomix.com/secure/";
            // h="https://collaboration.merck.com";
            URL url = new URL(myurl);
            // System.out.println(Verb);
            InputStream inStream = null;
            String line;
            try {
                // test NFS Samba
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                // urlConnection.setHostnameVerifier(new getHostnameVerifier());
                urlConnection.setRequestMethod(Verb);
                // urlConnection.setRequestProperty("Accept", "text/html, image/gif, image/jpeg,
                // *; q=.2, */*; q=.2");
                // urlConnection.setRequestProperty("key",
                // "lYKUdPAAjSauoHHsNiVHt75a73JU6cze6CzyHULt");
                // urlConnection.setRequestProperty("HOST",
                // "hfv3rlhfzb.execute-api.us-east-1.amazonaws.com");
                // urlConnection.setRequestProperty("User-Agent", "a");
                // urlConnection.setRequestProperty("Content-Type",
                // "application/x-www-form-urlencoded");
                // urlConnection.setRequestProperty( "Authorization","Basic
                // cm1hZGRhbGEremRzYnhpbmZvcm1hdGljYUBtZHNvbC5jb206SW5mb3JtYXRpY2EqOA==n");
                // urlConnection.setRequestProperty("x-api-key","yAEMZ9FVqGjlnbjiMD8u5a");
                if (SNI == 1) {
                    urlConnection.setHostnameVerifier(hostnameVerifier);
                    System.out.println("Using Customer HostnameVerifier");
                }
                urlConnection.setDoOutput(true);
                OutputStream os = urlConnection.getOutputStream();

                System.out.println(urlConnection.getResponseCode());
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        urlConnection.getResponseCode() / 100 == 2 ? urlConnection.getInputStream()
                        : urlConnection.getErrorStream()));
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
                urlConnection.disconnect();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            } finally {
                if (inStream != null) {
                    inStream.close();
                }
            }
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
