package blogmgr.test.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huangtl.blogmgr.model.blog.Privilege;
import com.huangtl.blogmgr.service.PrivilegeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class PrivilegeServerTest {

	@Resource
	private PrivilegeService privilegeService;
	
	@Test
	public void testAddPrivilege() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePrivilege() {
		fail("Not yet implemented");
	}

	@Test
	public void testEidtPrivilege() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryPrivilegesByRoleId() {
		List<Privilege> privileges = this.privilegeService.queryPrivilegesByRoleId("6a2875bf1b61413986f1488c50c1627a");
		System.out.println(privileges.size());
		
	}

	@Test
	public void testGetDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditBatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrivilegeDao() {
		fail("Not yet implemented");
	}

}
