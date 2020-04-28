package projetechec.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import projetechec.context.Context;
import projetechec.entity.ContenuPedagogique;
import projetechec.entity.Livre;
import projetechec.entity.Video;

public class DaoContenuPedagogiqueImpl implements DaoContenuPedagogique {

	@Override
	public void insert(ContenuPedagogique obj) {
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
	public ContenuPedagogique update(ContenuPedagogique obj) {
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
	public void delete(ContenuPedagogique obj) {
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
	public void deleteByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(ContenuPedagogique.class, key));
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
	public Optional<ContenuPedagogique> findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Optional<ContenuPedagogique> optional = Optional.ofNullable(em.find(ContenuPedagogique.class, key));
		if (em != null && em.isOpen()) {
			em.close();
		}
		return optional;
	}

	@Override
	public List<ContenuPedagogique> findAll() {
		List<ContenuPedagogique> contenuPedagogiques = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from ContenuPedagogique c");
		contenuPedagogiques = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return contenuPedagogiques;
	}

	@Override
	public List<Livre> findAllLivres() {
		List<Livre> livres = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Livre l");
		livres = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return livres;
	}

	@Override
	public List<Video> findAllVideos() {
		List<Video> videos = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Video v");
		videos = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return videos;
	}

}
