package CoreEngine.myClass;


/**
 * 책의 정보를 나타내는 클래스
 * DB_Element를 상속받는 서브클래스이다.
 * 
 * @author (2021320032 임기홍)
 * @version (2025/12/07)
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
     * @param catalogNumber 책의 고유 카탈로그넘버
     * @param title 책의 제목
     * @param OnLoan 책의 대출 여부
     */
    public Book(String author, String catalogNumber,String title)
    {
        this.author = author;
        this.catalogNumber = catalogNumber;
        this.title = title;
        this.OnLoan = false;
    }
    /**
     * Book 객체의 제목을 반환하는 메소드
     *
     *
     * @return   제목 값을 반환
     */
    public String getTitle()
    {
        return this.title;
    }
    /**
     * Book 객체의 고유 카탈로그넘버를 반환하는 메소드
     *
     *
     * @return   고유 카탈로그넘버 값을 반환
     */
    public String getID()
    {
        return this.catalogNumber;
    }
    /**
     * Book 객체의 저자를 반환하는 메소드
     *
     *
     * @return   저자 값을 반환
     */
    public String getAuthor()
    {
        return this.author;
    }
    /**
     * Book 객체의 대출 여부를 반환하는 메소드
     *
     *
     * @return   대출 여부 값을 반환
     */
    public boolean getOnLoan()
    {
        return this.OnLoan;
    }
    /**
     * Book 객체의 대출 여부를 변환하는 메소드
     *
     *
     * @return   대출 여부 값을 true로 변환
     */
    public void setOnLoan(boolean on)
    {
        this.OnLoan = true;
    }
    /**
     * Book 객체의 정보를 String 타입으로 return하는 메소드
     *
     * 
     * @return   특정 양식에 맞춰 Book 객체를 문자열로 반환
     */
    public String toString()
    {
        return "(" + catalogNumber + ") " + title + ", " + author;
        
    }
}
