import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * A Java GUI Panel with a few things laid out
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
        this.header=header;
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
     * @param   b   List of JButtons
     * @param   a   List of Listeners
     */
    public void addButtons(Container c, String[] s, JButton[] b, ActionListener[] a){
        for(int i=0;i<s.length;i++){
            b[i] = new JButton(s[i]);
            b[i].addActionListener(a[i]);
            c.add(b[i]);
        }
    }
}
