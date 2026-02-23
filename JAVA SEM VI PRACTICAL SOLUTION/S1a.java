public class S1a {

    public static void main(String[] args) throws InterruptedException {

        String text = "SVPM";
        int position = 0;
        int direction = 1;     // 1 = right, -1 = left
        int maxWidth = 40;     // console width

        while (true) {

            // Step 1: Clear the entire line
            System.out.print("\r");
            for (int i = 0; i < maxWidth + text.length(); i++) {
                System.out.print(" ");
            }

            // Step 2: Reset cursor
            System.out.print("\r");

            // Step 3: Print spaces + text
            for (int i = 0; i < position; i++) {
                System.out.print(" ");
            }
            System.out.print(text);

            // Step 4: Update position
            position += direction;

            // Step 5: Boundary control
            if (position >= maxWidth) {
                direction = -1;
            }
            if (position <= 0) {
                direction = 1;
            }

            Thread.sleep(150);
        }
    }
}
