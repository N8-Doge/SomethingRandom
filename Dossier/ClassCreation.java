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
    private ClassObject[] classNames;
    private JTextField[] fields;
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
        JTextField[] reference = {new JTextField(), new JTextField()};
        fields = reference;
        addTextFields(center, fieldText, reference);
        add(center, BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setLayout(new GridLayout(1,2));
        String[] lowerText = {"Back","Confirm"};
        addButtons(south, lowerText, buttonListeners);
        add(south, BorderLayout.SOUTH);
    }
    
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
