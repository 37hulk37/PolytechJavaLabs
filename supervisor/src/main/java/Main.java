public class Main {
    public static void main(String[] args) {
        Synchro queue = new Synchro();
        Supervisor supervisor = new Supervisor(queue);

        Thread thread = new Thread(supervisor, "Supervisor");
        thread.start();
    }
}
