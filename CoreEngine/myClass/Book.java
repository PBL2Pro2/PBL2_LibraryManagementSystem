package CoreEngine.myClass;


/**
 * 책의 정보를 나타내는 클래스
 * DB_Element를 상속받는 서브클래스이다.
 * 
 * @author (2021320032 임기홍)
 * @version (2025/10/15)
 */
public class Book extends DB_Element
{
    private String author;
    private String catalogNumber;
    private String title;
    private boolean OnLoan;

    /**
     * Book 클래스의 객체 생성자
     * 
     * @param author 책의 저자
     * @param bookID 책의 고유 넘버
     * @param publisher 책의 출판사
     * @param title 책의 제목
     * @param year 책의 출판년도
     */
    public Book(String author, String catalogNumber,String title)
    {
        this.author = author;
        this.catalogNumber = catalogNumber;
        this.title = title;
        this.OnLoan = false;
    }
    /**
     * Book 객체의 title을 반환하는 메소드
     *
     *
     * @return   titler 값을 반환
     */
    public String getTitle()
    {
        return this.title;
    }
    /**
     * Book 객체의 고유 카탈로그넘버를 반환하는 메소드
     *
     *
     * @return   catalogNumber 값을 반환
     */
    public String getID()
    {
        return this.catalogNumber;
    }
    /**
     * Book 객체의 author를 반환하는 메소드
     *
     *
     * @return   author 값을 반환
     */
    public String getAuthor()
    {
        return this.author;
    }
    /**
     * Book 객체의 OnLoan를 반환하는 메소드
     *
     *
     * @return   OnLoan 값을 반환
     */
    public boolean getOnLoan()
    {
        return this.OnLoan;
    }
    /**
     * Book 객체의 OnLoan를 반환하는 메소드
     *
     *
     * @return   OnLoan 값을 반환
     */
    public void setOnLoan(boolean on)
    {
        this.OnLoan = on;
    }
    /**
     * Book 객체의 정보를 String 타입으로 return하는 메소드
     *
     * 
     * @return   문제지 결과화면의 양식에 맞춰 Book 객체를 문자열로 반환
     */
    @Override
    public String toString()
    {
        return "(" + catalogNumber + ") " + title + ", " + author;
        
    }
}
