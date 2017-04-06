
public class Tasks {
  private String isDone;
  private String text;

  public Tasks(String text) {
    this.isDone = " ";
    this.text = text;
  }

  public void changeDone() {
    if (this.isDone == " ") {
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