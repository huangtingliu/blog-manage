package blogmgr.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huangtl.blogmgr.dao.where.MenuSqlWhere;
import com.huangtl.blogmgr.model.extjs.TreeNode;
import com.huangtl.blogmgr.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class MenuServiceTest {
	@Resource
	private MenuService menuService;
	
	@Test
	public void selectTreeNodeTest(){
		MenuSqlWhere sqlWhere = new MenuSqlWhere().fParentIdEqual("");
		List<TreeNode> nodes = menuService.getDao().selectTreeNodes(sqlWhere);
		System.out.println(nodes);
		//System.out.println(menuService);
	}
}
