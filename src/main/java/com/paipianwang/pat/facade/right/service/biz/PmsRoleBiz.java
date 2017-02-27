package com.paipianwang.pat.facade.right.service.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paipianwang.pat.facade.right.entity.PmsRole;
import com.paipianwang.pat.facade.right.service.dao.PmsRoleDao;
@Service
@Transactional
public class PmsRoleBiz {
	@Autowired
	private final PmsRoleDao pmsRoleDao = null;

	public List<PmsRole> getRolesByEmployId(long employeeId) {
		return pmsRoleDao.getRolesByEmployId(employeeId);
	}

	public PmsRole findRoleById(final long roleId) {
		return pmsRoleDao.findRoleById(roleId);
	}

	
	
}
