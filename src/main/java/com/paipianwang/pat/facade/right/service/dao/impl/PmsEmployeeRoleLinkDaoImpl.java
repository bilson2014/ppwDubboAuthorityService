package com.paipianwang.pat.facade.right.service.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paipianwang.pat.common.core.dao.impl.BaseDaoImpl;
import com.paipianwang.pat.facade.right.entity.PmsEmployeeRoleLink;
import com.paipianwang.pat.facade.right.service.dao.PmsEmployeeRoleLinkDao;

@Repository("pmsEmployeeRoleLinkDao")
public class PmsEmployeeRoleLinkDaoImpl extends BaseDaoImpl<PmsEmployeeRoleLink> implements PmsEmployeeRoleLinkDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate = null;
	
	public static final String SQL_FIND_EMPLOYEEIDS_BY_ROLENAME = "findEmployeeIdsByRoleName";
	
	@Override
	public List<PmsEmployeeRoleLink> findEmployeeIdsByRoleName(Map<String, Object> param) {
		return sessionTemplate.selectList(getStatement(SQL_FIND_EMPLOYEEIDS_BY_ROLENAME), param);
	}


}
