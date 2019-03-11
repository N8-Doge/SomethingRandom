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
    private String outfile, workdir, classesFile, itemsFile;
    /**
     * Default constructor
     */
    public Display()
    {
        //Initialize files if not exist
        workdir = System.getProperty("user.home")+"/.somethingrandom";
        new File(workdir).mkdirs();
        classesFile = workdir+"/classes.txt";
        itemsFile = workdir+"/items.txt";
        ClassObject[] classNames=getClassObject();

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
        classCreateButtons[1] = new PanelSwitcher(4);
        displayClassCreation = new ClassCreation(classCreateButtons, classNames);

        //ItemCreation
        ActionListener[] itemCreateButtons = new ActionListener[2];
        itemCreateButtons[0] = new PanelSwitcher(1);
        itemCreateButtons[1] = new PanelSwitcher(5);
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
            foo.add(0, next);
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

    /**
     * Appends class to file
     */
    public void createClass(){
        outfile=displayClassCreation.getStoreText();
        try{
            File file = new File(classesFile);
            FileWriter fr = new FileWriter(file, true);
            fr.write(outfile);
            fr.close();
        }
        catch(Exception e){System.out.println(e);}
        ClassObject[] newClasses = getClassObject();
        //Refresh ClassCreation
        displayClassCreation.reset(newClasses);
        //Refresh ItemCreation
        displayItemCreation.reset(newClasses);
        JOptionPane.showMessageDialog(null,"Created Class");
    }
    
    public void createItem(){
        outfile=displayItemCreation.getStoreText();
        try{
            File file = new File(itemsFile);
            FileWriter fr = new FileWriter(file, true);
            fr.write(outfile);
            fr.close();
        }
        catch(Exception e){System.out.println(e);}
        JOptionPane.showMessageDialog(null,"Created Item");
    }

    public ClassObject[] getClassObject(){
        File f = new File(classesFile);
        File g = new File(itemsFile);
        try{
            if(f.createNewFile()|g.createNewFile()){
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
            classNames[i]=new ClassObject(classes.get(2*i),classes.get(2*i+1));
        }
        return classNames;
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
                createClass();
                add(displayMenu);
                break;
                case 5:
                createItem();
                add(displayMenu);
                break;
                default:
                JOptionPane.showMessageDialog(null,"Under Development");
                add(displayMenu);
                break;
            }
            update();
        }
    }
}