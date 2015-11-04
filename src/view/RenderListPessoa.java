/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author boleto verde 02
 */
public class RenderListPessoa extends DefaultListCellRenderer{
    
    
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,boolean isSelected,boolean cellHasFocus){
     
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Pessoa p = (Pessoa) value;
        label.setIcon(new ImageIcon("./fotos/"+p.getFoto()));
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);        
        return label;
    }
    
}
