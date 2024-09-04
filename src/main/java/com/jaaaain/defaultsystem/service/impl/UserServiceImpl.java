package com.jaaaain.defaultsystem.service.impl;

service.impl;

import .entity.User;
import .mapper.UserMapper;
import .service.UserService;
import com.jaaaain.defaultsystem.mapper.UserMapper;
import com.jaaaain.defaultsystem.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 * @since 2024-09-04 12:25:46
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return userMapper.queryById(id);
    }

    /**
     * 分页查询
     * @param user 筛选条件
     * @return 查询结果
     */
    @Override
    public PageBean queryByLimit(Integer page, Integer size, User user) {
        PageHelper.startPage(page, size); // 将下一条搜索改为查count和limit两条
        List<User> list = userMapper.queryAllByLimit(user);  // 得到的数据直接为PageBean类型
        Page<User> p = (Page<User>) list;  // 强制类型转换
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /**
     * 新增数据
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        userMapper.insert(user);
        return user;
    }

    /**
     * 修改数据
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        userMapper.update(user);
        return queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return userMapper.deleteById(id) > 0;
    }
}
