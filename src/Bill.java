public class Bill {
    public int billId;
    public int patientId;
    public String patientName;
    public double roomCharge;
    public double surgeryCharge;
    public double totalAmount;
    public boolean isPaid;

    public Bill(int billId, int patientId, String patientName,
                double roomCharge, double surgeryCharge) {
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
                "\nBill ID      : " + billId +
                "\nPatient ID   : " + patientId +
                "\nPatient Name : " + patientName +
                "\nRoom Charge  : $" + roomCharge +
                "\nSurgery Charge: $" + surgeryCharge +
                "\nTotal Amount : $" + totalAmount +
                "\nStatus       : " + (isPaid ? "Paid" : "Unpaid") +
                "\n--------------------------";
    }

    public static void generateBill() {
        System.out.print("Enter patient ID: ");
        String idInput = Hospital.scanner.nextLine().trim();
        int patientId;
        try {
            patientId = Integer.parseInt(idInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid patient ID.");
            return;
        }

        // Find patient name
        String patientName = "";
        for (Patient p : Hospital.patients) {
            if (p.getId() == patientId) {
                patientName = p.getName();
                break;
            }
        }
        if (patientName.isEmpty()) {
            System.out.print("Patient not found. Enter patient name manually: ");
            patientName = Hospital.scanner.nextLine().trim();
        }

        System.out.print("Room type (1=Normal $200/day, 2=ICU $500/day): ");
        String roomTypeInput = Hospital.scanner.nextLine().trim();
        int roomType = roomTypeInput.equals("2") ? 2 : 1;

        System.out.print("Number of days stayed: ");
        int days = 0;
        try {
            days = Integer.parseInt(Hospital.scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of days.");
            return;
        }

        System.out.print("Surgery required? (1=Yes, 2=No): ");
        String surgChoice = Hospital.scanner.nextLine().trim();

        double ratePerDay = (roomType == 2) ? 500 : 200;
        double roomCharge = ratePerDay * days;
        double surgeryCharge = surgChoice.equals("1") ? 1500 : 0;

        int newId = Hospital.bills.size() + 1;
        Bill bill = new Bill(newId, patientId, patientName, roomCharge, surgeryCharge);
        Hospital.bills.add(bill);

        System.out.println("\nBill generated successfully!");
        System.out.println(bill);
    }

    public static void markAsPaid() {
        System.out.print("Enter bill ID to mark as paid: ");
        String input = Hospital.scanner.nextLine().trim();

        for (Bill b : Hospital.bills) {
            if (String.valueOf(b.billId).equals(input)) {
                b.isPaid = true;
                System.out.println("Bill marked as paid.");
                return;
            }
        }
        System.out.println("Bill ID not found.");
    }

    public static void viewAllBills() {
        if (Hospital.bills.isEmpty()) {
            System.out.println("No bills in the system.");
            return;
        }
        System.out.println("All Bills:");
        for (Bill b : Hospital.bills) System.out.println(b);
    }
}