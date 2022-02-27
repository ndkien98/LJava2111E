package com.t3h.news.dao.implHibernate;

import com.t3h.news.dao.INewsDao;
import com.t3h.news.model.NewsModel;
import com.t3h.news.model.entity.NewsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class NewsDaoImpl implements INewsDao {



    /**
     * ORM
     * @return
     */
    @Override
    public List<NewsModel> getList() {
        return null;
    }

    @Override
    public NewsModel add(NewsModel newsModel) {

        return null;
    }

    @Override
    public NewsModel findById(Integer id) {
        return null;
    }
}
