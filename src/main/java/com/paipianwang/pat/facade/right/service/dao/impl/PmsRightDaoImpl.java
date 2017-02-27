package com.paipianwang.pat.facade.right.service.dao.impl;


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

	@Override
	public long findMaxPos() {
		return sessionTemplate.selectOne(getStatement(SQL_FIND_MAX_POS));
	}
	

	
}
