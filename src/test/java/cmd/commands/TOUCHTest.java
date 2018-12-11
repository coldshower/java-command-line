package cmd.commands;

import com.sun.jdi.connect.Connector;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Spy;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TOUCHTest {
    private final TOUCH touch = new TOUCH();
    private final String[] args = new String[] {"touch", "./newDir"};

    @Test
    public void printsErrorIfFailsToCreateFile() {

        doNothing()
        .doThrow(new IOException("IOException error"))
        .when(path)
        .createNewFile();

        PrintStream systemOut = spy(System.out);
        touch.run(args);
//        verify(systemOut.println("IOException error"));
//        ArgumentCaptor<String> captur = ArgumentCaptor.forClass(String);
        verify(systemOut).println("IOException");

    }
}