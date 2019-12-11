package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**
 * 线路Service
 */
public interface RouteService {

    /**
     * 根据类别进行分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param ranme
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize , String ranme);


    /**
     * 根据id查询
     * @param rid
     * @return
     */
    public  Route findOne(String rid);
}
