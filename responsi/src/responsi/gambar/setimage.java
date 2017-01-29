/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.gambar;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 /*
 * @author al
 */
public class setimage extends JPanel { 
private Image image=null;
    public setimage (String file) {
    try{
        image = new ImageIcon(getClass().getResource(file)).getImage();
    }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Load image Gagal");
    }
    }
@Override
 protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
       Graphics2D graphic = (Graphics2D) grphcs.create();
       graphic.drawImage(image, 0, 0, getWidth(), getHeight(), null);
      graphic.dispose();
  }
}