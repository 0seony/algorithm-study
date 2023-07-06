## 놀이공원 티켓 판매하기💙
1. 회원 등급이 높은 사람에게 먼저 티켓 판매
2. 회원 등급이 같은 경우 더 많은 티켓을 신청한 사람에게 먼저 판매
3. 남은 티켓 수보다 더 많은 티켓을 구매하려는 경우 판매하지 않음
4. 티켓 판매는 한 번에 한 사람씩 순서대로

```java
import java.util.Arrays;

public class Shinhan {
   public static void main(String[] args) {
      // 테스트 케이스 출력
      int[][] arr1 = {{2,3},{1,7},{2,4},{3,5}};
      int[][] arr2 = {{1,9},{3,6},{2,5}};
      int[][] arr3 = {{3,1},{2,5},{2,10},{3,8},{1,2}};
      Shinhan T = new Shinhan();
      System.out.println(T.solution(10,arr1));
      System.out.println(T.solution(8,arr2));
      System.out.println(T.solution(20000,arr3));
      
   }
   
   public int solution(int tickets, int[][] requests) {
      int less = tickets;
      int answer = 0;
      Arrays.sort(requests,(o1,o2)->{
          // 같은 회원 등급인 경우 티켓 개수로 내림차순 정렬
         if(o1[0]==o2[0]) {
            return o2[1]-o1[1];
          // 회원 등급 오름차순 정렬
         } else {
            return o1[0]-o2[0];
         }
      });
      for(int[] request : requests) {
         if(less-request[1]>=0) {
            less-=request[1];
            answer+=request[1];
         }
      }
      return answer;      
   }
}
```
