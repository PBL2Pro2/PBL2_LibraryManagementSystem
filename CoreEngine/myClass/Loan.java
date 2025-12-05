package CoreEngine.myClass;

/**
 * 대출 정보를 나타내는 클래스
 * User와 Book을 연결하는 링크 역할을 한다.
 * 
 * @author (허진영_2020315044, 임기홍_2021320032, 안교관_2021320014)
 * @version (2025/12/05)
 */
public class Loan
{
    private User user;
    private Book book;

    /**
     * Loan 클래스의 객체 생성자
     * 
     * @param user 대출한 이용자
     * @param book 대출한 책
     */
    public Loan(User user, Book book)
    {
        this.user = user;
        this.book = book;
    }
    
    /**
     * Loan 객체의 이용자를 반환하는 메소드
     *
     * @return user 값을 반환
     */
    public User getUser()
    {
        return this.user;
    }
    
    /**
     * Loan 객체의 책을 반환하는 메소드
     *
     * @return book 값을 반환
     */
    public Book getBook()
    {
        return this.book;
    }
    
    /**
     * Loan 객체의 정보를 String 타입으로 return하는 메소드
     *
     * @return Loan 객체를 문자열로 반환
     */
    @Override
    public String toString()
    {
        return user.toString() + " ===> " + book.toString();
    }
}