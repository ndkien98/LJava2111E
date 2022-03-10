package com.t3h.newspringboot.controller.api;

import com.t3h.newspringboot.model.request.NewsRequest;
import com.t3h.newspringboot.model.response.NewResponse;
import com.t3h.newspringboot.service.INewService;
import com.t3h.newspringboot.utils.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewController {

    private final INewService iNewService;

    public NewController(INewService iNewService) {
        this.iNewService = iNewService;
    }

    @GetMapping()
    public ResponseEntity<List<NewResponse>> getList(){
        return ResponseEntity.ok(iNewService.getAll());
    }

    @GetMapping("/{author}")
    public ResponseEntity<List<NewResponse>> findByAuthor(@PathVariable(name = "author",required = false) String author){
        return ResponseEntity.ok(iNewService.findByAuthor(author));
    }

    @PostMapping()
    public ResponseEntity<?> insert(@RequestBody NewsRequest newsRequest){
        iNewService.insert(newsRequest);
        return ResponseEntity.ok("successful");
    }


}
