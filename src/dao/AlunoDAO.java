package dao;

import entidades.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

public class AlunoDAO implements DAO<Aluno> {
    EntityManager entityManager = getEntityManager();

    @Override
    public Aluno findById(int id) {
        return entityManager.find(Aluno.class, id);
    }

    @Override
    public List<Aluno> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Aluno.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public void insert(Aluno t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(t);
        transaction.commit();
    }

    @Override
    public void update(Aluno t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(t);
        transaction.commit();
    }

    @Override
    public void delete(Aluno t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Aluno a = entityManager.find(Aluno.class, t.getMatriculaAluno());
        entityManager.remove(a);
        transaction.commit();
    }
    
}
