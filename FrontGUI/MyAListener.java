package FrontGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import CoreEngine.*;

/**
 * MyPanel의 Event Listener Object 
 *
 * @author (허진영_2020315044)
 * @version (2025.12.06)
 */
public class MyAListener implements ActionListener
{
    public MyPanel mypanel;
    private String output = "";
    private int index;
    public MyAListener(MyPanel mypanel)
    {
        this.mypanel = mypanel;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(mypanel.mcb_selectUC)){
            JComboBox mcb = (JComboBox)e.getSource();
            index = mcb.getSelectedIndex(); 

            output = mypanel.selectUC[index] + "자 : " + mypanel.mtf_BorrowerName.getText() + "\n"
            + mypanel.selectUC[index] + "책 제목 : " + mypanel.mtf_BookTitle.getText() + "\n"
            + mypanel.selectUC[index] + "책 저자 : " + mypanel.mtf_BookAuthor.getText() + "\n"
            + mypanel.selectUC[index] + "책 등록번호 : " + mypanel.mtf_CatalogNumber.getText() + "\n"
            + "-------------------------------------------------" + "\n";
        }   

        if(index == 0 && e.getSource().equals(mypanel.mb_Run)){
            String outputTitle = mypanel.libApp.registerOneBorrower(mypanel.mtf_BorrowerName.getText(),mypanel.mtf_UniqueID.getText());
            mypanel.mta.append(outputTitle + "\n" + "-------------------------------------------------" + "\n");
        }
        else if(index == 1 && e.getSource().equals(mypanel.mb_Run)){
            String outputTitle = mypanel.libApp.registerOneBook(mypanel.mtf_BookTitle.getText(),mypanel.mtf_BookAuthor.getText(),mypanel.mtf_CatalogNumber.getText());
            mypanel.mta.append(outputTitle + "\n" + "-------------------------------------------------" + "\n");        
        }
        else if(index == 2 && e.getSource().equals(mypanel.mb_Run)){
            String outputTitle = mypanel.libApp.loanOneBook(mypanel.mtf_UniqueID.getText(), mypanel.mtf_CatalogNumber.getText());
            mypanel.mta.append(outputTitle + "\n");        
        }
        else if(index == 3 && e.getSource().equals(mypanel.mb_Run)){
            String outputTitle = mypanel.libApp.returnOneBook(mypanel.mtf_CatalogNumber.getText());
            mypanel.mta.append(outputTitle + "\n");
        }
        else if(e.getSource().equals(mypanel.mb_FloanD)){
            mypanel.mta.append("대출 가능한 책입니다\n\n" + mypanel.libApp.displayBookForLoan()+ "\n" + "-------------------------------------------------" + "\n");
        }
        else if(e.getSource().equals(mypanel.mb_OloanD)){
            mypanel.mta.append("대출 중인 책입니다\n\n" +mypanel.libApp.displayBookOnLoan()+ "\n" + "-------------------------------------------------" + "\n");
        }
        else if(e.getSource().equals(mypanel.mb_Clear)){
            mypanel.mtf_BorrowerName.setText("");
            mypanel.mtf_BookTitle.setText("");
            mypanel.mtf_BookAuthor.setText("");
            mypanel.mtf_CatalogNumber.setText("");
        }

    }
}
