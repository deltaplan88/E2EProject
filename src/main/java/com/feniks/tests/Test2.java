package com.feniks.tests;

import com.feniks.core.BaseTestTemplate;
import com.feniks.poms.GoogleLoginPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.*;
//@Listeners(com.feniks.core.Listeners.class)


public class Test2 extends BaseTestTemplate {

    //WebDriver driver;




    @Test(dataProvider = "MyDataProvider")
    public  void test(String email, String pass) throws Exception {

        System.out.println("email = "+email);
        System.out.println("pass = "+pass);


      //  Configurator.setLevel(log.getName(), Level.FATAL);
       /* log.trace("trace printed");
        log.debug("debug printed");
        log.info("info printed");
        log.warn("warn printed");
        log.error("error printed");
        log.fatal("fatal printed");*/

       // driver =  initializeDriver();



        driver.get("http:\\www.google.com");

        GoogleLoginPage gPage = new GoogleLoginPage(driver);
        gPage.searchBox.sendKeys("coc");
       // TestUtils.takeAndSaveScreenShot("screenshot1", driver);

     /*  if (email.equals("email2"))
            Assert.assertFalse(gPage.searchBox.isDisplayed());*/

        gPage.searchBox.sendKeys(Keys.ENTER);



    }
   /* @AfterClass
    public void close () {
        driver.close();

    }*/

    @DataProvider(name = "MyDataProvider")
    public Object[][] getData() throws SQLException {

     /*   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root", "root");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Employeeinfo where name = 'sam'");
        //String name = rs.getString("name");
        String location="";
        while (rs.next()){
            location = rs.getString("location");
           System.out.println(location);
        }*/





        Object[][] data = new Object[2][2];
        data[0][0] = "name";
        data[0][1] = "pass";

        data[1][0] = "email3";
        data[1][1] = "pass3";
/*
        data[1][0] = "email4";
        data[1][1] = "pass5";*/


        return data;
    }

}
