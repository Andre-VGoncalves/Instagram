/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.starter.R;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_main);

    /************* Cadastro de Usuario************/
      /*ParseUser usuario = new ParseUser();
      usuario.setUsername("andrevieira");
      usuario.setPassword("123456");
      usuario.setEmail("andre@gmail.com");

      //Cadastrar Usuario
      usuario.signUpInBackground(new SignUpCallback() {
          @Override
          public void done(ParseException e) {
              if (e == null){
                  Log.i("cadastrousuario", "Sucesso ao cadastrar o usuario");
              }else{
                  Log.i("cadastrousuario", "Erro ao cadastrar o usuario" + e.getMessage());
              }
          }
      });*/
      //deslogar usuario
      //ParseUser.logOut();

      /************* Verificar se esta Logado ************/
      /*
      if(ParseUser.getCurrentUser() != null){//logado
          Log.i("session", "Logado");
      }else{
          Log.i("session", "Deslogado");
      }*/

      //Realizar o Login
      ParseUser.logInInBackground("andrevieira", "123456", new LogInCallback() {
          @Override
          public void done(ParseUser user, ParseException e) {
              if (e == null){
                  Log.i("Login", "Sucesso ao fazer o login");
              }else{
                  Log.i("Login", "Erro ao fazer o login" + e.getMessage());
              }
          }
      });

  }

}
