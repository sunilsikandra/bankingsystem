package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
    JLabel label1,label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;

    JButton button1,button2,button3;

    Login()
    {
        super("Saksham Bank System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("source/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(365,10,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("source/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(655,350,100,100);
        add(iimage);

        ImageIcon iiii1 = new ImageIcon(ClassLoader.getSystemResource("source/atm1.png"));
        Image iiii2 = iiii1.getImage().getScaledInstance(200,320, Image.SCALE_DEFAULT);
        ImageIcon iiii3 = new ImageIcon(iiii2);
        JLabel iiiimage = new JLabel(iiii3);
        iiiimage.setBounds(30,100,200,320);
        add(iiiimage);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Ralway", Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(230,190,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(350,190,230,30);
        textField2.setFont(new Font("Arial", Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("       Pin:");
        label3.setFont(new Font("Ralway" , Font.BOLD ,30));
        label3.setForeground(Color.WHITE);
        label3.setBounds(230,250,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(350,250,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);

        button1 = new JButton("Sign In");
        button1.setFont(new Font("Arial", Font.BOLD,14));
        button1.setForeground(Color.BLACK);
        button1.setBackground(Color.WHITE);
        button1.setBounds(350,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Clear");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setBackground(Color.WHITE);
        button2.setForeground(Color.BLACK);
        button2.setBounds(479,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SignUp");
        button3.setFont(new Font("Arial", Font.BOLD,14));
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.WHITE);
        button3.setBounds(350,350,235,30);
        button3.addActionListener(this);
        add(button3);



        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("source/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);





        setLayout(null);
        setSize(850,480);
        setLocation(400,250);
        //setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource() == button1)
            {
                con c = new con();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet result = c.statement.executeQuery(q);
                if(result.next())
                {
                    setVisible(false);
                    new main_Class(pin);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number Or Pin");
                }

            }
            else if (e.getSource() == button2)
            {
                textField2.setText("");
                passwordField3.setText("");
            }
            else if (e.getSource() == button3)
            {

                new SignUp();
                setVisible(false);
            }
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }
    }

    public static void main(String[] args)
        {
            new Login();
        }

}
