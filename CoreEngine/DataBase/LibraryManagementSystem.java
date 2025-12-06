package CoreEngine.DataBase;

import java.util.*;
import CoreEngine.myClass.*;

/**
 * 이용자, 책, 대출 데이터베이스를 생성하고 관리하는 클래스
 * 대출 작업을 수행하고, 데이터베이스에 객체를 추가, 출력하는 기능을 갖췄다.
 * 
 * @author (허진영_2020315044, 임기홍_2021320032, 안교관_2021320014)
 * @version (2025.12.05)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB; 
    LibDB<User> userDB;
    HashMap<String,Loan> loanDB;

    /**
     * LibraryManagementSystem 생성자
     * 
     * 생성자 클래스로 객체의 필드값을 설정, 컬렉션 선언
     * 
     * @param bookDB 책 데이터베이스
     * @param userDB 이용자 데이터베이스
     * @param loanDB 대출 데이터베이스
     * 
     */
    public LibraryManagementSystem()
    {
        bookDB = new LibDB<Book>();
        userDB = new LibDB<User>();
        loanDB = new HashMap<String, Loan>();
    }

    /**
     * 이용자 등록 메소드
     * 중복 체크 후 User 객체를 생성하여 userDB에 저장
     * 
     * @param name 이용자의 이름
     * @param uniqueIdentifier 이용자의 고유 식별자
     * @return 등록 결과 메시지
     */
    public String registerUser(String name, String uniqueIdentifier){
        // 중복 체크
        User checkuser = userDB.findElement(uniqueIdentifier);
        if(checkuser != null){
            return "이미 등록된 이용자입니다.";
        }
        
        // User 객체 생성 및 저장
        User newUser = new User(name, uniqueIdentifier);
        userDB.addElement(newUser);
        
        return "이용자(" + name + " " + uniqueIdentifier + ") 등록작업을 완료하였습니다.";
    }
    
    /**
     * 책 등록 메소드
     * 중복 체크 후 Book 객체를 생성하여 bookDB에 저장
     * 
     * @param title 책의 제목
     * @param author 책의 저자
     * @param catalogNumber 책의 등록번호
     * @return 등록 결과 메시지
     */
    public String registerBook(String title, String author, String catalogNumber){
        // 중복 체크
        Book checkbook = bookDB.findElement(catalogNumber);
        if(checkbook != null){
            return "이미 등록된 책입니다.";
        }
        
        // Book 객체 생성 및 저장
        Book newBook = new Book(author, catalogNumber, title);
        bookDB.addElement(newBook);
        
        return "책(" + title + ", " + author + ", " + catalogNumber + ") 등록작업을 완료하였습니다.";
    }
    
    /**
     * 책 대출 메소드
     * 이용자 이름과 책 등록번호를 받아 대출 처리
     * 
     * @param userName 이용자의 이름
     * @param catalogNumber 책의 등록번호
     * @return 대출 결과 메시지
     */
    public String loanBook(String uniqueIdentifier, String catalogNumber){
        
        User user = findUserByUniqueIdentifier(uniqueIdentifier);
        if(user == null){
            return "등록되지 않은 이용자입니다.";
        }
        
        // Book 검색
        Book book = bookDB.findElement(catalogNumber);
        if(book == null){
            return "등록되지 않은 책입니다.";
        }
        
        // User 체크 (loanCounter > 0)
        if(user.getLoanCounter() <= 0){
            return "대출 가능 횟수를 초과했습니다.";
        }
        
        // Book 체크 (OnLoan == false)
        if(book.getOnLoan()){
            return "이미 대출 중인 책입니다.";
        }
        
        // Loan 객체 생성 (User와 Book 연결)
        Loan newLoan = new Loan(user, book);
        
        // Book 상태 변경 (OnLoan false에서 true로 변경)
        book.setOnLoan(true);
        
        // User loanCounter 감소 (남은 대출 가능 횟수 1 감소)
        user.downLoanCounter();
        
        // loanDB에 저장 (링크 생성)
        loanDB.put(catalogNumber, newLoan);
        
        // 책 카탈로그넘버가 아니라 bookTitle을 반환하도록 수정 
        return "책(" + book.getTitle() + ")이 이용자(" + user.getName() + ")에게 대출되었습니다.";
    }
    
    /**
     * 책 반납 메소드
     * 책 등록번호를 받아 반납 처리
     * 
     * @param catalogNumber 책의 등록번호
     * @return 반납 결과 메시지
     */
    public String returnBook(String catalogNumber){
        // 책 찾기 (시퀀스랑 비교 필요 )
        Book book = bookDB.findElement(catalogNumber);
        if(book == null){
            return "등록되지 않은 책입니다.";
        }
        
        // 대출 중인지 확인
        Loan loan = loanDB.get(catalogNumber);
        if(!book.getOnLoan()){
            return "대출 중이 아닌 책입니다.";
        }
        
        // User 가져오기
        User user = loan.getUser();
        
        // loanDB에서 제거 (링크 삭제)
        loanDB.remove(catalogNumber);
        
        // Book 상태 변경 (true 에서 false로)
        book.setOnLoan(false);
        
        // User loanCounter 증가 (남은 대출 가능 횟수 복구)
        user.upLoanCounter();
        
        // 책 카탈로그넘버가 아니라 bookTitle을 반환하도록 수정
        return "책(" + book.getTitle() + ")이 반납되었습니다.";
    }
    
    /**
     * 대출 가능한 책 목록을 문자열로 반환하는 메소드
     * OnLoan이 false인 책만 필터링하여 반환
     * 
     * @return 대출 가능한 책 목록
     */
    public String displayBooksForLoan(){
        StringBuilder sb = new StringBuilder();
    
        ArrayList<Book> books = bookDB.getAllElements();
        
        ArrayList<String> bookTexts = new ArrayList<String>();
        for (Book book : books){
            if(!book.getOnLoan()){
                String bookText = book.getID() + " " + book.toString();
                bookTexts.add(bookText);
            }
        }
        
        Collections.sort(bookTexts);
        
        for (String bookText : bookTexts) {
            sb.append(bookText).append("\n");
        }
    
        return sb.toString();
    }
    
    /**
     * 대출 중인 책 목록을 문자열로 반환하는 메소드
     * loanDB의 모든 대출 기록을 조회하여 반환
     * 
     * @return 대출 중인 책 목록
     */
    public String displayBooksOnLoan(){
        StringBuilder sb = new StringBuilder();
        
        ArrayList<String> keys = new ArrayList<String>(loanDB.keySet());
        
        Collections.sort(keys);
        
        for (String catalogNumber : keys) {
            Loan loan = loanDB.get(catalogNumber);
            sb.append(loan.toString()).append("\n");
        }
        return sb.toString();
    }
    
    /**
     * 이름으로 이용자를 찾는 헬퍼 메소드
     * toString()을 파싱하여 이름 비교
     * 
     * @param name 찾을 이용자의 이름
     * @return 해당 이름의 이용자, 없을 경우 null
     */
    private User findUserByUniqueIdentifier(String uniqueIdentifier){
        ArrayList<User> users = userDB.getAllElements();
        Iterator<User> it = users.iterator();
        while(it.hasNext()){
            User user = it.next();
            if(user.getID().equals(uniqueIdentifier)){
                return user;
            }
        }
        return null;
    }
}