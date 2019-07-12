package Dfa;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DfaState z1 = new DfaState("z1");
		DfaState z2 = new DfaState("z2",true);
		//FiniteState z3 = new FiniteState("z3");
		//FiniteState z4 = new FiniteState("z4");
		
		
		//z3.setFinal();
		
		z1.AddTransition(z2, 'a','b','c', 'd','e','f', 'g','h','i');
		
		z2.AddTransition(z2, 'a','b','c', 'd','e','f', 'g','h','i');
		//z2.addTransition(z3, 'f');
		//z2.addTransition(z4, 'n');
		
		//z4.addTransition(z3, 't');
		
		RunDfa automat = new RunDfa(z1);
		
		System.out.println(automat.testWord("").isValid());

		
		
	}

}