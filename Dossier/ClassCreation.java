import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Menu to create a class
 *
 * @author      Nathan Chen
 * @version     2-27-19
 */
public class ClassCreation extends Window
{
    /**
     * Creates the class
     * 
     * @param   a   Listener for Confirm button
     */
    public ClassCreation(ActionListener a)
    {
        super("New Class");
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4,1));
        String[] fieldText = {"Class Name","Period # (Optional)"};
        JTextField[] fields = {new JTextField(), new JTextField()};
        addTextFields(center, fieldText, fields);
        add(center, BorderLayout.CENTER);
        
        JPanel south = new JPanel();
        JButton confirm = new JButton("Confirm");
        confirm.addActionListener(a);
        south.add(confirm);
        add(south, BorderLayout.SOUTH);
    }
}
