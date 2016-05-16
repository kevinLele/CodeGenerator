package com.leader.CloudServer.Generator.entity;

import java.util.List;

/**
 * Created by Administrator on 2015/9/13 0013.
 */
public class Entity {
    private String entityPackage;

    private String providerPackage;

    private String providerImplPackage;

    private String mapperPackage;

    private String servicePackage;

    private String serviceImplPackage;

    private String restfulPackage;

    private String restfulImplPackage;

    private String consumerClassFilePackage;

    private String serviceBeanClassFilePackage;

    private String restPathPrefix;

    private String className;

    private String tableName;

    private List<Property> properties;

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getProviderPackage() {
        return providerPackage;
    }

    public void setProviderPackage(String providerPackage) {
        this.providerPackage = providerPackage;
    }

    public String getProviderImplPackage() {
        return providerImplPackage;
    }

    public void setProviderImplPackage(String providerImplPackage) {
        this.providerImplPackage = providerImplPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getServiceImplPackage() {
        return serviceImplPackage;
    }

    public void setServiceImplPackage(String serviceImplPackage) {
        this.serviceImplPackage = serviceImplPackage;
    }

    public String getRestfulPackage() {
        return restfulPackage;
    }

    public void setRestfulPackage(String restfulPackage) {
        this.restfulPackage = restfulPackage;
    }

    public String getRestfulImplPackage() {
        return restfulImplPackage;
    }

    public void setRestfulImplPackage(String restfulImplPackage) {
        this.restfulImplPackage = restfulImplPackage;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public String getConsumerClassFilePackage() {
        return consumerClassFilePackage;
    }

    public void setConsumerClassFilePackage(String consumerClassFilePackage) {
        this.consumerClassFilePackage = consumerClassFilePackage;
    }

    public String getRestPathPrefix() {
        return restPathPrefix;
    }

    public void setRestPathPrefix(String restPathPrefix) {
        this.restPathPrefix = restPathPrefix;
    }

    public String getServiceBeanClassFilePackage() {
        return serviceBeanClassFilePackage;
    }

    public void setServiceBeanClassFilePackage(String serviceBeanClassFilePackage) {
        this.serviceBeanClassFilePackage = serviceBeanClassFilePackage;
    }
}
