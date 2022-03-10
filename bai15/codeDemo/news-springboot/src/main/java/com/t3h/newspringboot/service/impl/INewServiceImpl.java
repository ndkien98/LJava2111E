package com.t3h.newspringboot.service.impl;

import com.t3h.newspringboot.model.entity.NewsEntity;
import com.t3h.newspringboot.model.request.NewsRequest;
import com.t3h.newspringboot.model.response.NewResponse;
import com.t3h.newspringboot.repository.NewsRepository;
import com.t3h.newspringboot.service.INewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class INewServiceImpl implements INewService {

    private final NewsRepository repository;

    /**
     * Spring tu khoi tao bean cho NewsRepository
     * trong bean container
     * @param repository
     */
    public INewServiceImpl(NewsRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * Tai lieu: do BA viet
     * - mo ta project
     * + casc chuc nang
     * + database
     * + kien truc cua project
     * + chon ra 1 chuc nang:
     *
     * @return
     */

    @Override
    public List<NewResponse> getAll() {
        // lay danh sach news trong database
        List<NewsEntity> entities = repository.findAll();

        // convert tu entities -> reponse
        List<NewResponse> responses = new ArrayList<>();

        for (NewsEntity entity:entities) {
            responses.add(convertEntityToResponse(entity));
        }
        return responses;
    }

    @Override
    public List<NewResponse> findByAuthor(String author) {
        // lay danh sach news trong database where bang author
        List<NewsEntity> entities = repository.findByAuthor(author);

        // convert entity sang response dung stream trong java
        return entities.stream().map(this::convertEntityToResponse).collect(Collectors.toList());
    }

    @Override
    public void insert(NewsRequest newsRequest) {
        repository.save(convertRequestToEntity(newsRequest));
    }

    @Override
    public List<NewResponse> findByNumberAccess(Integer numberAccess) {
        return null;
    }

    private NewsEntity convertRequestToEntity(NewsRequest request){
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setAuthor(request.getAuthor());
        newsEntity.setContent(request.getContent());
        newsEntity.setAvatar(request.getAvatar());
        newsEntity.setCategoryId(request.getCategoryId());
        newsEntity.setCensor(request.getCensor());
        newsEntity.setNumberAccess(request.getNumberAccess());
        return newsEntity;
    }

    private NewResponse convertEntityToResponse(NewsEntity entity){
        NewResponse newResponse =new NewResponse();
        newResponse.setAuthor(entity.getAuthor());
        newResponse.setAvatar(entity.getAvatar());
        newResponse.setContent(entity.getContent());
        newResponse.setId(entity.getId());
        return newResponse;
    }
}
