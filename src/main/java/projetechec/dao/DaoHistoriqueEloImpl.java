package projetechec.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import projetechec.context.Context;
import projetechec.entity.HistoriqueElo;
import projetechec.entity.HistoriqueEloKey;

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
			em.remove(obj);
			tx.commit();
		} catch (Exception e) {
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
		Query query = em.createQuery("from HistoriqueElo h");
		historiquesElo = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return historiquesElo;
	}


}