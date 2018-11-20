package cmd;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IOException("No cmd commands found");
        }

        String command = args[0];
        if (command.equals("ls")) {
            File path = new File(args[1]);

            if (args.length >= 3 && args[2].equals("-json")) {
                Map fileStructure = listAllAndPrintJson(path);
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fileStructure);
                System.out.println(jsonResult);
            } else {
                listAllAndPrint(path);
            }
        }

        if (command.equals("mkdir")) {
            File path = new File(args[1]);
            path.mkdirs();
        }
    }

    public static File[] listAllAndPrint(File path) {
        File[] files = path.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
        return files;
    }

    public static Map listAllAndPrintJson(File path) {
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
