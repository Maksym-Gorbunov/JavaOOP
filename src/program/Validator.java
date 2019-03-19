package program;

public class Validator {
public static boolean isFieldValid(String fieldName, String input) {
		switch(fieldName) {
			case "adress":
			case "model":
				return true;
			case "color":
				if(input.matches("[a-zA-Z]{1,20}"))  {
					return true;
				}
				System.out.println("--> invalid input : color");
				break;
			case "engineType":
				if(input.matches("[diesel]{6}") || input.matches("[petrol]{6}") || input.matches("[electric]{8}"))  {
					return true;
				}
				System.out.println("--> invalid input : engine type");
				break;
			case "enginePower":
				if(input.matches("[0-9]{1,20}"))  {
					return true;
				}
				System.out.println("--> invalid input : engine power");
				break;
			case "batterySize":
				if(input.matches("[0-9]{1,20}"))  {
					return true;
				}
				System.out.println("--> invalid input : battery size");
				break;
			case "powerConsumption":
				if(input.matches("[0-9]{1,20}"))  {
					return true;
				}
				System.out.println("--> invalid input : power consumption");
				break;
			case "gears":
				if(input.matches("[0-9]{1,20}"))  {
					return true;
				}
				System.out.println("--> invalid input: gears");
				break;
			case "loadWeight":
				if(input.matches("[0-9]{1,20}"))  {
					return true;
				}
				System.out.println("--> invalid input: load weight");
				break;
			case "loadVolume":
				if(input.matches("[0-9]{1,20}"))  {
					return true;
				}
				System.out.println("--> invalid input: load volume");
				break;
			case "weight":
				if(input.matches("[0-9]{1,20}"))  {
					return true;
				}
				System.out.println("--> invalid input: weight");
				break;
			case "numberOfPassangers":
				if(input.matches("[0-9]{1,2}"))  {
					return true;
				}
				System.out.println("--> invalid input: number of passangers");
				break;
			case "regNumber":
				if(input.matches("[A-Za-z]{3}[0-9]{2}[0-9a-zA-Z]{1}"))  {
					return true;
				}
				System.out.println("--> invalid input: register number");
				break;
			case "age":
				if(input.matches("[0-9]{2}"))  {
					return true;
				}
				System.out.println("--> invalid input: age");
				break;
			case "year":
				if(input.matches("[0-9]{4}"))  {
					return true;
				}
				System.out.println("--> invalid input: year");
				break;
			case "tankSize":
				if(input.matches("[0-9]{1,4}"))  {
					return true;
				}
				System.out.println("--> invalid input: tank size");
				break;
			case "fuelConsumption":
				if(input.matches("[0-9]{1,20}"))  {
					return true;
				}
				System.out.println("--> invalid input : fuel consumption");
				break;
			case "personalNumber":
				if(input.matches("[0-9]{6}[-]{1}[0-9]{4}"))  {
					return true;
				}
				System.out.println("--> invalid input: personal number");
				break;
			case "name":
				if(input.matches("[A-Z]{1}[a-z]{1,20}\\s[A-Z]{1}[a-z]{1,20}"))  {
					return true;
				}
				System.out.println("Invalid name");
				break;
		}
		return false;
	}
}

	