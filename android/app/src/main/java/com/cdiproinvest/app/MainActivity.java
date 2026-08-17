package com.cdiproinvest.app;
import android.app.Activity; import android.os.Bundle; import android.content.Intent; import android.net.Uri; import android.webkit.*;
public class MainActivity extends Activity {
 private static final String HOME="https://demellogabriel2015-max.github.io/calculadora-cdi-pro/", HOST="demellogabriel2015-max.github.io"; private WebView w;
 @Override public void onCreate(Bundle b){super.onCreate(b); w=new WebView(this);setContentView(w); WebSettings s=w.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);s.setAllowFileAccess(false);s.setSupportZoom(false); w.setWebViewClient(new WebViewClient(){@Override public boolean shouldOverrideUrlLoading(WebView v,WebResourceRequest r){return route(r.getUrl());}@Override public boolean shouldOverrideUrlLoading(WebView v,String u){return route(Uri.parse(u));}});if(b==null)w.loadUrl(HOME);else w.restoreState(b);}
 private boolean route(Uri u){if(u!=null&&(u.getScheme().equalsIgnoreCase("http")||u.getScheme().equalsIgnoreCase("https"))&&HOST.equalsIgnoreCase(u.getHost()))return false;try{startActivity(new Intent(Intent.ACTION_VIEW,u));}catch(Exception e){}return true;}
 @Override public void onBackPressed(){if(w.canGoBack())w.goBack();else super.onBackPressed();} @Override protected void onSaveInstanceState(Bundle b){w.saveState(b);super.onSaveInstanceState(b);} @Override protected void onDestroy(){w.destroy();super.onDestroy();}
}
