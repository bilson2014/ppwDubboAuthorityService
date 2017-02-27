package com.paipianwang.pat.facade.right.service.dao.impl;


import java.util.List;

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
	
	public static final String SQL_GET_ROLES_BY_EMPLOYEEID = "getRolesByEmployId";
	public static final String SQL_FIND_ROLE_BY_ID = "findRoleById";
	@Override
	public List<PmsRole> getRolesByEmployId(long employeeId) {
		return sessionTemplate.selectList(getStatement(SQL_GET_ROLES_BY_EMPLOYEEID),employeeId);
	}

	@Override
	public PmsRole findRoleById(long roleId) {
		return sessionTemplate.selectOne(getStatement(SQL_FIND_ROLE_BY_ID),roleId);
	}

	
}
