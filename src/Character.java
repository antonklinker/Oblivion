import java.util.Scanner;
public class Character {
    Scanner scanner = new Scanner(System.in);

    private int healthPot = 20;

    private int starsign=0;

    // This is used in the pickAction void
    private int pickAttack=0;

    // Determines the strength of each attribute
    private int magicStrength;
    private int stealthStrength;
    private int strengthStrength;

    private int enemyStrength;

    // Determines if your strength should increase
    private int magicProg;
    private int stealthProg;
    private int strengthProg;

    // Determines how much damage you will give and receive
    private int damage;

    // Your standard health points
    private int health=200;

    private String name;

    // GETTERS

    public String getName() { return name; }

    public void setName(String name) { this.name=name;}

    public void setHealth(int health) {this.health=health;}

    public void setHealthPot(int healthPot) {this.healthPot=healthPot;}

    // GETTERS THAT ARE NOT USED
    public int getMagicStrength() {
        return magicStrength;
    }

    public int getStealthStrength() {
        return stealthStrength;
    }

    public int getStrengthStrength() {
        return strengthStrength;
    }


    Character (String name, int magicStrength, int stealthStrength, int strengthStrength) {
        this.name=name;
        this.magicStrength=magicStrength;
        this.stealthStrength=stealthStrength;
        this.strengthStrength=strengthStrength;

    }

    Character (String name, int health, int strength) {
        this.name=name;
        this.enemyStrength=strength;
        this.health=health;

    }


    public void pickAction(Character other) {

        System.out.println("\t\"1\" Attack with magic\n\t\"2\" Attack with stealth\n\t\"3\" Attack with strength" +
                "\n\n\t\"4\" Drink health potion");

        Option chosenOption = null;
        while (chosenOption==null) {
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                pickAttack=1;
                break;
            } else if (choice.equals("2")) {
                pickAttack=2;
                break;
            } else if (choice.equals("3")) {
                pickAttack=3;
                break;
            } else if (choice.equals("4")) {
                pickAttack=4;
                break;
            } else {
                System.out.println("That is not a valid input. Try again.");
            }
        }


        if (pickAttack == 1) {
            // MAGIC
            damage = magicStrength/2 + (int) (Math.random() * magicStrength/2);
            other.health-=damage;

            System.out.println(name + " hits " + other.name + " for " + damage + " damage. " + other.name + " now has " +
                    + other.health + " health left.");

            // Every time a type of attack has been used three times, that type will be stronger
            magicProg++;
            if (magicProg % 3 == 0) {
                magicStrength = magicStrength + 1 + (int) (Math.random() * 3);
                System.out.println("\tYour skills in the mystic arts has grown. You now have " + magicStrength + " points in the destruction tree.");
            }
        }
        else if (pickAttack==2) {
            // STEALTH
            damage = stealthStrength/2 + (int) (Math.random() * stealthStrength/2);
            other.health-=damage;

            System.out.println(name + " hits " + other.name + " for " + damage + " damage. " + other.name + " now has " +
                    + other.health + " health left.");

            // Every time a type of attack has been used three times, that type will be stronger
            stealthProg++;
            if (stealthProg%3==0) {
                stealthStrength=stealthStrength + 1 + (int) (Math.random() * 3);
                System.out.println("\tYour ability to remain unseen has grown. You now have " + stealthStrength + " points in the stealth tree.");
            }

        }
        else if (pickAttack==3) {
            // STRENGTH
            damage = strengthStrength/2 + (int) (Math.random() * strengthStrength/2);
            other.health-=damage;

            System.out.println(name + " hits " + other.name + " for " + damage + " damage. " + other.name + " now has " +
                    + other.health + " health left.");

            // Every time a type of attack has been used three times, that type will be stronger
            strengthProg++;
            if (strengthProg%3==0) {
                strengthStrength=strengthStrength + 1 + (int) (Math.random() * 3);
                System.out.println("\tYour strength and brute force has grown. You now have " + strengthStrength + " points in physical strength.");
            }

        }
        else if (pickAttack==4) {
            // HEALTH POTION
            if (healthPot>0) {
                health = health+100;
                if (health>200) {health=200;}
                healthPot--;
                System.out.printf("\tYou health is restored to %d.\n", health);
                System.out.printf("\t\tRemaining health potions: %d\n", healthPot);
            } else {
                System.out.println("You don't have any health potions left");
            }
        }


    }

    public void attack(Character other) {
        damage = enemyStrength/2 + (int) (Math.random() * enemyStrength/2);
        other.health-=damage;

        if (damage!=0) {
            System.out.println(name + " hits " + other.name + " for " + damage + " damage. " + other.name + " now has " +
                    +other.health + " health left.");
        } else {
            System.out.println(name + " doesn't hit back.");
        }

    }


    public void pickStarsign() {
        while(starsign==0) {
            System.out.println("\nPick a starsign.");
            System.out.println("\t(1) Wizard");
            System.out.println("\t(2) Assassin");
            System.out.println("\t(3) Fighter");
            Option chosenOption = null;
            while (chosenOption==null) {
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    starsign=1;
                    break;
                } else if (choice.equals("2")) {
                    starsign=2;
                    break;
                } else if (choice.equals("3")) {
                    starsign=3;
                    break;
                } else {
                    System.out.println("That is not a valid input. Try again.");
                }
            }
            if (starsign == 1) {
                magicStrength = 35;
            } else if (starsign == 2) {
                stealthStrength = 35;
            } else if (starsign == 3) {
                strengthStrength = 35;
            } else {
                System.out.println("That was not one of options you were given. Try again.");
                starsign=0;
            }
        }
    }

    public boolean isAlive() {
        if (health>0)  return true;
        else return false;
    }
}
