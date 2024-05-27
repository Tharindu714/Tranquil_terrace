/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package HR;

import com.formdev.flatlaf.IntelliJTheme;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import model.UserBean;
import model.Validation;
import model.foodBean;
import GUI.Dashboard;

/**
 *
 * @author DS
 */
public class FoodItemManagement extends javax.swing.JFrame {

    /**
     * Creates new form FoodItemManagement
     */
    public FoodItemManagement() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        loadFoods();
        loadFoodCategoryCombo();
    }

    public HashMap<String, UserBean> foodMap = new HashMap<>();
    public HashMap<String, String> foodcategory = new HashMap<>();
    public Vector<UserBean> foodVector = new Vector<>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        foodName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        unitPrice = new javax.swing.JTextField();
        UserSignIn1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        category = new javax.swing.JTextField();
        newFoodName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        newFoodPrice = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        newFoodCateegory = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        UserSignIn = new javax.swing.JButton();
        foodsSearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        foodTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setPreferredSize(new java.awt.Dimension(225, 400));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Food Name");

        foodName.setEditable(false);
        foodName.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        foodName.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Category");

        jButton2.setBackground(new java.awt.Color(52, 73, 94));
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update Price");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Price");

        unitPrice.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        unitPrice.setForeground(new java.awt.Color(255, 255, 255));
        unitPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                unitPriceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unitPriceKeyReleased(evt);
            }
        });

        UserSignIn1.setBackground(new java.awt.Color(245, 71, 104));
        UserSignIn1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 13)); // NOI18N
        UserSignIn1.setForeground(new java.awt.Color(255, 255, 255));
        UserSignIn1.setText("Add New Food Item");
        UserSignIn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserSignIn1ActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        category.setEditable(false);
        category.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        category.setForeground(new java.awt.Color(255, 255, 255));

        newFoodName.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        newFoodName.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("New Food Name");

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Select Category");

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Add Price");

        newFoodPrice.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        newFoodPrice.setForeground(new java.awt.Color(255, 255, 255));
        newFoodPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newFoodPriceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newFoodPriceKeyReleased(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Add New Food");

        newFoodCateegory.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        newFoodCateegory.setForeground(java.awt.Color.white);
        newFoodCateegory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select" }));
        newFoodCateegory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newFoodCateegory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFoodCateegoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(category, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addGap(108, 108, 108))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(unitPrice, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(foodName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UserSignIn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(108, 108, 108))
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(newFoodPrice, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(newFoodName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(newFoodCateegory, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel36)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addGap(45, 45, 45)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newFoodCateegory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newFoodPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(UserSignIn1)
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 50));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle-xmark.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANQUIL TERRACE | Food Item Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new java.awt.BorderLayout());

        UserSignIn.setBackground(new java.awt.Color(245, 71, 104));
        UserSignIn.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 13)); // NOI18N
        UserSignIn.setForeground(new java.awt.Color(255, 255, 255));
        UserSignIn.setText("Search");
        UserSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserSignInActionPerformed(evt);
            }
        });

        foodsSearch.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        foodsSearch.setForeground(new java.awt.Color(255, 255, 255));
        foodsSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodsSearchActionPerformed(evt);
            }
        });
        foodsSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                foodsSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addComponent(foodsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(UserSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserSignIn)
                    .addComponent(foodsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        foodTable.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        foodTable.setForeground(new java.awt.Color(255, 255, 255));
        foodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Food Name", "Unit Price", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        foodTable.setSelectionBackground(new java.awt.Color(245, 71, 104));
        foodTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        foodTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foodTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(foodTable);
        if (foodTable.getColumnModel().getColumnCount() > 0) {
            foodTable.getColumnModel().getColumn(0).setResizable(false);
            foodTable.getColumnModel().getColumn(1).setResizable(false);
            foodTable.getColumnModel().getColumn(2).setResizable(false);
            foodTable.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel4, java.awt.BorderLayout.CENTER);
        jPanel4.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadFoodCategoryCombo() {

        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `food_category`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {

                v.add(resultSet.getString("category"));
                foodcategory.put(resultSet.getString("category"), resultSet.getString("id"));

            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            newFoodCateegory.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//load foods
    private void loadFoods() {
        try {

            String query = "SELECT * FROM `food_item`\n"
                    + "INNER JOIN `food_category` ON \n"
                    + "`food_category`.`id`=`food_item`.`food_category_id`\n"
                    + " ORDER BY `food_category_id`";

            ResultSet rs = MySQL.execute(query);

            DefaultTableModel tableModel = (DefaultTableModel) foodTable.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("food_item.id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("price"));
                v.add(rs.getString("category"));

//                foodBean bean=new foodBean();
//                bean.put(rs.getString("food_item.id"));
//
//                userMap.put(rs.getString("employee.id"), bean);
                tableModel.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearFoodtable() {

        foodName.setText("");
        unitPrice.setText("");
        category.setText("");
        foodTable.clearSelection();
        foodsSearch.setText("");
        

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int selectedIndex = foodTable.getSelectedRow();

        if (selectedIndex != -1) {
            try {

                String inputText = unitPrice.getText();
                if (isValidPrice(inputText)) {
                    double price = Double.parseDouble(inputText);

                    try {

                        MySQL.execute("UPDATE `hotel_db`.`food_item` SET `price`='" + price + "' WHERE  `id`='" + foodTable.getValueAt(foodTable.getSelectedRow(), 0) + "'");
                        JOptionPane.showMessageDialog(this, foodName.getText(), "Price Updated Successfully ", JOptionPane.INFORMATION_MESSAGE);
                        loadFoods();
                        clearFoodtable();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Please Enter a Valid Price", "Invalid Price", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed


    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
  this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void foodTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodTableMouseClicked

        int selectedRow = foodTable.getSelectedRow();

        if (evt.getClickCount() == 2 && selectedRow != -1) {

            String employeeId = foodTable.getValueAt(selectedRow, 0).toString();
//            loadData(employeeId);
            String fdName = foodTable.getValueAt(selectedRow, 1).toString();
            String unPrice = foodTable.getValueAt(selectedRow, 2).toString();
            String cat = foodTable.getValueAt(selectedRow, 3).toString();

            foodName.setText(fdName);
            unitPrice.setText(unPrice);
            category.setText(cat);

        }


    }//GEN-LAST:event_foodTableMouseClicked

    private void UserSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserSignInActionPerformed


    }//GEN-LAST:event_UserSignInActionPerformed

    private void UserSignIn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserSignIn1ActionPerformed

        Validation valid = new Validation();
        String price = newFoodPrice.getText();

        boolean validation = true;

        if (valid.emptyValue(newFoodName, "") || newFoodName.getText().length() < 3 || !newFoodName.getText().matches("[a-zA-Z]+")) {
            validation = false;
            JOptionPane.showMessageDialog(null, "Error: Not a valid Food Name.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        }

        if (valid.emptyValue(newFoodCateegory)) {
            JOptionPane.showMessageDialog(null, "Error: Please Select a Food Category.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            validation = false;
        }
        if (!isValidPrice(price)) {
            validation = false;

            JOptionPane.showMessageDialog(this, "Please Enter a Valid Price", "Invalid Price", JOptionPane.ERROR_MESSAGE);
        }

        if (validation) {

            try {

                ResultSet rs = MySQL.execute("SELECT * FROM `food_item` WHERE `name`='" + newFoodName.getText() + "' ");

                if (!rs.next()) {

                    MySQL.execute("INSERT INTO `hotel_db`.`food_item` (`name`, `price`, `food_category_id`) "
                            + "VALUES ('" + newFoodName.getText() + "', '" + newFoodPrice.getText() + "', '" + foodcategory.get(newFoodCateegory.getSelectedItem()) + "');");

                    JOptionPane.showMessageDialog(this, foodName.getText(), "Food Added Successfully", JOptionPane.INFORMATION_MESSAGE);
                    loadFoods();

                } else {
                    JOptionPane.showMessageDialog(this, "This Food Has Already Exists", "Check Food Name", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_UserSignIn1ActionPerformed

    private boolean isValidPrice(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            return false;
        }

        try {
            double value = Double.parseDouble(inputText);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void unitPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unitPriceKeyReleased


    }//GEN-LAST:event_unitPriceKeyReleased

    private void unitPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unitPriceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceKeyPressed

    private void foodsSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodsSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foodsSearchActionPerformed


    private void foodsSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_foodsSearchKeyReleased

        String searchText = foodsSearch.getText();
        if (searchText.length() > 3) {

            try {

                ResultSet rs = MySQL.execute("SELECT * FROM `food_item`"
                        + "INNER JOIN `food_category` ON"
                        + "`food_item`.`food_category_id`=`food_category`.`id`"
                        + " WHERE `name` LIKE '%" + searchText + "%' ORDER BY `category` ");

                DefaultTableModel foodmodel = (DefaultTableModel) foodTable.getModel();
                foodmodel.setRowCount(0);

                while (rs.next()) {

                    Vector v = new Vector();
                    v.add(rs.getString("id"));
                    v.add(rs.getString("name"));
                    v.add(rs.getString("price"));
                    v.add(rs.getString("category"));

                    foodmodel.addRow(v);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (searchText.length() == 3) {
            loadFoods();

        }

    }//GEN-LAST:event_foodsSearchKeyReleased

    private void newFoodPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newFoodPriceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_newFoodPriceKeyPressed

    private void newFoodPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newFoodPriceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_newFoodPriceKeyReleased

    private void newFoodCateegoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFoodCateegoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newFoodCateegoryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        IntelliJTheme.setup(Dashboard.class.getResourceAsStream(
                "/themes/Atom_One_DarkContrast.theme.json"));


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodItemManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UserSignIn;
    private javax.swing.JButton UserSignIn1;
    private javax.swing.JTextField category;
    private javax.swing.JTextField foodName;
    private javax.swing.JTable foodTable;
    private javax.swing.JTextField foodsSearch;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> newFoodCateegory;
    private javax.swing.JTextField newFoodName;
    private javax.swing.JTextField newFoodPrice;
    private javax.swing.JTextField unitPrice;
    // End of variables declaration//GEN-END:variables
}
