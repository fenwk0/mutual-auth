package com.macymoo.mutualauth.utils;

import org.apache.http.ssl.SSLContextBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;


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

            retVal = "Success: [" + conn.getResponseCode() + "]\n";

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

    //= SSLContexts.custom();.
    KeyStore loadKeystore(
            String storeLocation,
            String storePassword,
            String storeType,
            SSLContextBuilder sslContextBuilder) {

        KeyStore retVal = null;


        try {
            retVal = KeyStore.getInstance(storeType);

            loadStore(storeLocation, storePassword, retVal);

            sslContextBuilder.loadTrustMaterial(retVal, null);

        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    private void loadStore(String storeLocation, String storePassword, KeyStore retVal)
            throws NoSuchAlgorithmException,
            CertificateException {
        Path storePath = Paths.get(storeLocation);
        try (InputStream is = Files.newInputStream(storePath)) {
            retVal.load(is, storePassword.toCharArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
