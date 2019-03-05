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
        center.setLayout(new GridLayout(2,1));
        String[] buttonNames = {"New Class","New Task"};
        JButton[] buttons = {new JButton(), new JButton()};
        addButtons(center, buttonNames, buttons, buttonListeners);
        add(center, BorderLayout.CENTER);
    }
}
