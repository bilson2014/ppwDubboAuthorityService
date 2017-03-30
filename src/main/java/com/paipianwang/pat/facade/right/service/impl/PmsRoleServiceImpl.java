package com.paipianwang.pat.facade.right.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.common.util.ValidateUtil;
import com.paipianwang.pat.facade.right.entity.PmsRole;
import com.paipianwang.pat.facade.right.service.PmsRoleFacade;
import com.paipianwang.pat.facade.right.service.biz.PmsRoleBiz;
/**
 * 权限服务接口实现
 */
@Service("pmsRoleFacade")
public class PmsRoleServiceImpl implements PmsRoleFacade {

	@Autowired
	private final PmsRoleBiz biz = null;

	@Override
	public List<PmsRole> findRolesByEmployId(final long employeeId) {
		List<PmsRole> list = biz.findRolesByEmployId(employeeId);
		return list;
	}

	@Override
	public PmsRole findRoleById(final long roleId) {
		PmsRole PmsRole = biz.findRoleById(roleId);
		return PmsRole;
	}

	@Override
	public List<PmsRole> findAllRoles() {
		final List<PmsRole> list = biz.findAllRoles();
		return list;
	}

	@Override
	public DataGrid<PmsRole> listWithPagination(PageParam pageParam, Map<String, Object> param) {
		final DataGrid<PmsRole> dataGrid = biz.listWithPagination(pageParam, param);
		return dataGrid;
	}

	@Override
	public long save(PmsRole role) {
		final long ret = biz.save(role);
		return ret;
	}

	@Override
	public long update(PmsRole role) {
		final long ret = biz.update(role);
		return ret;
	}

	@Override
	public long deleteByIds(long[] ids) {
		if(ValidateUtil.isValid(ids)) {
			final long ret = biz.deleteByIds(ids);
			return ret;
		}
		return 0;
	}

	@Override
	public long grant(Long roleId, long[] rightIds) {
		if(roleId != null && ValidateUtil.isValid(rightIds)){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("roleId", roleId);
			param.put("rightIds", rightIds);
			final long ret = biz.grant(param);
			return ret;
		}
		return 0l;
	}

}
