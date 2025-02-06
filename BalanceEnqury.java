package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnqury extends JFrame implements ActionListener
{
    String pin;
    JLabel label2;
    JButton b1;
    BalanceEnqury(String pin)
    {
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("source/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1610,890,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(-5,0,1610,890);
        add(l3);

        JLabel label1 = new JLabel("Your Current Balance Is Rs ");
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(480,170,700,35);
        label1.setForeground(Color.WHITE);
        l3.add(label1);

        label2 = new JLabel();
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(495,210,700,35);
        label2.setForeground(Color.WHITE);
        l3.add(label2);

        b1 = new JButton("Back");
        b1.setBounds(730,440,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        int balance = 0;
        try
        {
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (resultSet.next())
            {
                if (resultSet.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }
                else
                {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

        label2.setText(""+balance);
        setLayout(null);
        setSize(1610,1000);
        setLocation(-5,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        setVisible(false);
        new main_Class(pin);
    }

    public static void main(String[] args)
    {
        new BalanceEnqury("");
    }
}
