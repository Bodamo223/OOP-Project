import java.util.ArrayList;

public class Doctor extends Person {
    public int doctorId;
    public String specialization;
    public ArrayList<Integer> assignedPatients;

    public Doctor(int doctorId, String name, String phone, String specialization) {
        super(name, phone);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.assignedPatients = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Doctor [ID=" + doctorId + ", Name=" + name +
                ", Specialization=" + specialization +
                ", Assigned Patients=" + assignedPatients.size() + "]";
    }

    public static void showDoctors() {
        if (Hospital.doctors.isEmpty()) {
            System.out.println("No doctors in the system.");
            return;
        }
        System.out.println("All Doctors:");
        for (Doctor d : Hospital.doctors) System.out.println(d);
    }

    public static void assignPatient() {
        System.out.print("Enter doctor ID: ");
        String docInput = Hospital.scanner.nextLine().trim();
        System.out.print("Enter patient ID: ");
        String patInput = Hospital.scanner.nextLine().trim();

        Doctor foundDoc = null;
        for (Doctor d : Hospital.doctors) {
            if (String.valueOf(d.doctorId).equals(docInput)) {
                foundDoc = d;
                break;
            }
        }
        if (foundDoc == null) {
            System.out.println("Doctor not found.");
            return;
        }

        boolean patientExists = false;
        for (Patient p : Hospital.patients) {
            if (String.valueOf(p.getId()).equals(patInput)) {
                patientExists = true;
                break;
            }
        }
        if (!patientExists) {
            System.out.println("Patient not found.");
            return;
        }

        int patId = Integer.parseInt(patInput);
        if (foundDoc.assignedPatients.contains(patId)) {
            System.out.println("Patient is already assigned to this doctor.");
            return;
        }

        foundDoc.assignedPatients.add(patId);
        System.out.println("Patient " + patInput + " assigned to " + foundDoc.name + " successfully.");
    }

    public static void showDoctorPatients() {
        System.out.print("Enter doctor ID: ");
        String docInput = Hospital.scanner.nextLine().trim();

        Doctor foundDoc = null;
        for (Doctor d : Hospital.doctors) {
            if (String.valueOf(d.doctorId).equals(docInput)) {
                foundDoc = d;
                break;
            }
        }
        if (foundDoc == null) {
            System.out.println("Doctor not found.");
            return;
        }

        if (foundDoc.assignedPatients.isEmpty()) {
            System.out.println("No patients assigned to " + foundDoc.name + ".");
            return;
        }

        System.out.println("Patients assigned to " + foundDoc.name + ":");
        for (int patId : foundDoc.assignedPatients) {
            boolean found = false;
            for (Patient p : Hospital.patients) {
                if (p.getId() == patId) {
                    System.out.println(p);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Patient ID " + patId + " not found.");
        }
    }
}