package CoreEngine.myClass;

/**
 * 사용자의 정보를 나타내는 클래스
 * DB_Element를 상속받는 서브클래스이다.
 *
 * @author (2021320032 임기홍)
 * @version (2025/10/15)
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
     * @param stID 이용자의 학번
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
     * @return    name 값을 반환
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
     * User 객체의 loanCounter를 반환하는 메소드
     *
     *
     * @return    loanCounter 값을 반환
     */
    public int getLoanCounter()
    {
        return this.loanCounter;
    }
    /**
     * User 객체의 loanCounter를 증가하는 메소드
     *
     *
     * @return    loanCounter 값을 반환
     */
    public void upLoanCounter()
    {
        this.loanCounter++;
    }
    /**
     * User 객체의 loanCounter를 감소하는 메소드
     *
     *
     * @return    loanCounter 값을 반환
     */
    public void downLoanCounter()
    {
        this.loanCounter--;
    }
    /**
     * User 객체의 정보를 String 타입으로 return하는 메소드
     *
     *
     * @return    문제지 결과화면의 양식에 맞춰 User 객체를 문자열로 반환
     */
    @Override
    public String toString()
    {
        // 여기에 코드를 작성하세요.
        return "[" + uniqueIdentifier + "] " + name;
    }
}
