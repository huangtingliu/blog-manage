package blogmgr.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huangtl.blogmgr.dao.RoleDao;
import com.huangtl.blogmgr.dao.where.RoleSqlWhere;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class RoleDaoTest {

	@Resource
	private RoleDao  roleDao;
	@Test
	public void testSelectOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testFakeDeleteBatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectListUserSqlWhere() {
		List<Role> roles;
		UserSqlWhere userSqlWhere = new UserSqlWhere();
		roles = this.roleDao.selectList(userSqlWhere);
		System.out.println(roles);
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
	public void testSelectListSqlWhereStringArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectPaging() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectCount() {
		fail("Not yet implemented");
	}

}
