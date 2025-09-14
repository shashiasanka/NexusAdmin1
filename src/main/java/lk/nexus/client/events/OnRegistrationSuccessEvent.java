package lk.nexus.client.events;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import lk.nexus.client.models.Register;



public class OnRegistrationSuccessEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private String appUrl;
	private Locale locale;
	private Register user;

	public OnRegistrationSuccessEvent(Register user, Locale locale, String appUrl) {
		super(user);
		this.user = user;
		this.locale = locale;
		this.appUrl = appUrl;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Register getUser() {
		return user;
	}

	public void setUser(Register user) {
		this.user = user;
	}

	
}
