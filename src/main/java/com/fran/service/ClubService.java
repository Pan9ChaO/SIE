package com.fran.service;

import com.fran.pojo.Club;
import com.fran.pojo.Temp;

import java.util.List;

public interface ClubService {
    List<Club> getClubs();

    List<Club> getByName(String name);

    List<Club> getByPresident(String president);

    List<Integer> getClubId(int id);

    List<Integer> getStudentId(int id);

    int save(int stuId,int cId);

    void increase(int cId);

    int create(String name,int count,int president,String des);

    int getClubRecent(int stuId, String name);

    Temp exist(String name);
}
