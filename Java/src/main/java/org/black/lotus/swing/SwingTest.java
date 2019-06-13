package org.black.lotus.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest {
    public static void main(String args[]) {
        JFrame frame = new JFrame("JSpinner Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SpinnerModel spinnerModel = new SpinnerNumberModel(10, // initial value
                0, // min
                100, // max
                1);//


        JSpinner spinner = new JSpinner(spinnerModel);

        // Disable keyboard edits in the spinner
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        tf.setEditable(true);
        tf.setBackground(Color.white);
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
                tf.setValue(99);
            }
        });

        // The value of the spinner can still be programmatically changed
        spinner.setValue(new Integer(100));
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(e);
            }
        });

        frame.add(spinner, BorderLayout.SOUTH);

        frame.setSize(200, 90);
        frame.setVisible(true);
    }
}
