package thompson.kyle.LfCodingChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class LfCodingChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LfCodingChallengeApplication.class, args);
	}

	RestTemplate restTemplate = new RestTemplate();

	private List<String> getSupervisorsFromAws() {

		String url = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";
		Supervisor[] supervisorsArray = this.restTemplate.getForObject(url, Supervisor[].class);

		List<Supervisor> supervisorsArrayList = Arrays.asList(supervisorsArray);
		Collections.sort(supervisorsArrayList);

		List<String> formattedSortedList = new ArrayList<String>();
		supervisorsArrayList.forEach(s -> {
			if (!s.getJurisdiction().matches("^[0-9]+$")) {
				formattedSortedList.add(s.toString());
			}
		});

		return formattedSortedList;
	}

	@GetMapping("/api/supervisors")
	@ResponseStatus(HttpStatus.OK)
	public List<String> supervisors() {
		return getSupervisorsFromAws();
	}

	@PostMapping(path = "/api/submit", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> submit(@ModelAttribute NotificationsForm request) {
		
		System.out.println(request.toString());

		try {
			FormValidator.validate(request);
			return new ResponseEntity<String>("Notification request submitted", HttpStatus.ACCEPTED);
		} catch (NotificationsFormException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
