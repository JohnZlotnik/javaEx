package com.blueRibbon.ex;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 09/10/2018.
 *
 */
public class utils {

    public static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }
}
