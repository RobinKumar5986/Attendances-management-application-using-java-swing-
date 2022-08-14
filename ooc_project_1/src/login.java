import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class login extends JFrame {

    JFrame frame;
    JPanel panel;
    JLabel user,Login,pass, invalidPass=new JLabel("Invalid ID Password...!!!");
    JTextField txt,paa;
    JButton loginbtn,signUp;
    login()
    {


        //-------------------------------//
        invalidPass.setVisible(false);
        //----------------------//
        frame=new JFrame("Login...!!!");
        //frame.setSize(500,500);
        //-----setting the position------//
        frame.setBounds(500,120,500,500);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(new Color(245, 233, 193, 219));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        //--------panel--------//
        panel=new JPanel();
        //panel.setBackground(Color.red);//color
        panel.setBounds(60,100-50,300+50,300+50);
        panel.setLayout(null);
        panel.setBackground(new Color(245, 233, 193, 219));
       //panel.setBorder(2,Color.red);
        //----------label user----------//
        user=new JLabel("User");
        user.setBounds(100,23,100,50);
        user.setFont(new Font("Times New Roman",Font.BOLD,20));
        user.setForeground(Color.BLACK);
        //---------label password-------//
        pass=new JLabel("password");
        pass.setBounds(60,95,150,50);
        pass.setFont(new Font("Times New Roman",Font.BOLD,20));
        pass.setForeground(Color.BLACK);
        //------text field---------//
        txt=new JTextField();
        txt.setBounds(50+100,40,100,20);
        //-----password fiend------//
        paa=new JPasswordField();
        paa.setBounds(50+100,40+70,100,20);
        //-----login  button-------//
        //btn 1
        loginbtn=new JButton("Login");
        loginbtn.setFocusable(false);
        loginbtn.setBackground(new Color(0x99E1E7));
        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean matched=false;
                String uname=txt.getText().toString();
                String pwd=paa.getText().toString();
                try {
                    FileReader fr = new FileReader("loginIdPwd.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line=br.readLine())!=null) {
                        if (line.equals(uname + "\t" + pwd)) {
                            matched = true;
                            break;
                        }
                    }
                    fr.close();
                }catch (Exception exp){}
                if(matched==true) {
                    new SubjectAndDate();
                    frame.dispose();
                }
                else
                {

                   invalidPass.setBounds(90,190,200,50);
                   invalidPass.setForeground(Color.red);
                   invalidPass.setVisible(true);
                }

            }
        });
        loginbtn.setBounds(70,150,100,50);

        //btn 2
        signUp=new JButton("SignUP");
        signUp.setBackground(new Color(0x99E1E7));
        signUp.setBounds(180,150,100,50);
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SignUp s= new SignUp();
               s.setBounds(520,120,300,300);
               s.setVisible(true);
               frame.dispose();
            }
        });
        //----login text---//
        Login=new JLabel("Login");
        Login.setForeground(Color.BLUE);
        Login.setFont(new Font("Times New Roman",Font.BOLD,30));
        Login.setBounds(100,5,100,50);
        //-------adding------------//
        panel.add(invalidPass);
        panel.add(signUp);
        panel.add(loginbtn);
        panel.add(txt);
        panel.add(paa);
        panel.add(user);
        panel.add(pass);
        frame.add(panel);
        frame.add(Login);
        frame.setVisible(true);
    }
}
