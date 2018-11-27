package cmd;

import java.util.HashMap;
import java.util.Map;
import cmd.Command;

class Commands {
    static Map<String, Command> map = new HashMap<>();

    static Command get(String command) {
        return Commands.map.get(command);
    }
}
