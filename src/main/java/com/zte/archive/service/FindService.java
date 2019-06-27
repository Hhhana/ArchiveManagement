package com.zte.archive.service;

import com.zte.archive.model.Archive;
import com.zte.archive.model.Destroy;
import com.zte.archive.model.Find;
import com.zte.archive.model.Lose;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-25 8:21
 * Description:<描述>
 */
public interface FindService {
    /**
     * create by: Hana
     * description: 查询id对应的Archive表记录
     * create time: 14:26 2019/6/25
     *
     * @Param: archiveId
     * @return java.util.List<com.zte.archive.model.Archive>
     */
    public Archive queryAllArchive(@Param("archiveId") String archiveId);

    /**
     * create by: Hana
     * description: 查询某时间段内的Find表记录
     * create time:  2019/6/25
     *
     * @Param: archiveId
     * @return java.util.List<com.zte.archive.model.Find>
     */
    public List<Find> queryAllFind(@Param("startTime")String startTime,@Param("endTime")String endTime);

    /**
     * create by: Hana
     * description: 查询某时间段内的Lose表记录
     * create time: 14:28 2019/6/25
     *
     * @Param: archiveId
     * @return java.util.List<com.zte.archive.model.Lose>
     */
    public List<Lose> queryAllLose(@Param("startTime")String startTime,@Param("endTime")String endTime);


    /**
     * create by: Hana
     * description: 查询某时间段内的Destroy记录
     * create time: 14:35 2019/6/25
     *
     * @Param: startTime
     * @Param: endTime
     * @return java.util.List<com.zte.archive.model.Destroy>
     */
    public List<Destroy> queryAllDestroy(@Param("startTime")String startTime,@Param("endTime")String endTime);

    /**
     * create by: Hana
     * description: 更新Archive表，修改状态
     * create time: 10:39 2019/6/26
     *
     * @Param: java.util.List<com.zte.archive.model.Archive>
     * @return
     */
    public void updateArchive(@Param("archiveId") String archiveId) throws SQLException;

    /**
     * create by: Hana
     * description: 更新find表，插入数据
     * create time: 11:10 2019/6/26
     *
     * @Param: java.util.List<com.zte.archive.model.Find>
     * @return
     */
    public void insertFind(Find find) throws SQLException;

}
