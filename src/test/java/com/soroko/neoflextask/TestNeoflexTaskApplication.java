package com.soroko.neoflextask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestNeoflexTaskApplication {

	public static void main(String[] args) {
		SpringApplication.from(NeoflexTaskApplication::main).with(TestNeoflexTaskApplication.class).run(args);
	}

}
