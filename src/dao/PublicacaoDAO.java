package dao;

import entidades.Publicacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

public class PublicacaoDAO implements DAO<Publicacao> {
    EntityManager entityManager = getEntityManager();

    @Override
    public Publicacao findById(int id) {
        return entityManager.find(Publicacao.class, id);
    }

    @Override
    public List<Publicacao> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Publicacao.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public void insert(Publicacao t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(t);
        transaction.commit();
    }

    @Override
    public void update(Publicacao t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(t);
        transaction.commit();
    }

    @Override
    public void delete(Publicacao t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Publicacao a = entityManager.find(Publicacao.class, t.getCodigoPub());
        entityManager.remove(a);
        transaction.commit();
    }
    
}
