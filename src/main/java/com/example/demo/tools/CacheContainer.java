package com.example.demo.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by M.Hadiyan
 * Date: 6/24/2023
 * Time: 9:00 AM
 **/
public class CacheContainer {

    private static final CacheContainer CACHE_CONTAINER = new CacheContainer();

    private Map<String, List<String>> map = new HashMap<>();


    public static CacheContainer getInstance() {
        return CACHE_CONTAINER;
    }

    public Map<String, List<String>> createCacheContainer(String element, List<String> nodes) {
        if (map.isEmpty()) {
            map = XmlReader.getInstance().readXml(element, nodes);
        }
        return map;
    }

    public List<String> getCacheContainer(String key, Map<String, List<String>> map) {
        return map.get(key);
    }


    public Map<String, List<String>> getCache() {
        return map;
    }


    //createCacheContainer(key , Map)
    //getCacheContainer()
    //getCache(containerName,key)
    //putCache(containerName, Map)
}
