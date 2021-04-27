
package com.swing.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class DeletePizza extends JFrame
{
    private Connection connection;
    
   private JPanel p1,p2;
   private JComboBox cbox1;
   private JButton cmd1;
   
   private void initComponentEvent()
   {
       //l1=new JLabel("");
       
       cbox1=new JComboBox();
      
       
       cmd1=new JButton("Delete");
       this.getRootPane().setDefaultButton(cmd1);
       
       p1=new JPanel(new GridLayout(1,1));
       p1.setBorder(BorderFactory.createTitledBorder("Select Pizza"));
       p1.add(cbox1);
       
       p2=new JPanel(new GridBagLayout());
       p2.setBorder(BorderFactory.createTitledBorder("Action"));
       p2.add(cmd1);
       
       
       this.getContentPane().add(p1,BorderLayout.NORTH);
       this.getContentPane().add(p2,BorderLayout.SOUTH);
               
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
    
     private void initButtonEvent()
     {
       cmd1.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e)
           {
              delete();
           }
       });
   }
   
   private void delete()
   {
       try
       {
          
            PreparedStatement ps=connection.prepareStatement("delete from addpizza where pid=?");
                ps.setString(1, cbox1.getSelectedItem().toString().split("-")[0]);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pizza Details Deleted Successfully");
       } 
       catch(Exception e)
       {
           
       }
       
   }
   
   
   
   
   
   
    
    public DeletePizza(Connection c)
    {
        this.connection=c;
        this.initComponentEvent();
        this.initComboBoxEvent();
        this.initButtonEvent();
        this.setTitle("Delete Pizza Record");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(300,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    
    
}
