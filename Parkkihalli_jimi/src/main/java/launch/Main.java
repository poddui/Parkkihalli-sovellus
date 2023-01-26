package launch;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Main {

    public static void main(String[] args) throws Exception {

        String webappDirPath = new File("src/main/webapp/").getAbsolutePath();

        Tomcat tomcat = new Tomcat();

        String httpPort = System.getenv().getOrDefault("PORT", "8080");
        tomcat.setPort(Integer.valueOf(httpPort));

        tomcat.getConnector();

        Context webApp = tomcat.addWebapp("/", webappDirPath);

         webApp.setReloadable(true);

        WebResourceRoot resources = new StandardRoot(webApp);
        resources.addPreResources(
                new DirResourceSet(resources, "/WEB-INF/classes", new File("target/classes").getAbsolutePath(), "/"));
        webApp.setResources(resources);


        webApp.setRequestCharacterEncoding("utf-8");
        webApp.setResponseCharacterEncoding("utf-8");
        
        tomcat.start();
        tomcat.getServer().await();
    }
}