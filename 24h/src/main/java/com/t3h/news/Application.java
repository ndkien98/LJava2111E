package com.t3h.news;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}

/**
 * - JDBC
 *
 * - Hibernate
 *
 * - JPA
 *
 * - ORM
 *
 * - git là 1 nền tảng quản lý các phiển bản
 *  + SVN
 *  + .....
 *
 *  - khởi tạo git
 *  + git init: khởi tạo repository tại máy local
 *  + server remote
 *  + git remote set-url origin newUrl: lệnh set remote cho server local
 *  - để đưa được code lên trên server remote
 *      + add file vào git repository local: git add đường dẫn file
 *      + commit lưu lại 1 phiên bản code taji1 thời điểm: git commit -m"comment tai day"
 *
 *- quy trình dùng git trong dự án
 * - lấy project về:
 *  + lệnh clone
 *
 * - checkout ra nhánh Feature để phát triển
 *  + gỉ checkout -b Featrue/ten chúc nang
 *
 * - sau khi code và phát triển chức năng xong thì add file
 *  + chỉ add các file code mình sửa, ko add các file config
 * - commit với message rõ ràng
 * - pull code từ nhánh develop về nhánh hiện tại
 *  + git fetch: lấy về tất cả code với từ git server
 *  + git pull origin develop: lấy code từ nhánh develop về nhánh đang phát triển
 *  + push code lên nhánh đang phát triển
 *  + tạo merge request đến nhánh develop
 */
