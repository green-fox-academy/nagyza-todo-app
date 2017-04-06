
public class Tasks {
  private String isDone;
  private String text;

  Tasks(String text) {
    this.isDone = " ";
    this.text = text;
  }

  Tasks(String isDone, String text) {
    this.isDone = isDone;
    this.text = text;
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
    return "[" + isDone + "] " + text;
  }

  String toFile() {
    return isDone + ";" + text;
  }

}