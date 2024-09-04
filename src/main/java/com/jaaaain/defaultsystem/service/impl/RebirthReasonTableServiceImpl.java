package com.jaaaain.defaultsystem.service.impl;

service.impl;

import .entity.RebirthReasonTable;
import .mapper.RebirthReasonTableMapper;
import .service.RebirthReasonTableService;
import com.jaaaain.defaultsystem.mapper.RebirthReasonTableMapper;
import com.jaaaain.defaultsystem.service.RebirthReasonTableService;
import org.springframework.stereotype.Service;

/**
 * 重生原因表(RebirthReasonTable)表服务实现类
 * @since 2024-09-04 12:25:46
 */
@Service("rebirthReasonTableService")
public class RebirthReasonTableServiceImpl implements RebirthReasonTableService {

    @Autowired
    private RebirthReasonTableMapper rebirthReasonTableMapper
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RebirthReasonTable queryById(Integer id) {
        return rebirthReasonTableMapper.queryById(id);
    }

    /**
     * 分页查询
     * @param rebirthReasonTable 筛选条件
     * @return 查询结果
     */
    @Override
    public PageBean queryByLimit(Integer page, Integer size, RebirthReasonTable rebirthReasonTable) {
        PageHelper.startPage(page, size); // 将下一条搜索改为查count和limit两条
        List<RebirthReasonTable> list = rebirthReasonTableMapper.queryAllByLimit(rebirthReasonTable);  // 得到的数据直接为PageBean类型
        Page<RebirthReasonTable> p = (Page<RebirthReasonTable>) list;  // 强制类型转换
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /**
     * 新增数据
     * @param rebirthReasonTable 实例对象
     * @return 实例对象
     */
    @Override
    public RebirthReasonTable insert(RebirthReasonTable rebirthReasonTable) {
        rebirthReasonTableMapper.insert(rebirthReasonTable);
        return rebirthReasonTable;
    }

    /**
     * 修改数据
     * @param rebirthReasonTable 实例对象
     * @return 实例对象
     */
    @Override
    public RebirthReasonTable update(RebirthReasonTable rebirthReasonTable) {
        rebirthReasonTableMapper.update(rebirthReasonTable);
        return queryById(rebirthReasonTable.getId());
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return rebirthReasonTableMapper.deleteById(id) > 0;
    }
}
