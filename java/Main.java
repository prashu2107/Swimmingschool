import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<SwimLesson> lessons = new ArrayList<>();
        List<Coach> coaches = new ArrayList<>();
        List<Learner> learners = new ArrayList<>(); 

        // Instantiate LessonManager, LearnerManager, BookingManager, ReviewManager, and ReportManager
        LessonManager lessonManager = new LessonManager(lessons, coaches);
        LearnerManager learnerManager = new LearnerManager(learners);
        BookingManager bookingManager = new BookingManager(lessons, learners);
        ReviewManager reviewManager = new ReviewManager(lessons, learners);
        ReportManager reportManager = new ReportManager(learners, lessons, scanner);

        boolean exit = false;
        while (!exit) {
            // Display main menu options
            System.out.println("Welcome to Hatfield Junior Swimming School!");
            System.out.println("Please select an option:");
            System.out.println("1. View timetable for the next 4 weeks");
            System.out.println("2. Managing Lessons");
            System.out.println("3. Managing Learners");
            System.out.println("4. Booking and Cancelling Lessons");
            System.out.println("5. Reviews and Ratings");
            System.out.println("6. Reporting");
            System.out.println("7. Generate reports");
            System.out.println("8. Exit");

            // Get user input
            int option = scanner.nextInt();

            // Process user input
            switch (option) {
                case 1:
                    Timetable.displayTimetable();
                    break;
                case 2:
                    lessonManager.managingLessonsMenu(scanner);
                    break;
                case 3:
                    learnerManager.managingLearnersMenu(scanner);
                    break;
                case 4:
                    bookingManager.bookingAndCancelingLessonsMenu(scanner);
                    break;
                case 5:
                    reviewManager.reviewsAndRatingsMenu(scanner);
                    break;
                case 6:
                    reportManager.reportingMenu(); 
                    break;
                case 7:
                    // Logic to generate reports
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}
