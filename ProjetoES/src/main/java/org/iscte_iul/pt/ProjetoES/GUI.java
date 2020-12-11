package org.iscte_iul.pt.ProjetoES;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class GUI {
	private JFrame frame;
	private ExcelReader ER;
	private Defeitos def;
	private Defeitos_Iplasma defI;
	private File selectedFile;
	private String path;
	private JScrollPane excel;
	private JTextField locEditorLogic;
	private JTextField locEditorNumber;
	private JTextField cycloEditorLogic;
	private JTextField cycloEditorNumber;
	private JTextField editorAndOr;
	private JTextField ferramenta;

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

				JDialog frameRegra = new JDialog(frame, "Escolher metrica");
				frameRegra.setLayout(new BorderLayout());
				frameRegra.setLocation(550, 200);
				frameRegra.setVisible(true);
				frameRegra.setSize(400, 500);

				JPanel panelCenter = new JPanel();
				panelCenter.setLayout(new GridLayout(5, 1));

				ButtonGroup g1 = new ButtonGroup();
				JRadioButton firstRadio = new JRadioButton("PMD");
				JRadioButton secondRadio = new JRadioButton("IPlasma");
				JRadioButton thirdRadio = new JRadioButton("Long Method");
				JRadioButton fourthRadio = new JRadioButton("Feature Envy");
				JRadioButton fifthRadio = new JRadioButton("Regra Personalizada");

				// g1 para selecionar so uma opcao
				g1.add(firstRadio);
				g1.add(secondRadio);
				g1.add(thirdRadio);
				g1.add(fourthRadio);
				g1.add(fifthRadio);

				panelCenter.add(firstRadio);
				panelCenter.add(secondRadio);
				panelCenter.add(thirdRadio);
				panelCenter.add(fourthRadio);
				panelCenter.add(fifthRadio);

				frameRegra.add(panelCenter, BorderLayout.CENTER);

				JButton check = new JButton("Confirmar");
				check.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent x) {
						if (firstRadio.isSelected()) {
							frame.remove(excel);
							frameRegra.dispose();

							def = new Defeitos(ER.getDados());
							def.defeitos();

							JPanel pmdPanel = new JPanel();
							pmdPanel.setLayout(new GridLayout(1, 2));

							JTable pmdTable = new JTable(def.getresultados(), def.getheader());
							pmdTable.setEnabled(false);

							JScrollPane table = new JScrollPane(pmdTable);

							frame.add(table);
							frame.setVisible(true);

						} else if (secondRadio.isSelected()) {
							frame.remove(excel);
							frameRegra.dispose();

							defI = new Defeitos_Iplasma(ER.getDados());
							defI.defeitos();

							JPanel pmdPanel = new JPanel();
							pmdPanel.setLayout(new GridLayout(1, 2));

							JTable pmdTable = new JTable(defI.getresultados(), defI.getheader());
							pmdTable.setEnabled(false);

							JScrollPane table = new JScrollPane(pmdTable);

							frame.add(table);
							frame.setVisible(true);

						} else if (thirdRadio.isSelected()) {
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
									frame.remove(excel);
									frameRegra.dispose();
									lm.dispose();

									JPanel lmPanelFinal = new JPanel();
									lmPanelFinal.setLayout(new GridLayout(1, 1));

									def = new Defeitos(ER.getDados());
									def.defeitos();
									JTable DefLm = new JTable(def.getresultados(), def.getheader());
									DefLm.setEnabled(false);

									JScrollPane tableLM = new JScrollPane(DefLm);

									isLongMethod pmetodo = new isLongMethod(ER.getDados(), lmTextLOC.getText(),
											lmTextCYCLO.getText());
									JList<String> listLM = new JList<String>(tamanhoVetorCerto(pmetodo.getdados()));
									JScrollPane listaLMFinal = new JScrollPane(listLM);
									listaLMFinal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
									listaLMFinal.setWheelScrollingEnabled(true);

									JSplitPane splitLM = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listaLMFinal,
											tableLM);
									splitLM.setDividerLocation(100);
									splitLM.setVisible(true);

									frame.add(splitLM, BorderLayout.CENTER);
									frame.setVisible(true);
								}

							});

							lmPanelButton.add(lmCheck);
							lm.add(lmPanelButton, BorderLayout.SOUTH);
						} else if (fourthRadio.isSelected()) {
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
									frame.remove(excel);
									frameRegra.dispose();
									fe.dispose();

									def = new Defeitos(ER.getDados());
									def.defeitos();

									JTable DefFe = new JTable(def.getresultados(), def.getheader());
									DefFe.setEnabled(false);
									JScrollPane tableFE = new JScrollPane(DefFe);

									isFeatureEnvy smetodo = new isFeatureEnvy(ER.getDados(), feTextATFD.getText(),
											feTextLAA.getText());
									JList<String> listFE = new JList<String>(tamanhoVetorCerto(smetodo.getdados()));
									JScrollPane listaFEFinal = new JScrollPane(listFE);
									listaFEFinal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

									JSplitPane splitFE = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listaFEFinal,
											tableFE);
									splitFE.setDividerLocation(100);
									splitFE.setVisible(true);

									frame.add(splitFE, BorderLayout.CENTER);
									frame.setVisible(true);
								}
							});

							fePanelButton.add(feCheck);
							fe.add(fePanelButton, BorderLayout.SOUTH);
						} else {

							frame.remove(excel);
							frameRegra.dispose();

							JDialog pr = new JDialog(frameRegra, "Personalizar Regras");
							pr.setLayout(new BorderLayout());
							pr.setLocation(600, 250);
							pr.setVisible(true);
							pr.setSize(200, 125);

							JPanel fifthpanel = new JPanel(new GridLayout(3, 1));
							ButtonGroup g2 = new ButtonGroup();
							JRadioButton longMethodPR = new JRadioButton("Long Method");
							JRadioButton featureEnvyPR = new JRadioButton("Feature Envy");

							g2.add(longMethodPR);
							g2.add(featureEnvyPR);

							fifthpanel.add(longMethodPR);
							fifthpanel.add(featureEnvyPR);

							pr.add(fifthpanel, BorderLayout.CENTER);

							JButton prCheck = new JButton("Confirmar Code Smell");
							prCheck.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent x) {
									if (longMethodPR.isSelected()) {
										frame.remove(excel);
										frameRegra.dispose();
										pr.dispose();

										JDialog prDefineParametros = new JDialog(frameRegra, "Personalizar Regras");
										prDefineParametros.setLayout(new GridLayout(5, 1));
										prDefineParametros.setLocation(600, 250);
										prDefineParametros.setVisible(true);
										prDefineParametros.setSize(300, 175);

										JPanel panelLMRP1linha = new JPanel(new GridLayout(1, 3));
										JPanel panelLMRP2linha = new JPanel(new GridLayout(1, 2));
										JPanel panelLMRP3linha = new JPanel(new GridLayout(1, 3));
										JPanel panelLMRP4linha = new JPanel(new GridLayout(1, 2));
										JPanel panelLMRP5linha = new JPanel(new GridLayout(1, 1));

										JLabel labelLOC = new JLabel("LOC (Ex: < 31");
										locEditorLogic = new JTextField();
										locEditorNumber = new JTextField();

										JLabel editorLabel = new JLabel("Escreva and ou or");
										editorAndOr = new JTextField();

										JLabel labelCYCLO = new JLabel("CYCLO (Ex: > 52");
										cycloEditorLogic = new JTextField();
										cycloEditorNumber = new JTextField();

										JLabel labelFerramenta = new JLabel("PMD ou IPlasma");
										ferramenta = new JTextField();

										panelLMRP1linha.add(labelLOC);
										panelLMRP1linha.add(locEditorLogic);
										panelLMRP1linha.add(locEditorNumber);
										panelLMRP2linha.add(editorLabel);
										panelLMRP2linha.add(editorAndOr);
										panelLMRP3linha.add(labelCYCLO);
										panelLMRP3linha.add(cycloEditorLogic);
										panelLMRP3linha.add(cycloEditorNumber);
										panelLMRP4linha.add(labelFerramenta);
										panelLMRP4linha.add(ferramenta);

										
										//Ver aqui miguel 
										JButton checkLMPR = new JButton("Confirmar Regra");
										checkLMPR.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent x) {
												frame.remove(excel);
												frameRegra.dispose();
												pr.dispose();
												Regras regrasLM = new Regras(ER.getDados(), "Long Method", locEditorLogic.getText().charAt(0), cycloEditorLogic.getText().charAt(0), editorAndOr.getText().trim(), locEditorNumber.getText().trim(), cycloEditorNumber.getText().trim(), "LongMethod");
												regrasLM.cria();
												
												if (ferramenta.getText().trim().equals("PMD") ){
													
													DefeitosPrPMD defPrLm = new DefeitosPrPMD(ER.getDados(), regrasLM.getLista());
													defPrLm.defeitos();

													JTable lmPRTable = new JTable(defPrLm.getresultados(), defPrLm.getheader());
													lmPRTable.setEnabled(false);
													JScrollPane tablePRLM = new JScrollPane(lmPRTable);

													JList<String> listLmPr = new JList<String>(tamanhoVetorCerto(regrasLM.getResultados()));
													JScrollPane paneLmPr = new JScrollPane(listLmPr);
													paneLmPr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
													paneLmPr.setWheelScrollingEnabled(true);

													JSplitPane splitLM = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneLmPr, tablePRLM);
													splitLM.setDividerLocation(100);
													splitLM.setVisible(true);

													frame.add(splitLM, BorderLayout.CENTER);
													frame.setVisible(true);
													
												} else {
													
													DefeitosPrIPlasma defPrIP = new DefeitosPrIPlasma(ER.getDados(), regrasLM.getLista());
													defPrIP.defeitos();

													JTable lmPRTable = new JTable(defPrIP.getresultados(), defPrIP.getheader());
													lmPRTable.setEnabled(false);
													JScrollPane tablePRLM = new JScrollPane(lmPRTable);

													JList<String> listIPPr = new JList<String> (tamanhoVetorCerto(regrasLM.getResultados()));
													JScrollPane paneIpPr = new JScrollPane(listIPPr);
													paneIpPr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
													paneIpPr.setWheelScrollingEnabled(true);

													JSplitPane splitLM = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneIpPr, tablePRLM);
													splitLM.setDividerLocation(100);
													splitLM.setVisible(true);

													frame.add(splitLM, BorderLayout.CENTER);
													frame.setVisible(true);
												}
											}
										});

										panelLMRP5linha.add(checkLMPR);

										prDefineParametros.add(panelLMRP1linha);
										prDefineParametros.add(panelLMRP2linha);
										prDefineParametros.add(panelLMRP3linha);
										prDefineParametros.add(panelLMRP4linha);
										prDefineParametros.add(panelLMRP5linha);

									} else {
										frame.remove(excel);
										frameRegra.dispose();
										pr.dispose();

										JDialog feDefineParametros = new JDialog(frameRegra, "Personalizar Regras");
										feDefineParametros.setLayout(new GridLayout(4, 1));
										feDefineParametros.setLocation(600, 250);
										feDefineParametros.setVisible(true);
										feDefineParametros.setSize(300, 175);

										JPanel panelFERP1linha = new JPanel(new GridLayout(1, 3));
										JPanel panelFERP2linha = new JPanel(new GridLayout(1, 2));
										JPanel panelFERP3linha = new JPanel(new GridLayout(1, 3));
										JPanel panelFERP4linha = new JPanel(new GridLayout(1, 1));

										JLabel labelATFD = new JLabel("ATFD");
										JTextField atfdEditorLogic = new JTextField();
										JTextField atfdEditorNumber = new JTextField();

										JLabel editorLabel = new JLabel("Escreva and ou or");
										JTextField editorAndOr = new JTextField();

										JLabel labelLAA = new JLabel("CYCLO");
										JTextField laaEditorLogic = new JTextField();
										JTextField laaloEditorNumber = new JTextField();

										panelFERP1linha.add(labelATFD);
										panelFERP1linha.add(atfdEditorLogic);
										panelFERP1linha.add(atfdEditorNumber);
										panelFERP2linha.add(editorLabel);
										panelFERP2linha.add(editorAndOr);
										panelFERP3linha.add(labelLAA);
										panelFERP3linha.add(laaEditorLogic);
										panelFERP3linha.add(laaloEditorNumber);

										JButton checkFEPR = new JButton("Confirmar Regra");
										checkFEPR.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent x) {
												/*
												 * frame.remove(excel); frameRegra.dispose(); pr.dispose();
												 * 
												 * //isLongMethod pmetodo = new isLongMethod(ER.getDados(),
												 * lmTextLOC.getText(), lmTextCYCLO.getText());
												 * 
												 * JPanel lmPanelFinal = new JPanel(); lmPanelFinal.setLayout(new
												 * GridLayout(1, 2));
												 * 
												 * //JList<String> model = new JList<String>(pmetodo.getdados());
												 * //JScrollPane excellmFinal = new JScrollPane(model);
												 * excellmFinal.setVerticalScrollBarPolicy(JScrollPane.
												 * VERTICAL_SCROLLBAR_ALWAYS);
												 * 
												 * lmPanelFinal.add(excellmFinal); frame.add(lmPanelFinal,
												 * BorderLayout.CENTER); frame.setVisible(true);
												 */
											}
										});

										panelFERP4linha.add(checkFEPR);

										feDefineParametros.add(panelFERP1linha);
										feDefineParametros.add(panelFERP2linha);
										feDefineParametros.add(panelFERP3linha);
										feDefineParametros.add(panelFERP4linha);

									}
								}
							});

							pr.add(prCheck, BorderLayout.SOUTH);

						}
					}
				});

				// botao check da frame Regras (frame inicial)
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

					JTable jt = new JTable(ER.getDados(), ER.getHeader());
					excel = new JScrollPane(jt);

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

	public String[] tamanhoVetorCerto(String[] xx) {
		String[] result = new String[500];
		for (int i = 0; i < 422; i++) {
			if (xx[i] == null) {
				result = new String[i];
				for (int j = 0; j < i; j++) {
					result[j] = xx[j];
				}
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		new GUI().open();
	}

}