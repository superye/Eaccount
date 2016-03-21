package com.eaccount.dao;

import com.eaccount.domain.Pay;

import java.util.List;

/**
 * Created by spzn on 16-3-20.
 */
public interface IPayDAO {
    public boolean AddPayInfo(Pay pay);
    public List<Pay> GetPayInfoByCompanyId(String company_id);
}
