public class Room {
    public int roomNumber;
    public String type;
    public String status;
    public int assignedPatientId;

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.status = "Available";
        this.assignedPatientId = -1;
    }

    @Override
    public String toString() {
        String patInfo = assignedPatientId == -1 ? "" : ", Patient ID: " + assignedPatientId;
        return "Room: " + roomNumber + " | Type: " + type + " | Status: " + status + patInfo;
    }

    public static void showRooms() {
        if (Hospital.rooms.isEmpty()) {
            System.out.println("No rooms in the system.");
            return;
        }
        System.out.println("All Rooms:");
        for (Room r : Hospital.rooms) System.out.println(r);
    }

    public static void reserveRoom() {
        System.out.print("Enter room number: ");
        String roomInput = Hospital.scanner.nextLine().trim();
        System.out.print("Enter patient ID: ");
        String patInput = Hospital.scanner.nextLine().trim();

        for (Room r : Hospital.rooms) {
            if (String.valueOf(r.roomNumber).equals(roomInput)) {
                if (r.status.equals("Occupied")) {
                    System.out.println("Room " + roomInput + " is already occupied.");
                    return;
                }
                try {
                    r.assignedPatientId = Integer.parseInt(patInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid patient ID.");
                    return;
                }
                r.status = "Occupied";
                System.out.println("Room " + roomInput + " reserved for patient " + patInput + " successfully.");
                return;
            }
        }
        System.out.println("Room not found.");
    }

    public static void releaseRoom() {
        System.out.print("Enter room number to release: ");
        String roomInput = Hospital.scanner.nextLine().trim();

        for (Room r : Hospital.rooms) {
            if (String.valueOf(r.roomNumber).equals(roomInput)) {
                if (r.status.equals("Available")) {
                    System.out.println("Room " + roomInput + " is already available.");
                    return;
                }
                r.status = "Available";
                r.assignedPatientId = -1;
                System.out.println("Room " + roomInput + " released successfully.");
                return;
            }
        }
        System.out.println("Room not found.");
    }
}