/*
 * Copyright (C) 2016 spudrucket
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
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author spudrucket
 */
public class ShowTags extends javax.swing.JFrame {
    
    public static int idColumn = 0;
    MainWindow mainwindow;

    /**
     * Creates new form ShowTags
     */
    public ShowTags() {
        initComponents();
    }
    
    public ShowTags(MainWindow mw) {
        this.mainwindow = mw;
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
        tagsQuery = java.beans.Beans.isDesignTime() ? null : ColloquiumPUEntityManager.createQuery("SELECT t FROM Tags t");
        tagsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : tagsQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.setAutoCreateRowSorter(true);
        addNewButton = new javax.swing.JButton();
        updateTagButton = new javax.swing.JButton();
        deleteTagButton = new javax.swing.JButton();

        setTitle("Tags");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tagsList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tagname}"));
        columnBinding.setColumnName("Tagname");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tagdefinition}"));
        columnBinding.setColumnName("Tagdefinition");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tagexplanation}"));
        columnBinding.setColumnName("Tagexplanation");
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

        addNewButton.setText("New");
        addNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButtonActionPerformed(evt);
            }
        });

        updateTagButton.setText("Edit");
        updateTagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTagButtonActionPerformed(evt);
            }
        });

        deleteTagButton.setText("Delete");
        deleteTagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTagButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addNewButton)
                        .addGap(18, 18, 18)
                        .addComponent(updateTagButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteTagButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewButton)
                    .addComponent(updateTagButton)
                    .addComponent(deleteTagButton))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Tags getSelectedTag() {
               
        Tags selectedTag = null;
        if (jTable1.isRowSelected(jTable1.getSelectedRow())) {
            for (Tags t : tagsList) {
                if (t.getId().equals(jTable1.getValueAt(jTable1.getSelectedRow(), idColumn))) {
                    selectedTag = t;
                    break;
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Please first select a tag.");
        }
        return selectedTag;
    }
    
    private LinkedList<Tags> getSelectedTags() {
        LinkedList<Tags> selectedTags = new LinkedList();
        if (jTable1.getSelectedRows().length > 0) {
            int[] tagsArray = jTable1.getSelectedRows();
            for (int i = 0; i < tagsArray.length; i++) {
                for (Tags t : tagsList) {
                    if (jTable1.getValueAt(tagsArray[i], idColumn) == t.getId()) {
                        selectedTags.add(t);
                        break;
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Please first select a tag.");
        }
        return selectedTags;
    }
    
    private void addNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButtonActionPerformed
        AddTag addtag = new AddTag(mainwindow);
        addtag.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addNewButtonActionPerformed

    private void updateTagButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTagButtonActionPerformed
        if (getSelectedTag() != null) {
            UpdateTags ui = new UpdateTags(getSelectedTag(), mainwindow);
            ui.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_updateTagButtonActionPerformed

    private void deleteTagButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTagButtonActionPerformed
        if (getSelectedTags().size() > 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Tag(s)?");
            if (confirm == 0) {
                LinkedList<Tags> selectedTags = getSelectedTags();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");

                for (Tags t : selectedTags) {
                        TagsJpaController tjc = new TagsJpaController(emf);
                    try {
                        tjc.destroy(t.getId());
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(ShowTags.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                               
            }
        }
        
        this.setVisible(false);
        ShowTags st = new ShowTags();
        st.setVisible(true);
        mainwindow.popjList1();
    }//GEN-LAST:event_deleteTagButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ColloquiumPUEntityManager;
    private javax.swing.JButton addNewButton;
    private javax.swing.JButton deleteTagButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<spudrucket.github.io.Colloquium.Tags> tagsList;
    private javax.persistence.Query tagsQuery;
    private javax.swing.JButton updateTagButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
