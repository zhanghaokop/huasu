package com.huashu.huashuManager;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class UpdateTest {




    @Test
    public void update(){


        DataSource huasuDs = new SingleConnectionDataSource("jdbc:MySQL://118.31.40.61:3306/huasu?useUnicode=true&characterEncoding=utf8&autoReconnect=true","root","huasu2017", true);
        //huasu 数据库操作模板
        JdbcTemplate huasu = new JdbcTemplate(huasuDs);

        DataSource huasuManagerDs = new SingleConnectionDataSource("jdbc:MySQL://118.31.40.61:3306/huasumanager?useUnicode=true&characterEncoding=utf8&autoReconnect=true","root","huasu2017", true);
        //huasuManager 数据库操作模板
        JdbcTemplate huasuManager = new JdbcTemplate(huasuManagerDs);

        List<Map<String, Object>> oldList = huasu.queryForList("SELECT b.id,b.company,c.id as companyId from BASIC_INFO b INNER JOIN CUSTOMERS c ON c.company = b.company ");



        oldList.forEach(a -> huasuManager.update("update BASIC_INFO SET companyId = ? where id = ?", a.get("companyId").toString(), a.get("id").toString()));

    }
}
