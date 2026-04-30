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
}