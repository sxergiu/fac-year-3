package org.loose.good.refactoring.optional.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loose.good.refactoring.optional.model.Author;
import org.loose.good.refactoring.optional.model.Commit;
import org.loose.good.refactoring.optional.model.File;
import org.loose.good.refactoring.optional.model.Project;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProjectServiceTest {

    private static final String EXISTING_PROJECT_ID = "demo";
    private static final String NON_EXISTING_PROJECT_ID = "nothing";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ProjectService projectService;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));

        projectService = new ProjectService();
        projectService.setProjectRepository(new TestProjectRepository());
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void printProjectDetailsThatExists() {
        projectService.printProjectDetails(EXISTING_PROJECT_ID);
        assertEquals(String.format("Project ID: %s\nProject name: %s", EXISTING_PROJECT_ID, TestProjectCreator.DEMO_PROJECT_NAME),
                outContent.toString());
    }

    @Test
    public void printProjectDetailsThatDoesNotExists() {
        projectService.printProjectDetails(NON_EXISTING_PROJECT_ID);
        assertTrue(outContent.toString().isEmpty());
    }

    @Test
    public void getCommitNamesForExistingProject() {
        List<String> commitNamesForProject = projectService.getCommitNamesForProject(EXISTING_PROJECT_ID);
        List<String> expectedCommits = Arrays.asList("a1ef4g6", "b3fd567", "n432cde", "u321vdf", "u3218ds");
        assertEquals(expectedCommits, commitNamesForProject);
    }

    @Test(expected = NoSuchProjectException.class)
    public void getCommitNamesForNonExistingProject() {
        projectService.getCommitNamesForProject(NON_EXISTING_PROJECT_ID);
    }

    @Test
    public void getFirstAuthorNameForExistingProject() {
        String firstAuthorNameForProject = projectService.getFirstAuthorNameForProject(EXISTING_PROJECT_ID);
        assertEquals("Samantha Blind", firstAuthorNameForProject);
    }

    @Test(expected = NoSuchProjectException.class)
    public void getFirstAuthorNameForNonExistingProject() {
        projectService.getFirstAuthorNameForProject(NON_EXISTING_PROJECT_ID);
    }

    @Test
    public void getNumberOfFilesInExistingProject() {
        int numberOfFilesInProject = projectService.getNumberOfFilesInProject(EXISTING_PROJECT_ID);
        assertEquals(4, numberOfFilesInProject);
    }

    @Test
    public void getNumberOfFilesInNonExistingProject() {
        int numberOfFilesInProject = projectService.getNumberOfFilesInProject(NON_EXISTING_PROJECT_ID);
        assertEquals(-1, numberOfFilesInProject);
    }

    private static class TestProjectRepository implements ProjectRepository {

        @Override
        public Project getProjectByID(String projectID) {
            if (projectID.contains("demo"))
                return new TestProjectCreator(projectID).createDemoProject();

            return null;
        }
    }

    private static class TestProjectCreator {
        static final String DEMO_PROJECT_NAME = "Demo project Name";
        private String projectID;

        private Author john = new Author("John Doe", "john.doe@email.com");
        private Author samantha = new Author("Samantha Blind", "samblind@email.com");

        private File file1 = new File("demo/src/main/java/org/example/demo/Demo.java");
        private File file2 = new File("demo/src/main/resources/config.xml");
        private File file3 = new File("demo/src/test/java/org/example/demo/DemoTest.java");
        private File file4 = new File("demo/src/test/resources/testFile.txt");

        private Date firstCommitDate;
        private Date secondCommitDate;
        private Date thirdCommitDate;
        private Date forthCommitDate;
        private Date fifthCommitDate;

        private TestProjectCreator(String projectID) {
            this.projectID = projectID;

            Calendar calendar = Calendar.getInstance();
            calendar.set(2019, Calendar.DECEMBER, 2);
            firstCommitDate = calendar.getTime();
            calendar.set(2019, Calendar.DECEMBER, 3);
            secondCommitDate = calendar.getTime();
            calendar.set(2019, Calendar.DECEMBER, 5);
            thirdCommitDate = calendar.getTime();
            calendar.set(2019, Calendar.DECEMBER, 11);
            forthCommitDate = calendar.getTime();
            calendar.set(2019, Calendar.DECEMBER, 18);
            fifthCommitDate = calendar.getTime();
        }

        private Project createDemoProject() {
            return new Project(projectID, DEMO_PROJECT_NAME, Arrays.asList(john, samantha),
                    createDemoCommits(), Arrays.asList(file1, file2, file3, file4));
        }

        private List<Commit> createDemoCommits() {
            return Arrays.asList(new Commit("a1ef4g6", firstCommitDate, samantha),
                    new Commit("b3fd567", secondCommitDate, john),
                    new Commit("n432cde", thirdCommitDate, samantha),
                    new Commit("u321vdf", forthCommitDate, john),
                    new Commit("u3218ds", fifthCommitDate, samantha));
        }

    }
}