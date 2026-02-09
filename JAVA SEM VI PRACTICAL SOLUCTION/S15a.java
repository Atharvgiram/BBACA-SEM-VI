public class S15a {

    public static void main(String[] args) {

        for(char ch = 'a'; ch <= 'z'; ch++) {

            System.out.println(ch);

            try {
                Thread.sleep(2000);   // 2 seconds delay
            } catch(Exception e) {}
        }
    }
}
