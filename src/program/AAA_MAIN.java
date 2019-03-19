import app.Menu;
import domain.Contact;

public class Main {
    public static void main(String[] args) {
        new Menu().mainMenu();








        Menu menu = new Menu();
        String[] data = menu.createMenu();
        for (String field : data){
            System.out.println(field);
        }
    }
}
