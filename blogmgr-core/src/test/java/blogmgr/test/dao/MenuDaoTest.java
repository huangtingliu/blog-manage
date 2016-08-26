package blogmgr.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.huangtl.blogmgr.dao.MenuDao;
import com.huangtl.blogmgr.dao.where.MenuSqlWhere;
import com.huangtl.blogmgr.model.blog.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class MenuDaoTest {
	
	@Resource
	private MenuDao menuDao;

	@Test
	public void testSelectTreeNodes() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectList() {
		MenuSqlWhere where = new MenuSqlWhere()
					.fParentIdEqual("A001");
		List<Menu> menus = this.menuDao.selectList(where,"fDescr");
		print(menus);
	}

	@Test
	public void testSelectCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectPaging() {
		fail("Not yet implemented");
	}
	
	
	private void print(Object obj){
		System.out.println(JSON.toJSONString(obj,true));
	}

}
