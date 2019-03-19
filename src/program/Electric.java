package program;
import java.io.Serializable;

public class Electric extends Engine  implements Serializable {
	private float powerConsumption;		// kwh/km
	private float batterySize;			// kWh
	public static final long serialVersionUID = 99L;

	//Constructor
	public Electric(float powerConsumption, float batterySize, float enginePower) {
		super(enginePower);
		this.powerConsumption = powerConsumption;
		this.batterySize = batterySize;
	}

	//Info
	@Override
	public String info() {
		String info = "type of fuel: " + this.getClass().getSimpleName().toLowerCase() + "\n" +
				      "power consumption: " + getPowerConsumption() + "kWh/km\n" +
				      "battery size: " + getBatterySize() + "kWh\n";
		return info;
	}

	//Getters & Setters
	public float getPowerConsumption() {
		return powerConsumption;
	}
	public void setPowerConsumption(float powerConsumption) {
		this.powerConsumption = powerConsumption;
	}
	public float getBatterySize() {
		return batterySize;
	}
	public void setBatterySize(float batterySize) {
		this.batterySize = batterySize;
	}
}
