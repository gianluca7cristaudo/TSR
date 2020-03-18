import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Button;
import javax.swing.JPasswordField;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.TextArea;
import javax.swing.JTextArea;

public class TsrGUI {

	private JFrame frame;
	private JButton btn_accedi;
	private JTextField txb_nome_titolo;
	private JTextField txb_cognome_abstract;
	private JTextField txb_nazionalita_affiliazione_dimensione;
	private JTextField txb_email_A_nomeFile;
	private JLabel lbl_titolo_prog;
	private JLabel lbl_nome_titolo;
	private JLabel lbl_cognome_abstract;
	private JLabel lbl_nazionalita_affiliazione_dimensione;
	private JLabel lbl_email_A_nomeFile;
	private JLabel lbl_password_A;
	private JLabel lbl_anni_esperienza;
	private Choice ch_anni_esperienza;
	private JLabel lbl_tipo;
	private Choice ch_senior_junior;
	private JButton btn_registra_revisore;
	private JButton btn_registra_autore;
	private JButton btn_back;
	private int sezione=0; 
	private TSR nuovo=TSR.getIstanza();
	private JButton btn_registrati_accedi_avanti;
	private JLabel lbl_risposta_registrazione;
	private JPasswordField txb_password_A;
	private JLabel lbl_datiUtente;
	private Panel panel_datiUtente;
	private JButton btn_sottometti_articoloA_DF;
	private JButton btn_visualizza_valutazioni_Tracce;
	private JLabel lbl_infoS;
	private JButton btn_ins_Autore_conferma;
	private JButton btn_conferma_sottomissione;
	private Choice ch_articoliAR_DaVR_DF;
	private JLabel lbl_articoliAR_DaVR_DF;
	private JButton btn_visualizzaV_SelAV_DF;
	private TextArea txa_visualizzaV_Edit;
	private JLabel lblGiudizio;
	private Choice chGiudizio;
	private JLabel lblCommento;
	private JTextArea txaCommento;
	private JLabel lbl_EsitoValutazione;
	private Panel pnl_VJ;
	private Choice ch_VJ_vte;
	private Choice ch_VJ_vor;
	private Choice ch_VJ_vpr;
	private Choice ch_VJ_vov;
	private JLabel lvl_VJ_vte;
	private JLabel lbl_VJ_vor;
	private JLabel lbl_VJ_vpr;
	private JLabel lbl_VJ_vov;
	private Panel pnl_Ins_DF;
	private Choice ch_Scelte_DF_CRR;
	private JLabel lbl_Ins_Scelta_DF;
	private JButton btn_inviaDF;
	private JButton btn_confermaDF;
	private JLabel lbl_confermaDefinitvia_DF;
	private JButton btn_indietro_DF_pn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TsrGUI window = new TsrGUI();
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
	public TsrGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 844, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btn_accedi = new JButton("accedi");
		btn_accedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sezione=3;
				nascondiHome();
				mostraCampiAccesso();
			}
		});
		btn_accedi.setBounds(65, 433, 105, 31);
		frame.getContentPane().add(btn_accedi);
		
		lbl_titolo_prog = new JLabel("Top Scientist Review");
		lbl_titolo_prog.setForeground(new Color(0, 153, 204));
		lbl_titolo_prog.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titolo_prog.setFont(new Font("Tahoma", Font.BOLD, 31));
		lbl_titolo_prog.setBounds(223, 0, 329, 93);
		frame.getContentPane().add(lbl_titolo_prog);
		
		btn_registra_revisore = new JButton("registra revisore");
		btn_registra_revisore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nascondiHome();
				sezione=1;
				mostraRegistrazioneRevisore();
			}
		});
		btn_registra_revisore.setBounds(560, 433, 134, 31);
		frame.getContentPane().add(btn_registra_revisore);
		
		btn_registra_autore = new JButton("registra autore");
		btn_registra_autore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sezione=2;
				nascondiHome();
				mostraRegistrazioneAutore();
				//AutoreDAOimpl classeDAO=new AutoreDAOimpl();
				//classeDAO.inserisciAutore(nuovo.getAutoreCorrente()); //DATABASE
			}
		});
		btn_registra_autore.setBounds(295, 433, 134, 31);
		frame.getContentPane().add(btn_registra_autore);
		
		lbl_nome_titolo = new JLabel("Nome:");
		lbl_nome_titolo.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_nome_titolo.setBounds(271, 108, 63, 14);
		frame.getContentPane().add(lbl_nome_titolo);
		
		lbl_cognome_abstract = new JLabel("Cognome:");
		lbl_cognome_abstract.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_cognome_abstract.setBounds(258, 133, 76, 14);
		frame.getContentPane().add(lbl_cognome_abstract);
		
		lbl_nazionalita_affiliazione_dimensione = new JLabel("Nazionalit\u00E0:");
		lbl_nazionalita_affiliazione_dimensione.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_nazionalita_affiliazione_dimensione.setBounds(223, 158, 111, 14);
		frame.getContentPane().add(lbl_nazionalita_affiliazione_dimensione);
		
		lbl_email_A_nomeFile = new JLabel("Email:");
		lbl_email_A_nomeFile.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_email_A_nomeFile.setBounds(208, 183, 123, 14);
		frame.getContentPane().add(lbl_email_A_nomeFile);
		
		lbl_password_A = new JLabel("Password:");
		lbl_password_A.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_password_A.setBounds(258, 208, 74, 14);
		frame.getContentPane().add(lbl_password_A);
		
		lbl_anni_esperienza = new JLabel("Anni di esperienza:");
		lbl_anni_esperienza.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_anni_esperienza.setBounds(223, 233, 109, 14);
		frame.getContentPane().add(lbl_anni_esperienza);
		
		ch_anni_esperienza = new Choice();
		ch_anni_esperienza.setBackground(Color.WHITE);
		ch_anni_esperienza.setBounds(351, 227, 86, 20);
		frame.getContentPane().add(ch_anni_esperienza);
		
		lbl_tipo = new JLabel("Tipo:");
		lbl_tipo.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tipo.setBounds(275, 258, 54, 14);
		frame.getContentPane().add(lbl_tipo);
		
		txb_nome_titolo = new JTextField();
		txb_nome_titolo.setBounds(351, 105, 86, 20);
		frame.getContentPane().add(txb_nome_titolo);
		txb_nome_titolo.setColumns(10);
		
		txb_cognome_abstract = new JTextField();
		txb_cognome_abstract.setBounds(351, 130, 86, 20);
		frame.getContentPane().add(txb_cognome_abstract);
		txb_cognome_abstract.setColumns(10);
		
		txb_nazionalita_affiliazione_dimensione = new JTextField();
		txb_nazionalita_affiliazione_dimensione.setBounds(351, 155, 86, 20);
		frame.getContentPane().add(txb_nazionalita_affiliazione_dimensione);
		txb_nazionalita_affiliazione_dimensione.setColumns(10);
		
		txb_email_A_nomeFile = new JTextField();
		txb_email_A_nomeFile.setBounds(351, 180, 86, 20);
		frame.getContentPane().add(txb_email_A_nomeFile);
		txb_email_A_nomeFile.setColumns(10);
		
		ch_senior_junior = new Choice();
		ch_senior_junior.setBounds(351, 252, 86, 20);
		frame.getContentPane().add(ch_senior_junior);
		
		btn_back = new JButton("indietro");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(sezione) {
					case 1: {
						nascondiRegistrazioneRevisore();
						cancellaCampiRegistrazione();
						mostraHome();
						break;
					}
					case 2: {
						nascondiRegistrazioneAutore();
						cancellaCampiRegistrazione();
						mostraHome();
						break;
					}
					case 3: {
						nascondiCampiAccesso();
						mostraHome();
						break;
					}
					case 4:{
						esciAutore();
						mostraHome();
						break;
					}
					case 5: {
						nascondiInserisciAutore();
						btn_sottometti_articoloA_DF.setVisible(true);
						btn_visualizza_valutazioni_Tracce.setVisible(true);
						btn_back.setText("Esci");
						sezione=4;
						break;
					}
					case 6: {
						sezione=5;
						lbl_email_A_nomeFile.setText("Email:");
						nascondiInsDatiArticolo();
						mostraInserisciAutore();
						break;
					}
					case 7: {
						sbloccaLblInsDati();
						sezione=6;
						btn_ins_Autore_conferma.setVisible(true);
						btn_conferma_sottomissione.setVisible(false);
						lbl_risposta_registrazione.setVisible(false);
						break;
					}
					case 8:{
						btn_sottometti_articoloA_DF.setVisible(true);
						btn_visualizza_valutazioni_Tracce.setVisible(true);
						ch_articoliAR_DaVR_DF.setVisible(false);
						lbl_articoliAR_DaVR_DF.setVisible(false);
						txa_visualizzaV_Edit.setVisible(false);
						btn_visualizzaV_SelAV_DF.setVisible(false);
						btn_back.setText("Esci");
						sezione=4;
						break;
					}
					case 9: {
						hideSezioneRevisore();
						mostraHome();
						lbl_EsitoValutazione.setVisible(false);
						break;
					}
					case 10: {
						sezione=9;
						btn_back.setText("Esci");
						hideCampiValutazioneSenior();
						pnl_VJ.setVisible(false);
						showSezioneRevisore();
						lbl_EsitoValutazione.setVisible(false);
						break;
					}
					case 11: {
						btn_back.setVisible(false);
						btn_sottometti_articoloA_DF.setVisible(false);
						btn_visualizza_valutazioni_Tracce.setVisible(false);
						panel_datiUtente.setVisible(false);
						mostraHome();
						lbl_titolo_prog.setVisible(true);
						break;
					}
					case 12:{
						lbl_articoliAR_DaVR_DF.setVisible(false);
						ch_articoliAR_DaVR_DF.setVisible(false);
						btn_visualizzaV_SelAV_DF.setVisible(false);
						sezione=11;
						btn_sottometti_articoloA_DF.setVisible(true);
						btn_visualizza_valutazioni_Tracce.setVisible(true);
						btn_back.setText("Esci");
						break;
					}
					case 13:{
						txa_visualizzaV_Edit.setVisible(false);
						sezione=12;
						pnl_Ins_DF.setVisible(false);
						ch_articoliAR_DaVR_DF.setVisible(true);
						lbl_articoliAR_DaVR_DF.setVisible(true);
						btn_visualizzaV_SelAV_DF.setVisible(true);
						break;
					}
					case 14:{
						sezione=11;
						txa_visualizzaV_Edit.setText("");
						txa_visualizzaV_Edit.setVisible(false);
						showSezioneEditore();
						break;
					}
					case 16:{
						ch_articoliAR_DaVR_DF.setVisible(true);
						btn_visualizzaV_SelAV_DF.setVisible(true);
						lbl_articoliAR_DaVR_DF.setVisible(true);
						txa_visualizzaV_Edit.setVisible(false);
						sezione=8;
					}
				}
				
			}
		});
		btn_back.setBounds(129, 333, 105, 31);
		frame.getContentPane().add(btn_back);
		
		btn_registrati_accedi_avanti = new JButton("registrati");
		btn_registrati_accedi_avanti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (sezione){
					case 1: {
						String nome=txb_nome_titolo.getText();
						String cognome=txb_cognome_abstract.getText();
						String nazionalita=txb_nazionalita_affiliazione_dimensione.getText();
						String email=txb_email_A_nomeFile.getText();
						String password=txb_password_A.getText();
						int anni_esperienza=Integer.parseInt(ch_anni_esperienza.getSelectedItem());
						String tipo=ch_senior_junior.getSelectedItem();
						String risposta=nuovo.registrazioneRevisore(nome, cognome, email, nazionalita, anni_esperienza, password, tipo);
						lbl_risposta_registrazione.setVisible(true);
						lbl_risposta_registrazione.setText(risposta);
						if(risposta.contains("correttamente")) cancellaCampiRegistrazione();
						break;
					}
					case 2: {
						String nome=txb_nome_titolo.getText();
						String cognome=txb_cognome_abstract.getText();
						String affiliazione=txb_nazionalita_affiliazione_dimensione.getText();
						String email=txb_email_A_nomeFile.getText();
						String password=txb_password_A.getText();
						String risposta=nuovo.registrazioneAutore(nome, cognome, email, affiliazione, password);
						lbl_risposta_registrazione.setVisible(true);
						lbl_risposta_registrazione.setText(risposta);
						if(risposta.contains("effettuata")) cancellaCampiRegistrazione();
						break;
					}
					case 3: {
							String email=txb_email_A_nomeFile.getText();
							String password=txb_password_A.getText();
							if(nuovo.autenticazioneEditore(email, password)) {
								showSezioneEditore();
								cancellaDatiAccesso();
								btn_registrati_accedi_avanti.setVisible(false);
								lbl_email_A_nomeFile.setVisible(false);
								lbl_password_A.setVisible(false);
								txb_email_A_nomeFile.setVisible(false);
								txb_password_A.setVisible(false);
								lbl_risposta_registrazione.setVisible(false);
								lbl_titolo_prog.setVisible(false);
								sezione=11;
							}
							else {
									boolean risultato=nuovo.autenticazioneAutore(email, password);
									if(risultato==true) {
										sezioneAutore();
										nascondiRegistrazioneAutore();
										cancellaDatiAccesso();
										lbl_risposta_registrazione.setVisible(false);
									}
									else {
										risultato=nuovo.autenticazioneRevisore(email, password);
										if(risultato==true) {
											cancellaDatiAccesso();
											lbl_email_A_nomeFile.setVisible(false);
											lbl_password_A.setVisible(false);
											txb_email_A_nomeFile.setVisible(false);
											txb_password_A.setVisible(false);
											btn_registrati_accedi_avanti.setVisible(false);
											btn_back.setText("Esci");
											lbl_risposta_registrazione.setVisible(false);
											showSezioneRevisore();
										}
										else {
											lbl_risposta_registrazione.setVisible(true);
											lbl_risposta_registrazione.setText("utente non presente nel sistema.");
											txb_email_A_nomeFile.setText("");
											txb_password_A.setText("");
										}
									}
								}
						break;
					}
					case 5: {
						mostraInsDatiArticolo();
						btn_registrati_accedi_avanti.setVisible(false);
						lbl_infoS.setVisible(false);
						break;
					}
				}
			}
		});
		btn_registrati_accedi_avanti.setBounds(542, 333, 105, 31);
		frame.getContentPane().add(btn_registrati_accedi_avanti);
		
		lbl_risposta_registrazione = new JLabel("qui");
		lbl_risposta_registrazione.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_risposta_registrazione.setBounds(258, 292, 315, 14);
		frame.getContentPane().add(lbl_risposta_registrazione);
		
		txb_password_A = new JPasswordField();
		txb_password_A.setToolTipText("Inserire una password di almeno 8 caratteri, contenente almeno 1 lettera maiuscola e un numero");
		txb_password_A.setBounds(351, 205, 86, 20);
		frame.getContentPane().add(txb_password_A);
		
		panel_datiUtente = new Panel();
		panel_datiUtente.setBackground(SystemColor.activeCaption);
		panel_datiUtente.setBounds(0, 0, 292, 31);
		frame.getContentPane().add(panel_datiUtente);
		
		lbl_datiUtente = new JLabel("New label");
		panel_datiUtente.add(lbl_datiUtente);
		
		btn_sottometti_articoloA_DF = new JButton("Sottometti Articolo");
		btn_sottometti_articoloA_DF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (sezione) {
					case 4: {
						nuovo.nuovoArticolo();
						btn_visualizza_valutazioni_Tracce.setVisible(false);
						btn_sottometti_articoloA_DF.setVisible(false);
						mostraInserisciAutore();
						break;
					}
					case 11: {
						sezione=12;
						btn_back.setText("Indietro");
						btn_back.setVisible(true);
						btn_sottometti_articoloA_DF.setVisible(false);
						btn_visualizza_valutazioni_Tracce.setVisible(false);
						lbl_articoliAR_DaVR_DF.setText("Seleziona articolo per la DF");
						lbl_articoliAR_DaVR_DF.setVisible(true);
						btn_visualizzaV_SelAV_DF.setText("Seleziona");
						if(nuovo.getListaArticoliCandidati().size()>0) btn_visualizzaV_SelAV_DF.setVisible(true);
						riempiCh_DF();
						ch_articoliAR_DaVR_DF.setVisible(true);
					}
				}
			}
		});
		btn_sottometti_articoloA_DF.setBackground(SystemColor.menu);
		btn_sottometti_articoloA_DF.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btn_sottometti_articoloA_DF.setForeground(SystemColor.desktop);
		btn_sottometti_articoloA_DF.setBounds(54, 158, 165, 43);
		frame.getContentPane().add(btn_sottometti_articoloA_DF);
		
		btn_visualizza_valutazioni_Tracce = new JButton("Visualizza Valutazioni");
		btn_visualizza_valutazioni_Tracce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (sezione) {
					case 4:{
						sezione=8;
						int i=0;
						for (i=0;i<nuovo.getAutoreCorrente().getListaArticoliAR().size();i++) {
							ch_articoliAR_DaVR_DF.add(nuovo.getAutoreCorrente().getListaArticoliAR().get(i).getTitolo());
						}
						showValutazioni();
						btn_visualizzaV_SelAV_DF.setText("Visualizza");
						if (i>0)btn_visualizzaV_SelAV_DF.setVisible(true);
						break;
					}
					case 11:{
						btn_back.setText("Indietro");
						sezione=14;
						showTracce();
						break;
					}
				}
			}
		});
		btn_visualizza_valutazioni_Tracce.setForeground(Color.BLACK);
		btn_visualizza_valutazioni_Tracce.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btn_visualizza_valutazioni_Tracce.setBackground(SystemColor.menu);
		btn_visualizza_valutazioni_Tracce.setBounds(482, 158, 165, 43);
		frame.getContentPane().add(btn_visualizza_valutazioni_Tracce);
		
		lbl_infoS = new JLabel("");
		lbl_infoS.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoS.setBounds(124, 208, 523, 14);
		frame.getContentPane().add(lbl_infoS);
		
		btn_ins_Autore_conferma = new JButton("Inserisci autore");
		btn_ins_Autore_conferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (sezione) {
					case 5: {
						String email=txb_email_A_nomeFile.getText();
						txb_email_A_nomeFile.setText("");
						String risultato=nuovo.inserisciAutore(email);
						lbl_infoS.setText(risultato);
						break;
					}
					case 6: {
						int dimensione=0;
						String titolo=txb_nome_titolo.getText();
						String abgstract=txb_cognome_abstract.getText();
						if (txb_nazionalita_affiliazione_dimensione.getText().length()>0)dimensione=Integer.parseInt(txb_nazionalita_affiliazione_dimensione.getText());
						String nome_file=txb_email_A_nomeFile.getText();
						String risultato=nuovo.setDatiArticolo(titolo, abgstract, dimensione, nome_file);
						lbl_risposta_registrazione.setText(risultato);
						lbl_risposta_registrazione.setVisible(true);
						if(risultato.contains("sono")) {
							sezione=7;
							btn_ins_Autore_conferma.setVisible(false);
							btn_conferma_sottomissione.setVisible(true);
							bloccaLblInsDati();
						}
						break;
					}
					case 10:{
						if(nuovo.getRevisoreCorrente() instanceof RevisoreSenior) {
							String commento=txaCommento.getText();
							String giudizio=chGiudizio.getSelectedItem();
							String risposta=nuovo.inValutazione(commento, giudizio, 0, 0, 0, 0);
							if (!(risposta.contains("non"))) {
								hideCampiValutazioneSenior();
								aggiornaChV();
								btn_ins_Autore_conferma.setVisible(false);
								showSezioneRevisore();
							}
							lbl_EsitoValutazione.setText(risposta);
							lbl_EsitoValutazione.setVisible(true);
						}
						else {
							
						}
						break;
					}
				}
			}
		});
		btn_ins_Autore_conferma.setBounds(330, 333, 130, 31);
		frame.getContentPane().add(btn_ins_Autore_conferma);
		
		btn_conferma_sottomissione = new JButton("Conferma Sottomissione");
		btn_conferma_sottomissione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sezione 7
				if((nuovo.getListaRevisoriJunior().size()>=2)&&(nuovo.getListaRevisoriSenior().size()>=1)) {
					String risultato=nuovo.confermaSottomissioneArticolo();
					lbl_risposta_registrazione.setText(risultato);
					lbl_risposta_registrazione.setVisible(true);
					sbloccaLblInsDati();
					nascondiInsDatiArticolo();
					sezioneAutore();
					btn_conferma_sottomissione.setVisible(false);
					btn_registrati_accedi_avanti.setVisible(false);
					btn_ins_Autore_conferma.setVisible(false);
					sezione=4;
				}
				lbl_risposta_registrazione.setText("il numero di revisori è insufficiente");
			}
		});
		btn_conferma_sottomissione.setBounds(314, 253, 159, 36);
		frame.getContentPane().add(btn_conferma_sottomissione);
		
		ch_articoliAR_DaVR_DF = new Choice();
		ch_articoliAR_DaVR_DF.setBounds(171, 208, 134, 20);
		frame.getContentPane().add(ch_articoliAR_DaVR_DF);
		
		lbl_articoliAR_DaVR_DF = new JLabel("Articoli A/R");
		lbl_articoliAR_DaVR_DF.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_articoliAR_DaVR_DF.setBounds(0, 211, 170, 14);
		frame.getContentPane().add(lbl_articoliAR_DaVR_DF);
		
		btn_visualizzaV_SelAV_DF = new JButton("Seleziona");
		btn_visualizzaV_SelAV_DF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (sezione) {
					case 8:{
						txa_visualizzaV_Edit.setText("");
						txa_visualizzaV_Edit.setBounds(240, 67, 458, 339);
						txa_visualizzaV_Edit.setVisible(true);
						txa_visualizzaV_Edit.setEditable(false);
						sezione=16;
						ch_articoliAR_DaVR_DF.setVisible(false);
						btn_visualizzaV_SelAV_DF.setVisible(false);
						lbl_articoliAR_DaVR_DF.setVisible(false);
						for(int i=0;i<nuovo.getAutoreCorrente().getListaArticoliAR().size();i++) {
							if(ch_articoliAR_DaVR_DF.getSelectedItem().equals(nuovo.getAutoreCorrente().getListaArticoliAR().get(i).getTitolo())) {
								for(int j=0;j<nuovo.getAutoreCorrente().getListaArticoliAR().get(i).getListaValutazioni().size();j++) {
									if(nuovo.getAutoreCorrente().getListaArticoliAR().get(i).getListaValutazioni().get(j) instanceof ValutazioneSenior) {
										ValutazioneSenior V=(ValutazioneSenior)nuovo.getAutoreCorrente().getListaArticoliAR().get(i).getListaValutazioni().get(j);
										txa_visualizzaV_Edit.setText(txa_visualizzaV_Edit.getText()+"\n"+V.toString()+"\n"+"\n"+"-----------------------------------------");
									}
									else {
										ValutazioneJunior V=(ValutazioneJunior)nuovo.getAutoreCorrente().getListaArticoliAR().get(i).getListaValutazioni().get(j);
										txa_visualizzaV_Edit.setText(txa_visualizzaV_Edit.getText()+"\n"+V.toString()+"\n"+"\n"+"-----------------------------------------");
									}
								}
							}
						}
						txa_visualizzaV_Edit.setText(txa_visualizzaV_Edit.getText()+"\n"+"\n"+"---------------------------------"+"\n"+"Stato:"+nuovo.getArticoloCorrente().getStato());
						break;
					}
					case 9:{
						String titoloArticoloScelto=ch_articoliAR_DaVR_DF.getSelectedItem();
						Articolo art=null;
						for(int i=0;i<nuovo.getRevisoreCorrente().getListaArticoliAssociati().size();i++) {
							if(titoloArticoloScelto.equals(nuovo.getRevisoreCorrente().getListaArticoliAssociati().get(i).getTitolo())) {
								art=nuovo.getRevisoreCorrente().getListaArticoliAssociati().get(i);
								break;
							}
						}
						nuovo.setArticoloCorrente(art);
						hideSezioneRevisore();
						sezione=10;
						btn_back.setText("Indietro");
						lbl_EsitoValutazione.setVisible(false);
						if (nuovo.getRevisoreCorrente() instanceof RevisoreSenior) {
							chGiudizio.removeAll();
							chGiudizio.add("accept");
							chGiudizio.add("weak accept");
							chGiudizio.add("weak reject");
							chGiudizio.add("reject");
							chGiudizio.setVisible(true);
							lblGiudizio.setVisible(true);
							lblCommento.setVisible(true);
							txaCommento.setVisible(true);
							btn_ins_Autore_conferma.setText("Conferma");
							btn_ins_Autore_conferma.setVisible(true);
						}
						else {
							riempiCh_VJ();
							pnl_VJ.setVisible(true);
						}
						
						break;
					}
					case 12:{
						String titoloArticoloScelto=ch_articoliAR_DaVR_DF.getSelectedItem();
						Articolo art=null;
						for (int i=0;i<nuovo.getListaArticoliCandidati().size();i++) {
							if(titoloArticoloScelto.equals(nuovo.getListaArticoliCandidati().get(i).getTitolo()))art=nuovo.getListaArticoliCandidati().get(i);
							break;
						}
						nuovo.setArticoloCorrente(art);
						sezione=13;
						ch_articoliAR_DaVR_DF.setVisible(false);
						lbl_articoliAR_DaVR_DF.setVisible(false);
						btn_visualizzaV_SelAV_DF.setVisible(false);
						VVE();
						riempiCH_DF_ARR();
						pnl_Ins_DF.setVisible(true);
						btn_inviaDF.setVisible(true);
						ch_Scelte_DF_CRR.setVisible(true);
						lbl_Ins_Scelta_DF.setVisible(true);
						btn_confermaDF.setVisible(false);
						lbl_confermaDefinitvia_DF.setVisible(false);
						btn_indietro_DF_pn.setVisible(false);
						break;
					}
				}
				
			}
		});
		btn_visualizzaV_SelAV_DF.setBounds(130, 249, 89, 23);
		frame.getContentPane().add(btn_visualizzaV_SelAV_DF);
		
		txa_visualizzaV_Edit = new TextArea();
		txa_visualizzaV_Edit.setEditable(false);
		txa_visualizzaV_Edit.setBounds(314, 544, 458, 339);
		frame.getContentPane().add(txa_visualizzaV_Edit);
		
		txaCommento = new JTextArea();
		txaCommento.setBounds(426, 104, 221, 143);
		frame.getContentPane().add(txaCommento);
		
		lblCommento = new JLabel("Inserire il commento:");
		lblCommento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCommento.setBounds(182, 183, 229, 14);
		frame.getContentPane().add(lblCommento);
		
		chGiudizio = new Choice();
		chGiudizio.setBounds(426, 252, 126, 20);
		frame.getContentPane().add(chGiudizio);
		
		lblGiudizio = new JLabel("Seleziona giudizio:");
		lblGiudizio.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGiudizio.setBounds(182, 258, 229, 14);
		frame.getContentPane().add(lblGiudizio);
		
		lbl_EsitoValutazione = new JLabel("New label");
		lbl_EsitoValutazione.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_EsitoValutazione.setBounds(242, 375, 315, 14);
		frame.getContentPane().add(lbl_EsitoValutazione);
		
		pnl_VJ = new Panel();
		pnl_VJ.setBounds(316, 76, 221, 230);
		frame.getContentPane().add(pnl_VJ);
		pnl_VJ.setLayout(null);
		
		ch_VJ_vte = new Choice();
		ch_VJ_vte.setBounds(159, 21, 52, 20);
		pnl_VJ.add(ch_VJ_vte);
		
		ch_VJ_vor = new Choice();
		ch_VJ_vor.setBounds(159, 64, 52, 20);
		pnl_VJ.add(ch_VJ_vor);
		
		ch_VJ_vpr = new Choice();
		ch_VJ_vpr.setBounds(159, 107, 52, 20);
		pnl_VJ.add(ch_VJ_vpr);
		
		ch_VJ_vov = new Choice();
		ch_VJ_vov.setBounds(159, 149, 52, 20);
		pnl_VJ.add(ch_VJ_vov);
		
		lvl_VJ_vte = new JLabel("Inserisci voto technical:");
		lvl_VJ_vte.setHorizontalAlignment(SwingConstants.TRAILING);
		lvl_VJ_vte.setBounds(10, 27, 143, 14);
		pnl_VJ.add(lvl_VJ_vte);
		
		lbl_VJ_vor = new JLabel("Inserisci voto originality:");
		lbl_VJ_vor.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_VJ_vor.setBounds(10, 66, 143, 14);
		pnl_VJ.add(lbl_VJ_vor);
		
		lbl_VJ_vpr = new JLabel("Inserisci voto presentation:");
		lbl_VJ_vpr.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_VJ_vpr.setBounds(10, 111, 143, 14);
		pnl_VJ.add(lbl_VJ_vpr);
		
		lbl_VJ_vov = new JLabel("Inserisci voto overall:");
		lbl_VJ_vov.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_VJ_vov.setBounds(10, 155, 143, 14);
		pnl_VJ.add(lbl_VJ_vov);
		
		JButton btnNewButton = new JButton("Conferma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String voto_te=ch_VJ_vte.getSelectedItem();
				String voto_or=ch_VJ_vor.getSelectedItem();
				String voto_pre=ch_VJ_vpr.getSelectedItem();
				String voto_ov=ch_VJ_vov.getSelectedItem();
				int voto_tec=Integer.parseInt(voto_te);
				int voto_ori=Integer.parseInt(voto_or);
				int voto_pred=Integer.parseInt(voto_pre);
				int voto_ove=Integer.parseInt(voto_ov);
				String risposta=nuovo.inValutazione("", "", voto_tec, voto_ori, voto_pred, voto_ove);
				lbl_EsitoValutazione.setText(risposta);
				lbl_EsitoValutazione.setVisible(true);
				btn_back.setText("Esci");
				pnl_VJ.setVisible(false);
				showSezioneRevisore();
			}
		});
		btnNewButton.setBounds(64, 196, 89, 23);
		pnl_VJ.add(btnNewButton);
		
		pnl_Ins_DF = new Panel();
		pnl_Ins_DF.setBounds(314, 395, 458, 143);
		frame.getContentPane().add(pnl_Ins_DF);
		pnl_Ins_DF.setLayout(null);
		
		ch_Scelte_DF_CRR = new Choice();
		ch_Scelte_DF_CRR.setBounds(277, 22, 102, 20);
		pnl_Ins_DF.add(ch_Scelte_DF_CRR);
		
		lbl_Ins_Scelta_DF = new JLabel("Inserisci decisione finale:");
		lbl_Ins_Scelta_DF.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_Ins_Scelta_DF.setBounds(108, 28, 163, 14);
		pnl_Ins_DF.add(lbl_Ins_Scelta_DF);
		
		btn_inviaDF = new JButton("Invia");
		btn_inviaDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_indietro_DF_pn.setText("Indietro");
				lbl_confermaDefinitvia_DF.setText("Confermare la decisione finale");
				lbl_confermaDefinitvia_DF.setVisible(true);
				btn_confermaDF.setText("Conferma");
				btn_confermaDF.setVisible(true);
				btn_indietro_DF_pn.setVisible(true);
				btn_inviaDF.setVisible(false);
				ch_Scelte_DF_CRR.setVisible(false);
				lbl_Ins_Scelta_DF.setVisible(false);
				btn_back.setVisible(false);
			}
		});
		btn_inviaDF.setBounds(252, 53, 89, 23);
		pnl_Ins_DF.add(btn_inviaDF);
		
		btn_confermaDF = new JButton("Conferma");
		btn_confermaDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String decisione=ch_Scelte_DF_CRR.getSelectedItem();
				nuovo.decisioneFinale(decisione);
				btn_confermaDF.setVisible(false);
				lbl_confermaDefinitvia_DF.setVisible(false);
				btn_indietro_DF_pn.setVisible(false);
				pnl_Ins_DF.setVisible(false);
				txa_visualizzaV_Edit.setVisible(false);
				btn_back.setText("Esci");
				btn_back.setVisible(true);
				btn_sottometti_articoloA_DF.setVisible(true);
				btn_visualizza_valutazioni_Tracce.setVisible(true);
				sezione=11;
			}
		});
		btn_confermaDF.setBounds(95, 97, 102, 35);
		pnl_Ins_DF.add(btn_confermaDF);
		
		lbl_confermaDefinitvia_DF = new JLabel("New label");
		lbl_confermaDefinitvia_DF.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_confermaDefinitvia_DF.setBounds(39, 72, 203, 14);
		pnl_Ins_DF.add(lbl_confermaDefinitvia_DF);
		
		btn_indietro_DF_pn = new JButton("Indietro");
		btn_indietro_DF_pn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_confermaDF.setVisible(false);
				lbl_confermaDefinitvia_DF.setVisible(false);
				btn_indietro_DF_pn.setVisible(false);
				ch_Scelte_DF_CRR.setVisible(true);
				lbl_Ins_Scelta_DF.setText("Inserire decisione finale:");
				lbl_Ins_Scelta_DF.setVisible(true);
				btn_inviaDF.setText("Invia");
				btn_inviaDF.setVisible(true);
				btn_back.setVisible(true);
				ch_Scelte_DF_CRR.setVisible(true);
			}
		});
		btn_indietro_DF_pn.setBounds(313, 97, 94, 35);
		pnl_Ins_DF.add(btn_indietro_DF_pn);
		
		//START
		mostraHome();
		lbl_datiUtente.setVisible(false);
		panel_datiUtente.setVisible(false);
		btn_sottometti_articoloA_DF.setVisible(false);
		btn_visualizza_valutazioni_Tracce.setVisible(false);
		nascondiInserisciAutore();
		btn_conferma_sottomissione.setVisible(false);
		ch_articoliAR_DaVR_DF.setVisible(false);
		lbl_articoliAR_DaVR_DF.setVisible(false);
		btn_visualizzaV_SelAV_DF.setVisible(false);
		txa_visualizzaV_Edit.setVisible(false);
		chGiudizio.setVisible(false);
		lblGiudizio.setVisible(false);
		txaCommento.setVisible(false);
		lblCommento.setVisible(false);
		lbl_EsitoValutazione.setVisible(false);
		pnl_VJ.setVisible(false);
		pnl_Ins_DF.setVisible(false);
		//AutoreDAOimpl classeDAO=new AutoreDAOimpl();
		//nuovo.setListaAutori(classeDAO.doRetrieveAll()); DATABASE
		
	}
	
	private void mostraHome() {
		
		btn_accedi.setVisible(true);
		btn_registra_autore.setVisible(true);
		btn_registra_revisore.setVisible(true);
		lbl_nome_titolo.setVisible(false);
		lbl_cognome_abstract.setVisible(false);
		lbl_nazionalita_affiliazione_dimensione.setVisible(false);
		lbl_email_A_nomeFile.setVisible(false);
		lbl_password_A.setVisible(false);
		ch_anni_esperienza.setVisible(false);
		ch_senior_junior.setVisible(false);
		lbl_anni_esperienza.setVisible(false);
		lbl_tipo.setVisible(false);
		txb_nome_titolo.setVisible(false);
		txb_cognome_abstract.setVisible(false);
		txb_email_A_nomeFile.setVisible(false);
		txb_nazionalita_affiliazione_dimensione.setVisible(false);
		btn_back.setVisible(false);
		btn_registrati_accedi_avanti.setVisible(false);
		lbl_risposta_registrazione.setVisible(false);
		txb_password_A.setVisible(false);
	}
	
	private void nascondiHome() {
		btn_accedi.setVisible(false);
		btn_registra_autore.setVisible(false);
		btn_registra_revisore.setVisible(false);
	}
	
	private void mostraRegistrazioneRevisore() {
		inserisciAnniEsperienza();
		lbl_nome_titolo.setText("Nome:");
		lbl_cognome_abstract.setText("Cognome:");
		lbl_email_A_nomeFile.setText("Email:");
		lbl_password_A.setText("Password:");
		lbl_nazionalita_affiliazione_dimensione.setText("Nazionalità:");
		lbl_nome_titolo.setVisible(true);
		lbl_cognome_abstract.setVisible(true);
		lbl_nazionalita_affiliazione_dimensione.setVisible(true);
		lbl_email_A_nomeFile.setVisible(true);
		lbl_password_A.setVisible(true);
		ch_anni_esperienza.setVisible(true);
		ch_senior_junior.setVisible(true);
		ch_senior_junior.removeAll();
		ch_senior_junior.add("Senior");
		ch_senior_junior.add("Junior");
		lbl_anni_esperienza.setVisible(true);
		lbl_tipo.setVisible(true);
		txb_nome_titolo.setVisible(true);
		txb_cognome_abstract.setVisible(true);
		txb_email_A_nomeFile.setVisible(true);
		txb_nazionalita_affiliazione_dimensione.setVisible(true);
		txb_password_A.setVisible(true);
		btn_back.setVisible(true);
		btn_registrati_accedi_avanti.setVisible(true);
	}
	
	private void nascondiRegistrazioneRevisore() {
		lbl_nome_titolo.setVisible(false);
		lbl_cognome_abstract.setVisible(false);
		lbl_nazionalita_affiliazione_dimensione.setVisible(false);
		lbl_email_A_nomeFile.setVisible(false);
		lbl_password_A.setVisible(false);
		ch_anni_esperienza.setVisible(false);
		ch_senior_junior.setVisible(false);
		lbl_anni_esperienza.setVisible(false);
		lbl_tipo.setVisible(false);
		txb_nome_titolo.setVisible(false);
		txb_cognome_abstract.setVisible(false);
		txb_email_A_nomeFile.setVisible(false);
		txb_nazionalita_affiliazione_dimensione.setVisible(false);
		txb_password_A.setVisible(false);
		btn_back.setVisible(false);
	}
	
	private void mostraRegistrazioneAutore(){
		lbl_nome_titolo.setText("Nome:");
		lbl_cognome_abstract.setText("Cognome:");
		lbl_email_A_nomeFile.setText("Email:");
		lbl_password_A.setText("Password:");
		btn_back.setVisible(true);
		lbl_nome_titolo.setVisible(true);
		lbl_cognome_abstract.setVisible(true);
		lbl_nazionalita_affiliazione_dimensione.setText("Affiliazione:");
		lbl_nazionalita_affiliazione_dimensione.setVisible(true);
		lbl_email_A_nomeFile.setVisible(true);
		lbl_password_A.setVisible(true);
		txb_nome_titolo.setVisible(true);
		txb_cognome_abstract.setVisible(true);
		txb_email_A_nomeFile.setVisible(true);
		txb_nazionalita_affiliazione_dimensione.setVisible(true);
		txb_password_A.setVisible(true);
		btn_registrati_accedi_avanti.setVisible(true);
	}
	
	private void nascondiRegistrazioneAutore() {
		lbl_nome_titolo.setVisible(false);
		lbl_cognome_abstract.setVisible(false);
		lbl_nazionalita_affiliazione_dimensione.setVisible(false);
		lbl_email_A_nomeFile.setVisible(false);
		lbl_password_A.setVisible(false);
		txb_nome_titolo.setVisible(false);
		txb_cognome_abstract.setVisible(false);
		txb_email_A_nomeFile.setVisible(false);
		txb_nazionalita_affiliazione_dimensione.setVisible(false);
		txb_password_A.setVisible(false);
	}
	
	private void inserisciAnniEsperienza() {
		ch_anni_esperienza.removeAll();
		for(int i=1;i<100;i++) {
			String ciao=String.valueOf(i);
			ch_anni_esperienza.add(ciao);
		}
		
	}
	
	private void cancellaCampiRegistrazione() {
		txb_nome_titolo.setText("");
		txb_cognome_abstract.setText("");
		txb_nazionalita_affiliazione_dimensione.setText("");
		txb_email_A_nomeFile.setText("");
		txb_password_A.setText("");
		ch_senior_junior.removeAll();
		ch_senior_junior.add("Senior");
		ch_senior_junior.add("Junior");
		inserisciAnniEsperienza();
	}
	
	private void mostraCampiAccesso() {
		lbl_email_A_nomeFile.setVisible(true);
		lbl_password_A.setVisible(true);
		btn_back.setText("Indietro");
		btn_back.setVisible(true);
		btn_registrati_accedi_avanti.setText("Accedi");
		btn_registrati_accedi_avanti.setVisible(true);
		txb_email_A_nomeFile.setVisible(true);
		txb_password_A.setVisible(true);
	}
	
	private void nascondiCampiAccesso() {
		lbl_email_A_nomeFile.setVisible(false);
		lbl_password_A.setVisible(false);
		btn_back.setVisible(false);
		btn_registrati_accedi_avanti.setText("Registrati");
		btn_registrati_accedi_avanti.setVisible(false);
		txb_email_A_nomeFile.setVisible(false);
		txb_password_A.setVisible(false);
	}
	
	private void sezioneAutore() {
		sezione=4;
		panel_datiUtente.setVisible(true);
		lbl_datiUtente.setVisible(true);
		lbl_datiUtente.setText(nuovo.getAutoreCorrente().getNome()+" "+nuovo.getAutoreCorrente().getCognome());
		lbl_titolo_prog.setVisible(false);
		btn_registrati_accedi_avanti.setVisible(false);
		btn_sottometti_articoloA_DF.setText("Sottometti articolo");
		btn_visualizza_valutazioni_Tracce.setText("Visualizza valutazioni");
		btn_sottometti_articoloA_DF.setVisible(true);
		btn_visualizza_valutazioni_Tracce.setVisible(true);
		btn_back.setText("Esci");
		btn_back.setVisible(true);
	}
	
	private void esciAutore() {
		panel_datiUtente.setVisible(false);
		lbl_datiUtente.setVisible(false);
		btn_sottometti_articoloA_DF.setVisible(false);
		btn_visualizza_valutazioni_Tracce.setVisible(false);
		btn_back.setText("Indietro");
		btn_back.setVisible(false);
		lbl_titolo_prog.setVisible(true);
	}
	
	private void cancellaDatiAccesso() {
		txb_email_A_nomeFile.setText("");
		txb_password_A.setText("");
	}
	
	private void mostraInserisciAutore (){
		txb_email_A_nomeFile.setVisible(true);
		lbl_email_A_nomeFile.setText("Email:");
		lbl_email_A_nomeFile.setVisible(true);
		btn_ins_Autore_conferma.setVisible(true);
		lbl_infoS.setText("");
		lbl_infoS.setVisible(true);
		sezione=5;
		btn_back.setText("Indietro");
		btn_back.setVisible(true);
		btn_registrati_accedi_avanti.setText("Avanti");
		btn_registrati_accedi_avanti.setVisible(true);
		btn_ins_Autore_conferma.setText("Inserisci autore");
		btn_ins_Autore_conferma.setVisible(true);
	}
	
	private void nascondiInserisciAutore (){
		btn_ins_Autore_conferma.setVisible(false);
		lbl_infoS.setVisible(false);
		txb_email_A_nomeFile.setVisible(false);
		lbl_email_A_nomeFile.setVisible(false);
		btn_registrati_accedi_avanti.setVisible(false);
		lbl_infoS.setVisible(false);
	}
	
	private void mostraInsDatiArticolo() {
		sezione=6;
		btn_ins_Autore_conferma.setText("Conferma");
		btn_ins_Autore_conferma.setVisible(true);
		lbl_nome_titolo.setText("Titolo:");
		lbl_nome_titolo.setVisible(true);
		txb_nome_titolo.setVisible(true);
		lbl_cognome_abstract.setText("Abstract:");
		lbl_cognome_abstract.setVisible(true);
		txb_cognome_abstract.setVisible(true);
		lbl_nazionalita_affiliazione_dimensione.setText("Dimensione:");
		lbl_nazionalita_affiliazione_dimensione.setVisible(true);
		txb_nazionalita_affiliazione_dimensione.setVisible(true);
		lbl_email_A_nomeFile.setText("Nome file:");
		lbl_email_A_nomeFile.setVisible(true);
		txb_email_A_nomeFile.setVisible(true);
	}
	
	private void nascondiInsDatiArticolo() {
		txb_nome_titolo.setText("");
		txb_cognome_abstract.setText("");
		txb_nazionalita_affiliazione_dimensione.setText("");
		txb_email_A_nomeFile.setText("");
		lbl_nome_titolo.setVisible(false);
		txb_nome_titolo.setVisible(false);
		lbl_cognome_abstract.setVisible(false);
		txb_cognome_abstract.setVisible(false);
		lbl_nazionalita_affiliazione_dimensione.setVisible(false);
		txb_nazionalita_affiliazione_dimensione.setVisible(false);
		lbl_email_A_nomeFile.setVisible(false);
		txb_email_A_nomeFile.setVisible(false);
		btn_ins_Autore_conferma.setText("Inserisci");
		btn_ins_Autore_conferma.setVisible(true);
		btn_registrati_accedi_avanti.setText("Avanti");
		btn_registrati_accedi_avanti.setVisible(true);
		lbl_risposta_registrazione.setVisible(false);
	}
	
	private void bloccaLblInsDati() {
		txb_nome_titolo.setEditable(false);
		txb_cognome_abstract.setEditable(false);
		txb_nazionalita_affiliazione_dimensione.setEditable(false);
		txb_email_A_nomeFile.setEditable(false);
	}
	
	private void sbloccaLblInsDati() {
		txb_nome_titolo.setEditable(true);
		txb_cognome_abstract.setEditable(true);
		txb_nazionalita_affiliazione_dimensione.setEditable(true);
		txb_email_A_nomeFile.setEditable(true);
	}
	
	private void showValutazioni() {
		btn_sottometti_articoloA_DF.setVisible(false);
		btn_visualizza_valutazioni_Tracce.setVisible(false);
		btn_back.setText("Indietro");
		aggiornaCHAR();
		ch_articoliAR_DaVR_DF.setVisible(true);
		lbl_articoliAR_DaVR_DF.setVisible(true);
	}
	
	private void showSezioneRevisore() {
		sezione=9;
		lbl_datiUtente.setText(nuovo.getRevisoreCorrente().getNome()+" "+nuovo.getRevisoreCorrente().getCognome());
		lbl_datiUtente.setVisible(true);
		panel_datiUtente.setVisible(true);
		lbl_articoliAR_DaVR_DF.setText("Seleziona articolo da valutare");
		lbl_articoliAR_DaVR_DF.setVisible(true);
		aggiornaChV();
		ch_articoliAR_DaVR_DF.setVisible(true);
		btn_visualizzaV_SelAV_DF.setText("Valuta");
		if(nuovo.getRevisoreCorrente().getListaArticoliAssociati().size()>0)btn_visualizzaV_SelAV_DF.setVisible(true);
	}
	
	private void hideSezioneRevisore() {
		lbl_datiUtente.setVisible(false);
		panel_datiUtente.setVisible(false);
		lbl_articoliAR_DaVR_DF.setVisible(false);
		ch_articoliAR_DaVR_DF.setVisible(false);
		btn_visualizzaV_SelAV_DF.setVisible(false);
		
	}
	
	private void aggiornaChV() {
		ch_articoliAR_DaVR_DF.removeAll();
		for(int i=0;i<nuovo.getRevisoreCorrente().getListaArticoliAssociati().size();i++) {
			ch_articoliAR_DaVR_DF.add(nuovo.getRevisoreCorrente().getListaArticoliAssociati().get(i).getTitolo());
		}
	}
	
	private void hideCampiValutazioneSenior() {
		chGiudizio.setVisible(false);
		txaCommento.setText("");
		txaCommento.setVisible(false);
		lblCommento.setVisible(false);
		lblGiudizio.setVisible(false);
		btn_ins_Autore_conferma.setVisible(false);
	}
	
	private void riempiCh_VJ() {
		ch_VJ_vor.removeAll();
		ch_VJ_vov.removeAll();
		ch_VJ_vpr.removeAll();
		ch_VJ_vte.removeAll();
		int i=0;
		for(i=0;i<10;i++) {
			String numero= Integer.toString(i);
			ch_VJ_vor.add(numero);
			ch_VJ_vov.add(numero);
			ch_VJ_vpr.add(numero);
			ch_VJ_vte.add(numero);
		}
	}
	
	private void showSezioneEditore() {
		btn_sottometti_articoloA_DF.setText("Decisione finale");
		btn_sottometti_articoloA_DF.setVisible(true);
		btn_visualizza_valutazioni_Tracce.setText("Visualizza Tracce");
		btn_visualizza_valutazioni_Tracce.setVisible(true);
		lbl_datiUtente.setText("EDITORE");
		panel_datiUtente.setVisible(true);
		lbl_datiUtente.setVisible(true);
		btn_back.setText("Esci");
		btn_back.setVisible(true);
	}
	
	private void riempiCh_DF() {
		ch_articoliAR_DaVR_DF.removeAll();
		for(int i=0;i<nuovo.getListaArticoliCandidati().size();i++) {
			ch_articoliAR_DaVR_DF.add(nuovo.getListaArticoliCandidati().get(i).getTitolo());
		}
	}
	
	private void riempiCH_DF_ARR() {
		ch_Scelte_DF_CRR.removeAll();
		if(nuovo.getArticoloCorrente().getStato().equals("candidato_rifiuto")) {
			ch_Scelte_DF_CRR.add("rifiutato");
			ch_Scelte_DF_CRR.add("ricandidato");
		}
		else {
			ch_Scelte_DF_CRR.add("accettato");
			ch_Scelte_DF_CRR.add("ricandidato");
		}
	}
	
	private void VVE() {
		txa_visualizzaV_Edit.setText("");
		txa_visualizzaV_Edit.setBounds(314, 25, 458, 339);
		for (int i=0;i<nuovo.getArticoloCorrente().getListaValutazioni().size();i++) {
			txa_visualizzaV_Edit.setText(txa_visualizzaV_Edit.getText()+"\n"+nuovo.getArticoloCorrente().getListaValutazioni().get(i).toString()+"\n"+"\n"+"----------------------------"+"\n"+"\n");
		}
		txa_visualizzaV_Edit.setVisible(true);
		txa_visualizzaV_Edit.setEditable(false);
	}
	
	private void aggiornaCHAR() {
		ch_articoliAR_DaVR_DF.removeAll();
		for(int i=0;i<nuovo.getAutoreCorrente().getListaArticoliAR().size();i++) {
			ch_articoliAR_DaVR_DF.add(nuovo.getAutoreCorrente().getListaArticoliAR().get(i).getTitolo());
		}
	}
	
	private void showTracce() {
		txa_visualizzaV_Edit.setBounds(314, 25, 458, 339);
		txa_visualizzaV_Edit.setText("");
		for(int i=0;i<nuovo.getListaTracce().size();i++) {
			txa_visualizzaV_Edit.setText(txa_visualizzaV_Edit.getText()+nuovo.getListaTracce().get(i).toString()+"\n"+"\n"+"----------------------------");
		}
		txa_visualizzaV_Edit.setVisible(true);
		btn_sottometti_articoloA_DF.setVisible(false);
		btn_visualizza_valutazioni_Tracce.setVisible(false);
	}
}
