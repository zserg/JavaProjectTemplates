package com.zserg.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleClient implements Client{

  private Decoder decoder;
  private Encoder encoder;

  @Autowired
  private BeanFactory beanFactory;

  public boolean init() {
    this.decoder = beanFactory.getBean("decoder", Decoder.class);
    this.encoder = beanFactory.getBean("encoder", Encoder.class);

    String s = "Hello, world!";
    return s.equals(decoder.decode(encoder.encode(s)));
  }

}


