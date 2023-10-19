package Java_DevKit.Seminar2_2.task2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        //new ChatWindow(new Server(new ConsoleServerListener()));
        try {
            new ChatWindow(new ConsoleServerListener(), new Server(new LogServerListener("ServerLogfile")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
