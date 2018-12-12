package cmd.commands;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import cmd.Command;

public class LS implements Command {
    @Override
    public final void run(String[] args) {
        File path = new File(args[1]);

        if (args.length >= 3 && args[2].equals("-json")) {
            LS.listAllAndPrintJson(path);
        } else {
            LS.listAllAndPrint(path);
        }
    }

    static final File[] listAllAndPrint(File path) {
        File[] files = path.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
        return files;
    }

    static final void listAllAndPrintJson(File path) {
        Map fileStructure = LS.createFileStructureFromPath(path);

        String jsonResult;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            jsonResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fileStructure);
        } catch (JsonProcessingException e) {
            jsonResult = e.toString();
        }

        System.out.println(jsonResult);
    }

    static final Map createFileStructureFromPath(File path) {
        Map fileStructure = new HashMap<String, Map>();
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                Map nestedFileStructure = createFileStructureFromPath(file);
                fileStructure.put(file.getName(), nestedFileStructure);
            } else {
                fileStructure.put(file.getName(), null);
            }
        }
        return fileStructure;
    }

}
