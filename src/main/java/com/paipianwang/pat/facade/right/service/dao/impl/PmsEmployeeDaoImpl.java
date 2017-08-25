package com.paipianwang.pat.facade.right.service.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paipianwang.pat.common.core.dao.impl.BaseDaoImpl;
import com.paipianwang.pat.facade.right.entity.PmsEmployee;
import com.paipianwang.pat.facade.right.service.dao.PmsEmployeeDao;

@Repository("pmsEmployeeDao")
public class PmsEmployeeDaoImpl extends BaseDaoImpl<PmsEmployee> implements PmsEmployeeDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate = null;

	public static final String SQL_DOLOGIN = "doLogin";
	public static final String SQL_CHECK_PHONENUMBER = "checkPhoneNumber";
	public static final String SQL_GETEMPLOYEE_WITH_VERSIONMANAGER = "getEmployeesWithVersionManager";
	public static final String SQL_EDIT_PASSWORD_BYID = "editPasswordById";
	public static final String SQL_SAVE_RELATIVITY = "saveRelativity";
	public static final String SQL_UPDATE_IMAGEPATH = "updateImagePath";
	public static final String SQL_FIND_EMPLOYER_BY_ID = "findEmployerById";
	public static final String SQL_DELETE_EMPLOYEE_ROLELINK = "deleteEmployeeRoleLink";
	public static final String SQL_FIND_EMPLOYEE_BY_NAME = "findEmployeeByRealName";
	public static final String SQL_FIND_EMPLOYEE_WITH_VERSIONMANAGER_ROLE_INFO = "findEmployeeWithVersionManagerRoleInfo";
	public static final String SQL_FIND_EMPLOYEE_LIST = "findEmployeeList";
	public static final String SQL_UPDATE_PWD_BY_ID = "updatePwdById";
	public static final String SQL_VERIFICATION_EMPLOYEE_EXIST = "verificationEmployeeExist";
	public static final String SQL_FIND_EMPLOYEES_BY_ROLEID = "findEmployeesByRoleId";
	public static final String SQL_FIND_EMPLOYEE_BY_IDS = "findEmployeeByIds";
	public static final String SQL_FIND_EMPLOYEES_BY_PHONENUMBER = "findEmployeesByPhoneNumber";
	public static final String SQL_UPDATE_UNIQUEID = "updateUniqueId";
	public static final String SQL_UPDATE_SELF="updateSelf";
	public static final String SQL_UPDATE_PHONE_BY_ID = "updatePhoneById";
	public static final String SQL_UPDATE_EMAIL_BY_ID = "updateEmailById";
	

	@Override
	public PmsEmployee doLogin(Map<String, Object> paramMap) {
		return sessionTemplate.selectOne(getStatement(SQL_DOLOGIN), paramMap);
	}

	@Override
	public long checkPhoneNumber(String phoneNumber) {
		final long ret = sessionTemplate.selectOne(getStatement(SQL_CHECK_PHONENUMBER), phoneNumber);
		return ret;
	}

	@Override
	public long saveRelativity(final PmsEmployee employee) {
		final long ret = sessionTemplate.insert(getStatement(SQL_SAVE_RELATIVITY), employee);
		return ret;
	}

	@Override
	public long updateImagePath(final PmsEmployee employee) {
		final long ret = sessionTemplate.insert(getStatement(SQL_UPDATE_IMAGEPATH), employee);
		return ret;
	}

	@Override
	public PmsEmployee findEmployerById(final long employeeId) {
		final PmsEmployee employee = sessionTemplate.selectOne(getStatement(SQL_FIND_EMPLOYER_BY_ID), employeeId);
		return employee;
	}

	@Override
	public long deleteEmployeeRoleLink(final long employeeId) {
		final long ret = sessionTemplate.delete(getStatement(SQL_DELETE_EMPLOYEE_ROLELINK), employeeId);
		return ret;
	}

	@Override
	public List<PmsEmployee> findEmployeeWithVersionManagerRoleInfo(Map<String, Object> param) {
		return sessionTemplate.selectList(getStatement(SQL_FIND_EMPLOYEE_WITH_VERSIONMANAGER_ROLE_INFO), param);
	}

	@Override
	public List<PmsEmployee> findEmployeeList() {
		return sessionTemplate.selectList(getStatement(SQL_FIND_EMPLOYEE_LIST));
	}

	@Override
	public long updatePwdById(PmsEmployee employee) {
		return sessionTemplate.update(getStatement(SQL_UPDATE_PWD_BY_ID), employee);
	}

	@Override
	public List<PmsEmployee> verificationEmployeeExist(PmsEmployee employee) {
		return sessionTemplate.selectList(getStatement(SQL_VERIFICATION_EMPLOYEE_EXIST), employee);
	}

	@Override
	public List<PmsEmployee> findEmployeesByRoleId(Long roleId) {
		return sessionTemplate.selectList(getStatement(SQL_FIND_EMPLOYEES_BY_ROLEID), roleId);
	}

	@Override
	public List<PmsEmployee> findEmployeeByIds(Map<String, Object> param) {
		return sessionTemplate.selectList(getStatement(SQL_FIND_EMPLOYEE_BY_IDS), param);
	}

	@Override
	public List<PmsEmployee> findEmployeesByPhoneNumber(Map<String, Object> param) {
		return sessionTemplate.selectList(getStatement(SQL_FIND_EMPLOYEES_BY_PHONENUMBER), param);
	}

	@Override
	public long updateUniqueId(PmsEmployee employee) {
		return sessionTemplate.update(getStatement(SQL_UPDATE_UNIQUEID), employee);
	}

	@Override
	public long updateSelf(PmsEmployee employee) {
		return sessionTemplate.update(getStatement(SQL_UPDATE_SELF), employee);
	}

	@Override
	public long updatePhoneById(PmsEmployee employee) {
		return sessionTemplate.update(getStatement(SQL_UPDATE_PHONE_BY_ID), employee);
	}

	@Override
	public long updateEmailById(PmsEmployee employee) {
		return sessionTemplate.update(getStatement(SQL_UPDATE_EMAIL_BY_ID), employee);
	}

}
