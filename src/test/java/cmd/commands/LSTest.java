package cmd.commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class LSTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final LS ls = new LS();

    private File mockPath = mock(File.class);
    private File[] mockFiles;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUpMockFiles() {
        mockFiles = new File[] {
            mock(File.class),
            mock(File.class),
            mock(File.class)
        };

        int counter = 0;

        for (File file : mockFiles) {
            when(file.getName()).thenReturn("file" + counter);
            counter += 1;
        }

        when(mockPath.listFiles()).thenReturn(mockFiles);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void listAllAndPrint_printsAllTheFilesAtGivenPath() {
        LS.listAllAndPrint(mockPath);
        assertEquals("file0\nfile1\nfile2\n", outContent.toString());
    }
    
}