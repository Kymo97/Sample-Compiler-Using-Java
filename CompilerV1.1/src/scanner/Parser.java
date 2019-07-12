 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.util.*;
import java.io.IOException;
import scanner.Scanner_Op;

public class Parser {

	
	 ReadExcel ReadFile;
	 ArrayList<String> Non_Ter;
	 HashMap<String, String> parseTable;
	 HashMap<String, String> ErrorHandling; 
	 ArrayList<String> Errors;
	 
	 

	public Parser() {
        ReadExcel ReadFile= new ReadExcel("Parser-Table3.xls");
        try {
			ReadFile.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Non_Ter=ReadFile.getTerm();
         parseTable = ReadFile.getParseTable();
         ErrorHandling = ReadFile.getErrorMap();
		Errors= new ArrayList<String>();
	}




	public ArrayList<String> Pars(List<Token> Tokens) throws IOException {
        
		
        
       this.Errors.clear(); 
       //String [] input=new String[];
       List<String> Input1=new ArrayList<String>();
       Tokens.add(new Token("File","EOF",Tokens.size()));
       for(int i =0; i<Tokens.size();++i) {
    	   if(Tokens.get(i).getType().equals("Identifier")||Tokens.get(i).getType().equals("IntegerLiteral")) {
    		   //input[i]=Tokens.get(i).getType();
    		   Input1.add(Tokens.get(i).getType());
    		   
    	   }
    	   else if(Tokens.get(i).getType().equals("LineComment")||Tokens.get(i).getType().equals("PargComment")) {
    		   continue;
    	   }
    	   else
    	   {
    		   //input[i]=Tokens.get(i).getName();
    		   Input1.add(Tokens.get(i).getName());
    	   }  
       }
       //Input1.add("EOF");
       
        
        Stack<String> stack = new Stack<>();
        stack.push("$");
        stack.push("Program");
        for(int i=0;i<Input1.size();++i){
            while(true){
	            String top = stack.peek();
	            if(Non_Ter.contains(top)){
		                String temp = top+Input1.get(i);
		                temp = parseTable.get(temp);
		                if(temp ==null){
		                	Errors.add("Line:"+Tokens.get(i).lineNumber+"  Expected:"+ErrorHandling.get(top) +"  Found:"+Input1.get(i));
		                	break;
		                }
		                String [] t = temp.split(" ");
		                stack.pop();
		                for(int a = t.length-1; a>-1; --a){
		                    if(t[a].equals("''"))
		                        continue;
		                    stack.push(t[a]);
		                }
	            }
	            else if(Input1.get(i).equals(top)){
	                stack.pop(); 
	                break;
	            }
	            else{
	            	Errors.add("Line:"+Tokens.get(i).lineNumber+"  Expected1:"+top +"  Found:"+Input1.get(i));
	            	break;	 
	            }
           }
        }
 
    
       // System.out.println(Errors.size());
        return Errors ;
    }
    
}


/*if(!stack.peek().equals("$")){
    while(!stack.peek().equals("$")){
        String t = stack.peek() +"$";
        if(!parseTable.containsKey(t)) {
        	Errors.add("Not Parsable");
        	break;
        }
        String [] temp = parseTable.get(t).split("''");
        if(temp ==null){
        	Errors.add("Not Parsable");
        	break;
        }
        stack.pop();
    	}
    }*/
/*for(int i=0;i<Errors.size();++i) {
	System.out.println(Errors.get(i));
}*/

/*for(String key1 : parseTable.keySet()) {
String key = key1.toString();
String value = parseTable.get(key1).toString();
System.out.println(key+"---------------"+value);
}*/


/*parseTable.put("Exp(", "Term Exp_");
parseTable.put("Expnumber", "Term Exp_");
parseTable.put("Exp_)", "");
parseTable.put("Exp_+", "Addop Term Exp_");
parseTable.put("Exp_-", "Addop Term Exp_");
parseTable.put("Exp_$", "");
parseTable.put("Addop+", "+");
parseTable.put("Addop-", "-");
parseTable.put("Term(", "Factor Term_");
parseTable.put("Termnumber", "Factor Term_");
parseTable.put("Mulop*", "*");
parseTable.put("Factor(", "( Exp )");
parseTable.put("Factornumber", "number");
parseTable.put("Term_)", "");
parseTable.put("Term_+", "");
parseTable.put("Term_-", "");
parseTable.put("Term_*", "Mulop Factor Term_");
parseTable.put("Term_$", "");*/
