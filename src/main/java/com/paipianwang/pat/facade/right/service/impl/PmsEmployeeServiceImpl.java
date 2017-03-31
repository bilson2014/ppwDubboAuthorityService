package com.paipianwang.pat.facade.right.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.common.util.ValidateUtil;
import com.paipianwang.pat.facade.right.entity.PmsEmployee;
import com.paipianwang.pat.facade.right.entity.PmsRole;
import com.paipianwang.pat.facade.right.service.PmsEmployeeFacade;
import com.paipianwang.pat.facade.right.service.biz.PmsEmployeeBiz;

/**
 * 员工服务接口实现
 * @author Jack
 *
 */
@Service("pmsEmployeeFacade")
public class PmsEmployeeServiceImpl implements PmsEmployeeFacade {

	@Autowired
	private PmsEmployeeBiz pmsEmployeeBiz;

	@Override
	public PmsEmployee doLogin(final String loginName, final String password) {
		return pmsEmployeeBiz.doLogin(loginName, password);
	}

	@Override
	public long checkPhoneNumber(String phoneNumber) {
		long result = pmsEmployeeBiz.checkPhoneNumber(phoneNumber);
		return result;
	}

	@Override
	public List<PmsEmployee> findEmployeeToSynergy() {
		final List<PmsEmployee> list = pmsEmployeeBiz.findEmployeeWithRoleInfo(null);
		// 返回的员工实体只需要包含名称以及ID
		final List<PmsEmployee> resultList = new ArrayList<PmsEmployee>();
		if (ValidateUtil.isValid(list)) {
			for (final PmsEmployee pmsEmployee : list) {
				final PmsEmployee employee = new PmsEmployee();
				employee.setEmployeeId(pmsEmployee.getEmployeeId());
				employee.setEmployeeRealName(pmsEmployee.getEmployeeRealName());
				resultList.add(employee);
			}
		}
		return resultList;
	}

	@Override
	public DataGrid<PmsEmployee> listWithPagination(Map<String, Object> paramMap, PageParam pageParam) {
		final DataGrid<PmsEmployee> dataGrid = pmsEmployeeBiz.listWithPagination(paramMap, pageParam);
		final List<PmsEmployee> lists = dataGrid.getRows();
		for (final PmsEmployee employee : lists) {
			final List<PmsRole> roles = employee.getRoles();
			final List<Long> roleIds = new ArrayList<Long>();
			for (final PmsRole role : roles) {
				final long roleId = role.getRoleId();
				roleIds.add(roleId);
			}
			employee.setRoleIds(roleIds);
		}
		return dataGrid;
	}

	@Override
	public long save(final PmsEmployee employee) {
		final long ret = pmsEmployeeBiz.save(employee);
		return ret;
	}

	@Override
	public PmsEmployee findEmployeeById(final long employeeId) {
		final PmsEmployee employee = pmsEmployeeBiz.findEmployeeById(employeeId);
		return employee;
	}

	@Override
	public void updateWidthRelation(final PmsEmployee employee) {
		pmsEmployeeBiz.updateWidthRelation(employee);
	}

	@Override
	public long update(PmsEmployee pmsEmployee) {
		final long ret = pmsEmployeeBiz.update(pmsEmployee);
		return ret;
	}

	@Override
	public long delete(long[] ids) {
		if (ValidateUtil.isValid(ids)) {

			return pmsEmployeeBiz.delete(ids);
		}
		return 0;
	}

	@Override
	public List<PmsEmployee> findEmployeeByRealNameWithinVersionManager(String employeeRealName) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("employeeRealName", employeeRealName);
		final List<PmsEmployee> list = pmsEmployeeBiz.findEmployeeWithRoleInfo(param);
		return list;
	}

	@Override
	public List<PmsEmployee> findEmployeeList() {
		final List<PmsEmployee> list = pmsEmployeeBiz.findEmployeeList();
		return list;
	}

	@Override
	public long updatePwdById(PmsEmployee originalEmployee) {
		final long ret = pmsEmployeeBiz.updatePwdById(originalEmployee);
		return ret;
	}

	@Override
	public long updateImagePath(PmsEmployee employee) {
		return pmsEmployeeBiz.updateImagePath(employee);
	}

	@Override
	public List<PmsEmployee> getEmployeesWithinVersionManager(String phoneNumber) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("phoneNumber", phoneNumber);
		final List<PmsEmployee> list = pmsEmployeeBiz.findEmployeeWithRoleInfo(param);
		// 返回的员工实体只需要包含名称以及ID
		final List<PmsEmployee> resultList = new ArrayList<PmsEmployee>();
		if (ValidateUtil.isValid(list)) {
			for (final PmsEmployee pmsEmployee : list) {
				final PmsEmployee employee = new PmsEmployee();
				employee.setEmployeeId(pmsEmployee.getEmployeeId());
				employee.setEmployeeRealName(pmsEmployee.getEmployeeRealName());
				resultList.add(employee);
			}
		}
		return resultList;
	}

	@Override
	public List<PmsEmployee> verificationEmployeeExist(PmsEmployee employee) {
		final List<PmsEmployee> list = pmsEmployeeBiz.verificationEmployeeExist(employee);
		return list;
	}

	@Override
	public List<PmsEmployee> findEmployeesByRoleId(Long roleId) {
		final List<PmsEmployee> list = pmsEmployeeBiz.findEmployeesByRoleId(roleId);
		return list;
	}

	@Override
	public List<PmsEmployee> findEmployeeByIds(Long[] employeeIds) {
		List<PmsEmployee> list = pmsEmployeeBiz.findEmployeeByIds(employeeIds);
		return list;
	}

	@Override
	public List<PmsEmployee> findEmployeesByPhoneNumber(String phoneNumber) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("phoneNumber", phoneNumber);
		final List<PmsEmployee> list = pmsEmployeeBiz.findEmployeesByPhoneNumber(param);
		return list;
	}

	@Override
	public long updateUniqueId(PmsEmployee employee) {
		return pmsEmployeeBiz.updateUniqueId(employee);
	}

}
