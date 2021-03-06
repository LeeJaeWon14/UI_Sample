package com.example.ui_sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.util.Linkify
import android.view.View
import android.widget.Toast
import androidx.core.text.toSpannable
import com.example.ui_sample.databinding.ActivitySpannableBinding
import java.util.regex.Matcher
import java.util.regex.Pattern

class SpannableActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpannableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpannableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            // Spannable
            tvSpannable.text.toSpannable().setSpan(object : ClickableSpan() {
                override fun onClick(p0: View) {
                    Toast.makeText(this@SpannableActivity, "Spannable Click", Toast.LENGTH_SHORT).show()
                }
            }, 0, 9, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
            tvSpannable.movementMethod = LinkMovementMethod.getInstance()

            // Linkify
            val mTransform = Linkify.TransformFilter { match, url -> "" }
            val pattern1 = Pattern.compile("Linkify")

            Linkify.addLinks(tvLinkfy, pattern1, "https://velog.io/@jeep_chief_14", null, mTransform)

//            btnAutoLinkGo.setOnClickListener {
//                tvAutoLink.text = edtInputAutoLink.text.toString()
//            }
        }
    }
}