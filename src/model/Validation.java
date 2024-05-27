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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import model.MySQL;

public class Validation extends javax.swing.JFrame {

    public Validation() {

    }

    private static String text = "";
    private static String text1 = "";
    private static String number = "";
    private static String pnnumber = "";
    public static final int PASSWORD_LENGTH = 8;

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
    public boolean is_Valid_Password(JPasswordField pwd) {

        String password = String.valueOf(pwd.getPassword());

        if (password.length() < PASSWORD_LENGTH) {
            return false;
        }

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (is_Numeric(ch)) {
                numCount++;
            } else if (is_Letter(ch)) {
                charCount++;
            } else {
                return false;
            }
        }

        return (charCount >= 2 && numCount >= 2);
    }

    public static boolean is_Letter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }

    public static boolean is_Numeric(char ch) {

        return (ch >= '0' && ch <= '9');
    }

    public boolean phoneNumberValidate(JTextField js) {

        String getText = js.getText();

        if (getText.isEmpty()) {

            inCorrect(js);
            JOptionPane.showMessageDialog(this, "phone Number is Empty", "warning", JOptionPane.WARNING_MESSAGE);
            return true;

        }

        if (!getText.matches("\\d+")) { // not equals number

            JOptionPane.showMessageDialog(this, "don't input charactor input numbers only", "warning", JOptionPane.WARNING_MESSAGE);
            inCorrect(js);
            js.setText(pnnumber);

        } else {
            pnnumber = getText;

        }

        if (getText.length() == 10) {

            correct(js);
            return false;

        } else if (getText.length() > 10) {

            inCorrect(js);

            JOptionPane.showMessageDialog(this, "Phone is Longer than 10 didgits,please input valid phone number", "warning", JOptionPane.WARNING_MESSAGE);

            return true;

        } else if (getText.length() < 10) {

            inCorrect(js);
            JOptionPane.showMessageDialog(this, "Phone is lower than 10 didgits,please input valid phone number", "warning", JOptionPane.WARNING_MESSAGE);
            return true;
        }

        return false;
    }

    public boolean emptyValue(JTextField js, String key) {

        String getText = js.getText();

        if (getText.isEmpty() || getText.equals(key)) {

            inCorrect(js);
            return true;

        }

        correct(js);
        return false;
    }

    public boolean emptyValue(JComboBox js) {

        String get = String.valueOf(js.getSelectedItem());

        if (get.equals(String.valueOf(js.getItemAt(0)))) {
//            return get;
            return true;

        }

        return false;

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

    public String numberValues(JTextField js) {

        String getText = js.getText();

        if (getText.isEmpty()) {

            inCorrect(js);
            return "false";

        }

        if (!getText.matches("\\d+")) { // not equals number
            inCorrect(js);
            js.setText(number);

            JOptionPane.showMessageDialog(null, "don't input charactors | input numbers only", "warning", JOptionPane.WARNING_MESSAGE);

        } else {
            number = getText;
            

        }

        if (true) {

            correct(js);
            return "done";

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
