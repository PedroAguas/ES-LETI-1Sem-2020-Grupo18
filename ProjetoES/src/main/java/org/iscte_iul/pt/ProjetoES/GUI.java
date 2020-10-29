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


		JScrollPane scroll = new JScrollPane(labelImage);
		frame.add (scroll, BorderLayout.CENTER); 


		JPanel panel = new JPanel(new BorderLayout());

		JPanel panelText = new JPanel();
		panelText.setLayout(new GridLayout(2, 1));


		final JTextField textPasta = new JTextField();
		final JTextField textImage = new JTextField();
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


		JButton Procurar = new JButton ("Procurar");
		Procurar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent x){
				try {
					ArrayImg();
					convertArrayImg();
				} catch (IOException e1) {
					e1.printStackTrace();
				}


			}
		});

		panel.add(Procurar, BorderLayout.SOUTH);
		frame.add (panel, BorderLayout.SOUTH);
	}


	public void filterFiles (String pasta){ 
		ArrayInicial = new File(pasta).listFiles(new FileFilter() {
			public boolean accept(File f){ 
				if (f.getAbsolutePath().toLowerCase().endsWith(".png")){
					return true;
				}
				return false;
			}
		});
	}



	public void ArrayImg() throws IOException{
		filterFiles(path);
		for (int i=0; i < ArrayInicial.length; i++){
			ArrayStrings.add(ArrayInicial[i].getName());
			ArrayImg.add(PathToImg(ArrayInicial[i]));
		}
	}

	public void convertArrayImg (){
		for (int i=0; i < ArrayImg.size(); i++){
			try {
				ArrayByte.add(convertToByte(ArrayImg.get(i)));
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
	}






	public byte[] convertToByte (BufferedImage img) throws IOException{
		byte[] aux1;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(img, "png", baos);
		baos.flush();
		aux1 = baos.toByteArray();
		baos.close();
		return aux1;
	}



	public BufferedImage PathToImg (File x) throws IOException{
		BufferedImage img = ImageIO.read(x);
		return img;
	}

	
	
	public static void main(String[] args) {
		new GUI().open();
	}	
		


}