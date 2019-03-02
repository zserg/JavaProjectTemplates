package com.zserg.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.zserg.controller.Controller;

@Slf4j
public class ControllerTest {

	@Test
	@DisplayName("Controller Test")
	public void test_welcome_message() {
		log.info("Controller test started");
		Controller obj = new Controller();
		assertEquals("Hello!", obj.hello());
	}

}
