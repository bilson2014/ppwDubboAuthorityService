/*package com.paipianwang.service.right.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.common.util.ValidateUtil;
import com.paipianwang.pat.facade.right.entity.PmsEmployee;
import com.paipianwang.pat.facade.right.entity.PmsRole;
import com.paipianwang.pat.facade.right.service.biz.PmsEmployeeBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class EmployeeTest {

	@Autowired
	private final PmsEmployeeBiz biz = null;
	
	@Test
	public void testInsert() {
		final PmsEmployee employee = new PmsEmployee();
		employee.setDimissionStatus(0);
		employee.setEmail("cheyan@126.com");
		employee.setEmployeeDescription("测试用");
		employee.setEmployeeImg("http://resource.apaipian.com/resources/1.image");
		employee.setEmployeeLoginName("cheyang");
		employee.setEmployeePassword("E10ADC3949BA59ABBE56E057F20F883E");
		employee.setEmployeeRealName("车燕");
		employee.setPhoneNumber("18600008765");
		final List<Long> roleIds = new ArrayList<Long>();
		roleIds.add(4l);
		roleIds.add(6l);
		roleIds.add(7l);
		employee.setRoleIds(roleIds);
		biz.save(employee);
		System.err.println(employee.getEmployeeId());
	}
	
	@Test
	public void testSelect() {
		final PmsEmployee employee = biz.findEmployeeById(63);
		System.err.println(employee.getEmployeeId());
	}
	
	@Test
	public void testCheckPhone() {
		final long sum = biz.checkPhoneNumber("18600008765");
		System.err.println(sum);
	}
	
	@Test
	public void testLogin() {
		PmsEmployee employee = biz.doLogin("cheyang", "E10ADC3949BA59ABBE56E057F20F883E");
		System.err.println(employee.getEmployeeId());
		List<PmsRole> roles = employee.getRoles();
		for (PmsRole role : roles) {
			System.err.println(role.getRoleName());
		}
	}
	
	@Test
	public void testListWithPagination() {
		PageParam pageParam = new PageParam();
		final long page = 1;
		final long rows = 20;
		pageParam.setBegin((page - 1) * rows);
		pageParam.setLimit(rows);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("employeeRealName", "wang");
		DataGrid<PmsEmployee> dataGrid = biz.listWithPagination(param, pageParam);
		System.err.println(dataGrid.getTotal());
		List<PmsEmployee> list = dataGrid.getRows();
		for (final PmsEmployee e : list) {
			System.err.println(e.getEmployeeRealName());
		}
	}
	
	@Test
	public void testUpdateImagePath() {
		PmsEmployee employee = new PmsEmployee();
		employee.setEmployeeId(63);
		employee.setEmployeeImg("group1/M00/00/19/Cgqp51i2XxuAZvtDAAJLSltCttU362.jpg");
		biz.updateImagePath(employee);
	}
	
	@Test
	public void testUpdateWidthRelation() {
		PmsEmployee employee = new PmsEmployee();
		employee.setEmployeeId(63);
		employee.setDimissionStatus(0);
		final List<Long> list = new ArrayList<Long>();
		list.add(10l);
		list.add(11l);
		list.add(12l);
		employee.setRoleIds(list);
		biz.updateWidthRelation(employee);
	}
	
	@Test
	public void testUpdate() {
		final PmsEmployee employee = new PmsEmployee();
		employee.setEmployeeId(63);
		employee.setDimissionStatus(0);
		employee.setEmail("cheyan@126.com");
		employee.setEmployeeDescription("测试用");
		employee.setEmployeeImg("http://resource.apaipian.com/resources/1.image");
		employee.setEmployeeLoginName("cheyang");
		employee.setEmployeePassword("E10ADC3949BA59ABBE56E057F20F883E");
		employee.setEmployeeRealName("车燕");
		employee.setPhoneNumber("18600008765");
		System.err.println(biz.update(employee));
	}
	
	@Test
	public void testUpdatePwd() {
		final PmsEmployee employee = new PmsEmployee();
		employee.setEmployeeId(63);
		employee.setEmployeePassword("123456");
		System.err.println(biz.updatePwdById(employee));
	}
	
	@Test
	public void testFindEmployeeWithRoleInfo() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("employeeRealName", "车");
		List<PmsEmployee> list = biz.findEmployeeWithRoleInfo(param);
		for (final PmsEmployee employee : list) {
			System.err.println(employee.getEmployeeRealName());
			List<PmsRole> roles = employee.getRoles();
			if(ValidateUtil.isValid(roles)) {
				for (PmsRole role : roles) {
					System.err.println(role.getRoleName());
				}
			}
		}
	}
	
	@Test
	public void findEmployeeList() {
		List<PmsEmployee> list = biz.findEmployeeList();
		System.err.println(list.size());
	}
	
	@Test
	public void testFindByRole() {
		List<PmsEmployee> list = biz.findEmployeesByRoleId(4l);
		if(ValidateUtil.isValid(list)) {
			for (final PmsEmployee employee : list) {
				System.err.println(employee.getEmployeeRealName());
				List<PmsRole> roles = employee.getRoles();
				if(ValidateUtil.isValid(roles)) {
					for (PmsRole role : roles) {
						System.err.println(role.getRoleName());
					}
				}
			}
		}
	}
	
	@Test
	public void testFindByIds() {
		final Long[] employeeIds = {62l,63l,64l};
		List<PmsEmployee> list = biz.findEmployeeByIds(employeeIds);
		for (final PmsEmployee employee : list) {
			System.err.println(employee.getEmployeeRealName());
			List<PmsRole> roles = employee.getRoles();
			if(ValidateUtil.isValid(roles)) {
				for (PmsRole role : roles) {
					System.err.println(role.getRoleName());
				}
			}
		}
	}
	
	@Test
	public void testDelete() {
		final long[] employeeIds = {63,64};
		System.err.println(biz.delete(employeeIds));
	}
}
*/