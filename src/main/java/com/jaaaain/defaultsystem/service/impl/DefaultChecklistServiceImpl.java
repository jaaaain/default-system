package com.jaaaain.defaultsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jaaaain.defaultsystem.entity.RebirthChecklist;
import com.jaaaain.defaultsystem.entity.vo.DefInfoVO;
import com.jaaaain.defaultsystem.mapper.CusTableMapper;
import com.jaaaain.defaultsystem.mapper.DefaultChecklistMapper;
import com.jaaaain.defaultsystem.entity.DefaultChecklist;
import com.jaaaain.defaultsystem.entity.PageBean;
import com.jaaaain.defaultsystem.service.DefaultChecklistService;
import com.jaaaain.defaultsystem.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 违约认定人工审核表(DefaultChecklist)表服务实现类
 * @since 2024-09-04 12:25:46
 */
@Service
public class DefaultChecklistServiceImpl implements DefaultChecklistService {

    @Autowired
    private DefaultChecklistMapper defaultChecklistMapper;
    @Autowired
    private CusTableMapper cusTableMapper;
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DefInfoVO queryById(Integer id) {
        DefInfoVO defInfo = defaultChecklistMapper.queryVOById(id);
        return defInfo;
    }

    /**
     * 分页查询
     * @param page,size,status,cusName
     * @return 查询结果
     */
    @Override
    public PageBean queryByLimit(Integer page, Integer size,Integer status,String cusName) {
        PageHelper.startPage(page, size); // 将下一条搜索改为查count和limit两条
        List<DefInfoVO> list = defaultChecklistMapper.VOlist(status,cusName);  // 得到的数据直接为PageBean类型
        Page<DefInfoVO> p = (Page<DefInfoVO>) list;  // 强制类型转换
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
        DefaultChecklist rebItem = defaultChecklistMapper.queryById(id);
        Integer status0 = rebItem.getStatus();
//        Claims claims = JwtUtils.parseJwt(token);
//        Integer userId = Integer.valueOf(claims.getId());
//        System.out.println("userId:"+userId);
        if (status0 == 0) {
            if(result==1){
                cusTableMapper.updateStatus(rebItem.getCusId(),1);
                defaultChecklistMapper.updateStatus(id,1);
            }else{
                defaultChecklistMapper.updateStatus(id,2);
            }
        }else{
            throw new RuntimeException("已审核过");
        }

    }
}
