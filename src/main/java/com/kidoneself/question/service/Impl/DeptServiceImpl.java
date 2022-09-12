package com.kidoneself.question.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.mapper.DeptMapper;
import com.kidoneself.question.modle.entity.Dept;
import com.kidoneself.question.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {


    @Resource
    private DeptMapper deptMapper;


    @Override
    public R<?> getPageDept(Integer pageSize, Integer pageNum) {
        Page<Dept> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Dept> query = Wrappers.lambdaQuery();
        query.orderByDesc(Dept::getSort);
        Page<Dept> deptPage = deptMapper.selectPage(page, query);
        return R.ok(deptPage);
    }
}
