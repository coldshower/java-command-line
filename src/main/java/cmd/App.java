package cmd;

import java.io.IOException;
import cmd.Commands;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IOException("No cmd commands found");
        }

        Commands.get(args[0]).run();
    }
}
