package com.vaman.hr.demo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;

public class ApacheHttpDemo {

	public static void main(String[] args) throws IOException {

		String url = "https://jsonplaceholder.typicode.com/posts";
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet(url);

		CloseableHttpResponse response = httpClient.execute(httpGet);

		int statusCode = response.getCode();
		System.out.println(statusCode);

		HttpEntity entity = response.getEntity();
		InputStream input = entity.getContent();
		byte[] allBytes = input.readAllBytes();

		System.out.println("Start");
		for (byte b : allBytes)
			System.out.print((char) b);
		System.out.println("End");

		httpClient.close();

	}

}
