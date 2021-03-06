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

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;


/**
 *
 * @author spudrucket
 */
public class AddInterview extends javax.swing.JFrame {

    MainWindow mainwindow;
    
    /**
     * Creates new form AddInterview
     */
    public AddInterview() {
        initComponents();
    }
    
    public AddInterview(MainWindow mw) {
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
        informantsQuery = java.beans.Beans.isDesignTime() ? null : ColloquiumPUEntityManager.createQuery("SELECT i FROM Informants i");
        informantsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : informantsQuery.getResultList();
        informantComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        summaryTextArea = new javax.swing.JTextArea();
        addInterviewButton = new javax.swing.JButton();
        interviewerTextField = new javax.swing.JTextField();
        locationTextField = new javax.swing.JTextField();
        dateFormatedTextField = new javax.swing.JFormattedTextField();
        informantLabel = new javax.swing.JLabel();
        interviewerLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        summaryLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        instructionsLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        hasTranslationLabel = new javax.swing.JLabel();
        hasTranslationCheckBox = new javax.swing.JCheckBox();
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

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, informantsList, informantComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        summaryTextArea.setColumns(20);
        summaryTextArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        summaryTextArea.setRows(5);
        jScrollPane1.setViewportView(summaryTextArea);

        addInterviewButton.setText("Next");
        addInterviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInterviewButtonActionPerformed(evt);
            }
        });

        dateFormatedTextField.setColumns(1);
        dateFormatedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("M/d/yyyy"))));

        informantLabel.setText("Informant:");

        interviewerLabel.setText("Interviewer:");

        locationLabel.setText("Location:");

        dateLabel.setText("Date (M/d/yyyy):");

        summaryLabel.setText("Summary:");

        titleLabel.setText("Interview Title*:");

        instructionsLabel.setText("*Interview Title is a required field.");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        hasTranslationLabel.setText("With Translation:");

        hasTranslationCheckBox.setSelected(true);
        hasTranslationCheckBox.setToolTipText("");

        jLabel1.setText("Interview Themes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(interviewerLabel)
                                    .addComponent(locationLabel)
                                    .addComponent(dateLabel))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(locationTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(interviewerTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateFormatedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hasTranslationLabel)
                                .addGap(32, 32, 32)
                                .addComponent(hasTranslationCheckBox))
                            .addComponent(instructionsLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(informantLabel)
                                    .addComponent(titleLabel))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(informantComboBox, 0, 185, Short.MAX_VALUE)
                                    .addComponent(titleTextField))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(theme1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(theme2TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(theme3TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(theme4TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(theme5TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(theme6TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(theme7TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(theme8TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(theme9TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addInterviewButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(summaryLabel)
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addInterviewButton, cancelButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(instructionsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleLabel)
                            .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(theme3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(informantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informantLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(interviewerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(interviewerLabel))
                        .addGap(21, 21, 21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(theme6TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme7TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme8TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(theme9TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(locationLabel))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateFormatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateLabel))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hasTranslationCheckBox)
                            .addComponent(hasTranslationLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(summaryLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addInterviewButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private java.sql.Date getSqlDate(String startDate) throws Exception {
        java.sql.Date sqlStartDate = null;
        if (startDate != null && !startDate.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            java.util.Date date = sdf.parse(startDate);
            sqlStartDate = new Date(date.getTime());
        }
        return sqlStartDate;
    } 
    
    private void addInterviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInterviewButtonActionPerformed
        if (!titleTextField.getText().isEmpty()) {
            Interviews newInterview = new Interviews();
            newInterview.setTitle(titleTextField.getText());
            Informants currentInformant = (Informants)informantComboBox.getSelectedItem();
            newInterview.setInformant(currentInformant);
            newInterview.setInterviewer(interviewerTextField.getText());
            newInterview.setLocation(locationTextField.getText());
            try {
                newInterview.setInterviewdate(getSqlDate(dateFormatedTextField.getText()));
            } catch (Exception ex) {
                Logger.getLogger(AddInterview.class.getName()).log(Level.SEVERE, null, ex);
            }
            newInterview.setTheme1(theme1TextField.getText());
            newInterview.setTheme2(theme2TextField.getText());
            newInterview.setTheme3(theme3TextField.getText());
            newInterview.setTheme4(theme4TextField.getText());
            newInterview.setTheme5(theme5TextField.getText());
            newInterview.setTheme6(theme6TextField.getText());
            newInterview.setTheme7(theme7TextField.getText());
            newInterview.setTheme8(theme8TextField.getText());
            newInterview.setTheme9(theme9TextField.getText());
            newInterview.setSummary(summaryTextArea.getText());
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
            InterviewsJpaController ijc = new InterviewsJpaController(emf);
            ijc.create(newInterview);

            EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
            Query query = entityManager.createNamedQuery("Interviews.findAll");
            List<Interviews> interviewsList = query.getResultList();
            Interviews currentInterview = interviewsList.get(interviewsList.size() - 1);

            boolean hasTranslation = hasTranslationCheckBox.isSelected(); 

            AddParagraph ap = new AddParagraph(currentInformant, currentInterview, hasTranslation);
            ap.setVisible(true);

            this.setVisible(false);
            mainwindow.populateTree();
        }
        else {
            JOptionPane.showMessageDialog(null,"Interview Title is blank");
        }
    }//GEN-LAST:event_addInterviewButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ColloquiumPUEntityManager;
    private javax.swing.JButton addInterviewButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JFormattedTextField dateFormatedTextField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JCheckBox hasTranslationCheckBox;
    private javax.swing.JLabel hasTranslationLabel;
    private javax.swing.JComboBox<String> informantComboBox;
    private javax.swing.JLabel informantLabel;
    private java.util.List<spudrucket.github.io.Colloquium.Informants> informantsList;
    private javax.persistence.Query informantsQuery;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JLabel interviewerLabel;
    private javax.swing.JTextField interviewerTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationTextField;
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
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
