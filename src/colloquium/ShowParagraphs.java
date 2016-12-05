/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloquium;

import colloquium.exceptions.NonexistentEntityException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Mark_K
 */
public class ShowParagraphs extends javax.swing.JFrame {
    
    public static int idColumn = 0;

    /**
     * Creates new form ShowParagraphs
     */
    public ShowParagraphs() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        ColloquiumPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        paragraphsQuery = java.beans.Beans.isDesignTime() ? null : ColloquiumPUEntityManager.createQuery("SELECT p FROM Paragraphs p");
        paragraphsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : paragraphsQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setTitle("Paragraphs");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, paragraphsList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${informant}"));
        columnBinding.setColumnName("Informant");
        columnBinding.setColumnClass(colloquium.Informants.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${interviewnumber}"));
        columnBinding.setColumnName("Interviewnumber");
        columnBinding.setColumnClass(colloquium.Interviews.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${text}"));
        columnBinding.setColumnName("Text");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${trans}"));
        columnBinding.setColumnName("Trans");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${notes}"));
        columnBinding.setColumnName("Notes");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tags}"));
        columnBinding.setColumnName("Tags");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane1.setViewportView(jTable1);

        updateButton.setText("Edit");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Paragraphs getSelectedParagraph () {
        Paragraphs selectedParagraph = null;
        if (jTable1.isRowSelected(jTable1.getSelectedRow())) {
            for (Paragraphs p : paragraphsList) {
                if (p.getId().equals(jTable1.getValueAt(jTable1.getSelectedRow(), idColumn))) {
                selectedParagraph = p;
                break;
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Please first select a paragraph.");
        }
        return selectedParagraph;
    }
    
    private LinkedList<Paragraphs> getSelectedParagraphs() {
        LinkedList<Paragraphs> selectedParagraphs = new LinkedList();
        if (jTable1.isRowSelected(jTable1.getSelectedRow())){
            int[] paragraphsArray = jTable1.getSelectedRows();
            for (int i = 0; i < paragraphsArray.length; i++) {
                for (Paragraphs p : paragraphsList) {
                    if (jTable1.getValueAt(paragraphsArray[i], idColumn) == p.getId()) {
                        selectedParagraphs.add(p);
                        break;
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Please first select a Paragraph.");
        }
        return selectedParagraphs;
    }
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        Paragraphs updateParagraph = getSelectedParagraph();
        if (updateParagraph != null) {
            UpdateParagraphs up = new UpdateParagraphs(updateParagraph);
            up.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (getSelectedParagraph() != null) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Paragraph?");
            if (confirm == 0) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
                LinkedList<Paragraphs> selectedParagraphs = getSelectedParagraphs();
                for (Paragraphs p : selectedParagraphs) {
                    ParagraphsJpaController pjc = new ParagraphsJpaController(emf);                
                    try {
                        pjc.destroy(p.getId());
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(ShowParagraphs.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                                                                
            }
            
            this.setVisible(false);
            ShowParagraphs sp = new ShowParagraphs();
            sp.setVisible(true);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ShowParagraphs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowParagraphs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowParagraphs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowParagraphs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowParagraphs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ColloquiumPUEntityManager;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<colloquium.Paragraphs> paragraphsList;
    private javax.persistence.Query paragraphsQuery;
    private javax.swing.JButton updateButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
