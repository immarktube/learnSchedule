package com.learn.demo.dataStructure;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * 类 {@code LinkedTable} 线性链表
 * <p> 主要用于包括线性链表结构剖析
 * @Author <a href="mailto:immarktube@gmail.com">tubemark</a>
 * @Since 2021/8/15 5:16 下午
 **/
public class LinkedTable {

    /**
     * @Author Marktube
     * @Description //TODO 
     * @Date 5:38 下午 2021/8/15
     * @Param [args]
     * @return void
    **/
    public static void main(String[] args) {
        
    }
    
    /**
     * @Author Marktube
     * @Description //TODO
     * @Date 6:04 下午 2021/8/15
     * @Param []
     * @return
    **/
    public LinkedTable() throws Exception {
        DataSource dataSource = DruidDataSourceFactory.createDataSource(new Properties());

        Connection connection = dataSource.getConnection();
    }
}
