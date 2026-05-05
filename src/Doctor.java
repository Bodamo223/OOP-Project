import java.util.ArrayList;

public class Doctor extends Person{
    public int doctorId;
    public String specialization;
    public ArrayList<Integer> assignedPatients;

    public Doctor(int doctorId, String name, String phone, String specialization) {
        super(name, phone);
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.assignedPatients = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ID: " + doctorId + " | Name: " + name + " | Specialization: " + specialization;
    }
}