package com.Fichier;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Fichiers 
{
private  String mot="";
 private String motSecret="";
 
 public Fichiers() {}
 public void Chercheur(int valeur)
 {
	 int i=(int)(Math.random()*valeur);
	 while(i>36000)
	 {
		i= i/2;
	 }
	 try
	 {
		 LineNumberReader ln=new LineNumberReader(new FileReader(new File("dictionnaire.txt")));
		int caractere;
    	while((caractere=ln.read())!=-1)
		{
				if (ln.getLineNumber() == i)
			{
				this.mot+=(char)(caractere);
			}
		}
    	this.mot=this.mot.trim().toUpperCase();
		for (int j=0;j<this.mot.length();j++)
		{
			if (j==4||j==9||j==11||j==14||j==17)
				this.motSecret+="*";
			else
				this.motSecret+=this.mot.charAt(j);	
		}
		 ln.close();
	 }
	 catch(FileNotFoundException e)
	 {
		 System.out.println("LE DOSSIER EST INTROUVABLE");
	 }
	 catch(IOException e)
	 {
		 System.out.println("Fichier non Trouver");
	 }
 }
 public String getmot()
 {
	 this.mot=this.mot.toUpperCase();
	 return this.mot;
 }
 public String getmotSecret()
 {
	 return this.motSecret;
 }
	
}
