package com.paipianwang.pat.facade.right.service.redis.dao;
import java.util.Map;

import com.paipianwang.pat.facade.right.entity.PmsRight;


public interface RedisRightDao {

	public PmsRight getRightFromRedis(final String uri);
	
	public Map<String,PmsRight> getRightsFromRedis();
	
	public void addRightByRedis(final PmsRight right);
	
	public void resetRightFromRedis(final Map<String,PmsRight> map);
}

