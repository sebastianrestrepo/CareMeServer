import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import processing.core.PApplet;

public class Firebase extends Thread {

	private PApplet app;
	private Calendar calendar;
	private int humidity, hour, minute, second;
	private HumidityModel hm;
	private Logic logic;
	private FileInputStream serviceAccount;
	private FirebaseOptions options;
	private DatabaseReference ref;
	private int delay;
	private String projectName;

	public Firebase(PApplet app, Logic logic) {
		this.logic = logic;
		this.app = app;

		delay = 120000/* logic.getUi().getTimeInt() * 60000 */;
		projectName = logic.getUi().getProjectName();
		System.out.println(projectName);
		try {
			serviceAccount = new FileInputStream("caremeapp-776bc-firebase-adminsdk-5xj4b-590add4628.json");
			options = new FirebaseOptions.Builder().setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
					.setDatabaseUrl("https://caremeapp-776bc.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initiateProject() {
		ref = FirebaseDatabase.getInstance().getReference();
	}

	@Override
	public void run() {
		while (true) {
			try {

				sendData();

				sleep(delay);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void sendData() {
		// if(app.frameCount % 1200 == 0) {
		calendar = Calendar.getInstance();

		humidity = logic.getA().getHumidity();

		hour = calendar.get(Calendar.HOUR_OF_DAY);
		minute = calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND);

		System.out.println("delay: " + delay);

		System.out.println("Humedad: " + humidity + " a la hora: " + hour + ":" + minute + ":" + second);

		if (logic.getUi().isPlay()) {
			ref.child(projectName).child("data").push().setValue(new HumidityModel(humidity, hour, minute));// escritura

			ref.child(projectName).child("idealh").setValue(logic.getUi().getIdealInt());
		}
		// de datos
		// }
		// ref.child(projectName).child("actualhumidity").push().setValue(humidity);
	}

	public void readData() {
		ref.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				HumidityModel post = dataSnapshot.getValue(HumidityModel.class);
				System.out.println("Post: " + post.getHumidity());
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				System.out.println("The read failed: " + databaseError.getCode());
			}
		});
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	// FINAL DE LA CLASE FIREBASE
}
