package com.t3h.news.controller;

import com.t3h.news.model.NewsModel;
import com.t3h.news.service.INewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cms/admin/news")
public class NewsController {


    /**
     * @Autowired
     * sử dựng reflection để tiêm
     */
    private final INewsService iNewsService;

    /**
     * DI
     * vì iNewsService có newserviceImpl được đánh dấu @Service
     * -> spring sẽ tự động tạo bean cho iNewsService = new NewsServiceImpl trong bean container
     * -
     * @param iNewsService
     */
    public NewsController(INewsService iNewsService) {
        this.iNewsService = iNewsService;
    }

    /**
     * GET
     * POST
     * PUT
     * DELETE
     * ...
     *
     * RestFul API
     * API (application programing interface)
     * - là 1 tập hợp các quy tắc hoặc hay 1 cơ chế để các hệ thống giao tiếp với nhau
     *
     * REST
     * - Cơ chế để chuyển đổi cấu chúc dữ liệu
     * vd: class -> json, xml
     * vd json:
     * {
     *     "name" : "TopDev",
     *     "title" : "Việc làm IT cho Top Developers",
     *     "description" : "là hệ sinh thái bao gồm cộng đồng các Top Developers."
     * }
     *  RestFul API:
     *  Tiêu chuẩn, quy tắc để xây dựng web service
     *  - trả ra dữ liệu dạng json, xml
     *  - cung cấp các đầu api
     *  - GET: chuyến lấy ra dữ liệu
     *  - POST: thêm dữ liệu trên server
     *  - PUT: Cập nhập
     *  - DELETE: Xóa dữ liệu trên server
     *
     * @return
     */
    @GetMapping()
    public String getListNews(Model model){
        List<NewsModel> newsModels = iNewsService.getList();
        model.addAttribute("newsModel",newsModels);
        return "admin/news/news";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable int id){
        NewsModel newsModel = iNewsService.findById(id);
        model.addAttribute("newsModel",newsModel);
        return "admin/news/detailNews";
    }

    @GetMapping("/create")
    public String create(Model model){
        NewsModel newsRequest = new NewsModel();
        model.addAttribute("newRequest",newsRequest);
        return "admin/news/addNews";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("newsRequest") NewsModel newsRequest){
        iNewsService.add(newsRequest);
        return "redirect:/news";
    }


}

/**
 *
 * ODBC: được viết bằng ngôn ngữ C
 *
 * JDBC: + chuẩn để làm việc với cơ sở dữ liệu
 *       + cung cấp các đầu api để kết nối đến csdl
 *       + giao tiếp với database
 *       + tạo ra câu query trên Java để thao tác với csdl
 *
 *  - các bước để giao tiếp với database bằng JDBC
 *  + mở connection
 *  + tạo ra câu query
 *  + Query dữ liệu ( nhận được dữ liệu dưới dạng các table)
 *  + mapping dữ liệu từ table -> Java
 *
 *
 * Hibernate, JPA,
 * từ JDBC => cần đến ORM framework
 * vì:
 * - các tổ chức dữ liệu khác nhau, Java -> Class, database -> table
 * - Java có khái niệm kế thừa, database chỉ có khái niệm khóa ngoại khóa chính
 *
 * => ORM framework tự động mapping dữ liệu từ các table ứng với các class
 *
 * Hibernate:
 *+ tự động quản lý các transaction
 *+ kết hợp ORM framework thự hiện query thông qua các class ORM ( Entity) ( che dấu đi cấu trúc database,
 * dễ ràng phát triển
 *
 * transaction: (vd khi thực hiện insert, update -> đó gọi là 1 transaction)
 * + commit: sửa đôi dữ liệu trong cở sở dữ liệu
 * + rollback: đảm bảo dữ liệu sẽ nguyên vẹn như ban đầu nếu sảy ra lỗi khi thực hiện transaction
 *

 */
