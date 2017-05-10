package com.example.android.personas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by android on 04/04/2017.
 */

public class Datos {
    //private static ArrayList<Persona> personas = new ArrayList<>();

    /*public static void guardar(Persona p){
        personas.add(p);
    }*/

    public static ArrayList<Persona> traerPersonas(Context contexto) {
        SQLiteDatabase db;
        String sql;
        String foto;
        String nombre;
        String apellido;
        int edad;
        String pasatiempo;

        ArrayList<Persona> personas =  new ArrayList();

        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBPersonas",null,1);
        db = aux.getReadableDatabase();

        sql = "Select foto, nombre, apellido, edad, pasatiempo from Personas";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                foto = c.getString(0);
                nombre = c.getString(1);
                apellido = c.getString(2);
                edad = Integer.parseInt(c.getString(3));
                pasatiempo = c.getString(4);

                Persona p = new Persona(foto,nombre,apellido,edad,pasatiempo);
                personas.add(p);
            }while(c.moveToNext());
        }

        db.close();

        return personas;
    }

    public static Persona buscarPersonas(Context contexto, String nomb) {
        SQLiteDatabase db;
        String sql;
        String foto;
        String nombre;
        String apellido;
        int edad;
        String pasatiempo;
        Persona p=null;

        ArrayList<Persona> personas =  new ArrayList();

        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBPersonas",null,1);
        db = aux.getReadableDatabase();

        sql = "Select foto, nombre, apellido, edad, pasatiempo from Personas where nombre='"+nomb+"'";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                foto = c.getString(0);
                nombre = c.getString(1);
                apellido = c.getString(2);
                edad = Integer.parseInt(c.getString(3));
                pasatiempo = c.getString(4);

                p = new Persona(foto,nombre,apellido,edad,pasatiempo);

            }while(c.moveToNext());
        }

        db.close();

        return p;
    }
}
