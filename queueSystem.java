
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class queueSystem {

    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd h:mm:ss a");  

    static Scanner userInput = new Scanner(System.in); // SCANNER THAT CAN BE ACCESSED BY ALL METHODS

    static String[] arrayOfNames = new String[50]; // ARRAY THAT CAN BE ACCESSED BY ALL METHODS

    static String[] arrayOfTimes = new String[50];
    public static void main(String[] args) {
        System.out.println("Welcome to <DEFAULT NAME> queueing system.");
        arrayOfNames[0] = "Mika";
        arrayOfNames[1] = "Ron";
        arrayOfTimes[0] = getCurrentTime();
        arrayOfTimes[1] = getCurrentTime();
        mainProcess(arrayOfNames);
    }

    static void mainProcess(String[] arrayOfNames) {
        String name, select;
        int queueNumber;
        boolean queueSystem = true;

        while (queueSystem) {
            for (queueNumber = 0; queueNumber < arrayOfNames.length && arrayOfNames[queueNumber] != null; queueNumber++) {} // SETS THE ARRAY AND CURRENT AVAILABLE QUEUE NUMBER

            String QUESTION_PROMPT = (arrayOfNames[2] == null) ? "Enter a name to get started: " : "Enter a name: "; // TERNARY OPERATOR TO CHECK
            System.out.print(QUESTION_PROMPT);
            name = enterName(); // CALLS enterName METHOD AND RETURNS A VALUE
            arrayOfNames[queueNumber] = name;
            arrayOfTimes[queueNumber] = getCurrentTime();

            System.out.println("The queue is: "); // prints the array that doesn't have a null value
            for (queueNumber = 0; queueNumber < arrayOfNames.length && arrayOfNames[queueNumber] != null; queueNumber++) {
                if (arrayOfNames[queueNumber] != null && !arrayOfNames[queueNumber].equals("")) {
                    System.out.print("Number " + (queueNumber + 1) + " " + arrayOfNames[queueNumber]);
                    System.out.println(" at " + arrayOfTimes[queueNumber]);
                }
            }

            System.out.println("============");
            System.out.println("Enter 'Y' if you want to add a new user");
            System.out.println("Enter 'R' if you want to move the queue up");
            System.out.println("Enter 'X' if you want to exit the program");

            boolean selectionScreen = true;
            while (selectionScreen) {
                select = userInput.nextLine();
                if (select.equalsIgnoreCase("Y")) {
                    break;
                } else if (select.equalsIgnoreCase("X") || select.equalsIgnoreCase("R")) {
                    selectionProcess(select, arrayOfNames);
                } else {
                    System.out.println("Invalid choice, please try again!");
                    continue;
                }
            }
        }
    }

    static void selectionProcess(String userSelect, String[] arrayOfNames) {
        boolean selectionProcess = true;
        while (selectionProcess) {
            switch (userSelect.toUpperCase()) {
                case "Y":
                    break;
                case "R":
                    if (arrayOfNames[0] != null) {
                        queueUp(arrayOfNames, arrayOfTimes);
                        break;
                    } else {
                        promptUserRestart(arrayOfNames);
                    }
                    break;
                case "X":
                    System.out.println("Exiting program! Thank you for using <DEFAULT NAME> queuing system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            break;
        }
    }

    static void promptUserRestart(String[] arrayOfNames) {
            String restartProgramResponse;
            System.out.print("The queue is empty. Do you want to continue the program? Y/N:");
            restartProgramResponse = userInput.nextLine().toUpperCase();

            if (restartProgramResponse.equals("Y")) {
                mainProcess(arrayOfNames);
            } else if (restartProgramResponse.equals("N")) {
                System.out.println("Shutting down! Thank you for using <DEFAULT NAME> queue system.");
                System.exit(0);
            } else {
                System.out.print("Invalid response! Try again: ");
                promptUserRestart(arrayOfNames);
            }
        }

    static void queueUp(String[] arrayOfNames, String[] arrayOfTimes) { // REMOVES THE VALUE OF THE FIRST INDEX AND MOVES THE OTHER VALUES UP
        int length = arrayOfNames.length;

        for (int i = 1; i < length; i++) {
            arrayOfNames[i - 1] = arrayOfNames[i];
        }

        arrayOfNames[length - 1] = null;

        System.out.println("The queue is now:");

        for (int queueNumber = 0; queueNumber < arrayOfNames.length && arrayOfNames[queueNumber] != null; queueNumber++) {
            System.out.print("Number " + (queueNumber + 1) + " " + arrayOfNames[queueNumber]);
            System.out.println(" at " + arrayOfTimes[queueNumber + 1]);
        }
        System.out.println("============");
        System.out.println("Enter 'Y' if you want to add a new user");
        System.out.println("Enter 'R' if you want to move the queue up");
        System.out.println("Enter 'X' if you want to exit the program");
        }

    static String getCurrentTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String currentTime = dateTimeFormatter.format(localDateTime);
        return currentTime;
        }

    static String enterName() { // THIS METHOD CHECKS IF THE INPUT IS VALID AND RETURNS IT
        String name = "";
        boolean flag = true;
        while (flag) {
            name = userInput.nextLine();
            if (name.length() < 2 || name.isEmpty() || name.isBlank()) {
                System.out.print("Please enter a valid name:");
                continue;
            } else {
                flag = false;
            }
        }
        return name;
    }
}