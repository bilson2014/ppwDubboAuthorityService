package com.paipianwang.pat.facade.right.service.dao;



import java.util.List;
import java.util.Map;

import com.paipianwang.pat.common.core.dao.BaseDao;
import com.paipianwang.pat.facade.right.entity.PmsEmployee;

public interface PmsEmployeeDao extends BaseDao<PmsEmployee>{

	public PmsEmployee doLogin(final Map<String, Object> paramMap);

	public long checkPhoneNumber(final String phoneNumber);

	public List<PmsEmployee> getEmployeesWithVersionManager(final String phoneNumber);

	public long editPasswordById(final PmsEmployee originalEmployee);
	/**
	 * 获取项目协同人 目前业务规则:协同人身份为视频管家和视频管家指导
	 * 
	 * @return employeeList
	 */
	public List<PmsEmployee> findEmployeeToSynergy();
	/**
	 * 仅保存员工与角色之间的关系
	 * 
	 * @param link
	 *            员工角色关系实体
	 */
	public long saveRelativity(final PmsEmployee employee);
	/**
	 * 更新照片路径
	 * 
	 * @param path
	 * @return
	 */
	public long updateImagePath(final PmsEmployee employee);

	public PmsEmployee findEmployerById(final long employeeId);

	/**
	 * 根据员工ID，删除内部员工与角色之间的关系
	 * @param employeeId 员工ID
	 * @return
	 */
	public long  deleteEmployeeRoleLink(final long employeeId);
}
