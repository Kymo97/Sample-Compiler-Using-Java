package scanner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class tableClas {
	
	JTable table;
	DefaultTableModel model;
	
	public tableClas() {
		table =new JTable();
	}
	
	public tableClas(int rows,int cols) {
		model =new DefaultTableModel();
		model.setRowCount(rows);
		model.setColumnCount(cols);
		table= new JTable(model);
	}
	
	public void setTitles(String[] Titles) {
		
		for(int i=0;i<this.table.getColumnCount();++i) {
			TableColumn colum1=this.table.getTableHeader().getColumnModel().getColumn(i);
			
			colum1.setHeaderValue(Titles[i]);
		}
		
	}
	
	public void setValues(Object x,int rows,int cols) {	
		this.table.setValueAt(x, rows, cols);
	}
	

}
