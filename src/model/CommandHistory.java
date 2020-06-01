package model;

import java.util.Stack;

public class CommandHistory {
	Stack<Command> previousCommands = new Stack<Command>();
	    
	public void push (Command c) {
		previousCommands.push(c);
	}
	public Command pop () {
		return previousCommands.pop();
	}
	public void empty () {
		 previousCommands.clear();
	}
	public Stack<Command> getStack () {
		return this.previousCommands;
	}
}
