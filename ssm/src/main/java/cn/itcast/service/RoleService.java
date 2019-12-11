package cn.itcast.service;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;


import java.util.List;

public interface RoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(int id) throws Exception;

    List<Permission> findOtherPermissions(int roleId) throws Exception;

    void addPermissionToRole(int roleId, Integer[] permissionIds) throws Exception;
}
