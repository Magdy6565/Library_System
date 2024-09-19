/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import constants.*;
/**
 *
 * @author zedan.net
 */
public class LibrarianRole implements  FileNames {

    private BookDatabase booksDatabase = new BookDatabase(BOOKS_FILENAME);
    private StudentBookDatabase sBDatabase = new StudentBookDatabase(STUDENTSBOOKS_FILENAME);
  //  public static      -------------------------------------------------------------------------------------------------
    public LibrarianRole() {
        
//--------------------------------------------------------------------------
        booksDatabase.readFromFile();
        sBDatabase.readFromFile();
       
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void addBook(String id, String title, String authorName, String publisherName, int quantity) throws IOException {
        //booksDatabase.readFromFile();
        Book b = new Book(id, title, authorName, publisherName, quantity);
        booksDatabase.insertRecord(booksDatabase.createRecordFrom(b.lineRepresentation()));
        System.out.println(booksDatabase.sizeOfArrayList());

       // booksDatabase.saveToFile();   
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public Book[] getListOfBooks() {
        //booksDatabase.readFromFile();
        Book[] x = new Book[booksDatabase.getRecords().size()];

        for (int i = 0; i < booksDatabase.sizeOfArrayList(); i++) {
            x[i] = (Book) booksDatabase.getRecords().get(i);
        }
        return x;
        
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public StudentBook[] getListOfBorrowingOperations() {
        //sBDatabase.readFromFile();
        System.out.println("SIze of borowin array list is"+sBDatabase.sizeOfArrayList());
        StudentBook[] x = new StudentBook[sBDatabase.getRecords().size()];

        for (int i = 0; i < sBDatabase.sizeOfArrayList(); i++) {
            x[i] = (StudentBook) sBDatabase.getRecords().get(i);
        }
        return x;
    }

    public int borrowBook (String stdentId, String bookId, LocalDate borrowDate) throws IOException
    {
        for(StudentBook r : getListOfBorrowingOperations())
      {
          if(r.getSearchKey().equals(stdentId +","+bookId)){
              System.out.println("Condition esmo mawgood fel borrowing list borrowing is Done here");
              return 1 ;}
      }
        
        for (Book s :getListOfBooks())
        {
            if(s.getSearchKey().equals(bookId) && s.getQuantity() == 0)
            {
                System.out.println("Condition quantity borrowing is Done here");
                return 0;
            }
        }

        for (Book t :getListOfBooks())
        {
            if (t.getSearchKey().equals(bookId))
            {
                t.setQuantity(t.getQuantity()-1);
                System.out.println("Hna hystlf ktaaab 3aady");
                StudentBook s = new StudentBook(stdentId, bookId, borrowDate);
        sBDatabase.insertRecord(sBDatabase.createRecordFrom(s.lineRepresentation()));
            }
        }
        return 2;
    }
      public void logout() throws IOException
    {
        booksDatabase.saveToFile();
        sBDatabase.saveToFile();
    }
    public double returnBook(String studentId, String  bookId, LocalDate returnDate) throws IOException
    {int  diff =0;
        //booksDatabase.readFromFile();
        Book b = new Book();
        if (booksDatabase.contains(bookId)) {
            b = (Book) booksDatabase.getRecord(bookId);
        }
        else
        {System.out.println("Book id not found in borrowing lists");
           return -1;
        
        }
        b.setQuantity(b.getQuantity() + 1);
         //booksDatabase.saveToFile();
         //-------------------------------------------------------------
         //sBDatabase.readFromFile();
         //
         if(sBDatabase.contains(studentId+","+bookId) == false ){
             System.out.println("Not found in borrowing list");
         }
         else{
         StudentBook s1 = new StudentBook(studentId, bookId, returnDate);
        s1 = (StudentBook) sBDatabase.getRecord(studentId+","+bookId);
         LocalDate borrow_date = s1.getBorrowDate();
             System.out.println("borrow date is "+borrow_date );
         Period period = Period.between(borrow_date, returnDate);
           diff = Math.abs(period.getDays());
         }
          
         //--------------------------------------------------------------------------------------------------------------------
         //sBDatabase.readFromFile();
         sBDatabase.deleteRecord(studentId+","+bookId);
         //sBDatabase.saveToFile();
         System.out.println("Thanks for returning the book your name is out of the borrowing list now");
         //----------------------------------------------------------------------------------------------------------------------------
        
     if(diff < 7)
              return 0;
          else 
              return (diff -7) * 0.5 ;
        
    }
  
}
