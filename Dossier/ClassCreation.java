import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Menu to create a class
 *
 * @author      Nathan Chen
 * @version     3-5-19
 */
public class ClassCreation extends Window
{
    /**
     * Creates the class
     * 
     * @param   buttonListeners   Listeners for buttons in class
     */
    public ClassCreation(ActionListener[] buttonListeners, ArrayList<String> classes)
    {
        super("New Class");
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5,1));
        String[] fieldText = {"Class Name","Period # (Optional)"};
        JLabel list = new JLabel("Classes:\n"+ classes);
        list.setFont(new Font("Arial",Font.ITALIC,12));
        center.add(list);
        addTextFields(center, fieldText);
        add(center, BorderLayout.CENTER);
        
        JPanel south = new JPanel();
        south.setLayout(new GridLayout(1,2));
        String[] lowerText = {"Back","Confirm"};
        addButtons(south, lowerText, buttonListeners);
        add(south, BorderLayout.SOUTH);
    }
}
