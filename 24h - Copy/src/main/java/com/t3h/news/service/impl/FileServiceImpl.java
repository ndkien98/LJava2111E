package com.t3h.news.service.impl;

import com.t3h.news.model.response.SystemResponse;
import com.t3h.news.service.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileServiceImpl implements IFileService {

    @Override
    public SystemResponse uploadAvatar(MultipartFile file, String folderName) {

        String fileName = file.getOriginalFilename();
        File folder = new File("C:\\Users\\Admin\\Desktop\\out\\ljava2111e\\24h - Copy\\src\\main\\resources\\static\\admin\\img\\" + folderName);
        File newFile = null;
        try {
            if (!folder.exists()){
                folder.mkdir();
            }

            newFile = new File(folder.getAbsolutePath() + File.separator + fileName);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
            stream.write(file.getBytes());
            stream.close();

        } catch (IOException e) {

        }

        return new SystemResponse().setData(newFile.getAbsolutePath()).setStatus(200).setError("successfully");
    }
}
