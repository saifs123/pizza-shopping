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

public class MainForm extends JFrame
{
    private Connection connection;
    private JMenuBar menubar;
    private JMenu menu1,menu2,menu3;
    private JMenuItem item1,item2;
    private JLabel l1;
       
    
    private JToolBar toolbar;
    private JButton cmd1,cmd2,cmd3,cmd4,cmd5,cmd6,cmd7;
    
    private void initToolBar()
    {
     
         
         
   
         
    }
    
    
    
     
    private void initMenu()
    {
      item1=new JMenuItem("Show Pizzas");
      item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,KeyEvent.CTRL_MASK));
      item1.setMnemonic('C');
      
      
      item2=new JMenuItem("Buy");
      item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,KeyEvent.CTRL_MASK));
      item2.setMnemonic('d');
      
      
      
      
      
      menu1=new JMenu("Pizza");
        menu1.setMnemonic('P');
        
      
      menu1.add(item1);
      menu1.add(item2);
      
      
      
      
    
      
      menubar=new JMenuBar();
      menubar.add(menu1);
      
      this.setJMenuBar(menubar);
    }
            
    public MainForm(Connection c)
    {
        this.connection=c;
        //this.initWindoEvent();
        this.initMenu();
       this.initItemEvent();
        this.initToolBar();
         
      l1=new JLabel();
      this.setTitle("Pizza Ordering System");
      l1.setIcon(new ImageIcon(getClass().getResource("/images/pizza.jpg")));
     this.add(l1);
     //l1.setSize(Toolkit.getDefaultToolkit().getScreenSize());
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
                
               ShowAllPizzasToBuyer obj=new ShowAllPizzasToBuyer(connection);
               obj.setVisible(true);
           }
       });
       
    
    
       item2.addActionListener(new ActionListener()
       {

           @Override
           public void actionPerformed(ActionEvent e)
           {
               buy obj=new buy(connection);
           }
       });
    }
   
}


