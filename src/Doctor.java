import java.util.ArrayList;

public class Doctor {
    public int doctorId;
    public String name;
    public String specialization;
    public ArrayList<Integer> assignedPatients;

    public Doctor(int doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.assignedPatients = new ArrayList<>();
    }
}