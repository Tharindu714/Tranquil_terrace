/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author DS
 */
public class test {


private void loadAttendance(String userId) {

        try {

            String query = "SELECT * FROM `work_schedule` "
                    + "INNER JOIN `status` ON"
                    + "`status`.`id`=`work_schedule`.`status_id`"
                    + "WHERE `employee_id`='" + userId + "' ORDER BY `date` DESC ";

            ResultSet rs = MySQL.execute(query);

            DefaultTableModel tableModel = (DefaultTableModel) WorkScheduleTable.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("date"));
                v.add(rs.getString("on_time"));
                v.add(rs.getString("off_time"));

                if (rs.getString("work_schedule.status_id").equals("1")) {
                    v.add("active");
                } else {

                    v.add("inactive");
                }

                tableModel.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}