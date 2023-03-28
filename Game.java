/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap<String, Room> rooms = new HashMap<String, Room>();
    private Player player = new Player();
    
    public Game() {
        createRooms();
        player.setCurrentRoom(rooms.get("outside"));
    }
    
    private void createRooms() {
        Room outside, theater, pub, lab, office;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // add items to the rooms
        outside.addItem(new Item("map", "a map of the university", 0.2));
        theater.addItem(new Item("projector", "a high-definition projector", 4.0));
        pub.addItem(new Item("beer", "a pint of beer", 0.5));
        lab.addItem(new Item("computer", "a high-performance computer", 10.0));
        office.addItem(new Item("printer", "a color printer", 3.0));

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        theater.setExit("west", outside);
        pub.setExit("east", outside);
        lab.setExit("north", outside);
        lab.setExit("east", office);
        office.setExit("west", lab);

        rooms.put("outside", outside);
        rooms.put("theater", theater);
        rooms.put("pub", pub);
        rooms.put("lab", lab);
        rooms.put("office", office);
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go, back, help, quit, take, drop, inventory");
    }

    private void printLocationInfo() {
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits:");
        for (String exit : currentRoom.getExits().keySet()) {
            System.out.print(" " + exit);
        }
        System.out.println();
        if (!currentRoom.getItems().isEmpty()) {
            System.out.println("Items:");
            for (Item item : currentRoom.getItems()) {
                System.out.println(item.getName() + " - " + item.getDescription() + " (" + item.getWeight() + " kg)");
            }
        }
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Scanner reader = new Scanner(System.in);
            System.out.print("> ");
            String command = reader.nextLine();
            CommandParser commandParser = new CommandParser(command);
            finished = commandParser.executeCommand(currentRoom, player, rooms);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
}

