public class Main {
    public static void main(String[] args) {
        Hospital.loadSampleData();

        System.out.println("========================================");
        System.out.println("   Welcome to Hospital Management System");
        System.out.println("========================================\n");

        User loggedInUser = null;
        while (loggedInUser == null) {
            System.out.print("Username: ");
            String username = Hospital.scanner.nextLine().trim();
            System.out.print("Password: ");
            String password = Hospital.scanner.nextLine().trim();
            loggedInUser = Hospital.login(username, password);
        }

        Hospital.handleUserRole(loggedInUser);
        Hospital.scanner.close();
    }
}
