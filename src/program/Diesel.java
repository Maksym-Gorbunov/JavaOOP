package program;
import java.io.Serializable;

public class Diesel extends Engine implements Serializable{
	private float fuelConsumption;	// L/km
	private int tankSize;			// L
	private int gears;
	public static final long serialVersionUID = 77L;

	//Info
	@Override
	public String info() {
		String info = "type of fuel: " + this.getClass().getSimpleName().toLowerCase() + "\n" +
				"fuel consumption: " + getFuelConsumption() + "L/km\n" +
				"tank size: " + getTankSize() + "L\n" +
				"gears: " + getGears() + "\n";
		return info;
	}

	//Constructor
	public Diesel(float fuelConsumption, int tankSize, int gears, float enginePower) {
		super(enginePower);
		this.fuelConsumption = fuelConsumption;
		this.tankSize = tankSize;
		this.gears = gears;
	}

	//Getters & Setters
	public float getFuelConsumption() {
		return fuelConsumption;
	}
	public void setFuelConsumption(float fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	public int getTankSize() {
		return tankSize;
	}
	public void setTankSize(int tankSize) {
		this.tankSize = tankSize;
	}
	public int getGears() {
		return gears;
	}
	public void setGears(int gears) {
		this.gears = gears;
	}
}
