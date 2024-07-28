package com.irctc.Demo.dtos;

import java.util.List;

import com.irctc.Demo.models.ResponseStatus;
import com.irctc.Demo.models.Train;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchTrainsResponse {
    List<Train> trains;
    ResponseStatus status;
    String message;

    public void printResponse(){
        System.out.println("Avalible trains for you are : ");

        for(Train t: trains){
            System.out.println("Train no. "+t.getId()+" from "+t.getStartStop().getName()+" to "+t.getEndStop().getName());
        }

    }
}
