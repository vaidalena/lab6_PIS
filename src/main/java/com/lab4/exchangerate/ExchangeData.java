package com.lab4.exchangerate;

import org.json.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class ExchangeData {
    public static String parseUrl(URL url)
    {
        StringBuilder stringBuilder = new StringBuilder();

        try(BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())))
        {
            String inputLine;
            while ((inputLine = in.readLine())!=null)
            {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static List<JSONObject> requestExchange() throws IOException
    {
        JSONArray arrExchange = new JSONArray(parseUrl(new URL("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5")));
        List<JSONObject> obj = new ArrayList<>();
        for(int i=0; i<arrExchange.toList().size(); i++)
        {
            obj.add((JSONObject) arrExchange.get(i));
        }
        return obj;
    }
}
