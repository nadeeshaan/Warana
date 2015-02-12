package com.cse.warana.dao;

import com.cse.warana.utility.infoHolders.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Test
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
public class GetTechnologyIdDaoImplTest {

    @Autowired
    @Qualifier("getTechnologyIdDao")
    private GetTechnologyIdDao getTechnologyIdDao;

    @Rollback(true)
    public void getCurrentTechnologyIdsTest() {

        List<String> techIdList = null;
        List<Technology> technologyList = new ArrayList<>();
        String[] techArr = {"java", "mysql", "c#", "ruby"};

        for (int a = 0; a < techArr.length; a++) {
            Technology t = new Technology();
            t.setName(techArr[a]);
            technologyList.add(t);
        }

        techIdList = getTechnologyIdDao.getCurrentTechnologyIds(technologyList);
        Assert.assertEquals(technologyList.size(), techIdList.size());
    }

    @Rollback(true)
    public void getTechnologyIdMapTest() {
        Map<String, Long> techIdMap = null;
        List<Technology> technologyList = new ArrayList<>();
        String[] techArr = {"java", "mysql", "c#", "ruby"};

        for (int a = 0; a < techArr.length; a++) {
            Technology t = new Technology();
            t.setName(techArr[a]);
            technologyList.add(t);
        }

        techIdMap = getTechnologyIdDao.getTechnologyIdMap(technologyList);

        for (int a = 0; a < techArr.length; a++) {
            boolean check = false;
            if (techIdMap.containsKey(techArr[a])) {
                check = true;
            }
            Assert.assertEquals(true, check);
        }
    }

    @Rollback(true)
    public void getCompanyTechnologyScoreMapTest(){
        Map<Integer, Double> techScoreMap = null;
        techScoreMap = getTechnologyIdDao.getCandidateTechnologyScoreMap(new Long(1));
        Assert.assertNotNull(techScoreMap);
    }
}
