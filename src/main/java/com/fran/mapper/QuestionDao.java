package com.fran.mapper;



import com.fran.pojo.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class QuestionDao {
    private static Map<Integer, Question>  questions = null;


    static{
        questions = new HashMap<>();
        questions.put(1,new Question(101,"Question No.1"));
        questions.put(2,new Question(102,"Question No.2"));
        questions.put(3,new Question(103,"Question No.35"));

    }

    public  Collection<Question> getQuestions(){
        return questions.values();

    }

    public Question getQuestionById(Integer id){
        return questions.get(id);
    }

}
