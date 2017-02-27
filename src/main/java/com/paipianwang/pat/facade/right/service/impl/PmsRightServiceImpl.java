package com.paipianwang.pat.facade.right.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.paipianwang.pat.facade.right.service.PmsRightFacade;
import com.paipianwang.pat.facade.right.service.biz.PmsRightBiz;
/**
 * 权限服务接口实现
 */
@Service("pmsRightFacade")
public class PmsRightServiceImpl implements PmsRightFacade {

	@Autowired
	private final PmsRightBiz biz = null;

	@Override
	public long getMaxPos() {
		return biz.findMaxPos();
	}


}
