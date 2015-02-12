package com.cse.warana.utility.infoExtractors;

        import com.cse.warana.utility.infoHolders.Profile;
        import org.junit.Assert;
        import org.junit.Test;

        import java.util.ArrayList;
        import java.util.HashMap;

/**
 * Created by Kelum Deshapriya on 2015-02-08.
 */
public class PersonalInfoExtractorTest {
    private HashMap<String,String> paths = new HashMap<>();
    private ArrayList<String> lines = new ArrayList<>();
    private ArrayList<Integer> headingLines = new ArrayList<>();
    private ArrayList<String> allHeadings = new ArrayList<>();
    private ArrayList<String> linesCopy = new ArrayList<>();
    private Profile profile = new Profile();

    public PersonalInfoExtractorTest(){
        paths.put("root","src/main/resources");
        paths.put("listPath","/gazeteerLists");

        lines.add("Personal Information");
        lines.add("Name: Susil Prashantha");
        lines.add("Gender: Male");
        lines.add("Other Heading");

        linesCopy.add("Personal Information");
        linesCopy.add("Name: Susil Prashantha");
        linesCopy.add("Gender: Male");
        linesCopy.add("Other Heading");

        headingLines.add(new Integer("0"));

        allHeadings.add("0");
        allHeadings.add("3");
    }

    @Test
    public void extractPersonalInformationTest(){
        PersonalInfoExtract personalInfoExtract = new PersonalInfoExtract(paths);
        personalInfoExtract.extractPersonalInformation(lines,headingLines,allHeadings,linesCopy,profile);
        int counter = 0;

        if (profile.getName().contains("susil prashantha")){
            counter ++;
        }
        if (profile.getGender().toLowerCase().equals("male")){
            counter++;
        }

        Assert.assertEquals(2,counter);
    }

    public static void main(String[] args){
        PersonalInfoExtractorTest personalInfoExtractorTest = new PersonalInfoExtractorTest();
        personalInfoExtractorTest.extractPersonalInformationTest();
    }

}

