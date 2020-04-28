package projetechec.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import projetechec.entity.HistoriqueElo;
import projetechec.entity.HistoriqueEloKey;
import projetechec.context.Context;

public class DaoHistoriqueEloImpl implements DaoHistoriqueElo {

	@Override
	public void insert(HistoriqueElo obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
	}

	@Override
	public HistoriqueElo update(HistoriqueElo obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			obj = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
		return obj;
	}

	@Override
	public void delete(HistoriqueElo obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
	}

	@Override
	public void deleteByKey(HistoriqueEloKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(HistoriqueElo.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
	}

	@Override
	public Optional<HistoriqueElo> findByKey(HistoriqueEloKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Optional<HistoriqueElo> optional = Optional.ofNullable(em.find(HistoriqueElo.class, key));
		if (em != null && em.isOpen()) {
			em.close();
		}
		return optional;
	}

	@Override
	public List<HistoriqueElo> findAll() {
		List<HistoriqueElo> historiquesElo = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Competence c");
		historiquesElo = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return historiquesElo;
	}

	@Override
	public List<HistoriqueElo> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByKey(Integer key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<HistoriqueElo> findByKey(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

}
