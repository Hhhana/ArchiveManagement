package com.zte.archive.service.impl;

import com.zte.archive.dao.FindDao;
import com.zte.archive.model.Archive;
import com.zte.archive.model.Destroy;
import com.zte.archive.model.Find;
import com.zte.archive.model.Lose;
import com.zte.archive.service.FindService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-25 8:22
 * Description:<描述>
 */


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)

public class FindServiceImpl implements FindService {

    @Autowired
    private FindDao findDao;

    /**
     * create by: Hana
     * description: 查询id对应的Archive表记录
     * create time: 14:26 2019/6/25
     *
     * @param archiveId
     * @return java.util.List<com.zte.archive.model.Archive>
     * @Param: archiveId
     */
    @Override
    public Archive queryAllArchive(@Param("archiveId") String archiveId) {
        return findDao.queryAllArchive(archiveId);
    }

    /**
     * create by: Hana
     * description: 查询某时间段内的Find表记录
     * create time:  2019/6/25
     *
     * @Param: archiveId
     * @return java.util.List<com.zte.archive.model.Find>
     */
    @Override
    public List<Find> queryAllFind(@Param("startTime")String startTime,@Param("endTime")String endTime){
        return findDao.queryAllFind(startTime,endTime);
    }

    /**
     * create by: Hana
     * description: 查询某时间段内的Lose表记录
     * create time: 14:28 2019/6/25
     *
     * @Param: archiveId
     * @return java.util.List<com.zte.archive.model.Lose>
     */
    @Override
    public List<Lose> queryAllLose(@Param("startTime")String startTime,@Param("endTime")String endTime){
        return findDao.queryAllLose(startTime, endTime);
    }


    /**
     * create by: Hana
     * description: 查询某时间段内的Destroy记录
     * create time: 14:35 2019/6/25
     *
     * @Param: startTime
     * @Param: endTime
     * @return java.util.List<com.zte.archive.model.Destroy>
     */
    @Override
    public List<Destroy> queryAllDestroy(@Param("startTime")String startTime,@Param("endTime")String endTime){
        return findDao.queryAllDestroy(startTime, endTime);
    }

    /**
     * create by: Hana
     * description: 更新Archive表，修改状态
     * create time: 10:39 2019/6/26
     *
     * @Param: java.util.List<com.zte.archive.model.Archive>
     * @return
     */
    @Override
    public void updateArchive(@Param("archiveId") String archiveId) throws SQLException{
        findDao.updateArchive(archiveId);
    }


    /**
     * create by: Hana
     * description: 更新find表，插入数据
     * create time: 11:10 2019/6/26
     *
     * @Param: java.util.List<com.zte.archive.model.Find>
     * @return
     */
    @Override
    public void insertFind(Find find) throws SQLException{
        findDao.insertFind(find);
    }


}
