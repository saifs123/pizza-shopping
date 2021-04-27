package com.swing.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ShowAllPizzasToAdmin extends JFrame
{
    private Connection connection;
    private JTable table;
    private DefaultTableModel model;
    private JButton cmd1,cmd2;
    private JTextField txt1;
    
    private void initComponent()
    {
        txt1=new JTextField(15);
        model=new DefaultTableModel();
        model.addColumn("Pizza Id");
        model.addColumn("Pizza Name");
        model.addColumn("Price");
        model.addColumn("Buyer id");
        model.addColumn("Buyer name");
        model.addColumn("Phone No");
        model.addColumn("Address");
        model.addColumn("State");
        model.addColumn("City");
        model.addColumn("PinCode");
        model.addColumn("Payemnt Date");
        table=new JTable(model);
        
        
        cmd1=new JButton("Refresh");
        cmd2=new JButton("Search");
        this.getRootPane().setDefaultButton(cmd1);
        
        
        
        JPanel p1=new JPanel(new GridLayout(1,1,5,5));
        p1.setBorder(BorderFactory.createTitledBorder("Buyers Details"));
        p1.add(new JScrollPane(table));
        
        JPanel p2=new JPanel(new GridLayout(1,4,5,5));
        p2.setBorder(BorderFactory.createTitledBorder("Actions"));
        p2.add(cmd1);
        p2.add(new JLabel());
        p2.add(txt1);
        p2.add(cmd2);
        
        this.getContentPane().add(p1,BorderLayout.NORTH);
        this.getContentPane().add(p2,BorderLayout.SOUTH);
    }
      private void initButtonEvent()
    {
        cmd1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                GUIHelper.fillpdftable(connection, "select * from buyer order by buyername asc", table, model);
            }
        });
        cmd2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
               // GUIHelper.toPdf(table);
            }
        });
        txt1.addKeyListener(new KeyAdapter() 
        {

            @Override
            public void keyReleased(KeyEvent ke) 
            {
                String sql="select * from buyer where buyername like '"+txt1.getText()+"%'";
                GUIHelper.fillTable(connection, sql, table, model);
            }
            
            
        });
    }
    
   
    
    public ShowAllPizzasToAdmin(Connection connection)
    {
        this.connection=connection;
       this.initComponent();
        this.initButtonEvent();
        this.setTitle("Buyers Detail");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
