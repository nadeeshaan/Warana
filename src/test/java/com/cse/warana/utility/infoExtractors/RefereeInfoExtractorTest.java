package com.cse.warana.utility.infoExtractors;

import com.cse.warana.utility.infoHolders.Referee;
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
public class RefereeInfoExtractorTest {
    private HashMap<String, String> paths = new HashMap<>();
    private ArrayList<String> lines = new ArrayList<>();
    private ArrayList<Integer> headingLines = new ArrayList<>();
    private ArrayList<String> allHeadings = new ArrayList<>();
    private ArrayList<String> linesCopy = new ArrayList<>();
    private ArrayList<Referee> referees = new ArrayList<>();
    private AbstractSequenceClassifier classifier = null;

    public RefereeInfoExtractorTest() {
        paths.put("root", "src/main/resources");
        paths.put("listPath", "/gazeteerLists");

        lines.add("Non Related Referees");
        lines.add("Dr. Saman Nandasiri");
        lines.add("Senior Software Engineer");
        lines.add("saman@gmail.com");
        lines.add("Other Heading");

        linesCopy.add("Non Related Referees");
        linesCopy.add("Dr. Saman Nandasiri");
        linesCopy.add("Senior Software Engineer");
        linesCopy.add("saman@gmail.com");
        linesCopy.add("Other Heading");

        headingLines.add(new Integer("0"));

        allHeadings.add("0");
        allHeadings.add("4");

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
    public void extractRefereeInformationTest() {
        int counter = 0;
        RefereeInfoExtract refereeInfoExtract = new RefereeInfoExtract(classifier);
        refereeInfoExtract.getRefereeInfo(lines, headingLines, allHeadings, linesCopy, referees);

        if (referees.size() == 1) {
            counter++;
        }
        if (referees.get(0).getName().equals("Dr. Saman Nandasiri")) {
            counter++;
        }
        if (referees.get(0).getEmail().equals("saman@gmail.com")) {
            counter++;
        }

        Assert.assertEquals(3, counter);

    }

    public static void main(String[] args) {
        RefereeInfoExtractorTest refereeInfoExtractorTest = new RefereeInfoExtractorTest();
        refereeInfoExtractorTest.extractRefereeInformationTest();
    }
}

