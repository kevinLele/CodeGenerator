package com.leader.CloudServer.Generator;

import com.leader.CloudServer.Generator.entity.Config;
import com.leader.CloudServer.Generator.entity.Entity;
import com.leader.CloudServer.Generator.entity.Path;
import com.leader.CloudServer.Generator.entity.Property;
import com.leader.CloudServer.Generator.utils.ConfigReader;
import com.leader.CloudServer.Generator.utils.FreemarkerHelper;
import com.leader.CloudServer.Generator.utils.StringUtil;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/5 0005.
 */
public class CodeGenerator {

    public static void main(String[] args) {
        generateCodes();
    }

    public static void generateCodes() {
        SAXBuilder saxBuilder = new SAXBuilder();

        Config config = getConfig();
        FreemarkerHelper fmHelper = FreemarkerHelper.getInstance(new File("./Templates"));

        List<Entity> entityList = getEntitiesFromDB(config);

        for(Entity entity : entityList) {
            Map<String, Object> root = createDataModel(entity);

            fmHelper.createFile(root,"entity.ftl",config.getPath().getProjectPath() + config.getPath().getEntityPath() + "\\" + StringUtil.toUpperCaseFirst(entity.getClassName()) + ".java");
            fmHelper.createFile(root,"Provider.ftl",config.getPath().getProjectPath() + config.getPath().getProviderInterfacePath() + "\\I" + StringUtil.toUpperCaseFirst(entity.getClassName()) + "Provider.java");
            fmHelper.createFile(root,"ConsumerXML.ftl",config.getPath().getProjectPath() + config.getPath().getConsumerXmlFilePath() + ".new");
            fmHelper.createFile(root,"Consumer.ftl",config.getPath().getProjectPath() + config.getPath().getConsumerClassFilePath() + ".new");
            fmHelper.createFile(root,"Restful.ftl",config.getPath().getProjectPath() + config.getPath().getRestfulInterfacePath() + "\\I" + StringUtil.toUpperCaseFirst(entity.getClassName()) + "RestServer.java");
            fmHelper.createFile(root,"RestfulImpl.ftl",config.getPath().getProjectPath() + config.getPath().getRestfulImplPath() + "\\" + StringUtil.toUpperCaseFirst(entity.getClassName()) + "RestServerImpl.java");
            fmHelper.createFile(root,"Mapper.ftl",config.getPath().getProjectPath() + config.getPath().getMapperInterfacePath() + "\\" + StringUtil.toUpperCaseFirst(entity.getClassName()) + "Mapper.java");
            fmHelper.createFile(root,"MapperXML.ftl",config.getPath().getProjectPath() + config.getPath().getMapperXmlPath() + "\\" + entity.getTableName().replaceAll("_","-").toLowerCase() + "-mapper.xml");
            fmHelper.createFile(root,"Service.ftl",config.getPath().getProjectPath() + config.getPath().getServiceInterfacePath() + "\\I" + StringUtil.toUpperCaseFirst(entity.getClassName()) + "Service.java");
            fmHelper.createFile(root,"ServiceImpl.ftl",config.getPath().getProjectPath() + config.getPath().getServiceImplPath() + "\\" + StringUtil.toUpperCaseFirst(entity.getClassName()) + "ServiceImpl.java");
            fmHelper.createFile(root,"ServiceBean.ftl",config.getPath().getProjectPath() + config.getPath().getServiceBeanClassFilePath() + ".new");
            fmHelper.createFile(root,"ProviderImpl.ftl",config.getPath().getProjectPath() + config.getPath().getProviderImplPath()  + "\\" + StringUtil.toUpperCaseFirst(entity.getClassName()) + "ProviderImpl.java");
            fmHelper.createFile(root,"ProviderXML.ftl",config.getPath().getProjectPath() + config.getPath().getProviderXmlFilePath() + ".new");
        }
    }

    public static Config getConfig() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document doc = null;

        try {
            doc = saxBuilder.build("Resources/config.xml");
            Element root = doc.getRootElement();

            Config config = ConfigReader.readConfig(root);

            return config;
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 创建数据模型
     * @return
     */
    private static Map<String, Object> createDataModel(Entity entity) {
        Map<String, Object> root = new HashMap<String, Object>();

        root.put("entity",entity);

        return root;
    }

    private static List<Entity> getEntitiesFromDB(Config config) {
        String driver = "com.mysql.jdbc.Driver";

        // URL指向要访问的数据库名scutcs
        String url = config.getDbCfg().getUrl();

        // MySQL配置时的用户名
        String user = config.getDbCfg().getUser();

        // 连接MySQL配置时的密码
        String password = config.getDbCfg().getPassword();

        List<Entity> entityList = new ArrayList<>();

        try {
            // 加载驱动程序
            Class.forName(driver);

            // 连续数据库
            Connection conn = DriverManager.getConnection(url, user, password);

            if (!conn.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");

                for (String tableName : config.getTblConfig().getTables()) {
                    // statement用来执行SQL语句
                    Statement statement = conn.createStatement();

                    String sql = "SELECT * FROM " + tableName;
                    ResultSet rs = statement.executeQuery(sql);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    List<Property> properties = new ArrayList<>();
                    Entity entity = new Entity();
                    entity.setTableName(tableName);
                    entity.setClassName(StringUtil.toUpperCaseAndRemoveUnderLine(tableName.replaceAll(config.getTblConfig().getTablePrefix(), "")));
                    entity.setRestPathPrefix(config.getRestPathPrefix());
                    initJavapackage(config.getPath(), entity);

                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        String field = rsmd.getColumnName(i);
                        String type = rsmd.getColumnTypeName(i);

                        Property property = new Property(field,type);

                        //生成实体类时不需要生成父类已经声明的属性，需要进行标识
                        if(config.getTblConfig().getExcludedFields().contains(field.toLowerCase())){
                            property.setParentProperty(true);
                        }

                        properties.add(property);
                    }

                    entity.setProperties(properties);
                    entityList.add(entity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entityList;
    }

    private static void initJavapackage(Path path, Entity entity) {
        entity.setEntityPackage(StringUtil.getPkg(path.getEntityPath()));
        entity.setProviderPackage(StringUtil.getPkg(path.getProviderInterfacePath()));
        entity.setProviderImplPackage(StringUtil.getPkg(path.getProviderImplPath()));
        entity.setRestfulPackage(StringUtil.getPkg(path.getRestfulInterfacePath()));
        entity.setRestfulImplPackage(StringUtil.getPkg(path.getRestfulImplPath()));
        entity.setServicePackage(StringUtil.getPkg(path.getServiceInterfacePath()));
        entity.setServiceImplPackage(StringUtil.getPkg(path.getServiceImplPath()));
        entity.setMapperPackage(StringUtil.getPkg(path.getMapperInterfacePath()));

        entity.setConsumerClassFilePackage(StringUtil.getPkg(path.getConsumerClassFilePath()).replaceAll(".java", ""));
        entity.setServiceBeanClassFilePackage(StringUtil.getPkg(path.getServiceBeanClassFilePath()).replaceAll(".java", ""));
    }
}
