package program;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<Person> persons;

	public static void main(String[] args) {
		Controller controller = new Controller(new Crud());
		controller.loadPersons();
		controller.loadVehicles();
		controller.loadRegister();
		Scanner sc = new Scanner(System.in);
		String input;
		while (true) {
			System.out.println("_______________________________________");
			System.out.println();
			controller.showRegister();
			System.out.println();
			controller.showAllPersons();
			System.out.println();
			controller.showAllVehicles();
			System.out.println();
			printMenu();
			input = sc.nextLine();
			switch (input) {
				case "1":
					System.out.println("Create Person:");
					controller.createPerson();
					break;
				case "2":
					System.out.println("Create Vehicle:");
					controller.createVehicle();
					break;
				case "3":
					System.out.println("Edit Person");
					controller.editPerson();
					break;
				case "4":
					System.out.println("Edit Vehicle");
					controller.editVehicle();
					break;
				case "5":
					System.out.println("Delete Person");
					controller.deletePerson();
					break;
				case "6":
					System.out.println("Delete Vehicle");
					controller.deleteVehicle();
					break;
				case "7":
					System.out.println("Person Info");
					controller.findPerson();
					break;
				case "8":
					System.out.println("Vehicle Info");
					controller.findVehicle();
					break;
				case "9":
					System.out.println("Search");
					controller.search();
					break;
				case "10":
					System.out.println("EXIT...");
					return;
			}
		}
	}

	public static void printMenu() {
		System.out.println("_______________________________________");
		System.out.println("      MENU");
		System.out.println("1. Create Person");
		System.out.println("2. Create Vehicle");
		System.out.println("3. Edit Person");
		System.out.println("4. Edit Vehicle");
		System.out.println("5. Delete Person");
		System.out.println("6. Delete Vehicle");
		System.out.println("7. Person Info");
		System.out.println("8. Vehicle Info");
		System.out.println("9. Search");
		System.out.println("10. EXIT");
		System.out.println("_______________________________________");
	}
}

