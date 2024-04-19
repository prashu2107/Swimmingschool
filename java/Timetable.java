public class Timetable {
    public static void displayTimetable() {
        String[] daysOfWeek = {"Monday", "Wednesday", "Friday"};
        String[] coaches = {"Coach 1", "Coach 2", "Coach 3", "Coach 4"};

        // Define timetable for 4 weeks
        String[][][] timetable = {
            // Week 1
            {
                {"9:00 AM", "11:00 AM"}, // Monday
                {"9:00 AM", "11:00 AM"}, // Wednesday
                {"9:00 AM", "11:00 AM"}  // Friday
            },
            // Week 2
            {
                {"9:00 AM", "11:00 AM"}, // Monday
                {"9:00 AM", "11:00 AM"}, // Wednesday
                {"9:00 AM", "11:00 AM"}  // Friday
            },
            // Week 3
            {
                {"9:00 AM", "11:00 AM"}, // Monday
                {"9:00 AM", "11:00 AM"}, // Wednesday
                {"9:00 AM", "11:00 AM"}  // Friday
            },
            // Week 4
            {
                {"9:00 AM", "11:00 AM"}, // Monday
                {"9:00 AM", "11:00 AM"}, // Wednesday
                {"9:00 AM", "11:00 AM"}  // Friday
            }
        };

        // Display timetable
        System.out.println("Timetable for the next 4 weeks:");
        System.out.println("-------------------------------------------");
        System.out.printf("%-10s", "Day");
        for (String coach : coaches) {
            System.out.printf("%-15s", coach);
        }
        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.printf("%-10s", daysOfWeek[i]);
            for (int j = 0; j < 4; j++) {
                String[] lessons = timetable[j][i];
                for (String lesson : lessons) {
                    System.out.printf("%-15s", lesson);
                }
            }
            System.out.println();
        }
    }
}
