import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class BufferWriter {
     //no need for a main function since it is a class.
     private static final String DATA_FILE = "Passwords.txt";
     private static Scanner in;
     private static BufferedWriter out;

//since static, you can call it using BufferWriter.readString();
public static String readString(){
     if(in == null){
          try{
               in = new Scanner(new File(DATA_FILE));
          }
          catch(Exception e){
               System.err.println("Cannot open file for input!");
               e.printStackTrace();
          }
     }
     try{
          if(in.hasNext()){
               String s = in.nextLine();
               return s;
          }
          else{
               return null;
          }
     }
     catch(Exception e){
          System.err.println("Cannot read the file....");
          e.printStackTrace();
     }
     return null;
}

public static void writeString(String s){
     if(out == null){
          try{
               out = new BufferedWriter(new FileWriter(DATA_FILE));
          }
          catch(Exception e){
               System.err.println("Cannot open file for output!");
               e.printStackTrace();
          }
     }
     try{
          out.write(s);
          out.newLine();  //adds in a new line of data
          //out.write("|");  //this is like the byte space from FileWriting
     }
     catch (Exception e) {
          System.err.println("Cannot write file!");
          e.printStackTrace();
      }
}

public static void saveAndClose(){
     //closes after the Scanner is done reading the file
     if (in != null) {
          try {
              //close() closes and saves the file you are writing to
              in.close();
              in = null;
          }
          catch (Exception e) {
              System.err.println("Cannot close input file!");
              e.printStackTrace();
          }
      }
      //closes after the BufferedWriter is done writing to the file
      if (out != null) {
          try {
               //close() closes and saves the file you are writing to
              out.close();
              out = null;
          }
          catch (Exception e) {
              System.err.println("Cannot close output file!");
              e.printStackTrace();
          }
     }    
}

}
