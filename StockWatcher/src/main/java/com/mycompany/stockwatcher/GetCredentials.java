/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

/**
 *
 * @author DIEGO
 */

//Troque o usuario e senha para o do seu banco
public class GetCredentials {
    private String user;
    private String password;

    public GetCredentials() {
        user = "root";
        password = "123";
    }

    
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
    
}
