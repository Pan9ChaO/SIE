package com.fran.service;


import com.fran.mapper.ClubMapper;
import com.fran.pojo.Club;
import com.fran.pojo.Temp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService{
    @Autowired
    private ClubMapper clubMapper;



    @Override
    public List<Club> getClubs() {
        return clubMapper.getClubs();
    }

    @Override
    public List<Club> getByName(String name)  {
        return clubMapper.getByName(name);
    }

    @Override
    public List<Club> getByPresident(String president) {
        return clubMapper.getByPresident(president);
    }

    @Override
    public List<Integer> getClubId(int id) {
      return clubMapper.getClubId(id);
    }

    @Override
    public List<Integer> getStudentId(int id) {
        return clubMapper.getStudentId(id);
    }

    @Override
    public int save(int stuId, int cId) {
        return clubMapper.save(stuId,cId);
    }

    @Override
    public void increase(int cId) {
        clubMapper.increase(cId);
    }

    @Override
    public int create(String name,int count,int president,String des) {
        return clubMapper.create(name,count,president,des);
    }

    @Override
    public int getClubRecent(int stuId, String name) {
        if(clubMapper.getClubRecent(stuId,name).size() >= 1){
            return clubMapper.getClubRecent(stuId,name).get(0);
        }else{
            return -1;
        }
    }

    @Override
    public Temp exist(String name) {
       return clubMapper.exist(name);
    }
}
