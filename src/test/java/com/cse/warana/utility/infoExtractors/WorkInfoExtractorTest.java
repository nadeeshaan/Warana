package com.cse.warana.utility.infoExtractors;

import com.cse.warana.utility.infoHolders.Work;
import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nadeeshaan on 2015-02-08.
 */
public class WorkInfoExtractorTest {
    private HashMap<String, String> paths = new HashMap<>();
    private ArrayList<String> lines = new ArrayList<>();
    private ArrayList<Integer> headingLines = new ArrayList<>();
    private ArrayList<String> allHeadings = new ArrayList<>();
    private ArrayList<String> linesCopy = new ArrayList<>();
    private ArrayList<Work> worksList = new ArrayList<>();
    private AbstractSequenceClassifier classifier = null;

    public WorkInfoExtractorTest() {
        paths.put("root", "src/main/resources");
        paths.put("listPath", "/gazeteerLists");

        lines.add("Sample Text Line");
        lines.add("Sample Text Line");
        lines.add("Sample Text Line");
        lines.add("Work Experience Involved");
        lines.add("Trainee Software Engineer at WSO2 Lanka (Pvt) Ltd");
        lines.add("From: May 14,2012");
        lines.add("To: May 14,2013");
        lines.add("Other Heading");
        lines.add("Sample Text Line");
        lines.add("Sample Text Line");
        lines.add("Sample Text Line");

        linesCopy.add("Sample Text Line");
        linesCopy.add("Sample Text Line");
        linesCopy.add("Sample Text Line");
        linesCopy.add("Work Experience Involved");
        linesCopy.add("Trainee Software Engineer at WSO2 Lanka (Pvt) Ltd");
        linesCopy.add("From: May 14,2012");
        linesCopy.add("To: May 14,2013");
        linesCopy.add("Other Heading");
        lines.add("Sample Text Line");
        lines.add("Sample Text Line");
        lines.add("Sample Text Line");

        headingLines.add(new Integer("3"));

        allHeadings.add("3");
        allHeadings.add("7");

        String serializedClassifier = paths.get("root") + File.separator + "classifiers" + File.separator + "english.muc.7class.distsim.crf.ser.gz";
        try {
            classifier = CRFClassifier.getClassifier(serializedClassifier);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void extractWorkInformationTest() {
        int counter = 0;
        WorkInfoExtract workInfoExtract = new WorkInfoExtract(classifier, paths);
        workInfoExtract.extractWorkInfo(lines, headingLines, allHeadings, linesCopy, worksList);

        if (worksList.size() == 1 && worksList.get(0).getCompanyName().equals("wso2 lanka")) {
            counter++;
        }
        Assert.assertEquals(1, counter);
    }

    public static void main(String[] args) {
        WorkInfoExtractorTest workInfoExtractorTest = new WorkInfoExtractorTest();
        workInfoExtractorTest.extractWorkInformationTest();
    }
}

