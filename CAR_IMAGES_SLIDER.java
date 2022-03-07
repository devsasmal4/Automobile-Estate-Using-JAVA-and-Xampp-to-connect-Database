/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobile_estate;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author DEV SASMAL
 */
public class CAR_IMAGES_SLIDER extends javax.swing.JFrame {

    /**
     * Creates new form CAR_IMAGES_SLIDER
     */
    
    //get the car id
    int carId;
    
    //the image index;
    int index = 0;
    
    //images list
    ArrayList<byte[]> imagesList;
    
    public CAR_IMAGES_SLIDER() {
        initComponents();
        
        //set border to the jpanel title
        Border image_border = BorderFactory.createMatteBorder(1,1,1,1,new Color(0,0,0));
        jLabel_Image.setBorder(image_border);
        
        //set border to the next and previous 
        Border nav_border = BorderFactory.createMatteBorder(2,2,2,2,new Color(0,0,255));
        jLabel_Next.setBorder(nav_border);
        jLabel_Prev.setBorder(nav_border);
        
       displayImage(index);
       
        
    }
    
    //create a fuction to display the images by index
       public void displayImage(int imageIndex)
    {
        try
       {
        //get the images using the hashmap
        HashMap<byte[], Integer> map = new C_CARS().carImageList(carId);
        imagesList = new ArrayList<>(map.keySet());
        
        Image img = new ImageIcon(imagesList.get(imageIndex)).getImage().getScaledInstance(jLabel_Image.getWidth(), jLabel_Image.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        jLabel_Image.setIcon(image);
        }
       catch(Exception ex)
       {
       }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_Image = new javax.swing.JLabel();
        jLabel_Prev = new javax.swing.JLabel();
        jLabel_Next = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_Image.setBackground(new java.awt.Color(153, 153, 153));
        jLabel_Image.setOpaque(true);

        jLabel_Prev.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_Prev.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Prev.setText("<");
        jLabel_Prev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_PrevMouseClicked(evt);
            }
        });

        jLabel_Next.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_Next.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Next.setText(">");
        jLabel_Next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_NextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Prev, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(775, Short.MAX_VALUE)
                    .addComponent(jLabel_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Prev, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(488, Short.MAX_VALUE)
                    .addComponent(jLabel_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_PrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_PrevMouseClicked
        // show previous image
        index--;

        if(index > 0) index = 0;

        displayImage(index);
    }//GEN-LAST:event_jLabel_PrevMouseClicked

    private void jLabel_NextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_NextMouseClicked

        //show the next image
        index++;
        if(index >= imagesList.size()) index = imagesList.size() ;

        displayImage(index);
    }//GEN-LAST:event_jLabel_NextMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CAR_IMAGES_SLIDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CAR_IMAGES_SLIDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CAR_IMAGES_SLIDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CAR_IMAGES_SLIDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CAR_IMAGES_SLIDER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_Image;
    private javax.swing.JLabel jLabel_Next;
    private javax.swing.JLabel jLabel_Prev;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}