
public class Tasks {
  private String isDone;
  private String text;

  public Tasks(String isDone, String text) {
    this.isDone = isDone;
    this.text = text;
  }

  public String toFile() {
    return "[" + isDone + "] " + text;
  }
}