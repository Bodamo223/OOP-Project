public class Surgery {
    public int surgeryId;
    public String patientName;
    public String surgeonName;
    public String surgeryType;
    public String scheduledDate;
    public String status;

    public Surgery(int surgeryId, String patientName, String surgeonName,
                   String surgeryType, String scheduledDate) {
        this.surgeryId = surgeryId;
        this.patientName = patientName;
        this.surgeonName = surgeonName;
        this.surgeryType = surgeryType;
        this.scheduledDate = scheduledDate;
        this.status = "Scheduled";
    }

    @Override
    public String toString() {
        return "Surgery [ID=" + surgeryId + ", Patient=" + patientName +
                ", Surgeon=" + surgeonName + ", Type=" + surgeryType +
                ", Date=" + scheduledDate + ", Status=" + status + "]";
    }

    public static void scheduleSurgery() {
        System.out.print("Enter patient name: ");
        String patientName = Hospital.scanner.nextLine().trim();
        System.out.print("Enter surgeon name: ");
        String surgeonName = Hospital.scanner.nextLine().trim();
        System.out.print("Enter surgery type: ");
        String surgeryType = Hospital.scanner.nextLine().trim();
        System.out.print("Enter scheduled date (DD/MM/YYYY): ");
        String date = Hospital.scanner.nextLine().trim();

        int newId = Hospital.surgeries.size() + 1;
        Surgery surgery = new Surgery(newId, patientName, surgeonName, surgeryType, date);
        Hospital.surgeries.add(surgery);
        System.out.println("Surgery scheduled successfully. ID: " + newId);
    }

    public static void showSurgeries() {
        if (Hospital.surgeries.isEmpty()) {
            System.out.println("No surgeries in the system.");
            return;
        }
        System.out.println("All Surgeries:");
        for (Surgery s : Hospital.surgeries) System.out.println(s);
    }

    public static void cancelSurgery() {
        System.out.print("Enter surgery ID to cancel: ");
        String input = Hospital.scanner.nextLine().trim();

        for (Surgery s : Hospital.surgeries) {
            if (String.valueOf(s.surgeryId).equals(input)) {
                if (s.status.equals("Cancelled")) {
                    System.out.println("Surgery is already cancelled.");
                    return;
                }
                s.status = "Cancelled";
                System.out.println("Surgery ID " + input + " has been cancelled.");
                return;
            }
        }
        System.out.println("Surgery ID not found.");
    }
}