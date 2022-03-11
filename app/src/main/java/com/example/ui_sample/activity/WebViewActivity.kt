package com.example.ui_sample.activity

import android.os.Bundle
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_sample.MyWebClient
import com.example.ui_sample.R
import com.example.ui_sample.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    companion object {
        const val BASE_URL = "https://velog.io/@jeep_chief_14"
        const val NAVER = "https://www.naver.com"
    }
    private lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        window.statusBarColor = getColor(R.color.light_gray)
        binding.apply {
            wvWebView.apply {
                webViewClient = MyWebClient(binding)
                settings.apply {
                    javaScriptEnabled = true
                    loadWithOverviewMode = true
                    useWideViewPort = true
                    cacheMode = WebSettings.LOAD_DEFAULT
                }
                loadUrl(NAVER)
            }

            slWebLayout.apply {
                setOnRefreshListener {
                    isRefreshing = false
                    wvWebView.reload()
                }
            }

            ivNext.setOnClickListener { wvWebView.goForward() }
            ivPrev.setOnClickListener { wvWebView.goBack() }
            ivHome.setOnClickListener { wvWebView.loadUrl(BASE_URL) }

            url.text = NAVER
        }
    }

    override fun onBackPressed() {
        binding.run {
            if(wvWebView.canGoBack()) wvWebView.goBack()
            else super.onBackPressed()
        }
    }
}