package com.eaccount.dao;

import com.eaccount.domain.Company_profile;

import java.util.List;

/**
 * Created by spzn on 16-3-10.
 */
public interface ICompanyDAO {
    public List<Company_profile> GetCompanyInfoByCompanyId(Company_profile company_profile);
}
