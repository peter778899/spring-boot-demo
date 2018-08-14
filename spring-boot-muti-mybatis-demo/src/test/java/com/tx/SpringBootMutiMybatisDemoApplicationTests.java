package com.tx;

import com.tx.stu.interfaces2.UserMapper2;
import com.tx.stu.interfaces.UserMapper;
import com.tx.stu.pojo.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMutiMybatisDemoApplicationTests {
	@Resource
	private UserMapper userMapper;

	@Resource
	private UserMapper2 userMapper2;

	@After
	public void tearDown() throws Exception {
		userMapper = null;
	}

	@Test
	@Rollback
	public void findByName() throws Exception {
		User u = userMapper.findByName("yibai");
	}

	@Test
	@Rollback
	public void findByName2() throws Exception {
		User u = userMapper2.findByName("saya");
	}

}
