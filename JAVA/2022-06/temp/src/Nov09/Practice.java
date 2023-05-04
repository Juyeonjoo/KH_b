package Nov09;

import java.lang.reflect.Method;

public class Practice {

		
		public static void main(String[] args) {
		

			Method[] declaredMethods = Service.class.getDeclaredMethods();
			
			System.out.println("declaredMethods 주소= " + declaredMethods);

			for(Method method : declaredMethods) {
				

				if(method.isAnnotationPresent(MyAnnotation.class)) {
					

					MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);

					System.out.println("[" + method.getName()+ "]");
				
				
				for(int i =0; i < myAnnotation.number(); i++) {
					System.out.print(myAnnotation.value());
				} //for
				
				System.out.println();	//하나의 빈행 출력
				
		
				try { 				
					method.invoke(new Service());
				} catch(Exception e) {;;}
				System.out.println();
				}	//if
			}// enhanced for
		}	//main
	} // end class


