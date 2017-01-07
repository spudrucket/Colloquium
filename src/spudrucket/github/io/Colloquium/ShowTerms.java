/*
 * Copyright (C) 2016 Mark_K
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package spudrucket.github.io.Colloquium;

import spudrucket.github.io.Colloquium.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import spudrucket.github.io.Colloquium.exceptions.IllegalOrphanException;

/**
 *
 * @author spudrucket
 */
public class ShowTerms extends javax.swing.JFrame {

    int idColumn = 0;
    
    /**
     * Creates new form ShowTerms
     */
    public ShowTerms() {
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
        termsQuery = java.beans.Beans.isDesignTime() ? null : ColloquiumPUEntityManager.createQuery("SELECT t FROM Terms t");
        termsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : termsQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.setAutoCreateRowSorter(true);
        newTermButton = new javax.swing.JButton();
        editTermButton = new javax.swing.JButton();
        deleteTerm = new javax.swing.JButton();
        showUsagesButton = new javax.swing.JButton();

        setTitle("Show Terms");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, termsList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rootword}"));
        columnBinding.setColumnName("Rootword");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${forms}"));
        columnBinding.setColumnName("Forms");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${occurances}"));
        columnBinding.setColumnName("Occurances");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${notes}"));
        columnBinding.setColumnName("Notes");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(10);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        newTermButton.setText("New");
        newTermButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTermButtonActionPerformed(evt);
            }
        });

        editTermButton.setText("Edit");
        editTermButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTermButtonActionPerformed(evt);
            }
        });

        deleteTerm.setText("Delete");
        deleteTerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTermActionPerformed(evt);
            }
        });

        showUsagesButton.setText("Show Occurances");
        showUsagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUsagesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(showUsagesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newTermButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editTermButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteTerm)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTermButton)
                    .addComponent(editTermButton)
                    .addComponent(deleteTerm)
                    .addComponent(showUsagesButton))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int getSelectedTerm () {        
        if (jTable1.isRowSelected(jTable1.getSelectedRow())) {           
            int selectedTerm = (Integer) jTable1.getValueAt(jTable1.getSelectedRow(), idColumn);   
            return selectedTerm;
        }
        else {
            JOptionPane.showMessageDialog(null,"Please first select a term.");
        }
        return -1;
    }
    
    private void newTermButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTermButtonActionPerformed
        AddTerm at = new AddTerm();
        at.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_newTermButtonActionPerformed

    private void deleteTermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTermActionPerformed
        if (getSelectedTerm() != -1) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Term? \nAll occurances will be lost.");
            if (confirm == 0) {
                int termId = getSelectedTerm();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
                EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
                Query dbTermQuery = entityManager.createNamedQuery("Terms.findById").setParameter("id", termId);
                Terms term = (Terms) dbTermQuery.getSingleResult();
                Query dbUsagesQuery = entityManager.createNamedQuery("Usages.findByTerm").setParameter("term", term);
                List<Usages> usagesList = dbUsagesQuery.getResultList();
                UsagesJpaController ujc = new UsagesJpaController(emf);
                for (Usages u : usagesList) {
                    try {
                        ujc.destroy(u.getId());
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(ShowTerms.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                               
                TermsJpaController tjc = new TermsJpaController(emf);                                                   
                try {
                    tjc.destroy(termId);
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(ShowTerms.class.getName()).log(Level.SEVERE, null, ex);
                } catch (spudrucket.github.io.Colloquium.exceptions.NonexistentEntityException ex) {
                    Logger.getLogger(ShowTerms.class.getName()).log(Level.SEVERE, null, ex);
                }                                                                                
            }           
            this.setVisible(false);
            ShowTerms st = new ShowTerms();
            st.setVisible(true);
        }
    }//GEN-LAST:event_deleteTermActionPerformed

    private void showUsagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUsagesButtonActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            this.setVisible(false);
            ShowUsages su = new ShowUsages();
            su.setVisible(true);
        }
        else {
            int termId = getSelectedTerm();
            EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
            Query query = entityManager.createNamedQuery("Terms.findById").setParameter("id", termId);
            Terms term = (Terms) query.getSingleResult();
            this.setVisible(false);
            ShowUsages su = new ShowUsages(term);
            su.setVisible(true);
        }
    }//GEN-LAST:event_showUsagesButtonActionPerformed

    private void editTermButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTermButtonActionPerformed
        int termId = getSelectedTerm();
        if (termId != -1) {
            EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
            Query query = entityManager.createNamedQuery("Terms.findById").setParameter("id", termId);
            Terms term = (Terms) query.getSingleResult();
            UpdateTerms ut = new UpdateTerms(term);
            ut.setVisible(true);
            this.setVisible(false); 
        }
    }//GEN-LAST:event_editTermButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ColloquiumPUEntityManager;
    private javax.swing.JButton deleteTerm;
    private javax.swing.JButton editTermButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton newTermButton;
    private javax.swing.JButton showUsagesButton;
    private java.util.List<spudrucket.github.io.Colloquium.Terms> termsList;
    private javax.persistence.Query termsQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}