import java.util.Arrays;
import java.util.Scanner;

public class EX4 {

   public static void main(String[] args) {
         System.out.println("=== 시작 ===");
         System.out.println("프로그램을 종료하려면 EXIT를 입력하시오");
         while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("문자를 입력해주세요");

            String word = sc.nextLine();
            if (word.equalsIgnoreCase("EXIT")) {
               break; // 무한루프 탈출 조건
            }
            char[] word2 = word.toCharArray();//word단어를 배열로 바꿔준다
            System.out.println(Arrays.toString(word2));
            int i;
            for (i = 0; i < word2.length; i++) {//애너그램 판정
               if (word2[i] == word2[word2.length - i - 1]) {
               } else {
                  System.out.println("애너그램이 아닙니다");
                  break;
               }

            }

          if( i == word2.length ) {
          System.out.println("애너그램입니다"); 
          }

         }
         System.out.println("=== 종료 ===");

      }
   }