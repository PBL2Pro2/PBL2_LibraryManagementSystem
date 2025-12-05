package CoreEngine;
import CoreEngine.DataBase.LibraryManagementSystem;

/**
 * Mock-Up(LibraryApplication : 6개의 Use Case 제공)
 *
 * @author (허진영_2020315044, 임기홍_2021320032, 안교관_2021320014 )
 * @version (2025.11.26)
 */
public class LibraryApplication
{
    private String libraryName;
    private LibraryManagementSystem lms;
    
    public LibraryApplication(String name){
        libraryName = name;
        lms = new LibraryManagementSystem();
    }
    
    // UC#1 : 이용자 등록
    public String registerOneBorrower(String name, String uniqueIdentifier){
        return lms.registerUser(name, uniqueIdentifier);
    }

    // UC#2 : 책 등록
    public String registerOneBook(String title, String author, String catalogNumber){
        return lms.registerBook(title, author, catalogNumber);
    }
    
    // UC#3 : 대출가능한 책 목록 Display
    public String displayBookForLoan(){
        return lms.displayBooksForLoan();
    }
    
    // UC#4 : 대출중인 책 목록 Display
    public String displayBookOnLoan(){
        return lms.displayBooksOnLoan();
    }
    
    // UC#5 : 책 1권 대출
    public String loanOneBook(String name, String catalogNumber){
        return lms.loanBook(name, catalogNumber);
    }
    
    // UC#6 : 책 1권 반납
    public String returnOneBook(String catalogNumber){
       return lms.returnBook(catalogNumber);
    }
}