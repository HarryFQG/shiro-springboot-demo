package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.model.Resources;

import java.util.List;
import java.util.Map;

/**
 *  @author  fengqigui
 *  @date 2017/12/23.
 */
public interface ResourcesService extends IService<Resources> {
    PageInfo<Resources> selectByPage(Resources resources, int start, int length);

    public List<Resources> queryAll();

    public List<Resources> loadUserResources(Map<String,Object> map);

    public List<Resources> queryResourcesListWithSelected(Integer rid);
}
