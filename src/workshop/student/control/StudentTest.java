package workshop.student.control;

import workshop.student.Student;

public class StudentTest {
	public static void main(String[] args) {
        Student student = new Student("20250423", "��μ�", "��ǻ�Ͱ���", 3);
        System.out.println(student.getName() + " / " + student.getMajor() + " / " 
                + student.getGrade() + "�г�");
        
        System.out.println("5�г����� ����");
        student.setGrade(5);
	}
}
