import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Item creation menu
 *
 * @author      Nathan Chen
 * @version     3-4-19
 */
public class CreateMenu extends Window
{
    /**
     * Creates the class
     * 
     * @param       buttonListeners     ActionListener array for buttons
     */
    public CreateMenu(ActionListener[] buttonListeners)
    {
        super("Create:");
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,1));
        String[] buttonNames = {"New Class","New Task","Back"};
        addButtons(center, buttonNames, buttonListeners);
        add(center, BorderLayout.CENTER);
    }
}
