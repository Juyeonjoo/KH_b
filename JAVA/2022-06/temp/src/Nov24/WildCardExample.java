package Nov24;

import java.util.Arrays;

import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@ToString
@Log4j2

public class WildCardExample {
	
	//필드
//	Course<Person> course; 
//	Course<?> course2 = new Course<>("일반인과정", 5); // 

	//모든 일반인을 대상으로 하는 과정객체를 출력
	public static void printCourse(Course<?> course) { //구체타입: ? 
		log.trace("printCourse({}) invoked.", course);
	} //printCourse
	
	//학생들을 대상으로 하는 과정을 출려
	public static void printCourseStudent(Course<? extends Student> course) { //구체타입:제약된? 
		log.trace("printCourseStudent({}) invoked.", course);	
	}//printCourseStudent
	
	//근로자를 대상으로 하는 과정을 출력
	public static void printCourseWorker(Course<? super Worker> course) {
		log.trace("printCourseWorker({}) invoked.", course);
	}// printCourseWorker
	
	
//	============================================
	public static void main(String[] args) {
		
		//1. 첫번째 과정객체 생성(일반인 대상)
	Course<Person> personCourse = new Course<>("일반인과정", 5);
	
	personCourse.add(new Person("일반인"));
	personCourse.add(new Worker("직장인"));			//다형성1
	personCourse.add(new Student("학생"));			//다형성1
	personCourse.add(new HighStudent("고등학생"));	//다형성1
	
	System.out.println("===================================");
	//2. 두 번째 과정객체 생성(직장인 대상)
	Course<Worker> workerCourse = new Course<Worker>("직장인 과정", 5);
	
	workerCourse.add(new Worker("직장인"));

	System.out.println("===================================");
	
	//3. 세 번째 과정객체 생성(학생 대상)
	Course<Student> studentCourse = new Course<Student>("학생과정", 5);
	
	studentCourse.add(new Student("학생"));
	studentCourse.add(new HighStudent("고등학생"));		//다형성1

	System.out.println("===================================");
	
	//4. 네 번째 과정 객체 생성 (고등학생 대상)
	Course<HighStudent> highStudentCourse = new Course<HighStudent>("고등학생 과정", 5);
	
	highStudentCourse.add(new HighStudent("고등학생"));
	

	System.out.println("===================================");
	
	//1st. case : printCourse(Course<?> course)
	//생성된 제네릭타입의 객체를 받으니까 , ? wild 카드 사용가능
	printCourse(personCourse); // course객체, 구체타입만 다름(Perosn,Worker등)
	printCourse(workerCourse);
	printCourse(studentCourse);
	printCourse(highStudentCourse);
	
	System.out.println("===================================");
	
	//2nd. case: printCourseStudent(Course<? extends Student> course)
//	printCourseStudent(personCourse);
//	printCourseStudent(workerCourse);
	printCourseStudent(studentCourse);
	printCourseStudent(highStudentCourse);
	
	
	//3rd case: printCourseWorker(Course<? super Worker> course) 
	
	printCourseWorker(personCourse);
	printCourseWorker(workerCourse);
//	printCourseWorker(studentCourse);
//	printCourseWorker(highStudentCourse);
	
	}//main
} //end class
