package com.tx.stu;

import com.tx.stu.entity.User;
import com.tx.stu.interfaces.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void setUp() throws Exception {
        userRepository.save(new User("AAA", 10));
    }

    @After
    public void tearDown() throws Exception {
        userRepository = null;
    }

    @Test
    public void test() {
        User u1 = userRepository.findByName("AAA");
        System.out.println("第一次查询：" + u1.getAge());

        User u2 = userRepository.findByName("AAA");
        System.out.println("第二次查询：" + u2.getAge());
    }
}