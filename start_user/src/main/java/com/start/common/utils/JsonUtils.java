package com.start.common.utils;

import java.util.HashMap;
import java.util.Map;

public class JsonUtils {

    public static Map<String, Object> init(String key, Object value) {
        Map<String, Object> data = new HashMap<>();
        data.put(key, value);
        return data;
    }
}
