public class Option
{
    private String description;
    private String keyword;
    private Situation consequence;

    // getters.
    public String getKeyword(){ return keyword; }
    public String getDescription(){ return description;}
    public Situation getConsequence(){ return consequence; }


   public Option( String keyword, String description, Situation consequence )
    {
        this.description = description;
        this.keyword = keyword;
        this.consequence = consequence;
    }

    public Option( String keyword, Situation consequence )
    {
        this.keyword = keyword;
        this.consequence = consequence;
    }


    // IS NOT USED
    public String toString(){
        return "\"" + keyword + "\n\t -> " + consequence.getTitle();
    }
}
