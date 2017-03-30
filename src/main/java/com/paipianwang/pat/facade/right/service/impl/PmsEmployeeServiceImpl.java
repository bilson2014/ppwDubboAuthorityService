package com.paipianwang.pat.facade.right.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.facade.right.entity.PmsEmployee;
import com.paipianwang.pat.facade.right.service.PmsEmployeeFacade;
import com.paipianwang.pat.facade.right.service.biz.PmsEmployeeBiz;

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
	public List<PmsEmployee> getEmployeesWithVersionManager(final String phoneNumber) {
		final List<PmsEmployee> list = pmsEmployeeBiz.getEmployeesWithVersionManager(phoneNumber);
		return list;
	}

	@Override
	public long editPasswordById(final PmsEmployee originalEmployee) {
		final long ret = pmsEmployeeBiz.editPasswordById(originalEmployee);
		return ret;
	}

	@Override
	public List<PmsEmployee> findEmployeeToSynergy() {
		final List<PmsEmployee> list = pmsEmployeeBiz.findEmployeeToSynergy();
		return list;
	}

	@Override
	public DataGrid<PmsEmployee> listWithPagination(Map<String, Object> paramMap, PageParam pageParam) {
		return pmsEmployeeBiz.listWithPagination(paramMap, pageParam);
	}

	@Override
	public long save(final PmsEmployee employee) {
		pmsEmployeeBiz.save(employee);
		long ret = employee.getEmployeeId();
		return ret;
	}

	@Override
	public long updateImagePath(PmsEmployee employee) {
		long ret = pmsEmployeeBiz.updateImagePath(employee);
		return ret;
	}

	@Override
	public PmsEmployee findEmployerById(final long employeeId) {
		final PmsEmployee employee = pmsEmployeeBiz.findEmployerById(employeeId);
		return employee;
	}

	@Override
	public void updateWidthRelation(final PmsEmployee employee) {
		pmsEmployeeBiz.updateWidthRelation(employee);
	}

}
