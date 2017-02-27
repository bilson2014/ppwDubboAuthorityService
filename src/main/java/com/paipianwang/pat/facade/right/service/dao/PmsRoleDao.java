package com.paipianwang.pat.facade.right.service.dao;


import java.util.List;

import com.paipianwang.pat.common.core.dao.BaseDao;
import com.paipianwang.pat.facade.right.entity.PmsRight;
import com.paipianwang.pat.facade.right.entity.PmsRole;

/**
 * 角色访问接口层
 */
public interface PmsRoleDao extends BaseDao<PmsRole>{

	/**
	 * 查询员工的角色信息，不含权限
	 * @param employeeId
	 */
	public List<PmsRole> getRolesByEmployId(final long employeeId);

	public PmsRole findRoleById(final long roleId);


}
