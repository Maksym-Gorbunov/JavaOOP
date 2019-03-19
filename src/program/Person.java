package program;
import java.io.Serializable;

public class Person implements Serializable{
	private String personalNumber;
	private String name;
	private int age;
	private String adress;
	public static final long serialVersionUID = 44L;

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Person obj2 = (Person) obj;
		return getPersonalNumber().equals(obj2.getPersonalNumber());
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(getPersonalNumber());
	}
	
	@Override
	public String toString() {
		return getPersonalNumber();
	}
	
	//Info
	public String info() {
		String info = "personal number: " + getPersonalNumber() + "\n" +
					  "name: " + getName() + "\n" +
					  "age: " + getAge() + " years\n" +
					  "adress: " + getAdress();
		return info;
	}
	
	//Constructor
	public Person(String personalNumber, String name, int age, String adress) {
		this.personalNumber = personalNumber;
		this.name = name;
		this.age = age;
		this.adress = adress;
	}
	
	//Getters & Setters
	public String getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
}
