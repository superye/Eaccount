package com.eaccount.dao;

import com.eaccount.domain.Order;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-3.
 */
public class OrderDAO implements IOrderDAO{
    @Override
    public List<Order> SellerGetOrderMessageByUserId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectOrderInfoByUserSellerId", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

    @Override
    public List<Order> BuyerGetOrderMessageByUserId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectOrderInfoByUserBuyerId", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

    @Override
    public List<Order> SellerGetOrderMessageByOrderId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SellerSelectOrderInfoByOrderId", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

    @Override
    public List<Order> BuyerGetOrderMessageByOrderId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.BuyerSelectOrderInfoByOrderId", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

    @Override
    public boolean UpdateOrderSellerId(Order order) {
        int flag = 0;
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        try {
            sqlSession = dbAccess.getSqlSession();
            flag = sqlSession.update("Order.UpdateOrderSellerId", order);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (flag != 0) return true;
        else return false;
    }

    @Override
    public boolean UpdateOrderBuyerId(Order order) {
        int flag = 0;
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        try {
            sqlSession = dbAccess.getSqlSession();
            flag = sqlSession.update("Order.UpdateOrderBuyerId", order);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (flag != 0) return true;
        else return false;
    }

    @Override
    public boolean DeleteOrderInfoByOrderId(Order order) {
        int flag = 0;
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            flag += sqlSession.delete("Order.DeleteOrderByOrderId", order);
            flag += sqlSession.delete("Order.DeleteOrderDetailByOrderId", order);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (flag != 0) return true;
        else return false;
    }

    @Override
    public List<Order> GetNoPaidOrderByUserBuyerId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectReconciliationByBuyerId", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

    @Override
    public List<Order> GetNoPaidOrderByUserSellerId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectReconciliationBySellerId", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }


    @Override
    public int GetCountMatterOrder(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Integer> list = new ArrayList<Integer>();
        try {
            sqlSession = dbAccess.getSqlSession();
            if ("1".equals(order.getType())) {
                list = sqlSession.selectList("Order.BuyerCountMatterOrder", order);
            } else {
                list = sqlSession.selectList("Order.SellerCountMatterOrder", order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (list.size() == 0) return -1;
        return list.get(0);
    }

    @Override
    public int GetCountPayment(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Integer> list = new ArrayList<Integer>();
        try {
            sqlSession = dbAccess.getSqlSession();
            if ("1".equals(order.getType())) {
                list = sqlSession.selectList("Order.BuyerCountPayment", order);
            } else {
                list = sqlSession.selectList("Order.SellerCountPayment", order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (list.size() == 0 || list.get(0) == null) return -1;
        return list.get(0);
    }

    @Override
    public List<Order> GetMatterOrderInfo(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            if ("1".equals(order.getType())) {
                list = sqlSession.selectList("Order.BuyerSelectMatterOrderInfo", order);
            } else {
                list = sqlSession.selectList("Order.SellerSelectMatterOrderInfo", order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (list.size() == 0) return null;
        return list;
    }

    @Override
    public List<Order> GetMatterOrderDetailInfo(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            if ("1".equals(order.getType())) {
                list = sqlSession.selectList("Order.BuyerSelectMatterOrderDetailInfo", order);
            } else {
                list = sqlSession.selectList("Order.SellerSelectMatterOrderDetailInfo", order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (list.size() == 0) return null;
        return list;
    }

    @Override
    public boolean InsertOrder(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.update("Order.InsertOrder", order);
            sqlSession.update("Order.InsertPhoto", order);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return true;
    }

    @Override
    public List<Order> GetAccountPeriod(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.UserSelectAccountPeriod", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (list.size() == 0) return null;
        return list;
    }

    @Override
    public int CountOverdueOrder(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Integer> list = new ArrayList<>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.CountOverdueOrder", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (list.size() == 0) return 0;
        return list.get(0);
    }

    @Override
    public int CountNoSendOrder(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Integer> list = new ArrayList<>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.CountNoSend", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (list.size() == 0) return 0;
        return list.get(0);
    }

    @Override
    public int CountNoReceivingOrder(Order order) {
         DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Integer> list = new ArrayList<>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.CountNoReceiving", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (list.size() == 0) return 0;
        return list.get(0);
    }

    @Override
    public String GetNewestOrderId() {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<String> list = new ArrayList<>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectNewestOrderId");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list.get(0);
    }

    @Override
    public boolean SetReceivingTime(Order order) {
        int flag = 0;
        order.setOrder_id(order.getOrder_id().trim());
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        try {
            sqlSession = dbAccess.getSqlSession();
            flag = sqlSession.update("Order.SetReceivingTime", order);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (flag != 0) return true;
        else return false;
    }

    @Override
    public List<Order> GetOrderInfoByPayInfo(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectOrderInfoByPayInfo", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (list.size() == 0) return null;
        return list;
    }

    @Override
    public boolean UpdateTotalPrice(String order_id) {
        int flag = 1;
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        try {
            sqlSession = dbAccess.getSqlSession();
            flag *= sqlSession.update("Order.UpdateTotalPriceSeller", order_id);
            flag *= sqlSession.update("Order.UpdateTotalPriceBuyer", order_id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (flag != 0) return true;
        else return false;
    }

    @Override
    public boolean UpdatePaidPrice(Order order) {
        int flag = 1;
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        try {
            sqlSession = dbAccess.getSqlSession();
            flag = sqlSession.update("Order.UpdatePaidPrice", order);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (flag != 0) return true;
        else return false;
    }

    /**
     * 获得已对账未付款订单
     * @return
     */
    @Override
    public List<Order> GetRecNoPaidOrderByUserBuyerId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectReconciliationNoPaidByBuyerId", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

    @Override
    public List<Order> GetRecNoPaidOrderByUserSellerId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectReconciliationNoPaidBySellerId", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

    @Override
    public boolean UpdateReconciliation(String order_id) {
        int flag = 1;
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        try {
            sqlSession = dbAccess.getSqlSession();
            flag = sqlSession.update("Order.UpdateReconciliation", order_id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (flag != 0) return true;
        else return false;
    }
}
