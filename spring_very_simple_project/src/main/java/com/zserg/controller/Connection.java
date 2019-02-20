package com.zserg.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Connection {
    private Client client;

    @Autowired
    private BeanFactory beanFactory;

    public boolean start() {
        this.client = beanFactory.getBean("client", Client.class);
        return client.init();
    }
}
