import java.util.Scanner;

public class ArtificialIntelligenceChatbot {
    
    // Method to handle chatbot conversation
    public static String getResponse(String input) {
        // Converting the input to lower case for simplicity
        input = input.toLowerCase();

        // Simple responses for different inputs
        if (input.contains("hi") || input.contains("hello")) {
            return "Hello! How can I help you today?";
        } else if (input.contains("how are you")) {
            return "I'm just a bot, but I'm doing great! How about you?";
        } else if (input.contains("bye")) {
            return "Goodbye! Have a nice day!";
        } else if (input.contains("your name")) {
            return "I'm ChatBot. What's yours?";
        } else if (input.contains("help")) {
            return "I'm here to help! Ask me anything.";
        } else {
            return "Sorry, I didn't understand that. Can you try again?";
        }
    }

    public static void main(String[] args) {
        // Creating a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Welcome message
        System.out.println("Welcome to ChatBot! Type 'bye' to exit.");
        
        // Infinite loop to keep the conversation going
        while (true) {
            // Reading user input
            System.out.print("You: ");
            userInput = scanner.nextLine();
            
            // Exit condition
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("ChatBot: Goodbye!");
                break;
            }

            // Respond to the user input
            String response = getResponse(userInput);
            System.out.println("ChatBot: " + response);
        }

        // Close the scanner
        scanner.close();
    }
}
import java.util.Scanner;

public class ArtificialIntelligenceChatbot {
    
    // Method to handle chatbot conversation
    public static String getResponse(String input) {
        // Converting the input to lower case for simplicity
        input = input.toLowerCase();

        // Simple responses for different inputs
        if (input.contains("hi") || input.contains("hello")) {
            return "Hello! How can I help you today?";
        } else if (input.contains("how are you")) {
            return "I'm just a bot, but I'm doing great! How about you?";
        } else if (input.contains("bye")) {
            return "Goodbye! Have a nice day!";
        } else if (input.contains("your name")) {
            return "I'm ChatBot. What's yours?";
        } else if (input.contains("help")) {
            return "I'm here to help! Ask me anything.";
        } else {
            return "Sorry, I didn't understand that. Can you try again?";
        }
    }

    public static void main(String[] args) {
        // Creating a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Welcome message
        System.out.println("Welcome to ChatBot! Type 'bye' to exit.");
        
        // Infinite loop to keep the conversation going
        while (true) {
            // Reading user input
            System.out.print("You: ");
            userInput = scanner.nextLine();
            
            // Exit condition
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("ChatBot: Goodbye!");
                break;
            }

            // Respond to the user input
            String response = getResponse(userInput);
            System.out.println("ChatBot: " + response);
        }

        // Close the scanner
        scanner.close();
    }
}
