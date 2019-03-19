package app;

public class Validator {
    //Check first or last name (text only and start with uppercase, ex. "Daniel")
    public static boolean checkName(String input){
        if(input.matches("[A-Z]{1}[a-z]{2,20}")){
            return true;
        }
        return false;
    }

    //Check phone number (numbers only)
    public static boolean checkPhoneNumber(String input){
        if(input.matches("[0-9]{7,15}")){
            return true;
        }
        return false;
    }

    //Check emil (ex. "one.team@gmail.com")
    public static boolean checkEmail(String input){
        if(input.matches("[A-Za-z0-9.]{1,30}[@][a-z]{2,10}[.][a-z]{2,3}")){
            return true;
        }
        return false;
    }
}
