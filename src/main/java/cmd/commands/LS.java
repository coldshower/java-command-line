package cmd.commands;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


public class LS {
    @Override
    public final void run(String[] args) {
        File path = new File(args[1]);

        if (args.length >= 3 && args[2].equals("-json")) {
            Map fileStructure = LS.listAllAndPrintJson(path);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fileStructure);
            System.out.println(jsonResult);
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

    static final Map listAllAndPrintJson(File path) {
        Map fileStructure = new HashMap<String, Map>();
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                Map nestedFileStructure = listAllAndPrintJson(new File(file.getAbsolutePath()));
                fileStructure.put(file.getName(), nestedFileStructure);
            } else {
                fileStructure.put(file.getName(), null);
            }
        }
        return fileStructure;
    }

}
