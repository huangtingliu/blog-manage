package blogmgr.test.action;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.huangtl.blogmgr.action.MenuAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class MenuActionTest {
	@Resource
	private MenuAction menuAction;
	
	@Test
	public void testGetPaging() {
		Object menu = menuAction.getPaging(1, 5, null, null);
		System.out.println(JSON.toJSONString(menu,true));
	}

	@Test
	public void testGetList() {
		Object menu = menuAction.getList("A001", null);
		System.out.println(JSON.toJSONString(menu,true));
	}

	@Test
	public void testGetTreeNode() {
		Object menu =  menuAction.getTreeNode("A001", null);
		System.out.println(JSON.toJSONString(menu,true));
	}

	@Test
	public void testGetOne() {
		Object menu =  menuAction.getOne("A001");
		System.out.println(JSON.toJSONString(menu,true));
		
	}

	@Test
	public void testAddMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditMenu() {
		fail("Not yet implemented");
	}

}
