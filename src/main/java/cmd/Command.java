package cmd;

import java.io.IOException;

public interface Command {
    void run(String[] args) throws Exception;
}
