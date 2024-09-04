package com.jaaaain.defaultsystem.service.impl;

service.impl;

import .entity.DefTable;
import .mapper.DefTableMapper;
import .service.DefTableService;
import com.jaaaain.defaultsystem.mapper.DefTableMapper;
import com.jaaaain.defaultsystem.service.DefTableService;
import org.springframework.stereotype.Service;

/**
 * 违约风险原因表(DefTable)表服务实现类
 * @since 2024-09-04 12:25:45
 */
@Service("defTableService")
public class DefTableServiceImpl implements DefTableService {

    @Autowired
    private DefTableMapper defTableMapper
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DefTable queryById(Integer id) {
        return defTableMapper.queryById(id);
    }

    /**
     * 分页查询
     * @param defTable 筛选条件
     * @return 查询结果
     */
    @Override
    public PageBean queryByLimit(Integer page, Integer size, DefTable defTable) {
        PageHelper.startPage(page, size); // 将下一条搜索改为查count和limit两条
        List<DefTable> list = defTableMapper.queryAllByLimit(defTable);  // 得到的数据直接为PageBean类型
        Page<DefTable> p = (Page<DefTable>) list;  // 强制类型转换
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /**
     * 新增数据
     * @param defTable 实例对象
     * @return 实例对象
     */
    @Override
    public DefTable insert(DefTable defTable) {
        defTableMapper.insert(defTable);
        return defTable;
    }

    /**
     * 修改数据
     * @param defTable 实例对象
     * @return 实例对象
     */
    @Override
    public DefTable update(DefTable defTable) {
        defTableMapper.update(defTable);
        return queryById(defTable.getId());
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return defTableMapper.deleteById(id) > 0;
    }
}
