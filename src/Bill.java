public class Bill {
    public int billId;
    public int patientId;
    public String patientName;
    public double roomCharge;
    public double surgeryCharge;
    public double totalAmount;
    public boolean isPaid;

    public Bill(int billId, int patientId, String patientName, double roomCharge, double surgeryCharge) {
        this.billId = billId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.roomCharge = roomCharge;
        this.surgeryCharge = surgeryCharge;
        this.totalAmount = roomCharge + surgeryCharge;
        this.isPaid = false;
    }

    @Override
    public String toString() {
        return "Bill ID: " + billId +
                "\nPatient: " + patientName +
                "\nRoom Charge: $" + roomCharge +
                "\nSurgery Charge: $" + surgeryCharge +
                "\nTotal: $" + totalAmount +
                "\nStatus: " + (isPaid ? "Paid" : "Unpaid");
    }
}
