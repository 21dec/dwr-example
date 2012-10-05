package net.daum.smooth.dwr;

import java.util.Calendar;
import java.util.Collection;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.ScriptProxy;
import org.springframework.stereotype.Service;

@Service
public class DWRMemberService {

	public String getA() {
		return "aaaaa";
	}

	public String getB() {
		return "bbbbb";
	}

	public String getC() {
		return "ccccc";
	}

	public void shout() {
		long time = Calendar.getInstance().getTimeInMillis();
		notifyAllClient("update", time);
	}

	private void notifyAllClient(String funcName, long time) {
		getScriptProxy().addFunctionCall(funcName, time);

	}

	private ScriptProxy getScriptProxy() {
		WebContext ctx = WebContextFactory.get();
		Collection<ScriptSession> sessions = ctx.getScriptSessionsByPage(ctx.getCurrentPage());
		return new ScriptProxy(sessions);
	}
}
