/*package com.paipianwang.service.right.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.facade.right.entity.PmsRight;
import com.paipianwang.pat.facade.right.service.biz.PmsRightBiz;
import com.paipianwang.pat.facade.right.service.dao.PmsRightDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class RightTest {

	@Autowired
	private final PmsRightBiz biz = null;
	
	@Autowired
	private final PmsRightDao dao = null;
	
	@Test
	public void testSave() {
		final PmsRight right = new PmsRight();
		right.setIcon("123");
		right.setIconCls("123");
		right.setpId(1L);
		right.setSeq(10);
		right.setStatus(0);
		right.setResourceType(0);
		right.setIsCommon(true);
		right.setRightName("权限测试");
		right.setUrl("/portal/right/save");
		biz.save(right);
	}
	
	@Test
	public void testSelect() {
		PageParam param = new PageParam();
		param.setBegin(0);
		param.setLimit(100);
		DataGrid<PmsRight> grid = biz.listWithPagination(param, null);
		System.err.println(grid.getTotal());
		for (PmsRight right : grid.getRows()) {
			System.err.println(right.getRightName());
		}
	}
	
	@Test
	public void testAll() {
		final List<PmsRight> list = biz.all();
		for (PmsRight right : list) {
			System.err.println(right.getRightName());
		}
	}
	
	@Test
	public void testGetBy() {
		final PmsRight right = biz.findRightById(433);
		System.err.println(right.getRightName());
	}
	
	@Test
	public void testUpdate() {
		final PmsRight right = biz.findRightById(433);
		right.setRightName("测试修改信息");
		final long ret = biz.update(right);
		System.err.println(ret);
	}
	
	@Test
	public void testDelete() {
		final long[] ids = {433,434,435};
		biz.deleteByIds(ids);
	}
	
	@Test
	public void testListByPid() {
		Set<Long> pList = new HashSet<Long>();
		pList.add(416L);
		pList.add(358L);
		final List<PmsRight> list = biz.findRightByPid(pList);
		for (PmsRight pmsRight : list) {
			System.err.println("权限ID: " + pmsRight.getRightId());
		}
	}
	
	@Test
	public void testGetRightsByMenu() {
		Map<String, Object> param = new HashMap<String, Object>();
		Long[] array = {1L,2L,4L};
		param.put("pList", array);
		param.put("resourceType", 1);
		final List<PmsRight> list = dao.listBy(param);
		System.err.println("菜单总数为: " + list.size());
	}
	
	@Test
	public void testRightsByRoleId() {
		final List<Long> list = dao.findRightsByRole(3);
		System.err.println(list);
	}
	
}
*/