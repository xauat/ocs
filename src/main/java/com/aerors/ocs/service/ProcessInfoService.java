package com.aerors.ocs.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.aerors.ocs.dao.ProcessInfoDao;
import com.aerors.ocs.entity.ProcessInfo;

@Service(value ="processInfoService")
public class ProcessInfoService {
	@Resource private ProcessInfoDao processInfoDao;
	
	
	public void save(ProcessInfo processInfo) {
		processInfoDao.entity_save(processInfo);
	}
	
	public long count(String sql) {
		return processInfoDao.table_count(sql);
	}
	
	public List<T> queryByHql(String hql){
		return processInfoDao.entity_findByHQL(hql);
	}
	
	public void delete(ProcessInfo processInfo) {
		processInfoDao.entity_delete(processInfo);
	}
	
	public void update(ProcessInfo processInfo) {
		processInfoDao.entity_update(processInfo);
	}
}
