import java.util.Scanner;

public class S17a {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        for(int i = 0; i < str.length(); i++) {

            char ch = Character.toLowerCase(str.charAt(i));

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {

                System.out.println(ch);

                try {
                    Thread.sleep(3000);   // 3 seconds delay
                } catch(Exception e) {}
            }
        }
    }
}
