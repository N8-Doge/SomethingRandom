import java.awt.*;
import java.util.*;
import javax.swing.*;
/**
 * Used to start up jar file, template from torbert's driver
 * 
 * @author      Nathan Chen
 * @version     2-27-19
 */
public class Driver12
{
    /**
     * Runs program
     * 
     * @param   args    For jar, ignore
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("My Schedule");
        frame.setSize(400, 400);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Menu());
        frame.setVisible(true);
    }
}
//JOptionPane.showMessageDialog(null,"warning message","title",JOptionPane.ERROR_MESSAGE);