import java.util.Scanner;
import java.util.List;

public class ReportManager {
    private List<Learner> learners;
    private List<SwimLesson> lessons;
    private Scanner scanner;

    public ReportManager(List<Learner> learners, List<SwimLesson> lessons, Scanner scanner) {
        this.learners = learners;
        this.lessons = lessons;
        this.scanner = scanner;
    }

    public void reportingMenu() {
        boolean exit = false;
        while (!exit) {
            // Display reporting menu options
            System.out.println("Reporting Menu:");
            System.out.println("1. View Learner Details");
            System.out.println("2. View Lesson Details");
            System.out.println("3. Back");

            // Get user input
            int option;
            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.next(); // Clear the scanner buffer
                continue;
            }

            // Process user input
            switch (option) {
                case 1:
                    viewLearnerDetails();
                    break;
                case 2:
                    viewLessonDetails();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void viewLearnerDetails() {
        // Display detailed information of each learner
        for (Learner learner : learners) {
            System.out.println("Learner: " + learner.getName());
            System.out.println("Grade Level: " + learner.getGradeLevel());
            // You can add more learner details here if needed
            System.out.println("-----------------------------------");
        }
    }

    private void viewLessonDetails() {
        // Display detailed information of each lesson
        for (SwimLesson lesson : lessons) {
            System.out.println("Date: " + lesson.getDate());
            System.out.println("Time: " + lesson.getTime());
            System.out.println("Grade Level: " + lesson.getGradeLevel());
            System.out.println("Coach: " + lesson.getCoach().getName());
            System.out.println("Available Spots: " + lesson.getAvailableSpots());
            // You may want to display other lesson details here if needed
            System.out.println("-----------------------------------");
        }
    }
}
