package com.nowcoder.communityQ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityQApplication.class)
public class LogTest {
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);
    @Test
    public void testLogger(){
        System.out.println(logger.getName());

        logger.debug("debug logg");
        logger.info("infor log");
        logger.warn("debug log");
        logger.error("error log");

    }
}
