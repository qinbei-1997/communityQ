package com.nowcoder.communityQ.dao;

import org.springframework.stereotype.Repository;

@Repository("alphah")
public class AlphaDaoHibernayeImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
