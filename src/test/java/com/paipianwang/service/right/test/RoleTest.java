/*package com.paipianwang.service.right.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paipianwang.pat.facade.right.entity.PmsRole;
import com.paipianwang.pat.facade.right.service.biz.PmsRoleBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class RoleTest {

	@Autowired
	private final PmsRoleBiz biz = null;
	
	@Test
	public void testSave() {
		PmsRole role = new PmsRole();
		role.setRoleName("测试角色");
		role.setRoleDescription("就是测试角色使用");
		final long ret = biz.save(role);
		System.err.println("插入条目： " + ret);
	}
	
	@Test
	public void testUpdate() {
		PmsRole role = new PmsRole();
		role.setRoleId(19);
		role.setRoleName("角色测试");
		role.setRoleDescription("角色测试description");
		final long ret = biz.update(role);
		System.err.println("改变的条目数： " + ret);
	}
	
	@Test
	public void testFindRoleById() {
		final PmsRole role = biz.findRoleById(17);
		System.err.println(role.getRoleName());
	}
	
	@Test
	public void testFindAllRoles() {
		final List<PmsRole> list = biz.findAllRoles();
		for (final PmsRole pmsRole : list) {
			System.err.println(pmsRole.getRoleName());
		}
	}
	
	@Test
	public void testFindRoleByEmployee() {
		List<PmsRole> list = biz.findRolesByEmployId(36l);
		for (final PmsRole pmsRole : list) {
			System.err.println(pmsRole.getRoleName());
		}
	}
	
	@Test
	public void testGrant() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", 19);
		long[] rightIds = {14,15,18,19};
		param.put("rightIds", rightIds);
		final long ret = biz.grant(param);
		System.err.println(ret);
	}
	
	@Test
	public void testDelete() {
		long[] rightIds = {19};
		final long ret = biz.deleteByIds(rightIds);
		System.err.println(ret);
	}
}
*/