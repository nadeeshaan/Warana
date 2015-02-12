package com.cse.warana.utility.infoExtractors;

        import com.cse.warana.utility.infoHolders.Education;
        import org.junit.Test;

        import java.util.ArrayList;
        import java.util.HashMap;

/**
 * Created by Kelum Deshapriya on 2015-02-08.
 */
public class EducationalInfoExtractTest {

    private HashMap<String,String> paths = new HashMap<>();
    private ArrayList<String> lines = new ArrayList<>();
    private ArrayList<Integer> headingLines = new ArrayList<>();
    private ArrayList<String> allHeadings = new ArrayList<>();
    private ArrayList<String> linesCopy = new ArrayList<>();
    private ArrayList<Education> educations = new ArrayList<>();

    public EducationalInfoExtractTest(){
        paths.put("root","src/main/resources");
        paths.put("listPath","/gazeteerLists");

        lines.add("Educational Qualifications");
        lines.add("Mahinda College, Galle");
        lines.add("From: May 2007");
        lines.add("To: June 2009");
        lines.add("Other Heading");

        linesCopy.add("Educational Qualifications");
        linesCopy.add("Mahinda College, Galle");
        linesCopy.add("From: May 2007");
        linesCopy.add("To: June 2009");
        linesCopy.add("Other Heading");

        headingLines.add(new Integer("0"));

        allHeadings.add("0");
        allHeadings.add("4");
    }

    @Test
    public void extractEduInformationTest(){
        EducationalInfoExtract educationalInfoExtract = new EducationalInfoExtract(paths);
        educationalInfoExtract.extractEduInformation(lines,headingLines,allHeadings,linesCopy,educations);
        org.junit.Assert.assertEquals(1, educations.size());
    }

    public static void main(String[] args){
        EducationalInfoExtractTest educationalInfoExtractTest = new EducationalInfoExtractTest();
        educationalInfoExtractTest.extractEduInformationTest();
    }
}

