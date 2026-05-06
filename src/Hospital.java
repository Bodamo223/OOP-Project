import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    public static Scanner scanner = new Scanner(System.in);

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static ArrayList<Doctor> doctors = new ArrayList<>();
    public static ArrayList<Surgery> surgeries = new ArrayList<>();
    public static ArrayList<Room> rooms = new ArrayList<>();
    public static ArrayList<Bill> bills = new ArrayList<>();
    public static ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();

    public static void setupUsers() {
        users.add(new User("Abdallah", "12345", "Admin"));
        users.add(new User("Omar", "123", "Doctor"));
        users.add(new User("patient1", "pass", "Patient"));
    }

    public static User login(String name, String password) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        System.out.println("Invalid credentials. Please try again.\n");
        return null;
    }

    public static void handleUserRole(User user) {
        if (user == null) return;
        String role = user.getRole().toLowerCase();
        System.out.println("Welcome, " + user.getName() + " [" + user.getRole() + "]!\n");
        if (role.equals("admin")) {
            adminMenu();
        } else if (role.equals("doctor")) {
            doctorMenu();
        } else {
            patientMenu();
        }
    }

    public static void adminMenu() {
        while (true) {
            System.out.println("\n========= Admin Menu =========");
            System.out.println(" 1.  Add Patient");
            System.out.println(" 2.  Search Patient");
            System.out.println(" 3.  Modify Patient");
            System.out.println(" 4.  View All Patients");
            System.out.println(" 5.  Get Medical History");
            System.out.println(" 6.  Add Medical Record");
            System.out.println(" 7.  Show Doctors");
            System.out.println(" 8.  Assign Patient to Doctor");
            System.out.println(" 9.  Show Doctor's Patients");
            System.out.println(" 10. Show Rooms");
            System.out.println(" 11. Reserve Room");
            System.out.println(" 12. Release Room");
            System.out.println(" 13. Schedule Surgery");
            System.out.println(" 14. Show Surgeries");
            System.out.println(" 15. Cancel Surgery");
            System.out.println(" 16. Generate Bill");
            System.out.println(" 17. Mark Bill as Paid");
            System.out.println(" 18. View All Bills");
            System.out.println(" 0.  Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":  Patient.addPatient(); break;
                case "2":  Patient.searchPatient(); break;
                case "3":  Patient.modifyPatient(); break;
                case "4":  Patient.viewAllPatients(); break;
                case "5":  MedicalRecord.getHistory(); break;
                case "6":  MedicalRecord.addRecord(); break;
                case "7":  Doctor.showDoctors(); break;
                case "8":  Doctor.assignPatient(); break;
                case "9":  Doctor.showDoctorPatients(); break;
                case "10": Room.showRooms(); break;
                case "11": Room.reserveRoom(); break;
                case "12": Room.releaseRoom(); break;
                case "13": Surgery.scheduleSurgery(); break;
                case "14": Surgery.showSurgeries(); break;
                case "15": Surgery.cancelSurgery(); break;
                case "16": Bill.generateBill(); break;
                case "17": Bill.markAsPaid(); break;
                case "18": Bill.viewAllBills(); break;
                case "0":  System.out.println("Goodbye!"); return;
                default:   System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void doctorMenu() {
        while (true) {
            System.out.println("\n========= Doctor Menu =========");
            System.out.println(" 1. View All Patients");
            System.out.println(" 2. Search Patient");
            System.out.println(" 3. Get Medical History");
            System.out.println(" 4. Show Doctors");
            System.out.println(" 5. Show My Patients");
            System.out.println(" 6. Show Surgeries");
            System.out.println(" 7. Schedule Surgery");
            System.out.println(" 8. Show Rooms");
            System.out.println(" 0. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1": Patient.viewAllPatients(); break;
                case "2": Patient.searchPatient(); break;
                case "3": MedicalRecord.getHistory(); break;
                case "4": Doctor.showDoctors(); break;
                case "5": Doctor.showDoctorPatients(); break;
                case "6": Surgery.showSurgeries(); break;
                case "7": Surgery.scheduleSurgery(); break;
                case "8": Room.showRooms(); break;
                case "0": System.out.println("Goodbye!"); return;
                default:  System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void patientMenu() {
        while (true) {
            System.out.println("\n========= Patient Menu =========");
            System.out.println(" 1. Search Patient");
            System.out.println(" 2. Get Medical History");
            System.out.println(" 3. View All Bills");
            System.out.println(" 0. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1": Patient.searchPatient(); break;
                case "2": MedicalRecord.getHistory(); break;
                case "3": Bill.viewAllBills(); break;
                case "0": System.out.println("Goodbye!"); return;
                default:  System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void loadSampleData() {
        setupUsers();

        patients.add(new Patient(1, "Ahmed Ali",    "01011111111", 30, "Male",   "Cairo",       "A+", "None"));
        patients.add(new Patient(2, "Sara Mohamed", "01022222222", 25, "Female", "Giza",         "B+", "Diabetes"));
        patients.add(new Patient(3, "Khaled Hassan","01033333333", 45, "Male",   "Alexandria",   "O-", "Hypertension"));

        doctors.add(new Doctor(1, "Dr. Khaled", "01044444444", "Cardiology"));
        doctors.add(new Doctor(2, "Dr. Nour",   "01055555555", "Surgery"));
        doctors.add(new Doctor(3, "Dr. Rania",  "01066666666", "Pediatrics"));

        rooms.add(new Room(101, "Normal"));
        rooms.add(new Room(102, "Normal"));
        rooms.add(new Room(103, "Normal"));
        rooms.add(new Room(201, "ICU"));
        rooms.add(new Room(202, "ICU"));

        surgeries.add(new Surgery(1, "Ahmed Ali", "Dr. Nour", "Appendectomy", "10/06/2025"));

        bills.add(new Bill(1, 1, "Ahmed Ali", 600.0, 1500.0));

        medicalRecords.add(new MedicalRecord(1, "01/01/2025", "Flu",         "Dr. Khaled", "Paracetamol"));
        medicalRecords.add(new MedicalRecord(1, "15/03/2025", "Back Pain",   "Dr. Rania",  "Ibuprofen"));
        medicalRecords.add(new MedicalRecord(2, "10/02/2025", "Diabetes checkup", "Dr. Khaled", "Metformin"));
    }
}