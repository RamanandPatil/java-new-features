import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileRenamer {
    public static void main(String[] args) {
        String pathname = "D:\\Downloads\\20181218";
        renameFiles(pathname, "Smtebooks.Us", "");
    }

    public static void renameFiles(String pathname, String textToRemove, String textToReplace) {
        System.out.println("pathname = [" + pathname + "], textToRemove = [" + textToRemove + "], textToReplace = [" + textToReplace + "]");
        File dir = new File(pathname);
        if (!dir.exists()) {
            throw new RuntimeException("Please provide Correct pathname");
        }
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                renameFile(file, textToRemove, textToReplace);
            }
        } else {

        }
    }


    public static void renameFile(File file, String textToRemove,
                                  String textToReplace) {
        Path oldPath = file.toPath();
        System.out.println("\nPath before renaming: " + oldPath);
        String fileName = file.getName();
        if (fileName.contains(textToRemove)) {
            String newFileName = fileName.replaceAll(textToRemove, textToReplace);
            // Also replace all special chars and extra spaces
            newFileName = newFileName.replaceAll("\\[\\] ","");
            Path newPath = Path.of(file.getParent(), newFileName);
            try {
                Files.move(oldPath, newPath);
                System.out.println("Path after renaming: " + newPath);
            } catch (IOException e) {
                System.err.println("\nIOException while renaming files: " + e.getMessage());
            }
        } else {
            System.err.println("\ntextToRemove not found in the file: " + fileName);
        }

    }

}
