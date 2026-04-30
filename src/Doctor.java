import java.util.ArrayList;

public class Doctor extends Person{
    public int doctorId;
    public String specialization;
    public ArrayList<Integer> assignedPatients;

    public Doctor(int doctorId, String name, String specialization) {
        super(name);
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.assignedPatients = new ArrayList<>();
    }
}