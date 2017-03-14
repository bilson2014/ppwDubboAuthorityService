package com.paipianwang.pat.facade.right.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<PmsRole> getRolesByEmployId(final long employeeId) {
		List<PmsRole> list = biz.getRolesByEmployId(employeeId);
		return list;
	}

	@Override
	public PmsRole findRoleById(final long roleId) {
		PmsRole PmsRole = biz.findRoleById(roleId);
		return PmsRole;
	}


}
