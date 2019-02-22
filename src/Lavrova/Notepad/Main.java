package Lavrova.Notepad;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome to VeryUsefulNotepad!");
        System.out.println("Commands:");
        System.out.println("ALL         - to see all notes;");
        System.out.println("DEL         - to delete the note #1;");
        System.out.println("ADD         - to create new note;");
        System.out.println("EDI         - to change note #1 with the new text;");
        System.out.println("INF         - to change note #1 with the new text;");
        System.out.println("OUT         - to get out of here;");

        System.out.println("SET - to create a new Notepad and do some default things.");

        System.out.println("================");

        boolean shouldContinue = true;
        MyNotepad mySecretNotepad = new MyNotepad();

        Scanner in = new Scanner(System.in);
        do {
            switch (in.nextLine()) {
                case "ALL":
                    if(mySecretNotepad.getNotesCount() > 0) {
                        for (int i = 0; i < mySecretNotepad.getNotesCount(); i++) {
                            System.out.println(i + 1+ ": " + mySecretNotepad.getNoteText(i));
                        }
                    }
                    else {
                        System.out.println("You have no notes here.");
                    }
                    break;
                case "DEL":
                    if(mySecretNotepad.getNotesCount() == 0) {
                        printAnError("Empty");
                    }
                    else {
                        System.out.println("What note do you want to delete? Give a number from 1 to " + mySecretNotepad.getNotesCount());
                        try {
                            int deletedIndex = Integer.parseInt(in.nextLine()) - 1;
                            if (mySecretNotepad.deleteNote(deletedIndex)) {
                                printSuccess();
                            } else {
                                printAnError("NotFound");
                            }
                        }
                        catch (NumberFormatException e) {
                            printAnError("NotFound");
                        }
                    }
                    break;
                case "ADD":
                    System.out.println("What note do you want to add?");
                    String addedText = in.nextLine();
                    if(mySecretNotepad.addNote(addedText)) {
                        printSuccess();
                    }
                    else {
                        printAnError("");
                    }
                    break;
                case "EDI":
                    if(mySecretNotepad.getNotesCount() == 0) {
                        printAnError("Empty");
                    }
                    else {
                        System.out.println("What note do you want to edit? Give an index from 1 to " + mySecretNotepad.getNotesCount());
                        try {
                            int editedIndex = Integer.parseInt(in.nextLine()) - 1;
                            if(editedIndex >=0 && editedIndex < mySecretNotepad.getNotesCount()) {
                                System.out.println("What text do you want to set?");
                                String editedText = in.nextLine();
                                if (mySecretNotepad.editNote(editedIndex, editedText)) {
                                    printSuccess();
                                } else {
                                    printAnError("");
                                }
                            }
                            else {
                                printAnError("NotFound");
                            }
                        }
                        catch (NumberFormatException e) {
                            printAnError("NotFound");
                        }
                    }
                    break;
                case "SET":
                    for (int i = 0; i < 89; i++) {
                        mySecretNotepad.addNote("Default note #" + (i + 1));
                    }
                    System.out.println("Default Notepad was set to:");
                    for (int i = 0; i < mySecretNotepad.getNotesCount(); i++) {
                        System.out.println(mySecretNotepad.getNoteText(i));
                    }
                    break;
                case "INF":
                    System.out.println("Notes count = " + mySecretNotepad.getNotesCount());
                    System.out.println("Space available = " + mySecretNotepad.getSpaceInfo());
                    break;
                case "OUT":
                    shouldContinue = false;
                    break;
                default:
                    printAnError("");
                    break;
            }
        }
        while (shouldContinue);
        in.close();
    }

    private static void printAnError(String error) {
        switch (error) {
            case "Empty":
                System.out.println("Your Notepad is empty.");
                break;
            case "NotFound":
                System.out.println("There is no such note's number.");
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
