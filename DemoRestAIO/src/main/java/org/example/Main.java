package org.example;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.filter.log.LogDetail;
import static io.restassured.RestAssured.given;

import java.util.*;

public class Main {
    public static final String CREATE_CYCLE = "/project/{projectKey}/testcycle/detail";
    public static final String MARK_CASE = "project/{projectKey}/testcycle/{cycleKey}/testcase/{caseKey}/testrun?createNewRun={createNewRun}";

    private static RequestSpecification defaultRequestSpec;
    public static void main(String[] args) {

//        setupAIORestAssuredConfig();
//
//        String projectKey = "TES";
//        String newCycleKey = createCycle(projectKey);
//
//        //Mark test execution status of cases - status/duration can come from Result object of test frameworks
//        markCaseStatus(projectKey, newCycleKey, Arrays.asList("TES-TC-8","TES-TC-9","TES-TC-10"), "Passed");

        System.out.println("Hello world!");
    }

//    public static String createCycle(String projectKey) {
//        Map<String, Object> newCycleDetails = new HashMap<>();
//        newCycleDetails.put("title", "Regression Release 1");
//        newCycleDetails.put("objective", "Trial Run");
//
//        //If cycle needs to be created in specific folder, add folder information
//        newCycleDetails.put("folder", Collections.singletonMap("ID","213"));
//
//        Response response = doPost(CREATE_CYCLE, newCycleDetails, projectKey);
//        String newCycleKey = response.jsonPath().getString("key");
//        return newCycleKey;
//    }
//
//    public static void markCaseStatus(String projectKey, String cycleKey, List<String> caseKeys, String testRunStatus) {
//        Map<String, Object> runStatus = new HashMap<>();
//        runStatus.put("testRunStatus", testRunStatus);
//        runStatus.put("effort", "60000");
//        for(String caseKey : caseKeys) {
//            //Passing run status, path params and createNewRun as true
//            doPost(MARK_CASE, runStatus, projectKey, cycleKey, caseKey, "true" );
//        }
//    }
//
//    public static Response doPost(String path, Map<String, Object> params, Object ...pathParams) {
//        Response response = given(defaultRequestSpec).contentType(ContentType.JSON).body(params).when().post(path,pathParams).andReturn();
//        return response;
//    }
//
//    public static void setupAIORestAssuredConfig() {
//        RequestSpecBuilder builder   = new RequestSpecBuilder();
//        builder.setBaseUri("https://tcms.aioreports.com").setBasePath("/aio-tcms/api/v1");
//        builder.addHeader("Authorization", "AioAuth NWZjMmI4MzUtOTRmZS00NGQ0LTgxYTktZjVhOWI4MDFjNWEz");
//        builder.log(LogDetail.METHOD).log(LogDetail.URI);
//        defaultRequestSpec = builder.build();
//    }
}