import java.util.Scanner;

public class Storyline {

    Scanner scanner = new Scanner(System.in);


    public void partOne() {
        System.out.println(" _______  ______   _       _________         _________ _______  _       \n" +
                "(  ___  )(  ___ \\ ( \\      \\__   __/|\\     /|\\__   __/(  ___  )( (    /|\n" +
                "| (   ) || (   ) )| (         ) (   | )   ( |   ) (   | (   ) ||  \\  ( |\n" +
                "| |   | || (__/ / | |         | |   | |   | |   | |   | |   | ||   \\ | |\n" +
                "| |   | ||  __ (  | |         | |   ( (   ) )   | |   | |   | || (\\ \\) |\n" +
                "| |   | || (  \\ \\ | |         | |    \\ \\_/ /    | |   | |   | || | \\   |\n" +
                "| (___) || )___) )| (____/\\___) (___  \\   /  ___) (___| (___) || )  \\  |\n" +
                "(_______)|/ \\___/ (_______/\\_______/   \\_/   \\_______/(_______)|/    )_)\n" +
                "by Frederik, Jonathan & Anton\n");

        System.out.println("Do you wish to continue? (write anything)");
        scanner.nextLine();
        System.out.println("\nYou wake up to another day in prison and immediately notice footsteps walking towards" +
                " your cell.\nIn this distance you see four heavily armed guards escort someone, but you can't make out whom it might be." +
                "\nAs the guards get closer to your prison cell, you recognize a familiar face. The emperor." +
                "\n\nThe emperor and the guards approach your cell and stops." +
                "\n\nGUARD 1:\n" +
                "\t- \"This cell should be empty. What's going on?\"" +
                "\n\nGUARD 2:\n" +
                "\t- \"Prisoner, I order you to stand back.\"" +
                "\n\nYou stand against the back wall while one of the guards unlocks your cell." +
                "\n\nGUARD 2:\n" +
                "\t- \"If you move, I swear by the Nine Divines, I will end your life.\"" +
                "\n\nThe emperor enters your cell and stares into your eyes." +
                "\n\nTHE EMPEROR:\n" +
                "\t- \"You.. I've seen you in my dreams.. Yes, it is you.. By the Gods.." +
                " What is your name?\"");
    }

    public void partTwo(String name) {
        System.out.println("The emperor and his bodyguards open a secret exit in your cell.");
        System.out.println("\nGUARD 1:");
        System.out.println("\t- \"It's your lucky day..\"");
        System.out.println("\nThe exit seems to lead to an underground sewer system.");
        System.out.println("\nYou decide to follow the emperor and his party of guards.");
        System.out.println("\nAs you come closer to the exit, a group of assassins attacks you.");
        System.out.println("\nOne of the guards asks you to stay with the emperor while the guards fend off the assassins");
        System.out.println("\nTHE EMPEROR: ");
        System.out.println("\t- \"My time is short, " + name + ". Take this.\"");
        System.out.println("\n\t\tThe emperor hands you the Amulet of Kings.");
        System.out.println("\nTHE EMPEROR: ");
        System.out.println("\t- \"You need to take this to Brother Jauffre. The fate of Cyrodil depends on you.\"");
        System.out.println("\nAs the emperor hands you the amulet, one of the assassins emerges from the shadows.");
        System.out.println("\nThe emperor tells you not to worry, as the assassins comes closer.");
        System.out.println("\nOne of the guards rushes towards you, but it's too late. The emperor is dead.");
        System.out.println("\nThe assassins vanishes back into the shadows. The guards looks at you and asks what happened.");
        System.out.println("\nYou tell the guard that the emperor asked you to deliver the Amulet of Kings to Jauffre.");
        System.out.println("\nGUARD 1:");
        System.out.println("\t- \"And so you must do. I don't know what he saw in you, but you have to do it. With haste.\"");
        System.out.println("\nThe guard escorts you to the exit and leaves you there.");
        System.out.println("\nYou have now entered the land of Cyrodil, Tamriel.");
    }


}
