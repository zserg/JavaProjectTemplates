package com.zserg.controller;

import org.springframework.stereotype.Component;

@Component
public class DummyEncoder implements Encoder{

    public byte[] encode (String data) {
        return data.getBytes();
    }

}
