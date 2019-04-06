import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Decryption extends JDialog implements ActionListener, InOut{
	String decry;
	JButton OkBtn;
	JLabel DecryText;
	Decryption(){
		setSize(800,500);
		setModal(true);
		setLayout(null);
		
		
		DecryText = new JLabel();
		OkBtn = new JButton("확인");
		
		DecryText.setBounds(14, 12, 429, 65);
		OkBtn.setBounds(124, 89, 195, 36);
		
		OkBtn.addActionListener(this);
		
		add(DecryText);
		add(OkBtn);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(OkBtn)){
			
		}
		setVisible(false);
	}
	@Override
	public void ScannerText(String text) {
		decry = text;
	}
	@Override
	public String PrintText() {
		return decry;
	}
}
