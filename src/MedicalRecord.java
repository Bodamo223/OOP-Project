import java.util.Scanner;

public class MedicalRecord {
    public int patientId;
    public String date;
    public String diagnosis;
    public String doctorName;
    public String prescription;

    static Scanner scanner = new Scanner(System.in);

    public MedicalRecord(int patientId, String date, String diagnosis, String doctorName, String prescription) {
        this.patientId = patientId;
        this.date = date;
        this.diagnosis = diagnosis;
        this.doctorName = doctorName;
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Date: " + date + " | Doctor: " + doctorName + " | Diagnosis: " + diagnosis + " | Prescription: " + prescription;
    }

    public static MedicalRecord getHistory(){
        System.out.print("Enter patient ID: ");
        int inputId = 0;
        while (!scanner.hasNextInt()){
            System.out.println("ID must be a number, Try again!");
            System.out.print("Enter patient ID: ");
            scanner.next();
        }
        inputId = scanner.nextInt();

        for (MedicalRecord record : Hospital.medicalRecords){
            if(record.patientId == inputId){
                return record;
            }
        }
        System.out.println("No medical history found for this ID!");
        return null;
    }
}