package com.dreamer.listfilesanddir;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "listFilesAndDir")
@SessionScoped
public class ListFilesAndDir implements Serializable {

    private ArrayList list=new ArrayList();
    private String classPath;

    public ListFilesAndDir() {
        //Начинает читать от каталога tomcat
        //File file=new File("./../webapps/Properties-1.0-SNAPSHOT/WEB-INF");
        File file=new File("./");
        for(File sub:file.listFiles()){
            list.add(sub);
        }
        
        //пример, classpath, каталог с классами приложения
        //File currentClass = new File(URLDecoder.decode(ВашКласс.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8"));
       //String classDirectory = currentClass.getParent();
        this.classPath = ListFilesAndDir.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    }
    
    public ArrayList getList() {
        return list;
    }
    
    public String getClassPath() {
        return classPath;
    }
}
