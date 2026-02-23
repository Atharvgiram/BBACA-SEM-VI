import java.util.Scanner;

public class S8a {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();   // clear buffer

        String[] names = new String[n];

        for(int i = 0; i < n; i++) {
            System.out.print("Enter employee name: ");
            names[i] = sc.nextLine();
        }

        System.out.println("\nEmployees whose name starts with 'A':");

        for(int i = 0; i < n; i++) {
            if(names[i].toUpperCase().startsWith("A")) {
                System.out.println(names[i]);
            }
        }
    }
}
