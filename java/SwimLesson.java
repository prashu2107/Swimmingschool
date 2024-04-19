import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SwimLesson {
    private String date;
    private String time;
    private int gradeLevel;
    private Coach coach;
    private List<Review> reviews;
    private List<Learner> bookedLearners;

    // First constructor
    public SwimLesson(String date, String time, int gradeLevel, Coach coach, List<Review> reviews) {
        this.date = date;
        this.time = time;
        this.gradeLevel = gradeLevel;
        this.coach = coach;
        this.reviews = reviews;
        this.bookedLearners = new ArrayList<>();
    }

    // Second constructor
    public SwimLesson(Date date, TimeSlot timeSlot, int gradeLevel, Coach coach, List<Review> reviews) {
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(date);
        this.time = timeSlot.getStartTime() + " - " + timeSlot.getEndTime();
        this.gradeLevel = gradeLevel;
        this.coach = coach;
        this.reviews = reviews;
        this.bookedLearners = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public Coach getCoach() {
        return coach;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    // Method to add a review to the lesson
    public void addReview(Review review) {
        reviews.add(review);
    }

    // Method to remove a review from the lesson
    public void removeReview(Review review) {
        reviews.remove(review);
    }

    // Method to calculate the average rating of the lesson based on reviews
    public double calculateAverageRating() {
        if (reviews.isEmpty()) {
            return 0.0;
        }
        double totalRating = 0;
        for (Review review : reviews) {
            totalRating += review.getRating();
        }
        return totalRating / reviews.size();
    }

    // Method to check if a specific learner is booked for the lesson
    public boolean isLearnerBooked(Learner learner) {
        for (Learner bookedLearner : bookedLearners) {
            if (bookedLearner.getName().equals(learner.getName())) {
                return true; // Learner is booked for this lesson
            }
        }
        return false; // Learner is not booked for this lesson
    }

    // Method to book a learner for the lesson
    public void bookLearner(Learner learner) {
        bookedLearners.add(learner);
    }

    // Method to remove a learner from the lesson
    public void removeLearner(Learner learner) {
        bookedLearners.remove(learner);
    }

    // Method to get the number of available spots for the lesson
    public int getAvailableSpots() {
        // Assume a fixed capacity for the lesson and calculate available spots
        int capacity = 20; // You can adjust this value as needed
        return capacity - bookedLearners.size();
    }
}
