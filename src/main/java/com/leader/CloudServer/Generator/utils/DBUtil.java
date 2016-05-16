package com.leader.CloudServer.Generator.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/2 0002.
 */
public class DBUtil {
    public static Map<String,String> typeMap = new HashMap<String,String>();

    public static Map<String,String> fullTypeMap = new HashMap<String,String>();

    static{
        typeMap.put("varchar","String");
        typeMap.put("datetime","Date");
        typeMap.put("longtext","String");

        fullTypeMap.put("varchar","java.lang.String");
        fullTypeMap.put("datetime","java.util.Date");
        fullTypeMap.put("longtext","java.lang.String");
    }

    /**
     * 将数据库中的字段类型转换为JAVA中的类型
     * @param dbType
     * @return
     */
    public static String dbType2JavaType(String dbType) {
        String javaType = typeMap.get(dbType);
        String fullJavaType = fullTypeMap.get(dbType);

        if (null == javaType) {
            javaType = "String";
            fullJavaType = "java.lang.String";
        }

        return javaType;
    }

    public static String dbType2FullJavaType(String dbType) {
        String fullJavaType = fullTypeMap.get(dbType);

        if (null == fullJavaType) {
            fullJavaType = "java.lang.String";
        }

        return fullJavaType;
    }
}
