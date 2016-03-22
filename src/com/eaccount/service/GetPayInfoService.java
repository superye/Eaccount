package com.eaccount.service;

import com.eaccount.dao.IPayDAO;
import com.eaccount.dao.PayDAO;
import com.eaccount.domain.Pay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-21.
 */
public class GetPayInfoService implements IGetPayInfoService{
    @Override
    public List<Pay> GetPayInfoByCompanyId(String company_id) {
        IPayDAO payDAO = new PayDAO();
        List<Pay> list = new ArrayList<>();
        list = payDAO.GetPayInfoByCompanyId(company_id);
        return list;
    }

    @Override
    public Pay GetPayInfoByPayId(String pay_id) {
        IPayDAO payDAO = new PayDAO();
        Pay pay = new Pay();
        pay = payDAO.GetPayInfoByPayId(pay_id);
        return pay;
    }
}
