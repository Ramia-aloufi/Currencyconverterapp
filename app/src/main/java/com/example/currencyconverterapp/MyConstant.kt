package com.example.currencyconverterapp

object MyConstant{
    const val url = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/"
     val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
    val cur = arrayListOf("inr", "usd", "aud", "sar", "cny", "jpy")
}