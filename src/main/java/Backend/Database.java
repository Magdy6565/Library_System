/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import constants.*;
/**
 *
 * @author zedan.net
 */
abstract  class Database implements FileNames{
     private    ArrayList <item> records = new ArrayList <item> (20);
     private String searchKey ;
private String filename ;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Database(String filename) {
        this.filename = filename;
    }

    public  ArrayList<item> getRecords() {
        return records;
    }

    public  void setRecords(ArrayList<item> records) {
        this.records = records;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
     
   // public  abstract void readFromFile();
    

   
   public ArrayList<item> returnAllRecords()
   { ArrayList <item> x = new ArrayList <item> ();
        
        x= getRecords();
        return x ;
    }
   
 
    public boolean contains(String key )
    {
        for(int i =0 ; i < records.size();i++)
        {
            if(records.get(i).getSearchKey().equals(key))
                    return true;
        }
        return false ;
    }



 
   public void insertRecord(item record)
    {
        records.add(record);
        
    }
   public int sizeOfArrayList ()
   {
       int x= records.size();
       return x;
   }

    public void deleteRecord(String key)
    {
        records.remove(getRecord(key));
    }
    
      public item getRecord(String key)
    {
        int i ;
       
      for( i =0 ; i < records.size();i++)
        {
            if(records.get(i) .getSearchKey().equals(key))
                  return records.get(i);
            
        }
       
      return null;              
}
   
   public void saveToFile() throws IOException
   {
       FileWriter writer = new FileWriter(this.filename);
       int n = getRecords().size() , i;
       for(i=0;i<n;i++)
       {
           writer.write(getRecords().get(i).lineRepresentation() + '\n');
       }
       writer.close();
       
   }  
    public abstract item createRecordFrom(String line);
   
        public void readFromFile()
        {

            try {
                File file = new File(this.filename);
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine())
                {
                    String line = sc.nextLine();
                    String[] fileData = line.split(",");

                    if (filename.equals(BOOKS_FILENAME))
                    {
                    Book b = new Book(fileData[0], fileData[1], fileData[2], fileData[3],Integer.parseInt(fileData[4]));
                    records.add(b);
                    }

                     if (filename.equals(LIBRARIANS_FILENAME))
                      {
                         LibrarianUser l = new LibrarianUser(fileData[0], fileData[1], fileData[2], fileData[3], fileData[4]);
                         records.add(l);
                     }

                    if (filename.equals(STUDENTSBOOKS_FILENAME))
                    {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                StudentBook s = new StudentBook(fileData[0], fileData[1] , LocalDate.parse(fileData[2],formatter) );
                        records.add(s);
                    }
                    
                }
                sc.close();
            } catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
            }
        } 
}
