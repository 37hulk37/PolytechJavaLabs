public class FileReadException extends Exception {
    public FileReadException() {
        super("Can't read/open/etc file");
    }
}
