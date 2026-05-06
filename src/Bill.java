import java.util.Scanner;

public class Bill {
    public int billId;
    public int patientId;
    public String patientName;
    public double roomCharge;
    public double surgeryCharge;
    public double totalAmount;
    public boolean isPaid;

    private static int nextBillId = 1;
    static Scanner scanner = new Scanner(System.in);

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
        return "--------------------------" +
                "\nBill ID: " + billId +
                "\nPatient ID: " + patientId +
                "\nPatient Name: " + patientName +
                "\nRoom Charge: $" + roomCharge +
                "\nSurgery Charge: $" + surgeryCharge +
                "\nTotal Amount: $" + totalAmount +
                "\nStatus: " + (isPaid ? "Paid" : "Unpaid") +
                "\n--------------------------";
    }

    static void generateBill() {
        System.out.print("Enter patient ID       : ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // تنظيف السكنر

        System.out.print("Enter patient name     : ");
        String patientName = scanner.nextLine();

        System.out.print("Room type (1=Normal, 2=ICU): ");
        int roomType = scanner.nextInt();

        System.out.print("Number of days stayed  : ");
        int days = scanner.nextInt();

        System.out.print("Surgery required? (1=Yes, 2=No): ");
        int surgeryChoice = scanner.nextInt();

        double ratePerDay = (roomType == 2) ? 500 : 200;
        double roomCharge = ratePerDay * days;
        double surgeryCharge = (surgeryChoice == 1) ? 1500 : 0;

        Bill bill = new Bill(nextBillId++, patientId, patientName, roomCharge, surgeryCharge);

        Hospital.bills.add(bill);
        System.out.println("Bill generated successfully!");
    }

    static void markAsPaid() {
        System.out.print("Enter bill ID to mark as paid: ");
        int id = scanner.nextInt();

        for (Bill b : Hospital.bills) {
            if (b.billId == id) {
                b.isPaid = true;
                System.out.println("Bill marked as paid.\n");
                return;
            }
        }
        System.out.println("Bill ID not found.\n");
    }
}