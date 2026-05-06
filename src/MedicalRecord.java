public class MedicalRecord {
    public int patientId;
    public String date;
    public String diagnosis;
    public String doctorName;
    public String prescription;

    public MedicalRecord(int patientId, String date, String diagnosis,
                         String doctorName, String prescription) {
        this.patientId = patientId;
        this.date = date;
        this.diagnosis = diagnosis;
        this.doctorName = doctorName;
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Date: " + date + " | Doctor: " + doctorName +
                " | Diagnosis: " + diagnosis + " | Prescription: " + prescription;
    }

    public static void getHistory() {
        System.out.print("Enter patient ID: ");
        String input = Hospital.scanner.nextLine().trim();
        int inputId;
        try {
            inputId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
            return;
        }

        boolean found = false;
        for (MedicalRecord record : Hospital.medicalRecords) {
            if (record.patientId == inputId) {
                System.out.println(record);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No medical history found for this patient.");
        }
    }

    public static void addRecord() {
        System.out.print("Enter patient ID: ");
        String input = Hospital.scanner.nextLine().trim();
        int patientId;
        try {
            patientId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid patient ID.");
            return;
        }

        // Verify patient exists
        boolean exists = false;
        for (Patient p : Hospital.patients) {
            if (p.getId() == patientId) { exists = true; break; }
        }
        if (!exists) {
            System.out.println("Patient ID not found.");
            return;
        }

        System.out.print("Enter date (DD/MM/YYYY): ");
        String date = Hospital.scanner.nextLine().trim();
        System.out.print("Enter diagnosis: ");
        String diagnosis = Hospital.scanner.nextLine().trim();
        System.out.print("Enter doctor name: ");
        String doctorName = Hospital.scanner.nextLine().trim();
        System.out.print("Enter prescription: ");
        String prescription = Hospital.scanner.nextLine().trim();

        Hospital.medicalRecords.add(new MedicalRecord(patientId, date, diagnosis, doctorName, prescription));
        System.out.println("Medical record added successfully.");
    }
}