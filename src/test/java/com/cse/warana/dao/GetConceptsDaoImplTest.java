package com.cse.warana.dao;

import com.cse.warana.dto.CompanyTechnologyViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
public class GetConceptsDaoImplTest {

    @Autowired
    @Qualifier("getConceptsDao")
    private GetConceptsDao getConceptsDao;

    @Rollback
    public void getConceptsListTest(){
        List<String> conceptList = null;
        conceptList = getConceptsDao.getConceptsList();
        Assert.assertEquals(1356,conceptList.size());
    }

    @Rollback
    public void getTechnologyListTest(){
        List<String> technologyList = null;
        technologyList = getConceptsDao.getTechnologyList();
        Assert.assertEquals(35,technologyList.size());
    }

    @Rollback
    public void getCompanyTechnologiesWithScoreTest(){
        List<CompanyTechnologyViewDTO> companyTechnologyViewDTOs = null;
        companyTechnologyViewDTOs = getConceptsDao.getCompanyTechnologiesWithScore();
        for (int a = 0; a < companyTechnologyViewDTOs.size(); a++){
            float x = companyTechnologyViewDTOs.get(a).getScore();
            boolean y = false;
            if(x>0){
                y = true;
            }
            Assert.assertEquals(true,y);
        }
    }


}
