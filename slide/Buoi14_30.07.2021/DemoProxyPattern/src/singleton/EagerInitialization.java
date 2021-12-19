package singleton;

/**
 * Trong Eager initialization, thể hiện của Singleton Class được tạo tại thời điểm tải lớp.
 *
 *
 * Đây là phương pháp dễ nhất để tạo một lớp Singleton trong Java.
 *
 *
 * Nhưng nó có một nhược điểm là thể hiện đó được tạo ra mặc dù ứng dụng khách có thể không sử dụng nó.
 */

public class EagerInitialization {

    private static EagerInitialization instance;

    private EagerInitialization() {
    }

    static {
        try {
            instance = new EagerInitialization();
        }catch (Exception e) {
            throw new RuntimeException("Có ngoại lệ xảy ra");
        }
    }

    public static EagerInitialization getInstance() {
        return instance;
    }

}
