package com.cse.warana.dao;

import com.cse.warana.dto.ViewStatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
public class ViewStatDaoImplTest {

    @Autowired
    @Qualifier("viewStatDao")
    private ViewStatDao viewStatDao;

    @Rollback(true)
    public void getViewStatDaoListTest(){
        List<ViewStatDTO> viewStatDTOList = null;
        viewStatDTOList = viewStatDao.getViewStatDaoList();

        for (int a = 0; a < viewStatDTOList.size(); a++){
            boolean check = false;
            if (Integer.parseInt(viewStatDTOList.get(a).getScore())!=0){
                check = true;
            }
            Assert.assertEquals(true, check);
        }
    }

    @Rollback(true)
    public void getTechnologiesListTest(){
        List<String> techList = null;
        techList = viewStatDao.getTechnologiesList();
        Assert.assertNotNull(techList);
    }

    @Rollback(true)
    public void getAdvSearchResultsTest(){
        List<ViewStatDTO> viewStatDTOList = null;
        String[] techArr = {"java","mysql","c#","ruby","php"};
        viewStatDTOList = viewStatDao.getAdvSearchResults(techArr);

        for (int a = 0; a < viewStatDTOList.size(); a++){
            Assert.assertNotNull(viewStatDTOList.get(a));
        }
    }
}
