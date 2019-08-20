/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 
 */
public class Procedure {
    
    private String name;
    private StringBuilder builder;
        
    public Procedure(String name){
        this.name = name;
        this.builder = new StringBuilder();
        builder.append(name);
        builder.append(" (");
    }
    
    public Procedure noArguments(){
        builder.append(",");
        return this;
    }
    
    public Procedure addValue(String value){
        builder.append("\"");
        builder.append(value);
        builder.append("\"");
        builder.append(",");
        return this;
    }
    
    public Procedure addValue(int value){
        builder.append(value);
        builder.append(",");
        return this;
    }
    
    public Procedure addValue(double value){
        builder.append(value);
        builder.append(",");
        return this;
    }
    
    public Procedure addValue(LocalDate value){
        builder.append("'");
        builder.append(value.format(DateTimeFormatter.ISO_LOCAL_DATE)); 
        builder.append("'");
        builder.append(",");
        return this;
    }
    
    public Procedure addValue(LocalTime value){
        builder.append("'");
        builder.append(value.format(DateTimeFormatter.ISO_LOCAL_TIME)); 
        builder.append("'");
        builder.append(",");
        return this;
    }
    
    public Procedure addValue(LocalDateTime value){
        builder.append("'");
        builder.append(value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); 
        builder.append("'");
        builder.append(",");
        return this;
    }
    
    public String getStringForm(){
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append(")");
        return builder.toString();
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
   
}
