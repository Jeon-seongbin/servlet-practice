package org.example;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServerLauncher {

    public static final Logger logger = LoggerFactory.getLogger(WebApplicationServerLauncher.class);

    public static final String webDirLocation = "webapp/";

    public static void main(String[] args) throws LifecycleException {


        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        String path = new File(webDirLocation).getAbsolutePath();
        logger.info("config tomcat server getPath:{}", new File(webDirLocation).getPath());
        logger.info("config tomcat server path:{}", path);
        logger.info("config tomcat server getAbsolutePath:{}", new File(webDirLocation).getAbsolutePath());

        tomcat.addWebapp("/", new File(webDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();

    }
}
