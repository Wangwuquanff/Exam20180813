package com.wwq.dao;

import com.wwq.vo.Customer;

public interface CommentDao {
    //返回用户登陆信息
    public Customer login_Coustom(String cus_name,String cus_password)throws Exception;
}
