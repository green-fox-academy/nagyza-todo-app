import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static final Path fileKeepTodos = Paths.get("todos.csv");
  private static final Path fileUsage = Paths.get("print-usage.csv");
  private static Page page;

  public static void main(String[] args) {
    page = new Page();
    List<String> readTasks = readFile(fileKeepTodos);
    fillPage(readTasks);
    List<Tasks> tasksList = page.getTasksList();

    if (args.length == 0) {
      for (String line : readFile(fileUsage)) {
        System.out.println(line);
      }
    } else if (args[0].equals("-l") && readTasks.size() == 0) {
      System.out.println("No todos for today! :)");
    } else if (args[0].equals("-l")) {
      System.out.println(page.toString());
    } else if (args[0].equals("-a") && args.length < 2) {
      System.out.println("Unable to add: no task provided");
    } else if (args[0].equals("-a")) {
      page.addNewTask(args[1]);
      writeFile(page.toFile());
    } else if (args[0].equals("-r")) {
      if (args.length < 2) {
        System.out.println("Unable to remove: no index provided");
      } else if (!isInteger(args[1])) {
        System.out.println("Unable to remove: index is not a number");
      } else if (tasksList.size() < Integer.parseInt(args[1])) {
        System.out.println("Unable to remove: index is out of bound");
      } else {
        page.removeTask(Integer.parseInt(args[1]));
        writeFile(page.toFile());
      }
    } else if (args[0].equals("-c")) {
      if (args.length < 2) {
        System.out.println("Unable to remove: no index provided");
      } else if (!isInteger(args[1])) {
        System.out.println("Unable to remove: index is not a number");
      } else if (tasksList.size() < Integer.parseInt(args[1])) {
        System.out.println("Unable to remove: index is out of bound");
      } else {
        page.checkTask(Integer.parseInt(args[1]));
        writeFile(page.toFile());
      }
    } else if (args.length > 0) {
      System.out.println("Unsupported argument");
      for (String lines : readFile(fileUsage)) {
        System.out.println(lines);
      }
    }
  }

  private static void writeFile(ArrayList todoLines) {
    try {
      Files.write(fileKeepTodos, todoLines);
    } catch (IOException f) {
      System.out.println("Something wrong with reading the " + fileKeepTodos + " file!");
    }
  }

  private static List<String> readFile(Path filePath) {
    List<String> fileLines = new ArrayList<>();
    try {
      fileLines = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("Something wrong with reading the " + filePath + " file!");
    }
    return fileLines;
  }

  private static void fillPage(List<String> readTasks) {
    for (String line : readTasks) {
      String[] lineElements = line.split(";");
      String done = lineElements[0];
      String text = lineElements[1];
      page.addTask(new Tasks(done, text));
    }
  }
  private static boolean isInteger(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch( Exception e ) {
      return false;
    }
  }
}