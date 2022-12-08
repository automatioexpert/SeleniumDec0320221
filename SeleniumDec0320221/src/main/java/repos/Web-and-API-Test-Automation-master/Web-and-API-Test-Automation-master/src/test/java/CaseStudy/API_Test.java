package CaseStudy;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class API_Test {


	String key = "e2bed3149b650b4e55909ba4b8be0743";
	String token = "674f62b9a95e0924d931f93c6cb1748d1ae0f05de985e4987597f69212d5f923";
	
	
	
	@Test
	public void TrelloApiTest() {
		RestAssured.baseURI="https://api.trello.com";
		
		//CreateBoard
		Response BoardResponse = given().contentType(ContentType.JSON).log().all().queryParam("key",key).queryParam("token", token).queryParam("name", "Testinum")
				.when().post("/1/boards/");
		
		BoardResponse.then().log().all().assertThat().statusCode(200);
		
		String idBoard = BoardResponse.then().extract().response().path("id");

		
		//CreateList to create card
		Response ListResponse=given().contentType(ContentType.JSON).log().all().queryParam("key",key).queryParam("token", token).
				queryParam("name", "test1").
				queryParam("idBoard", idBoard)
				.when().post("/1/lists/");
		
		ListResponse.then().log().all().assertThat().statusCode(200);
		
		String idList = ListResponse.then().extract().response().path("id");
		
		//CreateCard
		 Response CardResponse = given().contentType(ContentType.JSON).log().all().queryParam("key",key).queryParam("token", token).
				queryParam("idList", idList)
				.when().post("/1/cards/");
		
		CardResponse.then().log().all().assertThat().statusCode(200);
		 String cardId = CardResponse.then().extract().response().path("id");

		 
		 //UpdateCard
		 Response UpdateCardResponse = given().contentType(ContentType.JSON).log().all().
				 pathParam("id", cardId).queryParam("key",key).queryParam("token", token).queryParam("name", "cardtest").
              when().put("/1/cards/{id}/");
		
		UpdateCardResponse.then().log().all().assertThat().statusCode(200);
		
		
		//DeleteCard
		 Response deleteCard = given().contentType(ContentType.JSON).log().all().
				 pathParam("id", cardId).queryParam("key",key).queryParam("token", token).
	              when().delete("/1/cards/{id}/");
		 
		 deleteCard.then().log().all().assertThat().statusCode(200);
		 
		 
		 //DeleteBoard
		 Response deleteBoard = given().contentType(ContentType.JSON).log().all().
				 pathParam("id", idBoard).queryParam("key",key).queryParam("token", token).
	              when().delete("/1/boards/{id}/");
		 
		 deleteBoard.then().log().all().assertThat().statusCode(200);
	}
	
	
	

	}

