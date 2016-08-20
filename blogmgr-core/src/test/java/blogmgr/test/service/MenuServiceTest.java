package blogmgr.test.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.model.blog.dictionary.CommonDictionary.Usability;
import com.huangtl.blogmgr.model.blog.dictionary.MenuType;
import com.huangtl.blogmgr.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class MenuServiceTest {

	@Resource
	private MenuService menuService;
	
	@Test
	public void testGetDao() {
		 boolean flag = this.menuService.getDao()!=null;
		 assertTrue(flag);
	}

	@Test
	public void testAddMenu() {
		Menu menu = new Menu();
		menu.setfId("T001");
		menu.setfName("测试");
		menu.setfType(MenuType.NAVIGATOR);
		menu.setfUsability(Usability.ENABLE);
		
		
		
	}

}
