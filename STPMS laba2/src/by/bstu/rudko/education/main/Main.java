package by.bstu.rudko.education.main;

import by.bstu.rudko.education.educationmanager.IAction;
import by.bstu.rudko.education.educationmanager.Manager;
import by.bstu.rudko.education.exception.EduException;
import by.bstu.rudko.education.units.Listener;
import by.bstu.rudko.education.units.Student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws EduException {
        String courseName;
        Manager manager = IAction.getManager();
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        String s = "";
        while (!"0".equals(s)) {
            System.out.println("1) Create a course");
            System.out.println("2) Display a list of course participants");
            System.out.println("3) Add a student to the course");
            System.out.println("4) Add a listener to the course");
            System.out.println("5) Show rating of the top 3 students");
            System.out.println("6) Add participants from a file");
            System.out.println("7) default method");
            System.out.println("0) Exit");

            s = scanner.nextLine();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }

            switch (x) {
                case 1:
                    System.out.println("Enter the course name");
                    courseName = scanner.nextLine();
                    manager.createCourse(courseName);
                    break;
                case 2:
                    System.out.println("List of courses:");
                    manager.PrintAllCourses();
                    System.out.println("Enter The Course:");
                    courseName = scanner.nextLine();
                    manager.PrinfAllMembersOfCours(courseName);
                    break;
                case 3:
                    try {
                        System.out.println("Enter the course name");
                        courseName = scanner.nextLine();
                        System.out.println("Enter the student's name");
                        String studentName = scanner.nextLine();
                        System.out.println("Enter the student's age");
                        String studentAge = scanner.nextLine();
                        int Age = Integer.parseInt(studentAge);
                        if (Age > 100 || Age < 18) {
                            System.out.println("Age must be correct");
                            break;
                        }
                        manager.addPersonToCourse(courseName, new Student(studentName, Age));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid value entered");
                        break;
                    }
                case 4:
                    System.out.println("Enter the course name");
                    courseName = scanner.nextLine();
                    System.out.println("Enter a name:");
                    String listenerName = scanner.nextLine();
                    manager.addPersonToCourse(courseName, new Listener(listenerName));
                case 5:
                    System.out.println("Enter the course name");
                    courseName = scanner.nextLine();
                    manager.GetThreeBestStudents(courseName);
                    break;
                case 6:
                    System.out.println("Enter the course name");
                    courseName = scanner.nextLine();
                    manager.loadJSONFile(courseName);
                case 7:
                    manager.defaultMethod();

            }

        }
        System.out.println("Goodbye!");
    }
}
