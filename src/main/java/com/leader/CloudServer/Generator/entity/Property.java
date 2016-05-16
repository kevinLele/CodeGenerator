package com.leader.CloudServer.Generator.entity;

import com.leader.CloudServer.Generator.utils.DBUtil;
import com.leader.CloudServer.Generator.utils.StringUtil;

/**
 * Created by Administrator on 2015/9/13 0013.
 */
public class Property {

    /**
     * JAVA中的字段类型
     */
    private String javaType;

    private String fullJavaType;

    /**
     * 属性名称
     */
    private String propertyName;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 字段类型
     */
    private String fieldType;

    /**
     * 是否是父类的属性
     */
    private boolean parentProperty = false;

    public Property(String fieldName, String fieldType) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;

        this.propertyName = StringUtil.toUpperCaseAndRemoveUnderLine(fieldName);
        this.javaType = DBUtil.dbType2JavaType(fieldType.toLowerCase());
        this.fullJavaType = DBUtil.dbType2FullJavaType(fieldType.toLowerCase());
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFullJavaType() {
        return fullJavaType;
    }

    public void setFullJavaType(String fullJavaType) {
        this.fullJavaType = fullJavaType;
    }

    public boolean getParentProperty() {
        return parentProperty;
    }

    public void setParentProperty(boolean parentProperty) {
        this.parentProperty = parentProperty;
    }
}
