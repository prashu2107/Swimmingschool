import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {
    private List<Learner> learners;
    private List<Coach> coaches;
    private List<SwimLesson> lessons;

    public ReportGenerator(List<Learner> learners, List<Coach> coaches, List<SwimLesson> lessons) {
        this.learners = learners;
        this.coaches = coaches;
        this.lessons = lessons;
    }

    public void generateReports() {
        // Generate reports
        generateLearnerReport();
        generateCoachReport();
    }

    private void generateLearnerReport() {
        System.out.println("Learner Report:");
        System.out.println("--------------------------------------------------");
        for (Learner learner : learners) {
            System.out.println("Name: " + learner.getName());
            System.out.println("Grade Level: " + learner.getGradeLevel());
            System.out.println("Lessons Booked: " + learner.getBookedLessons().size());
            System.out.println("Lessons Cancelled: " + learner.getCancelledLessons().size());
            System.out.println("Lessons Attended: " + learner.getAttendedLessons().size());
            System.out.println("-----------------------------------------------");
        }
    }

    private void generateCoachReport() {
        System.out.println("Coach Report:");
        System.out.println("--------------------------------------------------");
        for (Coach coach : coaches) {
            System.out.println("Name: " + coach.getName());
            System.out.println("Average Rating: " + calculateAverageRating(coach));
            System.out.println("-----------------------------------------------");
        }
    }

    private double calculateAverageRating(Coach coach) {
        List<Integer> ratings = new ArrayList<>();
        for (SwimLesson lesson : lessons) {
            if (lesson.getCoach().equals(coach)) {
                for (Review review : lesson.getReviews()) {
                    ratings.add(review.getRating());
                }
            }
        }
        if (ratings.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }
}