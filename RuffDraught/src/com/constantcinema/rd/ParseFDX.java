package com.constantcinema.rd;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class ParseFDX{
	
	SAXParserFactory factory;
	SAXParser parser;
	Debug d;
	Vector<String> summaries = null;
	
	
	public ParseFDX(FileInputStream fileInputStream, Debug d) throws SAXException, ParserConfigurationException, IOException{
		
		try{
			factory = SAXParserFactory.newInstance();
			d = this.d;
			parser = factory.newSAXParser();
			FDXHandler handler = new FDXHandler();		
			parser.parse(fileInputStream, handler);
			summaries = handler.getSummaries();
		}
		catch(SAXException sx){
			d.writeConsole(sx.getMessage());
		}
		catch(ParserConfigurationException pcx){
			d.writeConsole(pcx.getMessage());
		}
		catch(IOException iox){
			d.writeConsole(iox.getMessage());
		}
	}
	
	public Vector<String> getSummaries(){
		return summaries;
	}
			
}
			


