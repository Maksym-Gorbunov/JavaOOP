package program;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable{
	private int numberOfPassangers;

	public static final long serialVersionUID = 11L;

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Car obj2 = (Car) obj;
		return getRegNumber().equals(obj2.getRegNumber());
	}

	public static void test555(){
		System.out.println("hello 555");
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
	@Override
	public String info() {
		String info = "type of vehicle: " + this.getClass().getSimpleName().toLowerCase() + "\n" +
					  super.info() +
				      "numbers of passangers: " + getNumberOfPassangers() + "\n";
		return info;
	}
	
	//Constructor
	public Car(String regNummer, String model, int year, int weight, String color, int numberOfPassangers, Engine fuel) {
		super(regNummer, model, year, weight, color, fuel);
		this.numberOfPassangers = numberOfPassangers;
	}

	//Getters & Setters
	public int getNumberOfPassangers() {
		return numberOfPassangers;
	}
	public void setNumberOfPassangers(int numberOfPassangers) {
		this.numberOfPassangers = numberOfPassangers;
	}
	
	

}
