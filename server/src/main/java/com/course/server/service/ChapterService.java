package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.domain.bo.PageBo;
import com.course.server.mapper.ChapterMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Silas
 * Date: 2020/6/6
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    public void list(PageBo pageBo){

        PageHelper.startPage(pageBo.getPage(),pageBo.getSize());

        Example chapterExample = new Example(Chapter.class);
        chapterExample.orderBy("id").desc();
        Example.Criteria criteria = chapterExample.createCriteria();

        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);

        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterList);
        pageBo.setTotal(pageInfo.getTotal());
        pageBo.setList(chapterList);

    }
}
