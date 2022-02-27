package com.t3h.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/**
 *
 * JPA: JPA (Java Persistence API) là 1 giao diện lập trình ứng dụng Java, nó mô
 * tả cách quản lý các mối quan hệ dữ liệu trong ứng dụng sử dụng Java
 * Platform.
 *
 *
 * git init: khởi tạo repo máy local
 *
 * git clone: copy repo từ remote về
 *
 * git remote: link của server
 *
 * git fetch: copy tất cả branch về repo máy local
 *
 * branch: đại diện cho 1 phiên bản cụ thể
 *
 * checkout: tạo ra 1 branch
 *  - Master: nhánh chính của git
 *
 * commit: đại diện cho 1 phiên bản tại 1 thời điểm nhất định
 *  - để commit được trc hết phải sử dụng git add
 *   để đưa đươc file vào Staging Area
 *
 *   - Staging Area
 *        + khu vực chuẩn bị cho quá trình commit
 *        + lưu trữ lại tất cả các thay đổi
 *   - status:
 *       + file chưa được add
 *       + file đã được add
 *       + file bị chỉnh sửa
 *       + file đã commit
 *
 * Merge: gộp code 2 nhánh với nhau
 *
 * push: đẩy code lên nhánh trên remote
 *
 * rebase:
 * head: commit ở đầu tiên mỗi nhánh thì gọi là head
 *
 *  -> quy trình sử dụng git*
 *
 * II Spring data JPA
 *
 *
 *
 */
