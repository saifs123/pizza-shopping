package com.swing.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class UpdatePizzas extends JFrame
{
    private Connection connection;
    private JComboBox cbox1;
    private JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    private JButton cmd1,cmd2;
    private JPanel p1,p2,p3;
    
    private void initComponent()
    {
        cbox1=new JComboBox();
        
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
         l7=new JLabel("Incredient");
         l8=new JLabel("Toppings");
         l9=new JLabel("Sauces");
         
         
        
        cmd1=new JButton("Reset");
        cmd2=new JButton("Update");
        this.getRootPane().setDefaultButton(cmd2);
        
        p1=new JPanel(new GridLayout(1,1,5,5));
        p1.setBorder(BorderFactory.createTitledBorder("Select Pizza"));
        p1.add(cbox1);
        
       p2=new JPanel(new GridLayout(9,2,5,5));
       p2.setBorder(BorderFactory.createTitledBorder("Update Pizza Details"));
         p2.add(l1);
         p2.add(txt1);
         p2.add(l2);
         p2.add(txt2);
         p2.add(l3);
         p2.add(txt3);
         p2.add(l4);
         p2.add(txt4);
         p2.add(l5);
         p2.add(txt5);
         p2.add(l6);
         p2.add(txt6);
         p2.add(l7);
         p2.add(txt7);
         p2.add(l8);
         p2.add(txt8);
         p2.add(l9);
         p2.add(txt9);
         
       
       p3=new JPanel(new GridLayout(1,3,5,5));
       p3.setBorder(BorderFactory.createTitledBorder("Actions"));
       p3.add(cmd1);
       p3.add(cmd2);
               
       
        this.getContentPane().add(p1,BorderLayout.NORTH);
        this.getContentPane().add(p2,BorderLayout.CENTER);
        this.getContentPane().add(p3,BorderLayout.SOUTH);
    }
    
    
   
    
    
    
    private void initComboBoxEvent()
    {
        cbox1.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent fe)
            {
                fillComboBox();
            }
        });
       
         cbox1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                fillPersonData();
            }
        });
    }
    
    private void fillComboBox()
    {
     
        try
        {
            cbox1.removeAllItems();
            PreparedStatement ps=connection.prepareStatement("select pid,pname from addpizza order by pname asc");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                String item=rs.getString(1)+"-"+rs.getString(2);
                cbox1.addItem(item);
            }
        }
        catch(Exception e){}
  }
    
   private void fillPersonData()
    {
        try
        {
           String item=cbox1.getSelectedItem().toString();
           String a[]=item.split("-");
           PreparedStatement ps=connection.prepareStatement("select * from addpizza where pid=?");
           ps.setString(1,a[0]);
           ResultSet rs=ps.executeQuery();
           if(rs.next())
           {
              txt1.setText(rs.getString(1));
               txt2.setText(rs.getString(2));
               txt3.setText(rs.getString(3));
               txt4.setText(rs.getString(4));
               txt5.setText(rs.getString(5));
               txt6.setText(rs.getString(6));
               txt7.setText(rs.getString(7));
               txt8.setText(rs.getString(8));
               txt9.setText(rs.getString(9));
           }
         
        }
        catch(Exception e){}
    }
   
   
   private void initButtonEvent()
   {
       cmd1.addActionListener(new ActionListener() {

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
              update();
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
   private void update()
   {
       try
       {
          
            PreparedStatement ps=connection.prepareStatement("update addpizza set pname=?,pprice=?,pflavour=?,psize=?,pcrust=?,pincredient=?,ptoppings=?,psauces=? where pid='1'");
            ps.setString(1,txt2.getText());
            ps.setString(2,txt3.getText());
            ps.setString(3,txt4.getText());
            ps.setString(4,txt5.getText());
            ps.setString(5,txt6.getText());
            ps.setString(6,txt7.getText());
            ps.setString(7,txt8.getText());
            ps.setString(8,txt9.getText());
            //ps.setString(9, cbox1.getSelectedItem().toString().split("-")[0]);
            int a=ps.executeUpdate();       
            if(a>0)
            {
                JOptionPane.showMessageDialog(null, "Pizza Details Updated Successfully");
                reset();
            }
       }
       catch(Exception e)
       {
           
       }
       
   }
   
   
    
    public UpdatePizzas(Connection connection)
    {
        this.initComponent();
        //txt1.requestFocus();
        this.connection=connection;
       this.initComboBoxEvent();
        this.initButtonEvent();
        this.setTitle("Update Pizza Details");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //this.setSize(300,300);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
    }
            
}
