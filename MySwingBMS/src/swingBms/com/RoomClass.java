package swingBms.com;

public class RoomClass {
	
	public String light;
	public String lightStatus;
	protected String fan;
	protected String fanStatus;
	protected String window;
	protected String windowStatus;
	
	RoomClass(){
		//defaults
		setLight("Swiatlo");
		setFan("Wentylator");
		setWindow("Okno");
		setLightStatus("def");
		setFanStatus("def");
		setWindowStatus("def");
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getLightStatus() {
		return lightStatus;
	}

	public void setLightStatus(String lightStatus) {
		this.lightStatus = lightStatus;
	}

	public String getFan() {
		return fan;
	}

	public void setFan(String fan) {
		this.fan = fan;
	}

	public String getFanStatus() {
		return fanStatus;
	}

	public void setFanStatus(String fanStatus) {
		this.fanStatus = fanStatus;
	}

	public String getWindow() {
		return window;
	}

	public void setWindow(String window) {
		this.window = window;
	}

	public String getWindowStatus() {
		return windowStatus;
	}

	public void setWindowStatus(String windowStatus) {
		this.windowStatus = windowStatus;
	}
	
	
	

}
