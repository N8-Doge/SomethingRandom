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
    private ClassCreation displayClassCreation;
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
        
        //ClassCreation
        ActionListener classConfirmButton = new CreateClassConfirmListener();
        displayClassCreation = new ClassCreation(classConfirmButton);
    }

    /**
     * Updates the panel
     */
    public void update(){
        revalidate();
        repaint();
    }
    
    private class MenuViewListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            removeAll();
            update();
        }
    }
    private class MenuRemindListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            removeAll();
            update();
        }
    }
    private class MenuCreateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            removeAll();
            add(displayCreateMenu);
            update();
        }
    }
    private class CreateClassListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            removeAll();
            add(displayClassCreation);
            update();
        }
    }
    private class CreateTaskListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            removeAll();
            update();
        }
    }
    private class CreateClassConfirmListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            removeAll();
            update();
        }
    }
}