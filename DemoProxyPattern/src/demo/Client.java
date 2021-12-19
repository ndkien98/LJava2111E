package demo;

public class Client {
    public static void main(String[] args) {
        Image image = new ProxyImage("http://gpcoder.com/favicon.ico");

        System.out.println("---");
        System.out.println("Call real service 1st: ");
        image.showImage();

        System.out.println("---");
        System.out.println("Call real service 2nd: ");
        image.showImage();
    }
}