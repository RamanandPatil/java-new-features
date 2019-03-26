import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileRenamerNew {
    public static void main(java.lang.String[] args) {

        //working folder
        String dir = "D:\\Downloads\\20181216\\";
        //recursively list files before renaming
        System.out.println("\nBefore Renaming: ");
        listFiles(dir);
        //rename files - replace text in the name with song.text
        renameFiles(dir, "[Smtebooks.eu] ", "");
        //recursively list files after renaming
        System.out.println("\nAfter Renaming: ");
        listFiles(dir);
    }


    public static void listFiles(String dir) {
        try {
            Files.find(Paths.get(dir),
                    Integer.MAX_VALUE,
                    (filePath, fileAttr) -> fileAttr.isRegularFile())
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void renameFiles(String dir, String replace, String replaceBy) {
        System.out.println("\nStart of FileRenamer.renameFiles\n");
        try {
            try (Stream<Path> stream = Files.find(Paths.get(dir), 3,
                    (path, attr) -> String.valueOf(path).endsWith(".Pdf"))) {
                stream.map(String::valueOf).forEach(item -> {
                    System.out.println(item);
                            try {
                                Files.move(new File(item).toPath(), new File(item.replace(replace, replaceBy)).toPath());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nEnd of FileRenamer.renameFiles\n");
    }

}
