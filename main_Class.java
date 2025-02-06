package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener
{

    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    main_Class(String pin)
    {

        this.pin= pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("source/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1610,890,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(-5,0,1610,890);
        add(l3);

        JLabel label = new JLabel ("PLEASE SELECT YOUR TRANSACTION");
        label.setBounds(427,180,700,33);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,24));
        l3.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(423,290,160,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("CASH WITHDRAWAL");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(725,290,160,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(423,340,160,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(725,340,160,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(423,390,160,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(725,390,160,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(725,440,160,35);
        b7.addActionListener(this);
        l3.add(b7);



        setLayout(null);
        setSize(1610,958);
        setLocation(-5,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            new Deposit(pin);
            setVisible(false);
        }
        else if (e.getSource()==b7)
        {
            System.exit(0);
        }
        else if (e.getSource()==b2)
        {
            new withdrawal(pin);
            setVisible(false);
        }
        else if (e.getSource()==b6)
        {
           new BalanceEnqury(pin);
           setVisible(false);
        }
        else if (e.getSource()==b3)
        {
            new FastCash(pin);
            setVisible(false);
        } else if (e.getSource()==b5)
        {
            new PinChange(pin);
            setVisible(false);
        } else if (e.getSource()==b4)
        {
            new Mini(pin);
        }
    }

    public static void main(String[] args)
        {
            new main_Class("");

        }

}
