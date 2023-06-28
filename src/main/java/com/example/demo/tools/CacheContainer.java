package com.example.demo.tools;

import com.example.demo.annotation.Security;

import java.io.File;
import java.util.*;

/**
 * Created by M.Hadiyan
 * Date: 6/24/2023
 * Time: 9:00 AM
 **/
public class CacheContainer {

    private static final CacheContainer CACHE_CONTAINER = new CacheContainer();

    private Map<String, Map<String, List<Class<?>>>> allCaches = new HashMap<>();

    private Map<String, List<Class<?>>> roleMap = new HashMap<>();

    private Map<String, List<Class<?>>> fileMap = new HashMap<>();


    public static CacheContainer getInstance() {
        return CACHE_CONTAINER;
    }

    private Map<String, List<Class<?>>> getFileMap(File f) {
        for (File file : Objects.requireNonNull(f.listFiles())) {
            if (file.isFile()) {
                fileMap.put(file.getName(), Collections.singletonList(file.getClass()));
            } else {
                for (File listFile : Objects.requireNonNull(file.listFiles())) {
                    getFileMap(listFile);
                }
            }
        }
        return fileMap;
    }

    private Map<String, List<Class<?>>> getRoleMap(File f, String fileFilter) {
        for (File file : Objects.requireNonNull(f.listFiles())) {
            if (file.isFile() && file.getName().endsWith(fileFilter) && file.getClass().getAnnotation(Security.class) != null) {
                roleMap.put(file.getName(), Collections.singletonList(file.getClass()));
            } else {
                for (File listFile : Objects.requireNonNull(file.listFiles())) {
                    getRoleMap(listFile, fileFilter);
                }
            }
        }
        return roleMap;
    }

    public void createCacheContainer(File file, String fileFilter) {
        allCaches.put("FILE_MAP", getFileMap(file));
        allCaches.put("ROLE_MAP", getRoleMap(file, fileFilter));
    }

    public Map<String, List<Class<?>>> getRoleMap() {
        return allCaches.get("ROLE_MAP");
    }

    public Map<String, List<Class<?>>> getMapByKey(String key) {
        return allCaches.get(key);
    }
}
