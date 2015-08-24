package ba.bitcamp.SQL.task02andtask03;

/**
 * This class represents one product
 * 
 * @author Gordan
 *
 */
public class Product {

	// Declaring variables
	private Integer code;
	private String name;
	private Double price;

	/**
	 * Constructor
	 */
	public Product(Integer code, String name, Double price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public String toString() {
		return String.format("(%d) %s - %.2f KM", code, name, price);
	}

	// Getters and setters
	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
