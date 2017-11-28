import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;

public class Firebase {

	public Firebase() {

		FileInputStream serviceAccount;
		try {
			serviceAccount = new FileInputStream("caremeapp-776bc-firebase-adminsdk-5xj4b-590add4628.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
					.setDatabaseUrl("https://caremeapp-776bc.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// FINAL DE LA CLASE FIREBASE
}
