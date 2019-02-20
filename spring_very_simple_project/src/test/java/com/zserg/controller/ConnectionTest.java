package com.zserg.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader= AnnotationConfigContextLoader.class)
public class ConnectionTest {

    @Configuration
    static class ContextConfiguration {

        @Bean
        public Client client() {
            return new SimpleClient();
        }

        @Bean
        public Decoder decoder() {
            return new DummyDecoder();
        }

        @Bean
        public Encoder encoder() {
            return new DummyEncoder();
        }

        @Bean
        public Connection con() {
            return new Connection();
        }


    }

    @Autowired
    private Connection con;

    @Test
    public void startTest() {
        assertTrue(con.start());
    }
}

