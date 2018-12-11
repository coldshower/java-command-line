package cmd.commands;

import java.io.File;
import java.io.IOException;

import cmd.Command;

public class TOUCH implements Command {
    @Override
    public void run(String[] args) throws IOException {
        File path = new File(args[1]);

        path.createNewFile();

    }
}
