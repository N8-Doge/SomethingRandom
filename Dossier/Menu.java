import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Program menu
 *
 * @author      Nathan Chen
 * @version     2-27-19
 */
public class Menu extends Window
{
    /**
     * Creates the class
     * 
     * @param       buttonListeners     ActionListener array for buttons
     */
    public Menu(ActionListener[] buttonListeners)
    {
        super("Menu");
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,1));
        String[] buttonNames = {"View Tasks","Reminders","New Task"};
        addButtons(center, buttonNames, buttonListeners);
        add(center, BorderLayout.CENTER);
        
        JPanel south = new JPanel();
        south.setLayout(new GridLayout(1,3));
        String[] lowerButtonNames = {"Close", "Info", "Options"};
        ActionListener[] lowerButtonListeners = {new CloseListener(), new InfoListener(), new OptionsListener()};
        addButtons(south, lowerButtonNames, lowerButtonListeners);
        add(south, BorderLayout.SOUTH);
    }
    
    /**
     * Listener class for Close Button
     */
    private class CloseListener implements ActionListener{
        /**
         * Closes program
         * 
         * @param   e   ActionEvent for button press
         */
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    /**
     * Listener class for Info Button
     */
    private class InfoListener implements ActionListener{
        /**
         * Displays info as JOptionPane
         * 
         * @param   e   ActionEvent for button press
         */
        public void actionPerformed(ActionEvent e){
            String s = "Group Project by:";
            s+="\nNathan Chen, Benjamin Tu";
            s+="\nAlexis Raya, Leo Ding, Javier De La Cruz";
            s+="\nPlease rate our project!";
            JOptionPane.showMessageDialog(null,s);
        }
    }
    
    /**
     * Listener class for Options Buttons
     */
    private class OptionsListener implements ActionListener{
        /**
         * Displays Options
         * 
         * @param   e   ActionEvent for button press
         */
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,"Options in Development");
        }
    }
}
