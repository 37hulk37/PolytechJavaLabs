import java.io.IOException;

public class FileReadException extends IOException {
    public FileReadException() {
        super("Can't read/open/etc file");
    }
}
