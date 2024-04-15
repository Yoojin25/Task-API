package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    public static RequestSpecBuilder specBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter());
    }

    public static RequestSpecification requestSpec() {
        return specBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestSpecXml() {
        return specBuilder()
                .setContentType(ContentType.XML)
                .build();
    }

    public static ResponseSpecification responseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }
}
