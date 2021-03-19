package dk.youtec.drchannels.logic

import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

actual fun decryptUri(input: String): String {
    if (input.isNotBlank() && input.length > 10) {
        val n = input.substring(2, 10).toInt(16)
        val a = input.substring(10 + n)

        val data = input.substring(10, 10 + n).hexStringToByteArray()
        val key = hash("SHA-256", "$a:sRBzYNXBzkKgnjj8pGtkACch")
        val iv = a.hexStringToByteArray()

        return decryptAes(data, key, iv)
    }
    return ""
}

private fun decryptAes(
        encrypted: ByteArray,
        key: ByteArray,
        iv: ByteArray
): String {
    try {
        val skeySpec = SecretKeySpec(key, "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, IvParameterSpec(iv))
        val original = cipher.doFinal(encrypted)

        return String(original)
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
    return ""
}

private fun hash(
        type: String,
        input: String
): ByteArray = MessageDigest
        .getInstance(type)
        .digest(input.toByteArray())

fun String.hexStringToByteArray() = ByteArray(this.length / 2) {
    substring(it * 2, it * 2 + 2).toInt(16).toByte()
}