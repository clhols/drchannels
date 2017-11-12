package dk.youtec.zapr.util

import org.json.JSONArray
import org.json.JSONObject

//Give the JSONArray an iterator
operator fun JSONArray.iterator(): Iterator<JSONObject>
        = (0 until length()).asSequence().map { get(it) as JSONObject }.iterator()

fun JSONArray.toIntArray(): IntArray {
    val array: IntArray = IntArray(length(), { i -> getInt(i) })
    return array
}