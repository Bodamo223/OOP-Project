public class Patient {
    public int id;
    public String name;
    public String phone;
    public String address;
    public int age;
    public String bloodType;
    public String healthNotes;

    public Patient(int id, String name, String phone, String address, int age, String bloodType, String healthNotes) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.bloodType = bloodType;
        this.healthNotes = healthNotes;
    }
}