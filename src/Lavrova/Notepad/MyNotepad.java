package Lavrova.Notepad;

import java.util.Arrays;

public class MyNotepad {

    private MyNote[] notes;
    private int notesCount;
    int minCount = 64;

    public MyNotepad(){
        notes = new MyNote[minCount];
        InitializeNotes();
        notesCount = 0;
    }
    public int getNotesCount(){
        return notesCount;
    }

    public int getSpaceInfo() {
        return notes.length;
    }

    public boolean addNote(String text) {
        boolean result = false;
        if(notesCount > 0.9 * notes.length) {
            //добавим свободных мест.
            // При добавлении 91 элемента в массив из 100, сделаем массив = 200
            notes = Arrays.copyOf(notes, notes.length * 2);
            InitializeNotes();
        }
        if(!text.equals("")) {
            notes[notesCount].setText(text);
            notesCount++;
            result = true;
        }
        return result;
    }

    public String getNoteText(int index) {
        String text = "";
        if(index >= 0 && index < notesCount) {
            text = notes[index].getText();
        }
        return text;
    }

    public boolean deleteNote(int index) {
        boolean result = false;
        if(index >= 0 && index < notesCount) {
            for (int i = index + 1; i < notesCount; i++) {
                    notes[i - 1] = notes[i];
            }
            notesCount--;

            if(notesCount <= 0.9 * (notes.length / 2)) {
                //удалим лишние пустые элементы
                //удаляем 90й элемент из массива из 200 - сокращаем массив до 100
                notes = Arrays.copyOf(notes, notes.length / 2);
            }
            result = true;
        }
        return result;
    }
    public boolean editNote(int index, String newText) {
        boolean result = false;
        if(index >=0 && index < notesCount && !newText.equals("")) {
            notes[index].setText(newText);
            result = true;
        }
        return result;
    }

    private void InitializeNotes()
    {
        for (int i = 0; i < notes.length; i++) {
            if(null == notes[i]) {
                notes[i] = new MyNote();
            }
        }
    }
}
