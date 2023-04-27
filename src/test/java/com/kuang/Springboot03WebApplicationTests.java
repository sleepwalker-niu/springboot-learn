package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class Springboot03WebApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws Exception{
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

}
