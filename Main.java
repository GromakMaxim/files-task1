import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        DirectoryCreation newDirectory = (arr, path, builder) -> {
            for (int i = 0; i < arr.length; i++) {
                File myDir = new File(path, arr[i]);
                if (myDir.mkdir()) sb
                        .append("directory ")
                        .append(arr[i])
                        .append(" was created")
                        .append("\n");
            }
        };
        DirectoryCreation newFile = (arr, path, builder) -> {
            for (int i = 0; i < arr.length; i++) {
                File myFile = new File(path, arr[i]);
                try {
                    if (myFile.createNewFile()) {
                        sb
                                .append("file ")
                                .append(arr[i])
                                .append(" was created")
                                .append("\n");
                    }
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
        };

        String[] dirArr = {"src", "res", "savegames", "temp"};
        String[] dirArr1 = {"main", "test"};
        String[] dirArr2 = {"drawables", "vectors", "icons"};
        newDirectory.createNewItem(dirArr, "D:\\MyGame", sb);
        newDirectory.createNewItem(dirArr1, "D:\\MyGame\\src", sb);
        newDirectory.createNewItem(dirArr2, "D:\\MyGame\\res", sb);

        String[] filesArr = {"Main.java", "Utils.java"};
        String[] filesArr2 = {"temp.txt"};
        newDirectory.createNewItem(filesArr, "D:\\MyGame\\src\\main", sb);
        newFile.createNewItem(filesArr2, "D:\\MyGame\\temp", sb);

        try (FileWriter writer = new FileWriter("D:\\MyGame\\temp\\temp.txt", false)) {
            writer.write(String.valueOf(sb));
            writer.write("\n");
            writer.write(String.valueOf(LocalDateTime.now()));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}