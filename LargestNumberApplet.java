import java.awt.*;
import java.awt.event.*;

public class LargestNumberApplet extends java.applet.Applet implements ActionListener {
    TextField num1Field, num2Field, num3Field;
    Label resultLabel;
    Button findButton;

    public void init() {
        num1Field = new TextField(10);
        num2Field = new TextField(10);
        num3Field = new TextField(10);
        resultLabel = new Label("Result will be displayed here");
        findButton = new Button("Find Largest");

        add(new Label("Enter three numbers:"));
        add(num1Field);
        add(num2Field);
        add(num3Field);
        add(findButton);
        add(resultLabel);

        findButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        int num1 = Integer.parseInt(num1Field.getText());
        int num2 = Integer.parseInt(num2Field.getText());
        int num3 = Integer.parseInt(num3Field.getText());

        int largest = Math.max(Math.max(num1, num2), num3);

        resultLabel.setText("The largest number is: " + largest);
    }
}
