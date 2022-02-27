package com.t3h.news.controller.api;

import com.t3h.news.model.UserModel;
import com.t3h.news.model.entity.UserEntity;
import com.t3h.news.model.response.SystemResponse;
import com.t3h.news.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/user")
public class UserApiController {

    private final IUserService iUserService;

    public UserApiController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping()
    public ResponseEntity<SystemResponse<List<UserModel>>> getAll(){
        return ResponseEntity.ok(iUserService.getAll());
    }

    @PostMapping()
    public ResponseEntity<SystemResponse<UserModel>> add(@RequestBody UserModel userModel){
        return ResponseEntity.ok(iUserService.add(userModel));
    }


}
