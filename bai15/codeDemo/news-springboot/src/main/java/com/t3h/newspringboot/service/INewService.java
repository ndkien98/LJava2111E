package com.t3h.newspringboot.service;

import com.t3h.newspringboot.model.request.NewsRequest;
import com.t3h.newspringboot.model.response.NewResponse;

import java.util.List;

public interface INewService {

    List<NewResponse> getAll();

    void insert(NewsRequest newsRequest);

    List<NewResponse> findByAuthor(String author);

    List<NewResponse> findByNumberAccess(Integer numberAccess);

}
