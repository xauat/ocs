package com.aerors.ocs.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@SuppressWarnings("deprecation")
public abstract class BaseDaoImp<T> implements BaseDao<T> {
	private Class<T> clazz;

	Logger logger = LogManager.getLogger(BaseDaoImp.class);
	@SuppressWarnings("rawtypes")
	public abstract Class getEntityClass();

	@SuppressWarnings("unchecked")
	protected BaseDaoImp() {
		super();
		this.clazz = getEntityClass();
	}

	@Resource
	private SessionFactory sessionFactory;

	public boolean entity_save(Object obj) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			//ex.printStackTrace();
			logger.error("dateBase  save is error,plase check you operation!,reason:"+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			if (session != null) {
				session.close();
			}
			return false;
		}
	}

	public boolean entity_update(Object obj) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(obj);
			tx.commit();
			session.close();
			return true;
		} catch (Exception ex) {
//			ex.printStackTrace();
			logger.error("dateBase update is error,plase check you operation!,reason:"+ex.getMessage());
			if (tx != null) {
				tx.rollback();
				if (session != null) {
					session.close();
				}
			}
			return false;
		}
	}

	public boolean entity_saveOrUpdate(Object obj) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			//ex.printStackTrace();
			logger.error("dateBase saveOrUpdate is error,plase check you operation!,reason:"+ex.getMessage());
			if (tx != null) {
				tx.rollback();
				if (session != null) {
					session.close();
				}
			}
			return false;
		}
	}

	public boolean entity_delete(Object obj) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(obj);
			tx.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			//ex.printStackTrace();
			logger.error("dateBase delete is error,plase check you operation!,reason:"+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			if (session != null) {
				session.close();
			}
			return false;
		}
	}

	public T entity_findById(Serializable id) {
		Session session = null;
		Transaction tx = null;
		T obj = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			obj = (T) session.get(clazz, id);
			tx.commit();
		} catch (Exception ex) {
			//ex.printStackTrace();
			logger.error("dateBase findById is error,plase check you operation!,reason:"+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<T> entity_findByHQL(String hql) {
		List<T> list = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
		} catch (Exception ex) {
			//ex.printStackTrace();
			logger.error("dateBase findByHQL is error,plase check you operation!,reason:"+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> entity_queryPage(String hql, int page, int rows) {
		List<T> list = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			list = query.setFirstResult((page - 1) * rows).setMaxResults(rows)
					.list();

			tx.commit();
		} catch (Exception ex) {
			//ex.printStackTrace();
			logger.error("dateBase queryPag is error,plase check you operation!,reason:"+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public long table_count(String hql) {
		Session session = null;
		long count = 0;
		try{
			session = sessionFactory.openSession();
			count = (long) session.createQuery(hql).uniqueResult();
		}catch(Exception ex){
			logger.error("hql count is error,plase check you hql!,reason:"+ex.getMessage());	
			count = -1; //查询语句异常
		}finally{
			session.close();
		}
		return count;
	}
	
	@SuppressWarnings("rawtypes")
	public List executeSql(String sql) {
		Session session = null;
		List list = null;
		try{
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery(sql);
			list = query.list();
		}catch (Exception ex){
			logger.error("sql execute is error,plase check you sql!,reason:"+ex.getMessage());	
		}finally{
			session.close();
		}
		
		return list;
	}
	
	public void updataBySql(String sql){
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery(sql);
			tx = session.beginTransaction();
			query.executeUpdate();
		}catch (Exception ex){
			logger.error("sql execute is error,plase check you sql!,reason:"+ex.getMessage());	
		}finally{
			tx.commit();
			session.close();
		}
	}
	
	public boolean executeDelete(String sql){
		Session session = null;
		Transaction tx = null;
		boolean flag = false;
		try{
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery(sql);
			tx = session.beginTransaction();
			query.executeUpdate();
			flag = true;
		}catch (Exception ex){
			flag = false;
			logger.error("sql execute is error,plase check you sql!,reason:"+ex.getMessage());	
		}finally{
			tx.commit();
			session.close();
		}
		return flag;
	}
	
	public Object saveObjectGetID(Object obj){
		Session session = null;
		Transaction tx = null;
		Object obj1 = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(obj);
			obj1 = obj;
			tx.commit();
			session.close();
			return obj1;
		} catch (Exception ex) {
			//ex.printStackTrace();
			logger.error("dateBase  save is error,plase check you operation!,reason:"+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			if (session != null) {
				session.close();
			}
			return obj1;
		}
	}
}
