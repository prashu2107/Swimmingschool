import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookingManager {
    private List<SwimLesson> lessons;
    private List<Learner> learners;

    public BookingManager(List<SwimLesson> lessons, List<Learner> learners) {
        this.lessons = lessons;
        this.learners = learners;
    }

    public void bookingAndCancelingLessonsMenu(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            // Display booking and canceling lessons menu options
            System.out.println("Booking and Cancelling Lessons Menu:");
            System.out.println("1. Book Lesson");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Back");

            // Get user input
            int option = scanner.nextInt();

            // Process user input
            switch (option) {
                case 1:
                    bookLesson(scanner);
                    break;
                case 2:
                    cancelBooking(scanner);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void bookLesson(Scanner scanner) {
        System.out.print("Enter your name: ");
        String learnerName = scanner.next();

        // Find the learner with the specified name
        Learner learner = findLearnerByName(learnerName);
        if (learner == null) {
            System.out.println("Learner not found.");
            return;
        }

        // Display available lessons
        System.out.println("Available Lessons:");
        for (SwimLesson lesson : lessons) {
            if (lesson.getGradeLevel() <= learner.getGradeLevel() + 1) {
                System.out.println(lesson);
            }
        }

        // Prompt user to select a lesson to book
        System.out.print("Enter date of the lesson to book (yyyy-MM-dd): ");
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
        SwimLesson lessonToBook = null;
        for (SwimLesson lesson : lessons) {
            if (lesson.getDate().equals(date)) {
                lessonToBook = lesson;
                break;
            }
        }

        // Book the lesson if found
        if (lessonToBook != null) {
            if (lessonToBook.getAvailableSpots() > 0) {
                lessonToBook.bookLearner(learner);
                System.out.println("Lesson booked successfully.");
            } else {
                System.out.println("No available spots for this lesson.");
            }
        } else {
            System.out.println("Lesson not found.");
        }
    }

    private void cancelBooking(Scanner scanner) {
        System.out.print("Enter your name: ");
        String learnerName = scanner.next();

        // Find the learner with the specified name
        Learner learner = findLearnerByName(learnerName);
        if (learner == null) {
            System.out.println("Learner not found.");
            return;
        }

        // Display lessons booked by the learner
        System.out.println("Lessons booked by " + learner.getName() + ":");
        List<SwimLesson> bookedLessons = learner.getBookedLessons();
        for (SwimLesson lesson : bookedLessons) {
            System.out.println(lesson);
        }

        // Prompt user to select a lesson to cancel
        System.out.print("Enter date of the lesson to cancel booking (yyyy-MM-dd): ");
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
        SwimLesson lessonToCancel = null;
        for (SwimLesson lesson : bookedLessons) {
            if (lesson.getDate().equals(date)) {
                lessonToCancel = lesson;
                break;
            }
        }

        // Cancel the booking if found
        if (lessonToCancel != null) {
            lessonToCancel.removeLearner(learner);
            System.out.println("Booking canceled successfully.");
        } else {
            System.out.println("Booking not found.");
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
