package com.constantcinema.rd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ChooseFDX {
	
	JFileChooser iChooser = new JFileChooser();
	JFileChooser oChooser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Final Draft Files", "fdx");
	
	Debug d;
	
	public ChooseFDX(Debug d){
		
		d = this.d;
		
		iChooser.setFileFilter(filter);
		iChooser.setDialogTitle("Select the Final Draft script you'd like to convert into a treatment.");
		iChooser.showOpenDialog(iChooser);
		
		oChooser.setDialogTitle("Choose the location and name for your treatment file.");
		oChooser.setCurrentDirectory(iChooser.getCurrentDirectory());
		oChooser.setSelectedFile(new File(GetFileName(iChooser.getSelectedFile().getName()) + " -- TREATMENT.txt"));
		oChooser.showSaveDialog(oChooser);
		
	}
	
	public FileInputStream getFDX() throws FileNotFoundException{
		
		FileInputStream iFDXPath = new FileInputStream(iChooser.getCurrentDirectory() + File.separator + iChooser.getSelectedFile().getName());
		return iFDXPath;		
	}
	public void setFDX(Vector<String> summaries) throws IOException{
		FileOutputStream oFDXPath = new FileOutputStream(oChooser.getSelectedFile());
		for(int i = summaries.size()-1; i >-1 ; i--){
			byte[] summary = summaries.elementAt(i).getBytes();
			oFDXPath.write(summary);
			oFDXPath.write(13);
			oFDXPath.write(13);
		}		
		oFDXPath.close();
	}
	
	private String GetFileName(String x){
		if(x.indexOf(".")>0){
			x = x.substring(0,x.lastIndexOf("."));
		}
		return x;
	}
	
}


