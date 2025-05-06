import entities.user;
import java.util.Scanner;

public class Register {
    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        user newUser = new user(username, email, password, fullName, phone, address);
        newUser.saveToDatabase();
    }
}

/*
Class Name:
Register
Method Name:
registerUser
 */
