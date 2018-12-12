package cmd.commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class LSTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final File mockPath = mock(File.class);
    private File[] mockFiles;
    private final File mockDirectory = mock(File.class);

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUpMockFiles() {
        mockFiles = new File[] {
            mock(File.class),
            mock(File.class),
            mockDirectory
        };

        File[] mockDirectoryContents = new File[] {
            mock(File.class)
        };

        when(mockDirectoryContents[0].getName()).thenReturn("nestedFile");

        when(mockDirectory.getName()).thenReturn("directory");
        when(mockDirectory.isDirectory()).thenReturn(true);
        when(mockDirectory.listFiles()).thenReturn(mockDirectoryContents);


        when(mockFiles[0].getName()).thenReturn("file0");
        when(mockFiles[1].getName()).thenReturn("file1");
        when(mockPath.listFiles()).thenReturn(mockFiles);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void listAllAndPrint_printsAllTheFilesAtGivenPath() {
        LS.listAllAndPrint(mockPath);
        assertEquals("file0\nfile1\ndirectory\n", outContent.toString());
    }

    @Test
    public void createFileStructureFromPath_returnsHashMapOfFileStructure() {
        Map<String, Map> expectedHashMap = new HashMap<>();
        expectedHashMap.put("file0", null);
        expectedHashMap.put("file1", null);

        Map<String, Map> nestedHashMap = new HashMap<>();
        nestedHashMap.put("nestedFile", null);

        expectedHashMap.put("directory", nestedHashMap);

        assertEquals(
            expectedHashMap,
            LS.createFileStructureFromPath(mockPath)
        );
    }

    @Test
    public void listAllAndPrintJson_printsOutJson() {
        LS.listAllAndPrintJson(mockPath);
        assertEquals(
            "{\n  \"file0\" : null,\n  \"file1\" : null,\n  \"directory\" : {\n    \"nestedFile\" : null\n  }\n}\n",
            outContent.toString()
        );
    }

}