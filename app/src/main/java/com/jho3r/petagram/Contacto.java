package com.jho3r.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jho3r.petagram.pojo.Config;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Contacto extends AppCompatActivity {

    Button btnEnviar;
    EditText etComentario, etCorreo, etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etComentario = findViewById(R.id.etComentario);
        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
                finish();
            }
        });
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    private void sendEmail(){
        String nombre = etNombre.getText().toString();
        String email = etCorreo.getText().toString();
        String comentario = etComentario.getText().toString();
        String mensaje = nombre + " esta intentando contactar contigo: " +
                "\nTe dejo sus datos: " +
                "\nNombre: " + nombre +
                "\nEmail: " + email +
                "\nMensaje: " + comentario;

        Properties props = new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Config.usuario,Config.contraseña);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Config.usuario));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Config.enviara));
            message.setSubject("Nuevo mensaje de la app Petagram");
            message.setText(mensaje);
            Transport.send(message);

            Toast.makeText(getApplicationContext(),"Mensaje enviado con exito!",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Ah ocurrido un error intentalo mas tarde!",Toast.LENGTH_LONG).show();
            throw new RuntimeException(e);
        }

    }
}