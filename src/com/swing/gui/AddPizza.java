package com.swing.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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

public class AddPizza extends JFrame
{
    private Connection connection;
    
     private JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9;
     private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
     private JButton cmd1,cmd2;
     private JPanel p1,p2;
     private void initComponent()
     {
         txt1=new JTextField(15);
         txt2=new JTextField(15);
         txt3=new JTextField(15);
         txt4=new JTextField(15);
         txt5=new JTextField(15);
         txt6=new JTextField(15);
         txt7=new JTextField(15);
         txt8=new JTextField(15);
         txt9=new JTextField(15);
         
         
         l1=new JLabel("Pizza Id");
         l2=new JLabel("Pizza Name");
         l3=new JLabel("Pizza Price");
         l4=new JLabel("Pizza Flavour");
         l5=new JLabel("Pizza Size");
         l6=new JLabel("Pizza Crust");
         l7=new JLabel("Ingredient");
         l8=new JLabel("Pizza Toppings");
         l9=new JLabel("Sauces");
        
         
         cmd1=new JButton("Reset");
         cmd2=new JButton("Save");
         this.getRootPane().setDefaultButton(cmd2);
         
         p1=new JPanel(new GridLayout(9,2,5,5));
         p1.setBorder(BorderFactory.createTitledBorder("Enter Pizza Details"));
         p1.add(l1);
         p1.add(txt1);
         p1.add(l2);
         p1.add(txt2);
         p1.add(l3);
         p1.add(txt3);
         p1.add(l4);
         p1.add(txt4);
         p1.add(l5);
         p1.add(txt5);
         p1.add(l6);
         p1.add(txt6);
         p1.add(l7);
         p1.add(txt7);
         p1.add(l8);
         p1.add(txt8);
         p1.add(l9);
         p1.add(txt9);
         
         p2=new JPanel(new GridLayout(1,4,5,5));
         p2.setBorder(BorderFactory.createTitledBorder("Actions"));
         p2.add(cmd1);
         p2.add(new JLabel());
         p2.add(new JLabel());
         p2.add(cmd2);
         
         this.getContentPane().add(p1,BorderLayout.NORTH);
         this.getContentPane().add(p2,BorderLayout.SOUTH);
     }
     public AddPizza(Connection c)
     {
         this.connection=c;
         this.initComponent();
         this.initButtonEvent();
         this.setTitle("Add Pizza");
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         this.setResizable(false);
         this.pack();
         this.setLocationRelativeTo(null);
     }
     private void initButtonEvent()
     {
         cmd1.addActionListener(new ActionListener() 
         {

             @Override
             public void actionPerformed(ActionEvent ae) 
             {
                 reset();
             }
         });
         cmd2.addActionListener(new ActionListener() 
         {

             @Override
             public void actionPerformed(ActionEvent ae) 
             {
                 save();
             }
         });
     }
     private void reset()
     {
         txt1.setText("");
         txt2.setText("");
         txt3.setText("");
         txt4.setText("");
         txt5.setText("");
         txt6.setText("");
         txt7.setText("");
         txt8.setText("");
         txt9.setText("");
         txt1.requestFocus();
     }
     private void save()
     {
         try
         {
             //int n=new Random().nextInt(10000);
             PreparedStatement ps=connection.prepareStatement("insert into addpizza values(?,?,?,?,?,?,?,?,?)");
             ps.setString(1, txt1.getText());
             ps.setString(2, txt2.getText());
             ps.setString(3, txt3.getText());
             ps.setString(4, txt4.getText());
             ps.setString(5, txt5.getText());
             ps.setString(6, txt6.getText());
             ps.setString(7, txt7.getText());
             ps.setString(8, txt8.getText());
             ps.setString(9, txt9.getText());
             
             int a=ps.executeUpdate();
             
             if(a>0)
             {
                 JOptionPane.showMessageDialog(null, "New Pizza Added");
                 reset();
             }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e.toString());
         }
     }
}
