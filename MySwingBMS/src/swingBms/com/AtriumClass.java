package swingBms.com;

public class AtriumClass extends RoomClass{
	protected String moveSensor;
	protected Boolean mSensorStat;
	AtriumClass(){
		super();
		setAtriumDef();
	}
	public String getMoveSensor() {
		return moveSensor;
	}
	public void setMoveSensor(String moveSensor) {
		this.moveSensor = moveSensor;
	}
	public Boolean getmSensorStat() {
		return mSensorStat;
	}
	public void setmSensorStat(Boolean mSensorStat) {
		this.mSensorStat = mSensorStat;
	}
	
	private void setAtriumDef(){
		setMoveSensor("Czujnik ruchu");
	}
	

}
