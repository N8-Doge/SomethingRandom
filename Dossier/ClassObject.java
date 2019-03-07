public class ClassObject
{
    private String period, name;
    public ClassObject(String period, String name){
        this.period=period;
        this.name=name;
    }
    
    public String toString(){
        if(period.equals("noperiod")){
            return name;
        }
        return "Period " + period + " - " + name;
    }
    
    public String getPeriod(){return period;}
    public String getName(){return name;}
    //Period 1 Apush
    //English
}
