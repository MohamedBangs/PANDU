package com.FENETRE;
import com.BoiteDialogue.RecuperNome;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Meilleur_Scores 
{
	private String nom;
	private int controlscore=0;
	private String meilleur="";
	public Meilleur_Scores(int scores,String nom1)
	{
		 this.controlscore=scores;
		 this.nom=nom1;
		 this.Meilleur();
	}
	public void Meilleur()
	{
		  try
		  {
			 FileReader fr=new FileReader(new File("MeileurScores.txt"));
			       int a;
			       String st="";
			       int b=0;
			       while((a=fr.read())!=-1)
			       {
			    	   b=(int)(a);
			       }
			      //int b=Integer.valueOf(st).intValue();	 
			      System.out.println("A ++ "+b);
				  if (this.controlscore > b)
				  {
					  this.meilleur="VOUS AVEZ DEPASSEZ LE MEILLEUR SCORE !!! FELICITAITION";
					  FileWriter fw=new FileWriter(new File("MeileurScores.txt"));
					  FileWriter frw=new FileWriter(new File("NOM.txt"));
					  frw.write(this.nom);
					  fw.write(this.controlscore);
					  frw.close();
			          fw.close();
			          this.meilleur="VOUS AVEZ DEPASSEZ LE MEILLEUR SCORE !!! FELICITAITION";
			  }
			  
		  }catch(FileNotFoundException e)
		  {
			  System.out.println("LE FICHIER EST INTROUVABLE");
		  }
		  catch(IOException e)
		  {
			  System.out.println("LE FICHIER EST INTROUVABLE");
		  }
	}
 
  public String getMeilleurScore()
  {
	  String str="";
	  String string="";
	  String string2="";
	  try
	  {
		  FileReader fr=new FileReader(new File("MeileurScores.txt"));
		  FileReader frn=new FileReader(new File("NOM.txt"));
		  int a;
		  while((a=fr.read())!=-1)
		  {
			string+=(int)a;  
		  }
		  while((a=frn.read())!=-1)
		  {
			string2+=(char)a;  
		  }
			  str+=string2+" A LE MEILLEUR SCORE : ";
			  str+=string;
		      str+=" POINTS";
	  }
	  catch(FileNotFoundException e)
	  {
		  JOptionPane op=new JOptionPane();
		  op.showMessageDialog(null,"FICHIER DU SCORE INTROUVABLE","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
	  }
	  catch(IOException e)
	  {
		  JOptionPane op=new JOptionPane();
		  op.showMessageDialog(null,"FICHIER DU SCORE INTROUVABLE","INFORMATION",JOptionPane.INFORMATION_MESSAGE);  
	  }
	  return str;
  }
  public String MeilleurAffichage()
  {
	  return this.meilleur;
  }
}
