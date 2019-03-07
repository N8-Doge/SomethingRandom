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
        ArrayList<String> classes = getClasses(infile, new ArrayList<String>());
        ClassObject[] classNames = new ClassObject[classes.size()/2];
        for(int i=0;i<classes.size()/2;i++){
            classNames[i]=new ClassObject(classes.get(2*i+1),classes.get(2*i));
        }
        
        //Menu
        ActionListener[] menuButtons = new ActionListener[2];
        menuButtons[0] = new PanelSwitcher(-1);
        menuButtons[1] = new PanelSwitcher(1);
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
        displayClassCreation = new ClassCreation(classCreateButtons, classNames);

        //ItemCreation
        ActionListener[] itemCreateButtons = new ActionListener[2];
        itemCreateButtons[0] = new PanelSwitcher(1);
        itemCreateButtons[1] = new PanelSwitcher(-1);
        displayItemCreation = new ItemCreation(itemCreateButtons, classNames);
    }

    /**
     * Helper method for getting classes from a scanner recursively
     * 
     * @param   scannerIn   Scanner where things are read
     * @param   s           ArrayList of strings to append to
     */
    public ArrayList<String> getClasses(Scanner scannerIn, ArrayList<String> s){
        ArrayList<String> foo = s;
        if(infile.hasNext()){
            String next = scannerIn.next();
            foo = getClasses(scannerIn, s);
            foo.add(next);
        }
        return foo;
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
                default:
                    JOptionPane.showMessageDialog(null,"Under Development");
                    break;
            }
            update();
        }
    }
}