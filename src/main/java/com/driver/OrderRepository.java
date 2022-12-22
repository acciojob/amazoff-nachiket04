package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {

    HashMap <String, Order> orderHashMap = new HashMap<>();
    HashMap <String, DeliveryPartner> partnerHashMap = new HashMap<>();
    HashMap <String, List <String>> pairMap = new HashMap<>();


    public void addOrder(Order order){
        orderHashMap.put(order.getId(), order);
    }

    public Order getOrderById(String id){
        return orderHashMap.get(id);
    }

    public void addPartner(DeliveryPartner partner){
        partnerHashMap.put(partner.getId(), partner);
        if(!pairMap.containsKey(partner.getId())){
            pairMap.put(partner.getId(), new ArrayList<String>());
        }
    }

    public DeliveryPartner getPartnerById(String id){
        return partnerHashMap.get(id);
    }

    public void addPair(String orderId, String partnerId){
        List <String> list = pairMap.get(partnerId);
        list.add(orderId);
        pairMap.put(partnerId, list);
    }

    public int getOrderCount(String partnerId){
        List <String> list = pairMap.get(partnerId);
        return list.size();
    }

    public List<String> getOrders(String partnerId){
        return pairMap.get(partnerId);
    }

    public List<String> getAllOrders(){
        List<String> list = new ArrayList<>();
        for(String key: orderHashMap.keySet()){
            list.add(key);
        }
        return list;
    }
}
