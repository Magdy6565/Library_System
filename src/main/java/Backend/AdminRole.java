/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.IOException;
import constants.*;
/**
 *
 * @author zedan.net
 */
public class AdminRole implements  FileNames{
    private LibrarianUserDatabase database = new LibrarianUserDatabase(LIBRARIANS_FILENAME);

    public AdminRole() {
        database.readFromFile();
    }
    
    public void addLibrarian(String librarianId, String name, String email,String address, String phoneNumber) throws IOException
    {
      database.insertRecord(database.createRecordFrom(librarianId+","+name+","+email+","+address+","+phoneNumber));
     // database.saveToFile();
    }
    public LibrarianUser[] getListOfLibrarians()
     {
        
        LibrarianUser [] x = new LibrarianUser[database.getRecords().size()];
        
        for(int i =0 ; i <database.sizeOfArrayList() ; i++)
        {
             x [i] =(LibrarianUser) database.getRecords().get(i);
        }
        return x;
    }
    public void removeLibrarian(String key) throws IOException
    {
        database.deleteRecord(key);
       // database.saveToFile();
    }
    public void logout() throws IOException{
        database.saveToFile();
    }
}
