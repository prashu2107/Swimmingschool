import java.util.List;
import java.util.Scanner;

public class SwimmingSchoolManager {
    private List<SwimLesson> lessons;
    private List<Coach> coaches;
    private List<Learner> learners;

    public SwimmingSchoolManager(List<SwimLesson> lessons, List<Coach> coaches, List<Learner> learners) {
        this.lessons = lessons;
        this.coaches = coaches;
        this.learners = learners;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            // Display main menu options
            System.out.println("Main Menu:");
            System.out.println("1. Manage Lessons");
            System.out.println("2. Manage Learners");
            System.out.println("3. Write Reviews and Rate Lessons");
            System.out.println("4. Exit");
            
            // Get user input
            int option = scanner.nextInt();
            
            // Process user input
            switch (option) {
                case 1:
                    LessonManager lessonManager = new LessonManager(lessons, coaches);
                    lessonManager.managingLessonsMenu(scanner);
                    break;
                case 2:
                    LearnerManager learnerManager = new LearnerManager(learners);
                    learnerManager.managingLearnersMenu(scanner);
                    break;
                case 3:
                    ReviewManager reviewManager = new ReviewManager(lessons, learners);
                    reviewManager.reviewsAndRatingsMenu(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
        scanner.close();
    }
}
