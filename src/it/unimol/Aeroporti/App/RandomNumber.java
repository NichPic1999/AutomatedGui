package it.unimol.Aeroporti.App;

import java.util.Random;

public class RandomNumber {

    public String random_number(){
        Random rand=new Random();
        String res="";
        for (int i=0;i<10;i++){
            res+=String.valueOf(rand.nextInt(9));
        }
        return res;
    }

    }
