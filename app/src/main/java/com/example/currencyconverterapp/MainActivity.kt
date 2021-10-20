package com.example.currencyconverterapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    private var curencyDetails: Datum? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cur = MyConstant.cur

        var selected: Int = 0

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, cur
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    selected = position
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        btn1.setOnClickListener {

            var sel = et.text.toString()
            var currency: Double = sel.toDouble()

            getCurrency(onResult = {
                curencyDetails = it

                when (selected) {
                    0 -> disp(calc(curencyDetails?.eur?.inr?.toDouble(), currency));
                    1 -> disp(calc(curencyDetails?.eur?.usd?.toDouble(), currency));
                    2 -> disp(calc(curencyDetails?.eur?.aud?.toDouble(), currency));
                    3 -> disp(calc(curencyDetails?.eur?.sar?.toDouble(), currency));
                    4 -> disp(calc(curencyDetails?.eur?.cny?.toDouble(), currency));
                    5 -> disp(calc(curencyDetails?.eur?.jpy?.toDouble(), currency));
                }
            })
        }

    }

    private fun disp(calc: Double) {

        tv2.text = "result " + calc
    }

    private fun calc(i: Double?, sel: Double): Double {
        var s = 0.0
        if (i != null) {
            s = (i * sel)
        }
        return s
    }

    private fun getCurrency(onResult: (Datum?) -> Unit) {
        val apiInterface = MyConstant.apiInterface

        if (apiInterface != null) {
            apiInterface.getCurrency()?.enqueue(object : Callback<Datum> {
                override fun onResponse(
                    call: Call<Datum>,
                    response: Response<Datum>
                ) {
                    onResult(response.body())
                }

                override fun onFailure(call: Call<Datum>, t: Throwable) {
                    onResult(null)
                    Toast.makeText(applicationContext, "" + t.message, Toast.LENGTH_SHORT).show();
                }

            })
        }
    }
}