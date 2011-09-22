/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr334Coin;

/**
 *
 * @author otavio
 */
 import javax.swing.*;
 import javax.swing.plaf.LayerUI;
 import java.awt.*;

 public class ExemploJlayer {

     private static JLayer<JComponent> createLayer() {
       
         LayerUI<JComponent> layerUI = new LayerUI<JComponent>() {

             public void paint(Graphics g, JComponent c) {
                 
                 super.paint(g, c);
                 
                 g.setColor(new Color(0, 128, 0, 128));
                 g.fillRect(0, 0, c.getWidth(), c.getHeight());
             }

             public void installUI(JComponent c) {
                 super.installUI(c);


                 ((JLayer) c).setLayerEventMask(AWTEvent.MOUSE_MOTION_EVENT_MASK);
             }

             public void uninstallUI(JComponent c) {
                 super.uninstallUI(c);
             
                 ((JLayer) c).setLayerEventMask(0);
             }

             
             public void eventDispatched(AWTEvent e, JLayer<? extends JComponent> l) {
                 System.out.println("AWTEvent detected: " + e);
             }
         };
    
         JPanel panel = new JPanel();
         panel.add(new JButton("JButton"));

    
         return new JLayer<>(panel, layerUI);
     }

     private static void createAndShowGUI() {
         final JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
         frame.add(createLayer());

         frame.setSize(200, 200);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
     }

     public static void main(String[] args) throws Exception {
         SwingUtilities.invokeAndWait(new Runnable() {
             public void run() {
                 createAndShowGUI();
             }
         });
     }
 }
