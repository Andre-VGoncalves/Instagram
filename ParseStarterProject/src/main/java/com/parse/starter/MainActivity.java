/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      //add dados no Parse
      /*ParseObject pontuacao = new ParseObject("Pontuacao");
      pontuacao.put("nome", "Luiza");
      pontuacao.put("pontos", 7555 );
      pontuacao.saveInBackground(new SaveCallback() {
          @Override
          public void done(ParseException e) {
              if( e == null ){//não temos erros, pois o objeto está nulo
                  Log.i("salvarPontos", "Dados salvos com sucesso");
              }else {
                  Log.i("salvarPontos", "Erro ao salvar os dados");
              }
          }
      });*/


      //Consulta de dados
      /*ParseQuery<ParseObject> consulta = ParseQuery.getQuery("Pontuacao");
      consulta.getInBackground("NVsD8EWQdE", new GetCallback<ParseObject>() {
          @Override
          public void done(ParseObject object, ParseException e) {

              if( e == null ){
                  //Altera a pontuação
                  object.put("pontos", 1150 );
                  object.saveInBackground();

              }else{
                  Log.i("consultaObjeto", "Erro ao consultar objeto" + e.getMessage() );
              }

          }
      });*/

      ParseQuery<ParseObject> filtro = ParseQuery.getQuery("Pontuacao");

      //Aplicando filtros na listagem de objetos
      // pode colocar varios filtros de uma vez

      //campo mais o valor nesse caso maior que 800
      //filtro.whereGreaterThan("pontos", 800);

      //igual ou maior que 800
      //filtro.whereGreaterThanOrEqualTo("pontos", 800);

      //menor que 500
      //filtro.whereLessThan("pontos", 500);

      //termina com
      //filtro.whereEndsWith("nome", "ia");

      //inicia com
      //filtro.whereStartsWith("nome", "Ja");

      //ordem crescente
      //filtro.addAscendingOrder("pontos");

      //ordem decrescene
      //filtro.addDescendingOrder("pontos");

      // o tanto de resultados que quer exibir
      //filtro.setLimit(1);


      //Listar os dados
      filtro.findInBackground(new FindCallback<ParseObject>() {
          @Override
          public void done(List<ParseObject> objects, ParseException e) {

              if( e == null ){//efetuada a listagem sem erros

                  for( ParseObject object : objects ){
                      Log.i("ListarDados", "objetos - Nome: " + object.get("nome") + " ponto: " + object.get("pontos") );
                  }

              }else{//Erro ao listar
                  Log.i("ListarDados", "Erro ao Listar os objetos - " + e.getMessage() );
              }

          }
      });


  }

}
