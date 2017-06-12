package com.paipianwang.pat.facade.right.service.biz;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.facade.right.entity.PmsRole;
import com.paipianwang.pat.facade.right.service.dao.PmsRoleDao;

@Service
public class PmsRoleBiz {
	
	@Autowired
	private final PmsRoleDao pmsRoleDao = null;
	
	// 必须存在的角色ID数组
	private static Long[] REQUIRE_ROLE_ID_ARRAY = {1l,2l,3l,4l,8l,9l,19l};
	
	public List<PmsRole> findRolesByEmployId(long employeeId) {
		return pmsRoleDao.findRolesByEmployId(employeeId);
	}

	public PmsRole findRoleById(final long roleId) {
		return pmsRoleDao.getById(roleId);
	}

	public List<PmsRole> findAllRoles() {
		final List<PmsRole> list = pmsRoleDao.listBy(null);
		return list;
	}

	public DataGrid<PmsRole> listWithPagination(PageParam pageParam, Map<String, Object> paramMap) {
		final DataGrid<PmsRole> dataGrid = pmsRoleDao.listWithPagination(pageParam, paramMap);
		return dataGrid;
	}

	@Transactional
	public long save(PmsRole role) {
		return pmsRoleDao.insert(role);
	}

	@Transactional
	public long deleteByIds(long[] ids) {
		try {
			for (long roleId : ids) {
				// 判断角色是否能被删除
				if(!Arrays.asList(REQUIRE_ROLE_ID_ARRAY).contains(Long.parseLong(roleId + ""))) {
					pmsRoleDao.deleteRoleRightLink(roleId);
					pmsRoleDao.deleteEmployeeRoleLink(roleId);
					pmsRoleDao.deleteById(roleId);
				}
			}
			return 1l;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Transactional
	public long update(PmsRole role) {
		final long ret = pmsRoleDao.update(role);
		return ret;
	}

	/**
	 * 角色授权操作
	 * 该操作会先删除角色与权限之前的关系，然后再建立新的关系
	 * @param param 集合包含 roleId,rightIds
	 * @return 
	 */
	@Transactional
	public long grant(Map<String, Object> param) {
		pmsRoleDao.deleteRoleRightLink(Long.valueOf(param.get("roleId").toString()));
		final long ret = pmsRoleDao.grantRoleRightLink(param);
		return ret;
	}

}
