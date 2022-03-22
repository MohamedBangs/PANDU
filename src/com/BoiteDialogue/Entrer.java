package com.BoiteDialogue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.GridBagLayout;

public class Entrer extends JDialog
{
	private RecuperNome Nom=new RecuperNome();
	private JPanel panelnom=new JPanel();
	private JLabel []label;
	private JTextField nom;
	private JButton ok;
	private JButton annuler;
	
 public Entrer(JFrame fenetre,String titre,Boolean bool)
 {
	 super(fenetre,titre,bool);
	 this.setSize(300,400);
	 this.setLocationRelativeTo(null);
	 this.setResizable(true);
	 this.afficheur();
 }
 public RecuperNome Affiche()
 {
	 this.setVisible(true);
	 return this.Nom;
 }
 
 public void afficheur()
 {
	 JPanel labe=new JPanel();
	labe.setPreferredSize(new Dimension(200,100));
	labe.setBackground(Color.white);
	labe.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.blue),
			BorderFactory.createMatteBorder(5,2,5,2,Color.red)));
	 this.label=new JLabel[4];
	 for(int i=0;i<this.label.length;i++)
		 this.label[i]=new JLabel();
	 this.label[0].setText("                                 ACCEUILLE                             ");
	 this.label[1].setText("      VEILLEZ SAISIR VOTRE NOM");
	 this.label[2].setText("      POUR BENEFICIER");
	 this.label[3].setText("      PLUS EN FONCTIONNALITE");
	 JLabel labelNom=new JLabel("NOM");
	 panelnom.setPreferredSize(new Dimension(220,60));
	 panelnom.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.blue),
			 BorderFactory.createMatteBorder(5,2,5,2,Color.red)));
	 nom=new JTextField();
	 nom.setPreferredSize(new Dimension(100,25));
	 panelnom.setBackground(Color.white);
	 panelnom.add(labelNom);
	 panelnom.add(nom);
	 ok=new JButton("VALIDER");
	 ok.addActionListener(new ActionListener()
	 {
		public void actionPerformed(ActionEvent event)
		{
			Nom=new RecuperNome(nom.getText());
			setVisible(false);
		}
	 });
	 this.annuler=new JButton("QUITTER");
	annuler.addActionListener(new ActionListener()
	 {
		 public void actionPerformed(ActionEvent event)
		 {
			 setVisible(false);
		 }
	 });
	JPanel button=new JPanel();
	button.add(ok);
	button.add(annuler);
	
	labe.add(this.label[0]);
	labe.add(this.label[1]);
	labe.add(this.label[2]);
	labe.add(this.label[3]);
	this.getContentPane().add(labe,BorderLayout.NORTH);
	this.getContentPane().add(panelnom,BorderLayout.CENTER);
	this.getContentPane().add(button,BorderLayout.SOUTH);
	}
}
