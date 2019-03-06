import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Menu to create a item
 *
 * @author      Nathan Chen
 * @version     3-5-19
 */
public class ItemCreation extends Window
{
    /**
     * Creates the class
     * 
     * @param   buttonListeners   Listeners for buttons in class
     */
    public ItemCreation(ActionListener[] buttonListeners, ArrayList<String> classes)
    {
        super("New Item");
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(7,1));
        String[] arr = new String[classes.size()];
        for(int i=0;i<classes.size();i++)
            arr[i]=classes.get(i);
        JComboBox classList = new JComboBox(arr);
        center.add(classList);
        String[] fieldText = {"Item Name","Due Date (Optional)", "Notes (Optional)"};
        addTextFields(center, fieldText);
        add(center, BorderLayout.CENTER);
        
        JPanel south = new JPanel();
        south.setLayout(new GridLayout(1,2));
        String[] lowerText = {"Back","Confirm"};
        addButtons(south, lowerText, buttonListeners);
        add(south, BorderLayout.SOUTH);
    }
}
