package com.hq.springboot01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01ApplicationTests {


    @Test
    void contextLoads() {


    }

    public static void main(String[] args) {
      String str="DealModesdfsd";
        System.out.println(str.contains("dealMode"));
    }

}
