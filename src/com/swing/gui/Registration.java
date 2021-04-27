package com.swing.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Registration extends JFrame
{
    private Connection connection;
    private JLabel l1,l2,l3,l4;
    private JTextField txt1,txt2,txt3,txt4;
    private JButton cmd1,cmd2;
    private JPanel p1,p2;
    private void initComponentEvent()
    {
     l1=new JLabel("Enter Your Name");
     l2=new JLabel("Enter Email Adress");
     l3=new JLabel("Enter Password");
     l4=new JLabel("Enter Confirm Password");
     
     txt1=new JTextField(15);
     txt2=new JTextField(15);
     txt3=new JTextField(15);
     txt4=new JTextField(15);
     
     cmd1=new JButton("Sign Up");
     
     this.getRootPane().setDefaultButton(cmd1);
     cmd2=new JButton("Reset");
     
     p1=new JPanel(new GridLayout(4,2,5,5));
     p1.setBorder(BorderFactory.createTitledBorder("Detail"));
   p1.add(l1);
    p1.add(txt1);
     p1.add(l2);
     p1.add(txt2);
     p1.add(l3);
     p1.add(txt3);
     p1.add(l4);
     p1.add(txt4);
     
     p2=new JPanel(new GridLayout(1,2));
     p2.setBorder(BorderFactory.createTitledBorder("Action"));
      p2.add(cmd2);
     p2.add(cmd1);
  
     this.getContentPane().add(p2,BorderLayout.SOUTH);
      this.getContentPane().add(p1,BorderLayout.NORTH);
    }
   
    public Registration(Connection c)
   // public Registration()
    {
        this.connection=c;
       // this.initWindoEvent();
        this.initComponentEvent();
        this.initButtonEvent();
        this.setTitle("Registration Form");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        
    }
    
   
     private void initButtonEvent()
     {
         cmd2.addActionListener(new ActionListener() 
         {

             @Override
             public void actionPerformed(ActionEvent ae) 
             {
                 reset();
             }
         });
         cmd1.addActionListener(new ActionListener() 
         {

             @Override
             public void actionPerformed(ActionEvent ae) 
             {
                 signup();
             }
         });
     }
     private void reset()
     {
         txt1.setText("");
         txt2.setText("");
         txt3.setText("");
         txt4.setText("");
         txt1.requestFocus();
     }
     private void signup()
     {
         if(txt3.getText().equals(txt4.getText()))
         {
         try
         {
             int n=new Random().nextInt(10000);
             PreparedStatement ps=connection.prepareStatement("insert into registration values(?,?,?,?)");
             ps.setInt(1, n);
             ps.setString(2, txt1.getText());
             ps.setString(3, txt2.getText());
             ps.setString(4, txt3.getText());
//             ps.setString(4, txt4.getText());
             
             int a=ps.executeUpdate();
             
             if(a>0)
             {
                 reset();
             }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, "data not entered");
         }
         }
         else
         {
             JOptionPane.showMessageDialog(null,"Password and confirm Password are not same.");
         }
         }
     }

