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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author spudrucket
 */
public class UpdateInterviews extends javax.swing.JFrame {

    MainWindow mainwindow;
    
    /**
     * Creates new form UpdateInterviews
     */
    public UpdateInterviews() {
        initComponents();
    }
    
    public UpdateInterviews(Interviews selectedInterview, MainWindow mw) {
        this.mainwindow = mw;
        initComponents();
        selectInterviewComboBox.setSelectedItem(selectedInterview);
    }

    private java.sql.Date getSqlDate(String startDate) throws Exception {
        java.sql.Date sqlStartDate = null;
        if (startDate != null && !startDate.isEmpty()) {
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
        jLabel1 = new javax.swing.JLabel();
        theme1TextField = new javax.swing.JTextField();
        theme2TextField = new javax.swing.JTextField();
        theme3TextField = new javax.swing.JTextField();
        theme4TextField = new javax.swing.JTextField();
        theme5TextField = new javax.swing.JTextField();
        theme6TextField = new javax.swing.JTextField();
        theme7TextField = new javax.swing.JTextField();
        theme8TextField = new javax.swing.JTextField();
        theme9TextField = new javax.swing.JTextField();

        interviewerLabel.setText("Interviewer:");

        locationLabel.setText("Location:");

        dateLabel.setText("Date (M/d/yyyy):");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, informantsList, informantComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        summaryLabel.setText("Summary:");

        summaryTextArea.setColumns(20);
        summaryTextArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
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
        dateFormatedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("M/d/yyyy"))));

        informantLabel.setText("Informant:");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, interviewsList, selectInterviewComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        selectInterviewComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectInterviewComboBoxActionPerformed(evt);
            }
        });

        selectInterviewLabel.setText("Select Interview to Update:");

        jLabel1.setText("Interview Themes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateInterviewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(locationTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateFormatedTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                    .addComponent(interviewerTextField)))
                            .addComponent(instructionsLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectInterviewLabel)
                                .addGap(30, 30, 30)
                                .addComponent(selectInterviewComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel1))
                            .addComponent(theme1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(theme2TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(theme3TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(theme4TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(theme5TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(theme6TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(theme7TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(theme8TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(theme9TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(summaryLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(updateInterviewButton)
                                    .addComponent(cancelButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 22, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(theme3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme6TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme7TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme8TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme9TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
            updateInterview.setTheme1(theme1TextField.getText());
            updateInterview.setTheme2(theme2TextField.getText());
            updateInterview.setTheme3(theme3TextField.getText());
            updateInterview.setTheme4(theme4TextField.getText());
            updateInterview.setTheme5(theme5TextField.getText());
            updateInterview.setTheme6(theme6TextField.getText());
            updateInterview.setTheme7(theme7TextField.getText());
            updateInterview.setTheme8(theme8TextField.getText());
            updateInterview.setTheme9(theme9TextField.getText());
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
            mainwindow.populateTree();
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
            theme1TextField.setText(updateInt.getTheme1());
            theme2TextField.setText(updateInt.getTheme2());
            theme3TextField.setText(updateInt.getTheme3());
            theme4TextField.setText(updateInt.getTheme4());
            theme5TextField.setText(updateInt.getTheme5());
            theme6TextField.setText(updateInt.getTheme6());
            theme7TextField.setText(updateInt.getTheme7());
            theme8TextField.setText(updateInt.getTheme8());
            theme9TextField.setText(updateInt.getTheme9());
        }
    }//GEN-LAST:event_selectInterviewComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ColloquiumPUEntityManager;
    private javax.swing.JButton cancelButton;
    private javax.swing.JFormattedTextField dateFormatedTextField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JComboBox<String> informantComboBox;
    private javax.swing.JLabel informantLabel;
    private java.util.List<spudrucket.github.io.Colloquium.Informants> informantsList;
    private javax.persistence.Query informantsQuery;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JLabel interviewerLabel;
    private javax.swing.JTextField interviewerTextField;
    private java.util.List<spudrucket.github.io.Colloquium.Interviews> interviewsList;
    private javax.persistence.Query interviewsQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationTextField;
    private javax.swing.JComboBox<String> selectInterviewComboBox;
    private javax.swing.JLabel selectInterviewLabel;
    private javax.swing.JLabel summaryLabel;
    private javax.swing.JTextArea summaryTextArea;
    private javax.swing.JTextField theme1TextField;
    private javax.swing.JTextField theme2TextField;
    private javax.swing.JTextField theme3TextField;
    private javax.swing.JTextField theme4TextField;
    private javax.swing.JTextField theme5TextField;
    private javax.swing.JTextField theme6TextField;
    private javax.swing.JTextField theme7TextField;
    private javax.swing.JTextField theme8TextField;
    private javax.swing.JTextField theme9TextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JButton updateInterviewButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
