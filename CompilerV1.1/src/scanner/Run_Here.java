package scanner;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class Run_Here {

	private JFrame frame;
	private JTable table;
	private Scanner_Op Scanner;
	private Parser Main_Parser;
	ArrayList<String> Errors;
	List<Token> Tokens;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Run_Here window = new Run_Here();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Run_Here()throws Exception {
		initialize();
		Scanner = new Scanner_Op();
		Main_Parser = new Parser();
		Errors= new ArrayList<String>();
		Tokens = new ArrayList<Token>(); 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()throws Exception {
		String []headers= {"Line Number","Token","Type"};
		
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 280, 386);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(303, 0, 280, 386);
		frame.getContentPane().add(scrollPane1);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		

		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 397, 558, 126);
		frame.getContentPane().add(scrollPane_1);
		
		
		
		
		JButton btnToknize = new JButton("Compile");
		btnToknize.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)  {
				textArea.setText(null);
				scrollPane1.setViewportView(null);
				String code=editorPane.getText() ;
				Tokens.clear();
				table = new JTable();
				try {
					String []s=code.split("\n|\r");
					
					Tokens = Scanner.Toknized2(s);
					tableClas ReTable=new tableClas(Tokens.size(),3);
					ReTable.setTitles(headers);
					int row=0,col=0;
					for(Token i : Tokens) {
						ReTable.setValues((Object)i.getLineNumber(), row, col++);
						ReTable.setValues((Object)i.getName(), row, col++);
						ReTable.setValues((Object)i.getType(), row, col++);
						row++;
						col=0;
					}
					scrollPane1.setViewportView(ReTable.table);
					Errors = Main_Parser.Pars(Tokens);
					textArea.append("Error: "+Errors.size());
					if(Errors.size()<=0) {
						textArea.setText("Compiled");
						textArea.setForeground(Color.green);
					}
					else {
					
						for(String i : Errors) {
						textArea.setText(textArea.getText()+"\n"+i);
						}
						textArea.setForeground(Color.red);
					}
					
					
					scrollPane_1.setViewportView(textArea);
					
					//System.out.println(code);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
			}
		});
		
		btnToknize.setBounds(25, 530, 89, 23);
		frame.getContentPane().add(btnToknize);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editorPane.setText(null);
				textArea.setText(null);
				
			}
		});
		btnNewButton.setBounds(124, 530, 89, 23);
		frame.getContentPane().add(btnNewButton);
		

		
		

	}
}
