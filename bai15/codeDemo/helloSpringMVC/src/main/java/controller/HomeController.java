package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


    @RequestMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }

    /**
     * Http:
     * GET
     * POST
     * PUT
     * DELETE
     * Restful :
     *
     *
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    /**
     * http://localhost:8080/google
     * @return
     */
    @RequestMapping(value = "/google",method = RequestMethod.GET)
    public String google(){
        return "google";
    }

    /**
     * HomeController home = new HomeController();
     *
     * object home: được gọi là 1 bean
     * bean sẽ được nằm trong bean container quản lý
     *
     * @Controller:
     *  Đánh dấu class này là 1 component để tạo bean
     *  Đánh đấu là 1 controller để thực hiển trả ra 1 view
     *
     *  - @RequestMapping thực hiện chỉ định tất cả các đường dẫn:
     *      localhost:8008/
     *      localhost:8080/index
     *
     * - Khi project được code xong sẽ được build ra 1 file có đuổi
     * .war
     * .jar
     * - công cụ hỗ trợ build file: là maven, gradle
     *
     * - để chạy được file .war thì cần 1 webserver là tomcat
     */
}
