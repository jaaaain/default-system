package com.jaaaain.defaultsystem.service.impl;

service.impl;

import .entity.DefaultChecklist;
import .mapper.DefaultChecklistMapper;
import .service.DefaultChecklistService;
import com.jaaaain.defaultsystem.mapper.DefaultChecklistMapper;
import com.jaaaain.defaultsystem.service.DefaultChecklistService;
import org.springframework.stereotype.Service;

/**
 * 违约认定人工审核表(DefaultChecklist)表服务实现类
 * @since 2024-09-04 12:25:46
 */
@Service("defaultChecklistService")
public class DefaultChecklistServiceImpl implements DefaultChecklistService {

    @Autowired
    private DefaultChecklistMapper defaultChecklistMapper
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DefaultChecklist queryById(Integer id) {
        return defaultChecklistMapper.queryById(id);
    }

    /**
     * 分页查询
     * @param defaultChecklist 筛选条件
     * @return 查询结果
     */
    @Override
    public PageBean queryByLimit(Integer page, Integer size, DefaultChecklist defaultChecklist) {
        PageHelper.startPage(page, size); // 将下一条搜索改为查count和limit两条
        List<DefaultChecklist> list = defaultChecklistMapper.queryAllByLimit(defaultChecklist);  // 得到的数据直接为PageBean类型
        Page<DefaultChecklist> p = (Page<DefaultChecklist>) list;  // 强制类型转换
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /**
     * 新增数据
     * @param defaultChecklist 实例对象
     * @return 实例对象
     */
    @Override
    public DefaultChecklist insert(DefaultChecklist defaultChecklist) {
        defaultChecklistMapper.insert(defaultChecklist);
        return defaultChecklist;
    }

    /**
     * 修改数据
     * @param defaultChecklist 实例对象
     * @return 实例对象
     */
    @Override
    public DefaultChecklist update(DefaultChecklist defaultChecklist) {
        defaultChecklistMapper.update(defaultChecklist);
        return queryById(defaultChecklist.getId());
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return defaultChecklistMapper.deleteById(id) > 0;
    }
}
