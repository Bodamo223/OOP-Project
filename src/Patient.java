public class Patient extends Person{
    public int patientId;
    public String address;
    public int age;
    public String bloodType;
    public String healthNotes;

    public Patient(int patientId, String name, String phone, String address, int age, String bloodType, String healthNotes) {
        super(name, phone);
        this.patientId = patientId;
        this.address = address;
        this.age = age;
        this.bloodType = bloodType;
        this.healthNotes = healthNotes;
    }
}