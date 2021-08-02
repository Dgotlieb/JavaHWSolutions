import java.io.IOException;

public class LogsCreator {
    public static void main(String[] args) throws IOException {
        LogsWriter logsWriter = LogsWriter.getInstance();
        logsWriter.writeToFile("hello");
    }
}
