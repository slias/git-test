package com.course.business.controller.admin;

import com.course.server.domain.Chapter;
import com.course.server.domain.bo.PageBo;
import com.course.server.service.ChapterService;
import com.course.server.utils.CourseJsonResult;
import com.course.server.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Silas
 * Date: 2020/6/6
 * Time: 22:07
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @PostMapping("/list")
    public CourseJsonResult list(@RequestBody  PageBo pageBo){
        chapterService.list(pageBo);
        return  CourseJsonResult.ok(pageBo);
    }
}
