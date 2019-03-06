import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
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
    private ItemCreation displayItemCreation;
    private Scanner infile;
    /**
     * Default constructor
     */
    public Display()
    {
        //Initialize files if not exist
        String workdir = System.getProperty("user.home")+"/.somethingrandom";
        new File(workdir).mkdirs();
        String classesFile = workdir+"/classes.txt";
        File f = new File(classesFile);
        try{
            if(f.createNewFile()){
                JOptionPane.showMessageDialog(null,"Created new files");
            }
            infile = new Scanner(f);
        }
        catch(Exception e){
            System.out.println(""+e);
        }
        
        //ArrayList of classes
        ArrayList<String> classes = new ArrayList<String>();
        while(infile.hasNext()){
            classes.add(infile.next());
        }
        
        //Menu
        ActionListener[] menuButtons = new ActionListener[3];
        menuButtons[0] = new PanelSwitcher(-1);
        menuButtons[1] = new PanelSwitcher(-1);
        menuButtons[2] = new PanelSwitcher(1);
        displayMenu = new Menu(menuButtons);
        add(displayMenu);

        //CreateMenu
        ActionListener[] createButtons = new ActionListener[3];
        createButtons[0] = new PanelSwitcher(2);
        createButtons[1] = new PanelSwitcher(3);
        createButtons[2] = new PanelSwitcher(0);
        displayCreateMenu = new CreateMenu(createButtons);

        //ClassCreation
        ActionListener[] classCreateButtons = new ActionListener[2];
        classCreateButtons[0] = new PanelSwitcher(1);
        classCreateButtons[1] = new PanelSwitcher(-1);
        displayClassCreation = new ClassCreation(classCreateButtons, classes);
        
        //ItemCreation
        ActionListener[] itemCreateButtons = new ActionListener[2];
        itemCreateButtons[0] = new PanelSwitcher(1);
        itemCreateButtons[1] = new PanelSwitcher(-1);
        displayItemCreation = new ItemCreation(itemCreateButtons, classes);
    }

    /**
     * Updates the panel
     */
    public void update(){
        revalidate();
        repaint();
    }

    private class PanelSwitcher implements ActionListener{
        private int panel;
        public PanelSwitcher(int panel){
            this.panel=panel;
        }

        public void actionPerformed(ActionEvent e){
            removeAll();
            switch(panel){
                case 0:
                add(displayMenu);
                break;
                case 1:
                add(displayCreateMenu);
                break;
                case 2:
                add(displayClassCreation);
                break;
                case 3:
                add(displayItemCreation);
                break;
                case 4:
                break;
                default:
                System.out.println("DEBUG: Panel="+panel);
                break;
            }
            update();
        }
    }
}