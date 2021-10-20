package com.example.currencyconverterapp

import com.google.gson.annotations.SerializedName

class Datum {

    @SerializedName("date")
    var date: String? = null

    @SerializedName("eur")
    var eur: Cur? = null

    class Cur {

        @SerializedName("inr")
        var inr: String? = null

        @SerializedName("usd")
        var usd: String? = null

        @SerializedName("aud")
        var aud: String? = null

        @SerializedName("sar")
        var sar: String? = null

        @SerializedName("cny")
        var cny: String? = null

        @SerializedName("jpy")
        var jpy: String? = null

    }
}
//"ada": 0.516597,
//"aed": 4.263673,
//"afn": 103.90061,
//"all": 122.062781,
//"amd": 563.378784,
//"ang": 2.083219,
//"aoa": 695.343317,
//"ars": 114.448748,
//"aud": 1.595534,
//"awg": 2.089512,
//"azn": 1.975149,
//"bam": 1.959772,
//"bbd": 2.343313,
//"bch": 0.002044,
//"bdt": 99.415665,
//"bgn": 1.957972,
//"bhd": 0.437675,
//"bif": 2317.037071,
//"bmd": 1.16084,
//"bnb": 0.002716,
//"bnd": 1.576116,