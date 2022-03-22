package com.BoiteDialogue;

public class RecuperNome
{
	private String nom;
	public RecuperNome(){};
	public RecuperNome(String bangs)
	{
		this.nom=bangs;
	}
	public String toString()
	{
		String str;
		if (this.nom==null)
		{
			str="AUCUNE INFORMATION SAISIE";
			System.exit(0);
		}
		else
		 str=" NOM DU JOUEUR "+this.nom;
		return str;
		
	}
	public String getNomJoueure()
	{
		return this.nom;
	}
}
