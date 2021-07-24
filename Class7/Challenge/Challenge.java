import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

// 7
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    //synchronized method to control simultaneous access
    synchronized public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            // if instance is null, initialize
            instance = new ThreadSafeSingleton();
        }

        return instance;
    }

    public void writeToFile(String content) throws IOException {
        String filePath = "C:\\Users\\user\\log.txt";
        Files.writeString(Path.of(filePath), content + "\n", StandardOpenOption.APPEND);
    }
	
	//8
	Adapter Pattern - An Adapter Pattern says that just "converts the interface of a class into another interface that a client wants".
	Bridge Pattern - A Bridge Pattern says that just "decouple the functional abstraction from the implementation so that the two can vary independently".
	Observer Pattern - An Observer Pattern says that "just define a one-to-one dependency so that when one object changes state, all its dependents are notified and updated automatically".
	
	//9
	1. Ant 
	2. Gradle
}
