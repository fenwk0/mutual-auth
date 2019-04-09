package com.macymoo.mutualauth.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RestApi {

    private Object Greeting;

    public String invoke(String restUrl) {

        String retVal = "Failed";

        try {

            URL url = new URL(restUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            retVal = "Success: ["+conn.getResponseCode() +"]\n";

            String output;
            while ((output = br.readLine()) != null) {
                retVal = retVal + output + "\n";
            }

            conn.disconnect();


        } catch (MalformedURLException e) {

            retVal = retVal + e.getMessage() + " for " + restUrl;

        } catch (IOException e) {

            retVal = retVal + e.getMessage() + " for " + restUrl + " [Check that the url returns a response in your browser]";

        }

        return retVal;

    }


}
