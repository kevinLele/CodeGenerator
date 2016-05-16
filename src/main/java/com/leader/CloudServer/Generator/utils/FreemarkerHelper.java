package com.leader.CloudServer.Generator.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/5 0005.
 */
public class FreemarkerHelper {

    private File templatesDir;

    private static FreemarkerHelper helper;

    public static FreemarkerHelper getInstance(File templatesDir) {
        if (null == helper) {
            helper = new FreemarkerHelper();
            helper.setTemplatesDir(templatesDir);
        }

        return helper;
    }

    private void FreemarkerHelper(File templatesDir){
        this.templatesDir = templatesDir;
    }

    public void createFile(Map<String, Object> root, String tplPath, String filePath) {
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

        try {
            // 步骤一：指定 模板文件从何处加载的数据源，这里设置一个文件目录
            cfg.setDirectoryForTemplateLoading(templatesDir);

            // 步骤二：获取 模板文件
            Template template = cfg.getTemplate(tplPath);

            // 创建.java类文件
            File javaFile = new File(filePath);

            if (javaFile != null) {
                Writer javaWriter = new FileWriter(javaFile);
                template.process(root, javaWriter);
                javaWriter.flush();
                System.out.println("文件生成路径：" + javaFile.getCanonicalPath());

                javaWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public File getTemplatesDir() {
        return templatesDir;
    }

    public void setTemplatesDir(File templatesDir) {
        this.templatesDir = templatesDir;
    }
}
