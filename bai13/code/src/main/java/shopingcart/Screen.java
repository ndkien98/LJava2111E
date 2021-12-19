package shopingcart;

import java.util.Objects;

public class Screen extends Product {

    private String resolution;

    public Screen(String id,String t, double p, String resolution) {
        super(id,t, p);
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
        System.out.print(super.toString());
        return "Screen{" +
                "resolution='" + resolution + '\'' +
                '}';
    }
}
