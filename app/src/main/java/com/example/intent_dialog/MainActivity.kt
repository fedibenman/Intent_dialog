package com.example.intent_dialog

import android.app.AlertDialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar



lateinit var nomEditText: EditText
lateinit var prenomEditText: EditText
lateinit var emailEditText: EditText
lateinit var btn: Button
lateinit var webView: WebView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nomEditText = findViewById(R.id.nom)
        prenomEditText = findViewById(R.id.prenom)
        emailEditText = findViewById(R.id.mail)
        btn = findViewById(R.id.btn)
        webView = findViewById(R.id.webview)

        //Instanciation WebView

        webView.webViewClient = WebViewClient()
        // ProgressBar disparait à la fin du chargement de la page
        // chargement de la page à partir de son URL
        webView.loadUrl("https://www.google.com/")
        // autoriser les scripts javascripts
        webView.settings.javaScriptEnabled = true
        // accepter le zoom sur la page
        webView.settings.setSupportZoom(true)


        btn.setOnClickListener{
            valider(null)
        }
    }

    fun valider(v: View?) {
        if (nomEditText.getText().length === 0 || prenomEditText.getText().length === 0 || emailEditText.getText().length === 0) {
             val ad: AlertDialog.Builder
              ad = AlertDialog.Builder(this)
              ad.setMessage("Les champs ne doivent pas être vide")
              ad.setTitle("Error")
              ad.setIcon(android.R.drawable.btn_dialog)
              ad.setPositiveButton(
                  "yes"
              ) { dialogInterface, i ->run{
                  val progressDialog = ProgressDialog(this@MainActivity)
                  progressDialog.setTitle("Kotlin Progress Dialog")
                  progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
                  progressDialog.setMessage("Downloading music, please wait")
                  progressDialog.setIndeterminate(true)
                  progressDialog.setProgress(0)
                  progressDialog.show()
                  finish()
              }  }

              val a = ad.create()
              a.show()





        }
        Toast.makeText(this, "connextion etablis", Toast.LENGTH_LONG).show();
        var mylayout : LinearLayout=findViewById(R.id.mylayout)
        val snack = Snackbar.make(mylayout,"Connexion etablis ",Snackbar.LENGTH_LONG)
        snack.show()
    }


}