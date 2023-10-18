package dao;

import entidades.Emprestimo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

public class EmprestimoDAO implements DAO<Emprestimo> {
    EntityManager entityManager = getEntityManager();

    @Override
    public Emprestimo findById(int id) {
        return entityManager.find(Emprestimo.class, id);
    }

    @Override
    public List<Emprestimo> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Emprestimo.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public void insert(Emprestimo t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(t);
        transaction.commit();
    }

    @Override
    public void update(Emprestimo t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(t);
        transaction.commit();
    }

    @Override
    public void delete(Emprestimo t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Emprestimo e = entityManager.find(Emprestimo.class, t.getId());
        entityManager.remove(e);
        transaction.commit();
    }
    
}
