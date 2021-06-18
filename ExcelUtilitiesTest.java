package DataUtility;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ExcelUtilitiesTest {

    @Test
    public void test1(){
        String excelPath = "./Data/TestData.xlsx";
        String sheetName = "Sheet1";

        ExcelUtilities excelUtilities = new ExcelUtilities(excelPath,sheetName);

        Object firstName = excelUtilities.getCelldata(2,0);
        Object lastName = excelUtilities.getCelldata(2,1);
        Object subjectId = excelUtilities.getCelldata(2,2);

        JSONObject request = new JSONObject();

        request.put("firstName",firstName);
        request.put("lastName",lastName);
        request.put("subjectId",subjectId);

        System.out.println(request);

        baseURI="http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();

    }

}
