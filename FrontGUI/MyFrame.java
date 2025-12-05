package FrontGUI;
import javax.swing.*;

/**
 * LibraryApplication의 프레임
 *
 * @author (허진영_2020315044, 임기홍_2021320032, 안교관_2021320014 )
 * @version (2025.12.04)
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
