package Dfa;

import java.util.LinkedList;
import java.util.List;

//import RunDfa.Result;

public class RunDfa {

	private final DfaState initial;
	
	public RunDfa(final DfaState initial) {
		this.initial = initial;
	}
	
	public DfaState getInitial() {
		return this.initial;
	}
	
	public Result testWord(final String word) {
		return testWord(getInitial(), word, 0, new Result(word));
	}
	
	private Result testWord(final DfaState state, final String word, final Integer index, final Result result) {
		result.addState(state);
		
		if (index >= word.length()) {
			return result;
		}
		
		final List<DfaState> states = state.Get_State(word.charAt(index));
		
		Result nextResult = null;
		for (DfaState next : states) {
			nextResult = testWord(next, word, index+1, result.clone());
			if (nextResult.isValid()) {
				return nextResult;
			}
		}

		return nextResult;
	}
	
	
	public class Result implements Cloneable {
		private String word;
		private List<DfaState> states;

		public Result(final String word) {
			this.word = word;
			this.states = new LinkedList<DfaState>();
		}

		public Boolean isValid() {
			return states.get(states.size()-1).isAcceptState();
		}

		public DfaState addState(DfaState state) {
			this.states.add(state);
			return state;
		}
		
		public List<DfaState> getStates() {
			return states;
		}

		public String getWord() {
			return word;
		}
		
		@Override
		public Result clone() {
			Result result = new Result(getWord());
			for (DfaState state : states) {
				result.addState(state);
			}
			return result;
		}
		
		public String toString() {
			StringBuffer string = new StringBuffer();
			for (int i = 0; i < word.length(); i++) {
				string.append("[");
				string.append(states.get(i).getName());
				string.append("]");
				string.append(" -- ");
				string.append(word.charAt(i));
				string.append(" --> ");
			}
			
			string.append("[");
			string.append(states.get(word.length()).getName());
			string.append("]");
			
			
			return string.toString();
		}
	}
}
