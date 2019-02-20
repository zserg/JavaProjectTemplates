package com.zserg.controller;

import org.springframework.stereotype.Component;

@Component
public class DummyDecoder implements Decoder{

    public String decode (byte[] data) {
        return new String(data);
    }

}
