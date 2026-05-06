import java.util.ArrayList;

public class Patient extends Person {
    public int id;
    public int age;
    public String gender;
    public String address;
    public String bloodType;
    public String healthNotes;

    public Patient(int id, String name, String phone, int age, String gender,
                   String address, String bloodType, String healthNotes) {
        super(name, phone);
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.bloodType = bloodType;
        this.healthNotes = healthNotes;
    }

    public int getId()            { return id; }
    public String getName()       { return name; }
    public void setName(String n) { this.name = n; }
    public String getPhone()      { return phone; }
    public void setPhone(String p){ this.phone = p; }
    public int getAge()           { return age; }
    public void setAge(int a)     { this.age = a; }
    public String getGender()     { return gender; }
    public void setGender(String g){ this.gender = g; }
    public String getAddress()    { return address; }
    public void setAddress(String a){ this.address = a; }
    public String getBloodType()  { return bloodType; }
    public void setBloodType(String b){ this.bloodType = b; }
    public String getHealthNotes(){ return healthNotes; }
    public void setHealthNotes(String h){ this.healthNotes = h; }

    @Override
    public String toString() {
        return "Patient [ID=" + id + ", Name=" + name + ", Phone=" + phone +
                ", Age=" + age + ", Gender=" + gender + ", Address=" + address +
                ", Blood=" + bloodType + ", Notes=" + healthNotes + "]";
    }

    public static void addPatient() {
        System.out.print("Enter patient name: ");
        String inputName = Hospital.scanner.nextLine().trim();
        while (inputName.isEmpty()) {
            System.out.println("Name cannot be empty. Try again.");
            System.out.print("Enter patient name: ");
            inputName = Hospital.scanner.nextLine().trim();
        }

        System.out.print("Enter patient phone: ");
        String inputPhone = Hospital.scanner.nextLine().trim();
        while (inputPhone.isEmpty()) {
            System.out.println("Phone cannot be empty. Try again.");
            System.out.print("Enter patient phone: ");
            inputPhone = Hospital.scanner.nextLine().trim();
        }

        int inputAge = -1;
        while (inputAge <= 0) {
            System.out.print("Enter patient age: ");
            String ageStr = Hospital.scanner.nextLine().trim();
            try {
                inputAge = Integer.parseInt(ageStr);
                if (inputAge <= 0) System.out.println("Age must be a positive number. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Age must be a number. Try again.");
            }
        }

        System.out.print("Enter patient gender: ");
        String inputGender = Hospital.scanner.nextLine().trim();

        System.out.print("Enter patient address: ");
        String inputAddress = Hospital.scanner.nextLine().trim();

        System.out.print("Enter blood type: ");
        String inputBlood = Hospital.scanner.nextLine().trim();

        System.out.print("Enter health notes: ");
        String inputNotes = Hospital.scanner.nextLine().trim();

        int newId = Hospital.patients.size() + 1;
        Patient patient = new Patient(newId, inputName, inputPhone, inputAge,
                inputGender, inputAddress, inputBlood, inputNotes);
        Hospital.patients.add(patient);
        System.out.println("Patient added successfully! ID: " + newId);
    }

    public static void searchPatient() {
        System.out.print("Enter patient name or ID to search: ");
        String searchInput = Hospital.scanner.nextLine().trim();
        ArrayList<Patient> matches = new ArrayList<>();

        for (Patient patient : Hospital.patients) {
            boolean idMatches = String.valueOf(patient.getId()).equals(searchInput);
            boolean nameMatches = patient.getName().toLowerCase().contains(searchInput.toLowerCase());
            if (idMatches || nameMatches) {
                matches.add(patient);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No patient found.");
        } else {
            System.out.println("Matching patient(s):");
            for (Patient match : matches) System.out.println(match);
        }
    }

    public static void modifyPatient() {
        System.out.print("Enter the ID of the patient to modify: ");
        String idInput = Hospital.scanner.nextLine().trim();

        Patient p = null;
        for (Patient patient : Hospital.patients) {
            if (String.valueOf(patient.getId()).equals(idInput)) {
                p = patient;
                break;
            }
        }

        if (p == null) {
            System.out.println("No patient found with this ID.");
            return;
        }

        System.out.println("Current info: " + p);

        System.out.print("Enter new name [" + p.getName() + "]: ");
        String v = Hospital.scanner.nextLine().trim();
        if (!v.isEmpty()) p.setName(v);

        System.out.print("Enter new phone [" + p.getPhone() + "]: ");
        v = Hospital.scanner.nextLine().trim();
        if (!v.isEmpty()) p.setPhone(v);

        System.out.print("Enter new age [" + p.getAge() + "]: ");
        v = Hospital.scanner.nextLine().trim();
        if (!v.isEmpty()) {
            try { p.setAge(Integer.parseInt(v)); }
            catch (NumberFormatException e) { System.out.println("Invalid age, skipping."); }
        }

        System.out.print("Enter new gender [" + p.getGender() + "]: ");
        v = Hospital.scanner.nextLine().trim();
        if (!v.isEmpty()) p.setGender(v);

        System.out.print("Enter new address [" + p.getAddress() + "]: ");
        v = Hospital.scanner.nextLine().trim();
        if (!v.isEmpty()) p.setAddress(v);

        System.out.print("Enter new blood type [" + p.getBloodType() + "]: ");
        v = Hospital.scanner.nextLine().trim();
        if (!v.isEmpty()) p.setBloodType(v);

        System.out.print("Enter new health notes [" + p.getHealthNotes() + "]: ");
        v = Hospital.scanner.nextLine().trim();
        if (!v.isEmpty()) p.setHealthNotes(v);

        System.out.println("Patient data updated successfully.");
        System.out.println(p);
    }

    public static void viewAllPatients() {
        if (Hospital.patients.isEmpty()) {
            System.out.println("No patients in the system.");
        } else {
            System.out.println("All Patients:");
            for (Patient p : Hospital.patients) System.out.println(p);
        }
    }
}