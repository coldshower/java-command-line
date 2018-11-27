package cmd.commands;

import java.io.File;
import cmd.Command;

public class MKDIR implements Command {
    @Override
    public void run(String[] args) {
        File path = new File(args[1]);
        path.mkdirs();
    }
}
