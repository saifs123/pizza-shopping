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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Login extends JFrame
{
     private Connection connection;
   private JLabel l1,l2,l3;
    private JTextField txt1,txt2;
    private JButton cmd1,cmd2,cmd3;
    private JPanel p1,p2,p3;
    private void initComponentEvent()
    {
     l1=new JLabel("ID");
     l2=new JLabel("Password");
     l3=new JLabel("If you are not Registered please SignUp");
     txt1=new JTextField(15);
     txt2=new JTextField(15);
     
     cmd1=new JButton("Sign Up");
     cmd2=new JButton("Log In");
     this.getRootPane().setDefaultButton(cmd2);
     cmd3=new JButton("Reset");
     
     p1=new JPanel(new GridLayout(2,2));
     p1.setBorder(BorderFactory.createTitledBorder("Login Detail"));
   p1.add(l1);
    p1.add(txt1);
     p1.add(l2);
     p1.add(txt2);
     
     p2=new JPanel(new GridLayout(1,1));
     p2.setBorder(BorderFactory.createTitledBorder("Action"));
     p2.add(cmd3);
     p2.add(cmd2);
     
      p3=new JPanel(new GridLayout(2,1));
     p3.setBorder(BorderFactory.createTitledBorder("signUp"));
     p3.add(l3);
     p3.add(cmd1);
    
     this.getContentPane().add(p1,BorderLayout.CENTER);
     this.getContentPane().add(p2,BorderLayout.SOUTH);
      this.getContentPane().add(p3,BorderLayout.NORTH);
    }
   
    
    
    
   // public Login(Connection c)
             public Login()
    {
        //this.connection=c;
      this.initWindoEvent();
       this.initComponentEvent();
       this.initButtonEvent();
        this.setTitle("Login Form");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //this.setSize(300,300);
        this.setResizable(false);
        this.pack();
    }
    
    
    private void connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection=DriverManager.getConnection("jdbc:Mysql://127.0.0.1:3306/Bike","root","");
            if(!this.connection.isClosed())
            {
                JOptionPane.showMessageDialog(null,"Welcome to Pizza Ordering System");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
            System.exit(0);
        }
    }
    private void disconnect()
    {
        try
        {
            if(!this.connection.isClosed())
            {
                this.connection.isClosed();
            }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, e.toString());
           System.exit(0);
        }
    }

    private void initWindoEvent() 
    {
        this.addWindowListener(new WindowAdapter() 
        {

            @Override
            public void windowOpened(WindowEvent e) {
           connect();
            }

            @Override
            public void windowClosing(WindowEvent e) {
            disconnect();
            }
           
        });       
    
    }
    
    
    
    
    
    
    private void initButtonEvent()
   {
       cmd3.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e)
           {
               reset();
           }
       });
       cmd2.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e)
           {
              login();
           }
       });
       cmd1.addActionListener(new ActionListener()
      {

           @Override
           public void actionPerformed(ActionEvent e)
           {
             Registration obj=new Registration(connection);
           }
       });
       
   }
   private void reset()
   {
       txt1.setText("");
       txt2.setText("");
       txt1.requestFocus();
   }
   
   
   private void login()
   {
        if((txt1.getText().equals("admin@admin.admin"))  && (txt2.getText().equals("admin")) )
            {
              
            cmd2.addActionListener(new ActionListener()
            {

           @Override
           public void actionPerformed(ActionEvent e)
           {
             AdminForm obj=new AdminForm(connection);
           }
           });
            }
        else
        {
      
    try
       {
           int flag=1;
             Connection connection=DriverManager.getConnection("jdbc:Mysql://127.0.0.1:3306/Bike","root","");
             Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery("select * from registration");
      while(rs.next())
         {
             if(rs.getString(3).equals(txt1.getText())  && rs.getString(4).equals(txt2.getText()) )
            {
               flag=0;
               break;
            }
         }
      if(flag==0)
      {
          //JOptionPane.showMessageDialog(null,"Valid User");
          
          cmd2.addActionListener(new ActionListener()
      {

           @Override
           public void actionPerformed(ActionEvent e)
           {
             MainForm obj=new MainForm(connection);
           }
       });
         
          
      }
      else 
             {
              JOptionPane.showMessageDialog(null,"Invalid User");
              }
      
       
         }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,"Ex");
       }
        
       }
   }
}

