package program;
import java.io.Serializable;

public abstract class Vehicle implements Serializable{
	private String regNumber;
	private String model;
	private int year;
	private int weight;
	private String color;
	private Engine fuel;	
	public static final long serialVersionUID = 33L;

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Vehicle obj2 = (Vehicle) obj;
		return getRegNumber().equals(obj2.getRegNumber());
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(getRegNumber());
	}
	
	@Override
	public String toString() {
		return getRegNumber();
	}
	
	//Info
	public String info() {
		String info = "register number: " + getRegNumber() + "\n" +
					  "model: " + getModel() + "\n" +
					  "year: " + getYear() + "\n" +
					  "weight: " + getWeight() + "kg\n" +
					  "color: " + getColor() + "\n";
		return info + getFuel().info();
	}

	//Constructor
	public Vehicle(String regNummer, String model, int year, int weight, String color, Engine fuel) {
		this.regNumber = regNummer;
		this.model = model;
		this.year = year;
		this.weight = weight;
		this.color = color;
		this.fuel = fuel;
	}
	
	//Getters & Setters
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Engine getFuel() {
		return fuel;
	}
	public void setFuel(Engine fuel) {
		this.fuel = fuel;
	}
}
