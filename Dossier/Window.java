import java.awt.*;
import javax.swing.*;
/**
 * A Java GUI Panel with a few things laid out
 *
 * @author      Nathan Chen
 * @version     2-27-19
 */
public abstract class Window extends JPanel
{
    private static JLabel header;
    public Window(String headerText){
        this.header=header;
        setLayout(new BorderLayout());
        JPanel north = new JPanel();
        add(north, BorderLayout.NORTH);
        header = new JLabel(headerText);
        header.setFont(new Font("Arial",Font.BOLD,32));
        north.add(header);
    }
}
