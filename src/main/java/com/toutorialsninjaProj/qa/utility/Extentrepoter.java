package com.toutorialsninjaProj.qa.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Extentrepoter {

    public static ExtentReports generateExtentReport() throws IOException {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
            "C:/Users/shadows_box/eclipse-workspace/tutorialsninjaProj/test-output/Extentreport/extentreport.html"
        );
        
        ExtentReports extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter);

        Properties prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(
                "C:/Users/shadows_box/eclipse-workspace/tutorialsninjaProj/src/main/java/tutorialsninjaProj/qa/config/config.properties"
            );
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
        extentReport.setSystemInfo("Browser Name", prop.getProperty("browser"));
        extentReport.setSystemInfo("Email", prop.getProperty("validemail"));
        extentReport.setSystemInfo("Password", prop.getProperty("validpassword"));
        extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReport.setSystemInfo("Username", System.getProperty("user.name"));
        extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

        return extentReport;
    }
}
