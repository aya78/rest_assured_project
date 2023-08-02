package rest;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
//import static sun.net.ProgressMonitor.pm;

public class myRestAssuredProject {
   final static String url = "http://demo.guru99.com/V4/sinkministatement.php";
    @Test(priority = 0)
    public static void  getResponseBody(){
//        given().baseUri("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").then().log()
//                .all();

        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();
    }
    @Test(priority = 1)
    public static void getResponseStatus(){
        int status_code = given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is "+status_code);
        given().when().get(url).then().assertThat().statusCode(200);
    }
    @Test(priority = 2)
    public static void getResponseHeader(){

        System.out.println("the header in the response"+ get(url).then().extract().headers());
    }
    @Test(priority = 3)
    public static void getResponseTime(){

        System.out.println("the Time in the response"+ get(url).timeIn(TimeUnit.MILLISECONDS)+" MILLISECONDS");
    }
    @Test(priority = 4)
    public static void getResponseContentType(){

        System.out.println("the content type of response "+get(url).then().extract().contentType());
    }
}
