import java.util.ArrayList;
import java.util.List;

public class Learner {
    private String name;
    private String gender;
    private int age;
    private String emergencyContact;
    private int gradeLevel;
    private List<SwimLesson> bookedLessons;
    private List<SwimLesson> cancelledLessons;
    private List<SwimLesson> attendedLessons;

    public Learner(String name, String gender, int age, String emergencyContact, int gradeLevel) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.emergencyContact = emergencyContact;
        this.gradeLevel = gradeLevel;
        this.bookedLessons = new ArrayList<>();
        this.cancelledLessons = new ArrayList<>();
        this.attendedLessons = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public List<SwimLesson> getBookedLessons() {
        return bookedLessons;
    }

    public List<SwimLesson> getCancelledLessons() {
        return cancelledLessons;
    }

    public List<SwimLesson> getAttendedLessons() {
        return attendedLessons;
    }
}
