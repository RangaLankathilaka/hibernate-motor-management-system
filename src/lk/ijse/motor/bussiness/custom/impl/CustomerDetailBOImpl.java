/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import lk.ijse.motor.bussiness.custom.CustomerDetailBO;

import lk.ijse.motor.dao.custom.CustomerDetailDAO;
import lk.ijse.motor.dto.CustomerDetailDTO;
import lk.ijse.motor.entity.Customer;
import lk.ijse.motor.entity.CustomerDetail;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ranga Lankathilaka
 */

@Component
@Transactional
public class CustomerDetailBOImpl implements CustomerDetailBO{
    @Autowired
    CustomerDetailDAO customerDetailDAO;


    public CustomerDetailBOImpl() {
        
       // customerDetailDAO=(CustomerDetailDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.CUSTOMERDETAIL);

    }
    
    
    
    

    @Override
    public boolean save(CustomerDetailDTO entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


        try {



//            Customer customer = new Customer(dto.getCid(), dto.getCname(), dto.getContact(), dto.getAddress());
//            customerDAO.save(customer);


            CustomerDetail customerDetail=new CustomerDetail(null, entity.getCid(), entity.getPid());
            customerDetailDAO.save(customerDetail);

            return true;


        } catch (HibernateException exp) {
            return false;


        }
    
    }
    
}
