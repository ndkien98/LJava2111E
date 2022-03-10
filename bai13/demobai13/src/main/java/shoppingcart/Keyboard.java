package shoppingcart;

public class Keyboard extends Product{

    private String weight;

    public Keyboard(String id, int price,String weight) {
        super(id, price);
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "weight=" + weight +
                '}' + super.toString();
    }
}
