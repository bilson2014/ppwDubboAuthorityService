package com.paipianwang.pat.facade.right.service.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paipianwang.pat.common.core.dao.impl.BaseDaoImpl;
import com.paipianwang.pat.facade.right.entity.PmsRole;
import com.paipianwang.pat.facade.right.service.dao.PmsRoleDao;

/**
 * 角色访问实现类
 */
@Repository("pmsRoleDao")
public class PmsRoleDaoImpl extends BaseDaoImpl<PmsRole> implements PmsRoleDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate = null;

	public static final String SQL_GET_ROLES_BY_EMPLOYEEID = "findRolesByEmployId";
	public static final String SQL_DELETE_ROLE_RIGHT_LINK = "deleteRoleRightLink";
	public static final String SQL_DELETE_EMPLOYEE_ROLE_LINK = "deleteEmployeeRoleLink";
	public static final String SQL_GRANT_ROLE_RIGHT_LINK = "grantRoleRightLink";

	@Override
	public List<PmsRole> findRolesByEmployId(long employeeId) {
		return sessionTemplate.selectList(getStatement(SQL_GET_ROLES_BY_EMPLOYEEID), employeeId);
	}

	@Override
	public long deleteRoleRightLink(long roleId) {
		return sessionTemplate.delete(getStatement(SQL_DELETE_ROLE_RIGHT_LINK), roleId);
	}

	@Override
	public long deleteEmployeeRoleLink(long roleId) {
		return sessionTemplate.delete(getStatement(SQL_DELETE_EMPLOYEE_ROLE_LINK), roleId);
	}

	@Override
	public long grantRoleRightLink(Map<String, Object> param) {
		return sessionTemplate.insert(getStatement(SQL_GRANT_ROLE_RIGHT_LINK), param);
	}

}
