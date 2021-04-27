/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swing.gui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class AdminForm extends JFrame
{
    private Connection connection;
    private JMenuBar menubar;
    private JMenu menu1,menu2,menu3;
    private JMenuItem item1,item2,item3,item4,item5,item6,item7;
     private JLabel l1;
    private JToolBar toolbar;
    private JButton cmd1,cmd2,cmd3,cmd4,cmd5,cmd6,cmd7;
    
    private void initToolBar()
    {
     
         
        

         
    }
    
 
    private void initMenu()
    {
      item1=new JMenuItem("Add Pizza");
      item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,KeyEvent.CTRL_MASK));
      item1.setMnemonic('C');
    
      
      item2=new JMenuItem("Delete Pizza");
      item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,KeyEvent.CTRL_MASK));
      item2.setMnemonic('d');
      
      item3=new JMenuItem("Update Pizza");
      item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,KeyEvent.CTRL_MASK));
      item3.setMnemonic('u');
      
      item4=new JMenuItem("All Pizza");
      item5=new JMenuItem("Show Buyers");
     
      
      menu1=new JMenu("Pizza");
        menu1.setMnemonic('P');
        menu2=new JMenu("Show Details");
       
      
      menu1.add(item1);
      menu1.add(item2);
      menu1.add(item3);
      
    
      
      menu2.add(item4);
      menu2.add(item5);
      
      menubar=new JMenuBar();
      menubar.add(menu1);
      menubar.add(menu2);
      this.setJMenuBar(menubar);
    }
            
    public AdminForm(Connection c)
    {
        this.connection=c;
        //this.initWindoEvent();
        this.initMenu();
        this.initItemEvent();
        this.initToolBar();
      //  this.initButtonEvent();
     l1=new JLabel();
      this.setTitle("Pizza Ordering System");
      l1.setIcon(new ImageIcon(getClass().getResource("/images/pizza.jpg")));
      
     this.add(l1);
      this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
   

   private void initItemEvent()
    {
       item1.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae)
           {
               AddPizza obj=new AddPizza(connection);
               obj.setVisible(true);
           }
       });
    
       
      item3.addActionListener(new ActionListener()
       {

           @Override
           public void actionPerformed(ActionEvent e)
           {
               UpdatePizzas obj=new UpdatePizzas(connection);
           }
       });
   
        item2.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae)
           {
               DeletePizza obj=new DeletePizza(connection);
           }
       });
    
      
      item4.addActionListener(new ActionListener()
      {

           @Override
           public void actionPerformed(ActionEvent e)
           {
             ShowAllPizzas obj=new ShowAllPizzas(connection);
           }
       });
    
     
      
       
       
       item5.addActionListener(new ActionListener()
      {

           @Override
           public void actionPerformed(ActionEvent e)
           {
             ShowAllPizzasToAdmin obj=new ShowAllPizzasToAdmin(connection);
           }
       });
      }
      
}


