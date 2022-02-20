package com.t3h.news.dao.implJdbc;

import com.t3h.news.dao.INewsDao;
import com.t3h.news.mapper.NewMapper;
import com.t3h.news.model.NewsModel;

import java.util.List;

public class NewsDaoImpl extends GenericDaoImpl<NewsModel> implements INewsDao {

    public NewsModel add(NewsModel newsModel){

        String sql = "insert into news (id," +
                "title," +
                "author," +
                "originalResource," +
                "content," +
                "numberAccess," +
                "createDate," +
                "updateDate," +
                "editorId," +
                "creatorId) value (?,?,?,?,?,?,?,?,?,?)";

       this.insert(sql,newsModel.getId(),
                        newsModel.getTitle(),
                        newsModel.getAuthor(),
                        newsModel.getOriginalResource(),
                        newsModel.getContent(),
                        newsModel.getNumberAccess(),
                        newsModel.getCreateDate(),
               newsModel.getUpdateDate(),
               newsModel.getEditorId(),
               newsModel.getCreatorId());
        return newsModel;
    }


    @Override
    public List<NewsModel> getList() {
        String sql = "select * from news";
        return findByProperties(sql,new NewMapper());
    }

    @Override
    public NewsModel findById(Integer id) {

        String sql = "select * from news where id =?";

        List<NewsModel> newsModels = findByProperties(sql,new NewMapper(),id);
        if (newsModels.size() > 0){
            return newsModels.get(0);
        }
        return null;
    }
}
