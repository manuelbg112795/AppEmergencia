package com.example.adrian.appe;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FormularioGeneral extends AppCompatActivity {


    Button btnIngresa;
    Button btnVerificado;
    Button btnSiguiente;

    Spinner spinUsuarios;

    CheckBox chkFemenino;
    CheckBox chkMasculino;

    EditText txtMaterno;
    EditText txtPaterno;
    EditText txtNombre;
    EditText txtEdad;
    EditText txtOcupacion;
    EditText txtNacionalidad;
    EditText txtID;
    EditText txtFotoID; //Reemplazar posteriormente con insertar imagen
    EditText txtCalle;
    EditText txtNumExterior;
    EditText txtNumInterior;
    EditText txtColonia;
    EditText txtCP;
    EditText txtDelegacion;
    EditText txtEstado;
    EditText txtFotoDomicilio;  //Reemplazar con insertar imagen
    EditText txtTelefono;
    EditText txtCelular;
    EditText txtCorreo;
    EditText txtRefNombre;
    EditText txtRefTelefono;
    EditText txtRefCorreo;

    String Paterno;
    String Materno;
    String Nombre;
    int Edad;
    String Ocupacion;
    String Sexo;
    String Nacionalidad;
    String ID;
    String FotoID; //Reemplazar posteriormente con insertar imagen
    String Actividad;
    String Calle;
    int NumExterior;
    int NumInterior;
    String Colonia;
    int CP;
    String Delegacion;
    String Estado;
    String FotoDomicilio;  //Reemplazar con insertar imagen
    int Telefono;
    int Celular;
    String Correo;
    String RefNombre;
    int RefTelefono;
    String RefCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_general);

        Instanciar();

        btnIngresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormularioGeneral.this, Ingresa.class);
                startActivity(intent);

            }
        });

        btnVerificado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormularioGeneral.this, Inicio.class);
                startActivity(intent);

            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID="prueba";//Momentaneo hasta activar AltaSQL
                //AltaSQL();
                Intent siguiente = new Intent(FormularioGeneral.this, FormularioGeneral2.class);
                siguiente.putExtra("ID",ID);        //Pasa a la siguiente actividad el valor de ID para nueva tabla
                siguiente.putExtra("Actividad",Actividad);  //Para saber que desplegar y que no.
                startActivity(siguiente);

            }
        });

        String[] Tipousuarios = {"Elige una opción...", "Recopilar información web", "Líder de brigadistas", "Líder de transporte",
                "Líder de paramédicos", "Verificar información en zona de desastre", "Verificar información en albergue",
                "Verificar información en centro de acopio"};
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Tipousuarios) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = null;

                // If this is the initial dummy entry, make it hidden
                if (position == 0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    v = tv;
                } else {
                    // Pass convertView as null to prevent reuse of special case views
                    v = super.getDropDownView(position, null, parent);
                }

                // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                parent.setVerticalScrollBarEnabled(false);
                return v;
            }
        };

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinUsuarios.setAdapter(dataAdapter);

       spinUsuarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        Actividad="Usuario Web";
                        //Intent intent1 = new Intent(FormularioGeneral.this, Sweb.class);
                        //startActivity(intent1);
                        break;
                    case 2:
                        Actividad="Líder brigadista";
                        //Intent intent2 = new Intent(FormularioGeneral.this, Sbrigadista.class);
                        //startActivity(intent2);
                        break;
                    case 3:
                        Actividad="Líder transporte";
                        //Intent intent3 = new Intent(FormularioGeneral.this, Stransporte.class);
                        //startActivity(intent3);
                        break;
                    case 4:
                        Actividad="Líder paramédicos";
                        //Intent intent4 = new Intent(FormularioGeneral.this, Sparamedico.class);
                        //startActivity(intent4);
                        break;
                    case 5:
                        Actividad="Información desastre";
                        //Intent intent5 = new Intent(FormularioGeneral.this, Sdesastre.class);
                        //startActivity(intent5);
                        break;
                    case 6:
                        Actividad="Información albergue";
                        //Intent intent6 = new Intent(FormularioGeneral.this, Salbergue.class);
                        //startActivity(intent6);
                        break;
                    case 7:
                        Actividad="Información acopio";
                        //Intent intent7 = new Intent(FormularioGeneral.this, Sacopio.class);
                        //startActivity(intent7);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void Femenino(View Checkbox){
        chkMasculino.setChecked(false);
        chkFemenino.setChecked(true);
        Sexo="Femenino";
    }

    public void Masculino(View Checkbox){
        chkMasculino.setChecked(true);
        chkFemenino.setChecked(false);
        Sexo="Masculino";
    }

    private void Instanciar(){

        btnIngresa = (Button) findViewById(R.id.btn_Ingresa);
        btnVerificado = (Button) findViewById(R.id.btn_Verificado);
        btnSiguiente=(Button) findViewById(R.id.btn_Siguiente);

        spinUsuarios =(Spinner)findViewById(R.id.spin_Usuarios);

        chkFemenino = (CheckBox) findViewById(R.id.chk_Femenino);
        chkMasculino = (CheckBox) findViewById(R.id.chk_Masculino);

        txtMaterno=(EditText) findViewById(R.id.txt_Amaterno);
        txtPaterno=(EditText) findViewById(R.id.txt_Apaterno);
        txtNombre=(EditText) findViewById(R.id.txt_Nombre);
        txtEdad=(EditText)findViewById(R.id.txt_Edad);
        txtOcupacion=(EditText) findViewById(R.id.txt_Ocupacion);
        txtNacionalidad=(EditText) findViewById(R.id.txt_Nacionalidad);
        txtID=(EditText) findViewById(R.id.txt_Id);
        txtFotoID=(EditText)findViewById(R.id.txt_FotoID);  //Reemplazar con imagen
        txtCalle=(EditText) findViewById(R.id.txt_Calle);
        txtNumExterior=(EditText) findViewById(R.id.txt_Numero_exterior);
        txtNumInterior=(EditText) findViewById(R.id.txt_Numero_interior);
        txtColonia=(EditText)findViewById(R.id.txt_Colonia);
        txtCP=(EditText) findViewById(R.id.txt_Codigo_postal);
        txtDelegacion=(EditText) findViewById(R.id.txt_Delegacion);
        txtEstado=(EditText) findViewById(R.id.txt_Estado);
        txtFotoDomicilio=(EditText)findViewById(R.id.txt_FotoDomicilio);    //Reemplazar con imagen
        txtTelefono=(EditText)findViewById(R.id.txt_Telefono_local);
        txtCelular=(EditText) findViewById(R.id.txt_Celular);
        txtCorreo=(EditText) findViewById(R.id.txt_Correo_electronico);
        txtRefNombre=(EditText) findViewById(R.id.txt_Nombre_p_referencia);
        txtRefTelefono=(EditText)findViewById(R.id.txt_Telefono_p_referencia);
        txtRefCorreo=(EditText) findViewById(R.id.txt_Correo_p_electronico);

    }

    private void ExtraerData(){
         Materno=txtMaterno.getText().toString();
         Paterno=txtPaterno.getText().toString();
         Nombre=txtNombre.getText().toString();
         Edad=Integer.parseInt(txtEdad.getText().toString());
         Ocupacion=txtOcupacion.getText().toString();
         Nacionalidad=txtNacionalidad.getText().toString();
         ID=txtID.toString();
         FotoID=txtFotoID.getText().toString(); //Reemplazar posteriormente con insertar imagen
         Calle=txtCalle.getText().toString();
         NumExterior=Integer.parseInt(txtNumExterior.toString());
         NumInterior=Integer.parseInt(txtNumInterior.toString());
         Colonia=txtColonia.getText().toString();
         CP=Integer.parseInt(txtCP.toString());
         Delegacion=txtDelegacion.getText().toString();
         Estado=txtEstado.getText().toString();
         FotoDomicilio=txtFotoDomicilio.getText().toString();  //Reemplazar con insertar imagen
         Telefono=Integer.parseInt(txtTelefono.toString());
         Celular=Integer.parseInt(txtCelular.toString());
         Correo=txtCorreo.getText().toString();
         RefNombre=txtRefNombre.getText().toString();
         RefTelefono=Integer.parseInt(txtRefTelefono.toString());
         RefCorreo=txtRefCorreo.getText().toString();
    }

    private void AltaSQL(){
        AuxSQLFormGen auxSQL = new AuxSQLFormGen(this,"FormularioGeneral",null,1);
        SQLiteDatabase bd = auxSQL.getWritableDatabase();
        ExtraerData();

        ContentValues registro = new ContentValues();

        registro.put("ID",ID);
        registro.put("APaterno",Paterno);
        registro.put("AMaterno",Materno);
        registro.put("Nombre",Nombre);
        registro.put("Edad",Edad);
        registro.put("Ocupacion",Ocupacion);
        registro.put("Sexo",Sexo);
        registro.put("Nacionalidad",Nacionalidad);
        registro.put("Identificacion",FotoID);  //Reemplazar por imagen
        registro.put("Calle",Calle);
        registro.put("NumExterior",NumExterior);
        registro.put("NumInterior",NumInterior);
        registro.put("Colonia",Colonia);
        registro.put("CP",CP);
        registro.put("Delegacion",Delegacion);
        registro.put("Estado",Estado);
        registro.put("Domicilio",FotoDomicilio);
        registro.put("Telefono",Telefono);
        registro.put("Celular",Celular);
        registro.put("Correo",Correo);
        registro.put("RefNombre",RefNombre);
        registro.put("RefTelefono",RefTelefono);
        registro.put("RefCorreo",RefCorreo);
        registro.put("Actividad",Actividad);

        bd.insert("FormGen1", null, registro);
        bd.close();
        /*
        et_precio.setText("");
        et_codigo.setText("");
        et_descripcion.setText("");*/

        Toast.makeText(this,"Se han ingresado los datos",Toast.LENGTH_SHORT).show();
    }

   }

