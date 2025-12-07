package CoreEngine.myClass;

/**
 * 사용자의 정보를 나타내는 클래스
 * DB_Element를 상속받는 서브클래스이다.
 *
 * @author (2021320032 임기홍)
 * @version (2025/12/07)
 */
public class User extends DB_Element
{
    private String name;
    private String uniqueIdentifier;
    private int loanCounter;

    /**
     * User 클래스의 객체 생성자
     * 
     * @param name 이용자의 이름
     * @param uniqueIdentifier 이용자의 고유식별번호
     * @param loanCounter 이용자의 최대 대출 횟수
     */
    public User(String name, String uniqueIdentifier)
    {
        this.name = name;
        this.uniqueIdentifier = uniqueIdentifier;
        this.loanCounter = 10;
    }
    /**
     * User 객체의 이름을 반환하는 메소드
     *
     *
     * @return    이름 값을 반환
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * User 객체의 고유식별번호를 반환하는 메소드
     *
     *
     * @return    uniqueIdentifier 값을 반환
     */
    public String getID()
    {
        return this.uniqueIdentifier;
    }
    /**
     * User 객체의 최대 대출 횟수를 반환하는 메소드
     *
     *
     * @return    최대 대출 횟수 값을 반환
     */
    public int getLoanCounter()
    {
        return this.loanCounter;
    }
    /**
     * User 객체의 최대 대출 횟수를 증가하는 메소드
     *
     *
     * @return    최대 대출 횟수 값을 +1
     */
    public void upLoanCounter()
    {
        this.loanCounter++;
    }
    /**
     * User 객체의 최대 대출 횟수를 감소하는 메소드
     *
     *
     * @return    최대 대출 횟수 값을 -1
     */
    public void downLoanCounter()
    {
        this.loanCounter--;
    }
    /**
     * User 객체의 정보를 String 타입으로 return하는 메소드
     *
     *
     * @return    특정 양식에 맞춰 User 객체를 문자열로 반환
     */
    public String toString()
    {
        return "[" + uniqueIdentifier + "] " + name;
    }
}
