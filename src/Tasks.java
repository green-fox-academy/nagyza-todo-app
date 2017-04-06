
public class Tasks {
  private String isDone;
  private String text;

  public Tasks(String text) {
    this.isDone = " ";
    this.text = text;
  }

  public Tasks(String isDone, String text) {
    this.isDone = isDone;
    this.text = text;
  }

  public void changeDone() {
    if (this.isDone.equals(" ")) {
      this.isDone = "x";
    } else {
      this.isDone = " ";
    }
  }

  @Override
  public String toString() {
    return "[" + isDone + "] " + text;
  }

  String toFile() {
    return isDone + ";" + text;
  }

}