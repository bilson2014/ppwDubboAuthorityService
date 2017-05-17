package com.paipianwang.pat.facade.right.service.dao;


import java.util.List;

import com.paipianwang.pat.common.core.dao.BaseDao;
import com.paipianwang.pat.facade.right.entity.PmsRight;

/**
 * 权限访问接口层
 */
public interface PmsRightDao extends BaseDao<PmsRight>{

	/**
	 * 查询最大权限位
	 * @return 最大权限位
	 */
	public Integer findMaxPos();

	/**
	 * 查询最大权限位上的最大权限码
	 * @param maxPos 最大权限位
	 * @return 最大权限位上的最大权限码
	 */
	public Long findMaxCodeByPos(Integer maxPos);

	/**
	 * 根据角色ID，查询权限ID数组
	 * @param roleId 角色ID
	 * @return
	 */
	public List<Long> findRightsByRole(long roleId);

	/**
	 * 根据权限ID删除权限角色关系表数据
	 * @param rightId
	 */
	public long deleteRightRoleLink(long rightId);

}
