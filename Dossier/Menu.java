import java.awt.*;
import javax.swing.*;
/**
 * Program menu
 *
 * @author      Nathan Chen
 * @version     2-27-19
 */
public class Menu extends Window
{
    private static JButton viewButton, remindButton, newButton;
    public Menu()
    {
        super("Menu");
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,1));
        viewButton = new JButton("View Schedule");
        center.add(viewButton);
        remindButton = new JButton("Reminders");
        center.add(remindButton);
        newButton = new JButton("New Item");
        center.add(newButton);
        add(center, BorderLayout.CENTER);
    }
}
