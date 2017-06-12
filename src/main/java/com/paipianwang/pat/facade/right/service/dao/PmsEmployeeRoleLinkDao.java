package com.paipianwang.pat.facade.right.service.dao;

import java.util.List;
import java.util.Map;

import com.paipianwang.pat.common.core.dao.BaseDao;
import com.paipianwang.pat.facade.right.entity.PmsEmployeeRoleLink;

public interface PmsEmployeeRoleLinkDao extends BaseDao<PmsEmployeeRoleLink>{

	/**
	 * 根据角色名称获取员工ID集合
	 * @param roleNameList
	 * @return
	 */
	public List<PmsEmployeeRoleLink> findEmployeeIdsByRoleName(final Map<String, Object> param);
}
