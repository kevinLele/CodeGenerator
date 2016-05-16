package com.leader.CloudServer.Generator.entity;

/**
 * Created by Administrator on 2015/10/5 0005.
 */
public class Config {

    private Path path;

    private TableConfig tblConfig;

    private DatabaseCfg dbCfg;

    private String restPathPrefix;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public TableConfig getTblConfig() {

        return tblConfig;
    }

    public void setTblConfig(TableConfig tblConfig) {
        this.tblConfig = tblConfig;
    }

    public DatabaseCfg getDbCfg() {
        return dbCfg;
    }

    public void setDbCfg(DatabaseCfg dbCfg) {
        this.dbCfg = dbCfg;
    }

    public String getRestPathPrefix() {
        return restPathPrefix;
    }

    public void setRestPathPrefix(String restPathPrefix) {
        this.restPathPrefix = restPathPrefix;
    }
}
