package com.cse.warana.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
public class GetUploadedDocDoaImplTest {

    @Autowired
    @Qualifier("getUploadeDocDao")
    private GetUploadedDocDao getUploadedDocDao;

    @Rollback(true)
    public void getDocumentListTest(){
        List<String> docList = null;
        docList = getUploadedDocDao.getDocumentList();
        Assert.assertEquals(2,docList.size());
    }

}
