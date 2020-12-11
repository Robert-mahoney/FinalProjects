import java.util.ArrayList;
public class Bills extends Category
{
  static ArrayList<String> passes = new ArrayList<String>();
    public Bills(){
        super("Bills", passes.toString());
    }
    
    public static void addPass(String password){
      passes.add(password);
    }
    public static void modify(int index, String password){
      if(index>passes.size()-1){
        System.out.println("index out of bounds");
      }
      else{
      passes.set(index, password);
      }
    }

    public static void delete(int index){
      if(index>passes.size()-1){
        System.out.println("index out of bounds");
      }
      else{
      passes.remove(index);
      }
    }
}