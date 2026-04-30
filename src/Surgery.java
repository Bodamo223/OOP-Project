public class Surgery {
    public int surgeryId;
    public String patientName;
    public String surgeonName;
    public String surgeryType;
    public String scheduledDate;
    public String status;

    public Surgery(int surgeryId, String patientName, String surgeonName, String surgeryType, String scheduledDate) {
        this.surgeryId = surgeryId;
        this.patientName = patientName;
        this.surgeonName = surgeonName;
        this.surgeryType = surgeryType;
        this.scheduledDate = scheduledDate;
        this.status = "Scheduled";
    }
}