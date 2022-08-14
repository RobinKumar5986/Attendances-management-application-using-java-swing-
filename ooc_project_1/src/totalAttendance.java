import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;


class totalAttendance extends JFrame implements ActionListener {
    JTextField usnEnter;
    JLabel usnText;
    JButton Submit;
    JPanel data;
    JLabel totalDay;
    JLabel totalPresent;
    JLabel atdPresent;
    JLabel notFound;
    JButton close;
    totalAttendance()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(650,250,300,300);
//        this.setSize(500,500);
//        setUndecorated(true);
//        Ellipse2D.Double E=new Ellipse2D.Double(0,65,100,500);
//        this.setShape(E);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(245, 233, 193, 219));
//------------------------------------------------------------------------------------//
        //-------text field----//
        usnEnter=new JTextField();
        usnEnter.setBounds(80,40,100,30);
        usnText=new JLabel("USN");
        usnText.setForeground(Color.BLACK);
        usnText.setFont(new Font("Agency FB",Font.BOLD,20));
        usnText.setBounds(50,40,50,30);
        //-----Submit button-----//
        Submit=new JButton("Submit");
        Submit.setFont(new Font("Agency FB",Font.BOLD,15));
        Submit.setBounds(185,40,80,30);
        Submit.setFocusable(false);
        Submit.setBackground(new Color(0x99E1E7));
        Submit.setForeground(Color.BLACK);
        Submit.addActionListener(this);
        //--------panel-------//
        data =new JPanel();
        data.setBounds(0,80,300,200);
        data.setLayout(null);
        data.setBackground(new Color(245, 233, 193));
        //--------------------//
        totalDay=new JLabel();
        totalDay.setVisible(false);
        totalPresent=new JLabel();
        totalPresent.setVisible(false);
        atdPresent=new JLabel();
        atdPresent.setVisible(false);
        notFound=new JLabel();
        notFound.setVisible(false);
        //-------------------//
        //----close button---//
        close=new JButton("Close");
        close.setFocusable(false);
        close.setBounds(100,100,100,30);
        close.setBackground(new Color(0x99E1E7));
        close.addActionListener(this);
        //-------------------//
        data.add(close);
        data.add(totalPresent);
        data.add(totalDay);
        data.add(atdPresent);
        data.add(notFound);
        this.add(data);
        this.add(usnEnter);
        this.add(usnText);
        this.add(Submit);
        this.setVisible(true);
    }
    public void reade(String s,String usn)
    {
        String[] studentList;
        try {
//------------Reading and counting-----------//
            //----section A
            FileReader fr=new FileReader("C:\\Users\\sachi\\Desktop\\attandancr management\\ooc_project_1\\total attandance data\\"+s+"A_total.txt");
            BufferedReader r = new BufferedReader(fr);
            int count=0;
            String line;
            while ((line=r.readLine())!=null)
            {
                //System.out.println(line);
                count++;
            }
            r.close();
            //----section B
            FileReader frr=new FileReader("C:\\Users\\sachi\\Desktop\\attandancr management\\ooc_project_1\\total attandance data\\"+s+"B_total.txt");
            BufferedReader rr = new BufferedReader(frr);
            while ((line=rr.readLine())!=null)
            {
                //System.out.println(line);
                count++;
            }
            //----section C
            //System.out.println(count);
            rr.close();
            FileReader frrr=new FileReader("C:\\Users\\sachi\\Desktop\\attandancr management\\ooc_project_1\\total attandance data\\"+s+"C_total.txt");
            BufferedReader rrr = new BufferedReader(frrr);
            while ((line=rrr.readLine())!=null)
            {
                //System.out.println(line);
                count++;
            }
//            System.out.println(count);
            rrr.close();
            //----------------------------------//
             studentList=new String[count];
//-------------------------------------------------------------//
            //----section A
            FileReader abx=new FileReader("C:\\Users\\sachi\\Desktop\\attandancr management\\ooc_project_1\\total attandance data\\"+s+"A_total.txt");
            BufferedReader Abc = new BufferedReader(abx);
            count=0;
            while ((line=Abc.readLine())!=null)
            {
                //System.out.println(line);
                studentList[count]=line;
                count++;
            }
            Abc.close();
            //----section B
            FileReader Ac=new FileReader("C:\\Users\\sachi\\Desktop\\attandancr management\\ooc_project_1\\total attandance data\\"+s+"B_total.txt");
            BufferedReader Abb = new BufferedReader(Ac);
            while ((line=Abb.readLine())!=null)
            {
                //System.out.println(line);
                studentList[count]=line;
                count++;
            }
            //----section C
            //System.out.println(count);
            Abb.close();
            FileReader A=new FileReader("C:\\Users\\sachi\\Desktop\\attandancr management\\ooc_project_1\\total attandance data\\"+s+"C_total.txt");
            BufferedReader Ab = new BufferedReader(A);
            while ((line=Ab.readLine())!=null)
            {
                //System.out.println(line);
                studentList[count]=line;
                count++;
            }
            //System.out.println(count);
            Ab.close();
//            System.out.println("all done");
//            for(String q:studentList)
//            {
//                System.out.println(q);
//            }
            String pattern = ".*"+usn+".*";
            int i;
            boolean flag=false;
            for( i=0;i<count;i++)
            {
                String str=studentList[i].toLowerCase();
                if(Pattern.matches(pattern,str))
                {
                    //System.out.println("matched");
                    flag=true;
                    break;
                }
            }
            if(flag==true)
            {
                //--1
                notFound.setVisible(false);
               totalDay.setText("Total Days: "+studentList[i].charAt(studentList[i].length()-1));
               totalDay.setBounds(10,20,200,50);
               totalDay.setForeground(Color.BLACK);
               totalDay.setVisible(true);


               totalPresent.setText("Total Present: "+studentList[i].charAt(studentList[i].length()-3));
               totalPresent.setBounds(10,40,200,50);
               totalPresent.setForeground(Color.BLACK);
               totalPresent.setVisible(true);

               int a,b;
               a=studentList[i].charAt(studentList[i].length()-1) - 48;
               b=studentList[i].charAt(studentList[i].length()-3) -48;
               double d=(b*100)/a;
               //System.out.println(d);
               atdPresent.setText("Overall Attendance:"+d+"%");
               atdPresent.setBounds(10,60,200,50);
                if(d>=75)
                   atdPresent.setForeground(Color.green);
               else
                   atdPresent.setForeground(Color.red);
               atdPresent.setVisible(true);
               this.setVisible(true);
            }
            if(flag==false)
            {
                totalDay.setVisible(false);
                totalPresent.setVisible(false);
                atdPresent.setVisible(false);
                notFound.setBounds(80,20,300,50);
                notFound.setText("USN not Found...!!");
                notFound.setForeground(Color.red);
                notFound.setVisible(true);
            }


        }
        catch (Exception e){}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Submit) {
//            this.remove(data);
//            this.add(data);
            String usn = usnEnter.getText();
            usn = usn.toLowerCase();
            //System.out.println(usn);
            if (usn.startsWith("1hk21cs")) {
                String s="1_USN_";
                reade(s,usn);
            }
            if (usn.startsWith("1hk20cs")) {
                String s="2_USN_";
                reade(s,usn);
            }
            if (usn.startsWith("1hk19cs")) {
                String s="3_USN_";
                reade(s,usn);
            }
            if (usn.startsWith("1hk18cs")) {
                String s="4_USN_";
                reade(s,usn);
            }
        }
        if(e.getSource()==close)
        {
            this.dispose();
        }
    }
}
//public class totalAttendance {
//    public static void main(String[] args) {
//        new totalAttendances();
//    }
//}
