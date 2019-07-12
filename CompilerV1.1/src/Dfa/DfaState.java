package Dfa;
import java.util.LinkedList;
import java.util.List;

public class DfaState extends State {
	public static final DfaState Main_Null_State = new DfaState("null");
	
	private boolean AcceptState=false;
	private List<DfaTransition> Transitions;
	
	public DfaState(String name, boolean acceptState) {
		super(name);
		AcceptState = acceptState;
		this.Transitions = new LinkedList<DfaTransition>();
	}
	public DfaState(String name) {
		super(name);
		this.Transitions = new LinkedList<DfaTransition>();
	}
	
	public boolean isAcceptState() {
		return this.AcceptState;
	}
	
	public DfaState AddTransition(DfaState state, char... Chr) {
		for (char i : Chr ) {
			DfaTransition TempTrans= new DfaTransition(state, i);
			if(Transitions.contains(TempTrans)) {
				continue;}
			
			Transitions.add(TempTrans);
		}
		return this;
	}
	
	public List<DfaState> Get_State(char Chr){
		List<DfaState> states= new LinkedList<DfaState>();
		for(DfaTransition trans: this.Transitions) {
			if(trans.getTransChar()==Chr) {
				states.add(trans.getState());
			}
		}
		if(states.isEmpty())
			states.add(Main_Null_State);
		
		return states;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (AcceptState ? 1231 : 1237);
		result = prime * result + ((Transitions == null) ? 0 : Transitions.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DfaState other = (DfaState) obj;
		if (AcceptState != other.AcceptState)
			return false;
		if (Transitions == null) {
			if (other.Transitions != null)
				return false;
		} else if (!Transitions.equals(other.Transitions))
			return false;
		return true;
	}
	
	
	

}
