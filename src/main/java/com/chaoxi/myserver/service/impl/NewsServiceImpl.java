package com.chaoxi.myserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoxi.myserver.entity.NewsDTO;
import com.chaoxi.myserver.entity.NewsEntity;
import com.chaoxi.myserver.entity.NewsThumbEntity;
import com.chaoxi.myserver.mapper.NewsDTOMapper;
import com.chaoxi.myserver.mapper.NewsMapper;
import com.chaoxi.myserver.mapper.NewsThumbMapper;
import com.chaoxi.myserver.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, NewsEntity> implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Autowired
    NewsDTOMapper newsDTOMapper;

    @Autowired
    NewsThumbMapper newsThumbMapper;
    public List<NewsDTO> getNewsList(Map<String, Object> params) {
        int page = Integer.parseInt((String) params.get("page"));
        int limit = Integer.parseInt((String) params.get("limit"));

        // 一对多联表查询主字段缺少
        // MPJLambdaWrapper<NewsEntity> wrapper = new MPJLambdaWrapper<>(NewsEntity.class)
      /*   MPJLambdaWrapper<NewsEntity> wrapper = JoinWrappers.lambda(NewsEntity.class)
                .selectAll(NewsEntity.class)
                // 全部映射 不用考虑字段名重复问题(比如 id), 会对重复列自动添加别名
                .selectCollection(NewsThumbEntity.class, NewsDTO::getNewsThumbList
                         , map -> map
                        .result(NewsThumbEntity::getThumbId)
                        .result(NewsThumbEntity::getThumbUrl)
                        .result(NewsThumbEntity::getNewsId)
                )
                .leftJoin(NewsThumbEntity.class, NewsThumbEntity::getNewsId, NewsEntity::getNewsId);

        // List<NewsDTO> newsDTO = newsMapper.selectJoinList(NewsDTO.class, wrapper);
        Page<NewsDTO> newsDTO = newsMapper.selectJoinPage(new Page<>(page, limit), NewsDTO.class, wrapper);
 */

        // 分页查出limit数据，然后依次添加到NewsEntity中
        QueryWrapper<NewsDTO> queryWrapper = Wrappers.query();
        queryWrapper.select("news.*");
        Page<NewsDTO> newsEntityPage = newsDTOMapper.selectPage((new Page<>(page,limit)), queryWrapper);
        List<NewsDTO> list = newsEntityPage.getRecords();

        for (NewsDTO news : list) {
            QueryWrapper<NewsThumbEntity> thumbQueryWrapper = Wrappers.query();
            thumbQueryWrapper.eq("news_id", news.getNewsId());
            List<NewsThumbEntity> thumbList = newsThumbMapper.selectList(thumbQueryWrapper);
            news.setNewsThumbList(thumbList);
        }

        return list;
    }


    public List<NewsEntity> getPageList(Map<String, Object> params) {
        // Integer page = (Integer) params.get("page");
        int page = Integer.parseInt((String) params.get("page"));
        int limit = Integer.parseInt((String) params.get("limit"));
        Page<NewsEntity> pg = new Page<>(page, limit);
      /*   MPJLambdaWrapper<NewsEntity> wrapper = new MPJLambdaWrapper<NewsEntity>()
                .selectAll(NewsEntity.class)//查询user表全部字段
                .selectAll(NewsThumbEntity.class)//查询user_address tel 字段
                .leftJoin(NewsThumbEntity.class, NewsThumbEntity::getNewsId, NewsEntity::getNewsId);
        List<NewsEntity> list = newsMapper.selectJoinList(NewsEntity.class, wrapper);
 */

      /*   MPJLambdaWrapper<NewsEntity> wrapper1 = new MPJLambdaWrapper<NewsEntity>()
                .selectAll(NewsEntity.class)
                // .selectAll(NewsThumbEntity.class)
                //全部映射 不用考虑字段名重复问题(比如 id), 会对重复列自动添加别名
                .selectCollection(NewsThumbEntity.class,NewsResponse::getNewsThumbList)
                .leftJoin(NewsThumbEntity.class, NewsThumbEntity::getNewsId, NewsEntity::getNewsId);
                // .groupBy(NewsEntity::getNewsId);

        // List<NewsEntity> list= newsMapper.selectJoinList(NewsEntity.class, wrapper1);
        Page<NewsResponse> list = newsMapper.selectJoinPage(new Page<>(page, limit), NewsResponse.class, wrapper1);
        List<NewsResponse> records = list.getRecords();
        System.out.println(records.toString()); */


        //  联表查询，副表映射到主表list中
        /* QueryWrapper<NewsEntity> queryWrapper = Wrappers.query();
        queryWrapper.select("news.*");
        Page<NewsEntity> newsEntityPage = newsMapper.selectPage(pg, queryWrapper);
        List<NewsEntity> list = newsMapper.selectList(queryWrapper);

        for (NewsEntity news : list) {
            QueryWrapper<NewsThumbEntity> thumbQueryWrapper = Wrappers.query();
            thumbQueryWrapper.eq("news_id", news.getNewsId());
            List<NewsThumbEntity> thumbList = newsThumbMapper.selectList(thumbQueryWrapper);
            news.setNewsThumbList(thumbList);
        } */

        // 分页查出limit数据，然后依次添加到NewsEntity中
       /*  QueryWrapper<NewsEntity> queryWrapper = Wrappers.query();
        queryWrapper.select("news.*");
        Page<NewsEntity> newsEntityPage = newsMapper.selectPage(pg, queryWrapper);
        List<NewsEntity> list = newsEntityPage.getRecords();

        for (NewsEntity news : list) {
            QueryWrapper<NewsThumbEntity> thumbQueryWrapper = Wrappers.query();
            thumbQueryWrapper.eq("news_id", news.getNewsId());
            List<NewsThumbEntity> thumbList = newsThumbMapper.selectList(thumbQueryWrapper);
            news.setNewsThumbList(thumbList);
        } */

        return null;
    }
}
