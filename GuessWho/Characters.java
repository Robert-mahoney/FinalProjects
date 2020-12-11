public class Characters
{
    // instance variables - replace the example below with your own
    
    private String name;
    private String desc;
    
    //Abstract means there cannot be a constructor for this class
    
    
    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Characters(String name,String desc){
        this.name=name;
        this.desc=desc;
    }
    
    public String getName(){
        return name;
    }
    public String getDesc(){
        return desc;
    }
}