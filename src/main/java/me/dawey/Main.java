package me.dawey;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static String requestBody;
    public static URL URLString;

    public static void main(String[] args) throws IOException {
        // Read the request body from a file
        requestBody = Files.readString(Path.of("src/main/resources/requestBody.txt"));

        try {
            URLString = new URL("http://api.uniassist.hu:3000/api/creator");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Open the HTTP connection
        HttpURLConnection connection = (HttpURLConnection) URLString.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);

        // Connect to the server and send the request body
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Optional: Handle the response from the server
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        String responseString = "";
        // Read the response
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            responseString = String.valueOf(response);
        }

        //Converter Class
        Gson gson = new Gson();

        //Convert JSON to the class.
        TimeTableResponse timetableResponse = gson.fromJson(responseString, TimeTableResponse.class);


        //Print the data
        System.out.println("Státusz: " + timetableResponse.getStatus());
        System.out.println("Üzenet:" + timetableResponse.getMessage());
        for (Course course : timetableResponse.getCourses()) {
            System.out.println("Kurzusnev: " + course.getCourseLabel());
        }

        connection.disconnect();
    }
}