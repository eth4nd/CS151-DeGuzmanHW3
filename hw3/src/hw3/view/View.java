package hw3.view;

import hw3.controller.Message;
import hw3.controller.AddColorMessage;
import hw3.controller.ResetColorMessage;
import hw3.Bars;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

import static java.lang.Integer.parseInt;


public class View extends JFrame{
    BlockingQueue<Message> queue;

    JTextField redTextField;
    JTextField greenTextField;
    JTextField blueTextField;
    JButton updateButton;
    JButton resetButton;

    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;

    Bars typeBars;

    public View(BlockingQueue<Message> queue, int red, int green, int blue)
    {
        this.queue = queue;
        typeBars = new Bars(red, green, blue);

        this.redLabel = new JLabel(String.valueOf(red));
        this.greenLabel = new JLabel(String.valueOf(green));
        this.blueLabel = new JLabel(String.valueOf(blue));

        this.redTextField = new JTextField(10);
        this.greenTextField = new JTextField(10);
        this.blueTextField = new JTextField(10);

        this.updateButton = new JButton("update");
        this.resetButton = new JButton("reset");

        updateButton.addActionListener(e -> {
            int redValue = parseInt(redTextField.getText());
            int greenValue = parseInt(greenTextField.getText());
            int blueValue = parseInt(blueTextField.getText());
            try {
                Message msg = new AddColorMessage(redValue, greenValue, blueValue);
                queue.put(msg);
            } catch (InterruptedException exception) {

            }
        });

        resetButton.addActionListener(e -> {
            int redValue = 0;
            int greenValue = 0;
            int blueValue = 0;
            try {
                Message msg = new AddColorMessage(redValue, greenValue, blueValue);
                queue.put(msg);
            }catch (InterruptedException exception) {

            }
        });

        this.add(redLabel);
        this.add(greenLabel);
        this.add(blueLabel);
        this.add(redTextField);
        this.add(greenTextField);
        this.add(blueTextField);
        this.add(updateButton);
        this.add(resetButton);
        this.add(typeBars);

        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateColorsInView(int red, int green, int blue)
    {
        this.redLabel.setText(String.valueOf(red));
        this.typeBars.updateValues(red, green, blue);
        this.typeBars.repaint();
        this.greenLabel.setText(String.valueOf(green));
        this.blueLabel.setText(String.valueOf(blue));
    }

    public void resetColorsInView(int red, int green, int blue)
    {
        this.redLabel.setText("0");
        this.greenLabel.setText("0");
        this.blueLabel.setText("0");
    }

}
