/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloquium;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mark_K
 */
public class AddInformant extends javax.swing.JFrame {

    /**
     * Creates new form AddInformant
     */
    public AddInformant() {
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

        firstNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameTextField = new javax.swing.JTextField();
        nickNameLabel = new javax.swing.JLabel();
        nickNameTextField = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        ageLabel = new javax.swing.JLabel();
        ageSpinner = new javax.swing.JSpinner();
        birthPlaceLabel = new javax.swing.JLabel();
        birthPlaceTextField = new javax.swing.JTextField();
        residenceLabel = new javax.swing.JLabel();
        residenceTextField = new javax.swing.JTextField();
        primaryLangLabel = new javax.swing.JLabel();
        primaryLangTextField = new javax.swing.JTextField();
        secondaryLangLabel = new javax.swing.JLabel();
        secondaryLangTextField = new javax.swing.JTextField();
        tribeLabel = new javax.swing.JLabel();
        tribeTextField = new javax.swing.JTextField();
        clanLabel = new javax.swing.JLabel();
        clanTextField = new javax.swing.JTextField();
        marriageLabel = new javax.swing.JLabel();
        marriageComboBox = new javax.swing.JComboBox<>();
        numberOfChildrenLabel = new javax.swing.JLabel();
        numberOfChildrenSpinner = new javax.swing.JSpinner();
        economicLabel = new javax.swing.JLabel();
        economicTextField = new javax.swing.JTextField();
        professionLabel = new javax.swing.JLabel();
        professionTextField = new javax.swing.JTextField();
        educationLabel = new javax.swing.JLabel();
        educationTextField = new javax.swing.JTextField();
        religionLabel = new javax.swing.JLabel();
        religionTextField = new javax.swing.JTextField();
        addInformantButton = new javax.swing.JButton();
        other1Label = new javax.swing.JLabel();
        other1TextField = new javax.swing.JTextField();
        other2Label = new javax.swing.JLabel();
        other2TextField = new javax.swing.JTextField();
        other3Label = new javax.swing.JLabel();
        other3TextField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        instructionsLabel = new javax.swing.JLabel();
        other3Label1 = new javax.swing.JLabel();
        other4TextField = new javax.swing.JTextField();
        other3Label2 = new javax.swing.JLabel();
        other5TextField = new javax.swing.JTextField();
        other3Label3 = new javax.swing.JLabel();
        other6TextField = new javax.swing.JTextField();
        other3Label4 = new javax.swing.JLabel();
        other7TextField = new javax.swing.JTextField();
        other3Label5 = new javax.swing.JLabel();
        other8TextField = new javax.swing.JTextField();
        other3Label6 = new javax.swing.JLabel();
        other9TextField = new javax.swing.JTextField();

        setTitle("Add New Informant");
        setPreferredSize(new java.awt.Dimension(800, 600));

        firstNameLabel.setText("First Name:");

        firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextFieldActionPerformed(evt);
            }
        });

        surnameLabel.setText("Last Name:");

        surnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTextFieldActionPerformed(evt);
            }
        });

        nickNameLabel.setText("Nick Name*:");

        genderLabel.setText("Gender:");

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Male", "Female" }));
        genderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboBoxActionPerformed(evt);
            }
        });

        ageLabel.setText("Age:");

        birthPlaceLabel.setText("Birth Place:");

        residenceLabel.setText("Residence:");

        primaryLangLabel.setText("1st Langage:");

        secondaryLangLabel.setText("2nd Language:");

        tribeLabel.setText("Tribe:");

        clanLabel.setText("Clan:");

        marriageLabel.setText("Marital Status:");

        marriageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Single", "Married", "Divorced" }));
        marriageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marriageComboBoxActionPerformed(evt);
            }
        });

        numberOfChildrenLabel.setText("# of Children:");

        numberOfChildrenSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        economicLabel.setText("Economic Status:");

        professionLabel.setText("Profession:");

        educationLabel.setText("Edulcation:");

        religionLabel.setText("Religion:");

        addInformantButton.setText("Add Informant");
        addInformantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInformantButtonActionPerformed(evt);
            }
        });

        other1Label.setText("Other 1:");

        other2Label.setText("Other 2:");

        other3Label.setText("Other 3:");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        instructionsLabel.setText("*Nick Name is a required field and must be unique.");

        other3Label1.setText("Other 4:");

        other3Label2.setText("Other 5:");

        other3Label3.setText("Other 6:");

        other3Label4.setText("Other 7:");

        other3Label5.setText("Other 8:");

        other3Label6.setText("Other 9:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(primaryLangLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(primaryLangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(birthPlaceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(residenceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(birthPlaceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(residenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(ageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(117, 117, 117)
                                .addComponent(numberOfChildrenSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameLabel)
                                    .addComponent(genderLabel)
                                    .addComponent(nickNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nickNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(marriageLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(marriageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(clanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tribeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(clanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tribeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(numberOfChildrenLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(other3Label1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(other4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(secondaryLangLabel)
                                            .addComponent(other2Label))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(secondaryLangTextField)
                                            .addComponent(other2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(other3Label3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(other6TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(other3Label5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(other8TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(economicLabel)
                                            .addComponent(professionLabel)
                                            .addComponent(educationLabel)
                                            .addComponent(religionLabel)
                                            .addComponent(other1Label)
                                            .addComponent(other3Label))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(religionTextField)
                                            .addComponent(educationTextField)
                                            .addComponent(professionTextField)
                                            .addComponent(economicTextField)
                                            .addComponent(other1TextField)
                                            .addComponent(other3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(other3Label6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(other9TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(other3Label2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(other5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(other3Label4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(other7TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(addInformantButton)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(instructionsLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(instructionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tribeLabel)
                            .addComponent(tribeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nickNameLabel)
                            .addComponent(nickNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(clanLabel)
                                    .addComponent(clanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(marriageLabel)
                                    .addComponent(marriageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderLabel)
                                    .addComponent(numberOfChildrenSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addComponent(economicTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(professionLabel)
                                    .addComponent(professionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(educationLabel)
                                    .addComponent(educationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(religionLabel)
                                    .addComponent(religionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firstNameLabel)
                                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(surnameLabel)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numberOfChildrenLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ageLabel)
                            .addComponent(economicLabel)
                            .addComponent(ageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthPlaceLabel)
                            .addComponent(birthPlaceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(residenceLabel)
                            .addComponent(residenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(primaryLangLabel)
                            .addComponent(primaryLangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secondaryLangLabel)
                    .addComponent(secondaryLangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(other1Label)
                    .addComponent(other1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(other2Label)
                    .addComponent(other2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(other3Label)
                    .addComponent(other3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(other3Label1)
                    .addComponent(other4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(other3Label2)
                    .addComponent(other5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(other6TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(other3Label4)
                        .addComponent(other7TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(other3Label3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(other3Label5)
                    .addComponent(other8TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(other3Label6)
                    .addComponent(other9TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addInformantButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {firstNameTextField, surnameTextField});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private void surnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameTextFieldActionPerformed

    private void genderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboBoxActionPerformed

    private void addInformantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInformantButtonActionPerformed
        Informants newInformant = new Informants();
        newInformant.setFirstname(firstNameTextField.getText());
        newInformant.setSurname(surnameTextField.getText());
        newInformant.setNickname(nickNameTextField.getText());
        newInformant.setGender((String) genderComboBox.getSelectedItem());
        newInformant.setAge((Integer) ageSpinner.getValue());
        newInformant.setBirthplace(birthPlaceTextField.getText());
        newInformant.setResidence(residenceTextField.getText());
        newInformant.setPrimarylang(primaryLangTextField.getText());
        newInformant.setSecondarylang(secondaryLangTextField.getText());
        newInformant.setTribe(tribeTextField.getText());
        newInformant.setClan(clanTextField.getText());
        newInformant.setMarriage((String) marriageComboBox.getSelectedItem());
        newInformant.setNumberofchildren((Integer) numberOfChildrenSpinner.getValue());
        newInformant.setEconomic(economicTextField.getText());
        newInformant.setProfession(professionTextField.getText());
        newInformant.setEducation(educationTextField.getText());
        newInformant.setReligion(religionTextField.getText());
        newInformant.setOther1(other1TextField.getText());
        newInformant.setOther2(other2TextField.getText());
        newInformant.setOther3(other3TextField.getText());
        newInformant.setOther4(other4TextField.getText());
        newInformant.setOther5(other5TextField.getText());
        newInformant.setOther6(other6TextField.getText());
        newInformant.setOther7(other7TextField.getText());
        newInformant.setOther8(other8TextField.getText());
        newInformant.setOther9(other9TextField.getText());
             
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
        InformantsJpaController ijc = new InformantsJpaController(emf);
        ijc.create(newInformant);
       
        this.setVisible(false);
    }//GEN-LAST:event_addInformantButtonActionPerformed

    private void marriageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marriageComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marriageComboBoxActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddInformant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddInformant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddInformant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddInformant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddInformant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInformantButton;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JSpinner ageSpinner;
    private javax.swing.JLabel birthPlaceLabel;
    private javax.swing.JTextField birthPlaceTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel clanLabel;
    private javax.swing.JTextField clanTextField;
    private javax.swing.JLabel economicLabel;
    private javax.swing.JTextField economicTextField;
    private javax.swing.JLabel educationLabel;
    private javax.swing.JTextField educationTextField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JComboBox<String> marriageComboBox;
    private javax.swing.JLabel marriageLabel;
    private javax.swing.JLabel nickNameLabel;
    private javax.swing.JTextField nickNameTextField;
    private javax.swing.JLabel numberOfChildrenLabel;
    private javax.swing.JSpinner numberOfChildrenSpinner;
    private javax.swing.JLabel other1Label;
    private javax.swing.JTextField other1TextField;
    private javax.swing.JLabel other2Label;
    private javax.swing.JTextField other2TextField;
    private javax.swing.JLabel other3Label;
    private javax.swing.JLabel other3Label1;
    private javax.swing.JLabel other3Label2;
    private javax.swing.JLabel other3Label3;
    private javax.swing.JLabel other3Label4;
    private javax.swing.JLabel other3Label5;
    private javax.swing.JLabel other3Label6;
    private javax.swing.JTextField other3TextField;
    private javax.swing.JTextField other4TextField;
    private javax.swing.JTextField other5TextField;
    private javax.swing.JTextField other6TextField;
    private javax.swing.JTextField other7TextField;
    private javax.swing.JTextField other8TextField;
    private javax.swing.JTextField other9TextField;
    private javax.swing.JLabel primaryLangLabel;
    private javax.swing.JTextField primaryLangTextField;
    private javax.swing.JLabel professionLabel;
    private javax.swing.JTextField professionTextField;
    private javax.swing.JLabel religionLabel;
    private javax.swing.JTextField religionTextField;
    private javax.swing.JLabel residenceLabel;
    private javax.swing.JTextField residenceTextField;
    private javax.swing.JLabel secondaryLangLabel;
    private javax.swing.JTextField secondaryLangTextField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTextField;
    private javax.swing.JLabel tribeLabel;
    private javax.swing.JTextField tribeTextField;
    // End of variables declaration//GEN-END:variables
}
