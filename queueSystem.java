
import java.util.*;

public class queueSystem {

	public static Scanner userInput = new Scanner(System.in); //SCANNER THAT CAN BE ACCESSED BY ALL METHODS

	public static String[] arrayOfNames = new String[50]; //ARRAY THAT CAN BE ACCESSED BY ALL METHODS
	public static void main(String[] args) {
		String name, select;
		int queueNumber;
		arrayOfNames[0] = "Mika";
		arrayOfNames[1] = "Ron";
		boolean queueSystem = true;
		System.out.println("Welcome to <DEFAULT NAME> queueing system.");

		while (queueSystem) {
			for (queueNumber = 0; queueNumber < arrayOfNames.length && arrayOfNames[queueNumber] != null; queueNumber++) {} //SETS THE ARRAY AND CURRENT AVAILABLE QUEUE NUMBER

			String QUESTION_PROMPT = (arrayOfNames[2] == null) ? "Enter a name to get started: " : "Enter a name: "; //TERNARY OPERATOR TO CHECK IF USER IS NEW OR NOT


			System.out.print(QUESTION_PROMPT);
			name = enterName(); //CALLS enterName METHOD AND RETURNS A VALUE
			arrayOfNames[queueNumber] = name;

			System.out.println("The queue is: "); //prints the array that doesn't have a null value
			for (queueNumber = 0; queueNumber < arrayOfNames.length && arrayOfNames[queueNumber] != null; queueNumber++) {
				if (arrayOfNames[queueNumber] != null && !arrayOfNames[queueNumber].equals("")) {
					System.out.println("Number " + (queueNumber + 1) + " " + arrayOfNames[queueNumber]);
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
				if(arrayOfNames != null){
					queueUp(arrayOfNames);
					break;
				} else {
					main(arrayOfNames);
				}
			case "X":
				System.out.println("Exiting program! Thank you for using <DEFAULT NAME> queuing system");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice!");
			}
			break;
		}
	}
	// change into void
	static String queueUp(String[] arrayOfNames) {//REMOVES THE VALUE OF THE FIRST INDEX AND MOVES THE OTHER VALUES TO THE LEFT
			int length = arrayOfNames.length;
			String select = "";

			for (int i = 1; i < length; i++) {
				arrayOfNames[i - 1] = arrayOfNames[i];
			}

			arrayOfNames[length - 1] = null;

			System.out.println("The queue is now:");
			for (int i = 0; i < arrayOfNames.length && arrayOfNames[i] != null; i++) {
				System.out.println("Number " + (i + 1) + " " + arrayOfNames[i]);
			}

			System.out.println("============");
			System.out.println("Enter 'Y' if you want to add a new user");
			System.out.println("Enter 'R' if you want to move the queue up");
			System.out.println("Enter 'X' if you want to exit the program");
			return select;
	}

	static String enterName() { //THIS METHOD CHECKS IF THE INPUT IS VALID AND RETURNS IT
		String name = "";
		boolean flag = true;
		while (flag) {
			name = userInput.nextLine();
			if (name.length() < 2) {
				System.out.println("Please enter a valid name");
				continue;
			} else {
				flag = false;
			}
		}
		return name;
	}


}