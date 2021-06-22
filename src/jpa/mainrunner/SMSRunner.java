package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.entity.models.Course;
import jpa.entity.models.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;


public class SMSRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		//MAIN Logic Requirments 
		
		
		System.out.print("Are you: a(an) ");
		System.out.println("1. Student? ");
		System.out.println("2. Quite");
		System.out.println("Please Enter 1 or 2: ");
		try {
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		if(userInput == 1) {
			
			StudentService checkLogin = new StudentService();
			Scanner inputCre = new Scanner(System.in);
			System.out.print("Enter your email: ");
			String email = inputCre.nextLine();
			
			
			System.out.print("Enter your password: ");
			String password = inputCre.nextLine();
		
			if(checkLogin.validateStudent(email, password) == true) {
				List<Course> studentCourses = checkLogin.getStudentCourses(email);
				System.out.println("My Clasess ");
				for(Course co: studentCourses) {
					System.out.println(co.getcName() + "    " + co.getcInstructorName());
				}
				
				System.out.println("Please Select one of the options below ");
				System.out.println("1. Register for course");
				System.out.println("2. Logout");
				int userChoice = input.nextInt();
				if(userChoice ==  1) {
					CourseService cs = new CourseService(); 
					List<Course> allCourses = cs.getAllCourses();
					for(Course oneCourse: allCourses) {
						System.out.println(oneCourse.getcId() + " " + oneCourse.getcName() + "   " + oneCourse.getcInstructorName());
					}
					
					System.out.print("Which Course");
					Scanner scanner = new Scanner(System.in); 
					int coNum = scanner.nextInt(); 
					
					
					//Check if student is already registered or not 
					boolean check = false; 
					for(Course course: checkLogin.getStudentCourses(email)) {
						if(course.getcId() == coNum) {
							check = true; 
						}else {
							check = false; 
						}
					}
					
					//if the student already registered then print that to the console
					
					if(check == true) {
						System.out.print("You already registered in this class");
					} else {
						
						//Register the student 
						//StudentService s = new StudentService();
						checkLogin.registerStudentToCourse(email, coNum);
						
						
						//Printing the updated course list 
						List<Course> updatedCourses = checkLogin.getStudentCourses(email);
						System.out.println("My Classes");
						for(Course getCo: updatedCourses) {
							System.out.println(getCo.getcId() + " " + getCo.getcName() + " " + getCo.getcInstructorName());
						}
					}
				}else if (userInput == 2) {
					System.out.print("You logged out");
					System.exit(0); 
				}
				
			} else {
				System.out.println("The is not such student, please try again");
			}
	
		}else if(userInput == 2 ){
			
			System.out.print("Thank you");
			System.exit(0);
		} else {
			System.out.print("You can only enter 1 o 2 ");
		}
		
		} catch(NullPointerException e) {
			System.out.println("Email and Password can't be null"); 
		}
	}

}
