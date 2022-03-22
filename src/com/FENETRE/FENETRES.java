package com.FENETRE;
import java.awt.BorderLayout;

import java.awt.Color;
//import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuItem;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;




//import com.Fichier.Actualiser;
import com.BoiteDialogue.Fenetre;
//import com.BoiteDialogue.RecuperNome;
import com.Fichier.Fichiers;


public class FENETRES extends JFrame
{
	private Fenetre fene;
	private Fichiers fich;
	private JLabel labelnom=new JLabel();
	private JPanel panelnom =new JPanel();
	private String mot="";
	private String motSecret="";
	private String nom="";
	private Font font= new Font("Arial Black",Font.BOLD,14);
	private Dimension dimension=new Dimension(50,20);
	private String []str={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","�","�","�","�",
			"�","�","�","�","*","�","�","�","�","�","�","�","�","�","-","EF"};
	private JLabel label;
	 
	private JButton[] button=new JButton[str.length];
	private Ecouteur ecouteur=new Ecouteur();
	private JPanel panelbutton=new JPanel();
	private JPanel panel=new JPanel();
	private String orto="";
	private JButton boutton =new JButton("Valider");
	private JButton quitter=new JButton("Quitter");
	private JPanel quitterpanel=new JPanel();
	private JTextField text=new JTextField();;
   private Action action =new Action();
	private int score=0;
	private JLabel labelmotCache=new JLabel();
	private JPanel panelmot =new JPanel();
	private Meilleur_Scores ms;
	private JPanel Scor=new JPanel();
	private JLabel ls =new JLabel("0");
	private JPanel panelboutton =new JPanel();
	
	//LE MENU
	private JMenuBar menubar=new JMenuBar();
	private JMenu niveau =new JMenu("Niveau");
	private JMenu scores =new JMenu("Meilleur Score");
	private JMenu apropros=new JMenu("A Propos");
	
	private JMenuItem apropo=new JMenuItem("?");
	private JMenuItem mscore=new JMenuItem("Meilleur Scores");
	private JRadioButtonMenuItem primaire=new JRadioButtonMenuItem("Niveau Primaire");
	private JRadioButtonMenuItem college=new JRadioButtonMenuItem("Niveau College");
	private JRadioButtonMenuItem lycee=new JRadioButtonMenuItem("Niveau Lyc�e");
	private JRadioButtonMenuItem universite=new JRadioButtonMenuItem("Niveau Universitaire");
	private ButtonGroup bg=new ButtonGroup();
	private JPanel panele;
	
	private int valeur=5000;
  public FENETRES()
  {
	  this.setTitle("SCRABLE FRAN�AIS(BAM)");
	  this.setSize(600,500);
	  this.setLocationRelativeTo(null);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setResizable(false);
	   fene=new Fenetre();
	  this.Afficheur();
	  this.Menu();
	  this.Buttons();
	  this.label=new JLabel("");
	  Font font =new Font("ARIAL BLACK",Font.ITALIC,10);
	  this.label.setFont(font);
	  this.label.setForeground(Color.red);
	  this.panele=new JPanel();
	  this.panele.add(this.label);
	   panel.setSize(new Dimension(200,20));
	  this.getContentPane().add(this.panele,BorderLayout.NORTH);
	  this.getContentPane().add(this.panel,BorderLayout.CENTER);
	  this.getContentPane().add(this.panelbutton,BorderLayout.SOUTH);
  }
  public void Menu()
  {
	 //LE MENUBAR
	  
	  ActionMenu actionmenu=new ActionMenu();
	  this.primaire.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
	  this.college.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
	  this.lycee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,KeyEvent.CTRL_DOWN_MASK));
	  this.universite.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,KeyEvent.CTRL_DOWN_MASK));
	  this.primaire.addActionListener(actionmenu);
	  this.college.addActionListener(actionmenu);
	  this.lycee.addActionListener(actionmenu);
	  this.universite.addActionListener(actionmenu);
	  
	  this.primaire.setSelected(true);
		this.bg.add(this.primaire);
	 this.bg.add(this.college);
	 this.bg.add(this.lycee);
	 this.bg.add(this.universite);
	 
	 this.niveau.setMnemonic('N');
	 this.niveau.add(this.primaire);
	 this.niveau.add(this.primaire);
	 this.niveau.add(this.college);
     this.niveau.add(this.lycee);
     this.niveau.add(this.universite);
     
     this.apropo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
     this.apropo.addActionListener(new ActionListener()
     {
    	 public void actionPerformed(ActionEvent event)
    	 {
    		 
    		 JOptionPane op=new JOptionPane(); 
    		 String str="CE PETIT JEU DE DICTIONNAIRE VOUS ENRICHIT EN MOT DANS LA LANGUE FRAN�AISE\n";
    				str+="IL VOUS FORME EN ORTHOGRAPHE "
    						+ " POUR CHAQUE MOT TROUV�, VOTRE SCORE GRANDIRA EN FONCTION DU NIVEAU\n"
    						+ "LES NIVEAUX RESPECTIFS (PRIMAIRE CONTIENT 5000 MOTS + 5 points)\n (COLLEGE CONTIENT 15000 MOTS + 10 points)\n(LYC�E CONTIENT 25000 MOTS + 15 points)\n ET EN"
    						+ "FIN L'UNIVERSIT� A 36000 MOTS + 20 points\n\n";
    						str+="aller si tu connait la langue fran�aise montre moi ton tallent";
    		 op.showMessageDialog(null,str,"A PROPOS",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("livre.jpg"));
    	 }
     });
     this.apropros.setMnemonic('A');
     this.apropros.add(this.apropo);
     
     this.mscore.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,KeyEvent.CTRL_DOWN_MASK));
     this.mscore.addActionListener(new ActionListener()
     {
    	 String st="";
    	 JOptionPane op=new JOptionPane();
    	 public void actionPerformed(ActionEvent event)
    	 {
    		 ms=new Meilleur_Scores(score,nom);
    		st= ms.getMeilleurScore();
    		op.showMessageDialog(null,st,"MEILLEUR SCORE",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("score.png"));
    	 }
     });
     this.scores.setMnemonic('S');
     this.scores.add(mscore);
     
     this.menubar.add(this.niveau);
     this.menubar.add(this.scores);
     this.menubar.add(this.apropros);
	  
     this.setJMenuBar(this.menubar);

		this.panelboutton.setBackground(Color.white);
		this.panelboutton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.blue),
				BorderFactory.createMatteBorder(2,1,2,1,Color.red)));
		this.quitterpanel.setBackground(Color.white);
		this.quitterpanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.blue),
				BorderFactory.createMatteBorder(2,1,2,1,Color.red)));
		this.boutton.addActionListener(action);
		ActionQuitter qui=new ActionQuitter();
		this.quitter.addActionListener(qui);
		this.quitterpanel.add(this.quitter);
		this.panelboutton.add(this.boutton);
		GridBagConstraints gb=new GridBagConstraints();
		gb.gridx=0;
		gb.gridy=65;
		gb.gridwidth=1;
		gb.gridheight=1;
		this.panel.add(this.quitterpanel,gb);
		 gb=new GridBagConstraints();
		gb.gridx=80;
		gb.gridy=65;
		gb.gridwidth=1;
		gb.gridheight=1;
		gb.gridwidth=GridBagConstraints.REMAINDER;
		this.panel.add(this.panelboutton,gb);
		this.text.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent event)
			{	
			}
			public void keyReleased(KeyEvent event)
			{
				if (event.getKeyCode()==8)
				{
					String string;
					orto="";
					string =text.getText();
					for(int i=0;i<string.length();i++)
					{
						orto+=string.charAt(i);
					}
					text.setText(orto);
				}
			}
			public void keyTyped(KeyEvent arg0)
			{
				
			}
		});
  }
  
		public void Revalider()
		{
		  this.panele.removeAll();
		  this.panelbutton.removeAll();
		  this.panelmot.removeAll();
		  this.panelnom.removeAll();
		  this.panel.removeAll();
		  this.panelboutton.removeAll();
		  this.getContentPane().removeAll();
		  Afficheur();
		  Buttons();
		  GridBagConstraints gb=new GridBagConstraints();
			gb.gridx=0;
			gb.gridy=65;
			gb.gridwidth=1;
			gb.gridheight=1;
			this.panel.add(this.quitterpanel,gb);
			this.panelboutton.add(this.boutton);
			 gb=new GridBagConstraints();
			gb.gridx=80;
			gb.gridy=65;
			gb.gridwidth=1;
			gb.gridheight=1;
			gb.gridwidth=GridBagConstraints.REMAINDER;
			this.panel.add(panelboutton,gb);
			this.panele.add(this.label);
		  this.getContentPane().add(this.panele,BorderLayout.NORTH);
		  this.getContentPane().add(this.panel,BorderLayout.CENTER);
		  this.getContentPane().add(this.panelbutton,BorderLayout.SOUTH);
		  this.panele.revalidate();
		  this.panelboutton.revalidate();
		  this.panelbutton.revalidate();
		  this.panelmot.revalidate();
		  this.panelnom.revalidate();
		  this.panel.revalidate();
		  this.getContentPane().revalidate();
	}
  public void Buttons()
  {
	  for (int i=0;i<str.length;i++)
	  {
		  int a;
		  a=this.mot.indexOf(str[i]);

		  this.button[i]=new JButton(str[i]);
		  if (a<0 && (!this.button[i].getText().equals("EF")))
		   this.button[i].setEnabled(false);
		  this.button[i].setPreferredSize(dimension);
		  this.button[i].addActionListener(ecouteur);
		  this.panelbutton.setPreferredSize(new Dimension(300,200));
		  this.panelbutton.setBackground(Color.white);
		  this.panelbutton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.blue,Color.white),
				  BorderFactory.createMatteBorder(5,2,5,2,Color.red)));
		  this.panelbutton.add(this.button[i]);
	  }
  }
  class Ecouteur implements ActionListener
  {
	
	  public void actionPerformed(ActionEvent event)
	  {  
		 if (((JButton)event.getSource()).getText().equals("EF"))
		 {
			 String string;
			 orto="";
			string=text.getText();
			for(int i=0;i<string.length()-1;i++)
			{
				orto+=string.charAt(i);
			}
		 }
		 else
		 {
		   orto+=((JButton)event.getSource()).getText();
		 }
		 text.setText(orto); 
	  }
  }
	public void Afficheur()
	{
		//le layout principal
		//LE SCORE
	    	this.panel.setLayout(new GridBagLayout());
		    this.Scor.setBackground(Color.white);
		    this.Scor.setPreferredSize(new Dimension (120,40));
		    this.Scor.setBorder(BorderFactory.createTitledBorder("Score"));
			this.Scor.add(this.ls);
			GridBagConstraints gb=new GridBagConstraints();
			gb.gridx=0;
			gb.gridy=4;
			gb.gridwidth=1;
			gb.gridheight=1;
			gb.gridwidth=GridBagConstraints.REMAINDER;
			this.panel.add(this.Scor,gb);
		
	 // LE NOM DU JOUEUR
			
		//this.panelnom.setFont(font);
		this.panelnom.setPreferredSize(new Dimension(300,50));
		this.panelnom.setBackground(Color.white);
		this.nom=fene.getNomJoueur();
		this.labelnom.setText(this.nom);
		this.panelnom.setBorder(BorderFactory.createTitledBorder("Nom Du Joueur"));
		this.panelnom.add(this.labelnom);
		gb=new GridBagConstraints();
		gb.gridx=0;
		gb.gridy=0;
		gb.gridwidth=1;
		gb.gridheight=1;
		gb.gridwidth=GridBagConstraints.REMAINDER;
		this.panel.add(this.panelnom,gb);
		
		//LE MOT A CHERCHER

		panelmot.setPreferredSize(new Dimension (500,50));
		panelmot.setBackground(Color.white);
		panelmot.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.blue),
				BorderFactory.createMatteBorder(2,1,2,1,Color.red)));
		JLabel labelmot =new JLabel();
		JLabel dire=new JLabel("Mot Cach� : ");
		dire.setHorizontalAlignment(JLabel.CENTER);
		this.labelmotCache.setHorizontalAlignment(JLabel.CENTER);
		this.fich=new Fichiers();
		this.fich.Chercheur(this.getValeur());
		this.mot=this.fich.getmot();
		this.motSecret=this.fich.getmotSecret();
		this.labelmotCache.setText(this.motSecret);
		this.text.setPreferredSize(new Dimension(230,30));
		this.orto="";
		panelmot.add(dire);
		panelmot.add(labelmotCache);
		panelmot.add(this.text);
		gb=new GridBagConstraints();
		gb.gridx=0;
		gb.gridy=50;
		gb.gridwidth=2;
		gb.gridheight=2;
		this.panel.add(panelmot,gb);
		}
	
	class Action implements ActionListener
	{
		
		public void actionPerformed(ActionEvent event)
		{
				if (mot.equals(text.getText().toString()))
				{
					Score();
					Revalider();
					
				} 
				else
				{
					JOptionPane op =new JOptionPane();
					op.showMessageDialog(null," LE MOT ETAIT : "+mot,"MOT NON TROUV�",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("erreur.jpg"));
					Revalider();
				}
				System.out.println("le mot "+mot);
		}
	}
	class ActionMenu implements ActionListener
	{

		public void actionPerformed(ActionEvent event) 
		{
			if (((JRadioButtonMenuItem)event.getSource())==primaire)
			{
				valeur=5000;
				Revalider();
			}
			else if (((JRadioButtonMenuItem)event.getSource())==college)
			{
				valeur=15000;
				Revalider();
			}
			else if (((JRadioButtonMenuItem)event.getSource())==lycee)
			{
				valeur= 25000;
				Revalider();
			}
			else 
			{
				valeur=36000;
				Revalider();
			}
			
		}
		
	}
	class ActionQuitter implements ActionListener
	{

		public void actionPerformed(ActionEvent event) 
		{
			JOptionPane op=new JOptionPane();
			int a=op.showConfirmDialog(null,"VOULEZ VOUS QUITTER ?","QUITTER: OUI/NON",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon("quitter.jpg"));
	  if (a==(JOptionPane.YES_OPTION))
	  {
		  System.exit(0);
	  }
	  else
	  {
		  //NE RIEN FAIRE
	  }
		}
		
	}
	public int getValeur()
	{
		return this.valeur;
	}
	public void Score()
	{
		if (this.getValeur()==5000)
		this.score+=5;
		else if (this.getValeur()==15000)
			this.score+=10;
		else if (this.getValeur()==25000)
			this.score+=15;
		else if (this.getValeur()==36000)
			this.score+=20;
		this.ls.setText(""+this.score);
		this.Scor.add(this.ls);
		this.ms=new Meilleur_Scores(this.score,this.nom);
		if (!this.ms.MeilleurAffichage().equals(""))
		{
			System.out.println("VOUS AVEZ ATTEINT LE MEILLEUR SCOLRE ++ "+this.ms.MeilleurAffichage());
			this.label = new JLabel(this.ms.MeilleurAffichage());
			this.getContentPane().add(this.panele,BorderLayout.NORTH);
		}
			
	}
}
