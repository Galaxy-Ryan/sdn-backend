package com.glimmer.service.impl;

import com.glimmer.service.LinksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class LinksServiceImpl implements LinksService {

    static String onosUrl = "http://localhost:8181/onos/v1/";
    static String endPoint = "links";
    static String username = "onos";
    static String password = "rocks";

    public String getLinks() {
        try {
            String urlStr = onosUrl + endPoint;
            URL url = new URL(urlStr);
            System.out.println("URL: " + url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            String auth = username + ":" + password;
            String encodeAuth = java.util.Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
            System.out.println("encodeAuth: " + encodeAuth);
            httpURLConnection.setRequestProperty("Authorization", "Basic " + encodeAuth);

            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            } else {
                log.info("Request failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}