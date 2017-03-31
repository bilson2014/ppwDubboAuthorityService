package com.paipianwang.pat.facade.right.service.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.common.util.ValidateUtil;
import com.paipianwang.pat.facade.right.entity.PmsEmployee;
import com.paipianwang.pat.facade.right.service.dao.PmsEmployeeDao;

@Service
public class PmsEmployeeBiz {

	@Autowired
	private PmsEmployeeDao pmsEmployeeDao = null;

	public PmsEmployee doLogin(String loginName, String password) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("loginName", loginName);
		paramMap.put("password", password);
		return pmsEmployeeDao.doLogin(paramMap);
	}

	public long checkPhoneNumber(final String phoneNumber) {
		final long ret = pmsEmployeeDao.checkPhoneNumber(phoneNumber);
		return ret;
	}

	public DataGrid<PmsEmployee> listWithPagination(Map<String, Object> paramMap, PageParam pageParam) {
		return pmsEmployeeDao.listWithPagination(pageParam, paramMap);
	}

	@Transactional
	public long save(final PmsEmployee employee) {
		long ret = pmsEmployeeDao.insert(employee);
		pmsEmployeeDao.saveRelativity(employee);
		return ret;
	}

	@Transactional
	public long updateImagePath(final PmsEmployee employee) {
		long ret = pmsEmployeeDao.updateImagePath(employee);
		return ret;
	}

	public PmsEmployee findEmployeeById(final long employeeId) {
		final PmsEmployee employee = pmsEmployeeDao.getById(employeeId);
		return employee;
	}

	@Transactional
	public void updateWidthRelation(final PmsEmployee employee) {
		final long id = employee.getEmployeeId();
		pmsEmployeeDao.deleteEmployeeRoleLink(id);
		pmsEmployeeDao.update(employee);

		final List<Long> roleIds = employee.getRoleIds();
		if (ValidateUtil.isValid(roleIds)) {
			// 排除没有权限的弊端
			if (roleIds.size() == 1 && roleIds.get(0) == 0) {

			} else {
				pmsEmployeeDao.saveRelativity(employee);
			}
		}
	}

	@Transactional
	public long update(PmsEmployee pmsEmployee) {
		return pmsEmployeeDao.update(pmsEmployee);
	}

	/**
	 * 删除员工信息，同时需要删除员工与角色之间的关系
	 * 
	 * @param ids
	 *            员工信息
	 * @return
	 */
	@Transactional
	public long delete(long[] employeeIds) {

		try {
			for (final long employeeId : employeeIds) {
				pmsEmployeeDao.deleteEmployeeRoleLink(employeeId);
				pmsEmployeeDao.deleteById(employeeId);
			}
			return 1l;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public List<PmsEmployee> findEmployeeWithRoleInfo(Map<String, Object> param) {
		return pmsEmployeeDao.findEmployeeWithVersionManagerRoleInfo(param);
	}

	/**
	 * 查询员工信息（除了超级管理员、测试帐号等特殊帐号外）
	 * 
	 * @return
	 */
	public List<PmsEmployee> findEmployeeList() {
		return pmsEmployeeDao.findEmployeeList();
	}

	@Transactional
	public long updatePwdById(PmsEmployee originalEmployee) {
		return pmsEmployeeDao.updatePwdById(originalEmployee);
	}

	/**
	 * 检测三方登录是否已经绑定
	 * 
	 * @param employee
	 *            员工信息
	 * @return
	 */
	public List<PmsEmployee> verificationEmployeeExist(PmsEmployee employee) {
		return pmsEmployeeDao.verificationEmployeeExist(employee);
	}

	/**
	 * 根据角色，查询员工列表
	 * 
	 * @param roleId
	 *            角色名称
	 * @return
	 */
	public List<PmsEmployee> findEmployeesByRoleId(Long roleId) {
		return pmsEmployeeDao.findEmployeesByRoleId(roleId);
	}

	/**
	 * 根据员工ID数组，查询员工列表
	 * 
	 * @param roleIds
	 *            员工ID数组
	 * @return
	 */
	public List<PmsEmployee> findEmployeeByIds(Long[] employeeIds) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("employeeIds", employeeIds);
		return pmsEmployeeDao.findEmployeeByIds(param);
	}

	public List<PmsEmployee> findEmployeesByPhoneNumber(Map<String, Object> param) {
		return pmsEmployeeDao.findEmployeesByPhoneNumber(param);
	}

	public long updateUniqueId(PmsEmployee employee) {
		return pmsEmployeeDao.updateUniqueId(employee);
	};

}
