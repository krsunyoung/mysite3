package com.bit2016.mysite.action.board;

import com.bit2016.web.Action;
import com.bit2016.web.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if("write".equals(actionName)){
			action = new WriteformAction();
		}else if("write1".equals(actionName)){
			action = new WriteAction();
		}else if("view".equals(actionName)){
			action = new viewAction();
		}else{
			action = new ListAction();
		}
		return action;
	}

}
