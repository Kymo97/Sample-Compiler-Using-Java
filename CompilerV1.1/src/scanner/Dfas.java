package scanner;

import Dfa.DfaState;
import Dfa.RunDfa;

public class Dfas {
	
	
	 static public boolean ReservedWords(String Testing_Word) {
		 
		DfaState s1 = new DfaState("s1");
		DfaState s2 = new DfaState("s2");
		DfaState s3 = new DfaState("s3");
		DfaState s4 = new DfaState("s4");
		DfaState s5 = new DfaState("s5",true);
		DfaState s6 = new DfaState("s6");
		DfaState s7 = new DfaState("s7");
		DfaState s8 = new DfaState("s8");
		DfaState s9 = new DfaState("s9");
		DfaState s10 = new DfaState("s10");
		DfaState s11= new DfaState("s11");
		DfaState s12 = new DfaState("s12");
		DfaState s13= new DfaState("s13");
		DfaState s14= new DfaState("s14");
		DfaState s15= new DfaState("s15");
		DfaState s16= new DfaState("s16");
		DfaState s17= new DfaState("s17");
		DfaState s18= new DfaState("s18");
		DfaState s19= new DfaState("s19");
		DfaState s20= new DfaState("s20");
		DfaState s21= new DfaState("s21");
		DfaState s22= new DfaState("s22");
		DfaState s23= new DfaState("s23");
		DfaState s24= new DfaState("s24");
		DfaState s25= new DfaState("s25");
		DfaState s26= new DfaState("s26");
		DfaState s27= new DfaState("s27");
		DfaState s28= new DfaState("s28");
		DfaState s29= new DfaState("s29");
		DfaState s30= new DfaState("s30");
		DfaState s31= new DfaState("s31");
		DfaState s32= new DfaState("s32");
		DfaState s33= new DfaState("s33");
		DfaState s34= new DfaState("s34");
		
		DfaState s35= new DfaState("s35");
		DfaState s36= new DfaState("s36");
		DfaState s37= new DfaState("s37");
		
		DfaState s38= new DfaState("s38");
		DfaState s39= new DfaState("s39");
		DfaState s40= new DfaState("s40");
		
		
		DfaState s41= new DfaState("s41");
		DfaState s42= new DfaState("s42");
		DfaState s43= new DfaState("s43");
		DfaState s44= new DfaState("s44");
		
		DfaState s45= new DfaState("s45");
		DfaState s46= new DfaState("s46");
		DfaState s47= new DfaState("s47");
		DfaState s48= new DfaState("s48");
		
		//s1 Transitions
		s1.AddTransition(s12, 'i');
		//s1.AddTransition(s13, 'm');
		s1.AddTransition(s15, 'r');
		s1.AddTransition(s17, 't');
		s1.AddTransition(s11, 'c');
		s1.AddTransition(s18, 'v');
		s1.AddTransition(s19, 'w');
		s1.AddTransition(s14, 'p');
		s1.AddTransition(s16, 's');
		s1.AddTransition(s33, 'n');
		s1.AddTransition(s35, 'e');
		s1.AddTransition(s38, 't');
		s1.AddTransition(s41, 'f');
		
		
		
		//s2 Transitions
		s2.AddTransition(s5, 's');
		//s3 Transitions
		s3.AddTransition(s5, 'd');
		//s4 Transitions
		s4.AddTransition(s8, 'l');
		//s6 Transitions
		s6.AddTransition(s9, 'i');
		//s7 Transitions
		s7.AddTransition(s10, 'r');
		//s8 Transitions
		s8.AddTransition(s5, 'e');
		//s9 Transitions
		s9.AddTransition(s5, 'c');
		//s10 Transitions
		s10.AddTransition(s5, 'n');
		//s11 Transitions
		s11.AddTransition(s20, 'l');
		//s12 Transitions
		s12.AddTransition(s5, 'f');
		s12.AddTransition(s21, 'n');
		//s13 Transitions
		s13.AddTransition(s22, 'a');
		//s14 Transitions
		s14.AddTransition(s23, 'u');
		//s15 Transitions
		s15.AddTransition(s24, 'e');
		//s16 Transitions
		s16.AddTransition(s25, 't');
		//s17 Transitions
		s17.AddTransition(s26, 'h');
		//s18 Transitions
		s18.AddTransition(s27, 'o');
		//s19 Transitions
		s19.AddTransition(s28, 'h');
		//s20 Transitions
		s20.AddTransition(s29, 'a');
		//s21 Transitions
		s21.AddTransition(s5, 't');
		//s22 Transitions
		s22.AddTransition(s10, 'i');
		//s23 Transitions
		s23.AddTransition(s30, 'b');
		//s24 Transitions
		s24.AddTransition(s31, 't');
		//s25 Transitions
		s25.AddTransition(s32, 'a');
		//s26 Transitions
		s26.AddTransition(s2, 'i');
		//s27 Transitions
		s27.AddTransition(s3, 'i');
		//s28 Transitions
		s28.AddTransition(s4, 'i');
		//s6 Transitions
		s29.AddTransition(s2, 's');
		//s30 Transitions
		s30.AddTransition(s6, 'l');
		//s31 Transitions
		s31.AddTransition(s7, 'u');
		//s32 Transitions
		s32.AddTransition(s6, 't');
		//s33 Transitions
		s33.AddTransition(s34, 'e');
		//s32 Transitions
		s34.AddTransition(s5, 'w');
		//s35 Transitions
		s35.AddTransition(s36, 'l');
		//s36 Transitions
		s36.AddTransition(s37, 's');
		//s37 Transitions
		s37.AddTransition(s5, 'e');
		//s38 Transitions
		s38.AddTransition(s39, 'r');
		//s39 Transitions
		s39.AddTransition(s40, 'u');
		//s40 Transitions
		s40.AddTransition(s5, 'e');
		//s41 Transitions
		s41.AddTransition(s42, 'a');
		//s42 Transitions
		s42.AddTransition(s43, 'l');
		//s43 Transitions
		s43.AddTransition(s44, 's');
		//s40 Transitions
		s44.AddTransition(s5, 'e');
		
		s1.AddTransition(s45, 'm');
		s45.AddTransition(s46, 'a');
		s46.AddTransition(s47, 'i');
		s47.AddTransition(s5, 'n');
		
		
		RunDfa x = new RunDfa(s1);
		return x.testWord(Testing_Word).isValid();
		
	}


	 static public boolean DataTypes(String Testing_Word) {

		 
		DfaState s1 = new DfaState("s1");
		DfaState s2 = new DfaState("s2");
		DfaState s3 = new DfaState("s3");
		DfaState s4 = new DfaState("s4");
		DfaState s5 = new DfaState("s5");
		DfaState s6 = new DfaState("s6");
		DfaState s7 = new DfaState("s7");
		DfaState s8 = new DfaState("s8");
		DfaState s9 = new DfaState("s9",true);
		DfaState s10 = new DfaState("s10");
		DfaState s11= new DfaState("s11");
		DfaState s12 = new DfaState("s12");
		DfaState s13= new DfaState("s13");
		DfaState s14= new DfaState("s14");
		DfaState s15= new DfaState("s15");
		
		//s1 Transition
		s1.AddTransition(s2, 'b');
		s1.AddTransition(s3, 'i');
		s1.AddTransition(s4, 'S');
		
		//s2 Transition
		s2.AddTransition(s5, 'o');
		//s2 Transition
		s3.AddTransition(s6, 'n');
		//s4 Transition
		s4.AddTransition(s7, 't');
		//s5 Transition
		s5.AddTransition(s8, 'o');
		//s6 Transition
		s6.AddTransition(s9, 't');
		//s7 Transition
		s7.AddTransition(s10, 'r');
		//s8 Transition
		s8.AddTransition(s11, 'l');
		//s10 Transition
		s10.AddTransition(s12, 'i');
		//s11 Transition
		s11.AddTransition(s13, 'e');
		//s12 Transition
		s12.AddTransition(s14, 'n');
		//s13 Transition
		s13.AddTransition(s15, 'a');
		//s14 Transition
		s14.AddTransition(s9, 'g');
		//s15 Transition
		s15.AddTransition(s9, 'n');
		
		RunDfa x = new RunDfa(s1);
		return x.testWord(Testing_Word).isValid();
		
	 }
	 
	 static public boolean Identifiers(String Testing_Word) {
		 
			DfaState s1 = new DfaState("s1");
			DfaState s2 = new DfaState("s2",true);
			
			//s1 Transition
			s1.AddTransition(s2, 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s'
					,'t','u','v','w','x','y','z');	
			//s2 Transition
			s2.AddTransition(s2, 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s'
					,'t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','_');
			
			RunDfa x = new RunDfa(s1);
			return x.testWord(Testing_Word).isValid();
			
			
	 }
	 
	 static public boolean Operators(String Testing_Word) {
		DfaState s1 = new DfaState("s1");
		DfaState s2 = new DfaState("s2");
		DfaState s3 = new DfaState("s3",true);
		
		//s1 Transition
		s1.AddTransition(s3, '-','<','+','*');
		s1.AddTransition(s2, '&');
		
		//s2 Transition
		s2.AddTransition(s3,'&');
				
		RunDfa x = new RunDfa(s1);
		return x.testWord(Testing_Word).isValid();
	 }
	
	 static public boolean Symbols(String Testing_Word) {
		DfaState s1 = new DfaState("s1");
		DfaState s2 = new DfaState("s2",true);
		 
		//s1 Transition
		s1.AddTransition(s2, '{','}','(',')','[',']',';','=','!','.',',');
		
		RunDfa x = new RunDfa(s1);
		return x.testWord(Testing_Word).isValid();	 }
	 
	 static public boolean Integers(String Testing_Word) {
		 
			DfaState s1 = new DfaState("s1");
			DfaState s2 = new DfaState("s2",true);
			 
			//s1 Transition
			s1.AddTransition(s2, '0','1','2','3','4','5','6','8','9');
			//s2 Transition
			s2.AddTransition(s2, '0','1','2','3','4','5','6','8','9');
			
			RunDfa x = new RunDfa(s1);
			return x.testWord(Testing_Word).isValid();
		 
	 }
}
