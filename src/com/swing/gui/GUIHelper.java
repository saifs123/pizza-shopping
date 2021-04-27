package com.swing.gui;


import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUIHelper 
{
   
    public static void fillTable(Connection connection,String sql,JTable table,DefaultTableModel model)
    {
        try
        {
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            Vector<Vector>data=new Vector<>();
            Vector<String>heading=new Vector<>();
            for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
            {
                heading.addElement(rs.getMetaData().getColumnLabel(i));
            }
            while(rs.next())
            {
                Vector<String>row=new Vector<>();
                for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
                {
                    row.addElement(rs.getString(i));
                }
                data.addElement(row);
            }
            model.setDataVector(data, heading);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static void fillList(Connection connection,String sql,DefaultListModel model)
    {
            try
            {
                model.removeAllElements();
                PreparedStatement ps=connection.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    model.addElement(rs.getString(1)+"-"+rs.getString(2));
                }
            }
    catch(Exception e)
    {
        
    }
    }
    
    public static void fillpdftable(Connection connection,String sql,JTable table,DefaultTableModel model)
    {
        try
        {
            PreparedStatement ps =connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            Vector<Vector>data=new Vector<>();
            Vector<String>heading=new Vector<>();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++)
            {
                heading.addElement(rs.getMetaData().getColumnLabel(i));
            }
            while(rs.next())
            {
             Vector<String>row=new Vector<>();
             for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
             {
                 row.addElement(rs.getString(i));
             }
             data.addElement(row);
            }
            model.setDataVector(data, heading);
        }
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
