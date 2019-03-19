package program;
import java.io.Serializable;

public class Truck extends Vehicle implements Serializable{
	private int loadWeight;
	private int loadVolume;
	public static final long serialVersionUID = 22L;

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Truck obj2 = (Truck) obj;
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
	@Override
	public String info() {
		String info = "type of vehicle: " + this.getClass().getSimpleName().toLowerCase() + "\n" +
					  super.info() +
					  "load weight: " + getLoadWeight() + "kg\n" +
					  "load volume: " + getLoadVolume() + "m3\n";
		return info;
	}
	
	//Constructor
	public Truck(String regNummer, String model, int year, int weight, String color, int loadWeight, int loadVolume, Engine fuel) {
		super(regNummer, model, year, weight, color, fuel);
		this.loadVolume = loadVolume;
		this.loadWeight = loadWeight;
	}

	//Getters & Setters
	public int getLoadWeight() {
		return loadWeight;
	}
	public void setLoadWeight(int loadWeight) {
		this.loadWeight = loadWeight;
	}
	public int getLoadVolume() {
		return loadVolume;
	}
	public void setLoadVolume(int loadVolume) {
		this.loadVolume = loadVolume;
	}
}
