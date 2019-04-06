import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ImageIcon;
public class Main implements ActionListener {
	
	private JFrame frame;
	private JLabel VirtualKeyText;
	private JTextField VirtualKeyField;
	private JLabel PlainText;
	private JTextField PlainField;
	private JTable PasswordTable;
	private JButton DecryptionBtn;
	private JButton EncryptionBtn;
	private JPanel panelIcon;
	private JButton helpIcon;
	private JButton noticIcon;
	private JPanel panelBtn;
	
	public Main() {
		initialize();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 656, 449);
		frame.getContentPane().setLayout(null);
		//가상의 키VirtualKey
		//평문 PlainText
		//암호판 PasswordTable
		//복호화 DecryptionBtn
		//암호화 EncryptionBtn
		panelBtn = new JPanel();
		panelIcon = new JPanel();
		
		panelBtn.setLayout(null);
		panelIcon.setLayout(null);
		
		panelIcon.setBounds(14, 233, 108, 157);
		panelBtn.setBounds(136, 322, 429, 68);
		
		VirtualKeyText = new JLabel("가상의 키");
		PlainText = new JLabel("평문");
		
		VirtualKeyField = new JTextField();
		PlainField = new JTextField();
		
		VirtualKeyField.setColumns(10);
		PlainField.setColumns(10);
		
		PasswordTable = new JTable();
		
		DecryptionBtn = new JButton("복호화");
		EncryptionBtn = new JButton("암호화");
		helpIcon = new JButton();
		noticIcon = new JButton();
		
		noticIcon.setIcon(new ImageIcon("C:\\java_study\\project\\info\\Image\\notic.png"));
		helpIcon.setIcon(new ImageIcon("C:\\java_study\\project\\info\\Image\\help.png"));
		
		VirtualKeyText.setBounds(14, 14, 108, 35);
		PlainText.setBounds(14, 61, 108, 35);
		VirtualKeyField.setBounds(136, 14, 429, 37);
		PlainField.setBounds(136, 61, 429, 37);
		PasswordTable.setBounds(136, 110, 429, 200);
		DecryptionBtn.setBounds(235, 12, 180, 44);
		EncryptionBtn.setBounds(14, 12, 180, 44);
		helpIcon.setBounds(0, 0, 105, 74);
		noticIcon.setBounds(0, 83, 105, 74);
		
		frame.getContentPane().add(VirtualKeyText);
		frame.getContentPane().add(PlainField); 
		frame.getContentPane().add(VirtualKeyField);
		frame.getContentPane().add(PlainText);
		frame.getContentPane().add(PasswordTable);
		frame.getContentPane().add(panelBtn);
		frame.getContentPane().add(panelIcon);
		
		panelBtn.add(DecryptionBtn);
		panelBtn.add(EncryptionBtn);
		panelIcon.add(helpIcon);
		panelIcon.add(noticIcon);
		
		DecryptionBtn.addActionListener(this);
		EncryptionBtn.addActionListener(this);
		helpIcon.addActionListener(this);
		noticIcon.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(DecryptionBtn)) {
			checkJTextField();
		}else if(e.getSource().equals(EncryptionBtn)) {
			checkJTextField();		
		}
		if(e.getSource().equals(helpIcon)) {
			
		}else if(e.getSource().equals(noticIcon)) {
			
		}
	}
	public void checkJTextField() {
		if(PlainField.getText().isEmpty() || VirtualKeyField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "값을 입력해 주세요");
		}
	}
}