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

    public static void loadSampleData() {
        setupUsers();
        patients.add(new Patient(1, "Ahmed Ali", 30, "Male", "address"));
        patients.add(new Patient(2, "Sara Mohamed", 25, "Female", "address"));
        doctors.add(new Doctor(1, "Dr. Khaled", "01011111111", "Cardiology"));
        doctors.add(new Doctor(2, "Dr. Nour", "01022222222", "Surgery"));
        rooms.add(new Room(101, "Normal"));
        rooms.add(new Room(102, "Normal"));
        rooms.add(new Room(201, "ICU"));
    }
}
