package com.paipianwang.pat.facade.right.service.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paipianwang.pat.common.core.dao.impl.BaseDaoImpl;
import com.paipianwang.pat.facade.right.entity.PmsRight;
import com.paipianwang.pat.facade.right.service.dao.PmsRightDao;

/**
 * 权限访问实现类
 */
@Repository("pmsRightDao")
public class PmsRightDaoImpl extends BaseDaoImpl<PmsRight> implements PmsRightDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate = null;

	public static final String SQL_FIND_MAX_POS = "findMaxPos";
	public static final String SQL_FIND_MAX_CODE_BY_POS = "findMaxCodeByPos";
	public static final String SQL_FIND_RIGHTS_BY_ROLE = "findRightsByRole";

	@Override
	public Integer findMaxPos() {
		return sessionTemplate.selectOne(getStatement(SQL_FIND_MAX_POS));
	}

	@Override
	public Long findMaxCodeByPos(Integer maxPos) {
		return sessionTemplate.selectOne(getStatement(SQL_FIND_MAX_CODE_BY_POS), maxPos);
	}

	@Override
	public List<Long> findRightsByRole(long roleId) {
		return sessionTemplate.selectList(getStatement(SQL_FIND_RIGHTS_BY_ROLE), roleId);
	}

}
