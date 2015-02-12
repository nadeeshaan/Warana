package com.cse.warana.dao;

import com.cse.warana.dto.ResumesToAnalyseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
public class AnalyzeResumeDaoImplTest {
    @Autowired
    @Qualifier("analyzeResumeDao")
    private AnalyzeResumeDao analyzeResumeDao;

    @Rollback(true)
    public void getResumesToBeAnalyzedTest(){
        List<ResumesToAnalyseDto> resumesToAnalyseDtoList = null;
        resumesToAnalyseDtoList = analyzeResumeDao.getResumesToBeAnalyzed();
        Assert.assertEquals(3,resumesToAnalyseDtoList.size());
    }

    @Rollback(true)
    public void getTechnologyListOfCandidateTest(){
        List<String> technologyList = null;
        technologyList = analyzeResumeDao.getTechnologyListOfCandidate(new Long(1));
        Assert.assertEquals(15,technologyList.size());
    }
}
