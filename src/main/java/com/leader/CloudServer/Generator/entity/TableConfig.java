package com.leader.CloudServer.Generator.entity;

import java.util.List;

/**
 * Created by Administrator on 2015/10/5 0005.
 */
public class TableConfig {
    private String tablePrefix;

    private List<String> tables;

    private List<String> excludedFields;

    public List<String> getTables() {
        return tables;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public List<String> getExcludedFields() {
        return excludedFields;
    }

    public void setExcludedFields(List<String> excludedFields) {
        this.excludedFields = excludedFields;
    }
}
