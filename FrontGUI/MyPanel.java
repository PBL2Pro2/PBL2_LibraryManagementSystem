package FrontGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import CoreEngine.*;
/**
 * LibraryApplication의 패널
 *
* @author (허진영_2020315044, 임기홍_2021320032, 안교관_2021320014 )
 * @version (2025.12.04)
 */
public class MyPanel extends JPanel
{
    protected JLabel ml_BorrowerName, ml_UniqueID, ml_BookTitle, ml_BookAuthor, ml_CatalogNumber, ml_Choice;
    protected JTextField mtf_BorrowerName, mtf_UniqueID, mtf_BookTitle, mtf_BookAuthor, mtf_CatalogNumber;;
    protected JButton mb_Run, mb_Clear, mb_FloanD, mb_OloanD;
    protected JTextArea mta;
    protected String[] selectUC = {"이용자 등록","책 등록","대출","반납"};
    protected JComboBox mcb_selectUC;
    protected LibraryApplication libApp;


    public MyPanel(){
        setLayout(new BorderLayout(10, 10));
        
        JPanel topPanel = new JPanel();
        JLabel titleLabel = new JLabel("선문대학교 중앙도서관");
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.add(titleLabel);
        this.add(topPanel, BorderLayout.NORTH);
        
        ml_BorrowerName = new JLabel("이용자 이름");
        ml_UniqueID = new JLabel("고유식별자 번호");
        ml_BookTitle = new JLabel("책 제목");
        ml_BookAuthor = new JLabel("책 저자이름");
        ml_CatalogNumber = new JLabel("책 등록번호");
        ml_Choice = new JLabel("선택");

        mtf_BorrowerName = new JTextField("예: 홍길동", 20);
        mtf_UniqueID = new JTextField("예: 2025320001", 20);
        mtf_BookTitle = new JTextField("예: 소프트웨어설계론", 20);
        mtf_BookAuthor= new JTextField("예: (c)sHwang", 20);
        mtf_CatalogNumber = new JTextField("예: B0001", 20);
        
        mcb_selectUC = new JComboBox(selectUC);
        
        mta = new JTextArea(20, 28);
        mta.setText("선문대학교 중앙도서관에 오신것을 환영합니다!\n"
        + "----------------------------------------------------------\n");
        this.add(new JScrollPane(mta));
        
        JPanel bottomPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        bottomPanel.add(ml_BorrowerName);
        bottomPanel.add(mtf_BorrowerName);
        bottomPanel.add(ml_UniqueID);
        bottomPanel.add(mtf_UniqueID);
        bottomPanel.add(ml_BookTitle);
        bottomPanel.add(mtf_BookTitle);
        bottomPanel.add(ml_BookAuthor);
        bottomPanel.add(mtf_BookAuthor);
        bottomPanel.add(ml_CatalogNumber);
        bottomPanel.add(mtf_CatalogNumber);
        bottomPanel.add(ml_Choice);
        bottomPanel.add(mcb_selectUC);

        mb_Run = new JButton("실행");
        mb_FloanD = new JButton("대출가능");
        mb_OloanD = new JButton("대출중");
        mb_Clear = new JButton("Clear");bottomPanel.add(new JLabel("선택"));
        
        bottomPanel.add(mb_Run);
        bottomPanel.add(mb_FloanD);
        bottomPanel.add(mb_OloanD);
        bottomPanel.add(mb_Clear);
        
        add(bottomPanel, BorderLayout.SOUTH);
        
        MyAListener Alistener = new MyAListener(this);
        
        libApp = new LibraryApplication("선문대학교 중앙도서관");

        mcb_selectUC.addActionListener(Alistener);
        mb_Run.addActionListener(Alistener);
        mb_FloanD.addActionListener(Alistener);
        mb_OloanD.addActionListener(Alistener);
        mb_Clear.addActionListener(Alistener);

    }
}