package org.iscte_iul.pt.ProjetoES;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class GUI {
	private JFrame frame;
	private ExcelReader ER;
	private File selectedFile;
	private String path;

	public GUI() {
		frame = new JFrame("Read Excel");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		configurationFrame();
		frame.setSize(700, 450);
	}

	private void configurationFrame() {

		JPanel panelButton = new JPanel();
		panelButton.setLayout(new GridLayout(1, 2));
		
		JButton Excel = new JButton("Excel");
		Excel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent x) {
				JFileChooser jfc = new JFileChooser(".");
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnValue = jfc.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = jfc.getSelectedFile();
					path = selectedFile.getAbsolutePath();
					try {
						ER = new ExcelReader(path);
					} catch (InvalidFormatException | IOException e) {
						e.printStackTrace();
					}
					
					System.out.println(ER.getDados());
					JTable jt = new JTable(ER.getDados(), ER.getColuna());

					JScrollPane excel = new JScrollPane(jt);
						
					excel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					excel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					
					
					frame.add(excel, BorderLayout.CENTER);
				} else {
					if (returnValue == JFileChooser.CANCEL_OPTION) {
						System.out.println("No File Selected");
					}
				}
			}
		});
		
		
		JButton Defeitos = new JButton("Defeitos");
		panelButton.add(Defeitos);
		panelButton.add(Excel);
		frame.add(panelButton, BorderLayout.SOUTH);
		
	}

	public void open() {
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI().open();
	}
}