package cn.itcast.dao;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true , property = "id" , column = "id"),
            @Result(property = "roleName" , column = "roleName"),
            @Result(property = "roleDesc" , column = "roleDesc"),
            @Result(property = "permissions" , column = "id" , javaType = java.util.List.class , many = @Many(select = "cn.itcast.dao.PermissionDao.findPermissionByRoleId")),
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role (roleName , roleDesc) values(#{roleName} , #{roleDesc})")
    void save(Role role) throws Exception;

    @Select("select * from role  where id=#{roleId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "permissionName", column = "permissionName"),
            @Result(property = "url", column = "url"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.dao.PermissionDao.findPermissionByRoleId"))
    })
    Role findById(int id) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(int roleId) throws  Exception;


    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId} , #{permissionId})")
    void addPermissionToRole(@Param("roleId")int roleId, @Param("permissionId") int permissionId) throws Exception;
}
