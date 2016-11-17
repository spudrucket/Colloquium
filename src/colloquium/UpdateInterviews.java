/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloquium;

import colloquium.exceptions.NonexistentEntityException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mark_K
 */
public class UpdateInterviews extends javax.swing.JFrame {

    /**
     * Creates new form UpdateInterviews
     */
    public UpdateInterviews() {
        initComponents();
    }
    
    public UpdateInterviews(Interviews selectedInterview) {
        initComponents();
        selectInterviewComboBox.setSelectedItem(selectedInterview);
    }

    private java.sql.Date getSqlDate(String startDate) throws Exception {
        java.sql.Date sqlStartDate = null;
        if (startDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            java.util.Date date = sdf.parse(startDate);
            sqlStartDate = new Date(date.getTime());
        }
        return sqlStartDate;
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
        interviewsQuery = java.beans.Beans.isDesignTime() ? null : ColloquiumPUEntityManager.createQuery("SELECT i FROM Interviews i");
        interviewsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : interviewsQuery.getResultList();
        informantsQuery = java.beans.Beans.isDesignTime() ? null : ColloquiumPUEntityManager.createQuery("SELECT i FROM Informants i");
        informantsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : informantsQuery.getResultList();
        interviewerLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        informantComboBox = new javax.swing.JComboBox<>();
        summaryLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        summaryTextArea = new javax.swing.JTextArea();
        titleLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        updateInterviewButton = new javax.swing.JButton();
        instructionsLabel = new javax.swing.JLabel();
        interviewerTextField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        locationTextField = new javax.swing.JTextField();
        dateFormatedTextField = new javax.swing.JFormattedTextField();
        informantLabel = new javax.swing.JLabel();
        selectInterviewComboBox = new javax.swing.JComboBox<>();
        selectInterviewLabel = new javax.swing.JLabel();

        interviewerLabel.setText("Interviewer:");

        locationLabel.setText("Location:");

        dateLabel.setText("Date (M/d/yyyy):");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, informantsList, informantComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        summaryLabel.setText("Summary:");

        summaryTextArea.setColumns(20);
        summaryTextArea.setRows(5);
        jScrollPane1.setViewportView(summaryTextArea);

        titleLabel.setText("Interview Title*:");

        updateInterviewButton.setText("Update Interview");
        updateInterviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInterviewButtonActionPerformed(evt);
            }
        });

        instructionsLabel.setText("*Interview Title is a required field.");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        dateFormatedTextField.setColumns(1);
        dateFormatedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat(""))));

        informantLabel.setText("Informant:");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, interviewsList, selectInterviewComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        selectInterviewComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectInterviewComboBoxActionPerformed(evt);
            }
        });

        selectInterviewLabel.setText("Select Interview to Update:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(informantLabel)
                                    .addComponent(titleLabel))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleTextField)
                                    .addComponent(informantComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(interviewerLabel)
                                    .addComponent(locationLabel)
                                    .addComponent(dateLabel)
                                    .addComponent(summaryLabel))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateFormatedTextField)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                    .addComponent(interviewerTextField)
                                    .addComponent(locationTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(instructionsLabel)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(updateInterviewButton)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(selectInterviewLabel)
                                .addGap(30, 30, 30)
                                .addComponent(selectInterviewComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectInterviewComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectInterviewLabel))
                .addGap(18, 18, 18)
                .addComponent(instructionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(informantLabel)
                    .addComponent(informantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interviewerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interviewerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateFormatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(summaryLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateInterviewButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateInterviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInterviewButtonActionPerformed
        Interviews updateInterview = (Interviews)selectInterviewComboBox.getSelectedItem();
        if (updateInterview != null) {
            updateInterview.setTitle(titleTextField.getText());
            updateInterview.setInformant((Informants)informantComboBox.getSelectedItem());
            updateInterview.setInterviewer(interviewerTextField.getText());
            updateInterview.setLocation(locationTextField.getText());
            try {
                updateInterview.setInterviewdate(getSqlDate(dateFormatedTextField.getText()));
            } catch (Exception ex) {
                Logger.getLogger(UpdateInterviews.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateInterview.setSummary(summaryTextArea.getText());
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
            InterviewsJpaController ijc = new InterviewsJpaController(emf);
            try {
                ijc.edit(updateInterview);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(UpdateInterviews.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(UpdateInterviews.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.setVisible(false);
            ShowInterviews sint = new ShowInterviews();
            sint.setVisible(true);
        }
    }//GEN-LAST:event_updateInterviewButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void selectInterviewComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectInterviewComboBoxActionPerformed
        Interviews updateInt = (Interviews)selectInterviewComboBox.getSelectedItem();
        if (updateInt != null) {
            titleTextField.setText(updateInt.getTitle());
            informantComboBox.setSelectedItem(updateInt.getInformant());
            interviewerTextField.setText(updateInt.getInterviewer());
            locationTextField.setText(updateInt.getLocation());
            dateFormatedTextField.setValue(updateInt.getInterviewdate());
            summaryTextArea.setText(updateInt.getSummary());
        }
    }//GEN-LAST:event_selectInterviewComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateInterviews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateInterviews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateInterviews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateInterviews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateInterviews().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ColloquiumPUEntityManager;
    private javax.swing.JButton cancelButton;
    private javax.swing.JFormattedTextField dateFormatedTextField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JComboBox<String> informantComboBox;
    private javax.swing.JLabel informantLabel;
    private java.util.List<colloquium.Informants> informantsList;
    private javax.persistence.Query informantsQuery;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JLabel interviewerLabel;
    private javax.swing.JTextField interviewerTextField;
    private java.util.List<colloquium.Interviews> interviewsList;
    private javax.persistence.Query interviewsQuery;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationTextField;
    private javax.swing.JComboBox<String> selectInterviewComboBox;
    private javax.swing.JLabel selectInterviewLabel;
    private javax.swing.JLabel summaryLabel;
    private javax.swing.JTextArea summaryTextArea;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JButton updateInterviewButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
