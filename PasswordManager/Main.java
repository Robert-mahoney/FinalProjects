import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
class Main {
  final static String secretKey = "ssshhhhhhhhhhh!!!!";
  static List<Category> info = new ArrayList<Category>();
  public static void main(String[] args) {
    //Gets categories and their arrays of passwords
    List<Category> info = new ArrayList<Category>();
    populate(info);
    String category="";
    String pass="";
    //asks user to pick an option for what they want to do with their passwords
    Scanner in = new Scanner(System.in);
    String UserName = "";
    String newPassword = "";
    //lets user log in
        System.out.println("Would You Like To Create A New Account Or Login? (c/l): ");
        String cOrL = in.nextLine();
        if (cOrL.equals("c")) {
            System.out.println();
            System.out.println("What would you like your username to be?");
            UserName = in.nextLine();
            while (UserName.length() <= 7) {
                System.out.println("Your username is too short!");
                System.out.println("What would you like your username to be?");
                UserName = in.nextLine();
                System.out.println();
            }
            System.out.println();
            System.out.println("What would you like your password to be?");
            newPassword = in.nextLine();
            while (newPassword.length() <= 7) {
                System.out.println("Your password is too short!");
                System.out.println("What would you like your password to be?");
                newPassword = in.nextLine();
                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.println("Your username is " + UserName + " and your password is " + newPassword);
        } else {
            System.out.println("Please enter your username: ");
            UserName = in.nextLine();
            System.out.println("Please enter your password: ");
            newPassword = in.nextLine();
        }

    

    System.out.println("Would you like to (a)dd, (m)odify, (d)elete, (p)rint categories and passwords, (s)ave passwords, or (q)uit");
    String input = in.nextLine();
    //if user doesnt quit loop through the program
    while(!(input.equals("q"))){
      //lets user add a password to a specified category
    if(input.equals("a")){
      System.out.println("Type category you would like to add to");
      input = in.nextLine();
      category= input;
      System.out.println("Type password you would like to add(type Random for random password)");
      input = in.nextLine();
      pass= input;
      //lest user use random password
      if (pass.equals("Random")){
        pass = passwordGenerator();
      }
      //makes sure it is a strong password
      boolean ok= passChecker(pass);
      while(!ok){
        input = in.nextLine();
        pass = input;
        ok = passChecker(pass);
      }
      //checks what category user chose and adds password to it
      check(category,pass);
      //updates classes
      info.clear();
      populate(info);
      //prints out current passwords in that category
      for(Category c: info){
        if(c.getCategory().equals(category)){
              System.out.println(c.getPass());
        }
      }
    }
    //lets user modify the current passwords
    else if(input.equals("m")){
      System.out.println("Which category would you like to modify from");
      input = in.nextLine();
      category= input;
      System.out.println("Type index of password: ");
      int index = in.nextInt();
      System.out.println("To what(type Random for random password)?");
      String newPass = in.nextLine();
      newPass = in.nextLine();
      if (newPass.equals("Random")){
        newPass = passwordGenerator();
      }
      boolean okMod= passChecker(newPass);
      while(!okMod){
        input = in.nextLine();
        newPass = input;
        okMod = passChecker(newPass);
      }
      changePass(category,newPass,index);
      info.clear();
      populate(info);
      for(Category c: info){
        if(c.getCategory().equals(category)){
              System.out.println(c.getPass());
        }
      }
    }
    //lets user delete passwords
    else if(input.equals("d")){
      System.out.println("Which category would you like to delete from");
      input = in.nextLine();
      category= input;
      System.out.println("Type index of password: ");
      int indexDel = in.nextInt();
      deletePass(category,indexDel);
      info.clear();
      populate(info);
      for(Category c: info){
        if(c.getCategory().equals(category)){
              System.out.println(c.getPass());
        }
      }

    }
    //print out all categories and their passwords
    else if(input.equals("p")){
      for(Category c: info){
        System.out.print("The passwords for ");
        System.out.print(c.getCategory());
        System.out.print(" are ");
        System.out.print(c.getPass());
        System.out.print("\n");
      }
    }
    //saves and encrypts to a file
    else if(input.equals("s")){
      String temp="";
      temp+= (UserName+"\n");
      for(Category c: info){
        String encypted= AES.encrypt(c.getPass(), secretKey) ;
        temp+=("The passwords for "+ c.getCategory()+ " are "+ encypted+"\n");
        encypted = "";
      }
      BufferWriter.writeString(temp);
      BufferWriter.saveAndClose();
    }
    System.out.println("Would you like to (a)dd, (m)odify, (d)elete, (p)rint categories and passwords, (s)ave passwords, or (q)uit");
    input = in.nextLine();
    }

  }
  //adds category classes to an ArrayList
  public static void populate(List<Category> info){
    info.add(new Home());
    info.add(new Bills());
    info.add(new Work());
    info.add(new Misc());
    
  }

  public static void check(String cate, String password){
      if(cate.equals("Home")){
        Home.addPass(password);
      }
      else if(cate.equals("Bills")){
        Bills.addPass(password);
      }
      else if(cate.equals("Work")){
        Work.addPass(password);
      }
      else if(cate.equals("Misc")){
        Misc.addPass(password);
      }
      else{
        System.out.println("Category not found!");
      }
    }

    public static void changePass(String cate, String password, int index){
      if(cate.equals("Home")){
        Home.modify(index, password);
      }
      else if(cate.equals("Bills")){
        Bills.modify(index, password);
      }
      else if(cate.equals("Work")){
        Work.modify(index, password);
      }
      else if(cate.equals("Misc")){
        Misc.modify(index, password);
      }
      else{
        System.out.println("Category not found!");
      }
    }

    public static void deletePass(String cate, int index){
      if(cate.equals("Home")){
        Home.delete(index);
      }
      else if(cate.equals("Bills")){
        Bills.delete(index);
      }
      else if(cate.equals("Work")){
        Work.delete(index);
      }
      else if(cate.equals("Misc")){
        Misc.delete(index);
      }
      else{
        System.out.println("Category not found!");
      }
    }

    public static String passwordGenerator(){
   String[] spec = {"!","@","#","$","%","^","&","*","(",")"};
   String genPass="";
   int capLet = 3;
   
   int lowLet = 3;
   
   int num = 3;
   
   int special = 3;
 
   for(int i=0;i<capLet;i++){
     int ran = (int)(Math.random() * (90 - 65 + 1) + 65);
     char c=(char)ran; 
     genPass +=c;
   }
   for(int i=0;i<lowLet;i++){
     int ran = (int)(Math.random() * (122 - 97 + 1) + 97);
     char c=(char)ran; 
     genPass +=c;
   }
   for(int i=0;i<num;i++){
     int ran = (int)(Math.random() * (9 - 0 + 1) + 0); 
     genPass +=ran;
   }
   for(int i=0;i<special;i++){
     int ran = (int)(Math.random() * (9 - 0 + 1) + 0);
     genPass +=spec[ran];
   }
   return genPass;
 }

 public static boolean passChecker(String pass){
   String password = pass;
   boolean hasUppercase = !password.equals(password.toLowerCase());
   boolean hasNumber  = password.matches(".*\\d.*");
   boolean hasSpecial = password.matches(".*[!@#$%^&*()].*");
   if(!hasUppercase){
   System.out.println("Must have an uppercase Character");
   return false;
   }
   else if(!hasNumber){
   System.out.println("Must have a number");
   return false;
   }
   else if(!hasSpecial){
   System.out.println("Must have a special character");
   return false;
   }
   else if(password.length() < 8){
   System.out.println("Must have a length of 8");
   return false;
   }
   else{
     return true;
   }
 }

  
    
}