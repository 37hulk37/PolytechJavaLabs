public class Main {
    public static void main(String[] args) {
        Supervisor supervisor = new Supervisor();

        Thread thread = new Thread(supervisor, "Supervisor");

        thread.start();
    }
}
