package com.zserg.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.zserg.controller.Controller;

public class ControllerTest {

	@Test
	public void test_welcome_message() {
		Controller obj = new Controller();
		assertEquals("Hello!", obj.hello());
	}

}
