import java.util.List;
import java.util.Scanner;

public class LearnerManager {
    private List<Learner> learners;

    public LearnerManager(List<Learner> learners) {
        this.learners = learners;
    }

    public void managingLearnersMenu(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            // Display managing learners menu options
            System.out.println("Managing Learners Menu:");
            System.out.println("1. Add Learner");
            System.out.println("2. Remove Learner");
            System.out.println("3. Update Learner Details");
            System.out.println("4. Back");

            // Get user input
            int option = scanner.nextInt();

            // Process user input
            switch (option) {
                case 1:
                    addLearner(scanner);
                    break;
                case 2:
                    removeLearner(scanner);
                    break;
                case 3:
                    updateLearnerDetails(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addLearner(Scanner scanner) {
        System.out.println("Enter learner details:");

        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("Gender: ");
        String gender = scanner.next();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        System.out.print("Emergency contact phone number: ");
        String emergencyContact = scanner.next();

        System.out.print("Current grade level: ");
        int gradeLevel = scanner.nextInt();

        // Create a new learner object and add it to the learners list
        Learner learner = new Learner(name, gender, age, emergencyContact, gradeLevel);
        learners.add(learner);

        System.out.println("Learner added successfully.");
    }

    private void removeLearner(Scanner scanner) {
        System.out.print("Enter name of the learner to remove: ");
        String name = scanner.next();

        // Find the learner with the specified name
        Learner learnerToRemove = null;
        for (Learner learner : learners) {
            if (learner.getName().equalsIgnoreCase(name)) {
                learnerToRemove = learner;
                break;
            }
        }

        // Remove the learner if found
        if (learnerToRemove != null) {
            learners.remove(learnerToRemove);
            System.out.println("Learner removed successfully.");
        } else {
            System.out.println("Learner not found.");
        }
    }

    private void updateLearnerDetails(Scanner scanner) {
        System.out.print("Enter name of the learner to update details: ");
        String name = scanner.next();

        // Find the learner with the specified name
        Learner learnerToUpdate = null;
        for (Learner learner : learners) {
            if (learner.getName().equalsIgnoreCase(name)) {
                learnerToUpdate = learner;
                break;
            }
        }

        // Update learner details if found
        if (learnerToUpdate != null) {
            System.out.println("Enter new details for the learner:");
            System.out.print("Gender: ");
            String gender = scanner.next();
            learnerToUpdate.setGender(gender);

            System.out.print("Age: ");
            int age = scanner.nextInt();
            learnerToUpdate.setAge(age);

            System.out.print("Emergency contact phone number: ");
            String emergencyContact = scanner.next();
            learnerToUpdate.setEmergencyContact(emergencyContact);

            System.out.print("Current grade level: ");
            int gradeLevel = scanner.nextInt();
            learnerToUpdate.setGradeLevel(gradeLevel);

            System.out.println("Learner details updated successfully.");
        } else {
            System.out.println("Learner not found.");
        }
    }
}
