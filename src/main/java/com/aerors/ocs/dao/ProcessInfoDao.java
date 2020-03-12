package com.aerors.ocs.dao;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Repository;

import com.aerors.ocs.entity.ProcessInfo;
@Repository("processInfoDao")
public class ProcessInfoDao extends BaseDaoImp<T>{

	@Override
	public Class<ProcessInfo> getEntityClass() {
		return ProcessInfo.class;
	}

}
