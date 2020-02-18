import java.util.Scanner;
public class Situation
{
    Scanner scanner = new Scanner(System.in);
    private String text;
    private String title;
    private Option[] options;
    private Character monster;
    private Character companion;

    // Getters.
    public String getTitle(){ return title; }


    public Situation( String title )
    {
        this.title = title;
    }

    public void setContent( String text )
    {
        // This function is used when you're in a situation that only contains text
        this.text = text;
    }


    public void setContent( String text, Option[] options )
    {
        // This function is used when you're in a situation that only contains options
        this.text = text;
        this.options = options;
    }


    public void setContent( String text, Character monster, Situation winSituation )
    {
        // This function is used when you're on your own in a battle
        this.text = text;
        this.monster = monster;
        // Battles have only two possible outcomes; end game or go to the winning situation.
        options = new Option[]{ new Option( " Win", winSituation ) };
    }

    public void setContent( String text, Character monster, Character companion, Situation winSituation )
    {
        // This function is used when you have a companion to help you in battle
        this.text = text;
        this.monster = monster;
        this.companion = companion;
        // Battles have only two possible outcomes; end game or go to the winning situation.
        options = new Option[]{ new Option( " Win", winSituation ) };
    }


    public Situation play()
    {
        System.out.println();
        System.out.println( title );
        System.out.println(text);

        // If no options, return null.
        if( options == null ) return null;

        if( monster != null ){
            // Engage in battle

            // If you have anyone to help you
            if( companion != null) {
                Battle.untilDeath(Main.you, monster, companion);
            } else {
                // If you don't have any companion for this battle
                Battle.untilDeath(Main.you, monster);
            }

            if( Main.you.isAlive()) {
                return options[0].getConsequence();
            }
            else return null;
        } else {
            // Choose option.
            Option selectedOption = getOptionSelectedByUser();
            return selectedOption.getConsequence();
        }
    }


    private Option getOptionSelectedByUser()
    {
        // Display options.
        System.out.print( "Choose:" );
        for( Option option : options ){
            System.out.printf( "\n\t\"%s\"\t%s", option.getKeyword(), option.getDescription() );
        }
        System.out.println();

        // Let the user choose an option.
        Option chosenOption = null;
        while( chosenOption == null ){
            String choice = scanner.nextLine();
            for( Option option : options ){
                if( choice.equals( option.getKeyword() ) ){
                    chosenOption = option;
                    break;
                }
            }
            if( chosenOption == null ) {
                System.out.println( "Sorry that is not a valid choice. Try again." );
            }
        }
        return chosenOption;
    }


    // Is not used
   public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( String.format( "%s\n", title ) );
        if( options != null && options.length > 0 ){
            sb.append( "Options\n" );
            for( Option option : options ) sb.append( "\t" + option + "\n" );
        }
        return sb.toString();
    }
}