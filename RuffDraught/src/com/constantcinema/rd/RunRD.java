package com.constantcinema.rd;

import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class RunRD {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		
		/**
		 * Args[1] -- File Path to source file, including source file name
		 * Args[2] -- File Path to target file
		 */
		Debug d = new Debug();
		
		
		try{			
			ChooseFDX choose = new ChooseFDX(d);
			ParseFDX p = new ParseFDX(choose.getFDX(),d);
			//p.getSummaries();
			Vector<String> vSummaries = new Vector<String>(p.getSummaries());
			//d.writeConsole("SUMMARIES:::");
			for(int i=vSummaries.size()-1;i>0;i--){
				if(!vSummaries.elementAt(i).equals("")){
				d.writeConsole(vSummaries.elementAt(i));
				d.writeConsole("***");			
				}				
			}
			choose.setFDX(vSummaries);
		}
		catch(IOException iox){
			d.writeConsole(iox.getMessage());
		}
		catch(SAXException sx){		
			d.writeConsole(sx.getMessage());
		}
		catch(ParserConfigurationException pcx){
			d.writeConsole(pcx.getMessage());
		}
		finally{
			//d.writeConsole("Run Complete");
			System.exit(0);
		}

		

	}
	

	

}
