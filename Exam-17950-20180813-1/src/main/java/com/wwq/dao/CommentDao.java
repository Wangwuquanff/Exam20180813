package com.wwq.dao;

import com.wwq.vo.Customer;

public interface CommentDao {
    //�����û���½��Ϣ
    public Customer login_Coustom(String cus_name,String cus_password)throws Exception;
}
