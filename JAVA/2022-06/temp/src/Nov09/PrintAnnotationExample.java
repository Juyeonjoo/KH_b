package Nov09;

import java.lang.reflect.Method;


public class PrintAnnotationExample {
		
	// �ڹ� ���÷��� API (Java Reflection API)�� �̿��Ͽ�
	// ������̼��� ��Ÿ�����͸� �̿��Ͽ�, ����� Ư���� ����� �����غ���!!
	public static void main(String[] args) {

		// ================================================
		// Step.1 Service Ŭ������ "Clazz" ��ü�κ���,
		//        Ŭ���� �ȿ� ����� ��� �޼ҵ� ������ �迭�� ����
		// ================================================
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		
		// ================================================
		// Step.2 �迭�� ��ȸ�ϸ鼭, Service Ŭ������ �����
		//        �� Method�� MyAnnotation�� ����Ǿ� �ִ��� Ȯ���մϴ�.
		//        (����: �迭��ȸ�� ����, Enhanced for���� �̿��մϴ�)
		// ================================================
		for(Method method : declaredMethods) {
			
			// ================================================
			// Step.3 MyAnnotation�� ���� �޼ҵ忡 ����Ǿ��ִ��� Ȯ��
			// ================================================
			if( method.isAnnotationPresent( MyAnnotation.class ) ) {
				
				// ================================================
				// Step.4 ���� �޼ҵ忡 MyAnnotation�� ����Ǿ� �ִٸ�,
				//        �ش� ������̼��� ������
				// ================================================
				MyAnnotation myAnnotation = 
						method.getAnnotation( MyAnnotation.class );

				// ================================================
				// Step.5 ���� �޼ҵ��� �̸��� �ֿܼ� ���
				// ================================================
				System.out.println("[" + method.getName() + "] ");
				
				// ================================================
				// Step.6 ���� �޼ҵ忡 ����� MyAnnotation�� �Ӽ�����
				//        �����Ǵ� ��Ÿ�����͸� �̿��Ͽ�, �޼ҵ� ȣ��α�
				//        �� �ڵ����� ����� �������!!
				//        (�̰��� �ٷ�, MyAnnotation�� ��Ÿ������ �̿������)
				// ================================================
				
				// -------------------------
				// Step.6-1 ���м� ���
				// -------------------------
				for(int i=0; i < myAnnotation.number(); i++) {
					System.out.print( myAnnotation.value() );
				} // for
				
				System.out.println();	// �ϳ��� �� �� ���

				// -------------------------
				// Step.6-2 ���� ��ȸ�ϴ� �޼ҵ带 ���� ȣ��
				// -------------------------
				try {
					method.invoke(new Service());
				} catch (Exception e) {;;}
				System.out.println();
			} // if
		} // enhanced for
		
	} // main
	
} // end class
