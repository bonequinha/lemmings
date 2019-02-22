package Lavrova.Notepad;

public class MyNote {
    private String noteText;

    public MyNote() {
        noteText = "";
    }

    public void setText(String text) {
        noteText = text;
    }
    public String getText(){
        return noteText;
    }
}
