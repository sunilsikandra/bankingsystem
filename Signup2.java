package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener
{



    JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
    String formno;
    JTextField textpan, textAadhar;
    JRadioButton r1,r2,e1,e2;
    JButton next;



    Signup2(String formno)
    {

        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("source/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,5,100,100);
        add(image);

        this.formno = formno;

        JLabel l1 = new JLabel("Page 2 :-");
        l1.setFont(new Font("Rale way",Font.BOLD,22));
        l1.setBounds(360,60,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("rale way",Font.BOLD,22));
        l2.setBounds(320,100,600,40);
        add(l2);

        JLabel l3 = new JLabel("Religion :");
        l3.setFont(new Font("Rale way",Font.BOLD,18));
        l3.setForeground(new Color(50, 50, 50));
        l3.setBounds(100,160,200,30);
        add(l3);

        String religion[] = {"HINDU","SIKH","CHRISTIAN","MUSLIM","Other's"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(252,208,76));
        comboBox.setFont(new Font("Rale way",Font.BOLD,14));
        comboBox.setBounds(350,160,320,30);
        add(comboBox);

        JLabel l4 = new JLabel("Category :");
        l4.setFont(new Font("Rale way",Font.BOLD,18));
        l4.setForeground(new Color(50, 50, 50));
        l4.setBounds(100,200,200,30);
        add(l4);

        String category[] = {"General","Obc","Sc","St","Other's"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(new Color(252,208,76));
        comboBox2.setFont(new Font("Rale way",Font.BOLD,14));
        comboBox2.setBounds(350,200,320,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income :");
        l5.setFont(new Font("Rale way",Font.BOLD,18));
        l5.setForeground(new Color(50, 50, 50));
        l5.setBounds(100,240,200,30);
        add(l5);

        String income[] = {"Null","<1,00,000","<2,50,000","<5,00,000","Up To 10,00,000", "Above 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(252,208,76));
        comboBox3.setFont(new Font("Rale way",Font.BOLD,14));
        comboBox3.setBounds(350,240,320,30);
        add(comboBox3);

        JLabel l6 = new JLabel("Education :");
        l6.setFont(new Font("Rale way",Font.BOLD,18));
        l6.setForeground(new Color(50, 50, 50));
        l6.setBounds(100,280,200,30);
        add(l6);

        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate", "Other"};
        comboBox4 = new JComboBox(education);
        comboBox4.setBackground(new Color(252,208,76));
        comboBox4.setFont(new Font("Rale way",Font.BOLD,14));
        comboBox4.setBounds(350,280,320,30);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation :");
        l7.setFont(new Font("Rale way",Font.BOLD,18));
        l7.setForeground(new Color(50, 50, 50));
        l7.setBounds(100,320,200,30);
        add(l7);

        String occupation[] = {"Salared","self-Employed","Business","Student","Retired", "Other"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setBackground(new Color(252,208,76));
        comboBox5.setFont(new Font("Rale way",Font.BOLD,14));
        comboBox5.setBounds(350,320,320,30);
        add(comboBox5);

        JLabel l8 = new JLabel("Pan Number :");
        l8.setFont(new Font("Rale way",Font.BOLD,18));
        l8.setForeground(new Color(50, 50, 50));
        l8.setBounds(100,360,200,30);
        add(l8);

        textpan = new JTextField();
        textpan.setFont(new Font("Rale way",Font.BOLD,18));
        textpan.setBounds(350,360,320,30);
        add(textpan);

        JLabel l9 = new JLabel("Aadhar Number :");
        l9.setFont(new Font("Rale way",Font.BOLD,18));
        l9.setForeground(new Color(50, 50, 50));
        l9.setBounds(100,400,250,30);
        add(l9);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Rale way",Font.BOLD,18));
        textAadhar.setBounds(350,400,320,30);
        add(textAadhar);

        JLabel l10 = new JLabel("Senior Citizen :");
        l10.setFont(new Font("Rale way",Font.BOLD,18));
        l10.setForeground(new Color(50, 50, 50));
        l10.setBounds(100,440,250,30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Rale way",Font.BOLD,18));
        r1.setBackground(new Color(79, 223, 208));
        r1.setBounds(350,440,100,30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Rale way",Font.BOLD,18));
        r2.setBackground(new Color(79, 223, 208));
        r2.setBounds(500,440,100,30);
        add(r2);

        JLabel l11 = new JLabel("Existing Account :");
        l11.setFont(new Font("Rale way",Font.BOLD,18));
        l11.setForeground(new Color(50, 50, 50));
        l11.setBounds(100,480,250,30);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Rale way",Font.BOLD,18));
        e1.setBackground(new Color(79, 223, 208));
        e1.setBounds(350,480,100,30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Rale way",Font.BOLD,18));
        e2.setBackground(new Color(79, 223, 208));
        e2.setBounds(500,480,100,30);
        add(e2);


        JLabel l12 = new JLabel("Form Number :");
        l12.setFont(new Font("Rale way",Font.BOLD,14));
        l12.setBounds(470,10,180,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Rale way",Font.BOLD,14));
        l13.setBounds(575,10,480,30);
        add(l13);

        next = new JButton("Next");
        next.setFont(new Font("Rale way",Font.BOLD,14));
        next.setForeground(Color.BLACK);
        next.setBackground(Color.WHITE);
        next.setBounds(570,640,100,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(79, 223, 208));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        String rel = (String)  comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();

        String pan = textpan.getText();
        String aadhar = textAadhar.getText();

        String scitizen = "";
        if (r1.isSelected())
        {
            scitizen = "yes";
        }
        else if (r2.isSelected())
        {
            scitizen = "No";
        }

        String eAccount = "";
        if (e1.isSelected())
        {
            eAccount = "Yes";
        } else if (e2.isSelected())
        {
            eAccount = "No";
        }

        try
        {
            if (textpan.getText().equals("") || textAadhar.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }
            else
            {
                con c = new con();
                String q = "insert into signuptwo values('"+formno+"', '"+rel+"', '"+cate+"', '"+inc+"', '"+edu+"', '"+occ+"', '"+pan+"', '"+aadhar+"', '"+scitizen+"', '"+eAccount+"')";
                c.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }

        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

    }

    public static void main(String [] args)
    {
        new Signup2("");
    }

}
