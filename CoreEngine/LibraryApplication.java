package CoreEngine;
import CoreEngine.DataBase.LibraryManagementSystem;

/**
 * LibraryApplication 6개의 Use Case
 *
 * @author (임기홍_2021320032)
 * @version (2025.12.07)
 */
public class LibraryApplication
{
    private String libraryName;
    private LibraryManagementSystem lms;
    
    /**
     * LibraryApplication 클래스의 생성자
     *
     * @param name  MyPanel에서 생성 요청시 있던 파라미터
     */
    public LibraryApplication(String name){
        libraryName = name;
        lms = new LibraryManagementSystem();
    }
    /**
     * 메소드 registerOneBorrower
     *
     * @param name GUI에서 입력한 대출자의 이름
     * @param uniqueIdentifier GUI에서 입력한 대출자의 고유 식별 번호
     * @return lms객체의 대출자 등록 함수를 실행시켜 값을 GUI에 반환
     */
    public String registerOneBorrower(String name, String uniqueIdentifier){
        return lms.registerUser(name, uniqueIdentifier);
    }
    /**
     * 메소드 registerOneBook
     *
     * @param title GUI에서 입력한 책의 제목
     * @param author GUI에서 입력한 책의 저자
     * @param catalogNumber GUI에서 입력한 책의 고유 번호
     * @return lms객체의 책 등록 함수를 실행시켜 값을 GUI에 반환
     */
    public String registerOneBook(String title, String author, String catalogNumber){
        return lms.registerBook(title, author, catalogNumber);
    }
    /**
     * UC#3 : 대출가능한 책 목록 Display
     *
     * @return lms객체의 대출가능 디스플레이 함수를 실행시켜 값을 GUI에 반환
     */
    public String displayBookForLoan(){
        return lms.displayBooksForLoan();
    }
    /**
     * UC#4 : 대출중인 책 목록 Display
     *
     * @return lms객체의 대출중 디스플레이 함수를 실행시켜 값을 GUI에 반환
     */
    public String displayBookOnLoan(){
        return lms.displayBooksOnLoan();
    }
    /**
     * UC#5 : 책 1권 대출
     *
     * @param uniqueIdentifier GUI에서 입력한 대출자의 고유 식별 번호
     * @param catalogNumber GUI에서 입력한 책의 고유 번호
     * @return lms객체의 대출 함수를 실행시켜 값을 GUI에 반환
     */
    public String loanOneBook(String uniqueIdentifier, String catalogNumber){
        return lms.loanBook(uniqueIdentifier, catalogNumber);
    }
    /**
     * UC#6 : 책 1권 반납
     *
     * @param catalogNumber GUI에서 입력한 책의 고유 번호
     * @return lms객체의 반납 함수를 실행시켜 값을 GUI에 반환
     */
    public String returnOneBook(String catalogNumber){
       return lms.returnBook(catalogNumber);
    }
}