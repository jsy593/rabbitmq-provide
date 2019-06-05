package com.jsy.rabbitmqprovide;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqProvideApplicationTests {

	@Autowired
	private FactorProvider factorProvider;
	@Autowired
	private OrderProvider orderProvider;
	@Autowired
	private NotifyAllProvider notifyAllProvider;
	@Test
	public void test() {
		System.out.println("发送之前--------------------------------------------------");
		notifyAllProvider.sendMessage();
		System.out.println("发送完成--------------------------------------------------");
	}


}
