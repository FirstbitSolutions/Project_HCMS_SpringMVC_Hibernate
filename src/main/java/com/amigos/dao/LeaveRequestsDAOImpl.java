package com.amigos.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.amigos.dto.LeaveRequests;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeaveRequestsDAOImpl implements LeaveRequestsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<LeaveRequests> getAll() {
		Transaction tx = null;
		List<LeaveRequests> obj = new ArrayList<>();
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			obj = session.createQuery("FROM LeaveRequests", LeaveRequests.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
			obj = null;
		}
		return obj;
	}

	@Override
	public LeaveRequests getLeaveRequestsById(Long id) {
		Transaction tx = null;
		LeaveRequests obj = null;
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			obj = session.get(LeaveRequests.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Long save(LeaveRequests obj) {
		Transaction tx = null;
		Serializable serializable = null;
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			serializable = session.save(obj);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			serializable = null;
			e.printStackTrace();
		}
		return ((Integer) serializable).longValue();
	}

	@Override
	public void update(LeaveRequests obj) {
		Transaction tx = null;

		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			session.merge(obj);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Long id) {
		Transaction tx = null;

		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			LeaveRequests obj = session.get(LeaveRequests.class, id);
			if (obj != null) {
				session.remove(obj);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}
