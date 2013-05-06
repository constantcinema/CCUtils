package com.constantcinema.rd;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FDXHandler extends DefaultHandler{
	

	Boolean isSummary = false;
	Boolean isText = false;
	Vector<String> vSummaries = new Vector<String>();

	Debug d = new Debug();
	
	public void startDocument()throws SAXException{
		//d.writeConsole("Start of FDX File");
	}
	
	public void endDocument(){
		//d.writeConsole("End of FDX File");
	}
	

	public void startElement(String uri, String localName, String qName, Attributes attributes){
		//d.writeConsole("Start Element: " + qName);
		if (qName.equals("Summary")){			
			isSummary = true;
		}
		if (qName.equals("Text")){			
			isText = true;
		}
	}

	public void endElement(String uri, String localName, String qName){
		//d.writeConsole("End Element: " + qName);
		if (qName.equals("Summary")){
			isSummary = false;
		}
		if (qName.equals("Text")){
			isText = false;
		}
	}
	
	public void characters(char ch[], int start, int length){
		String sElement = new String(ch,start,length);
		int i = 0;
		if (isSummary == true && isText == true && !sElement.equals("")){
			vSummaries.add(i,sElement);
			//d.writeConsole("SUMMARY TEXT: " + sElement);
			i++;
		}
		else{
			//d.writeConsole("ELEMENT TEXT: " + sElement);
		}
				
	}
	
	public Vector<String> getSummaries(){
		return vSummaries;
	}
	
}

