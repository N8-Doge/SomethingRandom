import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * A Java GUI Panel laid out for Menu and CreateMenu
 *
 * @author      Nathan Chen
 * @version     2-27-19
 */
public abstract class Window extends JPanel
{
    //Instance variables
    private static JLabel header;
    
    /**
     * Constructor makes Window with a header
     * 
     * @param   headerText  String to go in header
     */
    public Window(String headerText){
        setLayout(new BorderLayout());
        JPanel north = new JPanel();
        add(north, BorderLayout.NORTH);
        header = new JLabel(headerText);
        header.setFont(new Font("Arial",Font.BOLD,32));
        north.add(header);
    }
    
    /**
     * Adds JButtons to a Container
     * 
     * @param   c   Container where JButtons go
     * @param   s   Array of Strings for JButton text
     * @param   a   List of Listeners
     */
    public void addButtons(Container c, String[] s, ActionListener[] a){
        for(int i=0;i<s.length;i++){
            JButton b = new JButton(s[i]);
            b.addActionListener(a[i]);
            c.add(b);
        }
    }
    
    /**
     * Adds JTextFields to a Container
     * 
     * @param   c   Container where JTextFields go
     * @param   s   Array of Strings for JTextField tooltip
     */
    public void addTextFields(Container c, String[] s){
        for(int i=0;i<s.length;i++){
            c.add(new JLabel(s[i]));
            JTextField t = new JTextField();
            c.add(t);
        }
    }
}
