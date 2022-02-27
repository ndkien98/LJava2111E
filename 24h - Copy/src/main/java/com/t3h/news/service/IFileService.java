package com.t3h.news.service;

import com.t3h.news.model.response.SystemResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    SystemResponse uploadAvatar(MultipartFile file, String folderName);

}
