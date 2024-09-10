package com.jaaaain.defaultsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jaaaain.defaultsystem.entity.DefaultChecklist;
import com.jaaaain.defaultsystem.entity.PageBean;
import com.jaaaain.defaultsystem.entity.RebirthChecklist;
import com.jaaaain.defaultsystem.entity.vo.RebInfoVO;
import com.jaaaain.defaultsystem.mapper.CusTableMapper;
import com.jaaaain.defaultsystem.mapper.DefaultChecklistMapper;
import com.jaaaain.defaultsystem.mapper.RebirthChecklistMapper;
import com.jaaaain.defaultsystem.service.RebirthChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 重生人工审核表(RebirthChecklist)表服务实现类
 * @since 2024-09-04 12:25:46
 */
@Service("rebirthChecklistService")
public class RebirthChecklistServiceImpl implements RebirthChecklistService {

    @Autowired
    private RebirthChecklistMapper rebirthChecklistMapper;

    @Autowired
    private CusTableMapper cusTableMapper;
    @Autowired
    private DefaultChecklistMapper defaultChecklistMapper;

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
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RebInfoVO queryVOById(Integer id) {
        return rebirthChecklistMapper.queryVOById(id);
    }

    /**
     * 分页查询
     * @param page,size,status,cusName
     * @return 查询结果
     */
    @Override
    public PageBean queryByLimit(Integer page, Integer size,Integer status,String cusName) {
        PageHelper.startPage(page, size); // 将下一条搜索改为查count和limit两条
        List<RebInfoVO> list = rebirthChecklistMapper.VOlist(status,cusName);  // 得到的数据直接为PageBean类型
        Page<RebInfoVO> p = (Page<RebInfoVO>) list;  // 强制类型转换
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /**
     * 审核
     * @param result 审核是否通过，1：通过，0：未通过
     * @return 影响行数
     */
    @Override
    @Transactional
    public void updateStatus(Integer id, Integer result) {
        RebirthChecklist rebItem = rebirthChecklistMapper.queryById(id);
        Integer status0 = rebItem.getStatus();
        DefaultChecklist defItem = defaultChecklistMapper.queryById(rebItem.getDefId());
        if (status0 == 0) {
            if(result==1){
                cusTableMapper.updateStatus(defItem.getCusId(),0);
                rebirthChecklistMapper.updateStatus(id,1);
            }else{
                rebirthChecklistMapper.updateStatus(id,2);
            }
        }else {
            throw new RuntimeException("已审核过");
        }
    }
}
