package com.springmvc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HkDispatcherServlet extends HttpServlet {

    private Properties config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //加载配置
        doLocationConfig(config.getInitParameter("contentConfigLocation"));

        //解析配置，并扫描
        doScanner();

    }

    private void doScanner() {
        String scannerpackage = this.config.getProperty("scannerpackage");
        System.out.println(scannerpackage);

    }

    private void doLocationConfig(String contentLocation) {
        this.config = new Properties();
        try(InputStream resourceAsStream = this.getClass().getResourceAsStream("/"+contentLocation)){
            this.config.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
