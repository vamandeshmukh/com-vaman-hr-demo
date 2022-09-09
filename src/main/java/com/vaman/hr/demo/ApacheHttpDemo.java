package com.vaman.hr.demo;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vaman.hr.demo.model.Post;

public class ApacheHttpDemo {

	public static void main(String[] args) throws IOException {

		String url = "https://jsonplaceholder.typicode.com/posts";
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet(url);

		CloseableHttpResponse response = httpClient.execute(httpGet);

		int statusCode = response.getCode();
		System.out.println(statusCode);

		String postsJsonData = new String(response.getEntity().getContent().readAllBytes());

		Gson gson = new Gson();
		Type listType = new TypeToken<List<Post>>() {
		}.getType();

		List<Post> postList = gson.fromJson(postsJsonData, listType);

		postList.forEach(p -> System.out.println(p.toString()));

		httpClient.close();
	}
}
