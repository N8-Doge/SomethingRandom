import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Display controlling where to go
 *
 * @author      Nathan Chen
 * @version     3-4-19
 */
public class Display extends JPanel
{
    //Instance variables
    private Menu displayMenu;
    private CreateMenu displayCreateMenu;
    
    /**
     * Default constructor
     */
    public Display()
    {
        //Menu
        ActionListener[] menuButtons = new ActionListener[3];
        menuButtons[0] = new MenuViewListener();
        menuButtons[1] = new MenuRemindListener();
        menuButtons[2] = new MenuCreateListener();
        displayMenu = new Menu(menuButtons);
        add(displayMenu);

        //CreateMenu
        ActionListener[] createButtons = new ActionListener[2];
        createButtons[0] = new CreateClassListener();
        createButtons[1] = new CreateTaskListener();
        displayCreateMenu = new CreateMenu(createButtons);
    }

    /**
     * Updates the panel
     */
    public void update(){
        revalidate();
        repaint();
    }
    
    /**
     * Listener class for View Button in Menu
     */
    private class MenuViewListener implements ActionListener{
        /**
         * Goes to Calendar page
         * 
         * @param   e   ActionEvent for button press
         */
        public void actionPerformed(ActionEvent e){
            removeAll();
            update();
        }
    }
    
    /**
     * Listener class for Reminder Button in Menu
     */
    private class MenuRemindListener implements ActionListener{
        /**
         * Goes to Reminder page
         * 
         * @param   e   ActionEvent for button press
         */
        public void actionPerformed(ActionEvent e){
            removeAll();
            update();
        }
    }
    
    /**
     * Listener class for Create Button in Menu
     */
    private class MenuCreateListener implements ActionListener{
        /**
         * Goes to Creation Page
         * 
         * @param   e   ActionEvent for button press
         */
        public void actionPerformed(ActionEvent e){
            removeAll();
            add(displayCreateMenu);
            update();
        }
    }
    
    /**
     * Listener class for Class Button in Create
     */
    private class CreateClassListener implements ActionListener{
        /**
         * Goes to Class Creation Page
         * 
         * @param   e   ActionEvent for button press
         */
        public void actionPerformed(ActionEvent e){
            removeAll();
            update();
        }
    }
    
    /**
     * Listener class for Task Button in Create
     */
    private class CreateTaskListener implements ActionListener{
        /**
         * Goes to Task Creation Page
         * 
         * @param   e   ActionEvent for button press
         */
        public void actionPerformed(ActionEvent e){
            removeAll();
            update();
        }
    }
}