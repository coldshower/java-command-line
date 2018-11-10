import java.io.File;
import java.io.IOException;

public class Cmd {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IOException("No cmd commands found");
        }

        String command = args[0];
        if (command.equals("ls")) {
            File path = new File(args[1]);
            listAllAndPrint(path);
        }

        if (command.equals("mkdir")) {
            File path = new File(args[1]);
            path.mkdirs();
        }
    }

    public static void listAllAndPrint(File path) {
        File[] files = path.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
