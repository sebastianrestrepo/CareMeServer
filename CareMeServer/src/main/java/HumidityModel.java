
public class HumidityModel {

	private int humidity, hour, minute;

	public HumidityModel(int humidity, int hour, int minute) {
		this.humidity = humidity;
		this.hour = hour;
		this.minute = minute;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

}
