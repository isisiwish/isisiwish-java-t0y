package top.cfish.sso.server.dao;

import top.cfish.sso.server.model.User;

/**
 * @author: isisiwish
 * @date: 2019/03/28
 * @time: 20:03
 */
public interface UserMapper
{
    User find(User user);
    /**
     *
     * @mbggenerated 2019/03/28
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019/03/28
     */
    int insert(User record);

    /**
     *
     * @mbggenerated 2019/03/28
     */
    int insertSelective(User record);

    /**
     *
     * @mbggenerated 2019/03/28
     */
    User selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019/03/28
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbggenerated 2019/03/28
     */
    int updateByPrimaryKey(User record);
}
