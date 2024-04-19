import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReviewManager {
    private List<SwimLesson> lessons;
    private List<Learner> learners;

    public ReviewManager(List<SwimLesson> lessons, List<Learner> learners) {
        this.lessons = lessons;
        this.learners = learners;
    }

    public void reviewsAndRatingsMenu(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            // Display reviews and ratings menu options
            System.out.println("Reviews and Ratings Menu:");
            System.out.println("1. Write Review and Rate Lesson");
            System.out.println("2. Back");

            // Get user input
            int option = scanner.nextInt();

            // Process user input
            switch (option) {
                case 1:
                    writeReviewAndRateLesson(scanner);
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void writeReviewAndRateLesson(Scanner scanner) {
        System.out.print("Enter your name: ");
        String learnerName = scanner.next();

        // Find the learner with the specified name
        Learner learner = findLearnerByName(learnerName);
        if (learner == null) {
            System.out.println("Learner not found.");
            return;
        }

        // Display lessons attended by the learner
        System.out.println("Lessons attended by " + learner.getName() + ":");
        List<SwimLesson> attendedLessons = learner.getAttendedLessons();
        for (SwimLesson lesson : attendedLessons) {
            System.out.println(lesson);
        }

        // Prompt user to select a lesson to review and rate
        System.out.print("Enter date of the lesson to review (yyyy-MM-dd): ");
        String dateString = scanner.next();
        // Parse the date string into a Date object using SimpleDateFormat
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            return;
        }

        // Find the lesson with the specified date
        SwimLesson lessonToReview = null;
        for (SwimLesson lesson : attendedLessons) {
            if (lesson.getDate().equals(date)) {
                lessonToReview = lesson;
                break;
            }
        }

        // Write review and rate the lesson if found
        if (lessonToReview != null) {
            System.out.print("Write your review: ");
            String review = scanner.next();

            System.out.print("Rate the lesson (1-5): ");
            int rating = scanner.nextInt();
            if (rating < 1 || rating > 5) {
                System.out.println("Invalid rating. Rating must be between 1 and 5.");
                return;
            }

            // Add review and rating to the lesson
            lessonToReview.addReview(new Review(learner, review, rating));
            System.out.println("Review and rating added successfully.");
        } else {
            System.out.println("Lesson not found.");
        }
    }

    private Learner findLearnerByName(String name) {
        for (Learner learner : learners) {
            if (learner.getName().equalsIgnoreCase(name)) {
                return learner;
            }
        }
        return null;
    }
}
