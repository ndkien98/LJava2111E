package singleton;

/**
 * Phương thức này tạo ra một thể hiện có thể truy cập toàn cục.
 *
 *
 * Việc triển khai phương thức này hoạt động tốt trong trường hợp môi trường
 * đơn luồng nhưng khi đối với các hệ thống đa luồng, nó có thể gây ra sự
 * cố nếu nhiều luồng nằm trong điều kiện if cùng một lúc.
 *
 *
 * Nó sẽ phá hủy mẫu singleton và cả hai luồng sẽ nhận được các thể hiện khác nhau của lớp singleton.
 */

public class LazyInitialization {

    private static LazyInitialization instance;
    private LazyInitialization() {
    }
    public static LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }
}