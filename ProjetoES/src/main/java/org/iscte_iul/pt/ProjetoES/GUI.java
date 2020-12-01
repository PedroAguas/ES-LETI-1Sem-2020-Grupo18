package org.iscte_iul.pt.ProjetoES;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class GUI {
	private JFrame frame;
	private ExcelReader ER;
	private File selectedFile;
	private String path;
	private String[] regras = { "PMI", "IPlasma", "Metricas" };

	public GUI() {
		frame = new JFrame("Read Excel");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setLocation(400, 150);
		configurationFrame();
		frame.setSize(700, 450);
	}

	private void configurationFrame() {

		JPanel panelButton = new JPanel();
		panelButton.setLayout(new GridLayout(1, 3));

		JButton listaRegras = new JButton("Regras");
		listaRegras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {

				JDialog frameRegra = new JDialog(frame, "Parametros Long Method");
				frameRegra.setLayout(new BorderLayout());
				frameRegra.setLocation(550, 200);
				frameRegra.setVisible(true);
				frameRegra.setSize(400, 500);

				JPanel panelCenter = new JPanel();
				panelCenter.setLayout(new GridLayout(4, 1));

				ButtonGroup g1 = new ButtonGroup();
				JRadioButton firstRadio = new JRadioButton("PMD");
				JRadioButton secondRadio = new JRadioButton("IPlasma");
				JRadioButton thirdRadio = new JRadioButton("Long Method");
				JRadioButton fourthRadio = new JRadioButton("Feature Envy");

				// g1 para selecionar so uma opcao
				g1.add(firstRadio);
				g1.add(secondRadio);
				g1.add(thirdRadio);
				g1.add(fourthRadio);

				panelCenter.add(firstRadio);
				panelCenter.add(secondRadio);
				panelCenter.add(thirdRadio);
				panelCenter.add(fourthRadio);

				frameRegra.add(panelCenter, BorderLayout.CENTER);

				JButton check = new JButton("Confirmar");
				check.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent x) {
						if (firstRadio.isSelected()) {
							// PMD chamar a funcao que a joana fizer para dar os resultados certos
						} else if (secondRadio.isSelected()) {
							// IPlasma chamar a funcao que a joana fizer para dar os resultados certos
						} else if (thirdRadio.isSelected()) {
							// Long Method
							JDialog lm = new JDialog(frameRegra, "Parametros Long Method");
							lm.setLayout(new BorderLayout());
							lm.setLocation(600, 250);
							lm.setVisible(true);
							lm.setSize(200, 125);

							JPanel lmPanelButton = new JPanel();
							JPanel lmPanel = new JPanel();
							lmPanel.setLayout(new GridLayout(2, 2));
							JLabel lmLabelLOC = new JLabel("LOC");
							JLabel lmLabelCYCLO = new JLabel("CYCLO");
							JTextField lmTextLOC = new JTextField();
							JTextField lmTextCYCLO = new JTextField();

							lmPanel.add(lmLabelLOC);
							lmPanel.add(lmTextLOC);
							lmPanel.add(lmLabelCYCLO);
							lmPanel.add(lmTextCYCLO);
							lm.add(lmPanel, BorderLayout.NORTH);

							JButton lmCheck = new JButton("Confirmar");
							lmCheck.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent x) {
									// Funcao que a Joana fizer
								}
							});

							lmPanelButton.add(lmCheck);
							lm.add(lmPanelButton, BorderLayout.SOUTH);
						} else {
							// Feature Envy Criar janela para por os parametros
							JDialog fe = new JDialog(frameRegra, "Parametros Long Method");
							fe.setLayout(new BorderLayout());
							fe.setLocation(600, 250);
							fe.setVisible(true);
							fe.setSize(200, 125);

							JPanel fePanelButton = new JPanel();
							JPanel fePanel = new JPanel();
							fePanel.setLayout(new GridLayout(2, 2));
							JLabel feLabelATFD = new JLabel("ATFD");
							JLabel feLabelLAA = new JLabel("LAA");
							JTextField feTextATFD = new JTextField();
							JTextField feTextLAA = new JTextField();

							fePanel.add(feLabelATFD);
							fePanel.add(feTextATFD);
							fePanel.add(feLabelLAA);
							fePanel.add(feTextLAA);
							fe.add(fePanel, BorderLayout.NORTH);

							JButton feCheck = new JButton("Confirmar");
							feCheck.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent x) {
									// Funcao que a Joana fizer
								}
							});

							fePanelButton.add(feCheck);
							fe.add(fePanelButton, BorderLayout.SOUTH);
						}
					}
				});

				JPanel panelSouth = new JPanel();
				panelSouth.setLayout(new GridLayout(1, 1));
				panelSouth.add(check);
				frameRegra.add(panelSouth, BorderLayout.SOUTH);
			}
		});

		
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

					JTable jt = new JTable(ER.getDados(), ER.getColunaInicial());
					JScrollPane excel = new JScrollPane(jt);

					excel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					excel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

					frame.add(excel, BorderLayout.CENTER);
					frame.setVisible(true);
				} else {
					if (returnValue == JFileChooser.CANCEL_OPTION) {
						System.out.println("No File Selected");
					}
				}
			}
		});

		panelButton.add(listaRegras);
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