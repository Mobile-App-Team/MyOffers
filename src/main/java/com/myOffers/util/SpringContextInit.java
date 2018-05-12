package com.myOffers.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextInit {
	
	public static ApplicationContext getContext(){
		return new ClassPathXmlApplicationContext("Spring-Module.xml");
	}

}
