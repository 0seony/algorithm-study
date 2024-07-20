import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String S = bf.readLine();
        int[] info = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        int[] nums = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            nums[i] = info[S.charAt(i) - 'A'];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= 10;
        }
        if (sum % 2 == 0) {
            System.out.println("You're the winner?");
        } else {
            System.out.println("I'm a winner!");
        }

    }
}