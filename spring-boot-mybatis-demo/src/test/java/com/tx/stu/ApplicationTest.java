package com.tx.stu;

import com.tx.stu.interfaces.UserMapper;
import com.tx.stu.pojo.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    @Autowired
    private UserMapper userMapper;

    @After
    public void tearDown() throws Exception {
        userMapper = null;
    }

    @Test
    @Rollback
    public void findByName() throws Exception {
        User u = userMapper.findByName("yiibai");
    }
}