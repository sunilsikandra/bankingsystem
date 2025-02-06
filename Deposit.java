package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener
{
    String pin;
    TextField textField;
    JButton b1,b2;


    Deposit(String pin)
    {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("source/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1610,890,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(-5,0,1610,890);
        add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(480,170,400,35);
        label1.setForeground(Color.WHITE);
        l3.add(label1);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(480,220,320,25);
        textField.setFont(new Font("Rale way",Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(730,395,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(730,442,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1610,1000);
        setLocation(-5,0);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try
        {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource()==b1)
            {
                if (textField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null ,"Please enter the Amount you want to Deposit");
                }
                else
                {
                    con c = new con();
                    c.statement.executeUpdate( "insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null ,"Rs "+amount+" Deposit Successfully");
                    setVisible(false);
                    new main_Class(pin);
                }
            }
            else if(e.getSource()==b2)
            {
                setVisible(false);
                new main_Class(pin);
            }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

    }
}
