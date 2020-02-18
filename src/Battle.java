public class Battle {
    public static void untilDeath( Character you, Character monster )
    {
        while( you.isAlive() && monster.isAlive() )
        {
            // Attack alone
            you.pickAction(monster);
            monster.attack(you);
        }

        if( !you.isAlive() ) System.out.println( "You were killed in battle." );
        if( !monster.isAlive() ) System.out.println( monster.getName() + " was killed in battle." );
    }
    public static void untilDeath( Character you, Character monster, Character companion )
    {
        while( you.isAlive() && monster.isAlive() )
        {
            // Attack with a companion
            you.pickAction(monster);
            companion.attack(monster);
            monster.attack(you);
        }

        if( !you.isAlive() ) System.out.println( "You were killed in battle." );
        if( !monster.isAlive() ) System.out.println( monster.getName() + " was killed in battle." );
    }
}
