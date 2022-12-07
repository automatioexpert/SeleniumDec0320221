/*Command Line Arguments are used to pass information to the program from command line*/
/*Example Command:- java CommandLineArguments Hello Java World*/
/*The data get passed as strings in the String array argument of the main() method*/
package arguments;

public class CommandLineArguments {

	public static void main(String[] args) {

		for (String argument : args) {
			System.out.println("Argument passed is: " + argument);
		}

	}

}
