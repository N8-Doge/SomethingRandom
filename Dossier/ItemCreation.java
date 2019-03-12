import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Menu to create a item
 *
 * @author      Nathan Chen
 * @version     3-5-19
 */
public class ItemCreation extends Window
{
    private JTextField[] fields = {new JTextField(), new JTextField(), new JTextField()};
    private ClassObject[] classNames;
    private JComboBox classList;
    /**
     * Creates the class
     * 
     * @param   buttonListeners   Listeners for buttons in class
     */
    public ItemCreation(ActionListener[] buttonListeners, ClassObject[] classNames)
    {
        super("New Item");
        this.classNames=classNames;
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(7,1));
        String[] arr = new String[classNames.length];
        for(int i=0;i<classNames.length;i++){
            arr[i]=classNames[i].toString();
        }
        classList = new JComboBox(arr);
        center.add(classList);
        String[] fieldText = {"Item Name","Due Date (Optional)", "Notes (Optional)"};
        addTextFields(center, fieldText, fields);
        add(center, BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setLayout(new GridLayout(1,2));
        String[] lowerText = {"Back","Confirm"};
        addButtons(south, lowerText, buttonListeners);
        add(south, BorderLayout.SOUTH);
    }

    public JTextField[] getFields(){return fields;}

    public boolean isValid(JTextField[] j){
        String regex = "(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])-((20)\\d\\d)";
        if(!j[1].getText().equals("")){
            if(!j[1].getText().matches(regex)){
                return false;
            }
        }
        regex = "[a-zA-Z0-9 .!@#$%^&*()_+|-]+";
        if(!j[0].getText().matches(regex)){
            return false;
        }
        if(!j[2].getText().equals("")){
            if(!j[2].getText().matches(regex)){
                return false;
            }
        }
        return true;
    }

    public void whyNot(JTextField[] j){
        String message = "Text is invalid because:\n";
        String regex = "(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])-((20)\\d\\d)";
        if(!j[1].getText().equals("")){
            if(!j[1].getText().matches(regex)){
                message+="•Date does not match MM-DD-YYYY format\n";
            }
        }
        regex = "[a-zA-Z0-9 .!@#$%^&*()_+|-]+";
        if(!j[0].getText().matches(regex)){
            message+="•Title can only contain a-zA-Z0-9 .!@#$%^&*()_+|-\n";
        }
        if(!j[2].getText().equals("")){
            if(!j[2].getText().matches(regex)){
                message+="•Notes can only contain a-zA-Z0-9 .!@#$%^&*()_+|-\n";
            }
        }
        JOptionPane.showMessageDialog(null, message ,"Warning", JOptionPane.WARNING_MESSAGE);
    }

    public String getStoreText(){
        String result = "\n"+classList.getSelectedItem().toString();
        result+="\n"+fields[0].getText();
        if(fields[1].getText().equals("")){
            result+="\nnoduedate";
        }
        else{
            result+="\n"+fields[1].getText();
        }
        if(fields[2].getText().equals("")){
            result+="\nnonotes";
        }
        else{
            result+="\n"+fields[2].getText();
        }
        return result;
    }

    public void reset(ClassObject[] classNames){
        this.classNames=classNames;
        for(JTextField j:fields){
            j.setText("");
        }
        classList.removeAllItems();
        for(int i=0;i<classNames.length;i++){
            classList.addItem(classNames[i].toString());
        }
    }
}
