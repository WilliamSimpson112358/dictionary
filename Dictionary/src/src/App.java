package src;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class App { 
    private static Dictionary dictionary = new Dictionary(); 
    
    public static void main(String[] args) throws Exception { 
        dictionaryApplication(); 
    }
 
private static void dictionaryApplication() { 
    Scanner scanIn = new Scanner(System.in); 
    String commandInput;
 
    do { 
        System.out.println(">>> "); 
        commandInput = scanIn.nextLine(); 
        List<String> splitCommand = Arrays.asList(commandInput.split(" "));
 
        switch(splitCommand.get(0)) {
            case "ADD": 
                if (splitCommand.size() != 3) { 
                    System.out.println("Incomplete command, please specify at least one KEY and MEMBER to add.");
                } else { 
                    dictionary.add(splitCommand.get(1), splitCommand.get(2));
                    System.out.println("Added the MEMBER: " + splitCommand.get(2) + ", to the KEY: " + splitCommand.get(1));
                } 
            break;
 
            case "ALLMEMBERS":
                if (splitCommand.size() != 1) { 
                    System.out.println("Invalid command, please provide a valid command");
                } else {
                    List<String> membersList = dictionary.getAllMembers();
                    if (membersList == null) {
                        System.out.println("The dictionary has no MEMBERS currently.");
                    }
                    else {
                        int memberOrder = 0;
                        for (String member : membersList) {
                            System.out.println(++memberOrder + ". " + member);
                        }
                        // System.out.println();
                    }
                }
            break;
 
            case "CLEAR":
                if (splitCommand.size() != 1) {
                    System.out.println("Invalid command, please provide a valid command");
                    System.out.println("Valid commands: KEYS, CLEAR, QUIT, MEMBERS <key>, ADD <key> <value>, REMOVE <key> <value>, REMOVALL <key>");
                } else {
                    dictionary.clear();
                    System.out.println("Dictionary has been cleared.");
                }
            break;
 
            case "HELP":
                if (splitCommand.size() != 1) {
                    System.out.println("Command List: ADD <key> <value>, ADDMANY <key> <value1> <value2...> ");
                    System.out.println("CLEAR, KEYS, MEMBERS <key>, QUIT, REMOVE <key> <value>, REMOVEALL <key>");
                    System.out.println("REMOVEMANY <key> <value1> <value2...>");
                }
            break;
 
            case "KEYEXISTS":
            if (splitCommand.size() != 2) {
                System.out.println("Invalid command, please provide a valid command"); 
                System.out.println("Valid command: KEYEXISTS <key>.");
            } else {
                dictionary.hasKey(splitCommand.get(1));
            }
            break;
 
            case "KEYS": 
                if (splitCommand.size() != 1) { 
                    System.out.println("Invalid command, please provide a valid command"); 
                    System.out.println("Valid commands: KEYS, CLEAR, QUIT, MEMBERS <key>, ADD <key> <value>, REMOVE <key> <value>, REMOVALL <key>");
                } else { 
                    Set<String> keys = dictionary.getKeys(); 
                    if (keys == null) { 
                        System.out.println("The dictionary is currently empty");
                    } else { 
                        int keyOrder = 0; 
                        for (String key : keys) { 
                            System.out.println(++keyOrder + ". " + key);
                            	}
                        }
                    } 
            break;
 
            case "MEMBERS": 
            if (splitCommand.size() != 2) { 
                System.out.println("Invalid command, please provide a valid command"); 
                System.out.println("Valid command: MEMBERS <key>."); 
            } else { 
                Set<String> values = dictionary.getValues(splitCommand.get(1)); 
                int valueOrder = 0; 
                for (String value : values) { 
                    System.out.println(++valueOrder + ". " + value);
                }
            }
            break;
 
            case "QUIT":
            break;
 
            case "REMOVE": 
                if (splitCommand.size() != 3 ) { 
                    System.out.println("Incomplete command, please specify at least one KEY and MEMBER to remove.");
                } else { 
                    dictionary.remove(splitCommand.get(1), splitCommand.get(2)); 
                    System.out.println(" Removed MEMBER: " + splitCommand.get(2) + " from the KEY: " + splitCommand.get(1));
                } 
            break;
 
            case "REMOVEALL":
                if (splitCommand.size() != 2) {
                    System.out.println("Incomplete command, please specify a KEY to remove it's MEMBERS");
                } else {
                    dictionary.removeAll(splitCommand.get(1));
                    System.out.println("Removed all MEMBERS from the key: " + splitCommand.get(1));
                }
            break;
 
            case "VALUEEXISTS":
            if (splitCommand.size() != 2) {
                System.out.println("Invalid command, please provide a valid command"); 
                System.out.println("Valid command: VALUEEXISTS <key>.");
            } else {
                dictionary.hasMember(splitCommand.get(1), splitCommand.get(2));
            }
            break;
        }
    }   while (!commandInput.equals("QUIT")); 
    scanIn.close();
    }
}
