package cmd.commands;

import java.io.File;
import java.io.IOException;

import cmd.Command;

public class PWD implements Command {
    @Override
    public void run(String[] args) {
        String arg1 = (args.length > 1) ? args[1] : ".";
        File path = new File(arg1);
        try {
            System.out.println(path.getCanonicalPath());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
