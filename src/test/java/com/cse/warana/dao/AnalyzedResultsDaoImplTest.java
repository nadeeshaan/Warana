package com.cse.warana.dao;

import com.cse.warana.dto.*;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import java.util.List;

@Test
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
public class AnalyzedResultsDaoImplTest {

    @Autowired
    @Qualifier("analyzedResults")
    private AnalyzedResultsDao analyzedResultsDao;

    @Rollback(true)
    public void getAnalyzedResultsTest(){
        List<AnalyticResultsDTO> analyticResultsDTOList = null;
        analyticResultsDTOList = analyzedResultsDao.getAnalyzedResults();

        Assert.assertNotNull(analyticResultsDTOList);
    }

    @Rollback(true)
    public void getCandidateProfileDataTest(){
        List<CandidateDTO> candidateDTOList = null;
        candidateDTOList = analyzedResultsDao.getCandidateProfileData(1);
        Assert.assertEquals(1,candidateDTOList.size());
    }

    @Rollback(true)
    public void getCandidateAchievementsDataTest(){
        List<AchievementDTO> achievementDTOList = null;
        achievementDTOList = analyzedResultsDao.getCandidateAchievementsData(1);
        Assert.assertEquals(4,achievementDTOList.size());
    }

    @Rollback(true)
    public void getCandidateEducationDataTest(){
        List<EducationDTO> educationDTOList = null;
        educationDTOList = analyzedResultsDao.getCandidateEducationData(1);
        org.testng.Assert.assertEquals(3,educationDTOList.size());
    }

    @Rollback(true)
    public void getCandidateProjectDataTest(){
        List<ProjectDTO> projectDTOList = null;
        projectDTOList = analyzedResultsDao.getCandidateProjectData(1);
        Assert.assertEquals(5,projectDTOList.size());
    }

    @Rollback(true)
    public void getCandidatePublicationsDataTest(){
        List<PublicationsDTO> publicationsDTOList = null;
        publicationsDTOList = analyzedResultsDao.getCandidatePublicationsData(1);
        Assert.assertEquals(2,publicationsDTOList.size());
    }

    @Rollback(true)
    public void getCandidateWorkExperienceDataTest(){
        List<WorkExpDTO> workExpDTOList = null;
        workExpDTOList = analyzedResultsDao.getCandidateWorkExperienceData(1);
        Assert.assertEquals(1,workExpDTOList.size());
    }
}
