package com.zserg.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.zserg.model.Model;

public class ModelTest {

	@Test
	public void test_get_id() {
		Model obj = new Model();
		assertEquals("Hello!", obj.getId());
	}

}