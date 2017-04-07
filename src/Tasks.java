
public class Tasks {
  private String isDone;
  private String text;
  private String date;
  private int priority;

  Tasks(String text) {
    this.isDone = " ";
    this.text = text;
    this.date = "";
    this.priority = 2;
  }

  Tasks(String isDone, String text, String date, int priority) {
    this.isDone = isDone;
    this.text = text;
    this.date = date;
    this.priority = priority;
  }

  public int getPriority() {
    return priority;
  }

  void changeDone() {
    if (this.isDone.equals(" ")) {
      this.isDone = "x";
    } else {
      this.isDone = " ";
    }
  }

  void changeToBeDone() {
    this.isDone = "x";
  }

  void changeToBeUndone() {
    this.isDone = " ";
  }

  @Override
  public String toString() {
    return "[" + isDone + "] " + " Priority: " + priority + "  " + date + "\t" + text;
  }

  String toFile() {
    return isDone + ";" + text + ";" + date + ";" + priority;
  }

}