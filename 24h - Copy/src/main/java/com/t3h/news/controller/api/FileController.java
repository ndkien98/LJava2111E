package com.t3h.news.controller.api;


import com.t3h.news.model.response.SystemResponse;
import com.t3h.news.service.IFileService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/admin/file")
public class FileController {

    private final IFileService iFileService;

    public FileController(IFileService iFileService) {
        this.iFileService = iFileService;
    }


    @PostMapping(value = "/img", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<SystemResponse> uploadAvatar(@RequestParam MultipartFile file, @RequestParam String folderName){
        return ResponseEntity.ok(iFileService.uploadAvatar(file,folderName));
    }
}
