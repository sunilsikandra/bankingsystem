package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener
{
    JButton b1, b2;
    JPasswordField p1,p2;
    String pin;
    PinChange(String pin)
    {

        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("source/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1610,890,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(-5,0,1610,890);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(450,170,400,35);
        label1.setForeground(Color.WHITE);
        l3.add(label1);

        JLabel label2 = new JLabel("New PIN");
        label2.setFont(new Font("System",Font.BOLD,14));
        label2.setBounds(450,210,400,35);
        label2.setForeground(Color.WHITE);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(585,214,270,25);
        p1.setFont(new Font("Rale way",Font.BOLD,22));
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN");
        label3.setFont(new Font("System",Font.BOLD,14));
        label3.setBounds(450,250,400,35);
        label3.setForeground(Color.WHITE);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(585,254,270,25);
        p2.setFont(new Font("Rale way",Font.BOLD,22));
        l3.add(p2);

        b1 = new JButton("CHANGE");
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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2))
            {
                JOptionPane.showMessageDialog(null,"Entered PIN does Not Match");
                return;
            }
            if (e.getSource()==b1)
            {
                if(p1.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Enter New Pin");
                    return;
                }
                if(p2.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Re-Enter New Pin");
                    return;
                }

                con c = new con();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new main_Class(pin);
            }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new PinChange("");
    }
}
