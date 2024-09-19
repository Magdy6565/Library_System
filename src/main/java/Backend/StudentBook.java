/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author zedan.net
 */
public class StudentBook extends item {
    private String studentId , bookId ;
    private LocalDate borrowDate ;

    public StudentBook(String studentId, String bookId, LocalDate borrowDate) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getBookId() {
        return bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    
    @Override
    public String getSearchKey() {
       return studentId +","+bookId ;
    }

    @Override
    public String lineRepresentation() {
       //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
              //  StudentBook s = new StudentBook(fileData[0], fileData[1] , LocalDate.parse(fileData[2],formatter) );
       return studentId+","+bookId+","+borrowDate;
      // LocalDate.parse(borrowDate, formatter);
    }

    
    
}
