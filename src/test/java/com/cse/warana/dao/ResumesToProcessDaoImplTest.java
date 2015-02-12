package com.cse.warana.dao;

import com.cse.warana.dto.ResumesToProcessDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
public class ResumesToProcessDaoImplTest {

    @Autowired
    @Qualifier("resumesToProcessDao")
    private ResumesToProcessDao resumesToProcessDao;

    @Rollback(true)
    public void getUploadedResumesTest(){
        List<ResumesToProcessDto> resumesToProcessDtoList = null;
        resumesToProcessDtoList = resumesToProcessDao.getUploadedResumes("NOT PROCESSED");
        Assert.assertEquals(2,resumesToProcessDtoList.size());
    }

    @Rollback(true)
    public void updateResumeStatusTest(){
        int id = -1;
        boolean check = false;
        id = resumesToProcessDao.updateResumeStatus("Sample File.pdf","PROCESSED");
        if (id > -1){
            check = true;
        }
        Assert.assertEquals(check,true);
    }
}
