package com.example.WebServiceDemo;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.example.controller.RestControllerDemo;


public class RestControllerDemoTest extends AbstractJUnit4SpringContextTests{
	
	
	@InjectMocks
	private RestControllerDemo restController;
	
	@Test
	public void getValues()
	{
		assertThat("hello, Yes.. It is Working..!!!",restController.getUserData()!=null);
	}

}
