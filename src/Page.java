import java.util.ArrayList;
import java.util.List;

public class Page {
  private List<Tasks> tasks;

  Page() {
    this.tasks = new ArrayList<>();
  }

  public Page(List<Tasks> tasks) {
    this.tasks = tasks;
  }

  void addTask(Tasks task) {
    this.tasks.add(task);
  }

  @Override
  public String toString() {
    String result = "";
    int i = 0;
    for (Tasks task : this.tasks) {
      result = result.concat(+ (i + 1) + " " + task.toString() + "\n");
      i++;
    }
    return result;
  }
}
