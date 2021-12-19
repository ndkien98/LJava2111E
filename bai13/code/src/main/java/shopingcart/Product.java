package shopingcart;

public class Product {
	private String title;
	private double price;
	private String id;
	
	public Product (String id,String t, double p) {
		this.title = t;
		this.price = p;
		this.id = id;
	}

	public Product() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Product) {
			Product p = (Product)o;
			return p.id.equals(this.id);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Product{" +
				"title='" + title + '\'' +
				", price=" + price +
				", id='" + id + '\'' +
				'}';
	}
}

