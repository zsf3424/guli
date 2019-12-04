package com.atguigu.guli.service.edu.service;

import com.atguigu.guli.service.edu.entity.Course;
import com.atguigu.guli.service.edu.entity.CourseInfoForm;
import com.atguigu.guli.service.edu.entity.vo.CoursePublishVo;
import com.atguigu.guli.service.edu.entity.vo.CourseQueryVo;
import com.atguigu.guli.service.edu.entity.vo.WebCourseQueryVo;
import com.atguigu.guli.service.edu.entity.vo.WebCourseVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author zsf
 * @since 2019-11-20
 */
public interface CourseService extends IService<Course> {

    /**
     * 保存课程和课程详情信息
     * @param courseInfoForm
     * @return 新生成的课程id
     */
    String saveCourseInfo(CourseInfoForm courseInfoForm);

    CourseInfoForm getCourseInfoFormById(String id);

    void updateCourseInfoById(CourseInfoForm courseInfoForm);

    void selectPage(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    void removeCourseById(String id);

    CoursePublishVo getCoursePublishVoById(String id);

    void publishCourseById(String id);

    Map<String,Object> webSelectPage(Page<Course> pageParam, WebCourseQueryVo webCourseQueryVo);

    /**
     * 获取课程信息并更新浏览量
     * @param id
     * @return
     */
    WebCourseVo selectWebCourseVoById(String id);

}
