package cmd;

import java.util.HashMap;
import java.util.Map;

import cmd.commands.*;

class Terminal {
    static Map<String, Command> map = new HashMap<>();

    static {
        map.put("ls", new LS());
        map.put("mkdir", new MKDIR());
    }

    static Command get(String command) {
        return cmd.Terminal.map.get(command);
    }
}
