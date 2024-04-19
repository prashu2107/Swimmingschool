import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class LessonManager {
    private List<SwimLesson> lessons;
    private List<Coach> coaches;

    public LessonManager(List<SwimLesson> lessons, List<Coach> coaches) {
        this.lessons = lessons;
        this.coaches = coaches;
    }

    public void managingLessonsMenu(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            // Display managing lessons menu options
            System.out.println("Managing Lessons Menu:");
            System.out.println("1. Add Lesson");
            System.out.println("2. Remove Lesson");
            System.out.println("3. Back");

            // Get user input
            int option = scanner.nextInt();

            // Process user input
            switch (option) {
                case 1:
                    addLesson(scanner);
                    break;
                case 2:
                    removeLesson(scanner);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addLesson(Scanner scanner) {
        System.out.println("Enter lesson details:");

        // Get lesson details from the user
        try {
            System.out.print("Date (yyyy-MM-dd): ");
            String dateString = scanner.next();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

            System.out.print("Start time (HH:mm): ");
            String startTime = scanner.next();

            System.out.print("End time (HH:mm): ");
            String endTime = scanner.next();

            System.out.print("Grade level: ");
            int gradeLevel = scanner.nextInt();

            System.out.print("Coach name: ");
            String coachName = scanner.next();
            Coach coach = findCoachByName(coachName);
            if (coach == null) {
                System.out.println("Coach not found.");
                return;
            }

            // Create a new TimeSlot object with the provided start and end times
            TimeSlot timeSlot = new TimeSlot(DayOfWeek.MONDAY, startTime, endTime);

            // Create an empty list of reviews
            List<Review> reviews = new ArrayList<>();

            // Create a new SwimLesson object and add it to the lessons list
            SwimLesson lesson = new SwimLesson(date, timeSlot, gradeLevel, coach, reviews);
            lessons.add(lesson);

            System.out.println("Lesson added successfully.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
        }
    }

    private void removeLesson(Scanner scanner) {
        System.out.print("Enter date of the lesson to remove (yyyy-MM-dd): ");
        String dateString = scanner.next();

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

            // Find the lesson with the specified date
            SwimLesson lessonToRemove = null;
            for (SwimLesson lesson : lessons) {
                if (lesson.getDate().equals(date)) {
                    lessonToRemove = lesson;
                    break;
                }
            }

            // Remove the lesson if found
            if (lessonToRemove != null) {
                lessons.remove(lessonToRemove);
                System.out.println("Lesson removed successfully.");
            } else {
                System.out.println("Lesson not found.");
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
        }
    }

    private Coach findCoachByName(String coachName) {
        for (Coach coach : coaches) {
            if (coach.getName().equalsIgnoreCase(coachName)) {
                return coach;
            }
        }
        return null;
    }
}
