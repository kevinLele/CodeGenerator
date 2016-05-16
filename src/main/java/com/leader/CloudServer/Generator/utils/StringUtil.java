package com.leader.CloudServer.Generator.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/2 0002.
 */
public class StringUtil {

    /**
     * 将下划线后的第一个字母大写，并且删除下划线
     * @param str
     * @return
     */
    public static String toUpperCaseAndRemoveUnderLine(String str) {
        StringBuffer strBuffer = new StringBuffer();

        if (null == str || "".equals(str)) {
            return "";
        }

        char[] charArr = str.toCharArray();
        List<Character> charList = new ArrayList<>();

        boolean needUpperCase = false;

        for (char ch : charArr) {
            if (needUpperCase) {
                strBuffer.append(Character.toUpperCase(ch));
                needUpperCase = false;
            } else {
                if (ch == '_') {
                    needUpperCase = true;
                } else {
                    strBuffer.append(ch);
                }
            }
        }

        return strBuffer.toString();
    }

    public static String toUpperCaseFirst(String str){
        if(null == str || "".equals(str)) {
            return "";
        }

        if (str.length() == 1) {
            return str.toUpperCase();
        }

        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    /**
     * 将文件路径转换为JAVA文件的包路径
     * @param sourcePath
     * @return
     */
    public static String getPkg(String sourcePath) {
        if (null == sourcePath || "".equals(sourcePath)) {
            return "";
        }

        String sourceJavaPath = "\\src\\main\\java\\";
        int idx = sourcePath.indexOf(sourceJavaPath);

        if (idx < 0 || idx >= sourcePath.length()) {
            return sourcePath;
        }

        String pkgPath = sourcePath.substring(idx + sourceJavaPath.length());
        return pkgPath.replaceAll("\\\\",".");
    }
}
