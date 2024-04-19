import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private int experienceYears;
    private List<String> specialties;

    public Coach(String name, int experienceYears, List<String> specialties) {
        this.name = name;
        this.experienceYears = experienceYears;
        this.specialties = specialties;
    }

    public String getName() {
        return name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void addSpecialty(String specialty) {
        specialties.add(specialty);
    }

    public void removeSpecialty(String specialty) {
        specialties.remove(specialty);
    }

    // Additional methods can be added here as needed
}
