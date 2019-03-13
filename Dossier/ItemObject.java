/**
 * ItemObject store data about an item/task
 * 
 * @author  Nathan Chen
 * @version 3-12-19
 */
public class ItemObject
{
    //Instance variables
    private String period, name, date, notes;
    
    /**
     * Constructor for class that sets private data
     * 
     * @param   period  String for period number
     * @param   name    String for name of task
     * @param   date    String for due date
     * @param   notes   String for notes of the task
     */
    public ItemObject(String period, String name, String date, String notes){
        this.period=period;
        this.name=name;
        this.date=date;
        this.notes=notes;
    }
    
    /**
     * Overrides toString method with one that reads out for the program
     */
    public String toString(){
        String result = name;
        if(!date.equals("noduedate")){
            result+="\nDue date: "+date;
        }
        if(!notes.equals("nonotes")){
            result+="\nNotes: "+notes;
        }
        return result;
    }
    
    /**
     * Returns period as a String
     */
    public String getPeriod(){return period;}
    /**
     * Returns item name as a string
     */
    public String getName(){return name;}
    /**
     * Returns due date as a string
     */
    public String getDate(){return date;}
    /**
     * Returns notes about item as a string
     */
    public String getNotes(){return notes;}
}
