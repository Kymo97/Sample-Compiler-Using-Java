package Dfa;

public class DfaTransition {
	private DfaState state;
	private char  TransChar;
	public DfaTransition(DfaState state, char transChar) {
		this.state = state;
		TransChar = transChar;
	}
	public DfaState getState() {
		return state;
	}
	public char getTransChar() {
		return TransChar;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TransChar;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DfaTransition other = (DfaTransition) obj;
		if (TransChar != other.TransChar)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	
	
	

}
