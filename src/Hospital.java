import java.util.ArrayList;

public class Hospital {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static ArrayList<Doctor> doctors = new ArrayList<>();
    public static ArrayList<Surgery> surgeries = new ArrayList<>();
    public static ArrayList<Room> rooms = new ArrayList<>();
    public static ArrayList<Bill> bills = new ArrayList<>();
    public static ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();

    public static void setupUsers(){
        users.add(new User("Abdallah", "12345", "Admin"));
        users.add(new User("Omar", "123", "Doctor"));
        users.add(new User("Assem", "1234", "Patient"));
    }

    public static User login(String name, String password){
        for (User user : users){
            if(user.getName().equalsIgnoreCase(name) && user.getPassword().equalsIgnoreCase(password)){
                return user;
            }
        }
        System.out.println("Invalid Credentials");
        return null;
    }

    public static void handleUserRole(User user) {
        if (user == null) return;
        if (user.getRole().equalsIgnoreCase("Admin")) {
            // adminMenu()
            System.out.println("Welcome Admin: " + user.getName());
        } else if (user.getRole().equalsIgnoreCase("Doctor")) {
            // doctorMenu()
            System.out.println("Welcome Doctor: " + user.getName());
        } else if (user.getRole().equalsIgnoreCase("Patient")) {
            //  patientMenu()
            System.out.println("Welcome Patient: " + user.getName());
        }
    }
}
