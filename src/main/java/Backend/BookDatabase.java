/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zedan.net
 */
 class BookDatabase extends Database {
  

    public BookDatabase(String filename) {
        super(filename);
    }
   
    @Override
      public Book createRecordFrom(String line)
    {
        
        
      String[] studentDataAsStrings = line.split(",");
       Book b= new Book(studentDataAsStrings[0], studentDataAsStrings[1] , studentDataAsStrings[2],studentDataAsStrings[3],Integer.parseInt(studentDataAsStrings[4]));
      
    return b; 
    }
     
}
