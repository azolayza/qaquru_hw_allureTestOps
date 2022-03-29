package com.azovcevae.tests.allure;

import com.azovcevae.pages.Layer;
import com.azovcevae.pages.WebSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

@Layer("web")
@Owner("eroshenkoam")
@Feature("Issues")
@Disabled
public class IssuesAllureWebTest {
        private static final String OWNER = "allure-framework";
        private static final String REPO = "allure2";

        private static final String ISSUE_TITLE = "Some issue title here";

        private final WebSteps steps = new WebSteps();

        @BeforeEach
        public void startDriver() {
            steps.startDriver();
        }

        @Test
        @Story("Create new issue")
        @Tags({@Tag("web"), @Tag("critical")})
        @DisplayName("Creating new issue authorized user")
        public void shouldCreateIssue() {
            steps.openIssuesPage(OWNER, REPO);
            steps.createIssueWithTitle(ISSUE_TITLE);
            steps.shouldSeeIssueWithTitle(ISSUE_TITLE);
        }

        @Test
        @Story("Create new issue")
        @Tags({@Tag("web"), @Tag("regress")})
        @DisplayName("Adding note to advertisement")
        public void shouldAddLabelToIssue() {
            steps.openIssuesPage(OWNER, REPO);
            steps.createIssueWithTitle(ISSUE_TITLE);
            steps.shouldSeeIssueWithTitle(ISSUE_TITLE);
        }

        @Test
        @Story("Close existing issue")
        @Tags({@Tag("web"), @Tag("regress")})
        @DisplayName("Closing new issue for authorized user")
        public void shouldCloseIssue() {
            steps.openIssuesPage(OWNER, REPO);
            steps.createIssueWithTitle(ISSUE_TITLE);
            steps.closeIssueWithTitle(ISSUE_TITLE);
            steps.shouldNotSeeIssueWithTitle(ISSUE_TITLE);
        }

        @AfterEach
        public void stopDriver() {
            steps.stopDriver();
        }
}
