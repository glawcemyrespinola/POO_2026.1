/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author marcio
 */
public class Fundo extends javax.swing.JInternalFrame {

    public Fundo() {
        initComponents();
        try {
            fundo = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("tela.jpeg"),"tela.jpeg"));
        } catch (Exception e) {
        }
    }
@Override
    public void paint(Graphics Fundo){
        Fundo.drawImage(fundo, 0, 0,getWidth(),getHeight(),this);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected static Image fundo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
