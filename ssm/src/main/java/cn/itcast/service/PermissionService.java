package cn.itcast.service;


import cn.itcast.domain.Permission;

import java.util.List;

public interface PermissionService {

    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
