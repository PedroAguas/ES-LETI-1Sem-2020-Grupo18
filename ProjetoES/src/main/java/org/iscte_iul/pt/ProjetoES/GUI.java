package org.iscte_iul.pt.ProjetoES;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;


public class GUI {
	private JFrame frame;
	private File selectedFile;
	private File selectedImg;
	private File[] ArrayInicial;
	private ArrayList<BufferedImage> ArrayImg = new ArrayList<>();
	private String path;
	private ArrayList<String> ArrayStrings = new ArrayList<>(); 
	private ArrayList<byte[]> ArrayByte = new ArrayList<byte[]>(); 
	@SuppressWarnings("rawtypes")
	private DefaultListModel model = new DefaultListModel<String>();
	
	
	

	public GUI(){
		frame = new JFrame ("Find Images");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
		frame.setLayout(new BorderLayout());
		configurationFrame();
		frame.setSize(700, 450);
		   
	}	

	public void open(){
		frame.setVisible(true);
	}

	
	
	private void configurationFrame(){

		ArrayList<String> listaWorkers = new ArrayList<>();
		listaWorkers.add("Procura normal");
		//		listaWorkers.add("tarefa2");
		//		listaWorkers.add("tarefa3");
		//		listaWorkers.add("tarefa4");
		//imagens.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		JList<String> tarefas = new JList(listaWorkers.toArray());
		frame.add (tarefas, BorderLayout.WEST); 

		final JList<String> imagens = new JList<String>(model);
		final JLabel labelImage = new JLabel();
		imagens.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()){
					System.out.println(imagens.getSelectedIndex());
					int i=imagens.getSelectedIndex();

					System.out.println("Index no Array " + i);
					BufferedImage b=ArrayImg.get(i);
					System.out.println("BufferedImage " + b);

					ImageIcon c = new ImageIcon(b);
					labelImage.setIcon(c);
				}
			}
		});



		frame.add (imagens, BorderLayout.EAST); 

	//Parte onde o excel vai ficar
		 TableModel data = null;
			TableColumnModel column = null;
			JTable jt=new JTable(data,column);    
			 jt.setBounds(30,40,200,300);     
		JTextArea textArea = new JTextArea(20, 20);  
		JScrollPane scrollableTextArea = new JScrollPane(jt);  

		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  

		frame.getContentPane().add(scrollableTextArea);  

		JPanel panel = new JPanel(new BorderLayout());

		JPanel panelText = new JPanel();
		panelText.setLayout(new GridLayout(2, 1));

	//Fim do ScrollPane 
		
		
		
		JTextField textPasta = new JTextField();
		JTextField textImage = new JTextField();

	

		
		panelText.add (textPasta);
		panelText.add (textImage);

		panel.add (panelText, BorderLayout.CENTER);


		JPanel panelButton = new JPanel();
		panelButton.setLayout(new GridLayout(2, 1));

		JButton Pasta = new JButton ("Pasta");

		Pasta.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent x) {
				JFileChooser jfc = new JFileChooser(".");
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnValue = jfc.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = jfc.getSelectedFile();
					textPasta.setText(selectedFile.getAbsolutePath());
					path = selectedFile.getAbsolutePath();
				}else{ 
					if (returnValue == JFileChooser.CANCEL_OPTION){
						System.out.println("No File Selected");
					}
				}
			}
		});


		JButton Imagem = new JButton ("Imagem");
		Imagem.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent x){
				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jgp", "gif", "png");
				jfc.addChoosableFileFilter(filter);
				int returnValue = jfc.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION){
					selectedImg = jfc.getSelectedFile();
					textImage.setText(selectedImg.getName());
				}else if (returnValue == JFileChooser.CANCEL_OPTION){
					System.out.println("No File Selected");
				}
			}
		});

		panelButton.add(Pasta);
		panelButton.add(Imagem);

		panel.add (panelButton, BorderLayout.EAST);
	}

/*
		JButton Procurar = new JButton ("Procurar");
		Procurar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent x){
				//try {
					//ArrayImg();
					//convertArrayImg();
				//} catch (IOException e1) {
					//e1.printStackTrace();
				//}


		//	}
		//S});

		panel.add(Procurar, BorderLayout.SOUTH);
		frame.add (panel, BorderLayout.SOUTH);
	}
		*/
	



	public static void main (String[] args) {
			new GUI().open();

	}
	
}

