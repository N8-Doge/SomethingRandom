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
    public Menu()
    {
        super("Menu");
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,1));
        center.add(new JButton("View Schedule"));
        center.add(new JButton("Reminders"));
        center.add(new JButton("New Item"));
        add(center, BorderLayout.CENTER);
    }
}
