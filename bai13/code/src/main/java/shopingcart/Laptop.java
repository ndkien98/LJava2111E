package shopingcart;

import java.util.Objects;

public class Laptop extends Product{

    private String cpu;

    public Laptop(String id,String t, double p, String cpu) {
        super(id,t, p);
        this.cpu = cpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        System.out.print(super.toString());;
        return "Laptop{" +
                "cpu='" + cpu + '\'' +
                '}';
    }
}
