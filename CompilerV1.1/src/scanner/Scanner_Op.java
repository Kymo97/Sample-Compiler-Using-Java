package scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Dfa.DfaTransition;
public class Scanner_Op {

	 ArrayList<String> Errors= new ArrayList<String>();
	
	public static List<Token> Toknized() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader("Code.txt"));
		String FilteredLine="";
		String Line = reader.readLine();
		int LineCounter=1;
		int TokenNumber=0;
		boolean ComFlag=true;
		boolean CommentFlag=true;
		List<Token> Tokens= new LinkedList<Token>();
		
		System.out.println("Line_Number\t"+"Word\t"+"Token");
		while(Line!=null) {
			//System.out.println(Line);
			Line=Line.replace("//", " // ");
			Line=Line.replace("/*", " /* ");
			Line=Line.replace("*/", " */ ");
			Line=Line.replace("&&", " && ");
			
			StringBuilder MainString= new StringBuilder();
			
			for (int i=0;i<Line.length();++i) {
				if(Line.charAt(i)=='<'||Line.charAt(i)=='+'||Line.charAt(i)=='-'||Line.charAt(i)=='('||Line.charAt(i)==')'
				||Line.charAt(i)=='['||Line.charAt(i)==']'||Line.charAt(i)==';'||Line.charAt(i)=='{'||Line.charAt(i)=='}'||Line.charAt(i)=='.'
				||Line.charAt(i)=='='||Line.charAt(i)=='!'||Line.charAt(i)==',') {
					MainString.append(" "+Line.charAt(i)+" ");
				}
				else if (Line.charAt(i)=='*'&&(Line.charAt(i-1)!='/'||Line.charAt(i+1)!='/'))
					MainString.append(Line.charAt(i));
				else {
					MainString.append(Line.charAt(i));
				}
			}
			FilteredLine=MainString.toString();
			String []SplitedString=FilteredLine.split(" ");
			
			for(int i=0;i<SplitedString.length;++i) {
				if(SplitedString[i].isEmpty())
					continue;
				if(SplitedString[i].equals("*/")) {
					ComFlag=true;
					CommentFlag=true;
					Tokens.add(new Token("PargComment", SplitedString[i], LineCounter));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Comment");
				}
				else if(SplitedString[i].equals("/*")||!ComFlag) {
					ComFlag=false;
					if(CommentFlag) {
						CommentFlag=false;
						Tokens.add(new Token("PargComment", SplitedString[i], LineCounter));
						//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Comment");
					}
					continue;}
				
				else if (SplitedString[i].equals("//")) {
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Comment");
					Tokens.add(new Token("LineComment", SplitedString[i], LineCounter));
					break;
				}
				else if (Dfas.ReservedWords(SplitedString[i])) {
					Tokens.add(new Token("ReservedWord", SplitedString[i], LineCounter));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"ReservedWords");
				}
				else if (Dfas.DataTypes(SplitedString[i])) {
					Tokens.add(new Token("DataType", SplitedString[i], LineCounter));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"DataType");
				}
				else if (Dfas.Identifiers(SplitedString[i].toLowerCase())) {
					Tokens.add(new Token("Identifier", SplitedString[i], LineCounter));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Identifier");
				}
				else if (Dfas.Integers(SplitedString[i])) {
					Tokens.add(new Token("Integer", SplitedString[i], LineCounter));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Integers");
				}
				else if (Dfas.Operators(SplitedString[i])) {
					Tokens.add(new Token("Operator", SplitedString[i], LineCounter));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Operators");
				}
				else if (Dfas.Symbols(SplitedString[i])) {
					Tokens.add(new Token("Symbol", SplitedString[i], LineCounter));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Symbols");
				}
				else {
					Tokens.add(new Token("Error", SplitedString[i], LineCounter));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Error");
				}
				
				TokenNumber++;
			}
			
			//System.out.println(FilteredLine);
			
			LineCounter++;
			Line=reader.readLine();
		}
		//System.out.println("Token Number:"+TokenNumber);
		
		return Tokens;
		
		
	}

	
	public ArrayList<String> getErrors() {
		return Errors;
	}



	private void setErrors(ArrayList<String> errors) {
		Errors = errors;
	}

	public List<Token> Toknized2(String []reader) throws Exception{
		//BufferedReader reader = new BufferedReader(new FileReader("Code.txt"));
		
		String FilteredLine="";
		String Line = reader[0];
		int LineCounter=0;
		int TokenNumber=0;
		boolean ComFlag=true;
		boolean CommentFlag=true;
		List<Token> Tokens= new LinkedList<Token>();
		
		System.out.println("Line_Number\t"+"Word\t"+"Token");
		while(LineCounter<reader.length) {
			Line=reader[LineCounter];
			//System.out.println(Line);
			Line=Line.replace("//", " // ");
			Line=Line.replace("/*", " /* ");
			Line=Line.replace("*/", " */ ");
			Line=Line.replace("&&", " && ");
			if(Line.contains("System.out.println")) {
				Line=Line.replace("System.out.println", "");
				Tokens.add(new Token("ReservedWord", "System.out.println", LineCounter));
			}
			
			StringBuilder MainString= new StringBuilder();
			
			for (int i=0;i<Line.length();++i) {
				if(Line.charAt(i)=='<'||Line.charAt(i)=='+'||Line.charAt(i)=='-'||Line.charAt(i)=='('||Line.charAt(i)==')'
				||Line.charAt(i)=='['||Line.charAt(i)==']'||Line.charAt(i)==';'||Line.charAt(i)=='{'||Line.charAt(i)=='}'||Line.charAt(i)=='.'
				||Line.charAt(i)=='='||Line.charAt(i)=='!'||Line.charAt(i)==',') {
					MainString.append(" "+Line.charAt(i)+" ");
				}
				else if (Line.charAt(i)=='*'&&(Line.charAt(i-1)!='/'||Line.charAt(i+1)!='/'))
					MainString.append(Line.charAt(i));
				else {
					MainString.append(Line.charAt(i));
				}
			}
			FilteredLine=MainString.toString();
			String []SplitedString=FilteredLine.split(" ");
			

			for(int i=0;i<SplitedString.length;++i) {
				if(SplitedString[i].isEmpty())
					continue;
				if(SplitedString[i].equals("*/")) {
					ComFlag=true;
					CommentFlag=true;
					Tokens.add(new Token("PargComment", SplitedString[i], (LineCounter-(LineCounter/2))));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Comment");
				}

				else if(SplitedString[i].equals("/*")||!ComFlag) {
					ComFlag=false;
					if(CommentFlag) {
						CommentFlag=false;
						Tokens.add(new Token("PargComment", SplitedString[i], (LineCounter-(LineCounter/2)+1)));
						//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Comment");
					}
					continue;}
				
				else if (SplitedString[i].equals("//")) {
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Comment");
					Tokens.add(new Token("LineComment", SplitedString[i], (LineCounter-(LineCounter/2)+1)));
					break;
				}
				else if (Dfas.ReservedWords(SplitedString[i])) {
					Tokens.add(new Token("ReservedWord", SplitedString[i], (LineCounter-(LineCounter/2)+1)));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"ReservedWords");
				}
				else if (Dfas.DataTypes(SplitedString[i])) {
					Tokens.add(new Token("DataType", SplitedString[i], (LineCounter-(LineCounter/2)+1)));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"DataType");
				}
				else if (Dfas.Identifiers(SplitedString[i].toLowerCase())) {
					Tokens.add(new Token("Identifier", SplitedString[i], (LineCounter-(LineCounter/2)+1)));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Identifier");
				}
				else if (Dfas.Integers(SplitedString[i])) {
					Tokens.add(new Token("IntegerLiteral", SplitedString[i], (LineCounter-(LineCounter/2)+1)));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Integers");
				}
				else if (Dfas.Operators(SplitedString[i])) {
					Tokens.add(new Token("Operator", SplitedString[i], (LineCounter-(LineCounter/2)+1)));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Operators");
				}
				else if (Dfas.Symbols(SplitedString[i])) {
					Tokens.add(new Token("Symbol", SplitedString[i], (LineCounter-(LineCounter/2)+1)));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Symbols");
				}
				else {
					Tokens.add(new Token("Error", SplitedString[i], (LineCounter-(LineCounter/2)+1)));
					//System.out.println(LineCounter+"\t"+SplitedString[i]+"\t"+"Error");
				}
				
				TokenNumber++;
			}
			LineCounter++;
			//System.out.println(FilteredLine);	
		}
		//System.out.println("Token Number:"+TokenNumber);
		//setErrors(Parser.Pars(Tokens));
		return Tokens;
		
		
	}
}
