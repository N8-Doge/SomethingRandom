/**
 * ClassObject is a class used to store data for classes easier
 * 
 * @author  Nathan Chen
 * @version 3-12-18
 */
public class ClassObject
{
    //Instance variables
    private String period, name;
    
    /**
     * Constructor for class that sets private data
     * 
     * @param   period  String for period number of class
     * @param   name    String for this class's name
     */
    public ClassObject(String period, String name){
        this.period=period;
        this.name=name;
    }
    
    /**
     * Overrides default method toString with one that prints out readable data 
     */
    public String toString(){
        if(period.equals("noperiod")){
            return name;
        }
        return "Period " + period + " - " + name;
    }
    
    /**
     * Returns period as a string
     */
    public String getPeriod(){return period;}
    /**
     * Returns name as a string
     */
    public String getName(){return name;}
}
