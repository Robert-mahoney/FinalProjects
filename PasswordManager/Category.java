public abstract class Category
{
    // instance variables - replace the example below with your own
    
    private String category;
    private String pass;
    
    
    public Category(String category,String pass){
        this.category=category;
        this.pass=pass;
    }
    
    public String getCategory(){
        return category;
    }
    public String getPass(){
        return pass;
    }
    
}