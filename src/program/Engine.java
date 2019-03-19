package program;
import java.io.Serializable;

public abstract class Engine implements Serializable {
	private float enginePower;	// kW
	public static final long serialVersionUID = 66L;

	//Info
	public String info() {
		return null;
	}

	//Constructor
	public Engine(float enginePower) {
		this.enginePower = enginePower;
	}
	
	//Getters & Setters
	public float getEnginePower() {
		return enginePower;
	}
	public void setEnginePower(float enginePower) {
		this.enginePower = enginePower;
	}
	

	
}
