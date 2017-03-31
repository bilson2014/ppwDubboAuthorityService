package com.paipianwang.pat.facade.right.service.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.common.util.ValidateUtil;
import com.paipianwang.pat.facade.right.entity.PmsRight;
import com.paipianwang.pat.facade.right.service.dao.PmsRightDao;
import com.paipianwang.pat.facade.right.service.redis.dao.RedisRightDao;

@Service
@Transactional
public class PmsRightBiz {

	/**
	 * Mysql right dao
	 */
	@Autowired
	private final PmsRightDao pmsRightDao = null;

	/**
	 * Redis right dao
	 */
	@Autowired
	private final RedisRightDao redisRightDao = null;

	public long findMaxPos() {
		return pmsRightDao.findMaxPos();
	}

	public List<PmsRight> findAllRights() {
		return pmsRightDao.listBy(null);
	}

	public DataGrid<PmsRight> listWithPagination(PageParam param, Map<String, Object> paramMap) {
		return pmsRightDao.listWithPagination(param, paramMap);
	}

	public PmsRight findRightById(final long rightId) {
		return pmsRightDao.getById(rightId);
	}

	public long save(final PmsRight right) {
		int pos = 0;
		long code = 0;
		final Integer maxPos = pmsRightDao.findMaxPos();

		if (maxPos == null) {
			pos = 0;
			code = 1;
		} else {
			Long maxCode = pmsRightDao.findMaxCodeByPos(maxPos);
			if (maxCode >= (1L << 60)) {
				pos = maxPos + 1;
				code = 1;
			} else {
				pos = maxPos;
				code = maxCode << 1;
			}
		}
		right.setPos(pos);
		right.setCode(code);
		final long ret = pmsRightDao.insert(right);

		// 更新上下文资源
		redisRightDao.addRightByRedis(right);

		return ret;
	}

	public long update(PmsRight right) {
		final long ret = pmsRightDao.update(right);
		return ret;
	}

	public long deleteByIds(long[] ids) {
		if (ValidateUtil.isValid(ids)) {
			final long ret = pmsRightDao.deleteByIds(ids);
			return ret;
		}
		return 0;
	}

	public List<PmsRight> findRightByPid(Set<Long> pList) {
		if (ValidateUtil.isValid(pList)) {
			final Map<String, Object> param = new HashMap<String, Object>();
			param.put("pList", pList);
			return pmsRightDao.listBy(param);
		}
		return null;
	}

	public List<PmsRight> getRightsByMenu() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("resourceType", 0);
		return pmsRightDao.listBy(param);
	}

	public List<Long> findRightsByRole(long roleId) {
		return pmsRightDao.findRightsByRole(roleId);
	}

}
