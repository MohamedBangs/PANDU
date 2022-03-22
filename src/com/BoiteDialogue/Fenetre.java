package com.BoiteDialogue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Fenetre extends JFrame
{
	private  Entrer entre= new Entrer(null,"BOITE",true);
	private  RecuperNome re=entre.Affiche(); 
	public Fenetre()
	{
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 JOptionPane option=new JOptionPane();
		 option.showMessageDialog(null,re.toString(),"INFORMATION DU JOUEUR",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("nom.jpg"));
	}
	 public String getNomJoueur()
		{
			return this.re.getNomJoueure();
		}

}
