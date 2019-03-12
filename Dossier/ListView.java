import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * A JPanel that displays the tasks as a table
 *
 * @author Nathan Chen
 * @version 3-11-19
 */
public class ListView extends Window
{
    public ListView(ActionListener[] buttons, ClassObject[] classNames, ItemObject[] items){
        super("Tasks");
        
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(classNames.length,1));
        for(int i=0;i<classNames.length;++i){
            JPanel section = new JPanel();
            section.setLayout(new GridLayout(1,2));
            section.add(new JLabel(classNames[i].toString()));
            JPanel grid = new JPanel();
            int index=0;
            for(ItemObject j:items){
                if(j.getPeriod().equals(classNames[i].toString())){
                    ++index;
                }
            }
            grid.setLayout(new GridLayout(index,1));
            for(ItemObject j:items){
                if(j.getPeriod().equals(classNames[i].toString())){
                    JButton itemButton = new JButton(j.getName());
                    itemButton.addActionListener(new MoreInfo(j));
                    grid.add(itemButton);
                }
            }
            section.add(grid);
            center.add(section);
        }
        add(center, BorderLayout.CENTER);
        
        JPanel south = new JPanel();
        JButton back = new JButton("Menu");
        back.addActionListener(buttons[0]);
        south.add(back);
        add(south, BorderLayout.SOUTH);
    }
    
    private class MoreInfo implements ActionListener{
        private ItemObject storedItem;
        public MoreInfo(ItemObject i){storedItem=i;}
        public void actionPerformed(ActionEvent e){
            String message = storedItem.toString();
            JOptionPane.showMessageDialog(null, message ,"More Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
