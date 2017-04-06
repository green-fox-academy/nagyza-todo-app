import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static final Path fileKeepTodos = Paths.get("todos.csv");
  private static final Path fileUsage = Paths.get("print-usage.csv");

  public static void main(String[] args) {
    if (args.length == 0) {
      for (String line : readFile(fileUsage)) {
        System.out.println(line);
      }
    }
  }

  public void writeFile(ArrayList todoLines) {
    try {
      Files.write(fileKeepTodos, todoLines);
    } catch (IOException f) {
      System.out.println("Something wrong with reading the " + fileKeepTodos + " file!");
    }
  }

  public static List<String> readFile(Path filePath) {
    List<String> fileLines = new ArrayList<>();
    try {
      fileLines = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("Something wrong with reading the " + filePath + " file!");
    }
    return fileLines;
  }

}
