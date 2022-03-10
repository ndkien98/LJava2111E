package shoppingcart;

public class Laptop extends Product{

    private String cpu;

    public Laptop(String id, int price, String cpu) {
        super(id, price);
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
        return "Laptop{" +
                "cpu='" + cpu + '\'' +
                '}' + super.toString();
    }
}
