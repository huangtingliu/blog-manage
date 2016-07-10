package blogmgr.test.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huangtl.blogmgr.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class UserDaoTest {
	@Resource
	private UserService  userService;
	
	
	@Test
	public void userAddTest(){
		System.out.println(userService.addUser(null));
	}
	
}
