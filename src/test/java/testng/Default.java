package testng;

import utility.Utility;
import jsonClasses.*;
import api.Http;

import org.testng.annotations.Test;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class Default {
	private String baseUrl = "https://jsonplaceholder.typicode.com/"; 

    @BeforeTest
    public void demo (){
        System.out.println("Hello, this will happen first");
    }

    @Test
    public void demoTwo (){
        System.out.println("Hello again");
    }
    
    @Test
    public void deleteToDo() throws Exception {
    	CloseableHttpResponse response = null;
		try {
			response = Http.httpsDelete(baseUrl + "todos/1");
			Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, 
					"Not successful for reason: " + response.getStatusLine().getReasonPhrase());
		} finally {
			if (response != null) response.close();
		}
    }
    
    @Test
    public void getToDo() throws Exception {
    	CloseableHttpResponse response = null;
		try {
			response = Http.httpsGet(baseUrl + "todos?id=1");
			Assert.assertFalse(EntityUtils.toString(response.getEntity(), "UTF-8").isEmpty(), "Message body was empty.");
			Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, 
					"Not successful for reason: " + response.getStatusLine().getReasonPhrase());
		} finally {
			if (response != null) response.close();
		}
    }
    
    @Test
    public void putToDo() throws Exception {
    	CloseableHttpResponse response = null;
    	ToDo todo = new ToDo(77, 1, "updated test title", true);
		try {
			response = Http.httpsPut(baseUrl + "todos/1", todo);
			ToDo todoResult = Utility.fromJson(EntityUtils.toString(response.getEntity(), "UTF-8"), ToDo.class);
			Assert.assertEquals(todoResult.title, todo.title);
			Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, 
					"Not successful for reason: " + response.getStatusLine().getReasonPhrase());
		} finally {
			if (response != null) response.close();
		}
    }
    
    @Test
    public void postToDo() throws Exception {
    	CloseableHttpResponse response = null;
    	ToDo todo = new ToDo(77, null, "test title", true);
		try {
			response = Http.httpsPost(baseUrl + "todos", todo);
			ToDo todoResult = Utility.fromJson(EntityUtils.toString(response.getEntity(), "UTF-8"), ToDo.class);
			Assert.assertTrue(todoResult.id != null, "Results ID is null.");
			Assert.assertEquals(response.getStatusLine().getStatusCode(), 201, 
					"Not created for reason: " + response.getStatusLine().getReasonPhrase());
		} finally {
			if (response != null) response.close();
		}
    }
}
