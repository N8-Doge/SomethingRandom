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
        addComponentsToPane(center);
        add(center, BorderLayout.CENTER);
    }
    
    /**
     * Do it really be another copy from Stack Overflow moment? 
     * Yes, it really do.
     */
    public static void addComponentsToPane(Container pane){
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        addAButton("Menu", pane);
        addAButton("View Schedule", pane);
        addAButton("New Item", pane);
    }
    
    /**
     * If it works its worth 
     * ~Ghandhi
     */
    public static void addAButton(String text, Container container){
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
}
