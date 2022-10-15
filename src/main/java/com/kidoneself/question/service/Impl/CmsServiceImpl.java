package com.kidoneself.question.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.mapper.CmsMapper;
import com.kidoneself.question.modle.entity.Cms;
import com.kidoneself.question.service.CmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class CmsServiceImpl extends ServiceImpl<CmsMapper, Cms> implements CmsService {


    @Resource
    private CmsMapper cmsMapper;


    @Override
    public R<?> getCms(Integer pageSize, Integer pageNum) {
        Page<Cms> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Cms> query = Wrappers.lambdaQuery();
        query.orderByDesc(Cms::getSort);
        Page<Cms> cmsPage = cmsMapper.selectPage(page, query);
        return R.ok(cmsPage);
    }
}
