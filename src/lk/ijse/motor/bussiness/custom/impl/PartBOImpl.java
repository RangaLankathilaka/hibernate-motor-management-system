/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.ijse.motor.bussiness.custom.PartBO;

import lk.ijse.motor.dao.custom.PartDAO;
import lk.ijse.motor.dto.CustomerDTO;
import lk.ijse.motor.dto.PartDTO;
import lk.ijse.motor.entity.Customer;
import lk.ijse.motor.entity.Part;

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
public class PartBOImpl implements PartBO{
    @Autowired
   private PartDAO partDAO;

    
    
    public PartBOImpl(){

       // this.partDAO= (PartDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.PART);

    }

    @Override
    public boolean save(PartDTO dto) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        Part part=new Part(dto.getPid(),dto.getPname(),dto.getBuying_price(),dto.getSelling_price(),dto.getQty(),dto.getSupplier());
//
//    return partDAO.save(part);




        try {


            Part part=new Part(dto.getPid(),dto.getPname(),dto.getBuying_price(),dto.getSelling_price(),dto.getQty(),dto.getSupplier());
            partDAO.save(part);

            return true;


        } catch (HibernateException exp) {
            return false;


        }
    
    
    }

    @Override
    public boolean delete(Integer pid) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    
//    return partDAO.delete(pid);



        try  {


            partDAO.delete(pid);

            return true;
        }catch (HibernateException exp){
            return false;
        }


    }

    @Override
    public ArrayList<PartDTO> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.



        try  {


            List<Part> allPartss = partDAO.getAll();



            ArrayList<PartDTO> dtos = new ArrayList<>();

            for (Part part : allPartss) {
//                int pid, String pname, int buying_price, int selling_price, int qty, String supplier) {
                PartDTO partDTO = new PartDTO(part.getPid(),part.getPname(),part.getBuying_price(),part.getSelling_price(),part.getQty(),part.getSupplier());
                dtos.add(partDTO);
            }

            return dtos;
        }catch (HibernateException exp){
            return null;
        }
    
    }

    @Override
    public ArrayList<PartDTO> getAllPartID() throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
       ArrayList<PartDTO> arr=getAll();
       ArrayList<PartDTO> arr2=new ArrayList<>();
        for (PartDTO partDTO : arr) {
            int id=partDTO.getPid();
            PartDTO partDTO1=new PartDTO(id);
            arr2.add(partDTO1);
        }
        
       return arr2;
    }

    @Override
    public PartDTO find(Integer pid) throws Exception {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.




        try  {


            Part find = partDAO.find(pid);



            String pname = find.getPname();
       int selling_price = find.getSelling_price();
       int qty = find.getQty();

    return new PartDTO(pname,selling_price, qty);




        }catch (HibernateException exp){
            return null;
        }









//
//       Part find = partDAO.find(pid);
//       String pname = find.getPname();
//       int selling_price = find.getSelling_price();
//       int qty = find.getQty();
//
//    return new PartDTO(pname,selling_price, qty);
    }

    @Override
    public boolean updateQty(PartDTO dto) throws Exception {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

   Part part=new Part(dto.getPid(),null, 0, 0, dto.getQty(),null);

//      return partDAO.updateQty(part);
        return false;



    }

    @Override
    public boolean update(PartDTO dto) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //Part part=partDAO.update();
   Part part=new Part(dto.getPid(),dto.getPname(),dto.getBuying_price(), dto.getSelling_price(), dto.getQty(), dto.getSupplier());
   
//    return partDAO.update(part);
        return false;
    
    
    
    }

    @Override
    public ArrayList<PartDTO> showQtyLessFive() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//
//    ArrayList<Part> arr=partDAO.showQtyLessFive();
//    ArrayList<PartDTO> arr2=new ArrayList<>();
//        for (Part part : arr) {
//        int pid = part.getPid();
//        String name=part.getPname();
//        PartDTO partDTO=new PartDTO(pid, name);
//            //System.out.println("ggggggggggggg"+name);
//        arr2.add(partDTO);
//        }
// return arr2;
//
    return null;
    }

    @Override
    public ArrayList<PartDTO> showSumQty() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
//    ArrayList<Part> arr=partDAO.showSumQty();
//    ArrayList<PartDTO> arr2=new ArrayList<>();
//        for (Part part : arr) {
//        int pid = part.getPid();
//        int qty = part.getQty();
//
//        PartDTO partDTO=new PartDTO(pid, qty);
//        arr2.add(partDTO);
//
//
//        }
//
//    return arr2;
//

        return null;
    }

    
    
    

  
    
}
