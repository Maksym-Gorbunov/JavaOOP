package app;

import java.util.Scanner;

public class Menu {


    public String[] createMenu(){
        System.out.println("\nCreate contact:");
        while(true){
            System.out.print("Name: ");
            input = sc.nextLine();
            if(Validator.checkName(input)){
                firstName = input; break;
            }
        }
        while(true){
            System.out.print("Last name: ");
            input = sc.nextLine();
            if(Validator.checkName(input)){
                lastName = input; break;
            }
        }
        while(true){
            System.out.print("Phone number: ");
            input = sc.nextLine();
            if(Validator.checkPhoneNumber(input)){
                phoneNumber = input; break;
            }
        }
        while(true){
            System.out.print("Email: ");
            input = sc.nextLine();
            if(Validator.checkEmail(input)){
                email = input; break;
            }
        }
        String[] data = new String[]{firstName, lastName, phoneNumber, email};
        return data;
    }
}
