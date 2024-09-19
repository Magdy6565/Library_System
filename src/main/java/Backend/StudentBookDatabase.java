/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zedan.net
 */
 class StudentBookDatabase  extends Database{

    public StudentBookDatabase(String filename) {
        super(filename);
    }
  
    @Override
      public StudentBook createRecordFrom(String line) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          String[] studentDataAsStrings = line.split(",");
       StudentBook s = new StudentBook(studentDataAsStrings[0], studentDataAsStrings[1] , LocalDate.parse(studentDataAsStrings[2],formatter)  );
    return s; 
    }
     
    }

   
    


   