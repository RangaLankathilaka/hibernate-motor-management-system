/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import lk.ijse.motor.bussiness.custom.VehicleBO;

import lk.ijse.motor.dao.custom.VehecleDAO;
import lk.ijse.motor.dto.VehicleDTO;
import lk.ijse.motor.entity.Customer;
import lk.ijse.motor.entity.Vehicle;

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
public class VehicleBOImpl implements VehicleBO{
    @Autowired
    VehecleDAO vehecleDAO;


    public VehicleBOImpl() {

        // vehecleDAO=(VehecleDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.VEHICLE);
    }

    

    @Override
    public boolean save(VehicleDTO entity) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      //  Vehicle vehicle=new Vehicle(entity.getVid(),entity.getType(),entity.getIssue(),entity.getCid());
     //   return vehecleDAO.save(vehicle);





        try {



            Vehicle vehicle = new Vehicle(entity.getVid(),entity.getType(),entity.getIssue(),null);
            vehecleDAO.save(vehicle);


            return true;


        } catch (HibernateException exp) {
            return false;


        }
    
    }

    @Override
    public int getVehicleCount() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 
 //return vehecleDAO.getVehicleCount();
        return 9;
    
    }
    
}
