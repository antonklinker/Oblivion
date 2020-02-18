import java.util.Scanner;
public class Main {


    public static Scanner scanner;
    public static Character you;

    static Situation[] situations;

    public static void main(String[] args) {

        // INITIATING ALL CHARACTERS
        you = new Character("TEMP", 20, 20, 20);

        scanner = new Scanner(System.in);


        Storyline storyline = new Storyline();

        // FIRST PART OF THE STORY
        storyline.partOne();


        // SELECTING YOUR CHARACTERS NAME
        System.out.println("\nPick a name for your character: ");
        you.setName(scanner.nextLine());

            System.out.println("\nTHE EMPEROR: ");
            System.out.println("\t- ''" + you.getName() + ".. Ahh yes, I see now.. My time must be short." +
                    " Which stars were showing on the day of your birth, " + you.getName() + "?''");

            // PICKING A STARSIGN THAT DETERMINES YOUR STRENGTHS
            you.pickStarsign();

            // SECOND PART OF THE STORY
            storyline.partTwo(you.getName());

                while (you.isAlive()) {
                    you.setHealth(200);
                    you.setHealthPot(20);
                    populateWorld();
                    playRecursive(situations[1]);
                }







    }

    static void playRecursive( Situation situation )
    {
        // Let the situation decide the next situation.
        Situation nextSituation = situation.play();

        // If we have a next situation, play it.

            if (nextSituation != null) {
                playRecursive(nextSituation);
            }



    }
    static void populateWorld() {
        situations = new Situation[]{
                // 0
                new Situation("_CREDITS_"),

                // 1
                new Situation("__Choose a path__"),
                // 2
                new Situation("__Join or refuse the Dark Brotherhood__"),
                // 3
                new Situation("__Kill the Dark Brotherhood__"),
                // 4
                new Situation("__Kill the Dark Brotherhood__"),
                // 5
                new Situation("__Kill the Dark Brotherhood__"),
                // 6
                new Situation("__Kill Rufio at the Inn of Ill Omen__"),
                // 7
                new Situation("__A guard catches you__"),
                // 8
                new Situation("__A guard catches you!__"),
                // 9
                new Situation("__Dark Brotherhood completed__"),
                // 10
                new Situation("__Joining the Mages guild__"),
                // 11
                new Situation("__Mages Guild under attack!__"),
                // 12
                new Situation("__Training in magic__"),
                // 13
                new Situation("__Kill the Necromancers!__"),
                // 14
                new Situation("__Kill the Necromancers!__"),
                // 15
                new Situation("__Kill the Necromancers!__"),
                // 16
                new Situation("__Mages Guild completed!__"),
                // 17
                new Situation("__Joining the Necromancers__"),
                // 18
                new Situation("__Kill the Mages Guild!__"),
                // 19
                new Situation("__Kill the Mages Guild!__"),
                // 20
                new Situation("__Kill the Mages Guild!__"),
                // 21
                new Situation("__Necromancer questline completed!__"),
                // 22
                new Situation("__A dark and cold welcome__"),
                // 23
                new Situation("__Practice__"),
                // 24
                new Situation("__Adamus Phillida__"),
                // 25
                new Situation("__Finding Brother Jauffre__"),
                // 26
                new Situation("__Kvatch__"),
                // 27
                new Situation("__Inside the Oblivion gate__"),
                // 28
                new Situation("__Travel to the Imperial City__"),
                // 29
                new Situation("__At the Imperial city__"),
                // 30
                new Situation("__Fighting your way into the town square__"),
                // 31
                new Situation("__Fighting your way into the town square__"),
                // 32
                new Situation("__Fighting Mehrunes Dagon__"),
                // 33
                new Situation("__Fighting Mehrunes Dagon__"),
                // 34
                new Situation("__ENDGAME__"),
                // 35
                new Situation("__Free as a bird in the land of Cyrodiil__"),
                // 36
                new Situation("__Deerhunting__"),
                // 37
                new Situation("__The ugly ogre__"),
                // 38
                new Situation("__Play again__"),
                // 39
                new Situation("__You have been killed__"),





        };
        situations[0].setContent(
                "THANK YOU FOR PLAYING. WE HOPE YOU ENJOYED IT. BEST REGARDS:\nFrederik, Jonathan & Anton",
                        new Option[]{
                                new Option("1", "Play again? You current strength remains the same and you will receive another 20 health potions.", situations[38]),
                        }
        );
        situations[1].setContent(
                "\nThe fresh air enters your lungs, you feel the sun on your face and all around you\nare the vast mountains of Cyrodiil. What do you do next?" +
                        " ",
                new Option[]{
                        new Option("1","Seek out the assassins guild called the Dark Brotherhood", situations[2] ),
                        new Option("2","Seek out the Mages Guild", situations[10] ),
                        new Option("3","Seek out Brother Jauffre", situations[25] )
                }
        );

        //THE DARK BROTHERHOOD
        situations[2].setContent(
                "\nYou've found the Dark Brotherhood. In order to join, Lucien Lachance, the speaker of the Dark Brotherhood, asks you to kill someone called Rufio",
                new Option[]{
                        new Option("1","Accept", situations[6] ),
                        new Option("2","Refuse", situations[3] )
                }
        );
        situations[3].setContent(
                "\nYou engage in combat with Lucien Lachance",
                new Character( "Lucien Lachance", 100, 10),
                situations[4]
        );
        situations[4].setContent(
                "\nYou engage in combat with Vincente Valtieri, the vampire member of the Dark Brotherhood",
                new Character( "Vincente Valtieri", 100, 10),
                situations[5]
        );
        situations[5].setContent(
                "\nYou engage in combat with Mathieu Bellamont, the mage assassin of the Dark Brotherhood",
                new Character( "Mathieu Bellamont", 100, 10),
                situations[1]
        );
        situations[6].setContent(
                "\nYou enter the Inn of Ill Omen, the last known location of Rufio. After asking around, you find the room where he sleeps. Rufio sleeps soundly.\n ",
                new Character( "Rufio", 50, 10),
                situations[8]
        );
        situations[8].setContent(
                "\nGUARD:\n\t- \"STOP RIGHT THERE, CRIMINAL SCUM! You've violated the law, pay with your blood!\"",
                new Character( "Guard", 100, 30),
                situations[22]
        );
        situations[22].setContent(
                "\nLUCIEN LACHANCE:\n\t- \"You've done well... Our leader, The Night Mother, is proud...\n\t\tI have another quest for you, if you're up for it.\n\t\tAdamus Phillida, a warrior who have pledged his life\n\t\tto destroy the Dark Brotherhood must be killed, what do you say?\"",
                new Option[]{
                        new Option("1", "Accept", situations[23]),
                        new Option("2", "Refuse", situations[9] )
                }
        );
        situations[23].setContent(
                "In order to kill Adamus Phillida, you must practice your skills as an assassin",
                new Character("Practice dummy", 400, 0),
                situations[24]
        );
        situations[24].setContent(
                "After a lot of practice, you are now ready to take down Adamus Phillida. You travel to Leyawiin, and sneak up on him... He sees you! let the battle commence!",
                new Character("Adamus Phillida", 250, 70),
                situations[9]
        );
        situations[9].setContent(
                "\nCongratulations! You are now a master assassin of the Dark Brotherhood!",
                new Option[]{
                        new Option( "1", "Seek out the Mages Guild", situations[10] ),
                        new Option( "2", "Find Brother Jauffre", situations[25] )
                }
        );


        // MAGES GUILD
        situations[10].setContent(
                "\nThe Arch Mage shows you around the Mages guild whilst explaining it's history...",
                new Option[] {
                        new Option("1", "Continue", situations[11] )
                }
        );
        situations[11].setContent(
                "\nAll of a sudden the Mages Guild is under attack by their biggest threat, the Necromancers. As a surprise,\nthe Necromancers asks you to join them!",
                new Option[] {
                        new Option( "1", "Join Mages Guild", situations[12] ),
                        new Option( "2", "Join the Necromancers", situations[17])
                }
        );
        situations[12].setContent(
                "\nThe mages succeed in fighting the necromancers. For now. Now you can start your training. On your path to\nbecome a better magician, you're forced to train your magic skills against a dummy",
                new Character ( "Target Dummy", 400, 0),
                situations[13]
        );
        situations[13].setContent(
                "\nIn order to become a guardian of Tamriel, you need to destroy the Necromancers!\nYour first opponent is a novice necromancer",
                new Character("Novice necromancer", 120, 8),
                situations[14]
        );
        situations[14].setContent(
                "\nNext up is an adept necromancer. He should be no problem for you.",
                new Character("Adept necromancer", 160, 15),
                situations[15]
        );
        situations[15].setContent(
                "\nMannimarco, the leader of the evil guild, has received the word, that you were killing his members.\nHe has tracked you down and casts a harmful spell towards you" +
                        " but you manage to dodge it.\nGet ready to fight.",
                new Character( "Mannimarco", 200, 30),
                situations[16]
        );
        situations[16].setContent(
                "\nCongratulations! You and the rest of the Mages Guild have eliminated every necromancer in Tamriel.\nWatch your back. They will be back.",
                new Option[]{
                        new Option("1", "The Dark Brotherhood", situations[2] ),
                        new Option("2", "Return the Amulet of Kings", situations[25] )
                }
        );
        situations[17].setContent(
                "\nYou've chosen to join the Necromancers. A dark and powerful path. First you need to train your magic skills\n on the corpse of a high elf.",
                new Character ("Dead high elf", 400, 0),
                situations[18]
        );
        situations[18].setContent(
                "\nIn order to become a master Necromancer, you're asked to destroy the Mages Guild!\nYour first opponent is a novice mage",
                new Character("Novice mage", 60, 18),
                situations[19]
        );
        situations[19].setContent(
                "Just as the novice takes his final breath, an adept mage appears.",
                new Character("Adept mage", 80, 25),
                situations[20]
        );
        situations[20].setContent(
                "While you were fighting the other members of the Mages Guild, the Arch-Mage fled to his tower.\nYou enter his tower and climb up the stairs." +
                        "\nThe door to his quarters are barricaded with a magical barrier, but that's not a problem for you.\nThe barrier is removed and the door blew open." +
                        "Inside you see the coward of an Arch-Mage. Kill him.",
                new Character("Arch-Mage", 100, 50),
                situations[21]
        );
        situations[21].setContent(
                "\nCongratulations! You have killed every member of the weak Mages Guild.\nThe necromancers have no more work for you at the moment.",
                new Option[]{
                        new Option("1", "The Dark Brotherhood", situations[2] ),
                        new Option("2", "Return the Amulet of Kings", situations[25] )
                }
        );

        // MAIN QUESTLINE
        situations[25].setContent(
                "You've found Brother Jauffre at the Weynon Priory. You encounter him to tell the sad news regarding the emperor",
                new Option[]{
                        new Option("1", "Mention the Amulet of Kings", situations[26] )
                }
        );
        situations[26].setContent(
                "Jauffre mentions that Brother Martin is the illegitimate son of the emperor, and that you need to find him.\n You ride to Kvatch to find that the city is guarded by an Oblivion gate\nYou can either help close the gate in order to find Martin, or flee and roam free",
                new Option[]{
                        new Option("1", "Help close the Oblivion Gate", situations[27] ),
                        new Option("2", "Free roam", situations[35])
                }
        );
        situations[27].setContent(
                "You enter the Oblivion gate and encounter a Daedric Prince! The Daedric Prince attacks you immediately!",
                new Character("Daedric Prince", 200, 35),
                situations[28]
        );
        situations[28].setContent(
                "After a fierce battle, you finally killed the Daedric prince. The Oblivion gate is closed.\nYou find Brother Martin and deliver the information. He is surprised.\nBrother Jauffre appears and tells you and Martin, that the Prince of darkness, Mehrunes Dagon,\nhas taken over the Imperial city, and that we must hurry to stop him!",

                new Option[]{
                        new Option("1", "Ride with Brother Martin", situations[29]),
                        new Option("2", "Ride with Brother Jauffre", situations[29])
                }
        );
        situations[29].setContent(
                "You are surrounded by chaos. A whelp attacks you! ",
                new Character("Whelp", 150, 30),
                situations[30]
        );
        situations[30].setContent(
                "Another whelp attacks you!!",
                new Character("Whelp", 150, 30),
                situations[31]
        );
        situations[31].setContent(
                "And another one ;)",
                new Character("Whelp", 150, 30),
                situations[32]
        );
        situations[32].setContent(
                "You get to the town square and encounter Mehrunes Dagon. Never have you ever seen such a horrific sight!\nBut you never back down!\nWith the heart of a true hero and the strength of a lion you commence to battle!",
                new Character( "Mehrunes Dagon", 500, 20),
                situations[33]
        );
        situations[33].setContent(
                "The battle is tough but Mehrunes Dagon has retreated to heal up... All of a sudden brother Martin has taken shape of a dragon! He helps you battle Mehrunes Dagon!",
                new Character( "Mehrunes Dagon", 2000, 50),
                new Character( "Brother Martin", 5000, 300),
                situations[34]
        );
        situations[34].setContent(
                "The battle is over... Finally!\nThe people of Cyrodiil thanks you. Without your help, this wouldn't have been possible. YOU ARE A TRUE HERO!",
                new Option[]{
                        new Option("1", "Congratulations", situations[0])
                }
        );
        situations[35].setContent(
                "You ride around free to do as you want",
                new Option[]{
                        new Option("1", "Kill a deer", situations[36]),
                        new Option("2", "Kill an ogre", situations[37]),
                        new Option("3", "Return to Kvatch", situations[26]),
                        new Option("4", "Seek out the Dark Brotherhood", situations[2]),
                        new Option("5", "Seek out the Mages Guild", situations[10])
                }
        );
        situations[36].setContent(
                "You encounter a wild deer with the goal of slaying the wild beauty!",
                new Character ("Deer", 10, 5),
                situations[35]
        );
        situations[37].setContent(
                "You encounter a wild Ogre! He looks at you with an angry ugly ogre face... The battle begins!",
                new Character("Ogre", 200, 30),
                situations[35]
        );
        situations[38].setContent(
                "You have decided to play again. Good luck."
        );
        situations[39].setContent(
                "You have been killed. Do you wish to play again?",
                new Option[]{
                        new Option("1", "Of course", situations[38]),
                }
        );
    }
}
