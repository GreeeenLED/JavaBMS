package swingBms.com;

public class RoomClass {
	
	public String light;
	public Boolean lightStatus;
	protected String fan;
	protected Boolean fanStatus;
	protected String window;
	protected Boolean windowStatus;
	
	RoomClass(){
		//defaults
		setLight("Swiatlo");
		setFan("Wentylator");
		setWindow("Okno");
		setLightStatus(false);
		setFanStatus(false);
		setWindowStatus(false);
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public Boolean getLightStatus() {
		return lightStatus;
	}

	public void setLightStatus(Boolean lightStatus) {
		this.lightStatus = lightStatus;
	}

	public String getFan() {
		return fan;
	}

	public void setFan(String fan) {
		this.fan = fan;
	}

	public Boolean getFanStatus() {
		return fanStatus;
	}

	public void setFanStatus(Boolean fanStatus) {
		this.fanStatus = fanStatus;
	}

	public String getWindow() {
		return window;
	}

	public void setWindow(String window) {
		this.window = window;
	}

	public Boolean getWindowStatus() {
		return windowStatus;
	}

	public void setWindowStatus(Boolean windowStatus) {
		this.windowStatus = windowStatus;
	}
	
	
	

}
