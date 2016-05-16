package com.leader.CloudServer.Generator;

import com.leader.CloudServer.Generator.entity.*;
import com.leader.CloudServer.Generator.utils.ConfigReader;
import com.leader.CloudServer.Generator.utils.StringUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    /*public static void main(String[] args) {
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document doc = saxBuilder.build("Resources/config.xml");
            Element root = doc.getRootElement();

            Config config = ConfigReader.readConfig(root);

            List<Entity> entityList = mysql(config);
            freemaker(config,entityList);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void freemaker(Config config, List<Entity> entityList){
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

        try {
            // 步骤一：指定 模板文件从何处加载的数据源，这里设置一个文件目录
            cfg.setDirectoryForTemplateLoading(new File("./Templates"));

            // 步骤二：获取 模板文件
            Template template = cfg.getTemplate("Entity.ftl");

            for(Entity entity : entityList) {
                // 步骤三：创建 数据模型
                Map<String, Object> root = createDataModel(entity);

                // 步骤四：合并 模板 和 数据模型
                // 创建.java类文件
                File javaFile = new File(config.getPath().getProjectPath() + config.getPath().getEntityPath(),entity.getClassName() + ".java");

                if(javaFile != null){
                    Writer javaWriter = new FileWriter(javaFile);
                    template.process(root, javaWriter);
                    javaWriter.flush();
                    System.out.println("文件生成路径：" + javaFile.getCanonicalPath());

                    javaWriter.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    *//**
     * 创建数据模型
     * @return
     *//*
    private static Map<String, Object> createDataModel(Entity entity) {
        Map<String, Object> root = new HashMap<String, Object>();

        root.put("entity",entity);

        return root;
    }



*/
}
