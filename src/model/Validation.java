/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import java.sql.ResultSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import model.MySQL;


public class Validation extends javax.swing.JFrame {

    public Validation() {

    }

    private static String text = "";
    private static String text1 = "";
    private static String number = "";

//    public void focusLost(JTextField js) {
//
//        Border defaultBorder
//                = BorderFactory.createCompoundBorder(
//                        BorderFactory.createLineBorder(Color.decode("#CCCCCC")),
//                        BorderFactory.createEmptyBorder(2, 2, 2, 2)
//                );
//
//        js.setBorder(defaultBorder);
//
//    }

    public  String emptyValue(JTextField js, String txt) {

        String getText = js.getText();

        if (getText.isEmpty()) {

            inCorrect(js);
            return "Please Enter " + txt + "";

        }

        correct(js);
        return "done";
    }

    public String emptyValue(JComboBox js,String txt) {

        String get = String.valueOf(js.getSelectedItem());

        if (get.equals(String.valueOf(js.getItemAt(0)))) {
//            return get;
            return "Please Select " + txt + "";

        }

        return "done";

    }

    
//    numbers block , only charaters
    public String valiDateText(JTextField js, String txt) {

        String getText = js.getText();

        if (getText.isEmpty()) {

            inCorrect(js);
            return "Please Enter " + txt + "";

        }

        if (getText.matches(".*\\d.*")) { // not equals Charactor

            JOptionPane.showMessageDialog(this, "don't input numbers", "warning", JOptionPane.WARNING_MESSAGE);
            js.setText(text1);

            inCorrect(js);
            return "" + txt + " Feild is Input Charactors Only";

        } else {
            text1 = getText;
        }
        correct(js);
        return "done";
    }

    public String phoneNumberValidate(JTextField js) {

        String getText = js.getText();

        if (getText.isEmpty()) {

            inCorrect(js);
            return "phone Number is Empty";

        }

        if (!getText.matches("\\d+")) { // not equals number
            inCorrect(js);
            js.setText(number);

//            JOptionPane.showMessageDialog(null, "don't input charactors | input numbers only", "warning", JOptionPane.WARNING_MESSAGE);

        } else {
            number = getText;
            System.out.println(number);

        }

        if (getText.length() == 10) {

            correct(js);
            return "done";

        } else if (getText.length() > 10) {

            inCorrect(js);

            return "Phone is Longer than 10 didgits,please input valid phone number  ";

        } else if (getText.length() < 10) {

            inCorrect(js);
            return "Phone is lower than 10 didgits,please input valid phone number  ";
        }

        return "done";
    }

    public void correct(JTextField js) {
        js.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.green),
                BorderFactory.createEmptyBorder(2, 6, 2, 2)));
    }

    public void inCorrect(JTextField js) {
        js.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.red),
                BorderFactory.createEmptyBorder(2, 6, 2, 2)));
    }

    public String valiDateEmail(JTextField js) {

        String getText = js.getText();

        if (getText.isEmpty()) {

            inCorrect(js);
            return "Please Enter Email";

        } else {

            String charac = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            Pattern pattern = Pattern.compile(charac);
            Matcher match = pattern.matcher(getText);

            if (match.matches()) {

                correct(js);

            } else {

                inCorrect(js);

                return "Invalid Email";
            }
        }

        return "done";

    }

}
