package MVC.View;

import javax.swing.*;
import java.awt.*;

public class DIYBackgroundPanel extends JPanel {

	DIYBackgroundPanel(){
        this.setBounds(10,0,950,760);
        this.setBackground(Color.darkGray);
        this.setLayout(new GridLayout(8,10) );
    }
}
