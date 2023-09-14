import java.io.IOException;

public class InvalidFileFormatException extends IOException {
    public InvalidFileFormatException() {
        super("Invalid file format");
    }
}


