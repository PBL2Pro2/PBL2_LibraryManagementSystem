package CoreEngine.myClass;


/**
 * 데이터베이스 요소의 추상 클래스
 * User와 Book의 부모 클래스이다.
 * 
 * @author (2021320032 임기홍)
 * @version (2025/10/25)
 */
public abstract class DB_Element
{
    /**
     * 데이터베이스 요소의 고유 ID를 반환하는 추상 메소드
     *
     *
     * @return    데이터베이스 요소의 고유 ID
     */
    public abstract String getID(); 
}
