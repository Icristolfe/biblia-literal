package br.com.bibliaoffline

import android.app.Activity
import android.graphics.Color
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : Activity() {
    private var fileCallback: ValueCallback<Array<Uri>>? = null
    private var bibleWebView: WebView? = null
    private val openFileRequest = 4102

    @Suppress("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.rgb(0, 0, 0)
        window.navigationBarColor = Color.rgb(0, 0, 0)
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = false
            isAppearanceLightNavigationBars = false
        }
        window.decorView.setBackgroundColor(Color.BLACK)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.BLACK)
        }
        val statusBarBand = View(this).apply { setBackgroundColor(Color.BLACK) }
        val web = WebView(this).apply { setBackgroundColor(Color.BLACK) }
        val navigationBarBand = View(this).apply { setBackgroundColor(Color.BLACK) }
        root.addView(statusBarBand, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, 0
        ))
        root.addView(web, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f
        ))
        root.addView(navigationBarBand, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, 0
        ))
        ViewCompat.setOnApplyWindowInsetsListener(root) { _, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            statusBarBand.layoutParams = statusBarBand.layoutParams.apply { height = bars.top }
            navigationBarBand.layoutParams = navigationBarBand.layoutParams.apply { height = bars.bottom }
            insets
        }
        bibleWebView = web
        web.settings.javaScriptEnabled = true
        web.settings.domStorageEnabled = true
        web.settings.allowFileAccess = true
        web.settings.allowContentAccess = true
        web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean =
                request.url.scheme != "file"
        }
        web.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView,
                callback: ValueCallback<Array<Uri>>,
                params: FileChooserParams
            ): Boolean {
                fileCallback?.onReceiveValue(null)
                fileCallback = callback
                val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                    type = "application/json"
                    addCategory(Intent.CATEGORY_OPENABLE)
                }
                startActivityForResult(Intent.createChooser(intent, "Escolher pacote bíblico"), openFileRequest)
                return true
            }
        }
        setContentView(root)
        ViewCompat.requestApplyInsets(root)
        web.loadUrl("file:///android_asset/index.html")
    }

    @Deprecated("Deprecated in Android, retained for broad device compatibility")
    override fun onBackPressed() {
        val web = bibleWebView
        if (web == null) {
            super.onBackPressed()
            return
        }
        web.evaluateJavascript("window.handleAndroidBack ? window.handleAndroidBack() : false") { handled ->
            if (handled != "true") super.onBackPressed()
        }
    }

    @Deprecated("Deprecated in Android, retained for broad device compatibility")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == openFileRequest) {
            fileCallback?.onReceiveValue(
                if (resultCode == RESULT_OK && data?.data != null) arrayOf(data.data!!) else null
            )
            fileCallback = null
        }
    }
}
