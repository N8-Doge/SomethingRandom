import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Menu to create a class
 *
 * @author      Nathan Chen
 * @version     3-5-19
 */
public class ClassCreation extends Window
{
    //Instance variables
    private ClassObject[] classNames;
    private JTextField[] fields={new JTextField(""), new JTextField("")};
    
    /**
     * Creates the class
     * 
     * @param   buttonListeners   Listeners for buttons in class
     */
    public ClassCreation(ActionListener[] buttonListeners, ClassObject[] classNames)
    {
        super("New Class");
        this.classNames = classNames;
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5,1));
        JButton viewClasses = new JButton("View Classes");
        viewClasses.addActionListener(new ViewClassesListener());
        center.add(viewClasses);
        String[] fieldText = {"Class Name","Period # (Optional)"};
        addTextFields(center, fieldText, fields);
        add(center, BorderLayout.CENTER);
        JPanel south = new JPanel();
        south.setLayout(new GridLayout(1,2));
        String[] lowerText = {"Back","Confirm"};
        addButtons(south, lowerText, buttonListeners);
        add(south, BorderLayout.SOUTH);
    }

    /**
     * Returns the JTextFields of the class
     */
    public JTextField[] getFields(){return fields;}

    /**
     * Checks if the data in the JTextFields is valid for storing
     * 
     * @param   j   Array of JTextFields that is being checked
     */
    public boolean isValid(JTextField[] j){
        if(!j[1].getText().equals("")){
            try{
                int foo = Integer.parseInt(j[1].getText());
            }
            catch(NumberFormatException e){
                return false;
            }
        }
        if(!j[0].getText().matches("[a-zA-Z ]+")){
            return false;
        }
        return true;
    }

    /**
     * Tells the user with a JOptionPane why their text is invalid
     */
    public void whyNot(JTextField[] j){
        String message = "Text is invalid because:\n";
        if(!j[1].getText().equals("")){
            try{
                int foo = Integer.parseInt(j[1].getText());
            }
            catch(NumberFormatException e){
                message+="•Period must be a number\n";
            }
        }
        if(!j[0].getText().matches("[a-zA-Z ]+")){
            message+="•Class name can only contain letters and spaces\n";
        }
        JOptionPane.showMessageDialog(null, message ,"Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * Returns a String that is used for storing in files
     */
    public String getStoreText(){
        String result = "\n";
        if(fields[1].getText().equals("")){
            result+="noperiod\n";
        }
        else{
            result+=fields[1].getText()+"\n";
        }
        result+=fields[0].getText();
        return result;
    }

    /**
     * Resets the class with new class names and blank JTextFields
     * 
     * @param   classNames  Array of ClassObjects containing the class names
     */
    public void reset(ClassObject[] classNames){
        this.classNames=classNames;
        for(JTextField j:fields){
            j.setText("");
        }
    }

    private class ViewClassesListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String s = "Current Classes:\n";
            for(ClassObject c: classNames){
                s+=c.toString()+"\n";
            }
            JOptionPane.showMessageDialog(null,s);
        }
    }
}