package com.paipianwang.pat.facade.right.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.common.entity.SessionInfo;
import com.paipianwang.pat.common.util.ListSort;
import com.paipianwang.pat.common.util.ValidateUtil;
import com.paipianwang.pat.facade.right.entity.PmsRight;
import com.paipianwang.pat.facade.right.entity.PmsTree;
import com.paipianwang.pat.facade.right.service.PmsRightFacade;
import com.paipianwang.pat.facade.right.service.biz.PmsRightBiz;
import com.paipianwang.pat.facade.right.service.redis.dao.RedisRightDao;

/**
 * 权限服务接口实现
 */
@Service("pmsRightFacade")
public class PmsRightServiceImpl implements PmsRightFacade {

	@Autowired
	private final PmsRightBiz biz = null;

	@Autowired
	private final RedisRightDao redisRightDao = null;

	@Override
	public long getMaxPos() {
		return biz.findMaxPos();
	}

	@Override
	public PmsRight getRightFromRedis(final String uri) {
		return redisRightDao.getRightFromRedis(uri);
	}

	@Override
	public List<PmsRight> findAllRights() {
		final List<PmsRight> list = biz.findAllRights();
		return list;
	}

	@Override
	public DataGrid<PmsRight> listWithPagination(PageParam param, Map<String, Object> paramMap) {
		final DataGrid<PmsRight> dataGrid = biz.listWithPagination(param, paramMap);
		return dataGrid;
	}

	@Override
	public PmsRight findRightById(long rightId) {
		final PmsRight right = biz.findRightById(rightId);
		return right;
	}

	@Override
	public long save(PmsRight right) {
		final long ret = biz.save(right);
		return ret;
	}

	@Override
	public long update(PmsRight right) {
		final long ret = biz.update(right);
		return ret;
	}

	@Override
	public long deleteByIds(long[] ids) {
		final long ret = biz.deleteByIds(ids);
		return ret;
	}

	@Override
	public List<PmsTree> resourceTree() {
		final List<PmsRight> rights = biz.findAllRights();
		final List<PmsTree> trees = new ArrayList<PmsTree>();

		for (final PmsRight right : rights) {
			final PmsTree tree = new PmsTree();
			tree.setId(right.getRightId() + "");
			tree.setPid(right.getpId() + "");
			tree.setText(right.getRightName());
			Map<String, Object> attr = new HashMap<String, Object>();
			attr.put("url", right.getUrl());
			tree.setAttributes(attr);
			tree.setIconCls(right.getIcon());
			trees.add(tree);
		}
		return trees;
	}

	@Override
	public Map<String, PmsRight> getRightsMergeMap() {
		List<PmsRight> list = biz.findAllRights();
		Map<String, PmsRight> map = new HashMap<String, PmsRight>();
		for (PmsRight pmsRight : list) {
			final String url = pmsRight.getUrl();
			if (ValidateUtil.isValid(url)) {
				map.put(url, pmsRight);
			}
		}
		return map;
	}

	@Override
	public List<PmsTree> menu(final SessionInfo info) {
		final List<PmsTree> treeList = new ArrayList<PmsTree>();

		if (info != null) {
			if (!info.isSuperAdmin()) {

				final Set<Long> pSet = new HashSet<Long>();

				// 从redis 中获取map
				Map<String, PmsRight> map = redisRightDao.getRightsFromRedis();

				// 遍历权限集合
				for (Map.Entry<String, PmsRight> entity : map.entrySet()) {
					final PmsRight right = entity.getValue();
					if (right != null) {
						if (right.getResourceType() == 0) { // 菜单
							if (right.getIsCommon()) {
								// 公共资源加入
								final Long pId = right.getpId();
								PmsTree tree = new PmsTree();
								tree.setIconCls(right.getIcon());
								tree.setId(right.getRightId() + "");
								tree.setPid(pId.toString());
								tree.setText(right.getRightName());
								tree.setOd(right.getSeq() + "");

								Map<String, String> attr = new HashMap<String, String>();
								attr.put("url", right.getUrl());
								tree.setAttributes(attr);

								treeList.add(tree);
								if (pId != null) {
									pSet.add(pId);
								}
							} else {
								// 非公共资源
								if (info.hasRight(right)) {
									// 有权限则加入
									final Long pId = right.getpId();
									PmsTree tree = new PmsTree();
									tree.setIconCls(right.getIcon());
									tree.setId(right.getRightId() + "");
									tree.setPid(pId.toString());
									tree.setText(right.getRightName());
									tree.setOd(right.getSeq() + "");

									Map<String, String> attr = new HashMap<String, String>();
									attr.put("url", right.getUrl());
									tree.setAttributes(attr);

									treeList.add(tree);
									if (pId != null) {
										pSet.add(pId);
									}
								}
							}
						}
					}
				}

				// 查询没有url的根节点
				if (ValidateUtil.isValid(pSet)) {
					// 获取根节点
					final List<PmsRight> list = biz.findRightByPid(pSet);
					if (ValidateUtil.isValid(list)) {
						for (final PmsRight right : list) {
							final PmsTree tree = new PmsTree();
							tree.setIconCls(right.getIcon());
							tree.setId(right.getRightId() + "");
							tree.setPid(right.getpId() == null ? null : right.getpId().toString());
							tree.setText(right.getRightName());
							tree.setOd(right.getSeq() + "");

							Map<String, String> attr = new HashMap<String, String>();
							attr.put("url", right.getUrl());
							tree.setAttributes(attr);

							treeList.add(tree);
						}

					}
				}

			} else {
				final List<PmsRight> rights = biz.getRightsByMenu();
				for (final PmsRight right : rights) {
					final PmsTree tree = new PmsTree();
					tree.setIconCls(right.getIcon());
					tree.setId(right.getRightId() + "");
					tree.setPid(right.getpId() == null ? null : right.getpId().toString());
					tree.setText(right.getRightName());
					tree.setOd(right.getSeq() + "");

					Map<String, String> attr = new HashMap<String, String>();
					attr.put("url", right.getUrl());
					tree.setAttributes(attr);

					treeList.add(tree);
				}
			}
		}
		ListSort<PmsTree> listSort = new ListSort<PmsTree>();
		listSort.Sort(treeList, "getOd", "asc");
		return treeList;
	}

	@Override
	public List<Long> findRightsByRole(long roleId) {
		final List<Long> list = biz.findRightsByRole(roleId);
		return list;
	}

	@Override
	public void resetRightOnRedis(Map<String, PmsRight> map) {
		redisRightDao.resetRightFromRedis(map);
	}

}
