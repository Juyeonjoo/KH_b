package Nov28;

import java.util.Stack;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StackExample {
//	LIFO 후입선출 자료구조를 가지는 스택의 예(동전통)
	public static void main(String[] args) {
		//1. 스택 구조를 가직는 자료구조 객체 생성
		Stack<Coin> coinBox = new Stack<Coin>();
		
		//2/ 스택에 동전 4개 넣기.
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		Coin c1000 = new Coin (1000);
		coinBox.push(c1000); //중복 삽입 
		coinBox.push(c1000);//중복 삽입
	
		log.info("1. coinBox : {}", coinBox);
		
		//3. 스택이 비워질때까지(empty)욧를 ㅎ나기 pop해서 ㅜㄹㄹ려
		while(!coinBox.isEmpty()) {		//동전통이 비었는가
			Coin coin = coinBox.pop();		// 비어있지 않으면 하나를 끄집어내라
			log.info("2. 꺼내온 동전: {} 원", coin.getValue());
		} //while
		
		//4. traverse
		for(Coin coin : coinBox) {
			log.info(coin);
		} //enhanced for 문
		
	}//main
} //end class
