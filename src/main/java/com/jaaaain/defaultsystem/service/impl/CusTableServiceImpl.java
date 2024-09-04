package com.jaaaain.defaultsystem.service.impl;

service.impl;

import .entity.CusTable;
import .mapper.CusTableMapper;
import .service.CusTableService;
import com.jaaaain.defaultsystem.mapper.CusTableMapper;
import com.jaaaain.defaultsystem.service.CusTableService;
import org.springframework.stereotype.Service;

/**
 * 客户表(CusTable)表服务实现类
 * @since 2024-09-04 12:25:43
 */
@Service("cusTableService")
public class CusTableServiceImpl implements CusTableService {

    @Autowired
    private CusTableMapper cusTableMapper
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CusTable queryById(Integer id) {
        return cusTableMapper.queryById(id);
    }

    /**
     * 分页查询
     * @param cusTable 筛选条件
     * @return 查询结果
     */
    @Override
    public PageBean queryByLimit(Integer page, Integer size, CusTable cusTable) {
        PageHelper.startPage(page, size); // 将下一条搜索改为查count和limit两条
        List<CusTable> list = cusTableMapper.queryAllByLimit(cusTable);  // 得到的数据直接为PageBean类型
        Page<CusTable> p = (Page<CusTable>) list;  // 强制类型转换
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /**
     * 新增数据
     * @param cusTable 实例对象
     * @return 实例对象
     */
    @Override
    public CusTable insert(CusTable cusTable) {
        cusTableMapper.insert(cusTable);
        return cusTable;
    }

    /**
     * 修改数据
     * @param cusTable 实例对象
     * @return 实例对象
     */
    @Override
    public CusTable update(CusTable cusTable) {
        cusTableMapper.update(cusTable);
        return queryById(cusTable.getId());
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return cusTableMapper.deleteById(id) > 0;
    }
}
