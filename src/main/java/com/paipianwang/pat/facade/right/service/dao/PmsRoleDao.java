package com.paipianwang.pat.facade.right.service.dao;


import java.util.List;
import java.util.Map;

import com.paipianwang.pat.common.core.dao.BaseDao;
import com.paipianwang.pat.facade.right.entity.PmsRole;

/**
 * 角色访问接口层
 */
public interface PmsRoleDao extends BaseDao<PmsRole>{

	/**
	 * 查询员工的角色信息，不含权限
	 * @param employeeId
	 */
	public List<PmsRole> findRolesByEmployId(final long employeeId);


	/**
	 * 根据角色ID，删除角色与权限之间的关系
	 * @param roleId 角色ID
	 * @return 
	 */
	public long deleteRoleRightLink(long roleId);

	/**
	 * 根据角色ID，删除内部员工与角色之间的关系
	 * @param roleId 角色ID
	 * @return
	 */
	public long deleteEmployeeRoleLink(long roleId);

	/**
	 * 建立角色与权限之间的关系
	 * @param roleId 角色ID
	 * @param resourceIds 权限集合
	 * @return
	 */
	public long grantRoleRightLink(Map<String, Object> param);
	
}
