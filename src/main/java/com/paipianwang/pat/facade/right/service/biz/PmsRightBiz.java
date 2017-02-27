package com.paipianwang.pat.facade.right.service.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.paipianwang.pat.facade.right.service.dao.PmsRightDao;
@Service
@Transactional
public class PmsRightBiz {
	@Autowired
	private final PmsRightDao pmsRightDao = null;

	public long findMaxPos() {
		return pmsRightDao.findMaxPos();
	}
	
	
}
