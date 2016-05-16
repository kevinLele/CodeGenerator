package com.leader.CloudServer.Generator.utils;

import com.leader.CloudServer.Generator.entity.Config;
import com.leader.CloudServer.Generator.entity.DatabaseCfg;
import com.leader.CloudServer.Generator.entity.Path;
import com.leader.CloudServer.Generator.entity.TableConfig;
import org.jdom2.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/5 0005.
 */
public class ConfigReader {

    public static Config readConfig(Element root) {
        Path path = getPath(root.getChild("paths"));
        TableConfig tblCfg = getTableConfig(root.getChild("tableCfg"));
        DatabaseCfg dbCfg = getDBCfg(root.getChild("DatabaseCfg"));

        Config config = new Config();
        config.setPath(path);
        config.setTblConfig(tblCfg);
        config.setDbCfg(dbCfg);
        config.setRestPathPrefix(root.getChildText("restPathPrefix"));

        return config;
    }

    public static Path getPath(Element pathEle) {
        Path path = new Path();

        path.setProjectPath(pathEle.getChildText("projectPath"));
        path.setEntityPath(pathEle.getChildText("entityPath"));
        path.setProviderInterfacePath(pathEle.getChildText("providerInterfacePath"));
        path.setRestfulInterfacePath(pathEle.getChildText("restfulInterfacePath"));
        path.setRestfulImplPath(pathEle.getChildText("restfulImplPath"));
        path.setMapperInterfacePath(pathEle.getChildText("mapperInterfacePath"));
        path.setMapperXmlPath(pathEle.getChildText("mapperXmlPath"));
        path.setServiceInterfacePath(pathEle.getChildText("serviceInterfacePath"));
        path.setServiceImplPath(pathEle.getChildText("serviceImplPath"));
        path.setProviderImplPath(pathEle.getChildText("providerImplPath"));
        path.setConsumerXmlFilePath(pathEle.getChildText("consumerXmlFilePath"));
        path.setProviderXmlFilePath(pathEle.getChildText("providerXmlFilePath"));
        path.setConsumerClassFilePath(pathEle.getChildText("consumerClassFilePath"));
        path.setServiceBeanClassFilePath(pathEle.getChildText("serviceBeanClassFilePath"));
        path.setTesterClassFilePath(pathEle.getChildText("testerClassFilePath"));

        return path;
    }

    public static TableConfig getTableConfig(Element tableCfg) {
        TableConfig config = new TableConfig();
        List<String> tables = new ArrayList<>();

        Element tablesEle = tableCfg.getChild("tables");
        Element excludedFieldsEle = tableCfg.getChild("excludedFields");

        config.setTablePrefix(tablesEle.getAttributeValue("tablePrefix"));
        List<Element> tblEles = tablesEle.getChildren("table");

        for(Element tblEle : tblEles) {
            tables.add(tblEle.getText());
        }

        config.setTables(tables);

        List<Element> fieldEles = excludedFieldsEle.getChildren("field");
        List<String> excludeFields = new ArrayList<>();

        for(Element fieldEle : fieldEles) {
            excludeFields.add(fieldEle.getText());
        }

        config.setExcludedFields(excludeFields);

        return config;
    }

    public static DatabaseCfg getDBCfg(Element cfgEle) {
        DatabaseCfg cfg = new DatabaseCfg();

        cfg.setUrl(cfgEle.getChildText("url"));
        cfg.setUser(cfgEle.getChildText("user"));
        cfg.setPassword(cfgEle.getChildText("password"));

        return cfg;
    }
}
