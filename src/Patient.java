import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    public int id;
    public String name;
    public int age;
    public String gender;
    public String address;

    static Scanner scanner = new Scanner(System.in);

    public Patient(int id, String name, int age, String gender, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Patient [ID=" + id + ", Name=" + name + ", Age=" + age +
                ", Gender=" + gender + ", Address=" + address + "]";
    }

    public static void searchPatient() {
        System.out.print("Enter patient name or ID to search: ");
        String searchInput = scanner.nextLine().trim();
        ArrayList<Patient> matches = new ArrayList<>();

        for (Patient patient : Hospital.patients) {
            boolean idMatches = String.valueOf(patient.getId()).equalsIgnoreCase(searchInput);
            boolean nameMatches = patient.getName().toLowerCase().contains(searchInput.toLowerCase());
            if (idMatches || nameMatches) {
                matches.add(patient);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No patient found.");
        } else {
            System.out.println("Matching patient(s):");
            for (Patient match : matches) {
                System.out.println(match);
            }
        }
    }

    public static void modifyPatient() {
        System.out.print("Enter the ID of the patient to modify: ");
        String idInput = scanner.nextLine().trim();

        Patient patientToModify = null;
        for (Patient patient : Hospital.patients) {
            if (String.valueOf(patient.getId()).equalsIgnoreCase(idInput)) {
                patientToModify = patient;
                break;
            }
        }

        if (patientToModify == null) {
            System.out.println("No patient found with this ID.");
            return;
        }

        System.out.println("Current info: " + patientToModify);

        System.out.print("Enter new name [" + patientToModify.getName() + "]: ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) patientToModify.setName(newName);

        System.out.print("Enter new age [" + patientToModify.getAge() + "]: ");
        String newAgeStr = scanner.nextLine().trim();
        if (!newAgeStr.isEmpty()) {
            try {
                patientToModify.setAge(Integer.parseInt(newAgeStr));
            } catch (NumberFormatException e) {
                System.out.println("Invalid age, skipping update.");
            }
        }

        System.out.print("Enter new gender [" + patientToModify.getGender() + "]: ");
        String newGender = scanner.nextLine().trim();
        if (!newGender.isEmpty()) patientToModify.setGender(newGender);

        System.out.print("Enter new address [" + patientToModify.getAddress() + "]: ");
        String newAddress = scanner.nextLine().trim();
        if (!newAddress.isEmpty()) patientToModify.setAddress(newAddress);

        System.out.println("Data updated successfully.");
    }

    public static void viewAllPatients() {
        if (Hospital.patients.isEmpty()) {
            System.out.println("No patients in the system.");
        } else {
            for (Patient p : Hospital.patients) System.out.println(p);
        }
    }

    public static void addPatient(){
        System.out.print("Enter patient name: ");
        scanner.nextLine();
        String inputName = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int inputAge = 0;
        if(!scanner.hasNextInt()){
            System.out.println("Age must be a number!, Try again");
            System.out.print("Enter patient age: ");
            scanner.next();
        }
        inputAge = scanner.nextInt();

        System.out.print("Enter patient gender: ");
        String inputGender = scanner.nextLine();
        System.out.print("Enter patient address: ");
        String inputAddress = scanner.nextLine();

        int Id = Hospital.patients.size() + 1;

        Patient patient = new Patient(Id, inputName, inputAge, inputGender, inputAddress);
        Hospital.patients.add(patient);

        System.out.println("Patient added successfully!");
    }
}

