package com.paipianwang.pat.facade.right.service.dao;

import java.util.List;
import java.util.Map;

import com.paipianwang.pat.common.core.dao.BaseDao;
import com.paipianwang.pat.facade.right.entity.PmsEmployee;

public interface PmsEmployeeDao extends BaseDao<PmsEmployee> {

	public PmsEmployee doLogin(final Map<String, Object> paramMap);

	public long checkPhoneNumber(final String phoneNumber);

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
	 * 根据员工ID，解除内部员工与角色之间的关系
	 * 
	 * @param employeeId
	 *            员工ID
	 * @return
	 */
	public long deleteEmployeeRoleLink(final long employeeId);

	/**
	 * 查询角色是视频管家的员工信息
	 * 
	 * @param param
	 *            条件 employeeRealName 员工真实姓名
	 * @return
	 */
	public List<PmsEmployee> findEmployeeWithVersionManagerRoleInfo(Map<String, Object> param);

	/**
	 * 查询员工信息（除了超级管理员、测试帐号等特殊帐号外）
	 * 
	 * @return
	 */
	public List<PmsEmployee> findEmployeeList();

	/**
	 * 根据员工ID，修改密码
	 * 
	 * @param originalEmployee
	 * @return
	 */
	public long updatePwdById(PmsEmployee originalEmployee);

	/**
	 * 检测三方登录是否已经绑定
	 * 
	 * @param employee
	 *            员工信息
	 * @return
	 */
	public List<PmsEmployee> verificationEmployeeExist(PmsEmployee employee);

	/**
	 * 根据角色，查询员工列表
	 * 
	 * @param roleId
	 *            角色名称
	 * @return
	 */
	public List<PmsEmployee> findEmployeesByRoleId(Long roleId);

	/**
	 * 根据员工ID数组，查询员工列表
	 * 
	 * @param roleIds
	 *            员工ID数组
	 * @return
	 */
	public List<PmsEmployee> findEmployeeByIds(Map<String, Object> param);

	/**
	 * 根据员工手机号码查询员工列表
	 * @param param phoneNumber 手机号码
	 * @return 员工列表
	 */
	public List<PmsEmployee> findEmployeesByPhoneNumber(Map<String, Object> param);

	/**
	 * 根据员工ID，更新三方登录的唯一编码
	 * @param employee 员工信息
	 * @return 
	 */
	public long updateUniqueId(PmsEmployee employee);

	/**
	 * 员工个人信息修改
	 * @param employee
	 * @return
	 */
	public long updateSelf(PmsEmployee employee);

	public long updatePhoneById(PmsEmployee employee);

	public long updateEmailById(PmsEmployee employee);

}
