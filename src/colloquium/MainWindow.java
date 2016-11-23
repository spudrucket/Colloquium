/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloquium;

import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Mark_K
 */
public class MainWindow extends javax.swing.JFrame {
    
    TableColumn idColumn;
    TableColumn textColumn;
    TableColumn transColumn;
    TableColumn tagsColumn;
    Interviews currentInterview;
    

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        jList1.setComponentPopupMenu(jList1PopupMenu);
        resultsTable.setComponentPopupMenu(resultsTablePopupMenu);
        resultsTable.setDefaultRenderer(String.class, new LineWrapCellRenderer());
        
        idColumn = resultsTable.getColumnModel().getColumn(0);
        textColumn = resultsTable.getColumnModel().getColumn(1);
        transColumn = resultsTable.getColumnModel().getColumn(2);
        tagsColumn = resultsTable.getColumnModel().getColumn(3);
        resultsTable.removeColumn(idColumn);
        
        populateTree();
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
        jList1PopupMenu = new javax.swing.JPopupMenu();
        addTagPopupMenuItem = new javax.swing.JMenuItem();
        deletePopupMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        createTagPopupMenuItem = new javax.swing.JMenuItem();
        editTagPopupMenuItem = new javax.swing.JMenuItem();
        resultsTablePopupMenu = new javax.swing.JPopupMenu();
        editParagraphPopupMenuItem = new javax.swing.JMenuItem();
        deleteAllTagsPopupMenuItem = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        informantsButton = new javax.swing.JButton();
        interviewsButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        showTransCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        addInformantMenuItem = new javax.swing.JMenuItem();
        addInterviewMenuItem = new javax.swing.JMenuItem();
        addTagMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        editInformantsMenuItem = new javax.swing.JMenuItem();
        editInterviewsMenuItem = new javax.swing.JMenuItem();
        editParagraphsMenuItem = new javax.swing.JMenuItem();
        editTagsMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        refreshMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        addTagPopupMenuItem.setText("Add Tag");
        addTagPopupMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTagPopupMenuItemActionPerformed(evt);
            }
        });
        jList1PopupMenu.add(addTagPopupMenuItem);

        deletePopupMenuItem.setText("Delete Tag");
        deletePopupMenuItem.setActionCommand("Delete Tag(s)");
        deletePopupMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePopupMenuItemActionPerformed(evt);
            }
        });
        jList1PopupMenu.add(deletePopupMenuItem);
        jList1PopupMenu.add(jSeparator4);

        createTagPopupMenuItem.setText("New Tag");
        createTagPopupMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTagPopupMenuItemActionPerformed(evt);
            }
        });
        jList1PopupMenu.add(createTagPopupMenuItem);

        editTagPopupMenuItem.setText("Edit Tags");
        editTagPopupMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTagPopupMenuItemActionPerformed(evt);
            }
        });
        jList1PopupMenu.add(editTagPopupMenuItem);

        editParagraphPopupMenuItem.setText("Edit Paragraph");
        resultsTablePopupMenu.add(editParagraphPopupMenuItem);

        deleteAllTagsPopupMenuItem.setText("Delete All Tags");
        resultsTablePopupMenu.add(deleteAllTagsPopupMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Colloquium");

        jTree1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setRootVisible(false);
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jTree1);

        resultsTable.setBorder(new javax.swing.border.MatteBorder(null));
        resultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Text", "Translation", "Tags"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultsTable.setInheritsPopupMenu(true);
        resultsTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        resultsTable.getTableHeader().setReorderingAllowed(false);
        resultsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(resultsTable);
        if (resultsTable.getColumnModel().getColumnCount() > 0) {
            resultsTable.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(32769, 50));
        jToolBar1.setMinimumSize(new java.awt.Dimension(800, 50));
        jToolBar1.setPreferredSize(new java.awt.Dimension(1284, 50));

        informantsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/colloquium/person-icon.png"))); // NOI18N
        informantsButton.setToolTipText("Informants");
        informantsButton.setFocusable(false);
        informantsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        informantsButton.setMaximumSize(new java.awt.Dimension(50, 50));
        informantsButton.setMinimumSize(new java.awt.Dimension(50, 50));
        informantsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        informantsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informantsButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(informantsButton);

        interviewsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/colloquium/text_bubble.png"))); // NOI18N
        interviewsButton.setToolTipText("Interviews");
        interviewsButton.setFocusable(false);
        interviewsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        interviewsButton.setMaximumSize(new java.awt.Dimension(50, 50));
        interviewsButton.setMinimumSize(new java.awt.Dimension(50, 50));
        interviewsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        interviewsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interviewsButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(interviewsButton);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/colloquium/tag.png"))); // NOI18N
        jButton1.setToolTipText("Tags");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton1.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        showTransCheckBox.setSelected(true);
        showTransCheckBox.setFocusable(false);
        showTransCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        showTransCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        showTransCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTransCheckBoxActionPerformed(evt);
            }
        });
        jToolBar1.add(showTransCheckBox);

        jLabel1.setText("Show Translation");
        jToolBar1.add(jLabel1);

        jList1.setInheritsPopupMenu(true);

        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tagsList, jList1);
        bindingGroup.addBinding(jListBinding);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jList1);

        jMenu1.setText("File");

        jMenuItem1.setText("New Project");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        addInformantMenuItem.setText("New Informant");
        addInformantMenuItem.setActionCommand("Add Informants");
        addInformantMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInformantMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(addInformantMenuItem);

        addInterviewMenuItem.setText("New Interview");
        addInterviewMenuItem.setToolTipText("");
        addInterviewMenuItem.setActionCommand("Add Interviews");
        addInterviewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInterviewMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(addInterviewMenuItem);

        addTagMenuItem.setText("New Tag");
        addTagMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTagMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(addTagMenuItem);
        jMenu1.add(jSeparator2);

        editInformantsMenuItem.setText("Edit Informants");
        editInformantsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInformantsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(editInformantsMenuItem);

        editInterviewsMenuItem.setText("Edit Interviews");
        editInterviewsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInterviewsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(editInterviewsMenuItem);

        editParagraphsMenuItem.setText("Edit Paragraphs");
        editParagraphsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParagraphsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(editParagraphsMenuItem);

        editTagsMenuItem.setText("Edit Tags");
        editTagsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTagsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(editTagsMenuItem);
        jMenu1.add(jSeparator3);

        refreshMenuItem.setText("Refresh");
        refreshMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(refreshMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private LinkedList getSelectedParagraphs() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        LinkedList<Paragraphs> paragraphsList = new LinkedList();
        int[] rows = resultsTable.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            int currentId = Integer.parseInt(resultsTable.getModel().getValueAt(rows[i], 0).toString());
            Query query = entityManager.createNamedQuery("Paragraphs.findById").setParameter("id", currentId);
            List<Paragraphs> selectedParagraphs = query.getResultList();
            for (Paragraphs p : selectedParagraphs) {
                paragraphsList.add(p);
            }
        }
        return paragraphsList;
    }
    
    private void addParagraphTags() {
        List<Tags> newTagsList;
        if (resultsTable.isColumnSelected(resultsTable.getSelectedColumn())) {
            EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
            DefaultTableModel model = (DefaultTableModel) resultsTable.getModel();
            newTagsList = jList1.getSelectedValuesList();                                    
            LinkedList<Paragraphs> selectedParagraphs = getSelectedParagraphs();
            int[] rows = resultsTable.getSelectedRows();
            int idColumn = resultsTable.getColumnCount();

            int count = 0;
            for (Paragraphs p : selectedParagraphs) {
                TreeSet<String> newTags = new TreeSet();
                String oldTagsString = p.getTags();
                if (!oldTagsString.isEmpty()) {
                   String[] oldTagsArray = oldTagsString.split(" *, *");                        
                   newTags.addAll(Arrays.asList(oldTagsArray));
                }                     
                for (Tags t : newTagsList) {
                    newTags.add(t.toString());
                }
                StringBuilder sb = new StringBuilder();
                for (String s : newTags) {
                    sb.append(s);
                    sb.append(", ");
                }

                p.setTags(sb.toString());
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
                ParagraphsJpaController pjc = new ParagraphsJpaController(emf);
                try {
                    pjc.edit(p);
                } catch (Exception ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                                               
                model.setValueAt(sb.toString(), rows[count], idColumn);
                count++;
            }
        }
    }
    
    private void popTable(Interviews interview) {
        DefaultTableModel model = (DefaultTableModel) resultsTable.getModel();
        model.setRowCount(0);
        
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        Query query = entityManager.createNamedQuery("Paragraphs.findByInterviewnumber").setParameter("interviewnumber", interview);
        List<Paragraphs> paragraphsList = query.getResultList();

        for (Paragraphs p : paragraphsList) {
            int data0 = p.getId();
            String data1 = p.getText();
            String data2 = p.getTrans();
            String data3 = p.getTags();                                  
            Object[] row = {data0, data1, data2, data3};
            model.addRow(row);
        } 
    }
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void addInformantMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInformantMenuItemActionPerformed
        AddInformant ainfo = new AddInformant();
        ainfo.setVisible(true);
    }//GEN-LAST:event_addInformantMenuItemActionPerformed

    private void addInterviewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInterviewMenuItemActionPerformed
        AddInterview aint = new AddInterview();
        aint.setVisible(true);
    }//GEN-LAST:event_addInterviewMenuItemActionPerformed

    private void addTagMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTagMenuItemActionPerformed
        AddTag atag = new AddTag();
        atag.setVisible(true);
    }//GEN-LAST:event_addTagMenuItemActionPerformed

    private void editInformantsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInformantsMenuItemActionPerformed
        ShowInformants sinf = new ShowInformants();
        sinf.setVisible(true);
    }//GEN-LAST:event_editInformantsMenuItemActionPerformed

    private void refreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshMenuItemActionPerformed
        this.setVisible(false);
        MainWindow mw = new MainWindow();
        mw.setVisible(true);
    }//GEN-LAST:event_refreshMenuItemActionPerformed

    private void editInterviewsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInterviewsMenuItemActionPerformed
        ShowInterviews sint = new ShowInterviews();
        sint.setVisible(true);
    }//GEN-LAST:event_editInterviewsMenuItemActionPerformed

    private void editTagsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTagsMenuItemActionPerformed
        ShowTags stag = new ShowTags();
        stag.setVisible(true);
    }//GEN-LAST:event_editTagsMenuItemActionPerformed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        if (node == null)
            return;
        
        if (node.isLeaf()) {
            try {
                currentInterview = (Interviews) node.getUserObject();
                popTable(currentInterview);
            } catch (ClassCastException cce) {
            }
                
        }         
    }//GEN-LAST:event_jTree1ValueChanged

    private void showTransCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTransCheckBoxActionPerformed
        if (showTransCheckBox.isSelected()) {
            resultsTable.addColumn(transColumn);
            resultsTable.moveColumn(2, 1);
        }
        else {
            resultsTable.removeColumn(transColumn);
        }
    }//GEN-LAST:event_showTransCheckBoxActionPerformed

    private void interviewsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interviewsButtonActionPerformed
        ShowInterviews sint = new ShowInterviews();
        sint.setVisible(true);
    }//GEN-LAST:event_interviewsButtonActionPerformed

    private void informantsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informantsButtonActionPerformed
        ShowInformants sinf = new ShowInformants();
        sinf.setVisible(true);
    }//GEN-LAST:event_informantsButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ShowTags stag = new ShowTags();
        stag.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (evt.getClickCount() == 2) {
            addParagraphTags();
        }
        if (evt.getButton() == MouseEvent.BUTTON3) {
            jList1PopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void editParagraphsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParagraphsMenuItemActionPerformed
        ShowParagraphs sp = new ShowParagraphs();
        sp.setVisible(true);
    }//GEN-LAST:event_editParagraphsMenuItemActionPerformed

    private void deletePopupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePopupMenuItemActionPerformed
        List<Tags> newTagsList;
        if (resultsTable.isColumnSelected(resultsTable.getSelectedColumn())) {
            EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
            DefaultTableModel model = (DefaultTableModel) resultsTable.getModel();
            newTagsList = jList1.getSelectedValuesList();                                    
            LinkedList<Paragraphs> selectedParagraphs = getSelectedParagraphs();
            int[] rows = resultsTable.getSelectedRows();
            int idColumn = resultsTable.getColumnCount();
            int count = 0;

            for (Paragraphs p : selectedParagraphs) {
                TreeSet<String> newTags = new TreeSet();
                String oldTagsString = p.getTags();
                if (!oldTagsString.isEmpty()) {
                   String[] oldTagsArray = oldTagsString.split(" *, *");                        
                   newTags.addAll(Arrays.asList(oldTagsArray));
                }                     
                for (Tags t : newTagsList) {
                    newTags.remove(t.toString());
                }
                StringBuilder sb = new StringBuilder();
                for (String s : newTags) {
                    sb.append(s);
                    sb.append(", ");
                }

                p.setTags(sb.toString());
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
                ParagraphsJpaController pjc = new ParagraphsJpaController(emf);
                try {
                    pjc.edit(p);
                } catch (Exception ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                model.setValueAt(sb.toString(), rows[count], idColumn);
                count++;
            }           
        }
    }//GEN-LAST:event_deletePopupMenuItemActionPerformed

    private void addTagPopupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTagPopupMenuItemActionPerformed
        addParagraphTags();
    }//GEN-LAST:event_addTagPopupMenuItemActionPerformed

    private void createTagPopupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTagPopupMenuItemActionPerformed
        AddTag at = new AddTag();
        at.setVisible(true);
    }//GEN-LAST:event_createTagPopupMenuItemActionPerformed

    private void editTagPopupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTagPopupMenuItemActionPerformed
        ShowTags st = new ShowTags();
        st.setVisible(true);
    }//GEN-LAST:event_editTagPopupMenuItemActionPerformed

    private void resultsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultsTableMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            resultsTablePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_resultsTableMouseClicked

    public final void populateTree() {
        try {
            LinkedList list = new LinkedList();
            list.add("Informants");
            EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
            Query query = entityManager.createNamedQuery("Informants.findAll");
            List<Informants> informantsList = query.getResultList();
            for (Informants i : informantsList) {
                Object value[] = {i.getId().toString(), i.getNickname()};
                list.add(value);
            }
            
            Object hierarchy[] = list.toArray();
            DefaultMutableTreeNode root = processHierarchy(hierarchy);

            DefaultTreeModel treeModel = new DefaultTreeModel(root);
            jTree1.setModel(treeModel);
        } catch (Exception e) {
        }
    }
    
    public DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
            
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        Query query = entityManager.createNamedQuery("Informants.findAll");
        List<Informants> informantsList = query.getResultList();

        DefaultMutableTreeNode child, grandchild;
        for (Informants info : informantsList) {
            child = new DefaultMutableTreeNode(info);
            node.add(child);
            Query query2 = entityManager.createNamedQuery("Interviews.findByInformant").setParameter("informant", info);
            List<Interviews> interviewsList = query2.getResultList();
            for (Interviews inter : interviewsList) {    
                grandchild = new DefaultMutableTreeNode(inter);
                child.add(grandchild);                               
            }
        }        
        return (node);
    }
    
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ColloquiumPUEntityManager;
    private javax.swing.JMenuItem addInformantMenuItem;
    private javax.swing.JMenuItem addInterviewMenuItem;
    private javax.swing.JMenuItem addTagMenuItem;
    private javax.swing.JMenuItem addTagPopupMenuItem;
    private javax.swing.JMenuItem createTagPopupMenuItem;
    private javax.swing.JMenuItem deleteAllTagsPopupMenuItem;
    private javax.swing.JMenuItem deletePopupMenuItem;
    private javax.swing.JMenuItem editInformantsMenuItem;
    private javax.swing.JMenuItem editInterviewsMenuItem;
    private javax.swing.JMenuItem editParagraphPopupMenuItem;
    private javax.swing.JMenuItem editParagraphsMenuItem;
    private javax.swing.JMenuItem editTagPopupMenuItem;
    private javax.swing.JMenuItem editTagsMenuItem;
    private javax.swing.JButton informantsButton;
    private javax.swing.JButton interviewsButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Tags> jList1;
    private javax.swing.JPopupMenu jList1PopupMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenuItem refreshMenuItem;
    private javax.swing.JTable resultsTable;
    private javax.swing.JPopupMenu resultsTablePopupMenu;
    private javax.swing.JCheckBox showTransCheckBox;
    private java.util.List<colloquium.Tags> tagsList;
    private javax.persistence.Query tagsQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
