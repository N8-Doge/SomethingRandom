public class ItemObject
{
    private String period, name, date, notes;
    public ItemObject(String period, String name, String date, String notes){
        this.period=period;
        this.name=name;
        this.date=date;
        this.notes=notes;
    }
    
    public String toString(){
        String result = name;
        if(!date.equals("noduedate")){
            result+="\n"+date;
        }
        if(!notes.equals("nonotes")){
            result+="\n"+notes;
        }
        return result;
    }
    
    public String getPeriod(){return period;}
    public String getName(){return name;}
    public String getDate(){return date;}
    public String getNotes(){return notes;}
}
