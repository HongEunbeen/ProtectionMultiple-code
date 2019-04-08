import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class Main implements ActionListener {

	public static String[][] table = new String[5][5];
	private JFrame frame;
	private JLabel VirtualKeyText;
	private JLabel PlainText;
	private JLabel SecurityText;
	private JTextField PlainField;
	private JTextField VirtualKeyField;
	private JTable PasswordTable;
	private DefaultTableModel passtbm;
	private JButton DecryptionBtn;
	private JButton EncryptionBtn;
	private JPanel panelIcon;
	private JButton helpIcon;
	private JButton noticIcon;
	private JPanel panelBtn;
	private JButton KeyBtn;
	private JTextField SecurityField;
	private String[] column = {"1","2","3","4","5"};
	DefaultTableModel model;
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
		frame.setBounds(100, 100, 650, 560);
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
		panelBtn.setBounds(136, 418, 380, 68);
		
		VirtualKeyText = new JLabel("가상의 키");
		PlainText = new JLabel("평문");
		SecurityText = new JLabel("암호문");
		
		VirtualKeyField = new JTextField();
		PlainField = new JTextField();
		SecurityField = new JTextField();
		
		SecurityField.setColumns(10);
		VirtualKeyField.setColumns(10);
		PlainField.setColumns(10);
		
		model = new DefaultTableModel(table, column);
		PasswordTable = new JTable(model);
		PasswordTable.setRowHeight(40);
		PasswordTable.getTableHeader().setReorderingAllowed(false);    
		
		KeyBtn = new JButton("암호표");
		DecryptionBtn = new JButton("복호화");
		EncryptionBtn = new JButton("암호화");
		helpIcon = new JButton();
		noticIcon = new JButton();
		
		KeyBtn.addActionListener(this);
		DecryptionBtn.addActionListener(this);
		EncryptionBtn.addActionListener(this);
		helpIcon.addActionListener(this);
		noticIcon.addActionListener(this);
		
		
		noticIcon.setIcon(new ImageIcon("Image\\notic.png"));
		helpIcon.setIcon(new ImageIcon("Image\\help.png"));
		
		
		SecurityText.setBounds(14, 128, 108, 35);
		SecurityField.setBounds(136, 129, 380, 37);
		VirtualKeyText.setBounds(14, 14, 108, 35);
		PlainText.setBounds(14, 81, 108, 35);
		VirtualKeyField.setBounds(136, 14, 380, 37);
		PlainField.setBounds(136, 80, 380, 37);
		PasswordTable.setBounds(136, 190, 380, 200);
		DecryptionBtn.setBounds(195, 12, 171, 44);
		EncryptionBtn.setBounds(14, 12, 171, 44);
		helpIcon.setBounds(0, 0, 105, 74);
		noticIcon.setBounds(0, 83, 105, 74);
		KeyBtn.setBounds(530, 14, 94, 35);
		
		frame.getContentPane().add(SecurityField);
		frame.getContentPane().add(VirtualKeyText);
		frame.getContentPane().add(PlainField); 
		frame.getContentPane().add(VirtualKeyField);
		frame.getContentPane().add(PlainText);
		frame.getContentPane().add(PasswordTable);
		frame.getContentPane().add(panelBtn);
		frame.getContentPane().add(panelIcon);
		frame.getContentPane().add(KeyBtn);
		frame.getContentPane().add(SecurityText);
		
		panelBtn.add(DecryptionBtn);
		panelBtn.add(EncryptionBtn);
		panelIcon.add(helpIcon);
		panelIcon.add(noticIcon);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(DecryptionBtn)) {
			checkJTextField();//복호화
		}else if(e.getSource().equals(EncryptionBtn)) {
			checkJTextField();//암호화
		}else if(e.getSource().equals(KeyBtn)) {
			checkJTextField();	
			setTableKey();
		}
		if(e.getSource().equals(helpIcon)) {
			
		}else if(e.getSource().equals(noticIcon)) {
			
		}
	}
	public void checkJTextField() {
		if(VirtualKeyField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "키를 입력해 주세요!!");
			return;
		}else {
		}
	}
	public void setTableKey() {
		VirtyualKeyC virc = new VirtyualKeyC(VirtualKeyField.getText());
		table = virc.setTable();
		model = new DefaultTableModel(table, column);
		PasswordTable.setModel(model);  
	}
}