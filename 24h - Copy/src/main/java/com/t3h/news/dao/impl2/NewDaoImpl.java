package com.t3h.news.dao.impl2;

import com.t3h.news.dao.INewsDao;
import com.t3h.news.model.entity.NewsEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class NewDaoImpl implements INewsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<NewsEntity> getList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT N from NewsEntity N", NewsEntity.class);
        List<NewsEntity> entities =  query.getResultList();

        return entities;
    }

    @Override
    public NewsEntity findById(int id) {

        Session session = sessionFactory.getCurrentSession();

        // create cau query
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NewsEntity> criteriaQuery = builder.createQuery(NewsEntity.class);
        Root<NewsEntity> root = criteriaQuery.from(NewsEntity.class);
        criteriaQuery.select(root).where(builder.equal(root.get("id"),id));

        return session.createQuery(criteriaQuery).uniqueResult();
    }

    @Override
    public NewsEntity add(NewsEntity newsEntity) {

        Session session = sessionFactory.getCurrentSession();
        session.save(newsEntity);
        return newsEntity;
    }
}
