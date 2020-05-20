package com.xtgj.j2ee.chapter10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xtgj.j2ee.chapter10.impl.OrderServiceBean;

public class AOPTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		OrderServiceBean orderService = (OrderServiceBean) context
				.getBean("orderservice");
		orderService.save();
	}
}
