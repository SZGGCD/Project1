package cn.itcast.service;



import cn.itcast.domain.SysLog;

import java.util.List;

public interface SysLogService {

    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll( int page,int size) throws Exception;
}
