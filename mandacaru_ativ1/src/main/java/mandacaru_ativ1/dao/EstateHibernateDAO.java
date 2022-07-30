package mandacaru_ativ1.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mandacaru_ativ1.entities.Estate;

public class EstateHibernateDAO implements EstateDAO{
	static EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("mandacaru");
	static EntityManager entityManager;

	@Override
	public void save(Estate entity) {
		entityManager = sessionFactory.createEntityManager();
		entityManager.getTransaction().begin();

		if (entity.getId() == 0) {
			entityManager.persist(entity);
		} else {
			entityManager.merge(entity);
		}

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void delete(int id) {
		entityManager = sessionFactory.createEntityManager();
		Estate Estate = entityManager.find(Estate.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(Estate);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public Estate find(int id) {
		entityManager = sessionFactory.createEntityManager();
		Estate Estate = entityManager.find(Estate.class, id);
		entityManager.close();

		return Estate;
	}

	@Override
	public List<Estate> findAll() {
		entityManager = sessionFactory.createEntityManager();
		List<Estate> estates = entityManager.createQuery("from estates", Estate.class).getResultList();
		entityManager.close();

		return estates;
	}

	@Override
	public Estate findByName(String str) {
		entityManager = sessionFactory.createEntityManager();
		Estate Estate = null;

		try {
			Estate = entityManager.createQuery("from estates where name=?1", Estate.class).setParameter(1, str)
					.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();

		return Estate;
	}

	@Override
	public List<Estate> findAllByName(String str) {
		entityManager = sessionFactory.createEntityManager();
		List<Estate> estates = null;

		try {
			estates = entityManager.createQuery("from estates where name=?1", Estate.class).setParameter(1, str)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
		entityManager.close();

		return estates;
	}
}
