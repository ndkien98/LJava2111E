package shoppingcart;

public class Screen extends Product{

    private String resolution;

    public Screen(String id, int price,String resolution) {
        super(id, price);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "resolution='" + resolution + '\'' +
                '}' + super.toString();
    }
}
