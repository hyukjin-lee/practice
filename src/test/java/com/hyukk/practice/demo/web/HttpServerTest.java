package com.hyukk.practice.demo.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HttpServerTest {

    HttpServer httpServer;

    @BeforeEach
    void setUp() {
        httpServer = new HttpServer();
    }

    @Test
    void testServe() throws IOException {
        httpServer.serve();
    }
}