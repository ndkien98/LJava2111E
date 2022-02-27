package com.t3h.news.dao.implJpa;

import com.t3h.news.dao.ICategoryDao;
import com.t3h.news.model.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements ICategoryDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public CategoryEntity findById(int id) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CategoryEntity> criteriaQuery = criteriaBuilder.createQuery(CategoryEntity.class);
        Root<CategoryEntity> root = criteriaQuery.from(CategoryEntity.class);

        Predicate[] predicates ={
            criteriaBuilder.equal(root.get("id"),id)
        };
        criteriaQuery.select(root).where(predicates);

        Query query = entityManager.createQuery(criteriaQuery);
        return (CategoryEntity) query.getSingleResult();
    }

    @Override
    public List<CategoryEntity> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(CategoryEntity.class));
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public CategoryEntity add(CategoryEntity category) {
        entityManager.persist(category);
        return category;
    }
}
