package com.example.yanghyemin.dao.impl;

import com.example.yanghyemin.dao.MyFridgeDao;
import com.example.yanghyemin.entity.MyFridge;
import com.example.yanghyemin.repository.MyFridgeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyFridgeDaoImpl implements MyFridgeDao {
  private final MyFridgeRepository myFridgeRepository;

  public MyFridgeDaoImpl(MyFridgeRepository myFridgeRepository) {
    this.myFridgeRepository = myFridgeRepository;
  }

  @Override
  public MyFridge insertMyFridge(MyFridge myFridge) {
    MyFridge saveMyFridge = myFridgeRepository.save(myFridge);
    return saveMyFridge;
  }

  @Override
  public void deleteMyFridge(Long id) throws Exception {
    Optional<MyFridge> deleteMyFridge = myFridgeRepository.findById(id);
    if(deleteMyFridge.isPresent()){
      MyFridge myFridge = deleteMyFridge.get();
      myFridgeRepository.delete(myFridge);
    }else throw new Exception();
  }

  @Override
  public List<MyFridge> listAllOrgerByUserId(String userId) {
    List<MyFridge> myFridgeList = myFridgeRepository.findByUserId(userId);
    return myFridgeList;
  }
}
