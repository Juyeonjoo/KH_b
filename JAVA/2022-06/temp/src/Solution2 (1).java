

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

/*
 *
 *
두 개의 조건
- 첫 번째 배열(a[i]) 요소는 '어떤 수들=x'의 공약수
- 이 'x'은 두 번째 배열(b[j])의 공약수

제약
1 <= a[i], b[j] =< 100

예제
a = [2, 6] ------> [6,12,18,24...] 			// 2와 6의 배수,
b = [24, 36]----> [1,2,3,4,6,12]			// 24와 36의 약수,

> 어떤수들이 가능한 범위: a[i-1] =< 'x' 범위 =< b[0]
> 6 = a[i-1] =< 'x' 범위 =< b[0] = 24  					---->for(int num =aArr[aArr.length - 1] ; num <= bArr[0] ; num++)

2는 6의 약수이므로 6의 배수, 6보다 작을 수 없다.
24와 36에서 공통으로 들어가는 약수이므로 24보다 클 수 없다.

알고리즘
1. a[i]의 공배수 배열 (a[0]: 최소 공배수)
2. b[j]의 공약수 배열 (b[j-1]: 최대 공약수)
3. a[i]와 b[j] 일치하는 값들의 배열
4. 배열의 크기
 *
 *
 */

class Result2 {

	public static int getTotalX(List<Integer> a, List<Integer> b) {

		TreeSet<Integer> aSet = new TreeSet<>(a);						// a List의 요소를 TreeSet으로 오름차순으로 정렬(TreeSet의 키는 저장과 동시에 자동 오름차순 정렬)
		//대소비교하여 정렬 가능한 이유 --> java.lang.Comparable 을 구현한 객체 요구
		//public final class Integer extends Number implements Comparable<Integer>, Constable, ConstantDesc
		Integer[] aArr = aSet.toArray(new Integer[aSet.size()]);		// Integer타입의 aArr의 배열에 저장
		//toArray() Returns an array containing all of the elements in this collection;

		TreeSet<Integer> bSet = new TreeSet<>(b);						// b List의 요소를 TreeSet으로 오름차순으로 정렬하고
		Integer[] bArr = bSet.toArray(new Integer[bSet.size()]);		// Integer타입의 bArr의 배열에 저장

		int answer = 0;
		//중첩된 반복문을 깨트리고 나오는 label문,반복문이 중첩되더라도 label이 포함되어있는 전체 break 효과

		loof:	// 답이 될 가능성이 있는 수의 범위를 순회하면서 조건 체크


			for(int num =aArr[aArr.length - 1] ; num <= bArr[0] ; num++){					//3. a[i]와 b[j] 일치하는 값들의 배열

				for(int aNum : aArr){	// a요소들의 공통배수인지 (aARR = a[i]요소)			//1. a[i]의 공배수 배열
					//enhanced for문 ( 하나의 자료를 저장할 변수 선언 : <자료 구조>)> 차례대로, 순서대로 꺼낸다.

					// 6%2, 6%6 > 12%2, 12%6
					if(num % aNum != 0){

						continue loof;	// a의 배수가 아니라면, 바깥쪽 for문, 증감식으로 돌아가 계속 수행
					} // if

				} // inner enhanced for1

				for(int bNum : bArr){	// b요소들의 공통약수인지 (bARR = b[i]요소)			2. b[j]의 공약수 배열

					//24%6, 36%6 > 24%12, 36%12
					if(bNum % num != 0){

						continue loof;	// b의 약수가 아니라면, 바깥쪽 for문, 증감식으로 돌아가 계속 수행
					} // if

				} // inner enhanced for2

				answer++; // a요소들의 공통배수이면서 b요소들의 공통약수인 경우에만 answer++
			} // outer for(loop)

		return answer;																		//4. 배열의 크기

	} // getTotalX
}

public class Solution2 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int total = Result2.getTotalX(arr, brr);

		bufferedWriter.write(String.valueOf(total));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();

	}
}