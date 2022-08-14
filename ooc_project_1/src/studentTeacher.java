import javax.swing.*;
import java.awt.*;

public class studentTeacher extends JFrame {
    JButton Student,teacher;
    studentTeacher()
    {
        getContentPane().setBackground(new Color(245, 233, 193));
        setBounds(500,200,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Student=new JButton("Student");
        Student.setBounds(100,100,70,30);

        //----------------//
        add(Student);
        //add(teacher);
        setVisible(true);
    }
}
