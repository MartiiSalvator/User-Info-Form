// Prompts the user for personal information,
// and then cleans up and re-formats the information.
// Name: Aaron Duc Nguyen
// homework7

// Tip: for your test cases, you can copy and paste them from the comments
//      below into your running program

// List test cases you used for NAME, and indicate whether each result was correct
// SMITH  ,   Mary jean: passed
// SmiTh,     MArY jEaN   (end with space): passed
//        SmiTh,     MArY jEaN   (end and start with space): passed
// SMITH   ,   MARY JEAN   : passed
// smith , mary     jean: passed


// List test cases you used for PHONE, and indicate whether each result was correct
// (513)529-1809 : passed
// (  51)3 52-918 0 9 : passed
// -513 -(5291-8) 09 : passed
// 5135291809 : passed
// (5135291809): passed

// List test cases you used for ADDRESS, and indicate whether each result was correct
// 204 Main Street, Apt. 5, Oxford, Ohio 45056 : passed
// 204 Main Street, Oxford, Ohio 45056 : passed
// Rm 214 Dennison Hall, 21 N Fisher Dr, Oxford, Ohio 45056 : passed
// Rm 214, Dennison Hall, 21 N Fisher Dr, Oxford, Ohio 45056 : passed

import java.util.Scanner;

public class Fixer {
   
   public static void main(String[] args) {
      // ********* DON'T CHANGE THE CODE YOU HAVE BEEN PROVIDED ********* //
      // These next several lines handle getting user input and storing it 
      // in variables.  
      
      // Connects a scanner to a keyboard
      Scanner input = new Scanner(System.in); 
      
      System.out.print("Name: ");
      String userName = input.nextLine();
      System.out.print("Phone: ");
      String userPhone = input.nextLine();
      System.out.print("Address: ");
      String userAddress = input.nextLine(); 
      
      // ********* BEGIN WRITING YOUR CODE HERE ********* //
   System.out.println("***** Results *****");
   System.out.println(parseName(userName));
   System.out.println(parsePhone(userPhone));
   System.out.println(parseStreetAddress(userAddress));   
   System.out.println(parseCityStateZip(userAddress));
   
   
   } // END MAIN
   
   // ********* WRITE YOUR REQUIRED METHODS HERE (SEE ASSIGNMENT) ********* //
   
   // name
   public static String parseName(String name){
   int iLeft = -2, iRight = -3;
   String nameWOSpaceFirstAndLast = "";
   //delete space before after user types name
   for (int i = 0; i < name.length(); i++){
 if(!name.substring(i,i+1).equals(" ")) {
 iLeft = i;
 break;
 }
 }
   for (int i = name.length()-1; i >= 0; i--){
 if(!name.substring(i,i+1).equals(" ")) {
 iRight = i;
 break;
 }
 }
 
 
   nameWOSpaceFirstAndLast = name.substring(iLeft,iRight);
   
   //delelte comma
   String finalName = nameWOSpaceFirstAndLast.replaceAll(",","");
   
   //Last name
   String lastName = finalName.substring(0,finalName.indexOf(" "));
   //Middle Initial
   String midInit = finalName.substring(finalName.lastIndexOf(" ")+1,finalName.lastIndexOf(" ")+2);
   //First name
   String firstName = finalName.substring(finalName.indexOf(" "),finalName.lastIndexOf(" ")).replaceAll(" ", "");
   
   return firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase() + " " + midInit.toUpperCase() + ". " + lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase() ;
   }
   
   //phone
   public static String parsePhone(String phone){
   
   String num;
   
   num = phone.replaceAll("-","").replaceAll(" ","").replaceAll("\\(","").replaceAll("\\)","");
   
   // form of number xxx-xxx-xxxx
   return  num.substring(0,3) + "-" + num.substring(3,6) + "-" + num.substring(6);
   }
   
   // Address 
   public static String parseStreetAddress(String address){
   
   String a = address.substring(0,address.lastIndexOf(","));
   
   return a.substring(0,a.lastIndexOf(","));
   }

   //State and Zip
   public static String parseCityStateZip(String address){
   
   String a = address.substring(0,address.lastIndexOf(","));
   
   return address.substring(a.lastIndexOf(",")+2);
   }
 
} // END CLASS
