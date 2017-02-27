package com.paipianwang.pat.facade.right.service.dao;


import com.paipianwang.pat.common.core.dao.BaseDao;
import com.paipianwang.pat.facade.right.entity.PmsRight;

/**
 * 权限访问接口层
 */
public interface PmsRightDao extends BaseDao<PmsRight>{

	public long findMaxPos();


}
