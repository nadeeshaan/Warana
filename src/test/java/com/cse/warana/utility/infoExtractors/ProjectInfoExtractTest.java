package com.cse.warana.utility.infoExtractors;

import com.cse.warana.utility.infoHolders.Project;
import com.cse.warana.utility.infoHolders.Technology;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nadeeshaan on 2015-02-08.
 */
public class ProjectInfoExtractTest {
    private HashMap<String, String> paths = new HashMap<>();
    private ArrayList<String> lines = new ArrayList<>();
    private ArrayList<Integer> headingLines = new ArrayList<>();
    private ArrayList<String> allHeadings = new ArrayList<>();
    private ArrayList<String> linesCopy = new ArrayList<>();
    private ArrayList<String> candidateTechnologies = new ArrayList<>();
    private ArrayList<Project> projects = new ArrayList<>();
    private ArrayList<Technology> techs = new ArrayList<>();

    public ProjectInfoExtractTest() {
        paths.put("root", "src/main/resources");
        paths.put("listPath", "/gazeteerLists");

        lines.add("Projects Involved");
        lines.add("This is Sample Project");
        lines.add("This is Sample description");
        lines.add("Technologies: java, mysql, c, c#");
        lines.add("Other Heading");

        linesCopy.add("Projects Involved");
        linesCopy.add("This is Sample Project");
        linesCopy.add("This is Sample description");
        linesCopy.add("Technologies: java, mysql, c, c#");
        linesCopy.add("Other Heading");

        headingLines.add(new Integer("0"));

        allHeadings.add("0");
        allHeadings.add("4");

        ArrayList<String> technologies = new ArrayList<>();
        technologies.add("java");
        technologies.add("mysql");
        technologies.add("c");
        technologies.add("c#");
        technologies.add("php");
        ArrayList<String> descriptiveTerms = new ArrayList();
        descriptiveTerms.add("sample Term1");
        descriptiveTerms.add("sample Term2");

        for (int a = 0; a < technologies.size(); a++) {
            Technology t = new Technology();
            t.setName(technologies.get(a));
            t.setDescriptiveTerms(descriptiveTerms);

            techs.add(t);
        }

        techs.add(new Technology());
    }

    @Test
    public void extractPersonalInformationTest() {
        ProjectInfoExtraction projectInfoExtraction = new ProjectInfoExtraction(paths);
        projectInfoExtraction.extractProjectInfo(lines, headingLines, allHeadings, linesCopy, candidateTechnologies, projects, techs);

        int counter = 0;

        if (projects.size() == 1 && projects.get(0).getName().toLowerCase().contains("this is sample project") && projects.get(0).getDescription().toLowerCase().equals("this is sample description")) {
            counter++;
        }

        Assert.assertEquals(1, counter);
    }

    public static void main(String[] args) {
        ProjectInfoExtractTest projectInfoExtractTest = new ProjectInfoExtractTest();
        projectInfoExtractTest.extractPersonalInformationTest();
    }
}

