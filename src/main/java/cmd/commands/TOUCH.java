package cmd.commands;

import java.io.File;
import java.io.IOException;

import cmd.Command;

public class TOUCH implements Command {
    @Override
    public void run(String[] args) {
        File path = new File(args[1]);

        try {
            path.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
