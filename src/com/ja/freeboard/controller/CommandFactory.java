package com.ja.freeboard.controller;

import com.ja.freeboard.controller.command.*;
import java.util.*;

public class CommandFactory {
	
	private HashMap<String,CommandHandler> commandMap;
	
	
	public CommandFactory() {
		commandMap = new HashMap<String,CommandHandler>();
		
		commandMap.put("/login_page.do",new LoginPageHandler());
		commandMap.put("/join_member_page.do",new JoinMemberPageHandler());
		commandMap.put("/join_member_process.do",new JoinMemberProcessHandler());
		commandMap.put("/login_process.do",new LoginProcessHandler());
		commandMap.put("/main_page.do", new MainPageHandler());
		commandMap.put("/logout_process.do", new LogoutProcessHandler());
	}
	
	public CommandHandler getCommandHandler(String command) {
		
		return commandMap.get(command);
		
		
		
	}
	
	

}
