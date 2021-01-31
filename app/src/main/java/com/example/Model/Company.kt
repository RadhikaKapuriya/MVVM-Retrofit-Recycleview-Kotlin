package com.example.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Company {
    @SerializedName("name")
    @Expose
    internal var name: String = ""

    @SerializedName("catchPhrase")
    @Expose
    private var catchPhrase: String? = null

    @SerializedName("bs")
    @Expose
    private var bs: String? = null
    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getCatchPhrase(): String? {
        return catchPhrase
    }

    fun setCatchPhrase(catchPhrase: String?) {
        this.catchPhrase = catchPhrase
    }

    fun getBs(): String? {
        return bs
    }

    fun setBs(bs: String?) {
        this.bs = bs
    }
}