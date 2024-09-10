package com.jaaaain.defaultsystem.service;
import com.jaaaain.defaultsystem.entity.PageBean;
import com.jaaaain.defaultsystem.entity.RebirthChecklist;
import com.jaaaain.defaultsystem.entity.vo.RebInfoVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 重生人工审核表(RebirthChecklist)表服务接口
 * @since 2024-09-04 12:25:46
 */
public interface RebirthChecklistService {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    RebirthChecklist queryById(Integer id);

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    RebInfoVO queryVOById(Integer id);

    /**
     * 分页查询
     * @param page,size,status,cusName
     * @return 查询结果
     */
    PageBean queryByLimit(Integer page, Integer size,Integer status,String cusName);

    /**
     * 审核
     * @param id,status 审核是否通过，1：通过，2：未通过
     * @return 影响行数
     */
    @Transactional
    void updateStatus(Integer id, Integer status);
}
