package com.eaccount.service;

import com.eaccount.domain.Pay;

import java.util.List;

/**
 * Created by spzn on 16-3-21.
 */
public interface IGetPayInfoService {
    public List<Pay> GetPayInfoByCompanyId(String company_id);
    public Pay GetPayInfoByPayId(String pay_id);
}
