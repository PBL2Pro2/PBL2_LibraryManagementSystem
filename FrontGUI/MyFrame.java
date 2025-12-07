package FrontGUI;
import javax.swing.*;

/**
 * LibraryApplication의 프레임
 *
 * @author (임기홍_2021320032 )
 * @version (2025.12.06)
 */
public class MyFrame extends JFrame
{
    public MyFrame(){
        this.setTitle("선문대학교 도서관 관리 시스템");
        this.setSize(350, 590);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel mp = new MyPanel();
        this.add(mp);
        
        this.setVisible(true);
    }
}
