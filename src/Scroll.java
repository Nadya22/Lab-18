import javax.swing.*;

public class Scroll extends JScrollPane {

    private final JTextArea text;

    public Scroll(JTextArea text){
        super(text);
        this.text = text;
    }

    public  String getText(){
        return  text.getText();

    }
}
