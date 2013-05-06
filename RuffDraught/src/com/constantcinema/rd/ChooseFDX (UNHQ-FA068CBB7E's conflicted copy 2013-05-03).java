package com.constantcinema.rd;

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
	FileNameExtensionFilter iFilter = new FileNameExtensionFilter("Final Draft Files", "fdx");
	
	Debug d;
	
	public ChooseFDX(Debug d){
		d = this.d;
		iChooser.setFileFilter(iFilter);
		iChooser.showOpenDialog(iChooser);
		iChooser.setDialogTitle("Choose an FDX File to Convert into a Treatment");
		oChooser.showSaveDialog(oChooser);
	}
	
	public FileInputStream getFDX() throws FileNotFoundException{
		
		FileInputStream iFDXPath = new FileInputStream(iChooser.getCurrentDirectory() + "\\" + iChooser.getSelectedFile().getName());
		return iFDXPath;		
	}
	public void setFDX(Vector<String> summaries) throws IOException{
		FileOutputStream oFDXPath = new FileOutputStream(oChooser.getSelectedFile());//(oChooser.getCurrentDirectory() + "\\" + iChooser.getSelectedFile().getName());
		for(int i = summaries.size()-1; i > 0; i--){
			byte[] summary = summaries.elementAt(i).getBytes();
			oFDXPath.write(summary);
			oFDXPath.write(13);
			oFDXPath.write(13);
		}		
		oFDXPath.close();
		//return oFDXPath;
		
	}
	
	
}


