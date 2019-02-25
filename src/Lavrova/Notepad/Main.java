package Lavrova.Notepad;
import java.util.Scanner;

public class Main {

    private static int defaultCount = 31; //для добавления заметок по умолчанию

    enum commandErrors {
        EMPTY,
        NOTFOUND,
        NOTNUMBER,
        OTHER
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to VeryUsefulNotepad!");
        System.out.println("Commands:");
        System.out.println("ALL         - to see all notes;");
        System.out.println("GET         - to get some note;");
        System.out.println("DEL         - to delete the note;");
        System.out.println("ADD         - to create new note;");
        System.out.println("EDI         - to change note with the new text;");
        System.out.println("INF         - to change note with the new text;");
        System.out.println("OUT         - to get out of here;");

        System.out.println("SET - to create a new Notepad and do some default things.");

        System.out.println("================");

        boolean isContinue = true;
        MyNotepad mySecretNotepad = new MyNotepad();
        Scanner scanInput = new Scanner(System.in);

        do {
            switch (scanInput.nextLine()) {
                case "ALL":
                    //вывести все элементы блокнота
                    if (mySecretNotepad.getNotesCount() > 0) {
                        for (int i = 0; i < mySecretNotepad.getNotesCount(); i++) {
                            System.out.printf("%d : %s \n", i + 1, mySecretNotepad.getNoteText(i));
                        }
                    } else {
                        printAnError(commandErrors.EMPTY);
                    }
                    break;
                case "GET":
                    //получить запись под указанным номером
                    if (mySecretNotepad.getNotesCount() == 0) {
                        printAnError(commandErrors.EMPTY);
                    } else {
                        int index = getIndex(mySecretNotepad, scanInput);
                        if (index < 0) {
                            printAnError(commandErrors.NOTFOUND);
                        } else {
                            System.out.println(mySecretNotepad.getNoteText(index));
                        }
                    }
                    break;
                case "DEL":
                    //удалить запись с указанным номером
                    if (mySecretNotepad.getNotesCount() == 0) {
                        printAnError(commandErrors.EMPTY);
                    } else {
                        int index = getIndex(mySecretNotepad, scanInput);
                        if (index < 0) {
                            printAnError(commandErrors.NOTFOUND);
                        } else {
                            mySecretNotepad.deleteNote(index);
                            printSuccess();

                        }
                    }
                    break;
                case "ADD":
                    //добавить новую запись
                    System.out.println("What note do you want to add?");
                    String addedText = scanInput.nextLine();
                    if (mySecretNotepad.addNote(addedText)) {
                        printSuccess();
                    } else {
                        printAnError(commandErrors.OTHER);
                    }
                    break;
                case "EDI":
                    //изменить текст указанной записи на новый
                    if (mySecretNotepad.getNotesCount() == 0) {
                        printAnError(commandErrors.EMPTY);
                    } else {
                        int index = getIndex(mySecretNotepad, scanInput);
                        if (index < 0) {
                            printAnError(commandErrors.NOTFOUND);
                        } else {
                            System.out.println("What text do you want to set?");
                            String editedText = scanInput.nextLine();
                            if(mySecretNotepad.editNote(index, editedText)) {
                                printSuccess();
                            } else {
                                printAnError(commandErrors.OTHER);
                            }
                        }
                    }
                    break;
                case "SET":
                    //добавить кучу новых записей по умолчанию, иначе на чём тестировать-то
                    for (int i = 0; i < defaultCount; i++) {
                        mySecretNotepad.addNote("Default note #" + (i + 1));
                    }
                    System.out.println("Default Notes was added to Notepad:");
                    for (int i = 0; i < mySecretNotepad.getNotesCount(); i++) {
                        System.out.println(mySecretNotepad.getNoteText(i));
                    }
                    break;
                case "INF":
                    //просто посмотрим, сколько и почём
                    System.out.printf("Notes count = %d \n", mySecretNotepad.getNotesCount());
                    System.out.printf("Space available = %d \n", mySecretNotepad.getSpaceInfo());
                    break;
                case "OUT":
                    //красиво и не прощаясь уйти
                    isContinue = false;
                    break;
                default:
                    printAnError(commandErrors.OTHER);
                    break;
            }
        }
        while (isContinue);
    }

    private static int getIndex(MyNotepad notepad, Scanner scan) {
        //функция запрашивает индекс и ищет его в блокноте,
        //возвращает индекс записи или -1, если не найдено
        int index = -1;
        System.out.printf("What note do you want to find? Give an index from 1 to %d \n",
                notepad.getNotesCount());
        try {
            int getIndex = Integer.parseInt(scan.nextLine()) - 1;
            if (notepad.checkIndex(getIndex)) {
                index = getIndex;
            }
        } catch (NumberFormatException e) {
            printAnError(commandErrors.NOTNUMBER);
        }
        return index;
    }

    private static void printAnError(commandErrors error) {
        switch (error) {
            case EMPTY:
                System.out.println("Your Notepad is empty.");
                break;
            case NOTFOUND:
                System.out.println("There is no such note's number.");
                break;
            case NOTNUMBER:
                System.out.println("Did you give me letters? I need only numbers.");
                break;
            default:
                System.out.println("Oops. You did something wrong. Try again.");
                break;
        }
    }

    private static void printSuccess() {
        System.out.println("We did it.");
    }
}
