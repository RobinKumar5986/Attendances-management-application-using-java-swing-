import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Pattern;


public class SignUp extends JFrame {
    JTextField t1,t2;
    JButton submit,Back;
    JLabel SignUpMsg,msgLen,msgLen2;
    JPanel magPanel1,magPanel2,msgPanel3;

    SignUp()
    {
            getContentPane().setBackground(new Color(245, 233, 193));
           setLayout(null);
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           //setSize(500,500);
           t1=new JTextField(60);
           t2=new JPasswordField(60);
           submit=new JButton("Submit");
           Back=new JButton("Back");

           t1.setBounds(100,20,80,30);
           t2.setBounds(100,60,80,30);
           submit.setBounds(70,100,80,30);
           Back.setBounds(160,100,80,30);
           Back.setFocusable(false);
           submit.setFocusable(false);

           SignUpMsg=new JLabel("SignUp");
           SignUpMsg.setFont(new Font("Times New Roman",Font.BOLD,25));
           SignUpMsg.setForeground(Color.BLUE);
           SignUpMsg.setBounds(0,20,100,50);
           //-----------message panel------//
            //#panel 1
            magPanel1=new JPanel();
            magPanel1.setLayout(null);
            magPanel1.setBounds(70,120,250,50);
            magPanel1.setVisible(false);
            //magPanel1.setBackground(Color.gray);
            //#pannel 2
            magPanel2=new JPanel();
            magPanel2.setLayout(null);
            magPanel2.setBounds(50,120,250,50);
            magPanel2.setVisible(false);
            //magPanel2.setBackground(Color.blue);
            //#pannel 3
            msgPanel3=new JPanel();
            msgPanel3.setLayout(null);
            msgPanel3.setBounds(50,120,250,50);
            msgPanel3.setVisible(false);
            //msgPanel3.setBackground(Color.green);
           Back.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   new login();
                   dispose();
               }
           });
           //----popUp---//
           submit.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                 try {
                     FileWriter fw = new FileWriter("loginIdPwd.txt", true);
                     int passLen=t2.getText().length();
                     int userLen=t1.getText().length();
                     JLabel msg = new JLabel();
                     msgLen=new JLabel("user name must contain 4 character ");
                     msgLen2=new JLabel("password must contain 4 character ");
                     //-----adding in panel----//
                     if(userLen<4)
                     {
                         magPanel1.setVisible(false);
                         msgPanel3.setVisible(false);
                         msgLen.setBounds(0,0,300,50);
                         msgLen.setForeground(Color.red);
                         magPanel2.add(msgLen);
                         add(magPanel2);//adding to frame
                         magPanel2.setVisible(true);
                     }

                     else if(passLen<4)
                     {
                         magPanel1.setVisible(false);
                         magPanel2.setVisible(false);
                         msgLen2.setBounds(0,0,300,50);
                         msgLen2.setForeground(Color.red);
                         msgPanel3.add(msgLen2);
                         add(msgPanel3);//adding to frame
                         msgPanel3.setVisible(true);
                     }
                     else{
                         //-------user name checking----//
                         try {
                             FileReader fr = new FileReader("loginIdPwd.txt");
                             BufferedReader br = new BufferedReader(fr);
                             String pattern = ".*" + t1.getText() + ".*";
                             String line;
                             boolean flag = false;
                             int count;
                             while ((line = br.readLine()) != null) {
                                 if (Pattern.matches(pattern, line)) {
                                     flag = true;
                                 }
                             }
                             fr.close();
                         //-------------------------------//
                             if(flag==false) {
                                 fw.write(t1.getText() + "\t" + t2.getText() + "\n");
                                 fw.close();
                                 JOptionPane.showMessageDialog(new JFrame(), "Registration Completed...!!!");
                                 dispose();
                                 new login();
                             }
                             if(flag==true)
                             {
                                 magPanel2.setVisible(false);
                                 msgPanel3.setVisible(false);
                                 msg.setForeground(Color.red);
                                 msg.setBounds(30,0,300,50);
                                 msg.setText("name is taken...!!!");
                                 magPanel1.add(msg);
                                 add(magPanel1);
                                 magPanel1.setVisible(true);
                             }
                         }
                         catch (Exception excp){}

                     }
                 }
                 catch (Exception ecx){}
               }

           });
           //------adding-----//

           add(SignUpMsg);
           add(t1);
           add(t2);
           add(submit);
           add(Back);
           setVisible(true);
    }
}
