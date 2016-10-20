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
		}else if("delete".equals(actionName)){
			action = new deleteAction();
		}else if("modifyform".equals(actionName)){
			action = new ModifyformAction();
		}else if("modify".equals(actionName)){
			action = new ModifyAction();
		}else if("rewrite".equals(actionName)){
			action = new RewriteAction();
		}else if("rewrite1".equals(actionName)){
			action = new Rewrite1Action();
		}else{
			action = new ListAction();
		}
		return action;
	}

}
