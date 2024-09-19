/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList ;
/**
 *
 * @author zedan.net
 */



 class LibrarianUserDatabase extends Database  {
   
   

    public LibrarianUserDatabase(String filename) {
        super(filename);}
    
    

    @Override
    public LibrarianUser createRecordFrom(String line)
    {
        
        
      String[] studentDataAsStrings = line.split(",");
       LibrarianUser l= new LibrarianUser(studentDataAsStrings[0], studentDataAsStrings[1] , studentDataAsStrings[2],studentDataAsStrings[3],studentDataAsStrings[4]);
      
    return l; 
    }
    
}