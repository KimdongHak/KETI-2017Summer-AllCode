package com.example.c.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by c on 2017-07-04.
 */

public class RequestHttpURLConnection {
    public String request(String _url) {
        HttpURLConnection urlconn = null;

        try {
            URL url = new URL(_url);
            urlconn = (HttpURLConnection) url.openConnection();

            urlconn.setRequestMethod("GET");
            urlconn.setRequestProperty("Accept-Charest", "URF-8");
            urlconn.setRequestProperty("Context_Type", "application/x-www-form-urlencoded;cahrset=UTF-8");

            if (urlconn.getResponseCode() != HttpURLConnection.HTTP_OK)
                return null;

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));

            String line;
            String page = "";

            while ((line = reader.readLine()) != null) {
                page += line;
            }

            return page;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlconn != null)
                urlconn.disconnect();
        }
        return null;
    }

    public String connection(String _url,String JSONobject) {
        HttpURLConnection urlconn = null;
        String result = "";
        int httpResult;
        try {
            URL url = new URL(_url);
            urlconn = (HttpURLConnection) url.openConnection();

            urlconn.setRequestMethod("POST");
            urlconn.setRequestProperty("Content-Type", "application/json");
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            urlconn.connect();

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(urlconn.getOutputStream());
            outputStreamWriter.write(JSONobject);
            outputStreamWriter.flush();
            outputStreamWriter.close();

            httpResult = urlconn.getResponseCode();
            if(httpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),"utf-8"));
                String line = null;

                while ((line = br.readLine()) != null) {
                    result = line;
                }

                br.close();
                return result;
            } else {
                return null;
            }

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
        return null;
    }
}