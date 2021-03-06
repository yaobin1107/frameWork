package cn.yb.edu.mapper;

import cn.yb.edu.model.Course;
import cn.yb.edu.model.CourseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Tue Jun 11 20:38:35 CST 2019
     */
    int countByExample(CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Tue Jun 11 20:38:35 CST 2019
     */
    int deleteByExample(CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Tue Jun 11 20:38:35 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Tue Jun 11 20:38:35 CST 2019
     */
    int insert(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Tue Jun 11 20:38:35 CST 2019
     */
    int insertSelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Tue Jun 11 20:38:35 CST 2019
     */
    List<Course> selectByExample(CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Tue Jun 11 20:38:35 CST 2019
     */
    Course selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Tue Jun 11 20:38:35 CST 2019
     */
    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Tue Jun 11 20:38:35 CST 2019
     */
    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Tue Jun 11 20:38:35 CST 2019
     */
    int updateByPrimaryKeySelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Tue Jun 11 20:38:35 CST 2019
     */
    int updateByPrimaryKey(Course record);
}