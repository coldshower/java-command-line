package cmd;

import java.util.HashMap;
import java.util.Map;

import cmd.commands.*;

class Terminal {
    static Map<String, Command> map = new HashMap<>();

    static {
        map.put("ls", new LS());
        map.put("mkdir", new MKDIR());
        map.put("pwd", new PWD());
        map.put("touch", new TOUCH());
    }

    static Command get(String command) {
        return cmd.Terminal.map.get(command);
    }
}
