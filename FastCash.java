package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    FastCash(String pin)
    {
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("source/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1610,890,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(-5,0,1610,890);
        add(l3);

        JLabel label = new JLabel ("SELECT WITHDRAWAL AMOUNT");
        label.setBounds(455,180,700,33);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,22));
        l3.add(label);

        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(423,290,160,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(725,290,160,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(423,340,160,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(725,340,160,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("Rs.5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(423,390,160,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(725,390,160,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("Back");
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
        if (e.getSource()==b7)
        {
            setVisible(false);
            new main_Class(pin);
        }
        else
        {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            con c = new con();
            Date date = new Date();
            try
            {
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
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
                String num ="17";

                if (e.getSource() != b7 && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");

            }

            catch (Exception E)
            {
                E.printStackTrace();
            }
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args)
    {
        new FastCash("");
    }
}
