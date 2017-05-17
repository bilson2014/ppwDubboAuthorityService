/*package com.paipianwang.service.right.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paipianwang.pat.facade.right.entity.PmsEmployeeProductLink;
import com.paipianwang.pat.facade.right.service.biz.PmsEmployeeProductLinkBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class EmployeeLinkTest {

	@Autowired
	private PmsEmployeeProductLinkBiz biz = null;
	
	@Test
	public void testDelete() {
		final List<PmsEmployeeProductLink> list = new ArrayList<PmsEmployeeProductLink>();
		PmsEmployeeProductLink link1 = new PmsEmployeeProductLink();
		link1.setEmployeeId(1);
		link1.setProductId(1);
		list.add(link1);
		
		PmsEmployeeProductLink link2 = new PmsEmployeeProductLink();
		link2.setEmployeeId(1);
		link2.setProductId(2);
		list.add(link2);
		
		PmsEmployeeProductLink link3 = new PmsEmployeeProductLink();
		link3.setEmployeeId(3);
		link3.setProductId(1);
		list.add(link3);
		
		boolean result = biz.deleteByEmployeeIdsAndproIds(list);
		System.err.println(result);
	}
	
	@Test
	public void testList() {
		
		List<Long> list = biz.findProductIdsByEmployeeId(1);
		System.err.println(list);
	}
	
	@Test
	public void testSave() {
		PmsEmployeeProductLink link = new PmsEmployeeProductLink();
		link.setEmployeeId(3);
		link.setProductId(3);
		boolean ret = biz.save(link);
		System.err.println(ret);
	}
}
*/