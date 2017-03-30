package com.paipianwang.pat.facade.right.service.dao.impl;



import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paipianwang.pat.common.core.dao.impl.BaseDaoImpl;
import com.paipianwang.pat.facade.right.entity.PmsEmployee;
import com.paipianwang.pat.facade.right.service.dao.PmsEmployeeDao;
@Repository
public class PmsEmployeeDaoImpl extends BaseDaoImpl<PmsEmployee> implements PmsEmployeeDao {

	public static final String SQL_DOLOGIN= "doLogin";
	public static final String SQL_CHECK_PHONENUMBER= "checkPhoneNumber";
	public static final String SQL_GETEMPLOYEE_WITH_VERSIONMANAGER= "getEmployeesWithVersionManager";
	public static final String SQL_EDIT_PASSWORD_BYID= "editPasswordById";
	public static final String SQL_FIND_EMPLOYEE_TOSYNERGY= "findEmployeeToSynergy";
	public static final String SQL_SAVE_RELATIVITY= "saveRelativity";
	public static final String SQL_UPDATE_IMAGEPATH= "updateImagePath";
	public static final String SQL_FIND_EMPLOYER_BY_ID= "findEmployerById";
	public static final String SQL_DELETE_EMPLOYEE_ROLELINK= "deleteEmployeeRoleLink";
	public static final String SQL_FIND_EMPLOYEE_BY_NAME = "findEmployeeByRealName";
	
	@Autowired
	private SqlSessionTemplate sessionTemplate = null;

	@Override
	public PmsEmployee doLogin(Map<String, Object> paramMap) {
		return sessionTemplate.selectOne(getStatement(SQL_DOLOGIN),paramMap);
	}

	@Override
	public long checkPhoneNumber(String phoneNumber) {
		final long ret = sessionTemplate.selectOne(getStatement(SQL_CHECK_PHONENUMBER),phoneNumber);
		return ret;
	}

	@Override
	public List<PmsEmployee> getEmployeesWithVersionManager(final String phoneNumber) {
		final List<PmsEmployee> list = sessionTemplate.selectList(getStatement(SQL_GETEMPLOYEE_WITH_VERSIONMANAGER),phoneNumber);
		return list;
	}

	@Override
	public long editPasswordById(final PmsEmployee originalEmployee) {
		final long ret = sessionTemplate.update(getStatement(SQL_EDIT_PASSWORD_BYID),originalEmployee);
		return ret;
	}

	@Override
	public List<PmsEmployee> findEmployeeToSynergy() {
		final List<PmsEmployee> list = sessionTemplate.selectList(getStatement(SQL_FIND_EMPLOYEE_TOSYNERGY));
		return list;
	}

	@Override
	public long saveRelativity(final PmsEmployee employee) {
		final long ret = sessionTemplate.insert(getStatement(SQL_SAVE_RELATIVITY),employee);
		return ret;
	}

	@Override
	public long updateImagePath(final PmsEmployee employee) {
		final long ret = sessionTemplate.insert(getStatement(SQL_UPDATE_IMAGEPATH),employee);
		return ret;
	}

	@Override
	public PmsEmployee findEmployerById(final long employeeId) {
		final PmsEmployee employee = sessionTemplate.selectOne(getStatement(SQL_FIND_EMPLOYER_BY_ID),employeeId);
		return employee;
	}

	@Override
	public long deleteEmployeeRoleLink(final long employeeId) {
		final long ret = sessionTemplate.delete(getStatement(SQL_DELETE_EMPLOYEE_ROLELINK),employeeId);
		return ret;
	}

}
