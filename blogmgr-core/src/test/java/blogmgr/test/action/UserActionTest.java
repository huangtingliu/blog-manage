package blogmgr.test.action;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.huangtl.blogmgr.action.UserAction;
import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.blog.dictionary.Gender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class UserActionTest {

	@Resource
	private UserAction userAction;
	
	@Test
	public void testGetPaging() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUser() {
		Object obj = userAction.getUser("09dbccec890a4fa8bcd6b71f360551f4");
		System.out.println(JSON.toJSONString(obj, true));
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testBatchEditUser() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setfId("09dbccec890a4fa8bcd6b71f360551f4");
		user.setfName("改");
		users.add(user);
		 user = new User();
		user.setfId("0e606e19adc4450e812d07f6a6ac4cdd");
		user.setfName("变");
		user.setfGender(Gender.UNKNOW);
		users.add(user);
		
		Object obj  = userAction.editBatchUser(users);
		System.out.println(JSON.toJSONString(obj, true));
	}

	@Test
	public void testEditUser() {
		fail("Not yet implemented");
	}

}
