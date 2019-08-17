package stepdefinition;

import org.junit.After;
import org.junit.Before;

import com.google.common.collect.ImmutableSet;
import com.webcerebrium.slack.Notification;
import com.webcerebrium.slack.NotificationException;
import com.webcerebrium.slack.SlackMessage;
import com.webcerebrium.slack.SlackMessageAttachment;

import cucumber.TestContext;
import io.cucumber.core.api.Scenario;

public class Hooks {
	TestContext testContext;
	Scenario scenario;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@After
	public void AfterSteps(Scenario scenario) {
		this.scenario = scenario;
		SlackMessage message = new SlackMessage();
		SlackMessageAttachment attach;
		if (scenario.getStatus().equals("failed")) {
			attach = new SlackMessageAttachment(scenario.getName(), "Scenario *FAILED* :sob: " + scenario.getName(),
					"#c11e0f");
		} else {
			attach = new SlackMessageAttachment(scenario.getName(),
					"Scenario *PASSED* :patrick-star: " + scenario.getName(), "#c11e0f");
		}
		attach.addMarkdown(ImmutableSet.of("title", "text"));
		message.getAttachments().add(attach);

		try {
			if (true) {
				(new Notification("https://hooks.slack.com/services/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"))
						.send(message);
			}

		} catch (NotificationException e) {
			System.out.println("Slack error");
			e.printStackTrace();
		}
		// testContext.getWebDriverManager().closeDriver();

	}

	@Before
	public void BeforeSteps(Scenario scenario) {
		this.scenario = scenario;
		SlackMessage message = new SlackMessage();
		SlackMessageAttachment attach = new SlackMessageAttachment(scenario.getName(),
				"Starting execution on " + System.getProperty("os.name"), "#2062ad");
		attach.addMarkdown(ImmutableSet.of("title", "text"));
		message.getAttachments().add(attach);
		try {
			(new Notification("https://hooks.slack.com/services/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"))
					.send(message);
		} catch (NotificationException e) {
			System.out.println("Faced some error");
			e.printStackTrace();
		}
	}

}
