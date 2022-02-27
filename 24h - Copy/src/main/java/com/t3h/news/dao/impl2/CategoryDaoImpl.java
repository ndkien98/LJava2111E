//package com.t3h.news.dao.impl2;
//
//import com.t3h.news.dao.ICategoryDao;
//import com.t3h.news.model.entity.CategoryEntity;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import javax.transaction.Transactional;
//
//@Repository
//@Transactional
//public class CategoryDaoImpl implements ICategoryDao {
//
//    private final SessionFactory sessionFactory;
//
//    public CategoryDaoImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public CategoryEntity findById(int id) {
//
//        Session session = sessionFactory.getCurrentSession();
//        // cung cấp các toán tử, tạo ra câu query
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//
//        CriteriaQuery<CategoryEntity> query = criteriaBuilder.createQuery(CategoryEntity.class);
//        Root<CategoryEntity> root = query.from(CategoryEntity.class);
//
//        query.select(root).where(criteriaBuilder.equal(root.get("id"),1)); // select * from category where id =1
//
//        CategoryEntity category = session.createQuery(query).uniqueResult();
//        return category;
//    }
//}
