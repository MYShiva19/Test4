package Starwars;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StarWars {
	@Test
	public void starWarsResponse() {
		
		baseURI = "https://swapi.dev/api/people";
		get(baseURI).then().statusCode(200).body("count", equalTo(82));
//		body("results.name", hasItems("Luke Skywalker", "C-3PO", "R2-D2", "Darth Vader", "Leia Organa", "Owen Lars", "Beru Whitesun lars", "R5-D4", "Biggs Darklighter", "Obi-Wan Kenobi"));
		Response response  = get(baseURI);
		JsonPath js = new JsonPath(response.asString());
		List<String> names = js.get("results.name");
		for(String name : names ) {
			System.out.println(name);
		}
		
		Map<Object, Object> test = response.jsonPath().getMap("results");
		System.out.println(test.toString());		
		
//		Map<String, String> heights = js.getMap("results.height");
//		
//		for(Map.Entry<String, String> me: heights.entrySet()) {
//			System.out.println(me.getKey() + " " + me.getValue());
//		}
		
//		Assert.assertEquals(200, response.getStatusCode());
//		System.out.println(response.getBody().asPrettyString());
		
		
	}

}
