import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            LinkedList<int[]> printer = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                printer.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }
            int cnt = 0;
            while (!printer.isEmpty()) {
                int[] now = printer.poll();
                boolean isMax = true;
                for (int i = 0; i < printer.size(); i++) {
                    if (now[1] < printer.get(i)[1]) {
                        printer.offer(now);
                        for (int j = 0; j < i; j++) {
                            printer.offer(printer.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if (!isMax) continue;
                cnt++;
                if (now[0] == M) break;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}