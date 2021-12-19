package singleton;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Khi bạn chạy code bên dưới, bạn sẽ thấy rằng hashCode của cả hai trường hợp không giống nhau sẽ phá hủy singleton.
 *
 *
 * Reflection rất mạnh mẽ và được sử dụng trong rất nhiều framework như Spring và Hibernate.
 */
public class Main {

    public static void main(String[] args) {

        EagerInitialization instanceOne = EagerInitialization.getInstance();
        EagerInitialization instanceTwo = null;

        try {
            Constructor[] constructors = EagerInitialization.class.getDeclaredConstructors();
            constructors[0].setAccessible(true);
            instanceTwo = (EagerInitialization) constructors[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());


    }


}
