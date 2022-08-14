import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectAndDate extends JFrame implements ActionListener{
    JComboBox acdYear,y1,y2,y3,y4,section;
    JButton back,submit;
    JLabel msg,selectParameter;

    String textFile;
    String year,sec;

    boolean selectedAll=false;

    SubjectAndDate()
    {
        this.getContentPane().setBackground(new Color(245, 233, 193));
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(500,500);
        this.setBounds(500,120,500,500);
        this.setLayout(null);
        String[] year={"1st_year","2nd_year","3rd_year","4th_year"};
        String[] year1={"17cs61","17cs62","17cs63","17cs64","17cs65"};
        String[] year2={"18cs41","18cs42","18cs43","18cs44","18cs45"};
        String[] year3={"19cs31","19cs32","19cs33","19cs34","19cs35"};
        String[] year4={"20cs21","20cs22","20cs23","20cs24","20cs25"};
        String[] sec={"A","B","C"};
        //-----subject--------//
        y1=new JComboBox(year1);
        y2=new JComboBox(year2);
        y3=new JComboBox(year3);
        y4=new JComboBox(year4);
        y1.setBackground(new Color(0x99E1E7));
        y2.setBackground(new Color(0x99E1E7));
        y3.setBackground(new Color(0x99E1E7));
        y4.setBackground(new Color(0x99E1E7));

        y1.addActionListener(this);
        y2.addActionListener(this);
        y3.addActionListener(this);
        y4.addActionListener(this);

        //----section----------//
        section=new JComboBox(sec);
        section.setBackground(new Color(0x99E1E7));
        section.addActionListener(this);
        //------year----------//
        acdYear=new JComboBox(year);
        acdYear.setBackground(new Color(0x99E1E7));
        acdYear.setBounds(10,130,150,50);
        acdYear.addActionListener(this);
        //----msg-----//
        msg=new JLabel("Select Year,Subject and Section");
        msg.setForeground(Color.BLUE);
        msg.setFont(new Font("Times New Roman",Font.BOLD,30));
        msg.setBounds(20,50,450,100);
        //------msg2--------//
        selectParameter=new JLabel("Select all Parameter");
        selectParameter.setForeground(Color.BLUE);
        selectParameter.setFont(new Font("Times New Roman",Font.BOLD,20));

        //--------back button-----//
        back=new JButton("Back");
        back.setBackground(new Color(0x99E1E7));
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(110,300,100,50);
        //-------submit button----//
        submit=new JButton("Submit");
        submit.setBackground(new Color(0x99E1E7));
        submit.addActionListener(this);
        submit.setFocusable(false);
        submit.setBounds(220,300,100,50);
        //---adding----//
        this.add(back);
        this.add(submit);
        this.add(msg);
        this.add(acdYear);
        this.add(selectParameter);
        //---visibility to true---//
        this.validate();
        setVisible(true);

    }
//-----action performed by buttons-----//
    @Override
    public void actionPerformed(ActionEvent e) {
        //------drop down menu year-----//
        this.setBackground(new Color(227, 225, 209));

        if(e.getSource()==acdYear)
        {
            textFile=acdYear.getSelectedItem().toString();
            acdYear.setEnabled(false);
            if(acdYear.getSelectedIndex()==0)
            {
                year="1";
                y1.setBounds(165,130,150,50);
                this.add(y1);

            }
            if(acdYear.getSelectedIndex()==1)
            {
                year="2";
                y2.setBounds(165,130,150,50);
                this.add(y2);
            }
            if(acdYear.getSelectedIndex()==2)
            {
                year="3";
                y3.setBounds(165,130,150,50);
                this.add(y3);

            }
            if(acdYear.getSelectedIndex()==3)
            {
                year="4";
                y4.setBounds(165,130,150,50);
                this.add(y4);
            }
        }
        //------drop down menu subject year1-----//
        if(e.getSource()==y1) {
            textFile = textFile + "_" + y1.getSelectedItem().toString();
            y1.setEnabled(false);
            acdYear.setEnabled(false);
            section.setBounds(320, 130, 150, 50);
            this.add(section);
        }
        //------drop down menu subject year2-----//
        if(e.getSource()==y2) {
            textFile = textFile + "_" + y2.getSelectedItem().toString();
            y2.setEnabled(false);
            acdYear.setEnabled(false);
            section.setBounds(320, 130, 150, 50);
            this.add(section);
        }
        //------drop down menu subject year3-----//
        if(e.getSource()==y3) {
            textFile = textFile + "_" + y3.getSelectedItem().toString();
            y3.setEnabled(false);
            acdYear.setEnabled(false);
            section.setBounds(320, 130, 150, 50);
            this.add(section);
        }
        //------drop down menu subject year4-----//
        if(e.getSource()==y4) {
            textFile = textFile + "_" + y4.getSelectedItem().toString();
            y4.setEnabled(false);
            acdYear.setEnabled(false);
            section.setBounds(320, 130, 150, 50);
            this.add(section);
        }
        //-----drop down menu for sections A B C------//
        if(e.getSource()==section)
        {
            sec=section.getSelectedItem().toString();
            textFile=textFile+"_"+section.getSelectedItem();
            section.setEnabled(false);
            selectedAll=true;
        }
        //-----submit button-----//
        if(e.getSource()==submit)
        {
            if(selectedAll==false)
            {
                selectParameter.setBounds(30,350,400,100);

            }
            else
            {
                new attendancePage(textFile,year,sec);
                this.dispose();
            }
        }
        //------back button-----//
        if(e.getSource()==back)
        {
            new login();
            this.dispose();
        }
    }
}
