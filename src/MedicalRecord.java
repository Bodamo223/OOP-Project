public class MedicalRecord {
    public int patientId;
    public String date;
    public String diagnosis;
    public String doctorName;
    public String prescription;

    public MedicalRecord(int patientId, String date, String diagnosis, String doctorName, String prescription) {
        this.patientId = patientId;
        this.date = date;
        this.diagnosis = diagnosis;
        this.doctorName = doctorName;
        this.prescription = prescription;
    }
}