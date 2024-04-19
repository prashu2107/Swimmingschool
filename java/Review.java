public class Review {
    private Learner learner;
    private String review;
    private int rating;

    public Review(Learner learner, String review, int rating) {
        this.learner = learner;
        this.review = review;
        this.rating = rating;
    }

    public Learner getLearner() {
        return learner;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

    // Additional methods can be added here as needed
}
