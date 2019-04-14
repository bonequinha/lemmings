package main.Notepad;

import java.util.Arrays;

public class MyNotepad {

    private MyNote[] notes;
    private int notesCount;
    private final int MIN_COUNT = 32;
    private final String EMPTY_TEXT = "";

    public MyNotepad() {
        notes = new MyNote[MIN_COUNT];
    }

    public int getNotesCount() {
        return notesCount;
    }

    public int getSpaceInfo() {
        return notes.length;
    }

    public boolean addNote(String text) {
        boolean result = false;
        if (!EMPTY_TEXT.equals(text)) {
            if (notesCount == notes.length) {
                //добавим свободных мест.
                notes = Arrays.copyOf(notes, notes.length * 2);
            }
            //инициализируем новый элемент в момент создания заметки
            notes[notesCount] = new MyNote();
            notes[notesCount].setText(text);
            notesCount++;

            result = true;
        }
        return result;
    }

    public String getNoteText(int index) {
        String text = EMPTY_TEXT;
        if (checkIndex(index)) {
            text = notes[index].getText();
        }
        return text;
    }

    public boolean deleteNote(int index) {
        boolean result = false;
        if (checkIndex(index)) {
            //сдвинем элементы после указанного на 1 левее
            System.arraycopy(notes,index + 1, notes, index, notes.length - index - 1);

            notesCount--;

            if (notesCount <= (notes.length / 2) && MIN_COUNT <= notes.length / 2) {
                //удалим лишние пустые элементы, если занято менее половины. Не уполовинивать, если и так минималка
                notes = Arrays.copyOf(notes, notes.length / 2);
            }
            result = true;
        }
        return result;
    }

    public boolean editNote(int index, String newText) {
        boolean result = false;
        if (checkIndex(index) && !EMPTY_TEXT.equals(newText)) {
            notes[index].setText(newText);
            result = true;
        }
        return result;
    }

    public boolean checkIndex(int index) {
        //проверяем, существует ли указанный индекс
        return index >= 0 && index < notesCount;
    }
}
