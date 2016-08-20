package blogmgr.test.action;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huangtl.blogmgr.action.MenuAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class MenuActionTest {
	@Resource
	private MenuAction menuAction;
	
	@Test
	public void testGetPaging() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTreeNode() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOne() {
		fail("Not yet implemented");
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
