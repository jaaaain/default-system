package com.jaaaain.defaultsystem.service.impl;

service.impl;

import .entity.RebirthChecklist;
import .mapper.RebirthChecklistMapper;
import .service.RebirthChecklistService;
import com.jaaaain.defaultsystem.mapper.RebirthChecklistMapper;
import com.jaaaain.defaultsystem.service.RebirthChecklistService;
import org.springframework.stereotype.Service;

/**
 * 重生人工审核表(RebirthChecklist)表服务实现类
 * @since 2024-09-04 12:25:46
 */
@Service("rebirthChecklistService")
public class RebirthChecklistServiceImpl implements RebirthChecklistService {

    @Autowired
    private RebirthChecklistMapper rebirthChecklistMapper
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RebirthChecklist queryById(Integer id) {
        return rebirthChecklistMapper.queryById(id);
    }

    /**
     * 分页查询
     * @param rebirthChecklist 筛选条件
     * @return 查询结果
     */
    @Override
    public PageBean queryByLimit(Integer page, Integer size, RebirthChecklist rebirthChecklist) {
        PageHelper.startPage(page, size); // 将下一条搜索改为查count和limit两条
        List<RebirthChecklist> list = rebirthChecklistMapper.queryAllByLimit(rebirthChecklist);  // 得到的数据直接为PageBean类型
        Page<RebirthChecklist> p = (Page<RebirthChecklist>) list;  // 强制类型转换
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /**
     * 新增数据
     * @param rebirthChecklist 实例对象
     * @return 实例对象
     */
    @Override
    public RebirthChecklist insert(RebirthChecklist rebirthChecklist) {
        rebirthChecklistMapper.insert(rebirthChecklist);
        return rebirthChecklist;
    }

    /**
     * 修改数据
     * @param rebirthChecklist 实例对象
     * @return 实例对象
     */
    @Override
    public RebirthChecklist update(RebirthChecklist rebirthChecklist) {
        rebirthChecklistMapper.update(rebirthChecklist);
        return queryById(rebirthChecklist.getId());
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return rebirthChecklistMapper.deleteById(id) > 0;
    }
}
